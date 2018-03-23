package labwork3.dao;

import java.util.List;

public interface InterfaceDAO<T, K> {

    List<T> selectAll(Class<T> tClass);
    void create(T entity);
    T select(Class<T> tClass, K key);
    void update(T entity);
    void delete(T entity);


}
