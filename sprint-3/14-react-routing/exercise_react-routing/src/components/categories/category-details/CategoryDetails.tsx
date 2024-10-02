import { useEffect, useState } from "react"
import { useParams } from "react-router-dom"
import categoryService from "../../../services/category-service"
import { Category } from "../../../models/category"


export default function CategoryDetails()
{
    const [category, setCategory] = useState<Category>();

    const params = useParams()
    const categoryId = params.categoryId ?? 0

    useEffect(() => { loadCategory()}, [])

    async function loadCategory() {

        const searchResult = await categoryService.getCategoryById(+categoryId)
        setCategory(searchResult)

    }

    return (
        <>
        <h4>Category Details</h4>
        <p>{category?.categoryName} {category?.description}</p>
        </>
    )
}