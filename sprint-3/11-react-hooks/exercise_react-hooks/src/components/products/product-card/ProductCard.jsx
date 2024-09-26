import productService from '../../../services/product-service'
import './ProductCard.css'
import { XCircle, XCircleFill } from 'react-bootstrap-icons'

export default function ProductCard({ id, product, onProductSelected }) {

    const productClicked = () => {
        onProductSelected(product);
    };

    return (
        <div className="card product-card" onClick={productClicked}>
            <div id="product-header" className="card-header">{product || "No Product Name"}</div>
            <div id="product-body" className="card-body">
                <p>Product ID: {id}</p>  
            </div>
        </div>
    );
}
