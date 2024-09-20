let categoryService;
let productService;
let addFormScreen;
let addForm;

document.addEventListener("DOMContentLoaded", function() {
    categoryService = new CategoryService();
    productService = new ProductsService();

    addFormScreen = document.getElementById("add-form-screen");
    addForm = document.getElementById("add-form");

    document.getElementById("add-button").addEventListener("click", showForm);
    document.getElementById("cancel-button").addEventListener("click", cancelAdd);
    document.getElementById("save-button").addEventListener("click", addCategory);

    loadProducts();
})

function loadProducts()
{
    productService.getAllProducts()
        .then(products => {
            const categoryContainer = document.getElementById('categories-container');
            categoryContainer.innerHTML = '';

            products.forEach(product => {
                const template = document.getElementById('category-template').content.cloneNode(true);
                template.getElementById('category-header').innerText = product.productName;
                template.getElementById('category-image').src = `images/${product.productId}.webp`;

                const deleteButton = template.querySelector('.card-footer #delete-button');
                deleteButton.addEventListener('click', () => {
                    productService.deleteProduct(product.productId).then(() => {
                        loadProducts();
                    })
                });

                categoryContainer.appendChild(template);
            })
        })
}

function showForm()
{
    addFormScreen.classList.remove("d-none");
}

function cancelAdd(event)
{
    event.preventDefault();
    addFormScreen.classList.add("d-none");
}

function addCategory(event)
{
    event.preventDefault();
    event.stopPropagation()

    addForm.classList.add("was-validated");

    if(addForm.checkValidity()){

        addFormScreen.classList.add("d-none");
        addForm.classList.remove("was-validated");
    }
}