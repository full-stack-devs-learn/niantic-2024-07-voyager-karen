import { useState } from "react";
import productService from "../../../services/product-service";

export default function ProductAdd({onCancel, onProductAdded}) {

    // add rest later 

    const [productName, setProductName] = useState('');
    const [unitPrice, setUnitPrice] = useState('');

    async function addProductHandler(event) {

        event.preventDefault()

        const newProduct = {
            productName: productName,
            unitPrice: unitPrice
        }

        await productService.add(newProduct)

        onProductAdded()

    }

    return (
        <div className="container">
        <h2>Add New Product</h2>
        <form onSubmit={addProductHandler}>
            <div className="row">
                <label htmlFor="product-name">Product Name:</label>
                <input type="text" className="form-control" name="product-name" id="product-name"
                    onChange={(e) => setProductName(e.target.value)}
                />    
            </div>
        

        </form>
        </div>
    )


}