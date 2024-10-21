package programacion.multiproceso;

import java.io.IOException;

public class Lanzador {
    public static void main(String[] args) throws IOException {
        String classpath = "C:/Users/CampusFP/Desktop/java/ACTIVIDAD-1_alejandro_de_santiago/bin;C:/Users/CampusFP/Desktop/java/ACTIVIDAD-1-2_alejandro_de_santiago/bin";

        String[] cmd1 = {"java", "-cp", classpath, "programacion.multitarea.Principal", "Pepe", "Juan", "Luis"};
        String[] cmd2 = {"java", "-cp", classpath, "programacion.multitarea.Principal", "Rosa", "Miguel", "Pedro"};

        ProcessBuilder pb1 = new ProcessBuilder(cmd1);
        pb1.redirectOutput(ProcessBuilder.Redirect.to(new java.io.File("examen1.txt")));
        pb1.redirectErrorStream(true); // Redirige también la salida de error
        Process p1 = pb1.start();
        System.out.println("Proceso 1 iniciado");

        ProcessBuilder pb2 = new ProcessBuilder(cmd2);
        pb2.redirectOutput(ProcessBuilder.Redirect.to(new java.io.File("examen2.txt")));
        pb2.redirectErrorStream(true); // Redirige también la salida de error
        Process p2 = pb2.start();
        System.out.println("Proceso 2 iniciado");

        // Espera a que los procesos terminen
        try {
            p1.waitFor();
            p2.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Procesos terminados");
    }
}