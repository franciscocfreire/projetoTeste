package br.com.fcf.projetoTesteBackEnd.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.fcf.projetoTesteBackEnd.dao.CategoryDAO;
import br.com.fcf.projetoTesteBackEnd.dto.Category;

public class CategoryTestCase {
	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("br.com.fcf.projetoTesteBackEnd");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	/*
	 * @Test public void testAddCategory(){ category = new Category();
	 * 
	 * category.setName("Television");
	 * category.setDescription("This is description for Television");
	 * category.setImageURL("CAT_1.img");
	 * 
	 * assertEquals("Successfully added a category inside the table!",true,
	 * categoryDAO.add(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testGetCategory(){ category = categoryDAO.get(3);
	 * assertEquals
	 * ("Successfully fetched a single category from the table!","Television"
	 * ,category.getName()); }
	 */

/*	@Test
	public void testUpdateCategory() {
		category = categoryDAO.get(3);
		category.setName("TV");
		assertEquals("Successfully updated a single category in the table!",
				true, categoryDAO.update(category));
	}*/
	
	@Test
	public void testDeleteCategory() {
		category = categoryDAO.get(3);		
		assertEquals("Successfully deleted a single category in the table!",
				true, categoryDAO.delete(category));
	}

}
