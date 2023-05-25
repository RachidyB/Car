package ma.emsi.JDBC.dao;

import ma.emsi.classe.User;

import java.sql.SQLException;

public interface UserDao {

    public int authentification(String email,String password);
    public void inscription(User user);
}
