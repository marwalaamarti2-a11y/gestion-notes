package ma.ensa.gestionnotes.controller;

import ma.ensa.gestionnotes.model.Etudiant;
import ma.ensa.gestionnotes.service.EtudiantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {

    private final EtudiantService service;

    public EtudiantController(EtudiantService service) {
        this.service = service;
    }

    // POST /etudiants : ajouter un etudiant (JSON dans le corps de la requete)
    @PostMapping
    public ResponseEntity<Etudiant> ajouter(@RequestBody Etudiant etudiant) {
        service.ajouter(etudiant);
        return ResponseEntity.status(HttpStatus.CREATED).body(etudiant);
    }

    // GET /etudiants : affichage des notes
    @GetMapping
    public List<Etudiant> afficherNotes() {
        return service.getTous();
    }

    // GET /etudiants/recherche?nom=...&prenom=... : rechercher un etudiant
    @GetMapping("/recherche")
    public ResponseEntity<Etudiant> rechercher(@RequestParam String nom, @RequestParam String prenom) {
        Etudiant e = service.rechercher(nom, prenom);
        if (e == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(e);
    }

    // GET /etudiants/admis
    @GetMapping("/admis")
    public List<Etudiant> admis() {
        return service.getAdmis();
    }

    // GET /etudiants/rattrapage
    @GetMapping("/rattrapage")
    public List<Etudiant> rattrapage() {
        return service.getRattrapage();
    }

    // GET /etudiants/majorant
    @GetMapping("/majorant")
    public List<Etudiant> majorant() {
        return service.getMajorants();
    }

    // GET /etudiants/tries
    @GetMapping("/tries")
    public List<Etudiant> listeTriee() {
        return service.getListeTriee();
    }
}