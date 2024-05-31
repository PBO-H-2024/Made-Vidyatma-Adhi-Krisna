package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Controller.Controller;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MainView {
    //controller
    Controller controller = new Controller();
    String data[][] = new String[100][4];

    //declare variable
    public JFrame frame = new JFrame("Internship Registration Form");
    JLabel title = new JLabel("RECRUITMENT DATA");
    public JTextField name = new JTextField();
    public JTextField writingScore = new JTextField();
    public JTextField codingScore = new JTextField();
    public JTextField interviewScore = new JTextField();
    JLabel labelName = new JLabel("Nama");
    JLabel labelWritingScore = new JLabel("Writing Score");
    JLabel labelCodingScore = new JLabel("Coding Score");
    JLabel labelInterviewScore = new JLabel("Interview Score");
    JLabel pathLabel = new JLabel("Path");

    //jcombobox
    String[] pathList = { "Android Developer", "Web Developer" };
    @SuppressWarnings({ "rawtypes", "unchecked" })
    JComboBox paths = new JComboBox(pathList);

    public JButton bAdd = new JButton("ADD");
    public JButton bUpdate = new JButton("UPDATE");
    public JButton bDelete = new JButton("DELETE");
    public JButton bClear = new JButton("CLEAR");

    //tablenya
    JTable tableData;
    DefaultTableModel tableModel;
    JScrollPane sp;
    Object columnName[] = {
            "Name", "Path", "Writing", "Coding", "Interview", "Score"
    };

    //ini constructornya
    public MainView(){
        //opening template 
        frame.setTitle("DATA RECRUITMENT");
        frame.setSize(1000, 1000);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        //set table
        tableModel = new DefaultTableModel(columnName, 0);
        tableData = new JTable(tableModel);
        sp = new JScrollPane(tableData);
        
        addComponents();
        setComponents();
        initComponents();

         tableData.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = tableData.getSelectedRow();
                String nameSelected = tableData.getValueAt(row, 0).toString();
                String pathSelected = tableData.getValueAt(row, 1).toString();
                String writeSelected = tableData.getValueAt(row, 2).toString();
                String codingSelected = tableData.getValueAt(row, 3).toString();
                String interviewSelected = tableData.getValueAt(row, 4).toString();
                name.setText(nameSelected);
                writingScore.setText(writeSelected);
                codingScore.setText(codingSelected);
                interviewScore.setText(interviewSelected);
                name.setEnabled(false);
                if(pathSelected == "Android Developer")  paths.setSelectedIndex(0);
                else paths.setSelectedIndex(1);
                
               
            }
        });


        bAdd.addActionListener((e) -> {
            System.out.println("PRessed");
            controller.insertData(name.getText(), paths.getSelectedItem().toString(), writingScore.getText(), codingScore.getText(), interviewScore.getText());
        });
        bUpdate.addActionListener((e) -> {
            controller.updateData(name.getText(), paths.getSelectedItem().toString(), writingScore.getText(), codingScore.getText(), interviewScore.getText());
        });
        bDelete.addActionListener((e) -> {
            controller.deleteData(name.getText());
        });
        bClear.addActionListener((e) -> {
            name.setEnabled(true);
            name.setText("");
            writingScore.setText("");
            codingScore.setText("");
            interviewScore.setText("");
            data = controller.readData();
            tableData.setModel((new JTable(data, columnName)).getModel());
        });
    }

    private void addComponents(){
        //add semua var nya ke frame
        frame.add(title);
        frame.add(labelName);
        frame.add(labelWritingScore);
        frame.add(labelCodingScore);
        frame.add(labelInterviewScore);
        frame.add(name);
        frame.add(pathLabel);
        frame.add(writingScore);
        frame.add(codingScore);
        frame.add(interviewScore);
        frame.add(bAdd);
        frame.add(bUpdate);
        frame.add(bDelete);
        frame.add(bClear);
        frame.add(paths);
        //add tabel
        frame.add(sp);
    }

    private void setComponents(){
        //set posisi sama ukuran nya
        title.setFont(new Font("Arial", Font.BOLD, 26));
        labelName.setFont(new Font("Arial", Font.BOLD, 16));
        labelCodingScore.setFont(new Font("Arial", Font.BOLD, 16));
        labelWritingScore.setFont(new Font("Arial", Font.BOLD, 16));
        labelInterviewScore.setFont(new Font("Arial", Font.BOLD, 16));

        name.setFont(new Font("Arial", Font.BOLD, 16));
        writingScore.setFont(new Font("Arial", Font.BOLD, 24));
        codingScore.setFont(new Font("Arial", Font.BOLD, 24));
        interviewScore.setFont(new Font("Arial", Font.BOLD, 24));
        bAdd.setFont(new Font("Arial", Font.BOLD, 18));
        bUpdate.setFont(new Font("Arial", Font.BOLD, 18));
        bDelete.setFont(new Font("Arial", Font.BOLD, 18));
        bClear.setFont(new Font("Arial", Font.BOLD, 18));

        labelName.setFont(new Font("Arial", Font.BOLD, 16));
        title.setBounds(150, 15, 350, 20);

        labelName.setBounds(800, 35, 150, 50);
        name.setBounds(800, 75, 150, 50);
        
        pathLabel.setBounds(800, 125, 150, 50);
        paths.setBounds(800, 165, 150, 50);

        labelWritingScore.setBounds(800, 215, 150, 50);
        writingScore.setBounds(800, 255, 150, 50);


        labelCodingScore.setBounds(800, 305, 150, 50);
        codingScore.setBounds(800, 345, 150, 50);

        labelInterviewScore.setBounds(800, 395, 150, 50);
        interviewScore.setBounds(800, 435, 150, 50);
        
        bAdd.setBounds(800, 495, 150, 50);
        bUpdate.setBounds(800, 550, 150, 50);
        bDelete.setBounds(800, 610, 150, 50);
        bClear.setBounds(800, 685, 150, 50);

        sp.setBounds(20, 60, 750, 750);
    }

    

    void initComponents(){
        System.out.println("TES");
        data = controller.readData();
        tableData.setModel((new JTable(data, columnName)).getModel());
    }

  

   
}
