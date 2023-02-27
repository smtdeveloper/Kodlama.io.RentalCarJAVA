package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequests;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import lombok.AllArgsConstructor;

@RestController 
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelController {

	private ModelService modelService;
	
	@GetMapping()
	public List<GetAllModelsResponse> getAll() {
		return modelService.getAll();
		
	}
	
	@PostMapping()
	@ResponseStatus(code =HttpStatus.CREATED)
	public void Add(@RequestBody() CreateModelRequests request ) {
		 this.modelService.add(request);
	}
	
	
}
