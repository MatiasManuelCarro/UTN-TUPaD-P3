const listaCategorias = document.getElementById("lista-categorias");

function cargarCategorias() {
    categorias.forEach(function (categoria) {
        const li = document.createElement("li")
        li.innerHTML = `<a href="3">${categoria}</a>`
        listaCategorias.appendChild(li)
    });
};

cargarCategorias();