package Assignment2.View;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import Assignment2.Controller.Controller;

public class UpdateData extends JFrame {
    private int updatedID;
    JFrame window = new JFrame("Student Input");

    JLabel lNim = new JLabel("NIM");
    JTextField fNim = new JTextField();

    JLabel lName = new JLabel("NAME");
    JTextField fName = new JTextField();

    JLabel lAge = new JLabel("AGE");
    JTextField fAge = new JTextField();

    JButton btnUpdate = new JButton("UPDATE");

    JLabel lResult = new JLabel();

    public UpdateData(Controller studentC, int id){
        this.updatedID = id;
        window.setLayout(null);
        window.setSize(500, 200);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        
        window.add(lNim);
        window.add(lName);
        window.add(lAge);
        window.add(lResult);
        window.add(fNim);
        window.add(fName);
        window.add(fAge);
        window.add(btnUpdate);
        
         //LABEL
        lNim.setBounds(5, 35, 120, 20);
        lName.setBounds(5, 60, 120, 20);
        lAge.setBounds(5, 85, 120, 20);
        lResult.setBounds(5, 110, 500, 20);

        
        //TEXTFIELD
        fNim.setBounds(150, 35, 120, 20);
        fName.setBounds(150, 60, 120, 20);
        fAge.setBounds(150, 85, 120, 20);
        
        //BUTTONPANEL
        btnUpdate.setBounds(300, 35, 90, 20);
        
        btnUpdate.addActionListener((e) -> {
            studentC.updateData(updatedID, Integer.parseInt(fNim.getText()), fName.getText(), Integer.parseInt(fAge.getText()));
            lResult.setText("Student with NIM : "+ Integer.parseInt(fNim.getText()) + " Data Updated successfully!");
            window.dispose();
        });
    }}
