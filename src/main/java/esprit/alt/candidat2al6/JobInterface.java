package esprit.alt.candidat2al6;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "JobALT6")
public interface JobInterface {

    @RequestMapping("/jobs")
    public List<Job> getalljobs();

    @RequestMapping("/jobs/{id}")
    public Job getJobByid(@PathVariable(value = "id") int id);

}
