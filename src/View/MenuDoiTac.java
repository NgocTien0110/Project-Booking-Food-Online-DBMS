package View;

import database.JDBCUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MenuDoiTac extends JFrame implements ActionListener {
    private JLabel labelHeader;
    private JButton buttonInfoAcc;
    private JButton buttonViewListPartner;
    private JButton buttonViewListChiNhanh;
    private JButton buttonLogout;
    private String MaTaiKhoanDD;
    private String MaDoiTac;
    public MenuDoiTac(String maTaiKhoanDD) {
        MaTaiKhoanDD = maTaiKhoanDD;
        try {
            //Bước 1: Tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            //Bước 2: Tạo ra đối tượng statement
            String sql = "Select * From TaiKhoan tk,NguoiDaiDien dd where tk.MaTaiKhoan=dd.MaTaiKhoanDD and tk.MaTaiKhoan=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,MaTaiKhoanDD);

            //Bước 3: Thực thi câu lệnh SQL
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                MaDoiTac = rs.getString("MaDoiTac");
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(MaDoiTac);

        JFrame.setDefaultLookAndFeelDecorated(true);
        this.setTitle("Hệ thống đặt món ăn online");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 500);
        this.setLocationRelativeTo(null);

        JPanel jPanelHeader = new JPanel();
        labelHeader = new JLabel("Hệ thống đặt món ăn online");
        labelHeader.setFont(new Font("Arial", Font.BOLD, 45));
        labelHeader.setForeground(new Color(1, 119, 216));
        jPanelHeader.add(labelHeader);
        jPanelHeader.setPreferredSize(new Dimension(800, 100));

        JPanel jPanelBody = new JPanel();

        buttonInfoAcc = new JButton("Xem thông tin tài khoản");
        buttonInfoAcc.setBackground(new Color(1, 119, 216));
        buttonInfoAcc.setForeground(Color.white);
        buttonInfoAcc.setFont(new Font("Arial", Font.BOLD, 25));
        buttonInfoAcc.addActionListener(this);

        buttonViewListPartner = new JButton("Xem danh sách đối tác");
        buttonViewListPartner.setBackground(new Color(1, 119, 216));
        buttonViewListPartner.setForeground(Color.white);
        buttonViewListPartner.setFont(new Font("Arial", Font.BOLD, 25));
        buttonViewListPartner.addActionListener(this);

        buttonViewListChiNhanh = new JButton("Chỉnh sửa thông tin chi nhánh");
        buttonViewListChiNhanh.setBackground(new Color(1, 119, 216));
        buttonViewListChiNhanh.setForeground(Color.white);
        buttonViewListChiNhanh.setFont(new Font("Arial", Font.BOLD, 20));
        buttonViewListChiNhanh.addActionListener(this);

        buttonLogout = new JButton("Đăng xuất");
        buttonLogout.setBackground(new Color(1, 119, 216));
        buttonLogout.setForeground(Color.white);
        buttonLogout.setFont(new Font("Arial", Font.BOLD, 25));
        buttonLogout.addActionListener(this);

        jPanelBody.setLayout(new GridLayout(2,2,50,80));
        jPanelBody.add(buttonInfoAcc);
        jPanelBody.add(buttonViewListPartner);
        jPanelBody.add(buttonViewListChiNhanh);
        jPanelBody.add(buttonLogout);
        jPanelBody.setPreferredSize(new Dimension(700,300));

        JPanel jPanelBodyLeft = new JPanel();
        jPanelBodyLeft.setPreferredSize(new Dimension(50,300));

        JPanel jPanelBodyRight = new JPanel();
        jPanelBodyRight.setPreferredSize(new Dimension(50,300));

        JLabel jLabelBot = new JLabel("Nhóm 7 - Hệ quản trị CSDL - 20HTTT2", SwingConstants.CENTER);
        jLabelBot.setFont(new Font("Arial", Font.BOLD, 35));
        jLabelBot.setForeground(new Color(1, 119, 216));

        JPanel jPanelBot = new JPanel(new BorderLayout());
        jPanelBot.setPreferredSize(new Dimension(1000, 100));
        jPanelBot.add(jLabelBot, BorderLayout.CENTER);

        this.setLayout(new BorderLayout());
        this.add(jPanelHeader, BorderLayout.PAGE_START);
        this.add(jPanelBody, BorderLayout.CENTER);
        this.add(jPanelBodyLeft, BorderLayout.LINE_START);
        this.add(jPanelBodyRight, BorderLayout.LINE_END);
        this.add(jPanelBot, BorderLayout.PAGE_END);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String strAction = e.getActionCommand();
        if (strAction.equals("Xem thông tin tài khoản")) {
            new UpdateInfoAccView(MaTaiKhoanDD);
            this.dispose();
        }
        else if (strAction.equals("Xem danh sách đối tác")) {
            new DoiTac_UserView(MaTaiKhoanDD).createAndShowGUI(MaTaiKhoanDD);
            this.dispose();
        }
        else if (strAction.equals("Chỉnh sửa thông tin chi nhánh")) {
            new ChiNhanh_AdminView(MaDoiTac, MaTaiKhoanDD).createAndShowGUI(MaDoiTac, MaTaiKhoanDD);
            this.dispose();
        }
        else if (strAction.equals("Đăng xuất")){
            new MenuDangNhapDangKy();
            this.dispose();
        }
    }
}
