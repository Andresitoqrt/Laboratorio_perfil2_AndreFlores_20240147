package Andres_20240147;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Laboratorio {

    private TreeMap<Integer, String> nombresProductos = new TreeMap<>();
    private TreeMap<Integer, Integer> stockProductos = new TreeMap<>();
    private Scanner scanner = new Scanner(System.in);
    private final int STOCK_BAJO = 10;

    public void Supermercado() {
        // Inicializar productos tecnológicos
        nombresProductos.put(101, "Laptop HP EliteBook");
        stockProductos.put(101, 20);

        nombresProductos.put(102, "Smartphone Samsung Galaxy");
        stockProductos.put(102, 50);

        nombresProductos.put(103, "Tablet iPad Pro");
        stockProductos.put(103, 8);

        nombresProductos.put(104, "Auriculares Sony WH-1000XM4");
        stockProductos.put(104, 9);

        nombresProductos.put(105, "Teclado Mecánico Razer");
        stockProductos.put(105, 19);

        nombresProductos.put(106, "Mouse Logitech MX Master");
        stockProductos.put(106, 3);

        nombresProductos.put(107, "Monitor LG UltraWide");
        stockProductos.put(107, 100);

        nombresProductos.put(108, "Impresora Epson EcoTank");
        stockProductos.put(108, 90);

        nombresProductos.put(109, "Disco Duro SSD 1TB");
        stockProductos.put(109, 40);

        boolean salir = false;
        while (!salir) {
            System.out.println("\n----- Sistema de Inventario Tecnológico -----");
            System.out.println("1. Actualizar stock de producto");
            System.out.println("2. Mostrar todos los productos");
            System.out.println("3. Mostrar productos con stock bajo (<" + STOCK_BAJO + ")");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

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

        if (nombresProductos.containsKey(id)) {
            System.out.println("Producto: " + nombresProductos.get(id));
            System.out.print("Ingrese nuevo stock: ");
            int nuevoStock = scanner.nextInt();

            stockProductos.put(id, nuevoStock);
            System.out.println("Stock actualizado correctamente");
        } else {
            System.out.println("Producto no registrado");
        }
    }

    public void mostrarProductos() {
        System.out.println("\nLISTADO DE PRODUCTOS TECNOLÓGICOS");
        System.out.println("ID\tNombre\t\t\tStock");
        System.out.println("----------------------------------------");

        for (Map.Entry<Integer, String> entry : nombresProductos.entrySet()) {
            int id = entry.getKey();
            System.out.printf("%d\t%-25s%d\n", id, entry.getValue(), stockProductos.get(id));
        }
    }

    public void mostrarProductosStockBajo() {
        System.out.println("\nPRODUCTOS CON STOCK BAJO (<" + STOCK_BAJO + ")");
        System.out.println("ID\tNombre\t\t\tStock");
        System.out.println("----------------------------------------");

        boolean hayStockBajo = false;

        for (Map.Entry<Integer, Integer> entry : stockProductos.entrySet()) {
            if (entry.getValue() < STOCK_BAJO) {
                int id = entry.getKey();
                System.out.printf("%d\t%-25s%d\n", id, nombresProductos.get(id), entry.getValue());
                hayStockBajo = true;
            }
        }

        if (!hayStockBajo) {
            System.out.println("No hay productos con stock bajo");
        }
    }
}