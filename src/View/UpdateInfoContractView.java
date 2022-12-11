package View;

import javax.swing.*;
import java.awt.*;

public class UpdateInfoContractView extends JFrame {
    private JLabel labelHeader;
    private JTextField inputRepreName;
    private JTextField inputParterName;
    private JTextField inputCommisPercent;
    private JTextField inputCommisFeeMonthly;
    private JTextField inputSignDay;
    private JTextField inputTimeRemain;
    private JTextField inputStaffName;
    private JTextField inputNoti;

    public UpdateInfoContractView() {
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

        JPanel jPanelBody = new JPanel(new GridLayout(4,2,20,20));

        JLabel labelRepre = new JLabel("Tên người đại diện");
        labelRepre.setFont(fontBody);
        labelRepre.setForeground(new Color(39, 167, 239));

        JPanel panelRepreName = new JPanel(new GridLayout(2,1,5,0));
        labelRepre.setFont(fontBody);
        labelRepre.setForeground(new Color(39, 167, 239));

        inputRepreName = new JTextField(50);
        panelRepreName.add(labelRepre);
        panelRepreName.add(inputRepreName);

        JLabel labelParterName = new JLabel("Tên đối tác");
        labelParterName.setFont(fontBody);
        labelParterName.setForeground(new Color(39, 167, 239));

        JPanel panelParterName= new JPanel(new GridLayout(2,1,5,0));
        inputParterName = new JTextField(50);
        panelParterName.add(labelParterName);
        panelParterName.add(inputParterName);

        JLabel labelCommisPercent = new JLabel("Phần trăm hoa hồng");
        labelCommisPercent.setFont(fontBody);
        labelCommisPercent.setForeground(new Color(39, 167, 239));

        JPanel panelCommisPercent = new JPanel(new GridLayout(2,1,5,0));
        inputCommisPercent = new JTextField(50);
        panelCommisPercent.add(labelCommisPercent);
        panelCommisPercent.add(inputCommisPercent);

        JLabel labelCommisFee = new JLabel("Phí hoa hồng tháng");
        labelCommisFee.setFont(fontBody);
        labelCommisFee.setForeground(new Color(39, 167, 239));

        JPanel panelCommisFee= new JPanel(new GridLayout(2,1,5,0));
        inputCommisFeeMonthly = new JTextField(50);
        panelCommisFee.add(labelCommisFee);
        panelCommisFee.add(inputCommisFeeMonthly);

        JLabel labelSignDay = new JLabel("Ngày ký");
        labelSignDay.setFont(fontBody);
        labelSignDay.setForeground(new Color(39, 167, 239));

        JPanel panelSignDay = new JPanel(new GridLayout(2,1,5,0));
        inputSignDay = new JTextField(50);
        panelSignDay.add(labelSignDay);
        panelSignDay.add(inputSignDay);

        JLabel labelRemain = new JLabel("Thời gian hiệu lực");
        labelRemain.setFont(fontBody);
        labelRemain.setForeground(new Color(39, 167, 239));

        JPanel panelTimeRemain = new JPanel(new GridLayout(2,1,5,0));
        inputTimeRemain= new JTextField(50);
        panelTimeRemain.add(labelRemain);
        panelTimeRemain.add(inputTimeRemain);

        JLabel labelStaffName = new JLabel("Tên nhân viên phụ trách");
        labelStaffName.setFont(fontBody);
        labelStaffName.setForeground(new Color(39, 167, 239));

        JPanel panelStaffName = new JPanel(new GridLayout(2,1,5,0));
        inputStaffName= new JTextField(50);
        panelStaffName.add(labelStaffName);
        panelStaffName.add(inputStaffName);

        JLabel labelNoti = new JLabel("Thông báo");
        labelNoti.setFont(fontBody);
        labelNoti.setForeground(new Color(39, 167, 239));

        JPanel panelNoti = new JPanel(new GridLayout(2,1,5,0));
        inputNoti = new JTextField(50);
        panelNoti.add(labelNoti);
        panelNoti.add(inputNoti);

        jPanelBody.add(panelRepreName);
        jPanelBody.add(panelSignDay);
        jPanelBody.add(panelParterName);
        jPanelBody.add(panelTimeRemain);
        jPanelBody.add(panelCommisPercent);
        jPanelBody.add(panelStaffName);
        jPanelBody.add(panelCommisFee);
        jPanelBody.add(panelNoti);
        jPanelBody.setPreferredSize(new Dimension(500,360));

        JPanel jPanelBodyLeft = new JPanel();
        jPanelBodyLeft.setPreferredSize(new Dimension(250,360));
        JPanel jPanelBodyRight = new JPanel();
        jPanelBodyRight.setPreferredSize(new Dimension(250,360));

        JButton jButtonBack = new JButton("Trở về");
        jButtonBack.setPreferredSize(new Dimension(130,60));
        jButtonBack.setBackground(new Color(217, 217, 217));

        JButton jButtonNoti = new JButton("Thông báo đối tác");
        jButtonNoti.setPreferredSize(new Dimension(160,60));
        jButtonNoti.setBackground(new Color(217, 217, 217));

        JButton jButtonUpdateInfo = new JButton("Cập nhật");
        jButtonUpdateInfo.setPreferredSize(new Dimension(130,60));
        jButtonUpdateInfo.setBackground(new Color(217, 217, 217));

        JPanel jPanelBot = new JPanel(new FlowLayout(FlowLayout.CENTER, 30,60));
        jPanelBot.add(jButtonBack);
        jPanelBot.add(jButtonNoti);
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

    public static void main(String[] args) {
        new UpdateInfoContractView();
    }
}
