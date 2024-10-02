import './App.css'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Header from './components/Header';
import HomePage from './components/HomePage';
import CategoryPage from './components/categories/category-page/CategoryPage';
import CategoryList from './components/categories/category-list/CategoryList';
import CategoryDetails from './components/categories/category-details/CategoryDetails';
import CategoryAdd from './components/categories/category-add/CategoryAdd';
import CategoryEdit from './components/categories/category-edit/CategoryEdit';

function App() {
  return (
    <Router>
      <Header />

      <main className="container mt-4">
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/categories" element={<CategoryPage />}>
            <Route path="" element={<CategoryList />} />
            <Route path=":categoryId" element={<CategoryDetails />} />
            <Route path="add" element={<CategoryAdd />} />
            <Route path=":categoryId/edit" element={<CategoryEdit />} />
          </Route>

        </Routes>
      </main>

      <footer>
        Northwind
      </footer>
    </Router>
  );
}

export default App;
