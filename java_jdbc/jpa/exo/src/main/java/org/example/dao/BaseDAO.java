package org.example.dao;

import java.util.List;

public interface BaseDAO<T> {

    void closeDAO();
    boolean add(T element);
    List<T> get();
    T get(int id);
    boolean update(T element);
    boolean delete(int id);
}
