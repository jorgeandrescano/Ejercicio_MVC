<%@include file="Layout/Header.jsp"%>
<%@include file="Layout/Navbar.jsp"%>
<div class="container">
    <p style="text-align: left;font-size: 30px; margin-top: 80px"> <strong>Servicios</strong>
    </p>
    <hr>
</div>

<div class="container" style="margin-top: 30px">
    <form id="form-serv" action="" method="get">
        <div class="row mb-4">
            <div class="col-4">
                <label class="form-label">Nombre del Servicio</label>
                <input class="form-control" name="txtNombre" required>
            </div>
            <div class="col-4">
                <label for="txtCategoria" class="form-label">Categoría</label>
                <select class="form-select" name="txtCategoria">
                    <option selected>Seleccione...</option>
                    <option value="1">Telefonía</option>
                    <option value="2">Servicios generales</option>
                </select>
            </div>
        </div>

        <div class="row mb-4">
            <div class="col-4">
                <label class="form-label">Medida</label>
                <input class="form-control" name="txtMedida" required>
            </div>
            <div class="col-4">
                <label class="form-label">Costo</label>
                <input class="form-control" name="txtCosto" required>
            </div>
        </div>

        <div class="row mb-4">
            <div class="col-4">
                <label class="form-label">Estado</label>
                <input class="form-control" name="txtEstado" required>
            </div>
            <div class="col-4">
                <br>
                <button type="submit" class="btn btn-outline-success p-1 px-2 mt-2" name="agregar">+ Agregar</button>
            </div>
        </div>
    </form>
</div>

<div class="container">
    <hr>
    <h4>Lista de Servicios</h4>
    <br>
    <table class="table table-striped">

        <thead>
            <tr class="table-dark">
                <th scope="col">Id Servicio</th>
                <th scope="col">Servicio</th>
                <th scope="col">Categoría</th>
                <th scope="col">Medida</th>
                <th scope="col">Costo</th>
                <th scope="col">Estado</th>
                <th scope="col">Acciones</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>1</td>
                <td>Telefonia IPTV</td>
                <td>Telefonía</td>
                <td>x Servicio</td>
                <td>$100,000</td>
                <td>Activo</td>
                <td>
                    <div class="d-grid gap-2 d-md-block">
                        <button class="btn btn-primary btn-sm btn-primary" type="button">Editar</button>
                        <button class="btn btn-primary btn-sm btn-warning" type="button">Desactivar</button>
                        <button class="btn btn-primary btn-sm btn-danger" type="button">Eliminar</button>
                    </div>
                </td>
            </tr>

        </tbody>

    </table>
</div>

<%@include file="Layout/Footer.jsp"%>

<script>
    /*$(function(){
        $("#form-serv").validate(
                errorClass:"text-danger")
    });*/
    $(document).ready(function() {
  $("#form-serv").validate({
          errorClass: "text-danger"});
});
                
</script>