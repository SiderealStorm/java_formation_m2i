package org.example.demos.jdbcdao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

// Cette classe permet de fournir une base (= modèle) aux autres classes de DAO via l'héritage
// La classe doit être abstraite pour ne pas être instanciée, et utiliser un générique pour pouvoir traiter les différents types de DAO des enfants
// On pourrait aussi utiliser une interface (généralement IDAO)
public abstract class BaseDAO<T> {

    // Attributs qui seront disponibles pour toutes les classes héritées :

    // Par convention, les valeur injectées sont notées avec un underscore
    protected Connection _connection;
    protected PreparedStatement statement;
    protected String query;
    protected ResultSet results;

    // Constructeur pour injecter la connexion :
    protected BaseDAO(Connection connection) {
        _connection = connection;
    }

    // Méthodes à implémenter dans TOUTES les classes DAO :

    // Les exceptions sont remontées, elles seront gérées dans la couche service
    public abstract boolean save(T element) throws SQLException;
    public abstract boolean update(T element) throws SQLException;
    public abstract boolean delete(T element) throws SQLException;
    public abstract List<T> getAll() throws SQLException;
    public abstract T get(int id) throws SQLException;

}
