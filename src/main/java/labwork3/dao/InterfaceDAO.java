package labwork3.dao;


import java.util.List;

public interface InterfaceDAO<T, K> {

    List<T> selectAll();
    void create(T entity);
    T select(K key);
    void update(T entity);
    void deleteByKey(K key);


}

