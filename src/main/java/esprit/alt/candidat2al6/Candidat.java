package esprit.alt.candidat2al6;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Candidat {

    @Id
    @GeneratedValue
    private int id;
    private String nom;
    private String prenom;
    private String email;
    @ElementCollection
    private Set<Integer> favoriteJobs = new HashSet<>();
    public Candidat() {
    }

    public Candidat(String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    public Set<Integer> getFavoriteJobs() {
        return favoriteJobs;
    }

    public void setFavoriteJobs(Set<Integer> favoriteJobs) {
        this.favoriteJobs = favoriteJobs;
    }

    public int getId() {
        return id;
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

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
