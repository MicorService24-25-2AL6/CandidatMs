package esprit.alt.candidat2al6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/candidats")
public class CandidatRestController {

    @Autowired
    private CandidatService candidatService;

    private String title = "Hello from Candidat2AL6";

    @GetMapping("/hello")
    public ResponseEntity<String> getTitle() {
        return ResponseEntity.ok(title);
    }


    @GetMapping
    public ResponseEntity<List<Candidat>> getAllCandidats() {
        return ResponseEntity.ok(candidatService.gelallcandidats());
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getCandidatById(@PathVariable int id) {
        try {
            Candidat candidat = candidatService.getCandidatById(id);
            return ResponseEntity.ok(candidat);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }


    @PostMapping
    public ResponseEntity<Candidat> createCandidat(@RequestBody Candidat candidat) {
        Candidat created = candidatService.saveCandidat(candidat);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping
    public Candidat updateCandidat(@RequestBody Candidat candidat) {
        return candidatService.updateCandidat(candidat);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCandidat(@PathVariable int id) {
        try {
            Candidat deleted = candidatService.deleteCandidat(id);
            return ResponseEntity.ok(deleted);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
