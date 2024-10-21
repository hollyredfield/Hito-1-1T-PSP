package programacion.multitarea;

import java.util.Random;

public class Examinador implements Runnable {
    private Thread hilo;
    private BufferExamenes buffer;

    public Examinador(String alumno, BufferExamenes generador) {
        this.buffer = generador;
        hilo = new Thread(this, alumno);
        hilo.start();
    }

    @Override
    public void run() {
        String codigoExamen = this.buffer.consumirExamen();
        if (codigoExamen != null) {
            Random rand = new Random();
            for (int i = 1; i <= 10; i++) {
                char respuesta = (char) ('A' + rand.nextInt(5));
                if (respuesta > 'D') respuesta = '-';
                System.out.println(codigoExamen + ";" + hilo.getName() + "; Pregunta " + i + ";" + respuesta);
            }
        } else {
            System.out.println("Agotado tiempo de espera y no hay más exámenes");
        }
    }
}