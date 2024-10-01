import { Link } from 'react-router-dom';
import React, { useEffect, useState } from 'react';

const CategoryList: React.FC = () => {
  const [categories, setCategories] = useState<any[]>([]); // Adjust the type according to your needs

  useEffect(() => {
    loadCategories();
  }, []);

  const loadCategories = () => {
    // Fetch your categories here
    const mockCategories = [
      { id: 1, name: "Category 1" },
      { id: 2, name: "Category 2" },
      { id: 3, name: "Category 3" },
    ];
    setCategories(mockCategories);
  };

  return (
    <div>
      <h4>Category List</h4>
      <ul>
        {categories.map((category) => (
          <li key={category.id}>
            <Link to={`/categories/${category.id}`}>{category.name}</Link> {/* Link to the Category Details page */}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default CategoryList;
