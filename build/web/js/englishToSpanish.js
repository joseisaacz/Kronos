$(document).ready(function() {    
    $('#tableAcc').DataTable({
        "language": {
                "lengthMenu": "Mostrar _MENU_ Acuerdos",
                "zeroRecords": "No se encontraron resultados",
                "info": "Mostrando Acuerdos del _START_ al _END_ de un total de _TOTAL_ registros",
                "infoEmpty": "Mostrando Acuerdos del 0 al 0 de un total de 0 registros",
                "infoFiltered": "(filtrado de un total de _MAX_ Acuerdos)",
                "sSearch": "Buscar:",
                "oPaginate": {
                    "sFirst":"Primero",
                    "sLast":"Último",
                    "sNext":"Siguiente",
                    "sPrevious": "Anterior"
			     },
			     "sProcessing":"Procesando...",
            }
    });     
});