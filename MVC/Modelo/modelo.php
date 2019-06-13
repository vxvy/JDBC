<?php
class Empleado {
    private $empleado;
    private $db;
    public function __construct() {
                $this->empleado = array();
        $this
->db = new PDO('mysql:host=localhost;dbname=ejemplo_mvc', "root", "");
} 
    public function getEmpleado() {
        $sql = "SELECT id, nombre, apellidos, telefono, departamento FROM empleados";
        foreach ($this->db->query($sql) as $res) {
            $this->empleado[] = $res;
        }
        return $this->empleado;
        $this->db = null;
    }
    public function setEmpleado($nombre, $apellidos, $telefono, $departamento) {
        $sql  =  "INSERT  INTO  empleados(nombre,  apellidos,  telefono,  departamento)  VALUES  ('".$nombre."','".$apellidos."','".$telefono."','". $departamento."')";
        $result = $this->db->query($sql);
        if ($result) {
            return true;
        } else {
            return false;
        }
    }
}