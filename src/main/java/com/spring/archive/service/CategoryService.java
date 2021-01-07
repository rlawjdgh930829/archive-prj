package com.spring.archive.service;

import java.util.List;

import com.spring.archive.domain.CategoryDTO;

public interface CategoryService {
	
	List<CategoryDTO> getAllCategoryService();
	Integer getMaxCategoryNo();

}
