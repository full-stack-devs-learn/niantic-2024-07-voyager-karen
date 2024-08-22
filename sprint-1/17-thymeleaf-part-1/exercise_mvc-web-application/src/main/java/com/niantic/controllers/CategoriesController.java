package com.niantic.controllers;

import com.niantic.services.CategoryDao;
import com.niantic.models.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/categories/add")
    public String addCategories(Model model) {
        model.addAttribute("categories", new Category());
        model.addAttribute("action", "add");
        return "categories/add_edit";
    }

    @PostMapping("/categories/add")
    public String addActor(Model model, @ModelAttribute("categories") Category category) {
        categoryDao.addCategory(category);
        model.addAttribute("categories", category);
        return "categories/add_success";
    }

    @GetMapping("/categories/{id}/edit")
    public String editCategory(Model model, @PathVariable int id) {
        Category category = categoryDao.getCategoryById(id);
        model.addAttribute("categories", category);
        model.addAttribute("action", "edit");
        return "categories/add_edit";
    }

    @PostMapping("/categories/{id}/edit")
    public String editCategory(Model model, @ModelAttribute("categories") Category category, @PathVariable int id) {
        category.setCategoryId(id);
        categoryDao.updateCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/categories/{id}/delete")
    public String deleteCatgory(Model model, @PathVariable int id)
    {
        Category category = categoryDao.getCategoryById(id);
        if(category == null)
        {
            model.addAttribute("message", String.format("There is no category with id %d", id));
            return "404";
        }

        model.addAttribute("categories", category);
        return "categories/delete";
    }

    @PostMapping("/categories/{id}/delete")
    public String deleteCategory(@PathVariable int id)
    {
        categoryDao.deleteCategory(id);

        return "redirect:/categories";
    }



}
