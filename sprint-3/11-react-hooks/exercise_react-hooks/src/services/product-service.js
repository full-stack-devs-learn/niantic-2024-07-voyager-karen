import axios from 'axios'

class ProductService {

    baseUrl = 'http://localhost:8080/products'

    async getAllProducts() {

        const response = await axios.get(this.baseUrl);
        return response.data;

    }

    async add(product) {

        const response = await axios.post(this.baseUrl, product)
        return response.data;

    }

    async delete(id) {

        await axios.delete(`${this.baseUrl}/${id}`)
    }

}

const productService = new ProductService()
export default productService;