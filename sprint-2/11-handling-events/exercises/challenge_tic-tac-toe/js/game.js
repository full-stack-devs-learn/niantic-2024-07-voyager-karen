// players player 1,2
const player1 = {
    name: 'Karen',
    value: 'X'
}
const player2 = {
    name: 'Valerie',
    value: 'O'
}

// current
let currentPlayer;


function setNextPlayer() {

    if (currentPlayer === player1) {
        currentPlayer = player2;
    } else {
        currentPlayer = player1;
    }

    // show current player 
    document.getElementById('playerName').textContent = `Current Player: ${currentPlayer.name} (${currentPlayer.value})`;

}

function init() {
    
    // starting player to player1 first
    currentPlayer = player1;

    // display starting player
    document.getElementById('playerName').textContent = `Current Player: ${currentPlayer.name} (${currentPlayer.value})`;

    // game button event listeners
    const buttons = document.querySelectorAll('.game-button');
    buttons.forEach(button => {

        // checking if button was clicked already
        button.addEventListener('click', function() {

            if (button.textContent === '') {

                // mark button with current player's value "O" or "X"
                button.textContent = currentPlayer.value;
    
    
                setNextPlayer();
        
        }
            
        })
    });

    // event listener for reset button
    document.getElementById('resetButton').addEventListener('click', function() {

        // clear all mark ups
        buttons.forEach(button => button.textContent = '');


    });

}    

// main
document.addEventListener('DOMContentLoaded', () =>
{
    init()
})
