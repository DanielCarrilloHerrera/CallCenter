# CallCenter

Notas.

*Los eventos de la aplicación quedan registrados en el archivo logs/logs.log. Se recomienda revisar ese archivo para verificar el resultado de la prueba unitaria.

*La documentación del código se genero a partir da javadoc. Esta se encuentra en la carpeta doc. Se recomienda revisar.

*En caso de que no haya un empleado disponible para atender la llamada en ese momento, se procede a reintentar hasta 3 veces adicionales la asignación. Si aún no se logra asignar la llamada a un empleado no ocupado, se da la llamada por no atendida y se registra en el archivo de logs.

*La solución para cuando hay mas de 10 llamadas entrantes es la misma del punto anterior. La prueba unitaria esta programada para ser ejecutada con 10 empleados, distribuidos entre las distintas categorías especificadas. En dado caso, se puede modificar este número y sus correspondientes categorías segun convenga.
