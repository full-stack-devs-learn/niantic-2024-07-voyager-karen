package com.niantic.controllers;

import com.niantic.services.CategoryDao;
import com.niantic.models.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;


@Controller
public class CategoriesController
{
    CategoryDao categoryDao = new CategoryDao();


    // https://localhost:8080/categories
    @GetMapping("/categories")

    public String getCategories(Model model) {

        ArrayList<Category> categories;

        categories = categoryDao.getCategories();

        model.addAttribute("categories", categories);
        return "categories/index";

    }

    @GetMapping("/categories/{id}")
    public String details(Model model, @PathVariable int id)
    {
       var category = categoryDao.getCategoryById(id);
       model.addAttribute("category", category);
       return "categories/details";
    }




}
