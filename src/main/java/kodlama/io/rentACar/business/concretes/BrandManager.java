package kodlama.io.rentACar.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;


@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;   
	
	@Override
	public List<GetAllBrandResponse> getAll() {
		
		List<Brand> brands = brandRepository.findAll();
		
		List<GetAllBrandResponse> bransResponse = brands.stream()
				.map(b -> this.modelMapperService.forRespons()
						.map(b, GetAllBrandResponse.class)).collect(Collectors.toList());
		
		return bransResponse;
		
	}



	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		
		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		
		this.brandRepository.save(brand);
		
	}



	@Override
	public GetByIdBrandResponse getById(int id) {
		
		Brand brand = this.brandRepository.findById(id).orElseThrow();
		GetByIdBrandResponse response = this.modelMapperService.forRespons().map(brand, GetByIdBrandResponse.class);
		return response;
		
	}



	@Override
	public void update(UpdateBrandRequest updateBraRequest) {
		
		Brand brand = this.modelMapperService.forRequest().map(updateBraRequest, Brand.class);
		this.brandRepository.save(brand);
		
	}



	@Override
	public void delete(int id) {
		
		this.brandRepository.deleteById(id);
		
	}
	
	
	
}
