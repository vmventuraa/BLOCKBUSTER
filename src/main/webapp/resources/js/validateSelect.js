 function validarFormulario() {
 var opcaoSelecionada1 = document.getElementById("id-genero").value;
 var opcaoSelecionada2 = document.getElementById("id-produtora").value;
 var mensagemErro = document.getElementById("mensagemErro");
 
 	if (opcaoSelecionada1 === "selecionado" || opcaoSelecionada2 === "selecionado") {
    	 mensagemErro.style.display = "block";
  
        return false;
    }else{
		  mensagemErro.style.display = "none";

         return true;
    }
    
}    