import java.util.List;

public class DataMovieController {
    MainView frame;
    DataMovieDAO implement;
    List<DataMovie> list;

    public DataMovieController(MainView frame){
        this.frame = frame;
        implement = new DataMovieDAO();
        list = implement.getAll();
    }

    public void isiTabel(){
        list = implement.getAll();
        ModelTabelMovie mtm = new ModelTabelMovie(list);
        frame.getTabelData().setModel(mtm);
    }

    public void insert(String judul, Double alur, Double penokohan, Double akting){
        DataMovie dm = new DataMovie(judul, alur, penokohan, akting);
        dm.setJudul(judul);
        dm.setAlur(alur);
        dm.setPenokohan(penokohan);
        dm.setAkting(akting);
        dm.setNilai((alur + penokohan + akting) / 3);
        implement.insert(dm);
    }

    public void update(String judul, Double alur , Double penokohan, Double akting){
        DataMovie dm = new DataMovie(judul, alur, penokohan, akting);
        dm.setJudul(judul);
        dm.setAlur(alur);
        dm.setPenokohan(penokohan);
        dm.setAkting(akting);
        dm.setNilai((alur + penokohan + akting) / 3);
        implement.update(dm);
    }

    public void delete(String judul){
        DataMovie dm = new DataMovie(judul, 0, 0, 0);
        dm.setJudul(judul);
        implement.delete(dm);
    }
}
