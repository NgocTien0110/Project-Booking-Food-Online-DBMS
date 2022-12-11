package View;

import javax.swing.*;
import java.awt.*;

public class OrderFoodView extends JFrame {
    private JLabel labelHeader;
    private JTextField inputFoodName;
    private JTextField inputPrice;
    private JTextField inputNumberFood;
    private JComboBox<String> inputOption;
    private JTextField inputAddress;
    private JComboBox<String> inputPayment;
    private JTextField inputShipFee;
    private JTextField inputTotalPrice;

    public OrderFoodView() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        this.setTitle("Đặt hàng");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);

        Font fontHeaderAndFooter = new Font("Arial", Font.BOLD, 35);
        Font fontBody = new Font("Arial", Font.BOLD, 16);

        JPanel jPanelHeader = new JPanel();
        labelHeader = new JLabel("Đặt hàng");
        labelHeader.setFont(fontHeaderAndFooter);
        labelHeader.setForeground(new Color(1, 119, 216));

        jPanelHeader.add(labelHeader);

        JPanel jPanelBody = new JPanel(new GridLayout(4,2,40,20));

        JLabel labelFoodName = new JLabel("Tên món ăn");
        labelFoodName.setFont(fontBody);
        labelFoodName.setForeground(new Color(39, 167, 239));

        JPanel panelFoodName = new JPanel(new GridLayout(2,1,5,0));
        inputFoodName = new JTextField(50);
        panelFoodName.add(labelFoodName);
        panelFoodName.add(inputFoodName);

        JLabel labelPrice = new JLabel("Giá món ăn");
        labelPrice.setFont(fontBody);
        labelPrice.setForeground(new Color(39, 167, 239));

        JPanel panelPrice = new JPanel(new GridLayout(2,1,5,0));
        inputPrice = new JTextField(50);
        panelPrice.add(labelPrice);
        panelPrice.add(inputPrice);

        JLabel labelNumberFood = new JLabel("Số lượng món ăn");
        labelNumberFood.setFont(fontBody);
        labelNumberFood.setForeground(new Color(39, 167, 239));

        JPanel panelNumberFood = new JPanel(new GridLayout(2,1,5,0));
        inputNumberFood= new JTextField(50);
        panelNumberFood.add(labelNumberFood);
        panelNumberFood.add(inputNumberFood);

        JLabel labelAddress = new JLabel("Địa chỉ");
        labelAddress.setFont(fontBody);
        labelAddress.setForeground(new Color(39, 167, 239));

        JPanel panelAddress = new JPanel(new GridLayout(2,1,5,0));
        inputAddress = new JTextField(50);
        panelAddress.add(labelAddress);
        panelAddress.add(inputAddress);

        JLabel labelOption = new JLabel("Tùy chọn");
        labelOption.setFont(fontBody);
        labelOption.setForeground(new Color(39, 167, 239));

        String[] option = new String[] {"Ít đá", "Nhiều đá", "Ít đường", "Nhiều đường", "Bình thường"};
        JPanel panelOption = new JPanel(new GridLayout(2,1,5,0));
        inputOption = new JComboBox<String>(option);
        panelOption.add(labelOption);
        panelOption.add(inputOption);

        JLabel labelPayment = new JLabel("Hình thức thanh toán");
        labelPayment.setFont(fontBody);
        labelPayment.setForeground(new Color(39, 167, 239));

        String[] payment = new String[] {"Chuyển khoản", "Tiền mặt"};
        JPanel panelPayment = new JPanel(new GridLayout(2,1,5,0));
        inputPayment= new JComboBox<String>(payment);
        panelPayment.add(labelPayment);
        panelPayment.add(inputPayment);

        JLabel labelShipFee = new JLabel("Phí vận chuyển");
        labelShipFee.setFont(fontBody);
        labelShipFee.setForeground(new Color(39, 167, 239));

        JPanel panelShipFee = new JPanel(new GridLayout(2,1,5,0));
        inputShipFee = new JTextField(50);
        panelShipFee.add(labelShipFee);
        panelShipFee.add(inputShipFee);

        JLabel labelTotalPrice = new JLabel("Tổng giá tiền");
        labelTotalPrice.setFont(fontBody);
        labelTotalPrice.setForeground(new Color(39, 167, 239));

        JPanel panelTotalPrice = new JPanel(new GridLayout(2,1,5,0));
        inputTotalPrice = new JTextField(50);
        panelTotalPrice.add(labelTotalPrice);
        panelTotalPrice.add(inputTotalPrice);

        jPanelBody.add(panelFoodName);
        jPanelBody.add(panelAddress);
        jPanelBody.add(panelPrice);
        jPanelBody.add(panelPayment);
        jPanelBody.add(panelNumberFood);
        jPanelBody.add(panelShipFee);
        jPanelBody.add(panelOption);
        jPanelBody.add(panelTotalPrice);
        jPanelBody.setPreferredSize(new Dimension(500,360));

        JPanel jPanelBodyLeft = new JPanel();
        jPanelBodyLeft.setPreferredSize(new Dimension(250,360));
        JPanel jPanelBodyRight = new JPanel();
        jPanelBodyRight.setPreferredSize(new Dimension(250,360));

        JButton jButtonBack = new JButton("Trở về");
        jButtonBack.setPreferredSize(new Dimension(215,60));
        jButtonBack.setBackground(new Color(217, 217, 217));

        JButton jButtonOrder = new JButton("Đặt hàng");
        jButtonOrder.setPreferredSize(new Dimension(215,60));
        jButtonOrder.setBackground(new Color(217, 217, 217));

        JPanel jPanelBot = new JPanel(new FlowLayout(FlowLayout.CENTER, 60,60));
        jPanelBot.add(jButtonBack);
        jPanelBot.add(jButtonOrder);

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
        new OrderFoodView();
    }
}
