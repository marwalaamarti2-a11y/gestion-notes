package ma.ensa.gestionnotes.service;

import ma.ensa.gestionnotes.model.Etudiant;
import ma.ensa.gestionnotes.repository.EtudiantRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class EtudiantService {

    private static final double NOTE_VALIDATION = 12.0;

    private final EtudiantRepository repository;

    // Spring injecte automatiquement le repository ici
    public EtudiantService(EtudiantRepository repository) {
        this.repository = repository;
    }

    public void ajouter(Etudiant e) {
        repository.ajouter(e);
    }

    public List<Etudiant> getTous() {
        return repository.trouverTous();
    }

    public Etudiant rechercher(String nom, String prenom) {
        return repository.trouver(nom, prenom);
    }

    public List<Etudiant> getAdmis() {
        return repository.trouverTous().stream()
                .filter(e -> e.getMoyenne() >= NOTE_VALIDATION)
                .toList();
    }

    public List<Etudiant> getRattrapage() {
        return repository.trouverTous().stream()
                .filter(e -> e.getMoyenne() < NOTE_VALIDATION)
                .toList();
    }

    // Peut renvoyer plusieurs etudiants en cas d'egalite
    public List<Etudiant> getMajorants() {
        List<Etudiant> tous = repository.trouverTous();
        double max = tous.stream().mapToDouble(Etudiant::getMoyenne).max().orElse(0);
        return tous.stream()
                .filter(e -> e.getMoyenne() == max)
                .toList();
    }

    // Du meilleur au moins bon
    public List<Etudiant> getListeTriee() {
        return repository.trouverTous().stream()
                .sorted(Comparator.comparingDouble(Etudiant::getMoyenne).reversed())
                .toList();
    }
}