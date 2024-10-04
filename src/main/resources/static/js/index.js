$(document).ready(() => {
  $("#agregarCategoria").on("click", function() {
    $("#modalCategoria").modal();
  });

  $("#btnCrear").on("click", function() {
    let nombreCategoria = $("#nombreCategoria").val();
    if(!nombreCategoria) {
      alert("El nombre de categoría no debe estar vacío");
      return;
    }
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
    }).fail(function(error){
      //Failed request
      alert("Falló la petición" + error);
    }).always(function() {
      //close modal after result
      $("#modalCategoria").modal();
    });
  })
});