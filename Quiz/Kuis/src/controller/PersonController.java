/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Color;

import view.Form;

/**
 *
 * @author ASUS
 */
public class PersonController {
    Form person; //bikin objek dari class form

    //ini constructornya
    public PersonController(Form person){
        this.person = person;

        person.bApply.addActionListener(e-> {
            person.frame.repaint();
            try {
                //declare variable
                String name = person.name.getText();
                String NIM = person.NIM.getText();
                String writingScore = person.writingScore.getText();
                String codingScore = person.codingScore.getText();
                String interviewScore = person.interviewScore.getText();
                String division = "";
                division = person.android.isSelected() ? "Android Developer" : "Web Developer";
                
                //error handling cek smua field dah diisi atau blm
                if(name.isEmpty() || NIM.isEmpty() || writingScore.isEmpty() || codingScore.isEmpty() || interviewScore.isEmpty()){
                    person.output.setText("All Fields Must Be Filled");
                } 
                // kalau udah diisi semua
                else { 
                    //declare variable skor nya jadi double
                    Double writing = Double.parseDouble(writingScore);
                    Double coding = Double.parseDouble(codingScore);
                    Double interview = Double.parseDouble(interviewScore);
                    
                    // Error handling cek skor angka or not
                    if (!isNumeric(writingScore) || !isNumeric(codingScore) || !isNumeric(interviewScore)) {
                        throw new NumberFormatException("Scores must be numeric");
                    }
                    // Error handling cek skor 0-100 ga
                    if(writing < 0 || writing > 100 || coding < 0 || coding > 100 || interview < 0 || interview > 100){
                        person.output.setText("Scores must be between 0 and 100");
                    } 
                    // kalau skor 0-100
                    else {
                        //cek divisi nya kaalau android
                        if(division.equals("Android Developer")){
                            Double weightWriting = writing * 0.2;
                            Double weightCoding = coding * 0.5;
                            Double weightInterview = interview * 0.3;
                            Double average = (weightWriting + weightCoding + weightInterview);
                            if(average >= 85){
                                person.output.setForeground(Color.green);
                                person.output.setText("ACCEPTED!, Congratulations ");
                                person.outputDetail.setText(name + "(" + NIM + ")" + " you are accepted as an " + division);
                            } else {
                                person.output.setForeground(Color.red);
                                person.output.setText("NOT ACCEPTED!, Sorry ");
                                person.outputDetail.setText(name + "(" + NIM + ")" + " you are not accepted as an " + division);
                            }
                        } 
                        //cek divisi nya kaalau web
                        else if(division.equals("Web Developer")){
                            Double weightWriting = writing * 0.4;
                            Double weightCoding = coding * 0.35;
                            Double weightInterview = interview * 0.25;
                            Double average = (weightWriting + weightCoding + weightInterview);
                            if(average >= 85){
                                person.output.setForeground(Color.green);
                                person.output.setText("ACCEPTED!, Congratulations ");
                                person.outputDetail.setText(name + "(" + NIM + ")" + " you are accepted as a " + division);
                            } else {
                                person.output.setForeground(Color.red);
                                person.output.setText("NOT ACCEPTED!, Sorry ");
                                person.outputDetail.setText(name + "(" + NIM + ")" + " you are not accepted as a " + division);
                            }
                        }
                    }
                }
            }
            //catch kalo ada error skor bukan numeric
            catch (NumberFormatException ex) {
                person.output.setText("Scores must be numeric");
            }
        });
    }
    
    // Method untuk error hadnling cek skor angka or not
    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}