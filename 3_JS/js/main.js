const listaCategorias = document.getElementById("lista-categorias");
const contenedorProductos = document.getElementById("contenedor-productos");
const modal = document.getElementById("modal");
const cerrarCarrito = document.getElementById("cerrar-carrito");
const modalCarrito = document.getElementById('modal-carrito');
const mensajeCarrito = document.getElementById("mensaje-carrito");


cerrarCarrito.onclick = function () {
    modal.style.display = "none";
    mensajeCarrito.textContent ="";
}



window.onclick = function (event) {
    const modal = document.getElementById("modal");
    if (event.target === modal) {
        modal.style.display = "none";
        mensajeCarrito.textContent ="";
    }

};



const cargarCategorias = () => {
    categorias.forEach((categoria) => {
        const li = document.createElement('li')
        li.innerHTML = `<a href="#">${categoria}</a>`
        listaCategorias.appendChild(li)

    });
}
cargarCategorias();

const cargarProductos = () => {
    productos.forEach((producto) => {
        const productosDestacados = document.createElement('article')
        productosDestacados.classList.add("productosDestacados")
        productosDestacados.innerHTML = `
        <img src=${producto.imagen} img alt=${producto.nombre} />
        <h3>${producto.nombre}</h3>
        <p>${producto.descripcion}</p>
        <p>Precio: $${producto.precio}</p>
        <button class=btn-detalles data-id="${producto.id}">Ver Detalles</button>
        <button class=btn-carrito data-id="${producto.id}">Agregar al Carrito</button>
        `
        contenedorProductos.appendChild(productosDestacados);


    });
}
cargarProductos();


contenedorProductos.addEventListener("click", (evento) => {
    if (evento.target.classList.contains("btn-carrito")) {
        const idProducto = evento.target.dataset.id;
        const producto = productos.find(p => p.id == idProducto);        
        mensajeCarrito.textContent = `Se agrega al carrito: ${producto.nombre}`;
        modal.style.display = "block";
    }
});

