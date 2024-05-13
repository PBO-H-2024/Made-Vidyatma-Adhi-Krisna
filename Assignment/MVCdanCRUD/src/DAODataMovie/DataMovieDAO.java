import java.sql.*;
import java.util.*;

import koneksi.Connector;

public class DataMovieDAO implements DataImplement{
    Connection con;
    public String judul;
    public double alur, penokohan, rating;

    final String select = "SELECT * FROM movie";
    public DataMovieDAO(){
        con = Connector.connection();
    }

    @Override
    public void insert(DataMovie dm) {
        PreparedStatement ps = null;
        try{
            String query = "INSERT INTO `movie`(`judul`,`alur`,`penokohan`, `akting`, `nilai`) VALUES ('" + dm.getJudul() + "','" + dm.getAlur() + "','" + dm.getPenokohan() + "','" + dm.getAkting() + "','" + dm.getNilai() + "')";

            ps = con.prepareStatement(query);
            ps.executeUpdate(query);
            // ps.setString(0, dm.getJudul());
            // ps.setDouble(0, dm.getAlur());
            // ps.setDouble(0, dm.getPenokohan());
            // ps.setDouble(0, dm.getAkting());
            // ps.setDouble(0, dm.getNilai());
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void update(DataMovie dm) {
        PreparedStatement ps = null;
        try{
            String query = "UPDATE `movie` SET `alur` = '" + dm.getAlur() + "', `penokohan` = '" + dm.getPenokohan() + "', `akting` = '" + dm.getAkting() + "', `nilai` = '" + dm.getNilai() + "' WHERE `judul` = '" + dm.getJudul() + "'";
            ps = con.prepareStatement(query);
            ps.executeUpdate(query);
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(DataMovie dm) {
        PreparedStatement ps = null;
        try{
            String query = "DELETE FROM `movie` WHERE `judul` = '" + dm.getJudul() + "'";
            ps = con.prepareStatement(query);
            ps.executeUpdate(query);
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("finally")
    @Override
    public List<DataMovie> getAll() {
        List<DataMovie> list = null;
        try{
            list = new ArrayList<DataMovie>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                DataMovie dm = new DataMovie(judul, alur, penokohan, rating);
                dm.setJudul(rs.getString("judul"));
                dm.setAlur(rs.getDouble("alur"));
                dm.setPenokohan(rs.getDouble("penokohan"));
                dm.setAkting(rs.getDouble("akting"));
                dm.setNilai(rs.getDouble("nilai"));
                list.add(dm);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        finally{
            return list;
        }
    }
}
