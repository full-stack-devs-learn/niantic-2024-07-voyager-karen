document.addEventListener('DOMContentLoaded', function() {
    const categorySelect = document.getElementById('category');

    // event listener for category dropdown
    categorySelect.addEventListener('change', function(event) {
        const categoryId = event.target.value; // get category id
        console.log('Selected Category ID:', categoryId); // debugging

        if (categoryId) {
            const url = `/products/category/${categoryId}`;

            // fetch product list
            fetch(url).then(response => {
                if (response.status === 200) {
                    return response.text();
                }
                throw new Error('Failed to load products');
            }).then(data => {
                const container = document.getElementById('productRows'); // product table body
                container.innerHTML = data;
            }).catch(error => {
                console.log('Error fetching products:', error);
            });
        }
    });
});
