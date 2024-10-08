import { useState, useEffect } from 'react';
import ProductCard from '../product-card/ProductCard';
import './ProductCardContainer.css';
import productService from '../../../services/product-service';

export default function ProductCardContainer() {

    const [selectedProduct, setSelectedProduct] = useState("None Selected");
    const [selectedProductId, setSelectedProductId] = useState(0);
    const [products, setProducts] = useState([]);

    useEffect(() => {

        productService.getAllProducts().then(data => {

            console.log("Products data:", data[0]);
            console.log("date being returned:");
            console.log(data);
            setProducts(data);


        })

    },
    [])


    const productSelected = (name) => {

        setSelectedProduct(name);

        const selectedProduct = products.find(product => product.productName === name);

        setSelectedProductId(selectedProduct.id);
        console.log(name)

    }

    const productDeleted = (id) => {

        const newList = products.filter(product => product.id != id);
        setProducts(newList)

    }

    return(
        <>
        <h5 className="container">Selected Product: {selectedProduct}</h5>
        <main className="container mt-4 products-container" id="products-container">
        {
            products.map((product) => (
                <ProductCard key={product.id}
                            product={product.name}
                            id={product.id}
                            categoryId={product.categoryId}
                            quantityPerUnit={product.quantityPerUnit}
                            unitPrice={product.unitPrice}
                            onProductSelected={productSelected}
                            onProductDeleted={productDeleted}
                    ></ProductCard>
                ))
            }
        </main>
        </>
    )


}