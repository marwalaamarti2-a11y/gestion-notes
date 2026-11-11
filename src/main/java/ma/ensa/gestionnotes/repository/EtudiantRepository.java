package ma.ensa.gestionnotes.repository;

import ma.ensa.gestionnotes.model.Etudiant;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EtudiantRepository {

    // Notre "base de donnees" : un dictionnaire cle -> etudiant
    private final Map<String, Etudiant> etudiants = new LinkedHashMap<>();

    private String cle(String nom, String prenom) {
        return (nom + "_" + prenom).toLowerCase();
    }

    public void ajouter(Etudiant e) {
        etudiants.put(cle(e.getNom(), e.getPrenom()), e);
    }

    public Etudiant trouver(String nom, String prenom) {
        return etudiants.get(cle(nom, prenom));
    }

    public List<Etudiant> trouverTous() {
        return new ArrayList<>(etudiants.values());
    }
}