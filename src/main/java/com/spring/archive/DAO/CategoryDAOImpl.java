package com.spring.archive.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.archive.DTO.CategoryDTO;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<CategoryDTO> getAllCategory() {
		return session.selectList("category.getAllCategory");
	}

}
