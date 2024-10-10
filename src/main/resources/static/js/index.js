$(document).ready(() => {
  $("#consultar").on("click", function(){
    let nombre = $("#nombreArticulo").val();
    let categoria = $("#categoria").val();
    let url = '';
    if(!nombre && (!categoria || categoria === '-1')){
      url = '/findElements/0'
    }
    if(!nombre && categoria){
      url = '/findElements/0?category='+categoria;
    }
    if(nombre && categoria){
      url = '/findElements/0?category='+categoria+'&nameCoincidence='+nombre;
    }
    console.log(url);
    $.ajax({
            method: "GET",
            url: url
          })
    .done(function(data) {
      if(data){
        $("#contenedorArticulos").html(data);
      }
      else{
        alert('No hay artículos con esas especificaciones.');
      }
    })
  })
  $("#agregarCategoria").on("click", function() {
    $("#modalCategoria").modal();
  });

  $("#agregarElemento").on("click", function() {
      $("#modalProducto").modal();
      $.ajax({
        method: "GET",
        url: "/categories"
      })
      .done(function(data) {
        let newContent = data.replace("categoria", "categoriaElemento");
        $("#categoriaElemento").replaceWith(newContent);
      })
      .fail(function(){console.log("No se refrescaron las categorias")});
  });
  //Función para el botón crear elemento
  $("#btnCrearProducto").on("click", function() {
    let nombreProducto = $("#nombreProducto").val();
    let descripcion = $("#descripcionProducto").val();
    let cantidad = $("#cantidadInicial").val();
    let imagen = $("#imagen").prop('files')[0];
    let categoria = $("#categoriaElemento").val();
    let loadedFile = false;
    let fileReader = new FileReader();
    if(!nombreProducto || !descripcion || !cantidad || !imagen || !categoria || categoria === 'none'){
      alert("Alguno de los campos está vacío, por favor verifique");
      return;
    }
    let result_base64;
    fileReader.addEventListener("load", () => {
      result_base64 = fileReader.result;
      $.ajax({
                method: "POST",
                contentType: "application/json",
                url: "/elements",
                data: JSON.stringify({
                  "name": nombreProducto,
                  "description": descripcion,
                  "quantity": cantidad,
                  "image": result_base64,
                  "category": categoria
                })
    }).done(function(){console.log("Elemento agregado")})
      .fail(function(error){alert("Error del servidor, se pudo agregar: "+error)})});
    fileReader.readAsDataURL(imagen);
  });
  //Función para el boton crear
  $("#btnCrear").on("click", function() {
    let nombreCategoria = $("#nombreCategoria").val();
    //Si categoría no tiene nada
    if(!nombreCategoria) {
      alert("El nombre de categoría no debe estar vacío");
      return;
    }
    //Llamada POST para crear la categoría
    $.ajax({
      method: "POST",
      contentType: "application/json",
      url: "/categories",
      data: JSON.stringify({
        "name": nombreCategoria
      })
    }).done(function(){
      //Successful request
      alert("Categoría añadida correctamente");
      //Para refrescar la categoría
      $.ajax({
            method: "GET",
            url: "/categories"})
            .done(function(data) {
              $("#categoria").replaceWith(data);
            })
            .fail(function(){console.log("No se refrescaron las categorias")});

    }).fail(function(error){
      //Failed request
      alert("Falló la petición" + error);
    }).always(function() {
      //close modal after result
      $("#modalCategoria").modal();
    });
  })
});