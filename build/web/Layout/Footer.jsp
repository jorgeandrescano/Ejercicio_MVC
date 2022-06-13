 
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="row">
    <div class="col-lg-6 bg-secondary bg-opacity-50 p-3">
        <p style="font-size: 1rem; color: graytext; text-align: center"> 
            &#9400 2022- Todos los derechos reservados
        </p>
    </div>
    <div class="col-lg-6 bg-secondary bg-opacity-50 p-3 d-flex justify-content-around">
        <i class="bi bi-facebook" style="font-size: 1.5rem; color: graytext;"></i>
        <i class="bi bi-instagram" style="font-size: 1.5rem; color: graytext;"></i>
        <i class="bi bi-twitter" style="font-size: 1.5rem; color: graytext;"></i>
        <i class="bi bi-youtube" style="font-size: 1.5rem; color: graytext;"></i>
        <i class="bi bi-twitch" style="font-size: 1.5rem; color: graytext;"></i>
        <i class="bi bi-snapchat" style="font-size: 1.5rem; color: graytext;"></i>
    </div>
</div>

<!--<script src="/Assets/js/bootstrap.min.js" type="text/javascript"></script>-->
<script src="Assets/js/bootstrap.bundle.js" type="text/javascript"></script>
<script src="Assets/js/jquery-3.6.0.min.js" type="text/javascript"></script>
<script src="Library/Validacion/jquery.validate.min.js" type="text/javascript"></script>
<script src="Library/Alertas/sweetalert2.all.min.js" type="text/javascript"></script>
<script>
    <%
        HttpSession miSession = request.getSession();
        if(miSession.getAttribute("Registro")!= null) {
            boolean Registro = (boolean) miSession.getAttribute("Registro");
            if (Registro) { %>
                Swal.fire("Servicio registrado con éxito", "<%=Registro%>", "success");
            <% }else{ %>
                Swal.fire("No se pudo registrar el servicio", "<%=Registro%>", "error");
            <% }
            //Si ya se mostró el mensaje, hay que removerlo
            miSession.removeAttribute("Registro");
        }
    %>
</script>

</body>
</html>
