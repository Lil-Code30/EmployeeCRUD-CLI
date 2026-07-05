package interfaces;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    Optional<T> get(int id);
    List<T> getAll();
    void insert(T entity);
    void update(T t);
    boolean delete(int id);
}
