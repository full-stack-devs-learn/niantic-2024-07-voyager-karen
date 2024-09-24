document.getElementById('fetchButton').addEventListener('click', function () {
    const pokemonName = document.getElementById('pokemonName').value.toLowerCase();
    const apiUrl = `https://pokeapi.co/api/v2/pokemon/${pokemonName}`;

    fetch(apiUrl)
        .then(response => {
            if (!response.ok) {
                throw new Error('No Pokemon found');
            }
            return response.json();
        })
        .then(data => {

            const template = document.getElementById('pokemon-template');
            const clone = template.content.cloneNode(true);

            clone.querySelector('.pokemon-name').textContent = data.name;
            clone.querySelector('.pokemon-image').src = data.sprites.front_default;
            clone.querySelector('.pokemon-weight').textContent = data.weight;
            clone.querySelector('.pokemon-height').textContent = data.height;
            clone.querySelector('.pokemon-type').textContent = data.types.map(type => type.type.name).join(', ');

            const pokemonDataContainer = document.getElementById('pokemonData');
            pokemonDataContainer.innerHTML = '';
            pokemonDataContainer.appendChild(clone);


        })
        .catch(error => {
            console.log(error);
            document.getElementById('pokemonData').innerHTML = 'Error';
        });
});
