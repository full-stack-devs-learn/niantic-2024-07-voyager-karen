import { useState, useEffect } from 'react';
import './ProductCardContainer.css';
import productService from '../../../services/product-service';

export default function ProductCardContainer() {

    const [selectedProduct, setSelectedProduct] = useState("None Selected");
    const [selectedProductId, setSelectedProductId] = useState(0);
    const [products, setProducts] = useState([]);

}