package View;
import StoredProcedure.CallStoredProcedure;

import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DoiTac_AdminView extends JPanel {
    private JTextField searchField;
    private JTextField madt;
    private JTextField sldon;
    private JTextField mst;
    private JTextField doanhthu;
    private JTextField name;
    private JTextField email;
    private JTextField phone;
    private JTextField address;
    private JTextField amountCN;
    private JButton btnBack;
    private JButton btnViewListCN;
    private JButton btnSearch;
    private JButton btnAdd;
    private JButton btnEdit;
    private JButton btnDelete;
    private JButton btnSave;
    private JTable table;
    public DoiTac_AdminView()
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
        JPanel namePanel=new JPanel();
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.Y_AXIS));
        namePanel.add(name_label);
        namePanel.add(name);
        JLabel email_label=new JLabel("Email:");
        email_label.setFont(new Font("Arial", Font.BOLD, 15));
        email_label.setForeground(new Color(1, 119, 219));
        email=new JTextField(10);
        JPanel emailPanel=new JPanel();
        emailPanel.setLayout(new BoxLayout(emailPanel, BoxLayout.Y_AXIS));
        emailPanel.add(email_label);
        emailPanel.add(email);
        JLabel phone_label=new JLabel("Số điện thoại:");
        phone_label.setFont(new Font("Arial", Font.BOLD, 15));
        phone_label.setForeground(new Color(1, 119, 219));
        phone=new JTextField(10);
        JPanel phonePanel=new JPanel();
        phonePanel.setLayout(new BoxLayout(phonePanel, BoxLayout.Y_AXIS));
        phonePanel.add(phone_label);
        phonePanel.add(phone);
        JLabel address_label=new JLabel("Địa chỉ:");
        address_label.setFont(new Font("Arial", Font.BOLD, 15));
        address_label.setForeground(new Color(1, 119, 219));
        address=new JTextField(10);
        JPanel addressPanel=new JPanel();
        addressPanel.setLayout(new BoxLayout(addressPanel, BoxLayout.Y_AXIS));
        addressPanel.add(address_label);
        addressPanel.add(address);
        JLabel amountCN_label=new JLabel("Số lượng chi nhánh:");
        amountCN_label.setFont(new Font("Arial", Font.BOLD, 15));
        amountCN_label.setForeground(new Color(1, 119, 219));
        amountCN=new JTextField(10);
        JPanel amountCNPanel=new JPanel();
        amountCNPanel.setLayout(new BoxLayout(amountCNPanel, BoxLayout.Y_AXIS));
        amountCNPanel.add(amountCN_label);
        amountCNPanel.add(amountCN);
        JPanel slDonPanel=new JPanel();
        slDonPanel.setLayout(new BoxLayout(slDonPanel, BoxLayout.Y_AXIS));
        JLabel slDon_label=new JLabel("Số lượng đơn:");
        slDon_label.setFont(new Font("Arial", Font.BOLD, 15));
        slDon_label.setForeground(new Color(1, 119, 219));
        sldon=new JTextField(10);
        slDonPanel.add(slDon_label);
        slDonPanel.add(sldon);
        JPanel madtPanel=new JPanel();
        madtPanel.setLayout(new BoxLayout(madtPanel, BoxLayout.Y_AXIS));
        JLabel madt_label=new JLabel("Mã đối tác:");
        madt_label.setFont(new Font("Arial", Font.BOLD, 15));
        madt_label.setForeground(new Color(1, 119, 219));
        madt=new JTextField(10);
        madtPanel.add(madt_label);
        madtPanel.add(madt);
        JPanel mstPanel=new JPanel();
        mstPanel.setLayout(new BoxLayout(mstPanel, BoxLayout.Y_AXIS));
        JLabel mst_label=new JLabel("Mã số thuế:");
        mst_label.setFont(new Font("Arial", Font.BOLD, 15));
        mst_label.setForeground(new Color(1, 119, 219));
        mst=new JTextField(10);
        mstPanel.add(mst_label);
        mstPanel.add(mst);
        JPanel doanhthuPanel=new JPanel();
        doanhthuPanel.setLayout(new BoxLayout(doanhthuPanel, BoxLayout.Y_AXIS));
        JLabel doanhthu_label=new JLabel("Doanh thu:");
        doanhthu_label.setFont(new Font("Arial", Font.BOLD, 15));
        doanhthu_label.setForeground(new Color(1, 119, 219));
        doanhthu=new JTextField(10);
        doanhthuPanel.add(doanhthu_label);
        doanhthuPanel.add(doanhthu);

        JPanel infoPanel=new JPanel();
        infoPanel.setLayout(new GridLayout(3, 3, 60, 20));
        infoPanel.add(madtPanel);
        infoPanel.add(namePanel);
        infoPanel.add(amountCNPanel);
        infoPanel.add(slDonPanel);
        infoPanel.add(mstPanel);
        infoPanel.add(emailPanel);
        infoPanel.add(phonePanel);
        infoPanel.add(addressPanel);
        infoPanel.add(doanhthuPanel);



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
        table.setPreferredScrollableViewportSize(new Dimension(1050, 300));
        table.setFillsViewportHeight(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setRowSelectionAllowed(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // insert data to table
        DefaultTableModel model = new DefaultTableModel();
        Object[] column = {"Mã đối tác","Tên đối tác", "SL chi nhánh","SL đơn","Mã số thuế", "Email", "Số điện thoại","Địa chỉ","Doanh thu tháng"};
        model.setColumnIdentifiers(column);
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        CallStoredProcedure call=new CallStoredProcedure();
        call.ESP_XemDanhSachDoiTacAdmin(model);

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

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = table.getSelectedRow();
                madt.setText(model.getValueAt(i, 0).toString());
                name.setText(model.getValueAt(i, 1).toString());
                amountCN.setText(model.getValueAt(i, 2).toString());
                sldon.setText(model.getValueAt(i, 3).toString());
                mst.setText(model.getValueAt(i, 4).toString());
                email.setText(model.getValueAt(i, 5).toString());
                phone.setText(model.getValueAt(i, 6).toString());
                address.setText(model.getValueAt(i, 7).toString());
                doanhthu.setText(model.getValueAt(i, 8).toString());
            }
        });
        btnViewListCN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(madt.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn đối tác cần xem chi nhánh");
                }
                else{
                    Window win = SwingUtilities.getWindowAncestor(DoiTac_AdminView.this);
                    win.dispose();
                    new ChiNhanh_AdminView(madt.getText()).createAndShowGUI(madt.getText());
                }
            }
        });


    }
    public void createAndShowGUI()
    {
        JFrame frame = new JFrame("DT_User");
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel newContentPane = new DoiTac_AdminView();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        //look and feel

        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DoiTac_AdminView().createAndShowGUI();
            }
        });
    }



}
