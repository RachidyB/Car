package ma.emsi.JDBC.dao.impl;

import ma.emsi.JDBC.dao.UserDao;
import ma.emsi.classe.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImp implements UserDao {

    private Connection conn = DB.getConnection();

    @Override
    public int authentification(String email,String password) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT email FROM user WHERE email=? and password=? ");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet != null && resultSet.next()){
                System.out.println("logged");
                return 1;}
        } catch (SQLException e) {
            System.err.println("problème");
            return 0;
        } finally {
            DB.closeStatement(ps);
        }
        return 0;
    }

    @Override
    public void inscription(User user) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO user (nom,prenom,email,password) VALUES (?,?,?,?)");

            ps.setString(1, user.getNom());
            ps.setString(2, user.getPrenom());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("problème d'insertion d'un user");
        } finally {
            DB.closeStatement(ps);
        }    }
}
