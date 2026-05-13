package com.tup.programacion3;
import com.tup.programacion3.entities.DetallePedido;


import com.tup.programacion3.entities.Categoria;
import com.tup.programacion3.entities.Pedido;
import com.tup.programacion3.entities.Producto;
import com.tup.programacion3.entities.Usuario;
import com.tup.programacion3.enums.Estado;
import com.tup.programacion3.enums.FormaPago;
import com.tup.programacion3.enums.Rol;

import java.time.LocalDate;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // ============================
        // 1. USUARIOS (2)
        // ============================
        Usuario u1 = new Usuario(
                "Matias", "Carro", "matiascarro@mail.com", "123456789",
                "pass123", Rol.USUARIO
        );

        Usuario u2 = new Usuario(
                "Juan", "Perez", "juanperez@mail.com", "987654321",
                "clave456", Rol.ADMIN
        );


        // ============================
        // 2. CATEGORÍAS (3)
        // ============================
        Categoria cat1 = new Categoria("Placas de Video", "Tarjetas gráficas para gaming y diseño");
        Categoria cat2 = new Categoria("Microprocesadores", "CPUs Intel y AMD");
        Categoria cat3 = new Categoria("Almacenamiento", "Discos SSD y HDD");


        // ============================
        // 3. PRODUCTOS (10) – Partes de PC
        // ============================

        //Instanciando productos
        Producto p1 = new Producto("RTX 4060", 450000.0, "NVIDIA RTX 4060 8GB", 10, "rtx4060.jpg", true);
        Producto p2 = new Producto("RTX 4070 Super", 750000.0, "NVIDIA RTX 4070 Super 12GB", 8, "rtx4070s.jpg", true);
        Producto p3 = new Producto("RX 7600", 380000.0, "AMD Radeon RX 7600 8GB", 12, "rx7600.jpg", true);

        Producto p4 = new Producto("Intel i5 12400F", 180000.0, "Intel Core i5 12th Gen", 20, "i512400f.jpg", true);
        Producto p5 = new Producto("Intel i7 13700K", 420000.0, "Intel Core i7 13th Gen", 15, "i713700k.jpg", true);
        Producto p6 = new Producto("Ryzen 5 5600X", 200000.0, "AMD Ryzen 5 5600X", 18, "r55600x.jpg", true);

        Producto p7 = new Producto("SSD Kingston 480GB", 25000.0, "SSD SATA 480GB", 30, "ssd480.jpg", true);
        Producto p8 = new Producto("SSD NVMe 1TB", 55000.0, "SSD M.2 NVMe 1TB", 25, "nvme1tb.jpg", true);
        Producto p9 = new Producto("HDD Seagate 2TB", 35000.0, "Disco rígido 2TB", 20, "hdd2tb.jpg", true);
        Producto p10 = new Producto("SSD Samsung 980 Pro 2TB", 120000.0, "SSD NVMe Samsung 980 Pro 2TB", 10, "980pro.jpg", true);

        //asignacion de categorias
        p1.setCategoria(cat1);
        p2.setCategoria(cat1);
        p3.setCategoria(cat1);

        p4.setCategoria(cat2);
        p5.setCategoria(cat2);
        p6.setCategoria(cat2);

        p7.setCategoria(cat3);
        p8.setCategoria(cat3);
        p9.setCategoria(cat3);
        p10.setCategoria(cat3);

        // Colección de productos
        Set<Producto> productos = Set.of(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);

        // ============================
        // 4. PEDIDOS (3)
        // ============================
        Pedido ped1 = new Pedido(LocalDate.now(), Estado.PENDIENTE, 0.0, FormaPago.EFECTIVO);
        Pedido ped2 = new Pedido(LocalDate.now(), Estado.CONFIRMADO, 0.0, FormaPago.TARJETA);
        Pedido ped3 = new Pedido(LocalDate.now(), Estado.PENDIENTE, 0.0, FormaPago.TRANSFERENCIA);


        // Relacionar pedidos con usuarios
        u1.addPedido(ped1);
        u1.addPedido(ped2);
        u2.addPedido(ped3);


        // ============================
        // 5. DETALLES DE PEDIDO (mínimo 2 por pedido)
        // ============================

        // Pedido 1
        ped1.addDetallePedido(1, p1);
        ped1.addDetallePedido(2, p7);

        // Pedido 2
        ped2.addDetallePedido(1, p4);
        ped2.addDetallePedido(1, p8);

        // Pedido 3
        ped3.addDetallePedido(3, p3);
        ped3.addDetallePedido(1, p10);


        // ============================
        // 6. Mostrar un producto
        // ============================
        System.out.println("\n=== Mostrar un producto ===");
        System.out.println(p1);

        // ============================
        // 7. Listado de productos
        // ============================
        System.out.println("\n=== Listado de productos ===");
        productos.forEach(System.out::println);

        // ============================
        // Mostrar datos
        // ============================
        System.out.println("Usuarios:");
        System.out.println(u1);
        System.out.println(u2);

        System.out.println("\nPedidos del usuario 1:");
        for (Pedido p : u1.getPedidos()) {
            System.out.println(p);
            p.calcularTotal();
        }

        System.out.println("\nPedidos del usuario 2:");
        for (Pedido p : u2.getPedidos()) {
            System.out.println(p);
            p.calcularTotal();
        }

        // ============================
        // 8. Usuario con más pedidos
        // ============================
        System.out.println("\n=== Usuario con más pedidos ===");
        Usuario usuarioConMasPedidos =
                (u1.getPedidos().size() > u2.getPedidos().size()) ? u1 : u2;

        System.out.println("Usuario con más pedidos: " + usuarioConMasPedidos.getNombre());
        usuarioConMasPedidos.getPedidos().forEach(System.out::println);

        // ============================
        // 9. Comparación de productos (Punto 5 del TP)
        // ============================
        System.out.println("\n=== Comparación de productos ===");

        Producto p1Duplicado = new Producto(
                "RTX 4060",
                450000.0,
                "NVIDIA RTX 4060 8GB",
                10,
                "rtx4060.jpg",
                true
        );

        boolean existe = productos.contains(p1Duplicado);
        System.out.println("¿El producto ya existe en el Set? " + existe);

    }

}
