package View;



import javax.swing.*;
import java.awt.*;

/**
 *
 */
public class LoginView extends JPanel {

    private JButton login;
    private JButton register;
    private JLabel username_label;
    private JLabel password_label;
    private JTextField username;
    private JTextField password;
    public LoginView() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        JLabel phone=new JLabel("Call us: 1900-1412");
        phone.setForeground(Color.WHITE);
        phone.setFont(new Font("Arial", Font.TRUETYPE_FONT, 18));
        JLabel email=new JLabel("Email: 3T1V@support.com");
        email.setForeground(Color.WHITE);
        email.setFont(new Font("Arial", Font.TRUETYPE_FONT, 18));
        JPanel jPanel1=new JPanel();
        jPanel1.setBackground(new java.awt.Color(1, 119, 216));
        JPanel jPanel5= new JPanel();
        jPanel5.setBackground(new java.awt.Color(1, 119, 216));

        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(phone)
                                .addGap(58, 58, 58)
                                .addComponent(email)
                                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(phone, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(email))
                                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5);
        JPanel jPanel2=new JPanel();
        jPanel2.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        JPanel jPanel4=new JPanel();
        jPanel4.setBackground(new java.awt.Color(1, 119, 216));
        JPanel jPanel3=new JPanel();
        jPanel3.setBackground(new java.awt.Color(1, 119, 216));

        JLabel JLabel1=new JLabel("3T1V");
        JLabel1.setForeground(Color.WHITE);
        JLabel1.setFont(new Font("Arial", Font.TRUETYPE_FONT, 18));
        JLabel JLabel2=new JLabel("ONLINE FOOD ORDERING");
        JLabel2.setForeground(Color.WHITE);
        JLabel2.setFont(new Font("Arial", Font.TRUETYPE_FONT, 18));
        JLabel JLabel3=new JLabel("AND DELIVERY SYSTEM");
        JLabel3.setForeground(Color.WHITE);
        JLabel3.setFont(new Font("Arial", Font.TRUETYPE_FONT, 18));

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(101, 101, 101)
                                                .addComponent(JLabel1))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(JLabel2)))
                                .addContainerGap(9, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(JLabel3)
                                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JLabel2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JLabel3)
                                .addContainerGap())
        );

        jPanel4.add(jPanel3);
        //user name, password
        username_label = new JLabel("Tên tài khoản");
        username_label.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        password_label = new JLabel("Mật khẩu");
        password_label.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        username = new JTextField();
        password= new JPasswordField();
        username.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        password.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        //đăng nhập
        login= new JButton("Đăng nhập");
        login.setBackground(new java.awt.Color(1, 119, 216));
        login.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        login.setForeground(new java.awt.Color(255, 255, 255));


        //đăng ký
        register= new JButton("Đăng ký");
        register.setBackground(new java.awt.Color(1, 119, 216));
        register.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        register.setForeground(new java.awt.Color(255, 255, 255));


        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(login)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(register, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(username_label)
                                        .addComponent(password_label)
                                        .addComponent(password)
                                        .addComponent(username))
                                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(username_label)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(username, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(password_label)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(password, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(login, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(register, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 27, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(227, 227, 227)
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(142, Short.MAX_VALUE))
        );
        JFrame frame = new JFrame("Login");
        frame.setContentPane(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }// </editor-fold>

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }


    // Variables declaration - do not modify

    // End of variables declaration
}

