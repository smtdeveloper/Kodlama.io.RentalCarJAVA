package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandResponse;
import kodlama.io.rentACar.entities.concretes.Brand;

@RestController 
@RequestMapping("/api/brands")
public class BrandsController {
	
	private BrandService brandService;

	@Autowired
	public BrandsController(BrandService brandService) {
		
		this.brandService = brandService;
	}
	
	@GetMapping("/getall")
	public List<GetAllBrandResponse> getAll()
	{
		return brandService.getAll();
		
	}
	
	@PostMapping("/add")
	public void Add(@RequestBody() CreateBrandRequest request ) 
	{
		 this.brandService.add(request);
	}
	
	
}
