const usuarioHard = 'admin';
const passwordHard = 'admin';

document.addEventListener("DOMContentLoaded", 
function(){   
    document.getElementById("form-iniciosesion").addEventListener('submit',validar);
    const errorNombreUsuario = document.getElementById('errorNombreUsuario');
    const errorClave = document.getElementById('errorClave');
});

function validar(evento){
    evento.preventDefault();
    var usuario = document.getElementById('nombreUsuario').value;
    var clave = document.getElementById('clave').value;
    errorNombreUsuario.innerText = '';
    errorClave.innerText = '';
    if(usuario.length == 0 && clave.length > 0){
        errorNombreUsuario.innerText = 'El nombre de usuario es obligatorio';
        return;
    }
    if(usuario.length > 0 && clave.length == 0){
        errorClave.innerText = 'La clave es obligatoria';
        return;
    }
    if(usuario.length == 0 && clave.length == 0){
        errorNombreUsuario.innerText = 'El nombre de usuario es obligatorio';
        errorClave.innerText = 'La clave es obligatoria';
        return;
    }
    if(usuario == usuarioHard && clave == passwordHard){
        alert('credenciales correctas');
        window.location.replace= "https://www.google.com.ar/";
    }
    else{
        alert('credenciales incorrectas');
    }
    this.submit();
}







