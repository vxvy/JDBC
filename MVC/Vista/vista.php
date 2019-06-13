<html>
    <head>
        <meta charset="UTF-8">
        <title>Ejemplo MVC con PHP</title>
    </head>
    <body>
<header>
            <h1>Ejemplo MVC con PHP</h1>
            <hr/>
</header>
        <div> 
            <h3>Listado de empleados</h3>
            <table
                <tr> 
                    <th>NOMBRE</th>
                    <th>APELLIDOS</th>
                    <th>TELÉFONO</th>
                    <th>DEPARTAMENTO</th>
                </tr>
                <?php
                    for ($i = 0; $i < count($datos); $i++) {
                ?>
                <tr> 
                <td><?php echo $datos[$i]["nombre"]; ?></td>
                <td><?php echo $datos[$i]["apellidos"]; ?></td>
                <td><?php echo $datos[$i]["telefono"]; ?></td>
                <td><?php echo $datos[$i]["departamento"]; ?></td>
                </tr>
                <?php                
                    }
                ?>
            </table>
            <a href="../index.php"> Volver a la página principal</a>
            <hr/>
        </div> 
    </body>
</html>