import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import categoryService from "../../../services/category-service";
import { Category } from "../../../models/category"; 


export default function CategoryList() {

  const [categories, setCategories] = useState<Category[]>([]);


  useEffect(() => { loadCategories() }, []); 

  async function loadCategories() {

    try {
        const categories = await categoryService.getCategories();
        console.log("Fetched categories", categories);
        setCategories(categories);
    } 
    catch (error) {
      console.error("Error loading categories:", error);
    }

  }

  return (
    <>
      <h4>Categories List</h4>
      <Link className="btn btn-success" to="/categories/add">Add New Category</Link>
      <ul>
        {categories.map((category: Category) => (
          <li key={category.categoryId}>
            <Link to={`/categories/${category.categoryId}`}>
              {category.categoryName} {category.description}
            </Link>
            <Link className="btn btn-primary btn-sm" to={`/categories/${category.categoryId}/edit`}>
              Edit
            </Link>
          </li>
        ))}
      </ul>
    </>
  );
}