/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


document.addEventListener("DOMContentLoaded", function () {
    let loginAnchor=document.getElementById('loginAnchor');
    if(sessionStorage.ROLE === undefined){
        loginAnchor.innerHTML='';
        loginAnchor.innerHTML='LOGIN';
        loginAnchor.href='/Kronos/login.jsp';
        
    }
    else{
         loginAnchor.innerHTML='';
        loginAnchor.innerHTML='SALIR';
        loginAnchor.href='';
        loginAnchor.onclick=logout;
    }
});
