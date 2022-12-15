package View;

import StoredProcedure.XEM_MON_AN;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * View
 * Create by Đặng Ngọc Tiến
 * Date 12/12/2022 - 10:00 AM
 * Description: ...
 */
public class FoodListForCustomersView extends JFrame implements ActionListener {
    private JLabel labelHeader;
    private JTextField inputSearch;
    private JButton buttonSearch;
    private JTextField inputFoodName;
    private JTextField inputQuantity;
    private JTextField inputBrand;
    private JTextField inputPrice;
    private JTextField inputDescription;
    private JTable tableFoodList;
    private JButton buttonBack;
    private JButton buttonBuy;
    private String[] columnNames = {"ID món", "Chi nhánh", "Tên món ăn", "Mô tả", "Số lượng", "Giá"};
    private String MaTaiKhoan;
    private String MaDoiTac;
    private String MaChiNhanh;

    public FoodListForCustomersView(String maDoiTac, String maChiNhanh, String maTaiKhoan) {
        MaTaiKhoan = maTaiKhoan;
        MaChiNhanh = maChiNhanh;
        MaDoiTac = maDoiTac;
        JFrame.setDefaultLookAndFeelDecorated(true);
        this.setTitle("Danh sách món ăn");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);

        JPanel jPanelHeader = new JPanel();
        jPanelHeader.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        jPanelHeader.setLayout(new GridLayout(1, 2, 20, 20));
        labelHeader = new JLabel("Danh sách món ăn");
        labelHeader.setFont(new Font("Arial", Font.BOLD, 35));
        labelHeader.setForeground(new Color(1, 119, 216));

        JPanel jPanelSearch = new JPanel();
        jPanelSearch.setLayout(new GridLayout(1, 2, 0, 0));
        inputSearch = new JTextField();
        buttonSearch = new JButton("Tìm kiếm");
        jPanelSearch.add(inputSearch);
        jPanelSearch.add(buttonSearch);

        jPanelHeader.add(labelHeader);
        jPanelHeader.add(jPanelSearch);

        JPanel jPanelBody = new JPanel(new BorderLayout());
        jPanelBody.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JPanel jPanelBodyTop = new JPanel(new GridLayout(3, 2, 60, 5));
        jPanelBodyTop.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        JPanel jPanelFoodName = new JPanel(new GridLayout(1, 2, 0, 0));
        JLabel labelFoodName = new JLabel("Tên món ăn");
        inputFoodName = new JTextField();
        inputFoodName.setEditable(false);
        jPanelFoodName.add(labelFoodName);
        jPanelFoodName.add(inputFoodName);

        JPanel jPanelQuantity = new JPanel(new GridLayout(1, 2, 0, 0));
        JLabel labelQuantity = new JLabel("Số lượng");
        inputQuantity = new JTextField();
        inputQuantity.setEditable(false);
        jPanelQuantity.add(labelQuantity);
        jPanelQuantity.add(inputQuantity);

        JPanel jPanelBrand = new JPanel(new GridLayout(1, 2, 0, 0));
        JLabel labelBrand = new JLabel("Chi nhánh");
        inputBrand = new JTextField();
        inputBrand.setEditable(false);
        jPanelBrand.add(labelBrand);
        jPanelBrand.add(inputBrand);

        JPanel jPanelPrice = new JPanel(new GridLayout(1, 2, 0, 0));
        JLabel labelPrice = new JLabel("Giá");
        inputPrice = new JTextField();
        inputPrice.setEditable(false);
        jPanelPrice.add(labelPrice);
        jPanelPrice.add(inputPrice);

        JPanel jPanelDescription = new JPanel(new GridLayout(1, 2, 0, 0));
        JLabel labelDescription = new JLabel("Mô tả");
        inputDescription = new JTextField();
        inputDescription.setEditable(false);
        jPanelDescription.add(labelDescription);
        jPanelDescription.add(inputDescription);

