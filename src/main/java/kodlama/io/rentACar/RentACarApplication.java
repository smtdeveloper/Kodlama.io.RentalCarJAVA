package kodlama.io.rentACar;

import kodlama.io.rentACar.entities.concretes.Model;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RentACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);
	}

	
	@Bean
	public ModelMapper getModelMapper(){
		
		return new ModelMapper(); 
	}
	
}


//Car
//Brand
//