package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;

@RestController 
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
	private BrandService brandService;

	@GetMapping()
	public List<GetAllBrandResponse> getAll()
	{
		return brandService.getAll();
		
	}
	
	@GetMapping("/{id}")
	public GetByIdBrandResponse getById(int id)
	{
		return brandService.getById(id);
		
	}
	
	@DeleteMapping("/{id}")
	public void delete(int id)
	{
		 this.brandService.delete(id);
		
	}
	
	@PutMapping()
	public void update(@RequestBody() UpdateBrandRequest request )
	{
		 this.brandService.update(request);
		
	}
	
	@PostMapping()
	@ResponseStatus(code =HttpStatus.CREATED)
	public void Add(@RequestBody() CreateBrandRequest request ) 
	{
		 this.brandService.add(request);
	}
	
	
}
