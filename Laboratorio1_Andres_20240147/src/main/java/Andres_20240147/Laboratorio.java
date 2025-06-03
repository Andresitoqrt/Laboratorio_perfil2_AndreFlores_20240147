package Andres_20240147;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Laboratorio {

    private TreeMap<Integer, Integer> productos = new TreeMap<>();
    private Scanner scanner = new Scanner(System.in);
    private final int Stock_Bajo = 10;

    public void Supermercado() {

        productos.put(20, 20); // Cafe
        productos.put(50, 50); // Cereal
        productos.put(8, 8);   // Banana
        productos.put(9, 9);   // Chocolate
        productos.put(19, 19); // Leche
        productos.put(3, 3);   // Helado
        productos.put(100, 100); // Gaseosas
        productos.put(90, 90);   // Jugos
        productos.put(40, 40);   // Galletas

        boolean salir = false;
        while (!salir) {
            System.out.println("-----Sistema-de-Supermecado----- ");
            System.out.println("1. Actualizar productos ");
            System.out.println("2. Mostrar productos ");
            System.out.println("3. Mostrar producto debajo de (<10)");
            System.out.println("4. salir");
            System.out.print("Selecione una opcion: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    modificarProductos();
                    break;
                case 2:
                    mostrarProductos();
                    break;
                case 3:
                    mostrarProductosStockBajo();
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }

        System.out.println("Sistema cerrado");
        scanner.close();
    }

    public void modificarProductos() {
        System.out.print("\nIngrese ID del producto: ");
        int id = scanner.nextInt();

        if (productos.containsKey(id)) {
            System.out.print("Ingrese nuevo stock: ");
            int nuevoStock = scanner.nextInt();

            productos.put(id, nuevoStock);
            System.out.println("Stock actualizado correctamente");
        } else {
            System.out.println("Producto no registrado");
        }
    }

    public void mostrarProductos() {
        System.out.println("\nLISTADO DE PRODUCTOS");
        System.out.println("ID\tStock");
        System.out.println("----------------");

        for (Map.Entry<Integer, Integer> entry : productos.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }

    public void mostrarProductosStockBajo() {
        System.out.println("\nPRODUCTOS CON STOCK BAJO (<" + Stock_Bajo + ")");
        System.out.println("ID\tStock");
        System.out.println("----------------");

        boolean hayStockBajo = false;

        for (Map.Entry<Integer, Integer> entry : productos.entrySet()) {
            if (entry.getValue() < Stock_Bajo) {
                System.out.println(entry.getKey() + "\t" + entry.getValue());
                hayStockBajo = true;
            }
        }

        if (!hayStockBajo) {
            System.out.println("No hay productos con stock bajo");
        }
    }
}