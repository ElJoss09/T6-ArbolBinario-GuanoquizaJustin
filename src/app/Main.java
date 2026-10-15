package app;

import modelo.Nodo;
import negocio.ArbolBinario;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArbolBinario<String> arbol = new ArbolBinario<>();
        int opcion;

        do {
            System.out.println("\n--- MENÚ ÁRBOL BINARIO ---");
            System.out.println("1. Crear el árbol inicial (Universidad)");
            System.out.println("2. Visualizar el árbol");
            System.out.println("3. Consultar el número de nodos");
            System.out.println("4. Consultar el número de hojas");
            System.out.println("5. Consultar la altura");
            System.out.println("6. Consultar el grado de un nodo (Ej: FISEI)");
            System.out.println("7. Verificar si un nodo es hoja (Ej: SOFTWARE)");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    if (arbol.esVacio()) {
                        arbol.crearRaiz("UNIVERSIDAD");
                        Nodo<String> raiz = arbol.getRaiz();

                        arbol.agregarIzquierdo(raiz, "FISEI");
                        arbol.agregarDerecho(raiz, "DIDE");

                        Nodo<String> fisei = raiz.getIzquierdo();
                        Nodo<String> dide = raiz.getDerecho();

                        arbol.agregarIzquierdo(fisei, "SOFTWARE");
                        arbol.agregarDerecho(fisei, "TI");

                        arbol.agregarIzquierdo(dide, "INVEST.");
                        arbol.agregarDerecho(dide, "VINCULACIÓN");

                        Nodo<String> software = fisei.getIzquierdo();
                        arbol.agregarIzquierdo(software, "NIVEL1");
                        arbol.agregarDerecho(software, "NIVEL3");

                        System.out.println("Árbol inicial construido exitosamente.");
                    } else {
                        System.out.println("El árbol ya ha sido creado.");
                    }
                    break;
                case 2:
                    System.out.println("\nEstructura del Árbol:");
                    if (arbol.esVacio())
                        System.out.println("Árbol vacío.");
                    else
                        arbol.mostrarArbol();
                    break;
                case 3:
                    System.out.println("Número de nodos: " + arbol.contarNodos());
                    break;
                case 4:
                    System.out.println("Número de hojas: " + arbol.contarHojas());
                    break;
                case 5:
                    System.out.println("Altura del árbol (aristas): " + arbol.altura());
                    break;
                case 6:
                    if (!arbol.esVacio()) {
                        System.out.println("Grado de FISEI: " + arbol.getRaiz().getIzquierdo().grado());
                    } else {
                        System.out.println("Cree el árbol primero.");
                    }
                    break;
                case 7:
                    if (!arbol.esVacio()) {
                        Nodo<String> software = arbol.getRaiz().getIzquierdo().getIzquierdo();
                        System.out.println("¿El nodo SOFTWARE es hoja?: " + software.esHoja());
                    } else {
                        System.out.println("Cree el árbol primero.");
                    }
                    break;
                case 8:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 8);
        scanner.close();
    }
}
