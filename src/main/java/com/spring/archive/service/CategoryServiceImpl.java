package com.spring.archive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.archive.domain.CategoryDTO;
import com.spring.archive.repository.CategoryDAO;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDAO categoryDao;

	@Override
	public List<CategoryDTO> getAllCategoryService() {
		return categoryDao.getAllCategory();
	}

	@Override
	public Integer getMaxCategoryNo() {
		return categoryDao.getMaxCategoryNo();
	}

}
