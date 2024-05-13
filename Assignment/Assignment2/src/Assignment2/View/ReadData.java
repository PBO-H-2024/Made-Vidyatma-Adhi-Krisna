package Assignment2.View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import Assignment2.Controller.Controller;

public class ReadData extends JFrame {
    public int id, nim, age;
    public String name;
    int totalData;
    String data[][] = new String[100][4];

    JFrame window = new JFrame("Read Data Student");
    JTable table;
    DefaultTableModel tableModel;
    JScrollPane sp;
    Object columnName[] = {
            "id", "nim", "name", "age"
    };

    JButton btnAdd = new JButton("ADD");
    JButton btnRefresh = new JButton("REFRESH");

    public ReadData(Controller studentC) {
        tableModel = new DefaultTableModel(columnName, 0);
        table = new JTable(tableModel);
        sp = new JScrollPane(table);

        window.setLayout(null);
        window.setSize(550, 600);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.add(sp);
        window.add(btnAdd);
        window.add(btnRefresh);

        btnAdd.setBounds(20, 350, 100, 30);
        btnRefresh.setBounds(400, 350, 100, 30);
        sp.setBounds(20, 35, 500, 300);

        data = studentC.readData();
        table.setModel((new JTable(data, columnName)).getModel());
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = table.getSelectedRow();
                int id = Integer.parseInt(table.getValueAt(row, 0).toString());
                String name = table.getValueAt(row, 2).toString();

                int input = JOptionPane.showConfirmDialog(null,
                        "do you want to delete " + name + "?",
                        "Option...",
                        JOptionPane.YES_NO_OPTION);

                if (input == 0) {
                    studentC.deleteData(id);
                } else {
                    input = JOptionPane.showConfirmDialog(null,
                            "do you want to update " + name + "?",
                            "Option...",
                            JOptionPane.YES_NO_OPTION);
                    if (input == 0) {
                        new UpdateData(studentC, id);
                    }
                }
            }
        });

        btnAdd.addActionListener((e) -> {
            new InputData(studentC);
        });
        btnRefresh.addActionListener((e) -> {
            data = studentC.readData();
            table.setModel((new JTable(data, columnName)).getModel());
        });

    }

    //biar otomatis refresh abis add, update or delete data
    // public void refreshTable() {
        
    //     Controller studentC = new Controller();
    //     data = studentC.readData();
    //     table.setModel((new JTable(data, columnName)).getModel());
    // }
}