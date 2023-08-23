package org.example.exos.jpa.dao;

import jdk.jshell.spi.ExecutionControl;
import org.example.exos.jpa.entity.Category;

import java.util.List;

public class CategoryDAO implements BaseDAO<Category> {
    @Override
    public void closeDAO() {

    }

    @Override
    public boolean add(Category element) {
        return false;
    }

    @Override
    public List<Category> get() {
        return null;
    }

    @Override
    public Category get(int id) {
        return null;
    }

    @Override
    public boolean update(Category element) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Erreur : la méthode update() n'est pas implémentée pour CategoryDAO");
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
