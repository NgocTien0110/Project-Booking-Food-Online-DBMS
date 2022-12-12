package View;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ChiNhanh_AdminView extends JPanel {
    private JComboBox status;
    private JTextField searchField;
    private JTextField name;
    private JTextField timeClose;
    private JTextField phone;
    private JTextField address;
    private JTextField timeOpen;
    private JButton btnBack;
    private JButton btnViewListFood;
    private JButton btnSearch;
    private JTable table;
    private JButton btnAdd;
    private JButton btnEdit;
    private JButton btnDelete;
    private JButton btnSave;
    public ChiNhanh_AdminView()
    {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1200, 600));
        JLabel title=new JLabel("Danh sách chi nhánh");
        title.setForeground(new Color(1, 119, 219));
        title.setFont(new Font("Arial", Font.BOLD, 25));
        searchField=new JTextField(15);
        btnSearch=new JButton("Tìm kiếm");
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setBackground(new Color(1, 119, 219));
        btnSearch.setFont(new Font("Arial", Font.BOLD, 15));
        JPanel searchPanel=new JPanel();
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.X_AXIS));
        searchPanel.add(searchField);
        searchPanel.add(btnSearch);
        JPanel topPanel=new JPanel();
        topPanel.add(title);
        topPanel.add(Box.createRigidArea(new Dimension(250, 50)));
        topPanel.add(searchPanel);
        topPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        JLabel name_label=new JLabel("Tên chi nhánh:");
        name_label.setFont(new Font("Arial", Font.BOLD, 15));
        name_label.setForeground(new Color(1, 119, 219));
        name=new JTextField(10);
        name.setEditable(false);
        JPanel namePanel=new JPanel();
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.Y_AXIS));
        namePanel.add(name_label);
        namePanel.add(name);
        JLabel close_label=new JLabel("Thời gian đóng cửa:");
        close_label.setFont(new Font("Arial", Font.BOLD, 15));
        close_label.setForeground(new Color(1, 119, 219));
        timeClose=new JTextField(10);
        timeClose.setEditable(false);
        JPanel closePanel=new JPanel();
        closePanel.setLayout(new BoxLayout(closePanel, BoxLayout.Y_AXIS));
        closePanel.add(close_label);
        closePanel.add(timeClose);
        JLabel phone_label=new JLabel("Số điện thoại:");
        phone_label.setFont(new Font("Arial", Font.BOLD, 15));
        phone_label.setForeground(new Color(1, 119, 219));
        phone=new JTextField(10);
        phone.setEditable(false);
        JPanel phonePanel=new JPanel();
        phonePanel.setLayout(new BoxLayout(phonePanel, BoxLayout.Y_AXIS));
        phonePanel.add(phone_label);
        phonePanel.add(phone);
        JLabel address_label=new JLabel("Địa chỉ:");
        address_label.setFont(new Font("Arial", Font.BOLD, 15));
        address_label.setForeground(new Color(1, 119, 219));
        address=new JTextField(10);
        address.setEditable(false);
        JPanel addressPanel=new JPanel();
        addressPanel.setLayout(new BoxLayout(addressPanel, BoxLayout.Y_AXIS));
        addressPanel.add(address_label);
        addressPanel.add(address);
        JLabel timeOpen_label=new JLabel("Thời gian mở cửa:");
        timeOpen_label.setFont(new Font("Arial", Font.BOLD, 15));
        timeOpen_label.setForeground(new Color(1, 119, 219));
        timeOpen=new JTextField(10);
        timeOpen.setEditable(false);
        JPanel timeOpenPanel=new JPanel();
        timeOpenPanel.setLayout(new BoxLayout(timeOpenPanel, BoxLayout.Y_AXIS));
        timeOpenPanel.add(timeOpen_label);
        timeOpenPanel.add(timeOpen);
        JLabel status_label=new JLabel("Trạng thái:");
        status_label.setFont(new Font("Arial", Font.BOLD, 15));
        status_label.setForeground(new Color(1, 119, 219));
        status=new JComboBox();
        status.addItem("Đang hoạt động");
        status.addItem("Đóng cửa");
        JPanel statusPanel=new JPanel();
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.Y_AXIS));
        statusPanel.add(status_label);
        statusPanel.add(status);
        JPanel infoPanel=new JPanel();
        infoPanel.setLayout(new GridLayout(2, 3, 60, 20));
        infoPanel.add(namePanel);
        infoPanel.add(phonePanel);
        infoPanel.add(addressPanel);
        infoPanel.add(timeOpenPanel);
        infoPanel.add(closePanel);
        infoPanel.add(statusPanel);

        btnBack=new JButton("Quay lại");
        btnBack.setForeground(Color.WHITE);
        btnBack.setBackground(new Color(1, 119, 219));
        btnBack.setFont(new Font("Arial", Font.BOLD, 15));
        btnViewListFood=new JButton("Xem danh sách món ăn");
        btnViewListFood.setForeground(Color.WHITE);
        btnViewListFood.setBackground(new Color(1, 119, 219));
        btnViewListFood.setFont(new Font("Arial", Font.BOLD, 15));
        JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.CENTER, 200, 20));
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
        table.setPreferredScrollableViewportSize(new Dimension(1150, 300));
        table.setFillsViewportHeight(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setRowSelectionAllowed(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // insert data to table
        DefaultTableModel model = new DefaultTableModel();
        Object[] column = {"Mã chi nhánh","Mã đối tác","Tên chi nhánh","Địa chỉ","Số điện thoại","Thời gian mở cửa","Thời gian đóng cửa","Trạng thái",
        "Tên ngân hàng","Số tài khoản","Doanh thu tháng"};
        model.setColumnIdentifiers(column);
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        Object [][] row={{"CN0001","DT0001","Chi nhánh 1","254, NVC","09083764","7:00","22:00","Đang hoạt động","Argibank","10203949","2491249"},
        {"CN0002","DT0001","Chi nhánh 2","254, NVC","09083764","7:00","22:00","Đang hoạt động","Argibank","10203949","2491249"},
        {"CN0003","DT0001","Chi nhánh 3","254, NVC","09083764","7:00","22:00","Đang hoạt động","Argibank","10203949","2491249"},
        {"CN0004","DT0001","Chi nhánh 4","254, NVC","09083764","7:00","22:00","Đang hoạt động","Argibank","10203949","2491249"},
        {"CN0005","DT0001","Chi nhánh 5","254, NVC","09083764","7:00","22:00","Đang hoạt động","Argibank","10203949","2491249"},
        {"CN0006","DT0001","Chi nhánh 6","254, NVC","09083764","7:00","22:00","Đang hoạt động","Argibank","10203949","2491249"},
        {"CN0007","DT0001","Chi nhánh 7","254, NVC","09083764","7:00","22:00","Đang hoạt động","Argibank","10203949","2491249"},
        {"CN0008","DT0001","Chi nhánh 8","254, NVC","09083764","7:00","22:00","Đang hoạt động","Argibank","10203949","2491249"},
        {"CN0009","DT0001","Chi nhánh 9","254, NVC","09083764","7:00","22:00","Đang hoạt động","Argibank","10203949","2491249"},
        {"CN0010","DT0001","Chi nhánh 10","254, NVC","09083764","7:00","22:00","Đang hoạt động","Argibank","10203949","2491249"},
        {"CN0011","DT0001","Chi nhánh 11","254, NVC","09083764","7:00","22:00","Đang hoạt động","Argibank","10203949","2491249"},
        {"CN0012","DT0001","Chi nhánh 12","254, NVC","09083764","7:00","22:00","Đang hoạt động","Argibank","10203949","2491249"},
        {"CN0013","DT0001","Chi nhánh 13","254, NVC","09083764","7:00","22:00","Đang hoạt động","Argibank","10203949","2491249"},
        {"CN0014","DT0001","Chi nhánh 14","254, NVC","09083764","7:00","22:00","Đang hoạt động","Argibank","10203949","2491249"},
        {"CN0015","DT0001","Chi nhánh 15","254, NVC","09083764","7:00","22:00","Đang hoạt động","Argibank","10203949","2491249"},
        {"CN0016","DT0001","Chi nhánh 16","254, NVC","09083764","7:00","22:00","Đang hoạt động","Argibank","10203949","2491249"},
        {"CN0017","DT0001","Chi nhánh 17","254, NVC","09083764","7:00","22:00","Đang hoạt động","Argibank","10203949","2491249"},
        {"CN0018","DT0001","Chi nhánh 18","254, NVC","09083764","7:00","22:00","Đang hoạt động","Argibank","10203949","2491249"},
        {"CN0019","DT0001","Chi nhánh 19","254, NVC","09083764","7:00","22:00","Đang hoạt động","Argibank","10203949","2491249"}};
        for(int i=0; i<row.length; i++){
            model.addRow(row[i]);
        }

        // add table to scrollpane
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        // add scrollpane to frame
        btnAdd=new JButton("Thêm");
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setBackground(new Color(1, 119, 219));
        btnAdd.setFont(new Font("Arial", Font.BOLD, 15));
        btnEdit=new JButton("Cập nhật");
        btnEdit.setForeground(Color.WHITE);
        btnEdit.setBackground(new Color(1, 119, 219));
        btnEdit.setFont(new Font("Arial", Font.BOLD, 15));
        btnDelete=new JButton("Xóa");
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setBackground(new Color(1, 119, 219));
        btnDelete.setFont(new Font("Arial", Font.BOLD, 15));
        btnSave=new JButton("Lưu");
        btnSave.setForeground(Color.WHITE);
        btnSave.setBackground(new Color(1, 119, 219));
        btnSave.setFont(new Font("Arial", Font.BOLD, 15));
        JPanel panelButtonBottom=new JPanel();
        panelButtonBottom.setLayout(new BoxLayout(panelButtonBottom, BoxLayout.X_AXIS));
        panelButtonBottom.add(btnAdd);
        panelButtonBottom.add(Box.createRigidArea(new Dimension(100, 50)));
        panelButtonBottom.add(btnEdit);
        panelButtonBottom.add(Box.createRigidArea(new Dimension(100, 50)));
        panelButtonBottom.add(btnDelete);
        panelButtonBottom.add(Box.createRigidArea(new Dimension(100, 50)));
        panelButtonBottom.add(btnSave);
        JPanel bottom=new JPanel();
        bottom.add(panelButtonBottom);

        JPanel tablePanel=new JPanel();
        tablePanel.add(scroll);
        JPanel centerPanel=new JPanel();
        centerPanel.add(infoPanel);
        centerPanel.add(buttonPanel);
        centerPanel.add(tablePanel);
        add(centerPanel, BorderLayout.CENTER);
        add(bottom, BorderLayout.PAGE_END);
        add(topPanel, BorderLayout.PAGE_START);








        add(topPanel, BorderLayout.PAGE_START);






    }
    public void createAndShowGUI()
    {
        JFrame frame = new JFrame("Danh sách chi nhánh");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel newContentPane = new ChiNhanh_AdminView();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ChiNhanh_AdminView().createAndShowGUI();
            }
        });
    }



}
