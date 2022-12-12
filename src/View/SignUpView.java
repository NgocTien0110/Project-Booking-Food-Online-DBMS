package View;

import javax.swing.*;
import java.awt.*;

/**
 * View
 * Create by Đặng Ngọc Tiến
 * Date 12/11/2022 - 11:35 PM
 * Description: ...
 */
public class SignUpView extends JFrame {
    private JLabel labelHeader;
    private JTextField inputUsername;
    private JTextField inputPassword;
    private JTextField inputConfirmpassword;
    private JTextField inputAddress;
    private JTextField inputEmail;
    private JComboBox<String> inputAccountType;

    private String accountType[] = {"Khách hàng", "Tài xế", "Đối tác"};

    public SignUpView() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        this.setTitle("Đăng ký tài khoản");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);

        Font fontHeaderAndFooter = new Font("Arial", Font.BOLD, 35);
        Font fontBody = new Font("Arial", Font.BOLD, 16);

        JPanel jPanelHeader = new JPanel();
        jPanelHeader.setLayout(new BoxLayout(jPanelHeader, BoxLayout.Y_AXIS));
        jPanelHeader.setBackground(new Color(1, 119, 216));
        jPanelHeader.setPreferredSize(new Dimension(1000, 100));

        JLabel jsubHeader1 = new JLabel("Welcome to");
        jsubHeader1.setFont(new Font("Arial", Font.BOLD, 20));
        jsubHeader1.setForeground(Color.WHITE);
        jsubHeader1.setAlignmentX(Component.CENTER_ALIGNMENT);

        labelHeader = new JLabel("FOOD WORLD ONLINE");
        labelHeader.setFont(fontHeaderAndFooter);
        labelHeader.setForeground(new Color(255, 255, 255));
        labelHeader.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel jsubHeader = new JLabel("Sign up to experience it now");
        jsubHeader.setFont(new Font("Arial", Font.BOLD, 20));
        jsubHeader.setForeground(new Color(255, 255, 255));
        jsubHeader.setAlignmentX(Component.CENTER_ALIGNMENT);

        jPanelHeader.add(jsubHeader1);
        jPanelHeader.add(labelHeader);
        jPanelHeader.add(jsubHeader);

        JPanel jPanelBody = new JPanel(new GridLayout(4, 2, 40, 20));
        jPanelBody.setBorder(BorderFactory.createEmptyBorder(80, 200, 0, 200));

        JLabel labelUsername = new JLabel("Tên tài khoản");
        labelUsername.setFont(fontBody);
        labelUsername.setForeground(new Color(39, 167, 239));

        JPanel panelUsername = new JPanel(new GridLayout(2, 1, 5, 0));

        inputUsername = new JTextField(50);
        panelUsername.add(labelUsername);
        panelUsername.add(inputUsername);

        JLabel labelEmail = new JLabel("Email");
        labelEmail.setFont(fontBody);
        labelEmail.setForeground(new Color(39, 167, 239));

        JPanel panelEmail = new JPanel(new GridLayout(2, 1, 5, 0));
        inputEmail = new JTextField(50);
        panelEmail.add(labelEmail);
        panelEmail.add(inputEmail);

        JLabel labelPassword = new JLabel("Mật khẩu");
        labelPassword.setFont(fontBody);
        labelPassword.setForeground(new Color(39, 167, 239));

        JPanel panelPassword = new JPanel(new GridLayout(2, 1, 5, 0));
        inputPassword = new JTextField(50);
        panelPassword.add(labelPassword);
        panelPassword.add(inputPassword);

        JLabel labelConfirmPassword = new JLabel("Xác nhận mật khẩu");
        labelConfirmPassword.setFont(fontBody);
        labelConfirmPassword.setForeground(new Color(39, 167, 239));

        JPanel panelConfirmPassword = new JPanel(new GridLayout(2, 1, 5, 0));
        inputConfirmpassword = new JTextField(50);
        panelConfirmPassword.add(labelConfirmPassword);
        panelConfirmPassword.add(inputConfirmpassword);

        JLabel labelAddress = new JLabel("Địa chỉ");
        labelAddress.setFont(fontBody);
        labelAddress.setForeground(new Color(39, 167, 239));

        JPanel panelAddress = new JPanel(new GridLayout(2, 1, 5, 0));
        inputAddress = new JTextField(50);
        panelAddress.add(labelAddress);
        panelAddress.add(inputAddress);

        JLabel labelAccountType = new JLabel("Loại tài khoản");
        labelAccountType.setFont(fontBody);
        labelAccountType.setForeground(new Color(39, 167, 239));

        JPanel panelAccountType = new JPanel(new GridLayout(2, 1, 5, 0));
        inputAccountType = new JComboBox<>(accountType);
        panelAccountType.add(labelAccountType);
        panelAccountType.add(inputAccountType);


        jPanelBody.add(panelUsername);
        jPanelBody.add(panelEmail);
        jPanelBody.add(panelPassword);
        jPanelBody.add(panelConfirmPassword);
        jPanelBody.add(panelAddress);
        jPanelBody.add(panelAccountType);

        JPanel jPanelFooter = new JPanel();
        jPanelFooter.setLayout(new GridLayout(1, 2, 20, 0));

        JButton buttonSignUp = new JButton("Đăng ký");
        buttonSignUp.setFont(fontBody);
        buttonSignUp.setForeground(new Color(255, 255, 255));
        buttonSignUp.setBackground(new Color(1, 119, 216));
        buttonSignUp.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton buttonBack = new JButton("Quay lại");
        buttonBack.setFont(fontBody);
        buttonBack.setForeground(new Color(255, 255, 255));
        buttonBack.setBackground(new Color(1, 119, 216));
        buttonBack.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        jPanelFooter.add(buttonSignUp);
        jPanelFooter.add(buttonBack);
        jPanelFooter.setBorder(BorderFactory.createEmptyBorder(0, 200, 50, 200));

        this.add(jPanelHeader, BorderLayout.NORTH);
        this.add(jPanelBody, BorderLayout.CENTER);
        this.add(jPanelFooter, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new SignUpView();
    }
}
