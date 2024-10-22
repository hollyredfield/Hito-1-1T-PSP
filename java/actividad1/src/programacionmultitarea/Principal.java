package programacionmultitarea;

public class Principal {
    public static void main(String[] args) throws InterruptedException {
        BufferExamenes generador = new BufferExamenes();
        for (String alumno : args) {
            new Thread(new ProductorExamenes(generador)).start();
            new Thread(new Examinador(alumno, generador)).start();
        }
        // Espera para dar tiempo a los hilos de ejecutarse
        Thread.sleep(5000); // Ajusta el tiempo según sea necesario
    }
}