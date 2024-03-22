/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author ASUS
 */
public class Form extends JFrame{

    //declare variable
    public JFrame frame = new JFrame("Internship Registration Form");
    JLabel title = new JLabel("REGISTRATION FORM");
    public JTextField name = new JTextField();
    public JTextField NIM = new JTextField();
    public JTextField writingScore = new JTextField();
    public JTextField codingScore = new JTextField();
    public JTextField interviewScore = new JTextField();
    public JLabel output = new JLabel();
    public JLabel outputDetail = new JLabel();

    JLabel labelName = new JLabel("Nama");
    JLabel labelNIM = new JLabel("NIM");
    JLabel labelWritingScore = new JLabel("Writing Score");
    JLabel labelCodingScore = new JLabel("Coding Score");
    JLabel labelInterviewScore = new JLabel("Interview Score");
    public JRadioButton android = new JRadioButton("Android Developer");
    public JRadioButton web = new JRadioButton("Web Developer"); 
    ButtonGroup division = new ButtonGroup();
    public JButton bApply = new JButton("APPLY");

    //ini constructornya
    public Form(){
        //opening template dari catatan
        frame.setTitle("Enrollment Software Development Internship");
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        //add semua var nya ke frame
        division.add(android);
        division.add(web);
        android.setSelected(true);

        frame.add(title);
        frame.add(labelName);
        frame.add(labelNIM);
        frame.add(labelWritingScore);
        frame.add(labelCodingScore);
        frame.add(labelInterviewScore);
        frame.add(name);
        frame.add(NIM);
        frame.add(writingScore);
        frame.add(codingScore);
        frame.add(interviewScore);
        frame.add(android);
        frame.add(web);
        frame.add(bApply);
        frame.add(output);
        frame.add(outputDetail);

        //set posisi sama ukuran nya
        title.setFont(new Font("Arial", Font.BOLD, 26));
        labelName.setFont(new Font("Arial", Font.BOLD, 16));
        labelNIM.setFont(new Font("Arial", Font.BOLD, 16));
        labelCodingScore.setFont(new Font("Arial", Font.BOLD, 16));
        labelWritingScore.setFont(new Font("Arial", Font.BOLD, 16));
        labelInterviewScore.setFont(new Font("Arial", Font.BOLD, 16));
        name.setFont(new Font("Arial", Font.BOLD, 16));
        NIM.setFont(new Font("Arial", Font.BOLD, 16));
        writingScore.setFont(new Font("Arial", Font.BOLD, 24));
        codingScore.setFont(new Font("Arial", Font.BOLD, 24));
        interviewScore.setFont(new Font("Arial", Font.BOLD, 24));
        android.setFont(new Font("Arial", Font.BOLD, 16));
        web.setFont(new Font("Arial", Font.BOLD, 16));
        bApply.setFont(new Font("Arial", Font.BOLD, 30));
        output.setFont(new Font("Arial", Font.BOLD, 24));
        outputDetail.setFont(new Font("Arial", Font.BOLD, 15));

        title.setBounds(150, 15, 350, 20);
        labelName.setFont(new Font("Arial", Font.BOLD, 16));

        labelName.setBounds(35, 45, 50, 50);
        labelNIM.setBounds(35, 85, 50, 50);
        name.setBounds(85, 55, 250, 35);
        NIM.setBounds(85, 95, 250, 35);
        
        labelWritingScore.setBounds(400, 35, 150, 50);
        writingScore.setBounds(400, 75, 150, 50);
        labelCodingScore.setBounds(400, 125, 150, 50);
        codingScore.setBounds(400, 165, 150, 50);
        labelInterviewScore.setBounds(400, 215, 150, 50);
        interviewScore.setBounds(400, 255, 150, 50);
        
        android.setBounds(35, 135, 250, 65);
        web.setBounds(35, 185, 250, 65);

        bApply.setBounds(35, 250, 200, 50);
        output.setBounds(25, 400, 550, 50);
        outputDetail.setBounds(10, 450, 550, 50);
    }
}
