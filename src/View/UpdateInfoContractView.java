package View;

import DAO.HopDongDAO;
import DAO.TaiKhoanDAO;
import Model.HopDongModel;
import Model.TaiKhoanModel;
import StoredProcedure.ContractProcedure;
import database.JDBCUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

public class UpdateInfoContractView extends JFrame implements ActionListener {
    private JLabel labelHeader;
    private JTextField inputRepreName;
    private JTextField inputParterName;
    private JTextField inputCommisPercent;
    private JTextField inputCommisFeeMonthly;
    private JTextField inputSignDay;
    private JTextField inputTimeRemain;
    private JTextField inputStaffName;
    private JTextField inputNoti;
    private String MaTaiKhoan;
    private String MaHopDong;
    private int thoiGianHL;
    private boolean daDuyet;
    private JComboBox<String> inputStatusContract;

    public UpdateInfoContractView(String maTaiKhoan, String maHopDong) {
        MaTaiKhoan = maTaiKhoan;
        MaHopDong = maHopDong;
        JFrame.setDefaultLookAndFeelDecorated(true);
        this.setTitle("Cập nhật thông tin hợp đồng");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);

        Font fontHeaderAndFooter = new Font("Arial", Font.BOLD, 35);
        Font fontBody = new Font("Arial", Font.BOLD, 16);

        JPanel jPanelHeader = new JPanel();
        labelHeader = new JLabel("Thông tin hợp đồng");
        labelHeader.setFont(fontHeaderAndFooter);
        labelHeader.setForeground(new Color(1, 119, 216));

        jPanelHeader.add(labelHeader);

        try {
            //Bước 1: Tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            //Bước 2: Tạo ra đối tượng statement
            String sql = "SELECT * FROM HopDong hd, TaiKhoan tk, DoiTac dt where hd.MaHopDong=? and hd.MaTaiKhoanDD=tk.MaTaiKhoan and hd.MaDoiTac=dt.MaDoiTac";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, MaHopDong);
            //Bước 3: Thực thi câu lệnh SQL
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String tenDaiDien = rs.getString("TenTaiKhoan");
                String tenDoiTac = rs.getString("TenDoiTac");
                Date ngayKy = rs.getDate("NgayKi");
                String maNVPhuTrach = rs.getString("MaTaiKhoanNV");
                float phanTramHH = rs.getFloat("PhamTramHoaHong");
                int thoiGianHLTemp = rs.getInt("ThoiGianHieuLuc");
                double phiHH = rs.getDouble("PhiHoaHong");

                if (thoiGianHLTemp < 0) {
                    thoiGianHL = 0;
                    daDuyet = false;
                } else {
                    thoiGianHL = thoiGianHLTemp;
                    daDuyet = true;
                }
                JPanel jPanelBody = new JPanel(new GridLayout(5, 2, 40, 20));

                JLabel labelRepre = new JLabel("Tên người đại diện");
                labelRepre.setFont(fontBody);
                labelRepre.setForeground(new Color(39, 167, 239));

                JPanel panelRepreName = new JPanel(new GridLayout(2, 1, 5, 0));

                inputRepreName = new JTextField(50);
                inputRepreName.setText(tenDaiDien);
                panelRepreName.add(labelRepre);
                panelRepreName.add(inputRepreName);

                JLabel labelParterName = new JLabel("Tên đối tác");
                labelParterName.setFont(fontBody);
                labelParterName.setForeground(new Color(39, 167, 239));

                JPanel panelParterName = new JPanel(new GridLayout(2, 1, 5, 0));
                inputParterName = new JTextField(50);
                inputParterName.setText(tenDoiTac);
                panelParterName.add(labelParterName);
                panelParterName.add(inputParterName);

                JLabel labelCommisPercent = new JLabel("Phần trăm hoa hồng");
                labelCommisPercent.setFont(fontBody);
                labelCommisPercent.setForeground(new Color(39, 167, 239));

