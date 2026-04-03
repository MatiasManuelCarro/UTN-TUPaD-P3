
//constante para limitar la cantidad de pokemons solicitados
const limit = 251;
let todosLosPokemones = [];

const fetchPokemons = async () => {
    try {
        const response = await fetch(`https://pokeapi.co/api/v2/pokemon?limit=${limit}`);
        const data = await response.json()
        todosLosPokemones = data.results.map((pokemon) => {
            const id = pokemon.url.split("/")[6];
            const url = `https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${id}.png`;
            return {
                name: pokemon.name,
                imagen: url,
            };
        });
        mostrarPokemones(todosLosPokemones);
    } catch (error) {
        console.log(error)
    }

};

const contenedorPokemones = document.getElementById("contenedor_pokemones");

const mostrarPokemones = (pokemones = []) => {
    contenedorPokemones.innerHTML = ""
    if (pokemones.length > 0) {
        pokemones.forEach((pokemon) => {
            const tarjeta = document.createElement("Article")
            tarjeta.classList.add("tarjeta");
            tarjeta.innerHTML = `<img src="${pokemon.imagen}" alt="pokemon ${pokemon.name}" /><h3>${pokemon.name}</h3>`;
            contenedorPokemones.appendChild(tarjeta);
        });
        contenedorPokemones.classList.remove("contenedor__pokemones--flex");
    } else {
        const mensajeError = document.createElement("h2");
        mensajeError.style.color = "#e63946";
        contenedorPokemones.appendChild(mensajeError);
        contenedorPokemones.classList.add("contenedor__pokemones--flex");
    }
};

const inputBuscar = document.getElementById("buscar");
inputBuscar.addEventListener("input", (e) => {
    const busqueda = e.target.value.toLowerCase();
    const resultado = todosLosPokemones.filter((pokemon) => {
        return pokemon.name.toLowerCase().includes(busqueda);
    });
    mostrarPokemones(resultado)
});

fetchPokemons();