package ma.ensa.gestionnotes.model;

public class Etudiant {

    private String nom;
    private String prenom;
    private double note1;
    private double note2;
    private double coef1;
    private double coef2;

    public Etudiant() {
    }

    public Etudiant(String nom, String prenom, double note1, double note2, double coef1, double coef2) {
        this.nom = nom;
        this.prenom = prenom;
        this.note1 = note1;
        this.note2 = note2;
        this.coef1 = coef1;
        this.coef2 = coef2;
    }

    // Note finale du module : moyenne pondérée des deux éléments
    public double getMoyenne() {
        return (note1 * coef1 + note2 * coef2) / (coef1 + coef2);
    }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public double getNote1() { return note1; }
    public void setNote1(double note1) { this.note1 = note1; }

    public double getNote2() { return note2; }
    public void setNote2(double note2) { this.note2 = note2; }

    public double getCoef1() { return coef1; }
    public void setCoef1(double coef1) { this.coef1 = coef1; }

    public double getCoef2() { return coef2; }
    public void setCoef2(double coef2) { this.coef2 = coef2; }
}