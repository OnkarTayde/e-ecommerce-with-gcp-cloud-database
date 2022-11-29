package com.ecommerce.app.brand;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BrandController {

	
	
	@Autowired
	BrandService brandService;
	
	@PostMapping(value="/addBrand")
	public BrandModel insertIntoTable(@RequestBody BrandModel b)
	{
		BrandModel  brandModel =brandService.InsertBrand(b);
		return brandModel;
		
	}
	//docker build -f Dockerfile -t simple-deploy.jar:0.0.1.RELEASE
	@GetMapping(value="/getAllBrands")
	public List<BrandModel> getAllBrands()
	{
		return brandService.getAllBrand();
		
	}

	@GetMapping("/getBrandByName/{Brand_name}")
	public List<Object> getBrandByName(@PathVariable("Brand_name")String Brand_name)
	{
		List<Object>list=brandService.getBrandByName(Brand_name);
		return list;
	}

	@DeleteMapping("/deleteBrandById/{brand_id}")
	public void deleteBrandById(@PathVariable("brand_id")int id)
	{

		brandService.deleteBrandById(id);
	}
}
