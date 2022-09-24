/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */
window.onload = function () {
    //Ejecución de recarga de página 
};

function enviarDatos() {
    const XHR = new XMLHttpRequest();
    var formData = new URLSearchParams(new FormData(document.getElementById('form'))).toString();

    XHR.addEventListener('error', (event) => {
        console.log('Upps.. Algo salió mal');
    });
    XHR.open('POST', 'NewServlet', true);
    XHR.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    XHR.onload = () => {
        if (XHR.readyState === XHR.DONE && XHR.status === 200) {
            console.log("Respuesta => " + XHR.response);
            document.getElementById('bodyTable').innerHTML = XHR.response;
            success();
            cleanForm();
        }
    };
    XHR.send(formData);
}

function cleanForm() {
    document.getElementById("codigo").value = '';
    document.getElementById("nombre").value = '';
    document.getElementById("pasta").value = '';
    document.getElementById("editorial").value = '';
    document.getElementById("año").value = '';
}

function eliminar(codigo) {
    const XHR = new XMLHttpRequest();
    var formData = new URLSearchParams(new FormData());

    // Define what happens in case of error
    XHR.addEventListener('error', (event) => {
        console.log('Oops! Something went wrong.');
    });

    // Set up our request
    XHR.open('POST', 'NewServlet', true);
    XHR.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    XHR.onload = () => {
        if (XHR.readyState === XHR.DONE && XHR.status === 200) {
            console.log("response => " + XHR.response);
            deleted();
            setTimeout(function () {
                window.location.reload();
            }, 2000);
        }
    };
    formData.append('codigo_libro', codigo);
    formData.append('control', 'ELIMINAR');
    XHR.send(formData);
}

function success() {
    const Toast = Swal.mixin({
        toast: true,
        position: 'top-end',
        showConfirmButton: false,
        timer: 3000,
        timerProgressBar: true,
        didOpen: (toast) => {
            toast.addEventListener('mouseenter', Swal.stopTimer);
            toast.addEventListener('mouseleave', Swal.resumeTimer);
        }
    });

    Toast.fire({
        icon: 'success',
        title: 'Registrado exitosamente!'
    });
}

function deleted() {
    Swal.fire({
        title: 'Registro eliminado exitosamente!',
        width: 600,
        padding: '3em',
        color: '#fff',
        background: '#fff url(https://b.rgbimg.com/users/x/xy/xymonau/600/mgZP6rW.jpg)',
        backdrop: `
    rgba(0,0,123,0.4)
    url("https://64.media.tumblr.com/1ba85ab48165850add73e21e84380427/81638282add66aaa-cb/s540x810/556c3d985b7e469e496d0bfdd1af3b20d7f17369.gifv")
    left top
    no-repeat
  `
    });
}