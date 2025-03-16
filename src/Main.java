import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// Clase que representa un empleado
class Empleado {
    private static int contadorEmpleados = 0; // Memoria estática para contar empleados
    private int id;
    private String nombre;
    private double salario;

    // Constructor de la clase Empleado
    public Empleado(String nombre, double salario) {
        this.id = ++contadorEmpleados;
        this.nombre = nombre;
        this.salario = salario;
    }

    // Métodos getters para acceder a los atributos privados
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getSalario() { return salario; }

    // Método para mostrar los datos del empleado
    public void mostrarEmpleado() {
        System.out.println("ID: " + id + " | Nombre: " + nombre + " | Salario: " + salario);
    }
}

// Clase que maneja la gestión de empleados
class GestorEmpleados {
    private ArrayList<Empleado> empleados = new ArrayList<>(); // Memoria dinámica para almacenar empleados

    // Método para agregar un nuevo empleado
    public void agregarEmpleado(String nombre, double salario) {
        empleados.add(new Empleado(nombre, salario));
        System.out.println("Empleado agregado exitosamente.");
    }

    // Método para mostrar todos los empleados registrados
    public void mostrarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            System.out.println("Lista de empleados:");
            for (Empleado e : empleados) {
                e.mostrarEmpleado();
            }
        }
    }

    // Clase principal que maneja la interacción con el usuario
    class AplicacionEmpleados {
        private static Scanner scanner = new Scanner(System.in);
        private static GestorEmpleados gestor = new GestorEmpleados();

        public static void main(String[] args) {
            int opcion;
            do {
                mostrarMenu();
                opcion = leerOpcion();
                ejecutarOpcion(opcion);
            } while (opcion != 3);
        }

        // Método para mostrar el menú
        private static void mostrarMenu() {
            System.out.println("\n--- Menú de Gestión de Empleados ---");
            System.out.println("1. Agregar empleado");
            System.out.println("2. Mostrar empleados");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
        }

        // Método para leer la opción del usuario con validación de entrada
        private static int leerOpcion() {
            int opcion = -1;
            try {
                opcion = scanner.nextInt();
                if (opcion < 1 || opcion > 3) {
                    System.out.println("Opción inválida. Intente de nuevo.");
                    return leerOpcion();
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número válido.");
                scanner.next(); // Limpiar el buffer
                return leerOpcion();
            }
            return opcion;
        }
}
// Método para ejecutar la opción seleccionada
    private static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                agregarEmpleado();
                break;
            case 2:
                gestor.mostrarEmpleados();
                break;
            case 3:
                System.out.println("Saliendo del sistema...");
                break;
        }
    }

    // Método para agregar un empleado con validación de entrada
    private static void agregarEmpleado() {
        System.out.print("Ingrese el nombre del empleado: ");
        scanner.nextLine(); // Limpiar buffer
        String nombre = scanner.nextLine();

        double salario = 0;
        while (true) {
            try {
                System.out.print("Ingrese el salario del empleado: ");
                salario = scanner.nextDouble();
                if (salario < 0) {
                    throw new IllegalArgumentException("El salario no puede ser negativo.");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número válido.");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        gestor.agregarEmpleado(nombre, salario);
    }
}
