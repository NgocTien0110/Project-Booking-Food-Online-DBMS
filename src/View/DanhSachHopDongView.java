
package View;

import DAO.ChiNhanhDAO;
import DAO.DoiTacDAO;
import DAO.HopDongDAO;
import DAO.TaiKhoanDAO;
import Model.DoiTacModel;
import Model.HopDongModel;
import Model.TaiKhoanModel;
import database.JDBCUtil;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.util.List;

public class DanhSachHopDongView extends JFrame implements ActionListener {
    private JLabel labelHeader;
    private JTextField inputSearch;
    private JButton buttonSearch;
    private JTextField inputRepreName;
    private JTextField inputParterName;
    private JTextField inputStatusContract;
    private JTextField inputTimeRemain;
    private JTextField inputSignDay;
    private DefaultTableModel dtmContract;
    private JTable tableContractList;
    private JButton buttonBack;
    private JButton buttonViewDetails;
    private String MaTaiKhoan;

    public DanhSachHopDongView(String maTaiKhoan) {
        MaTaiKhoan = maTaiKhoan;
        JFrame.setDefaultLookAndFeelDecorated(true);
        this.setTitle("Danh sách hợp đồng");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);

        JPanel jPanelHeader = new JPanel();
        jPanelHeader.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        jPanelHeader.setLayout(new GridLayout(1, 2, 20, 20));
        labelHeader = new JLabel("Danh sách hợp đồng");
        labelHeader.setFont(new Font("Arial", Font.BOLD, 35));
        labelHeader.setForeground(new Color(1, 119, 216));

        JPanel jPanelSearch = new JPanel();
        jPanelSearch.setLayout(new GridLayout(1, 2, 0, 0));
        inputSearch = new JTextField();
        buttonSearch = new JButton("Tìm kiếm");
        jPanelSearch.add(inputSearch);
        jPanelSearch.add(buttonSearch);

        jPanelHeader.add(labelHeader);
        jPanelHeader.add(jPanelSearch);

        JPanel jPanelBody = new JPanel(new BorderLayout());
        jPanelBody.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JPanel jPanelBodyTop = new JPanel(new GridLayout(3, 2, 60, 5));
        jPanelBodyTop.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        JPanel jPanelRepreName = new JPanel(new GridLayout(1, 2, 0, 0));
        JLabel labelRepreName = new JLabel("Tên người đại diện");
        inputRepreName = new JTextField();
        jPanelRepreName.add(labelRepreName);
        jPanelRepreName.add(inputRepreName);

        JPanel jPanelRemainTime = new JPanel(new GridLayout(1, 2, 0, 0));
        JLabel labelRemainTime = new JLabel("Thời gian hiệu lực(tháng)");
        inputTimeRemain = new JTextField();
        jPanelRemainTime.add(labelRemainTime);
        jPanelRemainTime.add(inputTimeRemain);

        JPanel jPanelParterName = new JPanel(new GridLayout(1, 2, 0, 0));
        JLabel labelParterName = new JLabel("Tên đối tác");
        inputParterName = new JTextField();
        jPanelParterName.add(labelParterName);
        jPanelParterName.add(inputParterName);

        JPanel jPanelStatusContract = new JPanel(new GridLayout(1, 2, 0, 0));
        JLabel labelStatusContract = new JLabel("Tình trạng hợp đồng");
        inputStatusContract = new JTextField();
        jPanelStatusContract.add(labelStatusContract);
        jPanelStatusContract.add(inputStatusContract);

        JPanel jPanelSignDay = new JPanel(new GridLayout(1, 2, 0, 0));
        JLabel labelSignDay = new JLabel("Ngày ký");
        inputSignDay = new JTextField();
        jPanelSignDay.add(labelSignDay);
        jPanelSignDay.add(inputSignDay);

        jPanelBodyTop.add(jPanelRepreName);
        jPanelBodyTop.add(jPanelRemainTime);
        jPanelBodyTop.add(jPanelParterName);
        jPanelBodyTop.add(jPanelStatusContract);
        jPanelBodyTop.add(jPanelSignDay);


        dtmContract = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        dtmContract.addColumn("ID hợp đồng");
        dtmContract.addColumn("Tên đối tác");
        dtmContract.addColumn("Tên người đại diện");
        dtmContract.addColumn("Thời gian hiệu lực(tháng)");
        dtmContract.addColumn("Ngày ký");
        dtmContract.addColumn("Tình trạng hợp đồng");

        loadDataSw();
        tableContractList = new JTable(dtmContract);

