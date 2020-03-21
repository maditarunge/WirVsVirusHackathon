package DatabaseConnection;

public interface DatabaseManager<T> {
    void insert(T object);
    void update(T object);
    void delete(T object);
    void deleteAll();
}
