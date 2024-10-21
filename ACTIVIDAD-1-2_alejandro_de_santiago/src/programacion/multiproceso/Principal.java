package programacion.multitarea;

public class Principal {
    public static void main(String[] args) throws InterruptedException {
        BufferExamenes generador = new BufferExamenes();
        for (String alumno : args) {
            new Thread(new ProductorExamenes(generador)).start();
            new Thread(new Examinador(alumno, generador)).start();
        }
        
        Thread.sleep(5000); 
}