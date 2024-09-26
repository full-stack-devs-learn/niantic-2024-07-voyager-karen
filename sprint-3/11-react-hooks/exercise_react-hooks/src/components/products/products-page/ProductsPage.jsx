import { useState } from 'react'
import ProductAdd from '../product-add/ProductAdd'
import './ProductsPage.css'
import ProductCardContainer from '../product-card-container/ProductCardContainer'

export default function ProductsPage()
{

    const [action, setAction] = useState("list");

    return (
        <div className='container'>
            <header className="mt-4">
                <h1>Products</h1>
            </header>
            <button className="btn btn-danger" onClick={()=> setAction("add")}>Add</button>

            {action === "list" && <ProductCardContainer></ProductCardContainer>}
            {action === "add" && <ProductAdd onCancel={()=>setAction("list")}
                                            onProductAdded={()=>setAction("list")}
                                        ></ProductAdd>}
        </div>

    )
}