package com.spring.archive.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.archive.domain.CategoryDTO;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<CategoryDTO> getAllCategory() {
		return session.selectList("category.getAllCategory");
	}

	@Override
	public Integer getMaxCategoryNo() {
		return session.selectOne("category.getMaxCategoryNo");
	}

}
