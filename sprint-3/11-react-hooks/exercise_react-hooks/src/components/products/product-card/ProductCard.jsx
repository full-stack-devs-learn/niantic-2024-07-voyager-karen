import productService from '../../../services/product-service'
import './ProductCard.css'
import { XCircle, XCircleFill } from 'react-bootstrap-icons'

export default function ProductCard({ id, product, categoryId, quantityPerUnit, unitPrice, onProductSelected, onProductDeleted}) {

    const productClicked = () => {
        onProductSelected(product);
    };

    async function deleteProduct(event) {

        event.stopPropagation();

        await productService.delete(id);

        if(onProductDeleted) {
            onProductDeleted(id);
        }

    }

    return (
        <div className="card product-card" onClick={productClicked}>
            <div id="product-header" className="card-header">{product || "No Product Name"}</div>
            <div id="product-body" className="card-body">
                <p>Product ID: {id}</p>
                <p>Category ID: {categoryId}</p>
                <p>Quantity Per Unit: {quantityPerUnit}</p>
                <p>Unit Price: {unitPrice}</p>                    
            </div>
            <div className="card-footer">
                <XCircleFill onClick={deleteProduct} color="red" className="delete-icon"/>
            </div>
        </div>
    );
}
