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
}