                JPanel panelCommisPercent = new JPanel(new GridLayout(2, 1, 5, 0));
                inputCommisPercent = new JTextField(50);
                inputCommisPercent.setText(String.valueOf(phanTramHH));
                panelCommisPercent.add(labelCommisPercent);
                panelCommisPercent.add(inputCommisPercent);

                JLabel labelCommisFee = new JLabel("Phí hoa hồng tháng");
                labelCommisFee.setFont(fontBody);
                labelCommisFee.setForeground(new Color(39, 167, 239));

                JPanel panelCommisFee = new JPanel(new GridLayout(2, 1, 5, 0));
                inputCommisFeeMonthly = new JTextField(50);
                inputCommisFeeMonthly.setText(String.valueOf(phiHH));
                panelCommisFee.add(labelCommisFee);
                panelCommisFee.add(inputCommisFeeMonthly);

                JLabel labelSignDay = new JLabel("Ngày ký");
                labelSignDay.setFont(fontBody);
                labelSignDay.setForeground(new Color(39, 167, 239));

                JPanel panelSignDay = new JPanel(new GridLayout(2, 1, 5, 0));
                inputSignDay = new JTextField(50);
                inputSignDay.setText(String.valueOf(ngayKy));
                panelSignDay.add(labelSignDay);
                panelSignDay.add(inputSignDay);

                JLabel labelRemain = new JLabel("Thời gian hiệu lực(tháng)");
                labelRemain.setFont(fontBody);
                labelRemain.setForeground(new Color(39, 167, 239));

                JPanel panelTimeRemain = new JPanel(new GridLayout(2, 1, 5, 0));
                inputTimeRemain = new JTextField(50);
                inputTimeRemain.setText(String.valueOf(thoiGianHL));
                panelTimeRemain.add(labelRemain);
                panelTimeRemain.add(inputTimeRemain);

                JLabel labelStaffName = new JLabel("Mã nhân viên phụ trách");
                labelStaffName.setFont(fontBody);
                labelStaffName.setForeground(new Color(39, 167, 239));

                JPanel panelStaffName = new JPanel(new GridLayout(2, 1, 5, 0));
                inputStaffName = new JTextField(50);
                inputStaffName.setText(maNVPhuTrach);
                panelStaffName.add(labelStaffName);
                panelStaffName.add(inputStaffName);

                JLabel labelNoti = new JLabel("Thông báo");
                labelNoti.setFont(fontBody);
                labelNoti.setForeground(new Color(39, 167, 239));

                JPanel panelNoti = new JPanel(new GridLayout(2, 1, 5, 0));
                inputNoti = new JTextField(50);
                panelNoti.add(labelNoti);
                panelNoti.add(inputNoti);

                JLabel labelOption = new JLabel("Tình trạng hợp đồng");
                String[] option;
                if (!daDuyet) {
                    option = new String[]{"Chưa duyệt", "Đã duyệt"};
                } else {
                    option = new String[]{"Đã duyệt", "Chưa duyệt"};
                }
                JPanel panelOption = new JPanel(new GridLayout(2, 1, 5, 0));
                inputStatusContract = new JComboBox<String>(option);
                panelOption.add(labelOption);
                panelOption.add(inputStatusContract);

                jPanelBody.add(panelRepreName);
                jPanelBody.add(panelSignDay);
                jPanelBody.add(panelParterName);
                jPanelBody.add(panelTimeRemain);
                jPanelBody.add(panelCommisPercent);
                jPanelBody.add(panelStaffName);
                jPanelBody.add(panelCommisFee);
                jPanelBody.add(panelNoti);
                jPanelBody.add(panelOption);
                jPanelBody.setPreferredSize(new Dimension(500, 360));

                JPanel jPanelBodyLeft = new JPanel();
                jPanelBodyLeft.setPreferredSize(new Dimension(250, 360));
                JPanel jPanelBodyRight = new JPanel();
                jPanelBodyRight.setPreferredSize(new Dimension(250, 360));

