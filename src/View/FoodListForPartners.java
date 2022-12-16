package View;


import DAO.ThucDonDAO;
import Model.ThucDonModel;
import StoredProcedure.DT_UPDATE_GIA;
import StoredProcedure.XEM_MON_AN;
import StoredProcedure.XOA_MON_AN;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * View
 * Create by Đặng Ngọc Tiến
 * Date 12/12/2022 - 10:00 AM
 * Description: ...
 */
public class FoodListForPartners extends JFrame implements ActionListener {
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
    private JButton buttonAdd;
    private JButton buttonUpdate;
    private JButton buttonDelete;
    private String MaTaiKhoan;
    private String MaDoiTac;
    private String MaChiNhanh;
//    private JButton buttonSave;

    private String[] columnNames = {"ID món", "Chi nhánh", "Tên món ăn", "Mô tả", "Số lượng", "Giá"};

    ArrayList<ThucDonModel> list = ThucDonDAO.getInstance().selectAll();
    public FoodListForPartners(String maDoiTac, String maChiNhanh, String maTaiKhoan) {
        MaDoiTac = maDoiTac;
        MaChiNhanh = maChiNhanh;
        MaTaiKhoan = maTaiKhoan;
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
        buttonSearch.setForeground(Color.WHITE);
        buttonSearch.setBackground(new Color(1, 119, 219));

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
        jPanelFoodName.add(labelFoodName);
        jPanelFoodName.add(inputFoodName);

        JPanel jPanelQuantity = new JPanel(new GridLayout(1, 2, 0, 0));
        JLabel labelQuantity = new JLabel("Số lượng");
        inputQuantity = new JTextField();
        jPanelQuantity.add(labelQuantity);
        jPanelQuantity.add(inputQuantity);

        JPanel jPanelBrand = new JPanel(new GridLayout(1, 2, 0, 0));
        JLabel labelBrand = new JLabel("Chi nhánh");
        inputBrand = new JTextField();
        jPanelBrand.add(labelBrand);
        jPanelBrand.add(inputBrand);

        JPanel jPanelPrice = new JPanel(new GridLayout(1, 2, 0, 0));
        JLabel labelPrice = new JLabel("Giá");
        inputPrice = new JTextField();
        jPanelPrice.add(labelPrice);
        jPanelPrice.add(inputPrice);

        JPanel jPanelDescription = new JPanel(new GridLayout(1, 2, 0, 0));
        JLabel labelDescription = new JLabel("Mô tả");
        inputDescription = new JTextField();
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

        tableFoodList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tableFoodList.getSelectedRow();
                inputFoodName.setText(tableFoodList.getValueAt(row, 2).toString());
                inputQuantity.setText(tableFoodList.getValueAt(row, 4).toString());
                inputBrand.setText(tableFoodList.getValueAt(row, 1).toString());
                inputPrice.setText(tableFoodList.getValueAt(row, 5).toString());
                inputDescription.setText(tableFoodList.getValueAt(row, 3).toString());
            }
        });

        JPanel jPanelBodyBottom = new JPanel(new GridLayout(1, 5, 20, 0));
        jPanelBodyBottom.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        buttonBack = new JButton("Quay lại");
        buttonBack.addActionListener(this);
        buttonBack.setForeground(Color.WHITE);
        buttonBack.setBackground(new Color(1, 119, 219));

        buttonAdd = new JButton("Thêm");
        buttonAdd.setForeground(Color.WHITE);
        buttonAdd.setBackground(new Color(1, 119, 219));

        buttonUpdate = new JButton("Sửa");
        buttonUpdate.setForeground(Color.WHITE);
        buttonUpdate.setBackground(new Color(1, 119, 219));

        buttonUpdate.addActionListener(new ActionListener() {
                                           @Override
                                           public void actionPerformed(ActionEvent e) {
                                               int row = tableFoodList.getSelectedRow();
                                               String maMonAn = tableFoodList.getValueAt(row, 0).toString();
//                                               String tenMonAn = inputFoodName.getText();
//                                               String soLuong = inputQuantity.getText();
//                                               String moTa = inputDescription.getText();
                                               String gia = inputPrice.getText();

                                               DT_UPDATE_GIA callStoredProcedure = new DT_UPDATE_GIA();
                                               int sta = callStoredProcedure.DT_UPDATE_GIA(maDoiTac, maMonAn, gia);

                                               if(sta == 1){
                                                   JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                                                   // refresh table
                                                    model.setRowCount(0);
                                                   XEM_MON_AN kh_xem_mon_an = new XEM_MON_AN();
                                                   kh_xem_mon_an.KH_XEM_MON_AN(model, maDoiTac, maChiNhanh);
                                                   inputFoodName.setText("");
                                                   inputQuantity.setText("");
                                                   inputBrand.setText("");
                                                   inputPrice.setText("");
                                                   inputDescription.setText("");

                                                  }else {
                                                   JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
                                                   // refresh table
                                                   model.setRowCount(0);
                                                   XEM_MON_AN kh_xem_mon_an = new XEM_MON_AN();
                                                   kh_xem_mon_an.KH_XEM_MON_AN(model, maDoiTac, maChiNhanh);

                                                   inputFoodName.setText("");
                                                    inputQuantity.setText("");
                                                    inputBrand.setText("");
                                                    inputPrice.setText("");
                                                    inputDescription.setText("");
                                               }


                                           }
                                       }
        );



        buttonDelete = new JButton("Xóa");
        buttonDelete.setForeground(Color.WHITE);
        buttonDelete.setBackground(new Color(1, 119, 219));
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tableFoodList.getSelectedRow();
                String maMonAn = tableFoodList.getValueAt(row, 0).toString();

                XOA_MON_AN callStoredProcedure = new XOA_MON_AN();
                int sta = callStoredProcedure.XOA_MON_AN(maDoiTac, maMonAn, maChiNhanh);
                if (sta == 1) {
                    JOptionPane.showMessageDialog(null, "Xóa thành công");
                    // refresh table
                    model.setRowCount(0);
                    XEM_MON_AN kh_xem_mon_an = new XEM_MON_AN();
                    kh_xem_mon_an.KH_XEM_MON_AN(model, maDoiTac, maChiNhanh);

                } else {
                    JOptionPane.showMessageDialog(null, "Xóa thất bại");
                    // refresh table
                    model.setRowCount(0);
                    XEM_MON_AN kh_xem_mon_an = new XEM_MON_AN();
                    kh_xem_mon_an.KH_XEM_MON_AN(model, maDoiTac, maChiNhanh);

                    inputFoodName.setText("");
                    inputQuantity.setText("");
                    inputBrand.setText("");
                    inputPrice.setText("");
                    inputDescription.setText("");
                }

            }
        });

//        buttonSave = new JButton("Lưu");

        jPanelBodyBottom.add(buttonBack);
        jPanelBodyBottom.add(buttonAdd);
        jPanelBodyBottom.add(buttonUpdate);
        jPanelBodyBottom.add(buttonDelete);
//        jPanelBodyBottom.add(buttonSave);

        jPanelBody.add(jPanelBodyTop, BorderLayout.NORTH);
        jPanelBody.add(new JScrollPane(tableFoodList), BorderLayout.CENTER);
        jPanelBody.add(jPanelBodyBottom, BorderLayout.SOUTH);

        this.add(jPanelHeader, BorderLayout.NORTH);
        this.add(jPanelBody, BorderLayout.CENTER);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String strAction = e.getActionCommand();
        if (strAction.equals("Quay lại")) {
            new ChiNhanh_AdminView(MaDoiTac, MaTaiKhoan).createAndShowGUI(MaDoiTac,MaTaiKhoan);
            this.dispose();
        }
    }
}
