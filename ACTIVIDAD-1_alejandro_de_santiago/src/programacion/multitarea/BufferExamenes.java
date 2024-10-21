package programacion.multitarea;

import java.util.LinkedList;
import java.util.Queue;

public class BufferExamenes {
    private Queue<String> colaExamenes;

    public BufferExamenes() {
        colaExamenes = new LinkedList<>();
    }

    public synchronized void fabricarNuevoExamen(String codigo) {
        colaExamenes.add(codigo);
        notify();
    }

    public synchronized String consumirExamen() {
        while (colaExamenes.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return colaExamenes.poll();
    }
}