        tableContractList.setRowHeight(30);
        tableContractList.setFont(new Font("Arial", Font.PLAIN, 15));
        tableContractList.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
        tableContractList.getTableHeader().setForeground(new Color(1, 119, 216));
        tableContractList.getTableHeader().setBackground(new Color(255, 255, 255));
        tableContractList.getTableHeader().setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        tableContractList.setShowGrid(false);
        tableContractList.setShowVerticalLines(true);
        tableContractList.setShowHorizontalLines(true);
        tableContractList.setGridColor(new Color(1, 119, 216));
        tableContractList.setSelectionBackground(new Color(1, 119, 216));
        tableContractList.setSelectionForeground(new Color(255, 255, 255));
        tableContractList.setRowSelectionAllowed(true);
        tableContractList.setColumnSelectionAllowed(false);
        tableContractList.setCellSelectionEnabled(false);
        tableContractList.setDragEnabled(false);
        tableContractList.setFillsViewportHeight(true);
        tableContractList.setPreferredScrollableViewportSize(new Dimension(500, 300));
        tableContractList.setFillsViewportHeight(true);
        tableContractList.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableContractList.setRowSelectionAllowed(true);
        tableContractList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableContractList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = tableContractList.getSelectedRow();
                if (row >= 0) {
                    inputRepreName.setText(tableContractList.getValueAt(row, 2).toString());
                    inputTimeRemain.setText(tableContractList.getValueAt(row, 3).toString());
                    inputParterName.setText(tableContractList.getValueAt(row, 1).toString());
                    inputStatusContract.setText(tableContractList.getValueAt(row, 5).toString());
                    inputSignDay.setText(tableContractList.getValueAt(row, 4).toString());
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(tableContractList);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        scrollPane.getViewport().setBackground(new Color(255, 255, 255));
        scrollPane.getViewport().setOpaque(true);

        JPanel jPanelBodyBottom = new JPanel(new GridLayout(1, 2, 150, 0));
        jPanelBodyBottom.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        buttonViewDetails = new JButton("Xem chi tiết");
        buttonViewDetails.addActionListener(this);
        buttonBack = new JButton("Quay lại");
        buttonBack.addActionListener(this);

        jPanelBodyBottom.add(buttonBack);
        jPanelBodyBottom.add(buttonViewDetails);

        jPanelBody.add(jPanelBodyTop, BorderLayout.NORTH);
        jPanelBody.add(scrollPane, BorderLayout.CENTER);
        jPanelBody.add(jPanelBodyBottom, BorderLayout.SOUTH);


        this.add(jPanelHeader, BorderLayout.NORTH);
        this.add(jPanelBody, BorderLayout.CENTER);


        this.setVisible(true);

    }

    public void loadDataSw() { //Hàm load data slang word mới vào data table
        dtmContract.setRowCount(0);
        try {
            //Bước 1: Tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            //Bước 2: Tạo ra đối tượng statement
            Statement st = con.createStatement();

            //Bước 3: Thực thi câu lệnh SQL
            String sql = "SELECT * FROM HopDong, TaiKhoan, DoiTac WHERE HopDong.MaDoiTac = DoiTac.MaDoiTac AND HopDong.MaTaiKhoanDD = TaiKhoan.MaTaiKhoan";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String MaHopDong = rs.getString("MaHopDong");
                Date NgayKi = rs.getDate("NgayKi");
                int ThoiGianHieuLuc = rs.getInt("ThoiGianHieuLuc");
                String TenDaiDien = rs.getString("TenTaiKhoan");
                String TenDoiTac = rs.getString("TenDoiTac");
                int thoiGianHieuLucTemp;
                String statusContract;
                if (ThoiGianHieuLuc < 0) {
                    thoiGianHieuLucTemp = 0;
                    statusContract = "Chưa duyệt";
                } else {
                    thoiGianHieuLucTemp = ThoiGianHieuLuc;
                    statusContract = "Đã duyệt";
                }
                Vector<String> vec = new Vector<>();
                vec.add(MaHopDong);
                vec.add(TenDoiTac);
                vec.add(TenDaiDien);
                vec.add(String.valueOf(thoiGianHieuLucTemp));
                vec.add(String.valueOf(NgayKi));
                vec.add(statusContract);
                dtmContract.addRow(vec);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String acStr = e.getActionCommand();
        if (acStr.equals("Quay lại")) {
            new MenuNhanVien(MaTaiKhoan);
            this.dispose();
        }
        else if (acStr.equals("Xem chi tiết")) {
            if(!tableContractList.getSelectionModel().isSelectionEmpty()) { //Đang lựa chọn
                DefaultTableModel model = (DefaultTableModel) tableContractList.getModel();

                int selectedRowIndex = tableContractList.getSelectedRow();
                String MaHopDong = model.getValueAt(selectedRowIndex, 0).toString();
                System.out.println(MaHopDong);
                new UpdateInfoContractView(MaTaiKhoan, MaHopDong);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn hợp đồng để xem chi tiết",
                        "Thông báo",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}