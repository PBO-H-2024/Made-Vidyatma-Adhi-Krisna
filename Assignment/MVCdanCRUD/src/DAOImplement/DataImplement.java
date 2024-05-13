import java.util.List;

public interface DataImplement {
    public void insert(DataMovie dm);
    public void update(DataMovie dm);
    public void delete(DataMovie dm);
    public List<DataMovie> getAll();
}
