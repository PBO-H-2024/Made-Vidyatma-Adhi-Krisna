import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTabelMovie extends AbstractTableModel{
    private List<DataMovie> list;
    public ModelTabelMovie(List<DataMovie> list){
        if (list == null) {
            this.list = new ArrayList<>();
        } else {
            this.list = list;
        }
    }

    @Override
    public int getRowCount() {
        return this.list.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Judul";
            case 1:
                return "Alur";
            case 2:
                return "Penokohan";
            case 3:
                return "Akting";
            case 4:
                return "Nilai";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return list.get(row).getJudul();
            case 1:
                return list.get(row).getAlur();
            case 2:
                return list.get(row).getPenokohan();
            case 3:
                return list.get(row).getAkting();
            case 4:
                return list.get(row).getNilai();
            default:
                return null;
        }
    }
    
}
