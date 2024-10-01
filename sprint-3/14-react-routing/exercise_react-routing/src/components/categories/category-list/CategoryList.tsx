import { useEffect, useState } from "react";
import { Link, useLocation } from "react-router-dom";

export default function CategoryList() {

      const [categories, setCategories] = useState<any[]>([]);

      const location = useLocation();
      const params = new URLSearchParams(location.search);

      const page = params.get("page") ?? 1

      const prevPage = +page - 1;
      const nextPage = +page + 1;

      useEffect(() => { loadCategories(); }, [])

      async function loadCategories() {

        // const categories = await categoryService.getCategories(page);
        // setCategories(categories)

    }


      return (
        <>
          <h4>Categories List</h4>
          <ul>
            <li><Link to="/categories/2">Category 2</Link></li>
            <li><Link to="/categories/3">Category 3</Link></li>
            <li><Link to="/categories/4">Category 4</Link></li>
            <li><Link to="/categories/t">Category 5</Link></li>
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
