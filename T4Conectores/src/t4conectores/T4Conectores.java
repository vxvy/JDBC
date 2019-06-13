/*
    Los ejercicios comentados son los que no se entregan
 */
package t4conectores;

/**
 *
 * @author VCV
 */
public class T4Conectores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, InterruptedException {

        T4Ejers_1_2_3_4_5 ejer_1_2_3_4_5 = new T4Ejers_1_2_3_4_5();
        
        System.out.println(ejer_1_2_3_4_5.consultaNombre());
        
        ejer_1_2_3_4_5.darDeAltaAlumnosYAsignaturas("alumnos", true);
        ejer_1_2_3_4_5.darDeAltaAlumnosYAsignaturas("asignaturas", false);
        
//        Thread.sleep(500);
//        
//        ejer_1_2_3_4_5.modificarAlumnosYAsignaturas("alumnos", true);
//        ejer_1_2_3_4_5.modificarAlumnosYAsignaturas("asignaturas", false);
//
//        ejer_1_2_3_4_5.darDeBajaAlumnosYAsignaturas("alumnos", true);
//        ejer_1_2_3_4_5.darDeBajaAlumnosYAsignaturas("asignaturas", false);
//
//        ejer_1_2_3_4_5.consultarNombresVarios(1);
        ejer_1_2_3_4_5.consultarNombresVarios(2);
//        ejer_1_2_3_4_5.consultarNombresVarios(3);
//
        T4Ejers_6_7_8 ejer_6_7_8 = new T4Ejers_6_7_8();
//        
        ejer_6_7_8.consultaPatronNombreAlumno("\"A%\"", 170, false);
        ejer_6_7_8.consultaPatronNombreAlumno("A%", 170, true);
//
//
//        ejer_6_7_8.testVelocidadPS1(1);
//        0 sec
//        ejer_6_7_8.testVelocidadRS1(1);
//        0 sec        
//
//        ejer_6_7_8.testVelocidadPS1(10);
//        0 sec
//        ejer_6_7_8.testVelocidadRS1(10);
//        0 sec
//        
//        ejer_6_7_8.testVelocidadPS1(100);
//        0 sec
//        ejer_6_7_8.testVelocidadRS1(100);
//        0 sec
//        
//        ejer_6_7_8.testVelocidadPS1(1000);
//        2 sec
//        ejer_6_7_8.testVelocidadRS1(1000);
//        1 sec
//        
//        ejer_6_7_8.testVelocidadPS1(10000);
//        13 sec
//        ejer_6_7_8.testVelocidadRS1(10000);
//        Si cada vez que ejecutamos esto, abrimos la conexión, 
//        el servidor no lo aguanta y genera errores SQL
//        Reformulado el ejercicio para que abra la conexión y la cierre una sóla vez por bucle
//        Volvermos a testear con los nuevos métodos
//        ejer_6_7_8.testVelocidadPS2(10000);
//        2 sec
//        ejer_6_7_8.testVelocidadRS2(10000);
//        1 sec
//        
//        ejer_6_7_8.testVelocidadPS2(100000);
//        12 sec
//        ejer_6_7_8.testVelocidadRS2(100000);
//        14 sec
//                
//        ejer_6_7_8.testVelocidadPS2(1000000);
//        1 minute 53 seconds
//        ejer_6_7_8.testVelocidadRS2(1000000);
//        2 minutes 13 seconds
//        
//
//        He creado la tabla test para ejecutar esta sentencia
//        ejer_6_7_8.anyadeColumnaATabla("test","test","VARCHAR(25)","NULL");
//        String tabla, String nombreDeCampo, String tipoDeDato, String propiedades
//
//
        T4Ejer_9 ejer_9 = new T4Ejer_9();
//        
//        ejer_9.ejer9_a();
//        ejer_9.ejer9_b();
//        ejer_9.ejer9_c();
        ejer_9.ejer9_d();
//        ejer_9.ejer9_e();
//        ejer_9.ejer9_f();
        ejer_9.ejer9_g();
//        ejer_9.ejer9_h();
//
//
        T4Ejers_10_al_17 ejers_10_al_17 = new T4Ejers_10_al_17();

        ejers_10_al_17.ejer10();
        
        ejers_10_al_17.ejer16();

    }
}
