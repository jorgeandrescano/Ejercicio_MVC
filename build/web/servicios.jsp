<%@page import="Controller.CategoriasController" %>
<%@page import="Controller.ServiciosController" %>
<%@page import="java.sql.ResultSet" %>
<%@include file="Layout/Header.jsp"%>
<%@include file="Layout/Navbar.jsp"%>

<%
    ResultSet datosEditar = null;
    HttpSession miSession1 = request.getSession();
    if(miSession1.getAttribute("datosEdit") != null){
    datosEditar =(ResultSet) miSession1.getAttribute("datosEdit");
    datosEditar.next();
    }
%>

<div class="container">
    <p style="text-align: left;font-size: 30px; margin-top: 80px"> <strong>Servicios</strong>
    </p>
    <hr>
</div>

<div class="container" style="margin-top: 30px">
    <form action="ServiciosController" method="post" id="form-serv">
        <input class="form-control" type="hidden" name="txtIdServicio" value="<%= datosEditar != null? datosEditar.getInt("idServicio"): ""%>">
        <div class="row mb-4">
            <div class="col-4">
                <label class="form-label">Nombre del Servicio</label>
                <input class="form-control" name="txtNombreServ" value="<%=datosEditar != null?datosEditar.getString("nombreServ"): ""%>" required>
            </div>
            <% 
                CategoriasController objCate = new CategoriasController();
                ResultSet lCategorias = objCate.listCategoria();
            %>
            <div class="col-4">
                <label for="txtCategoria" class="form-label">Categoría</label>
                <select class="form-select" name="txtCategoria">
                    <option selected>Seleccione...</option>
                    <% while(lCategorias.next()){ %>
                    <option value="<%=lCategorias.getInt("idCategoria")%>"><%=lCategorias.getString("nombreCat")%></option>
                    <% } %>
                </select>
            </div>
        </div>

        <div class="row mb-4">
            <div class="col-4">
                <label class="form-label">Medida</label>
                <input class="form-control" name="txtMedida" value="<%=datosEditar != null?datosEditar.getString("medida"): ""%>" required>
            </div>
            <div class="col-4">
                <label class="form-label">Costo</label>
                <input class="form-control" name="txtCosto" value="<%=datosEditar != null?datosEditar.getFloat("costo"): ""%>" required>
            </div>
        </div>

        <div class="row mb-4">
            <div class="col-4">
                <label class="form-label">Estado</label>
                <input class="form-control" name="txtEstado" value="<%=datosEditar != null?datosEditar.getInt("estado"): ""%>" required>
            </div>
            <div class="col-4">
                <br>
                <%if(datosEditar != null) {%>
                <button type="submit" class="btn btn-outline-warning p-1 px-2 mt-2" name="btnModificar">Modificar</button>
                <% }else{ %>
                <button type="submit" class="btn btn-outline-success p-1 px-2 mt-2" name="btnGuardar">Guardar</button>
                <% } %>
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
                <th scope="col">Categoría</th>
                <th scope="col">Servicio</th>
                <th scope="col">Medida</th>
                <th scope="col">Costo</th>
                <th scope="col">Estado</th>
                <th scope="col">Acciones</th>
            </tr>
        </thead>
        <tbody>
            <% ServiciosController listaServ = new ServiciosController();
                ResultSet listaS = listaServ.listar();
                while(listaS.next()) {
            %>    
            <tr>
                <td><%=listaS.getInt("idServicio")%></td>
                <td><%=listaS.getString("nombreCat")%></td>
                <td><%=listaS.getString("nombreServ")%></td>
                <td><%=listaS.getString("medida")%></td>
                <td><%=listaS.getFloat("costo")%></td>
                <td><%=listaS.getInt("estado") == 1 ? "Activo" : "Inactivo"%></td>
                <td>
                    <div class="d-grid gap-2 d-md-block">
                        <a href="ServiciosController?idEditar=<%=listaS.getInt("idServicio")%>" class="btn btn-primary btn-sm btn-warning">Editar</a>
                        <% if(listaS.getInt("Estado") == 1){ %>
                            <a href="/ServiciosController?idServicio=<%=listaS.getInt("idServicio")%>&estado=0" class="btn btn-primary btn-sm btn-primary">Inactivar</a>
                        <% } else { %>
                            <a href="/ServiciosController?idServicio=<%=listaS.getInt("idServicio")%>&estado=1" class="btn btn-primary btn-sm btn-success">Activar</a>
                        <% } %>
                        <button class="btn btn-primary btn-sm btn-danger" type="button" name="btnEliminar">Eliminar</button>
                    </div>
                </td>
            </tr>
                <% } %> 
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