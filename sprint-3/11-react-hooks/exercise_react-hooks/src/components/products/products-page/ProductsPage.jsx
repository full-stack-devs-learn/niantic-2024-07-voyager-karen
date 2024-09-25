import { useState } from 'react'
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

        {action === "list" && <ProductCardContainer></ProductCardContainer>}

        </div>

    )
}