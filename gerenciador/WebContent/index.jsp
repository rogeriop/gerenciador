<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>"

<html>
<body>
Bem vindo ao nosso gerenciador de empresas!<br/>
<c:if test="${not empty usuarioLogado}">
	Você está logado como ${usuarioLogado}<br/>
</c:if>
<form action="NovaEmpresa" method="POST">
   Nome: <input type="text" name="nome" /><br/>
    <input type="submit" value="Enviar" />
</form>

<form action="Login" method="post">
	Email: <input type="text" name="email" /><br/>
	Senha: <input type="text" name="senha" /><br/>
	<input type="submit" value="Enviar" />
</form>

<form action="logout" method="POST">
	<input type="submit" value="Logout">
</form>



</body>
</html>