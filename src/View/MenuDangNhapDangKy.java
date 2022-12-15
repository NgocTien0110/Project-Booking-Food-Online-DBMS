package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuDangNhapDangKy extends JFrame implements ActionListener {
    private JLabel labelHeader;
    private JButton buttonDangNhap;
    private JButton buttonDangKy;

    public MenuDangNhapDangKy() {
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

        buttonDangKy = new JButton("Đăng ký");
        buttonDangKy.setBackground(new Color(1, 119, 216));
        buttonDangKy.setForeground(Color.white);
        buttonDangKy.setFont(new Font("Arial", Font.BOLD, 55));
        buttonDangKy.addActionListener(this);

        buttonDangNhap = new JButton("Đăng nhập");
        buttonDangNhap.setBackground(new Color(1, 119, 216));
        buttonDangNhap.setForeground(Color.white);
        buttonDangNhap.setFont(new Font("Arial", Font.BOLD, 55));
        buttonDangNhap.addActionListener(this);

        jPanelBody.setLayout(new GridLayout(1,2,50,80));
        jPanelBody.add(buttonDangNhap);
        jPanelBody.add(buttonDangKy);
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

    public static void main(String[] args) {
        new MenuDangNhapDangKy();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String strAction = e.getActionCommand();
        if (strAction.equals("Đăng ký")) {
            new SignUpView();
            this.dispose();
        }
         else if (strAction.equals("Đăng nhập")){
            new LoginView();
            this.dispose();
        }
    }
}
