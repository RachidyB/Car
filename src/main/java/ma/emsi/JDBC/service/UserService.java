package ma.emsi.JDBC.service;

import ma.emsi.JDBC.dao.UserDao;
import ma.emsi.JDBC.dao.impl.UserDaoImp;
import ma.emsi.classe.User;

public class UserService {
    private UserDao u = new UserDaoImp();


    public int login(String email,String password){return u.authentification(email,password);}
    public void signup(User user){u.inscription(user);}


}


