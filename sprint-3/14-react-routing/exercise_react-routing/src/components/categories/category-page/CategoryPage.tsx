import React from 'react';
import { Outlet, Link } from 'react-router-dom';

const CategoryPage: React.FC = () => {
  return (
    <div>
      <h4>Categories</h4>
      <Link className="btn btn-success" to="add">Add New Category</Link> {/* Link to the add category page */}
      
      {/* Renders the child routes like CategoryList or CategoryDetails */}
      <Outlet />
    </div>
  );
};

export default CategoryPage;
