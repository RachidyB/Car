package ma.emsi.classe;

import java.util.Objects;

public class User {
    int id;
    String nom;
    String prenom;
    String email;
    String password;

    public User(String nom, String prenpm, String email, String password) {
        this.nom = nom;
        this.prenom = prenpm;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenpm) {
        this.prenom = prenpm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenpm='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(nom, user.nom) && Objects.equals(prenom, user.prenom) && Objects.equals(email, user.email) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prenom, email, password);
    }
}
