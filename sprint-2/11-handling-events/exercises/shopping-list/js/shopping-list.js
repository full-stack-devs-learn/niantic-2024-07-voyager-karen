let service;
let list = []

let allItemsIncomplete = true;


function displayListTitle() {
    const title = document.getElementById("title")
    title.textContent = service.getListName();
}


function displayShoppingList() {

    const parent = document.getElementById("shopping-list")

    // added to clear existing list items because i accidently duplicated everything...

    parent.innerHTML = '';

    list.forEach(item => {
        addListItem(item, parent);
    })
}

function addListItem(item, parent)
{
    const div = document.createElement("div")
    div.classList.add("list-item");
    if(item.isComplete)
    {
        div.classList.add("complete")
    }

    addItemTitle(item, div);
    addQuantity(item, div)

    // add single click event to mark item complete 

    div.addEventListener('click', () =>  {

        if (!div.classList.contains('complete')) {
            div.classList.add('complete');
        }

    });

    // add double click event to mark item as incomplete

    div.addEventListener('dblclick', () =>  {

        if (div.classList.contains('complete')) {
            div.classList.remove('complete');
        }

    });


    parent.appendChild(div)
}

function addItemTitle(item, parent)
{
    const div = document.createElement("div")
    div.textContent = item.title;

    parent.appendChild(div);
}

function addQuantity(item, parent)
{
    const div = document.createElement("div");
    div.classList.add("quantity-container");

    const span = document.createElement("span");
    span.textContent = "quantity"
    span.classList.add("super");

    const text = document.createTextNode(item.quantity)

    div.appendChild(span)
    div.appendChild(text)

    parent.appendChild(div);
}


function markCompleted() {
    const listItems = document.querySelectorAll(".list-item");

    listItems.forEach(item => {
        item.classList.add("complete");
    })
}

// create the page load event here
function toggleAllItems() {

    const listItems = document.querySelectorAll(".list-item");

    listItems.forEach(item => {
        if(allItemsIncomplete) {
            item.classList.add("complete");
        } else {
            item.classList.remove("complete");
        }
    });

    allItemsIncomplete = !allItemsIncomplete;

    const toggleButton = document.getElementById("allCompleteButton");
    toggleButton.textContent = allItemsIncomplete ? "Mark All Completed" : "Mark All Incomplete";
}  

function addNewItem(event) {

    event.preventDefault();

    const newItemTitle = document.getElementById("itemName").value;
    const newItemQuantity = document.getElementById("quantity").value;

    const newItem = {
        title: newItemTitle,
        quantity: newItemQuantity,
        isComplete: false
    }

    list.push(newItem);
    displayShoppingList();

    document.querySelector('form').reset();

}



document.addEventListener("DOMContentLoaded", () => {
    service = new ShoppingService();
    list = service.getShoppingList();

    displayListTitle();
    displayShoppingList();

    // form sub to add new items
    const form = document.querySelector("form");
    form.addEventListener('submit', addNewItem);


    // toggle button for all
    const toggleButton = document.getElementById("allCompleteButton");
    toggleButton.addEventListener('click', toggleAllItems);
});

