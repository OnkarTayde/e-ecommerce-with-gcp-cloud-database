package com.ecommerce.app.category;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
public class CategoryController
{
	@Autowired
	CategoryService service;
	
	@Autowired
	CategoryRepository categoryRepository;


	@PostMapping("/addCategory")
	public CategoryModel addCategory(@RequestBody CategoryModel Cat)
	{
//		CategoryModel e =
//		System.out.println(e);
		return service.insertCategory(Cat);
	}
	
	@GetMapping("/getAllCategory")
	public List<CategoryModel> getAllCategory()
	{
		
		return service.getAllCategory();
		
	}
	
	@GetMapping("/getCategoryWithBrand")
	public List<Object> getCategoryWithBrand()
	{
		return service.getCategoryWithBrand();
	}
	
	@GetMapping("/getCategoryById/{category_id}")
	public List<Object> getCategoryById(@PathVariable("category_id")int id)
	{
		List<Object>list=service.getCategoryById(id);
		
		return list;
		
	}
	
	@GetMapping("/getCategoryByName/{category_name}")
	public List<Object> getCategoryByName(@PathVariable("category_name")String category_name)
	{
		List<Object>list=service.getCategoryByName(category_name);
		return list;
	}

	@DeleteMapping("/deleteCategoryById/{category_id}")
	public void deleteCategoryById(@PathVariable("category_id")int id)
	{

		service.deleteCategoryById(id);
	}


}
