import React from 'react';
import { Routes, Route } from 'react-router-dom';
import Header from './components/Header';
import HomePage from './components/HomePage';
import CategoriesList from './components/categories/CategoriesList';
import CategoryDetails from './components/categories/CategoryDetails';
import CategoryAdd from './components/categories/CategoryAdd';
import CategoryEdit from './components/categories/CategoryEdit';
import ProductSearch from './components/products/ProductSearch';
import ProductDetails from './components/products/ProductDetails';
import ProductAdd from './components/products/ProductAdd';
import ProductEdit from './components/products/ProductEdit';

const App: React.FC = () => {
  return (
    <div>
      <Header />
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/categories" element={<CategoriesList />} />
        <Route path="/categories/add" element={<CategoryAdd />} />
        <Route path="/categories/:id" element={<CategoryDetails />} />
        <Route path="/categories/:id/edit" element={<CategoryEdit />} />
        <Route path="/products" element={<ProductSearch />} />
        <Route path="/products/add" element={<ProductAdd />} />
        <Route path="/products/:id" element={<ProductDetails />} />
        <Route path="/products/:id/edit" element={<ProductEdit />} />
      </Routes>
    </div>
  );
};

export default App;
