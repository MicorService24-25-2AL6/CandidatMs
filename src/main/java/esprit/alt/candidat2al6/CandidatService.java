package esprit.alt.candidat2al6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatService implements ICandidat{

    @Autowired
    private CandidatRepository candidatRepository;

    @Autowired
    private JobInterface jobInterface;
    @Override
    public List<Candidat> gelallcandidats(){

       return candidatRepository.findAll();

    }

    @Override
    public Candidat saveCandidat(Candidat candidat) {
        return candidatRepository.save(candidat);
    }



    @Override
    public Candidat deleteCandidat(int id) {
        Optional<Candidat> candidatOptional = candidatRepository.findById(id);

        if (candidatOptional.isPresent()) {
            Candidat candidat = candidatOptional.get();
            candidatRepository.delete(candidat);
            return candidat;
        } else {
            throw new IllegalArgumentException("Candidat with id " + id + " not found.");
        }
    }

    @Override
    public Candidat updateCandidat(Candidat candidat) {
        if (candidatRepository.existsById(candidat.getId())) {
            return candidatRepository.save(candidat);  // Save the updated Candidat, ID remains unchanged
        } else {
            throw new IllegalArgumentException("Candidat with id " + candidat.getId() + " not found.");
        }
    }

    @Override
    public Candidat getCandidatById(int id) {
        Optional<Candidat> candidatOptional = candidatRepository.findById(id);
        return candidatOptional.orElseThrow(() -> new IllegalArgumentException("Candidat with id " + id + " not found."));
    }


    public List<Job> getlistJob(){
        return jobInterface.getalljobs();
    }
    public Job getJobById(int id){
        return jobInterface.getJobByid(id);
    }
}
