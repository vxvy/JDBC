<?php
    require_once("../modelo/modelo.php");
    $empleado = new Empleado();
    $datos = $empleado
->getEmpleado(); 
    require_once("../vista/vista.php");
