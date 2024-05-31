package Controller;

import javax.swing.JOptionPane;

import Model.RecruitModel;

public class Controller {
    RecruitModel model;
    public Controller() {
        this.model = new RecruitModel(this);
    }

      // method untuk membaca data dari model dan menampilkan ke view
    public String[][] readData() {
        return model.readData();
    }

    // method untuk menghapus data berdasarkan ID dengan model
    public void deleteData(String name) {
        model.deleteData(name);
        JOptionPane.showMessageDialog(null, "Data deleted successfully!");
    }

    // method untuk insert data baru dengan model
    public void insertData(String name, String path, String writing, String coding, String interview ) {
        Double writingS = Double.parseDouble(writing);
        Double codingS = Double.parseDouble(coding);
        Double interviewS = Double.parseDouble(interview);
        Double totalScore = 0.0;
        String status = "";

         //error handling cek smua field dah diisi atau blm
         if(name.isEmpty() || writing.isEmpty() || coding.isEmpty() || interview.isEmpty()){
            JOptionPane.showMessageDialog(null, "All Fields Must Be Filled");

        } 
         // Error handling cek skor angka or not
        if (!isNumeric(writing) || !isNumeric(coding) || !isNumeric(interview)) {
            JOptionPane.showMessageDialog(null, "Score Must Be Numeric!");
            throw new NumberFormatException("Scores must be numeric");
        }
        // Error handling cek skor 0-100 ga
        else if(writingS < 0 || writingS > 100 || codingS < 0 || codingS > 100 || interviewS < 0 || interviewS > 100){
            JOptionPane.showMessageDialog(null, "Score Must Between 0-100!");
        } 
        else{
             //cek divisi nya kaalau android
             if(path.equals("Android Developer")){
                Double weightWriting = writingS * 0.2;
                Double weightCoding = codingS * 0.5;
                Double weightInterview = interviewS * 0.3;
                 totalScore = (weightWriting + weightCoding + weightInterview);
                if(totalScore >= 85){
                    status = "ACCEPTED";
                } else {
                    status = "NOT ACCEPTED";
                }
            } 
            //cek divisi nya kaalau web
            else{
                Double weightWriting = writingS * 0.4;
                Double weightCoding = codingS * 0.35;
                Double weightInterview = interviewS * 0.25;
                 totalScore = (weightWriting + weightCoding + weightInterview);

                if(totalScore >= 85){
                    status = "ACCEPTED";
                } else {
                    status = "NOT ACCEPTED";
                }
            }
        }
        model.insertData(name, path, writingS, codingS, interviewS, totalScore, status);
        JOptionPane.showMessageDialog(null, "Data Inserted Successfully!");
    }

    // method untuk update data berdasarkan ID dengan model
    public void updateData(String name, String path, String writing, String coding, String interview) {
        Double writingS = Double.parseDouble(writing);
        Double codingS = Double.parseDouble(coding);
        Double interviewS = Double.parseDouble(interview);
        Double totalScore = 0.0;
        String status = "";
         // Error handling cek skor angka or not
        if (!isNumeric(writing) || !isNumeric(coding) || !isNumeric(interview)) {
            JOptionPane.showMessageDialog(null, "Score Must Be Numeric!");
            throw new NumberFormatException("Scores must be numeric");
        }
        // Error handling cek skor 0-100 ga
        else if(writingS < 0 || writingS > 100 || codingS < 0 || codingS > 100 || interviewS < 0 || interviewS > 100){
            JOptionPane.showMessageDialog(null, "Score Must Between 0-100!");
        } 
        else{
             //cek divisi nya kaalau android
             if(path.equals("Android Developer")){
                Double weightWriting = writingS * 0.2;
                Double weightCoding = codingS * 0.5;
                Double weightInterview = interviewS * 0.3;
                 totalScore = (weightWriting + weightCoding + weightInterview);
                if(totalScore >= 85){
                    status = "ACCEPTED";
                } else {
                    status = "NOT ACCEPTED";
                }
            } 
            //cek divisi nya kaalau web
            else{
                Double weightWriting = writingS * 0.4;
                Double weightCoding = codingS * 0.35;
                Double weightInterview = interviewS * 0.25;
                 totalScore = (weightWriting + weightCoding + weightInterview);

                if(totalScore >= 85){
                    status = "ACCEPTED";
                } else {
                    status = "NOT ACCEPTED";
                }
            }
        }
        model.updateData(name, path, writingS, codingS, interviewS, totalScore, status);
        JOptionPane.showMessageDialog(null, "Data Updated Successfully!");
    }


    void checkInput(){
       
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
