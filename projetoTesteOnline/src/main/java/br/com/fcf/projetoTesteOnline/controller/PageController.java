package br.com.fcf.projetoTesteOnline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fcf.projetoTesteBackEnd.dao.CategoryDAO;
import br.com.fcf.projetoTesteBackEnd.dto.Category;

@Controller
public class PageController {

	@Autowired
	private CategoryDAO categoryDAO;

	/*
	 * @RequestMapping(value = {"/","index","/home"}) public ModelAndView
	 * index(){ ModelAndView mav = new ModelAndView("page");
	 * mav.addObject("greetings", "Welcome"); return mav; }
	 */
	@RequestMapping(value = { "/", "index", "/home" })
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("userClickHome", true);
		mav.addObject("title", "Home");

		// passing the list of categories
		mav.addObject("categories", categoryDAO.list());
		return mav;
	}

	@RequestMapping(value = { "about" })
	public ModelAndView about() {
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("userClickAbout", true);
		mav.addObject("title", "About Us");
		return mav;
	}

	@RequestMapping(value = { "contact" })
	public ModelAndView contact() {
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("userClickContact", true);
		mav.addObject("title", "Contact Us");
		return mav;
	}

	/**
	 * Methods to load all the products and based on category
	 */

	@RequestMapping(value = { "show/all/products" })
	public ModelAndView showAllProducts() {
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("userClickAllProducts", true);
		mav.addObject("title", "View Product");

		// passing the list of categories
		mav.addObject("categories", categoryDAO.list());
		return mav;
	}

	/**
	 * Methods to load all the products and based on category
	 */

	@RequestMapping(value = { "show/category/{id}/products" })
	public ModelAndView showAllProducts(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("page");

		// categoryDAO to fetch a single category
		Category category = null;
		category = categoryDAO.get(id);

		mav.addObject("title", category.getName());

		// passing the list of categories
		mav.addObject("categories", categoryDAO.list());

		// passing the single category object
		mav.addObject("category", category);

		mav.addObject("userClickCategoryProducts", true);
		return mav;
	}

}
