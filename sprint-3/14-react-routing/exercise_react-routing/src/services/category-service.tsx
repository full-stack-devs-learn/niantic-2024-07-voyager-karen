import axios from "axios";
import { Category } from "../models/category";

class CategoryService {
    baseUrl = `${import.meta.env.VITE_API_BASE_URL}/categories`

    constructor() {
        console.log('Base URL:', this.baseUrl); 
    }

    async getCategories(): Promise<Category[]> {
        const response = await axios.get<Category[]>(this.baseUrl);
        return response.data;
    }

    async getCategoryById(id: number): Promise<Category> {
        const response = await axios.get<Category>(`${this.baseUrl}/${id}`);
        return response.data;
      }

    async addCategory(category: Category): Promise<Category> {
        const response = await axios.post<Category>(this.baseUrl, category);
        return response.data;
    }

    async updateCategory(category: Category): Promise<void> {
        const url = `${this.baseUrl}/${category.categoryId}`;
        await axios.put<void>(url, category);
    }
}

const categoryService = new CategoryService();
export default categoryService;
