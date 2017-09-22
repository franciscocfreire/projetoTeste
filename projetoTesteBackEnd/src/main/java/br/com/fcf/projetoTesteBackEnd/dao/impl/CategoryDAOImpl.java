package br.com.fcf.projetoTesteBackEnd.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.fcf.projetoTesteBackEnd.dao.CategoryDAO;
import br.com.fcf.projetoTesteBackEnd.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<Category>();

	static {

		Category category = new Category();

		// adding first category

		category.setId(1);
		category.setName("Television");
		category.setDescription("This is description for Television");
		category.setImageURL("CAT_1.img");
		category.setActive(true);

		categories.add(category);

		category = new Category();

		// adding second category

		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is description for Mobile");
		category.setImageURL("CAT_2.img");

		categories.add(category);

		// adding third category
		category = new Category();
		
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is description for Laptop");
		category.setImageURL("CAT_3.img");

		categories.add(category);
	}

	@Override
	public List<Category> list() {		
		return categories;
	}

	@Override
	public Category get(int id) {
		// enchanced for loop
		
		for(Category category : categories){
			if(category.getId() == id){
				return category;
			}
		}
		return null;
	}

}
