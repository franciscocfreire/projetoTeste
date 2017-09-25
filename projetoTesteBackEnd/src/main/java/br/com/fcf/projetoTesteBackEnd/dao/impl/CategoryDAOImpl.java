package br.com.fcf.projetoTesteBackEnd.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fcf.projetoTesteBackEnd.dao.CategoryDAO;
import br.com.fcf.projetoTesteBackEnd.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

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

	// Getting single category based on id
	@Override
	public Category get(int id) {

		return sessionFactory.getCurrentSession().get(Category.class,
				Integer.valueOf(id));
	}

	@Override
	@Transactional
	public boolean add(Category category) {

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(category);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * Updating a single category
	 * @see br.com.fcf.projetoTesteBackEnd.dao.CategoryDAO#update(br.com.fcf.projetoTesteBackEnd.dto.Category)
	 */
	@Override
	public boolean update(Category category) {
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(category);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		
		category.setActive(false);
		
		try {
			// delte the category to the database table
			sessionFactory.getCurrentSession().update(category);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
