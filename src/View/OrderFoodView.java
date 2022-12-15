package View;

import DAO.TaiKhoanDAO;
import DAO.ThucDonDAO;
import Model.TaiKhoanModel;
import Model.ThucDonModel;
import database.JDBCUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

public class OrderFoodView extends JFrame implements ActionListener {
    private JLabel labelHeader;
    private JTextField inputFoodName;
    private JTextField inputPrice;
    private JTextField inputNumberFood;
    private JComboBox<String> inputOption;
    private JTextField inputAddress;
    private JComboBox<String> inputPayment;
    private JTextField inputShipFee;
    private JTextField inputTotalPrice;
    private String MaMonAn;
    private String MaChiNhanh;
    private String MaDoiTac;
    private String MaTaiKhoan;

    public OrderFoodView(String maTaiKhoan, String maDoiTac, String maChiNhanh, String maMonAn) {
        MaTaiKhoan = maTaiKhoan;
        MaChiNhanh = maChiNhanh;
        MaMonAn = maMonAn;
        MaDoiTac = maDoiTac;
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

        TaiKhoanModel accTemp = new TaiKhoanModel();
        accTemp.setMaTaiKhoan(MaTaiKhoan);
        TaiKhoanModel infoAcc = TaiKhoanDAO.getInstance().selectById(accTemp);

        ThucDonModel thucDonTemp = new ThucDonModel();
        thucDonTemp.setMaChiNhanh(MaChiNhanh);
        thucDonTemp.setMaDoiTac(MaDoiTac);
        thucDonTemp.setMaMonAn(MaMonAn);
        ThucDonModel thucDonModel = ThucDonDAO.getInstance().selectById(thucDonTemp);

        JLabel labelFoodName = new JLabel("Tên món ăn");
        labelFoodName.setFont(fontBody);
        labelFoodName.setForeground(new Color(39, 167, 239));
        String TenMonAn="";
        try {
            //Bước 1: Tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            //Bước 2: Tạo ra đối tượng statement
            Statement st = con.createStatement();

            //Bước 3: Thực thi câu lệnh SQL
            String sql =String.format("SELECT * FROM ThucDon td, MonAn ma where td.MaMonAn = ma.MaMonAn and td.MaMonAn='%s'",MaMonAn);
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                TenMonAn = rs.getString("TenMonAn");
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        JPanel panelFoodName = new JPanel(new GridLayout(2,1,5,0));
        inputFoodName = new JTextField(50);
        inputFoodName.setText(TenMonAn);
        inputFoodName.setEditable(false);
        panelFoodName.add(labelFoodName);
        panelFoodName.add(inputFoodName);

        JLabel labelPrice = new JLabel("Giá món ăn");
        labelPrice.setFont(fontBody);
        labelPrice.setForeground(new Color(39, 167, 239));

        JPanel panelPrice = new JPanel(new GridLayout(2,1,5,0));
        inputPrice = new JTextField(50);
        inputPrice.setText(String.valueOf(thucDonModel.getGia()));
        inputPrice.setEditable(false);
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
        inputAddress.setText(infoAcc.getDCTaiKhoan());
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

        jPanelBody.add(panelFoodName);
        jPanelBody.add(panelAddress);
        jPanelBody.add(panelPrice);
        jPanelBody.add(panelPayment);
        jPanelBody.add(panelNumberFood);
        jPanelBody.add(panelOption);
        jPanelBody.setPreferredSize(new Dimension(500,360));

        JPanel jPanelBodyLeft = new JPanel();
        jPanelBodyLeft.setPreferredSize(new Dimension(250,360));
        JPanel jPanelBodyRight = new JPanel();
        jPanelBodyRight.setPreferredSize(new Dimension(250,360));

        JButton jButtonBack = new JButton("Quay lại");
        jButtonBack.setPreferredSize(new Dimension(215,60));
        jButtonBack.setBackground(new Color(217, 217, 217));
        jButtonBack.addActionListener(this);

        JButton jButtonOrder = new JButton("Đặt hàng");
        jButtonOrder.setPreferredSize(new Dimension(215,60));
        jButtonOrder.setBackground(new Color(217, 217, 217));
        jButtonOrder.addActionListener(this);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        String strAc = e.getActionCommand();
        if (strAc.equals("Quay lại")) {
            new FoodListForCustomersView(MaDoiTac, MaChiNhanh, MaTaiKhoan);
            this.dispose();
        } else if (strAc.equals("Đặt hàng")) {
            JLabel labelShipFee = new JLabel("Phí vận chuyển");
            labelShipFee.setForeground(new Color(39, 167, 239));

            JPanel panelShipFee = new JPanel(new GridLayout(2,1,5,0));
            inputShipFee = new JTextField(20);
            double shipFee;
            int slMonDat = Integer.valueOf(inputNumberFood.getText());
            double price = Double.valueOf(inputPrice.getText());
            if (slMonDat * price >= 50.000) {
                shipFee = 5000;
            } else {
                shipFee = 15000;
            }
            inputShipFee.setText(String.valueOf(shipFee));
            inputShipFee.setEditable(false);
            panelShipFee.add(labelShipFee);
            panelShipFee.add(inputShipFee);

            JLabel labelTotalPrice = new JLabel("Tổng giá tiền");
            labelTotalPrice.setForeground(new Color(39, 167, 239));

            JPanel panelTotalPrice = new JPanel(new GridLayout(2,1,5,0));
            inputTotalPrice = new JTextField(20);
            inputTotalPrice.setText(String.valueOf(slMonDat*price));
            panelTotalPrice.add(labelTotalPrice);
            panelTotalPrice.add(inputTotalPrice);

            JPanel jPanelBody = new JPanel(new GridLayout(2,1));
            jPanelBody.add(panelShipFee);
            jPanelBody.add(panelTotalPrice);

            JPanel jPanelHeader = new JPanel();
            JLabel jLabelHeader = new JLabel("Vui lòng xác nhận đơn hàng");
            jPanelHeader.add(jLabelHeader);

            JPanel addPanel = new JPanel(new BorderLayout());
            addPanel.add(jPanelHeader, BorderLayout.PAGE_START);
            addPanel.add(jPanelBody, BorderLayout.CENTER);

            int result = JOptionPane.showConfirmDialog(null, addPanel,
                    "Chỉnh sửa Slang Word", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                JOptionPane.showMessageDialog(null, "Đặt hàng thành công",
                        "Thông báo",JOptionPane.INFORMATION_MESSAGE);
            } else {

            }
        }
    }
}