                JButton jButtonBack = new JButton("Quay lại");
                jButtonBack.setPreferredSize(new Dimension(130, 60));
                jButtonBack.setBackground(new Color(217, 217, 217));
                jButtonBack.addActionListener(this);

                JButton jButtonNoti = new JButton("Thông báo đối tác");
                jButtonNoti.setPreferredSize(new Dimension(160, 60));
                jButtonNoti.setBackground(new Color(217, 217, 217));

                JButton jButtonUpdateInfo = new JButton("Cập nhật");
                jButtonUpdateInfo.setPreferredSize(new Dimension(130, 60));
                jButtonUpdateInfo.setBackground(new Color(217, 217, 217));
                jButtonUpdateInfo.addActionListener(this);

                JPanel jPanelBot = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 60));
                jPanelBot.add(jButtonBack);
                jPanelBot.add(jButtonNoti);
                jPanelBot.add(jButtonUpdateInfo);

                jPanelHeader.setPreferredSize(new Dimension(1000, 60));
                JPanel jPanelHeader1 = new JPanel();
                jPanelHeader1.add(jPanelHeader);

                jPanelBot.setPreferredSize(new Dimension(1000, 180));
                this.setLayout(new BorderLayout());
                this.add(jPanelHeader1, BorderLayout.PAGE_START);
                this.add(jPanelBodyLeft, BorderLayout.LINE_START);
                this.add(jPanelBodyRight, BorderLayout.LINE_END);
                this.add(jPanelBody, BorderLayout.CENTER);
                this.add(jPanelBot, BorderLayout.PAGE_END);
                this.setVisible(true);
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
            new DanhSachHopDongView(MaTaiKhoan);
            this.dispose();
        } else if (acStr.equals("Cập nhật")) {
            String option = (String) inputStatusContract.getSelectedItem();
            ContractProcedure contractProcedure = new ContractProcedure();
            int check = 0;
            if (option.equals("Đã duyệt") && daDuyet == true) { //Trước và sau của hợp đồng đều là đã duyệt
//                check = contractProcedure.SP_LUCapNhatThoiGianHLHopDong(MaHopDong,Integer.parseInt(inputTimeRemain.getText()));
//                check = contractProcedure.SP_CapNhatThoiGianHLHopDongXuLyLu(MaHopDong,Integer.parseInt(inputTimeRemain.getText()));
//                check = contractProcedure.SP_DLCapNhatThoiGianHLHopDong(MaHopDong,Integer.parseInt(inputTimeRemain.getText()));
                check = contractProcedure.SP_CapNhatThoiGianHLHopDongXuLyDL(MaHopDong,Integer.parseInt(inputTimeRemain.getText()));
            } else if (option.equals("Đã duyệt") && daDuyet == false) { //Trước là chưa duyệt và sau là đã duyệt
//                check = contractProcedure.SP_LUCapNhatThoiGianHLHopDong(MaHopDong,0);
//                check = contractProcedure.SP_CapNhatThoiGianHLHopDongXuLyLu(MaHopDong,0);
//                check = contractProcedure.SP_DLCapNhatThoiGianHLHopDong(MaHopDong,0);
                check = contractProcedure.SP_CapNhatThoiGianHLHopDongXuLyDL(MaHopDong,0);
            } else if (option.equals("Chưa duyệt") && daDuyet == true) { //Trước là đã duyệt và sau là chưa duyệt
//                check = contractProcedure.SP_LUCapNhatThoiGianHLHopDong(MaHopDong,-1);
//                check = contractProcedure.SP_CapNhatThoiGianHLHopDongXuLyLu(MaHopDong,-1);
//                check = contractProcedure.SP_DLCapNhatThoiGianHLHopDong(MaHopDong,-1);
                check = contractProcedure.SP_CapNhatThoiGianHLHopDongXuLyDL(MaHopDong,-1);
            }

            if (check == 1) {
                JOptionPane.showMessageDialog(null, "Cập nhật thời gian hiệu lực thành công",
                        "Thông báo",JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Cập nhật thời gian hiệu lực thất bại",
                        "Thông báo",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
