import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ToDoList lista = new ToDoList();
        int opcion;

        do {
            System.out.println("==============================");
            System.out.println("     TO-DO LIST - CONSOLA     ");
            System.out.println("==============================");
            System.out.println("1. Ver tareas");
            System.out.println("2. Agregar tareas");
            System.out.println("3. Marcar tareas como completadas");
            System.out.println("4. Eliminar tareas");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            while (!sc.hasNextInt()) {
                System.out.print("Entrada no válida. Ingresa un número: ");
                sc.next();
            }

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    lista.listarTareas();
                    break;
                case 2:
                    System.out.print("Ingresa una o más tareas separadas por comas: ");
                    sc.nextLine();
                    String entrada = sc.nextLine();
                    String[] tareas = entrada.split(",");
                    for (String tarea : tareas) {
                        String descripcion = tarea.trim();
                        if (!descripcion.isEmpty()) {
                            lista.agregarTarea(descripcion);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Ingresa los índices de las tareas a completar (separados por comas): ");
                    sc.nextLine();
                    String indices = sc.nextLine();
                    String[] partes = indices.split(",");
                    for (String parte : partes) {
                        try {
                            int indice = Integer.parseInt(parte.trim());
                            lista.marcarTareaComoCompletada(indice);
                        } catch (NumberFormatException e) {
                            System.out.println("Valor inválido: " + parte.trim());
                        }
                    }
                    break;
                case 4:
                    System.out.print("Ingresa los índices de las tareas a eliminar (separados por comas): ");
                    sc.nextLine();
                    String eliminar = sc.nextLine();
                    String[] eliminarPartes = eliminar.split(",");
                    int[] indicesEliminar = new int[eliminarPartes.length];
                    for (int i = 0; i < eliminarPartes.length; i++) {
                        try {
                            indicesEliminar[i] = Integer.parseInt(eliminarPartes[i].trim());
                        } catch (NumberFormatException e) {
                            System.out.println("Valor inválido: " + eliminarPartes[i].trim());
                        }
                    }
                    lista.eliminarMultiplesTareas(indicesEliminar);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }

        } while (opcion != 5);

        sc.close();
    }
}
