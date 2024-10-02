import { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import categoryService from "../../../services/category-service";
import { Category } from "../../../models/category";

export default function CategoryEdit() {
  const { id } = useParams<{ id: string }>(); 
  const [category, setCategory] = useState<Category | null>(null);
  const [categoryName, setCategoryName] = useState("");
  const [description, setDescription] = useState("");
  const navigate = useNavigate();

  useEffect(() => {

    if (id) {
      loadCategory(parseInt(id));
    }
  }, [id]);

  async function loadCategory(categoryId: number) {
    try {
      const category = await categoryService.getCategoryById(categoryId);
      setCategory(category);
      setCategoryName(category.categoryName);
      setDescription(category.description);
    } catch (error) {
      console.error("Error loading category:", error);
    }
  }

  async function handleSubmit(event: React.FormEvent) {
    event.preventDefault();
    try {
      if (category) {
        const updatedCategory = {
          ...category,
          categoryName,
          description
        };
        await categoryService.updateCategory(updatedCategory);

        navigate("/categories");
      }
    } catch (error) {
      console.error("Error updating category:", error);
    }
  }

  return (
    <div>
      <h4>Edit Category</h4>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Category Name:</label>
          <input
            type="text"
            value={categoryName}
            onChange={(e) => setCategoryName(e.target.value)}
            required
          />
        </div>
        <div>
          <label>Description:</label>
          <textarea
            value={description}
            onChange={(e) => setDescription(e.target.value)}
            required
          />
        </div>
        <button type="submit">Update Category</button>
      </form>
    </div>
  );
}