        jPanelBodyTop.add(jPanelFoodName);
        jPanelBodyTop.add(jPanelQuantity);
        jPanelBodyTop.add(jPanelBrand);
        jPanelBodyTop.add(jPanelPrice);
        jPanelBodyTop.add(jPanelDescription);

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        tableFoodList = new JTable(model);
        tableFoodList.setRowHeight(30);
        tableFoodList.setFont(new Font("Arial", Font.PLAIN, 15));
        tableFoodList.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
        tableFoodList.getTableHeader().setForeground(new Color(1, 119, 216));
        tableFoodList.getTableHeader().setBackground(new Color(255, 255, 255));
        tableFoodList.getTableHeader().setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        tableFoodList.setShowGrid(false);
        tableFoodList.setShowVerticalLines(true);
        tableFoodList.setShowHorizontalLines(true);
        tableFoodList.setGridColor(new Color(1, 119, 216));
        tableFoodList.setSelectionBackground(new Color(1, 119, 216));
        tableFoodList.setSelectionForeground(new Color(255, 255, 255));
        tableFoodList.setRowSelectionAllowed(true);
        tableFoodList.setColumnSelectionAllowed(false);
        tableFoodList.setCellSelectionEnabled(false);
        tableFoodList.setDragEnabled(false);
        tableFoodList.setFillsViewportHeight(true);
        tableFoodList.setPreferredScrollableViewportSize(new Dimension(500, 300));
        tableFoodList.setFillsViewportHeight(true);
        tableFoodList.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableFoodList.setRowSelectionAllowed(true);
        tableFoodList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        XEM_MON_AN kh_xem_mon_an = new XEM_MON_AN();
        kh_xem_mon_an.KH_XEM_MON_AN(model, maDoiTac, maChiNhanh);

        JScrollPane scrollPane = new JScrollPane(tableFoodList);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        scrollPane.getViewport().setBackground(new Color(255, 255, 255));
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        scrollPane.getViewport().setBackground(new Color(255, 255, 255));
        scrollPane.getViewport().setOpaque(true);

        jPanelBody.add(jPanelBodyTop, BorderLayout.NORTH);
        jPanelBody.add(scrollPane, BorderLayout.CENTER);
        tableFoodList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = tableFoodList.getSelectedRow();
                if (row >= 0) {
                    inputFoodName.setText(tableFoodList.getValueAt(row, 2).toString());
                    inputQuantity.setText(tableFoodList.getValueAt(row, 4).toString());
                    inputBrand.setText(tableFoodList.getValueAt(row, 1).toString());
                    inputPrice.setText(tableFoodList.getValueAt(row, 5).toString());
                    inputDescription.setText(tableFoodList.getValueAt(row, 3).toString());
                }
            }
        });




        JPanel jPanelBodyBottom = new JPanel(new GridLayout(1, 2, 150, 0));
        jPanelBodyBottom.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        buttonBuy = new JButton("Mua ngay");
        buttonBack = new JButton("Quay lại");
        buttonBack.addActionListener(this);
        buttonBuy.addActionListener(this);

        jPanelBodyBottom.add(buttonBack);
        jPanelBodyBottom.add(buttonBuy);



        jPanelBody.add(jPanelBodyTop, BorderLayout.NORTH);
        jPanelBody.add(scrollPane, BorderLayout.CENTER);
        jPanelBody.add(jPanelBodyBottom, BorderLayout.SOUTH);


        this.add(jPanelHeader, BorderLayout.NORTH);
        this.add(jPanelBody, BorderLayout.CENTER);


        this.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String strAction = e.getActionCommand();
        if (strAction.equals("Quay lại")) {
            new ChiNhanh_UserView(MaDoiTac, MaTaiKhoan).createAndShowGUI(MaDoiTac, MaTaiKhoan);
            this.dispose();
        }
        else if (strAction.equals("Mua ngay")) {
            int row = tableFoodList.getSelectedRow();
            if (row >= 0) {
                new OrderFoodView(MaTaiKhoan, MaDoiTac, MaChiNhanh, tableFoodList.getValueAt(row,0).toString());
                this.dispose();
            }
            else {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn món ăn để mua ngay",
                        "Thông báo",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
