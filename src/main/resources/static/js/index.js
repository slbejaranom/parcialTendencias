$(document).ready(() => {
  $("#agregarCategoria").on("click", function() {
    $("#modalCategoria").modal();
  });

  $("#agregarElemento").on("click", function() {
      $("#modalProducto").modal();
  });
  //Función para el botón crear elemento
  $("#btnCrearProducto").on("click", function() {
    let nombreProducto = $("#nombreProducto").val();
    let descripcion = $("#descripcionProducto").val();
    let cantidad = $("#cantidadInicial").val();
    let imagen = $("#imagen").val();
    let reader = new FileReaderSync();
    if(!nombreProducto || !descripcion || !cantidad || !imagen){
      alert("Alguno de los campos está vacío, por favor verifique");
      return;
    }
    let result_base64 = reader.readAsDataURL(imagen);

    $.ajax({
          method: "POST",
          contentType: "application/json",
          url: "/elements",
          data: JSON.stringify({
            "name": nombreProducto,
            "description": descripcion,
            "quantity": cantidad,
            "image": contenidoImagen
          })});
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