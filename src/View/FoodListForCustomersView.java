package View;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * View
 * Create by Đặng Ngọc Tiến
 * Date 12/12/2022 - 10:00 AM
 * Description: ...
 */
public class FoodListForCustomersView extends JFrame {
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

    private String[] columnNames = {"ID món", "ID chi nhánh", "Tên món ăn", "Mô tả", "Số lượng", "Giá"};
    private String [][] data = {
            {"1", "1", "Bún bò", "Bún bò ngon", "100", "10000"},
            {"2", "1", "Bún bò", "Bún bò ngon", "200", "10000"},
            {"3", "1", "Bún bò", "Bún bò ngon", "300", "10000"},
            {"4", "1", "Bún bò", "Bún bò ngon", "400", "10000"},
            {"5", "1", "Bún bò", "Bún bò ngon", "100", "10000"},
            {"6", "1", "Bún bò", "Bún bò ngon", "100", "10000"},
            {"7", "1", "Bún bò", "Bún bò ngon", "100", "10000"},
            {"8", "1", "Bún bò", "Bún bò ngon", "100", "10000"},
            {"9", "1", "Bún bò", "Bún bò ngon", "100", "10000"},
            {"10", "1", "Bún bò", "Bún bò ngon", "100", "10000"},
            {"11", "1", "Bún bò", "Bún bò ngon", "100", "10000"},
            {"12", "1", "Bún bò", "Bún bò ngon", "100", "10000"},
            {"13", "1", "Bún bò", "Bún bò ngon", "100", "10000"},
            {"14", "1", "Bún bò", "Bún bò ngon", "100", "10000"},
            {"15", "1", "Bún bò", "Bún bò ngon", "100", "10000"},
            {"16", "1", "Bún bò", "Bún bò ngon", "100", "10000"},
            {"17", "1", "Bún bò", "Bún bò ngon", "100", "10000"}
    };
    public FoodListForCustomersView() {
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
        jPanelFoodName.add(labelFoodName);
        jPanelFoodName.add(inputFoodName);

        JPanel jPanelQuantity = new JPanel(new GridLayout(1, 2, 0, 0));
        JLabel labelQuantity = new JLabel("Số lượng");
        inputQuantity = new JTextField();
        jPanelQuantity.add(labelQuantity);
        jPanelQuantity.add(inputQuantity);

        JPanel jPanelBrand = new JPanel(new GridLayout(1, 2, 0, 0));
        JLabel labelBrand = new JLabel("Nhãn hiệu");
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

        tableFoodList = new JTable(data, columnNames);
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
        tableFoodList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = tableFoodList.getSelectedRow();
                if (row >= 0) {
                    inputFoodName.setText(tableFoodList.getValueAt(row, 2).toString());
                    inputQuantity.setText(tableFoodList.getValueAt(row, 4).toString());
                    inputBrand.setText(tableFoodList.getValueAt(row, 3).toString());
                    inputPrice.setText(tableFoodList.getValueAt(row, 5).toString());
                    inputDescription.setText(tableFoodList.getValueAt(row, 3).toString());
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(tableFoodList);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        scrollPane.getViewport().setBackground(new Color(255, 255, 255));
        scrollPane.getViewport().setOpaque(true);

        JPanel jPanelBodyBottom = new JPanel(new GridLayout(1, 2, 150, 0));
        jPanelBodyBottom.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        buttonAdd = new JButton("Thêm");
        buttonBack = new JButton("Quay lại");

        jPanelBodyBottom.add(buttonAdd);
        jPanelBodyBottom.add(buttonBack);



        jPanelBody.add(jPanelBodyTop, BorderLayout.NORTH);
        jPanelBody.add(scrollPane, BorderLayout.CENTER);
        jPanelBody.add(jPanelBodyBottom, BorderLayout.SOUTH);


        this.add(jPanelHeader, BorderLayout.NORTH);
        this.add(jPanelBody, BorderLayout.CENTER);


        this.setVisible(true);

    }

    public static void main(String[] args) {
        new FoodListForCustomersView();
    }
}
