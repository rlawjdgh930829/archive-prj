package com.spring.archive.repository;

import java.util.List;

import com.spring.archive.domain.CategoryDTO;

public interface CategoryDAO {
	
	List<CategoryDTO> getAllCategory();
	
}
