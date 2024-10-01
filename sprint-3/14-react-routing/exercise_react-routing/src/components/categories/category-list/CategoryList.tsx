import { useEffect, useState } from "react";
import { Link, useLocation } from "react-router-dom";
import categoryService from "../../services/category-service";


export default function CategoryList() {
  const [categories, setCategories] = useState<any[]>([]);

  const location = useLocation();
  const params = new URLSearchParams(location.search);
  const page = params.get("page") ?? 1;

  const prevPage = +page - 1;
  const nextPage = +page + 1;

  useEffect(() => { loadCategories();}, [page]); 

  async function loadCategories() {
    try {
      const categories = await categoryService.getCategories(page);
      setCategories(categories);
    } catch (error) {
      console.error("Error loading categories:", error);
    }
  }

  return (
    <>
      <h4>Categories List</h4>
      <Link className="btn btn-success" to="/categories/add">Add New Category</Link>
      <ul>
        {categories.length > 0 ? (
          categories.map((category) => (
            <li key={category.categoryId}>
              <Link to={`/categories/${category.categoryId}`}>{category.name}</Link>{" "}
              <Link className="btn btn-primary btn-sm" to={`/categories/${category.categoryId}/edit`}>
                Edit
              </Link>
            </li>
          ))
        ) : (
          <li>No categories available</li>
        )}
      </ul>

      <div>
        {prevPage > 0 && (
          <Link className="btn btn-secondary" to={`/categories?page=${prevPage}`}>
            &lt;&lt;
          </Link>
        )}
        Page {page}
        <Link className="btn btn-secondary" to={`/categories?page=${nextPage}`}>
          &gt;&gt;
        </Link>
      </div>
    </>
  );
}
