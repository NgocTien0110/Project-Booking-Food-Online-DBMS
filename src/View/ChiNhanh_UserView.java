package View;

import Model.ChiNhanhModel;
import StoredProcedure.CallStoredProcedure;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Objects;

public class ChiNhanh_UserView extends JPanel {
    private JComboBox status;
    private JTextField madt;
    private JTextField searchField;
    private JTextField name;
    private JTextField macn;
    private JTextField timeClose;
    private JTextField address;
    private JTextField timeOpen;
    private JButton btnBack;
    private JButton btnViewListFood;
    private JButton btnSearch;
    private JTable table;
    private String MaTaiKhoan;

    public ChiNhanh_UserView(String maDT, String maTaiKhoan) {
        MaTaiKhoan = maTaiKhoan;
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1200, 600));
        JLabel title = new JLabel("Danh sách chi nhánh");
        title.setForeground(new Color(1, 119, 219));
        title.setFont(new Font("Arial", Font.BOLD, 25));
        searchField = new JTextField(15);
        btnSearch = new JButton("Tìm kiếm");
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setBackground(new Color(1, 119, 219));
        btnSearch.setFont(new Font("Arial", Font.BOLD, 15));
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.X_AXIS));
        searchPanel.add(searchField);
        searchPanel.add(btnSearch);
        JPanel topPanel = new JPanel();
        topPanel.add(title);
        topPanel.add(Box.createRigidArea(new Dimension(250, 50)));
        topPanel.add(searchPanel);
        topPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        JLabel macn_label=new JLabel("Mã chi nhánh:");
        macn_label.setFont(new Font("Arial", Font.BOLD, 15));
        macn_label.setForeground(new Color(1, 119, 219));
        macn = new JTextField(10);
        macn.setEditable(false);
        JPanel macn_panel = new JPanel();
        macn_panel.setLayout(new BoxLayout(macn_panel, BoxLayout.Y_AXIS));
        macn_panel.add(macn_label);
        macn_panel.add(macn);
        JLabel madt_label=new JLabel("Mã đối tác:");
        madt_label.setFont(new Font("Arial", Font.BOLD, 15));
        madt_label.setForeground(new Color(1, 119, 219));
        madt = new JTextField(10);
        madt.setEditable(false);
        madt.setText(maDT);
        JPanel madt_panel = new JPanel();
        madt_panel.setLayout(new BoxLayout(madt_panel, BoxLayout.Y_AXIS));
        madt_panel.add(madt_label);
        madt_panel.add(madt);
        JLabel name_label = new JLabel("Tên chi nhánh:");
        name_label.setFont(new Font("Arial", Font.BOLD, 15));
        name_label.setForeground(new Color(1, 119, 219));
        name = new JTextField(10);
        name.setEditable(false);
        JPanel namePanel = new JPanel();
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.Y_AXIS));
        namePanel.add(name_label);
        namePanel.add(name);
        JLabel close_label = new JLabel("Thời gian đóng cửa:");
        close_label.setFont(new Font("Arial", Font.BOLD, 15));
        close_label.setForeground(new Color(1, 119, 219));
        timeClose = new JTextField(10);
        timeClose.setEditable(false);
        JPanel closePanel = new JPanel();
        closePanel.setLayout(new BoxLayout(closePanel, BoxLayout.Y_AXIS));
        closePanel.add(close_label);
        closePanel.add(timeClose);
        JLabel phone_label = new JLabel("Số điện thoại:");
        phone_label.setFont(new Font("Arial", Font.BOLD, 15));
        phone_label.setForeground(new Color(1, 119, 219));
        madt = new JTextField(10);
        madt.setEditable(false);
        JPanel phonePanel = new JPanel();
        phonePanel.setLayout(new BoxLayout(phonePanel, BoxLayout.Y_AXIS));
        phonePanel.add(phone_label);
        phonePanel.add(madt);
        JLabel address_label = new JLabel("Địa chỉ:");
        address_label.setFont(new Font("Arial", Font.BOLD, 15));
        address_label.setForeground(new Color(1, 119, 219));
        address = new JTextField(10);
        address.setEditable(false);
        JPanel addressPanel = new JPanel();
        addressPanel.setLayout(new BoxLayout(addressPanel, BoxLayout.Y_AXIS));
        addressPanel.add(address_label);
        addressPanel.add(address);
        JLabel timeOpen_label = new JLabel("Thời gian mở cửa:");
        timeOpen_label.setFont(new Font("Arial", Font.BOLD, 15));
        timeOpen_label.setForeground(new Color(1, 119, 219));
        timeOpen = new JTextField(10);
        timeOpen.setEditable(false);
        JPanel timeOpenPanel = new JPanel();
        timeOpenPanel.setLayout(new BoxLayout(timeOpenPanel, BoxLayout.Y_AXIS));
        timeOpenPanel.add(timeOpen_label);
        timeOpenPanel.add(timeOpen);
        JLabel status_label = new JLabel("Trạng thái:");
        status_label.setFont(new Font("Arial", Font.BOLD, 15));
        status_label.setForeground(new Color(1, 119, 219));
        status = new JComboBox();
        status.addItem("Tất cả");
        status.addItem("Đang hoạt động");
        status.addItem("Đóng cửa");
        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.Y_AXIS));
        statusPanel.add(status_label);
        statusPanel.add(status);
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(2, 3, 60, 20));
        infoPanel.add(macn_panel);
        infoPanel.add(namePanel);
        infoPanel.add(addressPanel);
        infoPanel.add(timeOpenPanel);
        infoPanel.add(closePanel);
        infoPanel.add(statusPanel);

        btnBack = new JButton("Quay lại");
        btnBack.setForeground(Color.WHITE);
        btnBack.setBackground(new Color(1, 119, 219));
        btnBack.setFont(new Font("Arial", Font.BOLD, 15));
        btnViewListFood = new JButton("Xem danh sách món ăn");
        btnViewListFood.setForeground(Color.WHITE);
        btnViewListFood.setBackground(new Color(1, 119, 219));
        btnViewListFood.setFont(new Font("Arial", Font.BOLD, 15));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 200, 20));
        buttonPanel.add(btnBack);
        buttonPanel.add(btnViewListFood);
        table = new JTable();
        table.setRowHeight(30);
        table.setFont(new Font("Arial", Font.PLAIN, 15));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
        table.getTableHeader().setForeground(new Color(1, 119, 216));
        table.getTableHeader().setBackground(new Color(255, 255, 255));
        table.getTableHeader().setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        table.setShowGrid(false);
        table.setShowVerticalLines(true);
        table.setShowHorizontalLines(true);
        table.setGridColor(new Color(1, 119, 216));
        table.setSelectionBackground(new Color(1, 119, 216));
        table.setSelectionForeground(new Color(255, 255, 255));
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);
        table.setCellSelectionEnabled(false);
        table.setDragEnabled(false);
        table.setFillsViewportHeight(true);
        table.setPreferredScrollableViewportSize(new Dimension(800, 300));
        table.setFillsViewportHeight(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setRowSelectionAllowed(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // insert data to table
        DefaultTableModel model = new DefaultTableModel();
        Object[] column = {"Mã chi nhánh","Tên chi nhánh", "Mã đối tác", "Địa chỉ", "Thời gian mở cửa", "Thời gian đóng cửa", "Trạng thái"};
        model.setColumnIdentifiers(column);
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        CallStoredProcedure call = new CallStoredProcedure();
        call.ESP_XemDanhSachChiNhanhUser(model, maDT);
        // add table to scrollpane
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        // add scrollpane to frame


        JPanel tablePanel = new JPanel();
        tablePanel.add(scroll);
        JPanel centerPanel = new JPanel();
        centerPanel.add(infoPanel);
        centerPanel.add(buttonPanel);
        centerPanel.add(tablePanel);
        add(centerPanel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.PAGE_START);

        // xử lý sự kiện
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = table.getSelectedRow();
                macn.setText(model.getValueAt(i, 0).toString());
                name.setText(model.getValueAt(i, 1).toString());
                address.setText(model.getValueAt(i, 3).toString());
                timeOpen.setText(model.getValueAt(i, 4).toString());
                timeClose.setText(model.getValueAt(i, 5).toString());
            }
        });
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DoiTac_UserView(MaTaiKhoan);
                Window win = SwingUtilities.getWindowAncestor(ChiNhanh_UserView.this);
                win.dispose();
            }
        });
        // Jcombobox
        status.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Objects.requireNonNull(status.getSelectedItem()).toString().equals("Tất cả")) {
                    model.setRowCount(0);
                    CallStoredProcedure call = new CallStoredProcedure();
                    call.ESP_XemDanhSachChiNhanhUser(model, maDT);
                } else if (status.getSelectedItem().toString().equals("Đang hoạt động")) {
                    model.setRowCount(0);
                    CallStoredProcedure call = new CallStoredProcedure();
                    call.sp_TimKiemChiNhanhHD(model, maDT,"Đang hoạt động");

                } else if (status.getSelectedItem().toString().equals("Đóng cửa")) {
                    model.setRowCount(0);
                    CallStoredProcedure call = new CallStoredProcedure();
                    call.sp_TimKiemChiNhanhHD(model, maDT,"Đóng cửa");
                }
            }
        });
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DoiTac_UserView(MaTaiKhoan).createAndShowGUI(MaTaiKhoan);
                Window win = SwingUtilities.getWindowAncestor(ChiNhanh_UserView.this);
                win.dispose();
            }
        });
        btnViewListFood.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (macn.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn chi nhánh");
                } else {
                    new FoodListForCustomersView(maDT,macn.getText(), MaTaiKhoan);
                    Window win = SwingUtilities.getWindowAncestor(ChiNhanh_UserView.this);
                    win.dispose();
                }
            }
        });

    }

    public void createAndShowGUI(String maDT, String maTaiKhoan) {
        JFrame frame = new JFrame("Danh sách chi nhánh");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel newContentPane = new ChiNhanh_UserView(maDT, maTaiKhoan);
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }

}
// chi nhanh user