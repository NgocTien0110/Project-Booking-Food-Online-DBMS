package View;

import DAO.TaiKhoanDAO;
import Model.TaiKhoanModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateInfoAccView extends JFrame implements ActionListener {
    private JLabel labelHeader;
    private JTextField inputUsername;
    private JTextField inputPassword;
    private JTextField inputConfirmpassword;
    private JTextField inputAddress;
    private JTextField inputFullname;
    private JTextField inputEmail;
    private JTextField inputPhoneNum;
    private  String MaTaiKhoan;
    public UpdateInfoAccView(String maTaiKhoan) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        this.setTitle("Cập nhật thông tin tài khoản");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);

        Font fontHeaderAndFooter = new Font("Arial", Font.BOLD, 35);
        Font fontBody = new Font("Arial", Font.BOLD, 16);

        JPanel jPanelHeader = new JPanel();
        labelHeader = new JLabel("Thông tin tài khoản");
        labelHeader.setFont(fontHeaderAndFooter);
        labelHeader.setForeground(new Color(1, 119, 216));

        jPanelHeader.add(labelHeader);

        MaTaiKhoan = maTaiKhoan;
        TaiKhoanModel accTemp = new TaiKhoanModel();
        accTemp.setMaTaiKhoan(MaTaiKhoan);
        TaiKhoanModel infoAcc = TaiKhoanDAO.getInstance().selectById(accTemp);
        JPanel jPanelBody = new JPanel(new GridLayout(4,2,40,20));

        JLabel labelUsername = new JLabel("Tên đăng nhập");
        labelUsername.setFont(fontBody);
        labelUsername.setForeground(new Color(39, 167, 239));

        JPanel panelUsername = new JPanel(new GridLayout(2,1,5,0));

        inputUsername = new JTextField(50);
        inputUsername.setText(infoAcc.getTenTaiKhoan());
        inputUsername.setEditable(false);
        panelUsername.add(labelUsername);
        panelUsername.add(inputUsername);

        JLabel labelPassword = new JLabel("Mật khẩu");
        labelPassword.setFont(fontBody);
        labelPassword.setForeground(new Color(39, 167, 239));

        JPanel panelPassword = new JPanel(new GridLayout(2,1,5,0));
        inputPassword = new JPasswordField(50);
        panelPassword.add(labelPassword);
        panelPassword.add(inputPassword);

        JLabel labelConfirmPassword = new JLabel("Xác nhận mật khẩu");
        labelConfirmPassword.setFont(fontBody);
        labelConfirmPassword.setForeground(new Color(39, 167, 239));

        JPanel panelConfirmPassword = new JPanel(new GridLayout(2,1,5,0));
        inputConfirmpassword = new JTextField(50);
        panelConfirmPassword.add(labelConfirmPassword);
        panelConfirmPassword.add(inputConfirmpassword);

        JLabel labelAddress = new JLabel("Địa chỉ");
        labelAddress.setFont(fontBody);
        labelAddress.setForeground(new Color(39, 167, 239));

        JPanel panelAddress = new JPanel(new GridLayout(2,1,5,0));
        inputAddress = new JTextField(50);
        inputAddress.setText(infoAcc.getDCTaiKhoan());
        panelAddress.add(labelAddress);
        panelAddress.add(inputAddress);

        JLabel labelFullname = new JLabel("Họ và tên");
        labelFullname.setFont(fontBody);
        labelFullname.setForeground(new Color(39, 167, 239));

        JPanel panelFullname = new JPanel(new GridLayout(2,1,5,0));
        inputFullname = new JTextField(50);
        inputFullname.setText(infoAcc.getHoVaTen());
        panelFullname.add(labelFullname);
        panelFullname.add(inputFullname);

        JLabel labelEmail = new JLabel("Email");
        labelEmail.setFont(fontBody);
        labelEmail.setForeground(new Color(39, 167, 239));

        JPanel panelEmail = new JPanel(new GridLayout(2,1,5,0));
        inputEmail= new JTextField(50);
        inputEmail.setText(infoAcc.getEmail());
        panelEmail.add(labelEmail);
        panelEmail.add(inputEmail);

        JButton buttonUpdatePass = new JButton("Cập nhật mật khẩu");
        buttonUpdatePass.setForeground(Color.WHITE);
        buttonUpdatePass.setBackground(new Color(1, 119, 219));

        JLabel labelPhoneNum = new JLabel("Số điện thoại");
        labelPhoneNum.setFont(fontBody);
        labelPhoneNum.setForeground(new Color(39, 167, 239));

        JPanel panelPhoneNum = new JPanel(new GridLayout(2,1,5,0));
        inputPhoneNum = new JTextField(50);
        inputPhoneNum.setText(infoAcc.getSoDienThoai());
        panelPhoneNum.add(labelPhoneNum);
        panelPhoneNum.add(inputPhoneNum);

        jPanelBody.add(panelUsername);
        jPanelBody.add(panelAddress);
        jPanelBody.add(panelPassword);
        jPanelBody.add(panelFullname);
        jPanelBody.add(panelConfirmPassword);
        jPanelBody.add(panelEmail);
        jPanelBody.add(buttonUpdatePass);
        jPanelBody.add(panelPhoneNum);
        jPanelBody.setPreferredSize(new Dimension(500,360));

        JPanel jPanelBodyLeft = new JPanel();
        jPanelBodyLeft.setPreferredSize(new Dimension(250,360));
        JPanel jPanelBodyRight = new JPanel();
        jPanelBodyRight.setPreferredSize(new Dimension(250,360));

        JButton jButtonBack = new JButton("Quay lại");
        jButtonBack.setPreferredSize(new Dimension(215,60));
        jButtonBack.setForeground(Color.WHITE);
        jButtonBack.setBackground(new Color(1, 119, 219));
        jButtonBack.addActionListener(this);

        JButton jButtonUpdateInfo = new JButton("Cập nhật");
        jButtonUpdateInfo.setPreferredSize(new Dimension(215,60));
        jButtonUpdateInfo.setForeground(Color.WHITE);
        jButtonUpdateInfo.setBackground(new Color(1, 119, 219));

        JPanel jPanelBot = new JPanel(new FlowLayout(FlowLayout.CENTER, 60,60));
        jPanelBot.add(jButtonBack);
        jPanelBot.add(jButtonUpdateInfo);

        jPanelHeader.setPreferredSize(new Dimension(1000,60));
        JPanel jPanelHeader1 = new JPanel();
        jPanelHeader1.add(jPanelHeader);

        jPanelBot.setPreferredSize(new Dimension(1000,180));
        this.setLayout(new BorderLayout());
        this.add(jPanelHeader1, BorderLayout.PAGE_START);
        this.add(jPanelBodyLeft, BorderLayout.LINE_START);
        this.add(jPanelBodyRight, BorderLayout.LINE_END);
        this.add(jPanelBody, BorderLayout.CENTER);
        this.add(jPanelBot, BorderLayout.PAGE_END);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String acStr = e.getActionCommand();
        if (acStr.equals("Quay lại")) {
            if ((Character.compare(MaTaiKhoan.charAt(0),'K') == 0) && (Character.compare(MaTaiKhoan.charAt(1),'H') == 0)) {
                new MenuKhachHang(MaTaiKhoan);
                this.dispose();
            }
            else if ((Character.compare(MaTaiKhoan.charAt(0),'T') == 0) && (Character.compare(MaTaiKhoan.charAt(1),'X') == 0)) {
                new MenuTaiXe(MaTaiKhoan);
                this.dispose();
            }
            else if ((Character.compare(MaTaiKhoan.charAt(0),'N') == 0) && (Character.compare(MaTaiKhoan.charAt(1),'V') == 0)) {
                new MenuNhanVien(MaTaiKhoan);
                this.dispose();
            } else if ((Character.compare(MaTaiKhoan.charAt(0),'D') == 0) && (Character.compare(MaTaiKhoan.charAt(1),'D') == 0)) {
                new MenuDoiTac(MaTaiKhoan);
                this.dispose();
            }
        }
    }
}
