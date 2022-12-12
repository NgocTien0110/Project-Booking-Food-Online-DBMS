package View;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DoiTac_UserView extends JPanel {
    private JTextField searchField;
    private JTextField name;
    private JTextField email;
    private JTextField phone;
    private JTextField address;
    private JTextField amountCN;
    private JButton btnBack;
    private JButton btnViewListCN;
    private JButton btnSearch;
    private JTable table;
    public DoiTac_UserView()
    {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1200, 600));
        JLabel title=new JLabel("Danh sách đối tác");
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
        JLabel name_label=new JLabel("Tên đối tác:");
        name_label.setFont(new Font("Arial", Font.BOLD, 15));
        name_label.setForeground(new Color(1, 119, 219));
        name=new JTextField(10);
        name.setEditable(false);
        JPanel namePanel=new JPanel();
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.Y_AXIS));
        namePanel.add(name_label);
        namePanel.add(name);
        JLabel email_label=new JLabel("Email:");
        email_label.setFont(new Font("Arial", Font.BOLD, 15));
        email_label.setForeground(new Color(1, 119, 219));
        email=new JTextField(10);
        email.setEditable(false);
        JPanel emailPanel=new JPanel();
        emailPanel.setLayout(new BoxLayout(emailPanel, BoxLayout.Y_AXIS));
        emailPanel.add(email_label);
        emailPanel.add(email);
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
        JLabel amountCN_label=new JLabel("Số lượng chi nhánh:");
        amountCN_label.setFont(new Font("Arial", Font.BOLD, 15));
        amountCN_label.setForeground(new Color(1, 119, 219));
        amountCN=new JTextField(10);
        amountCN.setEditable(false);
        JPanel amountCNPanel=new JPanel();
        amountCNPanel.setLayout(new BoxLayout(amountCNPanel, BoxLayout.Y_AXIS));
        amountCNPanel.add(amountCN_label);
        amountCNPanel.add(amountCN);
        JPanel infoPanel=new JPanel();
        infoPanel.setLayout(new GridLayout(2, 3, 60, 20));
        infoPanel.add(namePanel);
        infoPanel.add(emailPanel);
        infoPanel.add(phonePanel);
        infoPanel.add(addressPanel);
        infoPanel.add(amountCNPanel);

        btnBack=new JButton("Quay lại");
        btnBack.setForeground(Color.WHITE);
        btnBack.setBackground(new Color(1, 119, 219));
        btnBack.setFont(new Font("Arial", Font.BOLD, 15));
        btnViewListCN=new JButton("Xem danh sách chi nhánh");
        btnViewListCN.setForeground(Color.WHITE);
        btnViewListCN.setBackground(new Color(1, 119, 219));
        btnViewListCN.setFont(new Font("Arial", Font.BOLD, 15));
        JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.CENTER, 200, 20));
        buttonPanel.add(btnBack);
        buttonPanel.add(btnViewListCN);
        table = new JTable();
        table.setRowHeight(30);
        table.setFont(new Font("Arial", Font.PLAIN, 15));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
        table.getTableHeader().setForeground(new Color(1, 119, 219));
        table.getTableHeader().setBackground(new Color(255, 255, 255));
        table.getTableHeader().setPreferredSize(new Dimension(100, 40));
        table.setRowHeight(30);
        table.setShowGrid(true);
        table.setGridColor(new Color(1, 119, 219));
        table.setSelectionBackground(new Color(1, 119, 219));
        table.setSelectionForeground(new Color(255, 255, 255));
        table.setRowMargin(0);
        table.setShowVerticalLines(true);
        table.setShowHorizontalLines(true);
        table.setFillsViewportHeight(true);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);
        table.setCellSelectionEnabled(false);
        table.setAutoCreateRowSorter(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setPreferredScrollableViewportSize(new Dimension(1000, 300));
        table.setFillsViewportHeight(true);
        // select all rows
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // insert data to table
        DefaultTableModel model = new DefaultTableModel();
        Object[] column = {"Tên đối tác", "SL chi nhánh", "Email", "Số điện thoại","Địa chỉ"};
        model.setColumnIdentifiers(column);
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        // insert data to table
//        Object [] row = new Object[5];
//        for(int i=0; i<listPartner.size(); i++){
//            row[0]=listPartner.get(i).getName();
//            row[1]=listPartner.get(i).getAmountCN();
//            row[2]=listPartner.get(i).getEmail();
//            row[3]=listPartner.get(i).getPhone();
//            row[4]=listPartner.get(i).getAddress();
//            model.addRow(row);
//        }
        Object [][] row={{"Mixi food", "2", "mixi@gmail.com", "0123456789", "Hà Nội"},{"Mixi food", "2", "mixi@gmail.com", "0123456789", "Hà Nội"},{"Mixi food", "2", "mixi@gmail.com", "0123456789", "Hà Nội"},{"Mixi food", "2", "mixi@gmail.com", "0123456789", "Hà Nội"},{"Mixi food", "2", "mixi@gmail.com", "0123456789", "Hà Nội"},{"Mixi food", "2", "mixi@gmail.com", "0123456789", "Hà Nội"},{"Mixi food", "2", "mixi@gmail.com", "0123456789", "Hà Nội"},{"Mixi food", "2", "mixi@gmail.com", "0123456789", "Hà Nội"},{"Mixi food", "2", "mixi@gmail.com", "0123456789", "Hà Nội"},{"Mixi food", "2", "mixi@gmail.com", "0123456789", "Hà Nội"},{"Mixi food", "2", "mixi@gmail.com", "0123456789", "Hà Nội"},{"Mixi food", "2", "mixi@gmail.com", "0123456789", "Hà Nội"},{"Mixi food", "2", "mixi@gmail.com", "0123456789", "Hà Nội"},{"Mixi food", "2", "mixi@gmail.com", "0123456789", "Hà Nội"},{"Mixi food", "2", "mixi@gmail.com", "0123456789", "Hà Nội"},{"M-TP", "5", "mtp@gmail.com","9588242", "Sài gòn"},{"BTS", "3", "bts@gmail.com", "0123456789", "Hàn Quốc"}};
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


        JPanel tablePanel=new JPanel();
        tablePanel.add(scroll);
        JPanel centerPanel=new JPanel();
        centerPanel.add(infoPanel);
        centerPanel.add(buttonPanel);
        centerPanel.add(tablePanel);
        add(centerPanel, BorderLayout.CENTER);








        add(topPanel, BorderLayout.PAGE_START);






    }
    public void createAndShowGUI()
    {
        JFrame frame = new JFrame("DT_User");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel newContentPane = new DoiTac_UserView();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }



}
