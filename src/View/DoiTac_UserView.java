package View;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import DAO.DoiTacDAO;
import Model.DoiTacModel;
import StoredProcedure.CallStoredProcedure;
import database.JDBCUtil;

import java.sql.*;
// mouse event listener table


public class DoiTac_UserView extends JPanel {
    private JTextField searchField;
    private JTextField madt;
    private JTextField name;
    private JTextField email;
    private JTextField phone;
    private JTextField address;
    private JTextField amountCN;
    private JButton btnBack;
    private JButton btnViewListCN;
    private JButton btnSearch;
    private JTable table;
    private String MaTaiKhoan;
    public DoiTac_UserView(String maTaiKhoan)
    {
        MaTaiKhoan = maTaiKhoan;
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1200, 600));
        JLabel title=new JLabel("Danh sách đối tác");
        title.setForeground(new Color(1, 119, 219));
        title.setFont(new Font("Arial", Font.BOLD, 25));
        searchField=new JTextField(15);
        btnSearch=new JButton("Tìm kiếm");
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setBackground(new Color(1, 119, 219));
        btnSearch.setFont(new Font("Arial", Font.BOLD, 15));
        JPanel searchPanel=new JPanel();
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.X_AXIS));
        searchPanel.add(searchField);
        searchPanel.add(btnSearch);
        JPanel topPanel=new JPanel();
        topPanel.add(title);
        topPanel.add(Box.createRigidArea(new Dimension(250, 50)));
        topPanel.add(searchPanel);
        topPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        JLabel madt_label=new JLabel("Mã đối tác:");
        madt_label.setFont(new Font("Arial", Font.BOLD, 15));
        madt_label.setForeground(new Color(1, 119, 219));
        madt=new JTextField(10);
        madt.setEditable(false);
        JPanel madtPanel=new JPanel();
        madtPanel.setLayout(new BoxLayout(madtPanel, BoxLayout.Y_AXIS));
        madtPanel.add(madt_label);
        madtPanel.add(madt);
        JLabel name_label=new JLabel("Tên đối tác:");
        name_label.setFont(new Font("Arial", Font.BOLD, 15));
        name_label.setForeground(new Color(1, 119, 219));
        name=new JTextField(10);
        name.setEditable(false);
        JPanel namePanel=new JPanel();
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.Y_AXIS));
        namePanel.add(name_label);
        namePanel.add(name);
        JLabel email_label=new JLabel("Email:");
        email_label.setFont(new Font("Arial", Font.BOLD, 15));
        email_label.setForeground(new Color(1, 119, 219));
        email=new JTextField(10);
        email.setEditable(false);
        JPanel emailPanel=new JPanel();
        emailPanel.setLayout(new BoxLayout(emailPanel, BoxLayout.Y_AXIS));
        emailPanel.add(email_label);
        emailPanel.add(email);
        JLabel phone_label=new JLabel("Số điện thoại:");
        phone_label.setFont(new Font("Arial", Font.BOLD, 15));
        phone_label.setForeground(new Color(1, 119, 219));
        phone=new JTextField(10);
        phone.setEditable(false);
        JPanel phonePanel=new JPanel();
        phonePanel.setLayout(new BoxLayout(phonePanel, BoxLayout.Y_AXIS));
        phonePanel.add(phone_label);
        phonePanel.add(phone);
        JLabel address_label=new JLabel("Địa chỉ:");
        address_label.setFont(new Font("Arial", Font.BOLD, 15));
        address_label.setForeground(new Color(1, 119, 219));
        address=new JTextField(10);
        address.setEditable(false);
        JPanel addressPanel=new JPanel();
        addressPanel.setLayout(new BoxLayout(addressPanel, BoxLayout.Y_AXIS));
        addressPanel.add(address_label);
        addressPanel.add(address);
        JLabel amountCN_label=new JLabel("Số lượng chi nhánh:");
        amountCN_label.setFont(new Font("Arial", Font.BOLD, 15));
        amountCN_label.setForeground(new Color(1, 119, 219));
        amountCN=new JTextField(10);
        amountCN.setEditable(false);
        JPanel amountCNPanel=new JPanel();
        amountCNPanel.setLayout(new BoxLayout(amountCNPanel, BoxLayout.Y_AXIS));
        amountCNPanel.add(amountCN_label);
        amountCNPanel.add(amountCN);
        JPanel infoPanel=new JPanel();
        infoPanel.setLayout(new GridLayout(2, 3, 60, 20));
        infoPanel.add(madtPanel);
        infoPanel.add(namePanel);
        infoPanel.add(emailPanel);
        infoPanel.add(phonePanel);
        infoPanel.add(addressPanel);
        infoPanel.add(amountCNPanel);

        btnBack=new JButton("Quay lại");
        btnBack.setForeground(Color.WHITE);
        btnBack.setBackground(new Color(1, 119, 219));
        btnBack.setFont(new Font("Arial", Font.BOLD, 15));
        btnViewListCN=new JButton("Xem danh sách chi nhánh");
        btnViewListCN.setForeground(Color.WHITE);
        btnViewListCN.setBackground(new Color(1, 119, 219));
        btnViewListCN.setFont(new Font("Arial", Font.BOLD, 15));
        JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.CENTER, 200, 20));
        buttonPanel.add(btnBack);
        buttonPanel.add(btnViewListCN);
        table = new JTable();
        table.setRowHeight(30);
        table.setFont(new Font("Arial", Font.PLAIN, 15));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
        table.getTableHeader().setForeground(new Color(1, 119, 216));
        table.getTableHeader().setBackground(new Color(255, 255, 255));
        table.getTableHeader().setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        table.setShowGrid(false);
        table.setShowVerticalLines(true);
        table.setShowHorizontalLines(true);
        table.setGridColor(new Color(1, 119, 216));
        table.setSelectionBackground(new Color(1, 119, 216));
        table.setSelectionForeground(new Color(255, 255, 255));
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);
        table.setCellSelectionEnabled(false);
        table.setDragEnabled(false);
        table.setFillsViewportHeight(true);
        table.setPreferredScrollableViewportSize(new Dimension(800, 300));
        table.setFillsViewportHeight(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setRowSelectionAllowed(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // insert data to table
        DefaultTableModel model = new DefaultTableModel();
        Object[] column = {"Mã đối tác","Tên đối tác", "SL chi nhánh", "Email", "Số điện thoại","Địa chỉ"};
        model.setColumnIdentifiers(column);
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        ArrayList<DoiTacModel> list = DoiTacDAO.getInstance().selectAll();
        CallStoredProcedure call = new CallStoredProcedure();
        call.ESP_XemDanhSachDoiTacUser(model);

        // add table to scrollpane
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        // add scrollpane to frame


        JPanel tablePanel=new JPanel();
        tablePanel.add(scroll);
        JPanel centerPanel=new JPanel();
        centerPanel.add(infoPanel);
        centerPanel.add(buttonPanel);
        centerPanel.add(tablePanel);
        add(centerPanel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.PAGE_START);
        // xử lý sự kiện
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = table.getSelectedRow();
                madt.setText(model.getValueAt(i, 0).toString());
                name.setText(model.getValueAt(i, 1).toString());
                amountCN.setText(model.getValueAt(i, 2).toString());
                email.setText(model.getValueAt(i, 3).toString());
                phone.setText(model.getValueAt(i, 4).toString());
                address.setText(model.getValueAt(i, 5).toString());
            }
        });
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        table.setRowSorter(sorter);
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = searchField.getText();
                if (text.length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter(text));
                }
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((Character.compare(MaTaiKhoan.charAt(0),'K') == 0) && (Character.compare(MaTaiKhoan.charAt(1),'H') == 0)) {
                    new MenuKhachHang(MaTaiKhoan);
                    Window win = SwingUtilities.getWindowAncestor(DoiTac_UserView.this);
                    win.dispose();
                }
                else if ((Character.compare(MaTaiKhoan.charAt(0),'T') == 0) && (Character.compare(MaTaiKhoan.charAt(1),'X') == 0)) {
                    new MenuTaiXe(MaTaiKhoan);
                    Window win = SwingUtilities.getWindowAncestor(DoiTac_UserView.this);
                    win.dispose();
                }
                else if ((Character.compare(MaTaiKhoan.charAt(0),'N') == 0) && (Character.compare(MaTaiKhoan.charAt(1),'V') == 0)) {
                    new MenuNhanVien(MaTaiKhoan);
                    Window win = SwingUtilities.getWindowAncestor(DoiTac_UserView.this);
                    win.dispose();
                } else if ((Character.compare(MaTaiKhoan.charAt(0),'D') == 0) && (Character.compare(MaTaiKhoan.charAt(1),'D') == 0)) {
                    new MenuDoiTac(MaTaiKhoan);
                    Window win = SwingUtilities.getWindowAncestor(DoiTac_UserView.this);
                    win.dispose();
                }
                Window win = SwingUtilities.getWindowAncestor(DoiTac_UserView.this);
                win.dispose();
            }
        });
        btnViewListCN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = table.getSelectedRow();
                if(i==-1) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn đối tác cần xem chi nhánh");
                } else {
                    String maDT = model.getValueAt(i, 0).toString();
                    // đóng giao diện hiện tại
                    Window win = SwingUtilities.getWindowAncestor(DoiTac_UserView.this);
                    win.dispose();
                    new ChiNhanh_UserView(maDT, MaTaiKhoan).createAndShowGUI(maDT, MaTaiKhoan);
                }
            }
        });
    }
    public void createAndShowGUI(String maTaiKhoan)
    {
        System.out.println(maTaiKhoan);
        JFrame frame = new JFrame("DT_User");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel newContentPane = new DoiTac_UserView(maTaiKhoan);
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    // add even

}
// doi tac user