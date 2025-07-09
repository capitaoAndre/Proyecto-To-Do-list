import java.util.ArrayList;

public class ToDoList {
    private ArrayList<Tarea> tareas = new ArrayList<>();

    public void agregarTarea(String descripcion) {
        tareas.add(new Tarea(descripcion));
        System.out.println("Tarea agregada con éxito: " + descripcion);
    }

    public void listarTareas() {
        if (tareas.isEmpty()) {
            System.out.println("La lista está vacía.");
        } else {
            for (int i = 0; i < tareas.size(); i++) {
                System.out.println(i + ". " + tareas.get(i));
            }
        }
    }

    public void marcarTareaComoCompletada(int indice) {
        if (indiceValido(indice)) {
            tareas.get(indice).marcarCompletada();
            System.out.println("Tarea #" + indice + " marcada como completada.");
        } else {
            System.out.println("Índice inválido: " + indice);
        }
    }

    public void eliminarTarea(int indice) {
        if (indiceValido(indice)) {
            tareas.remove(indice);
            System.out.println("Tarea eliminada correctamente.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void eliminarMultiplesTareas(int[] indices) {
        ArrayList<Integer> listaIndices = new ArrayList<>();
        for (int i : indices) {
            if (indiceValido(i)) {
                listaIndices.add(i);
            } else {
                System.out.println("Índice inválido: " + i);
            }
        }

        listaIndices.sort((a, b) -> b - a); // de mayor a menor
        for (int i : listaIndices) {
            tareas.remove(i);
            System.out.println("Tarea #" + i + " eliminada.");
        }
    }

    private boolean indiceValido(int indice) {
        return indice >= 0 && indice < tareas.size();
    }
}