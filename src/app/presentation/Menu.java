package app.presentation;

import app.model.Estudiante;
import app.service.EstudianteService;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private final EstudianteService service;
    private final Scanner sc = new Scanner(System.in);

    public Menu(EstudianteService service) {
        this.service = service;
    }

    public void mostrar() {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- Gestión de Estudiantes ---");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Listar estudiantes");
            System.out.println("3. Eliminar estudiante");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");

            String opcion = sc.nextLine().trim();
            switch (opcion) {
                case "1":
                    registrar();
                    break;
                case "2":
                    listar();
                    break;
                case "3":
                    eliminar();
                    break;
                case "4":
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        System.out.println("Hasta luego.");
    }

    private void registrar() {
        System.out.print("Código: ");
        String codigo = sc.nextLine().trim();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine().trim();
        System.out.print("Edad: ");
        int edad;
        try {
            edad = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Edad inválida.");
            return;
        }

        Estudiante e = new Estudiante(codigo, nombre, edad);
        boolean ok = service.registrar(e);
        if (ok) {
            System.out.println("Estudiante registrado.");
        } else {
            System.out.println("No se pudo registrar. Revisa duplicados o datos inválidos.");
        }
    }

    private void listar() {
        List<Estudiante> lista = service.listar();
        if (lista.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        System.out.println("Lista de estudiantes:");
        lista.forEach(System.out::println);
    }


    private void eliminar() {
        System.out.print("Código a eliminar: ");
        String codigo = sc.nextLine().trim();
        boolean ok = service.eliminar(codigo);
        if (ok) {
            System.out.println("Estudiante eliminado.");
        } else {
            System.out.println("No se encontró el estudiante para eliminar.");
        }
    }
}

