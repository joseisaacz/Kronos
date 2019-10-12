/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function login(){
       
//    if (!isValidDate(deadline.value)) {
//        alert("La Fecha de Vencimiento no es válida");
//        return;
//    }
    let _url= 'api/login/log';
    let _username=document.getElementById('j_username').value;
    let _password=document.getElementById('j_password').value;
    let user={
        username:_username,
        password:_password
    };
    $.ajax({
        type: "POST",
        url: _url ,
        contentType: "application/json",
        data: JSON.stringify(user),
        success: function (msg) {
          alert("ACUERDO AGREGADO EXITOSAMENTE");
      },
        error: function (response) {
            console.log(response);
            if(response.status===503){
                alert("NO HAY ACUERDOS");
            }
            else
            alert("OCURRIO UN ERROR");
        }
    });
}