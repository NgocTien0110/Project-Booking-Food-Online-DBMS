package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuNhanVien extends JFrame implements ActionListener {
    private JLabel labelHeader;
    private JButton buttonInfoAcc;
    private JButton buttonViewListPartner;
    private JButton buttonViewListContract;
    private JButton buttonLogout;
    private String MaTaiKhoanNV;
    public MenuNhanVien(String maTaiKhoanNV) {
        this.MaTaiKhoanNV = maTaiKhoanNV;
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

        buttonViewListContract = new JButton("Xem danh sách hợp đồng");
        buttonViewListContract.setBackground(new Color(1, 119, 216));
        buttonViewListContract.setForeground(Color.white);
        buttonViewListContract.setFont(new Font("Arial", Font.BOLD, 20));
        buttonViewListContract.addActionListener(this);

        buttonLogout = new JButton("Đăng xuất");
        buttonLogout.setBackground(new Color(1, 119, 216));
        buttonLogout.setForeground(Color.white);
        buttonLogout.setFont(new Font("Arial", Font.BOLD, 25));
        buttonLogout.addActionListener(this);

        jPanelBody.setLayout(new GridLayout(2,2,50,80));
        jPanelBody.add(buttonInfoAcc);
        jPanelBody.add(buttonViewListPartner);
        jPanelBody.add(buttonViewListContract);
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
            new UpdateInfoAccView(MaTaiKhoanNV);
            this.dispose();
        }
        else if (strAction.equals("Đăng xuất")){
            new MenuDangNhapDangKy();
            this.dispose();
        }
    }
}
