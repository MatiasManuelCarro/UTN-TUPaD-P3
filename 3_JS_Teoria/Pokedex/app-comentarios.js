//Este Script no se carga es solamente para los comentarios


//constante para limitar la cantidad de pokemons solicitados
const limit = 251;
let todosLosPokemones = [];

// Función que trae los pokémon desde la API
const fetchPokemons = async () => {
    try {
        // 1. Pedimos los primeros 100 pokémon
        const response = await fetch(`https://pokeapi.co/api/v2/pokemon?limit=${limit}`);

        // 2. Convertimos la respuesta en objeto JSON
        const data = await response.json()

        // 3. Transformamos cada pokémon en un objeto con nombre + imagen 
        todosLosPokemones= data.results.map((pokemon) => {

            // Extraemos el id desde la URL
            const id = pokemon.url.split("/")[6];

            // Armamos la URL del sprite usando ese id
            const url = `https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${id}.png`;

            //objeto pokemon que retorna
            return {
                name: pokemon.name,
                imagen: url,
            };
        });

        // 4. Mostramos los pokémon en el contenedor usando la funcion
        //la funcion recibe lo que contiene mostrarPokemones
        mostrarPokemones(todosLosPokemones);

        //En caso de error
    } catch (error) {
        console.log(error)
    }

};

// Seleccionamos el contenedor en el HTML
const contenedorPokemones = document.getElementById("contenedor_pokemones");

// Función que recibe un array de pokémon y los muestra
const mostrarPokemones = (pokemones = []) => {
     // limpiar y mostrar resultados para que recargue la pagina con la busqueda
    contenedorPokemones.innerHTML = ""
    if(pokemones.length > 0) {
    // por cada pokemon en el array
    pokemones.forEach((pokemon) => {
        // Creando un elemento <article> en el DOM 
        const tarjeta = document.createElement("Article")

        // classList.add("Tarjeta") agrega la clase CSS "Tarjeta" al elemento, 
        // permitiendo aplicarle estilos definidos en tu hoja de estilos
        tarjeta.classList.add("tarjeta");

        // Creamos el contenido de la tarjeta con innerHTML
        // Usamos template literals (``) para insertar dinámicamente las propiedades del objeto
        // ${pokemon.imagen} → URL de la imagen
        // ${pokemon.name} → nombre del pokémon
        // innerHTML inserta contenido HTML dentro del elemento (puede ser texto, etiquetas, imágenes, etc.)
        tarjeta.innerHTML = `<img src="${pokemon.imagen}" alt="pokemon ${pokemon.name}" /><h3>${pokemon.name}</h3>`;

        // Insertamos la tarjeta dentro del contenedor principal en el HTML
        // appendChild agrega el nuevo elemento (hijo) dentro del contenedor (padre) en el DOM
        contenedorPokemones.appendChild(tarjeta);
    });
    //se remueve la clase para que se pueda mostrar los pokemons de vuelta sin la tarjeta de mensaje de error
    contenedorPokemones.classList.remove("contenedor__pokemones--flex");
} else {
    // Si el array de pokemones filtrados está vacío (no hay coincidencias)

     // Creamos un elemento <h2> en el DOM
    const mensajeError = document.createElement("h2");

        // Le asignamos el texto que se mostrará como mensaje de error y le damos color
        mensajeError.textContent = "No hay pokemones en esta busqueda";
        mensajeError.style.color= "#e63946";

        // Insertamos el mensaje dentro del contenedor principal
        contenedorPokemones.appendChild(mensajeError);

         // Agregamos una clase CSS especial para modificar el estilo del contenedor que recien se creo
        contenedorPokemones.classList.add("contenedor__pokemones--flex");
    
}
};

//busqueda
// Seleccionamos el input de búsqueda por su id="buscar"
const inputBuscar = document.getElementById("buscar");
// Le agregamos un "escuchador de eventos" (event listener)
// Este escuchador se activa cada vez que el usuario escribe algo en el input
inputBuscar.addEventListener("input", (e) =>{
    // e.target.value contiene el texto actual que el usuario escribió en el input
    // Convertimos lo que escribe a minúsculas
    const busqueda = e.target.value.toLowerCase();
    // Filtramos el array de pokémon comparando nombres en minúsculas
    const resultado = todosLosPokemones.filter((pokemon)=>{
        return pokemon.name.toLowerCase().includes(busqueda);
    });
    //llama a la funcion para que se muestre la busqueda
    mostrarPokemones(resultado)
});


//funcion fetch pokemons (llama a la API)
fetchPokemons();