// add pageTitle

// add groceries

// create instance of service
const service = new ShoppingService();


/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function displayListTitle() {

    const listTitle = document.getElementById("title");
    listTitle.textContent = service.getListName();

}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {

    const groceries = service.getShoppingList();

    const groceryListContainer = document.getElementById("shopping-list");


    groceries.forEach(grocery => {

        // create a new div element for each grocery item
        const itemDiv = document.createElement('div');

        itemDiv.classList.add('list-item');

        // create title span
        const titleSpan = document.createElement('span');
        titleSpan.textContent = grocery.title;

        // create quantity container div
        const quantityContainer = document.createElement('div');
        quantityContainer.classList.add('quantity-container');

        // create 'super' span
        const superSpan = document.createElement('span');
        superSpan.classList.add('super');
        superSpan.textContent = 'quantity';

        // create text node for the quantity
        const quantityText = document.createTextNode(grocery.quantity);

        // append span and quantity to quantity container
        quantityContainer.appendChild(superSpan);
        quantityContainer.appendChild(quantityText);

        // append title and container to items 
        itemDiv.appendChild(titleSpan);
        itemDiv.appendChild(quantityContainer);
        
        // append grocery item div to the shopping list container
        groceryListContainer.appendChild(itemDiv);


    });

}


function markCompleted() {

    const listItems = document.querySelectorAll('.list-item');

    listItems.forEach(item => {

        item.classList.add('complete');

    });

}


displayListTitle();
displayGroceries();

