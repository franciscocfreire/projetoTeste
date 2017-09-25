package br.com.fcf.projetoTesteBackEnd.dao;

import java.util.List;

import br.com.fcf.projetoTesteBackEnd.dto.Category;

public interface CategoryDAO {

	
	
	List<Category> list();

	Category get(int id);
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);

}
