package Assignment2.Controller;
import javax.swing.JOptionPane;
import Assignment2.Model.StudentModel;
import Assignment2.View.ReadData;

public class Controller  {
    StudentModel model;
    ReadData view;

    public Controller() {
        this.model = new StudentModel(this);
    }

    // method untuk membaca data dari model dan menampilkan ke view
    public String[][] readData() {
        return model.readData();
    }

    // method untuk menghapus data berdasarkan ID dengan model
    public void deleteData(int id) {
        model.deleteData(id);
        JOptionPane.showMessageDialog(null, "Data deleted successfully!");
    }

    // method untuk insert data baru dengan model
    public void insertData(int nim, String name, int age) {
        model.insertData(nim, name, age);
        JOptionPane.showMessageDialog(null, "Data inserted successfully!");
    }

    // method untuk update data berdasarkan ID dengan model
    public void updateData(int id, int nim, String name, int age) {
        model.updateData(id, nim, name, age);
        JOptionPane.showMessageDialog(null, "Data updated successfully!");
    }
}
