package esprit.alt.candidat2al6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class Candidat2Al6Application {

	public static void main(String[] args) {
		SpringApplication.run(Candidat2Al6Application.class, args);
	}

	@Autowired
	private CandidatRepository candidatRepository;
	@Bean
	ApplicationRunner init(){
		return (args)->
		{
			candidatRepository.save(new Candidat("oumeima", "ibnelfekih", "oumeima.ibnelfekih@esprit.tn"));
			candidatRepository.save(new Candidat("sarra", "sarra", "sarra@esprit.tn"));
			candidatRepository.findAll().forEach(System.out::println);
		};
	}

}
