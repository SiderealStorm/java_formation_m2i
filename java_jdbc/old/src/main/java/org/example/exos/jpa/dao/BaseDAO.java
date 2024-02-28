package org.example.exos.jpa.dao;

import jdk.jshell.spi.ExecutionControl;

import java.util.List;

public interface BaseDAO<T> {

    void closeDAO();
    boolean add(T element);
    List<T> get();
    T get(int id);
    boolean update(T element) throws ExecutionControl.NotImplementedException;
    boolean delete(int id);
}
