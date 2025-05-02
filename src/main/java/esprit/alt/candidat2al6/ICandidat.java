package esprit.alt.candidat2al6;

import java.util.List;

public interface ICandidat {

    public List<Candidat> gelallcandidats();
    public Candidat saveCandidat(Candidat candidat);
    public Candidat deleteCandidat(int id);
    public Candidat updateCandidat(Candidat candidat);
    public Candidat getCandidatById(int id);


}
