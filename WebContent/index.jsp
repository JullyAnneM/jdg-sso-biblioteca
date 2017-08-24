<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Biblioteca Digital</title>
</head>
<body style="background-color: teal; text-align:center; color: white; font-family:verdana;">
	<h1>Bem vindo a sua Biblioteca Digital!</h1>
	
	</br>
	
	<h3>Insira o ISBN do Livro procurado aqui:</h3>
	
   <form action="api/rest/get" method="get">
   	<input style="text-align:center;border-radius: 4px;border: 1px solid #ccc;" type="number" name="isbn" placeholder="Isbn do livro.." required>
   	</br></br>
   	<input type="submit" style="background-color: #4CAF50; color: white; border: none; border-radius: 4px;cursor: pointer;">
   	
   	<script>
	function myFunction() {
        document.post.reset();
    	alert("Inserido com sucesso!");
	}
	</script>	
   	
   </form>
   	
   </br></br></br>
   
   <h3>Insira suas informações no Banco de Dados aqui: </h3>
   
   <form name="post" action="api/rest/persist" method="post">
   	<h4>Título</h4>
   	<input style="text-align:center;border-radius: 4px;border: 1px solid #ccc;" type="text" name="titulo" placeholder="Titulo do livro.." required>
   	<h4>ISBN</h4>
   	<input style="text-align:center;border-radius: 4px;border: 1px solid #ccc;" type="number" name="isbn" placeholder="Isbn do livro.."required>
   	<h4>Autor</h4>
   	<input style="text-align:center;border-radius: 4px;border: 1px solid #ccc;" type="text" name="autor" placeholder="Autor do livro.." required>
   	</br></br>
   	<button type="submit" style="background-color: #4CAF50; color: white; border: none; border-radius: 4px;cursor: pointer;" onclick="myFunction()">Submit</button>
   </form>

	
</body>
</html>