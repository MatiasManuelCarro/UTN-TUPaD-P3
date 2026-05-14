package com.utn;

import com.utn.entities.Categoria;
import com.utn.entities.Pedido;
import com.utn.entities.Producto;
import com.utn.entities.Usuario;
import com.utn.enums.Estado;
import com.utn.enums.FormaPago;
import com.utn.enums.Rol;

import java.time.LocalDate;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        // ============================
        // 1. USUARIOS (2)
        // ============================
        Usuario u1 = Usuario.builder()
                .nombre("Matias")
                .apellido("Carro")
                .mail("matias@mail.com")
                .celular("123456789")
                .contrasenia("pass123")
                .rol(Rol.USUARIO)
                .build();


        Usuario u2 = Usuario.builder()
                .nombre("Emiliano")
                .apellido("Gonzalez")
                .mail("Emiliano@mail.com")
                .celular("1100001111")
                .contrasenia("word456")
                .rol(Rol.USUARIO)
                .build();


        // ============================
        // 2. CATEGORÍAS (3)
        // ============================

        Categoria cat1 = Categoria.builder()
                .nombre("Placas de Video")
                .descripcion("Tarjetas Graficas, Nvidia, AMD e Intel")
                .build();
        Categoria cat2 = Categoria.builder()
                .nombre("Microprocesadores")
                .descripcion("Microprocesadores, CPUs Intel y AMD")
                .build();
        Categoria cat3 = Categoria.builder()
                .nombre("Almacenamiento")
                .descripcion("Discos HDD, SSD, M2 SATA y NVME")
                .build();



        // ============================
        // 3. PRODUCTOS (10) – Partes de PC
        // ============================

        //Instanciando productos
        Producto p1 = Producto.builder()
                .nombre("RTX 4060")
                .precio(450000.0)
                .descripcion("NVIDIA RTX 4060 8GB")
                .stock(10)
                .imagen("rtx4060.jpg")
                .disponible(true)
                .categoria(cat1)
                .build();

        Producto p2 = Producto.builder()
                .nombre("RTX 4070 Super")
                .precio(750000.0)
                .descripcion("NVIDIA RTX 4070 Super 12GB")
                .stock(8)
                .imagen("rtx4070s.jpg")
                .disponible(true)
                .categoria(cat1)
                .build();

        Producto p3 = Producto.builder()
                .nombre("RX 7600")
                .precio(380000.0)
                .descripcion("AMD Radeon RX 7600 8GB")
                .stock(12)
                .imagen("rx7600.jpg")
                .disponible(true)
                .categoria(cat1)
                .build();

        Producto p4 = Producto.builder()
                .nombre("Intel i5 12400F")
                .precio(180000.0)
                .descripcion("Intel Core i5 12th Gen")
                .stock(20)
                .imagen("i512400f.jpg")
                .disponible(true)
                .categoria(cat2)
                .build();

        Producto p5 = Producto.builder()
                .nombre("Intel i7 13700K")
                .precio(420000.0)
                .descripcion("Intel Core i7 13th Gen")
                .stock(15)
                .imagen("i713700k.jpg")
                .disponible(true)
                .categoria(cat2)
                .build();

        Producto p6 = Producto.builder()
                .nombre("Ryzen 5 5600X")
                .precio(200000.0)
                .descripcion("AMD Ryzen 5 5600X")
                .stock(18)
                .imagen("r55600x.jpg")
                .disponible(true)
                .categoria(cat2)
                .build();

        Producto p7 = Producto.builder()
                .nombre("SSD Kingston 480GB")
                .precio(25000.0)
                .descripcion("SSD SATA 480GB")
                .stock(30)
                .imagen("ssd480.jpg")
                .disponible(true)
                .categoria(cat3)
                .build();

        Producto p8 = Producto.builder()
                .nombre("SSD NVMe 1TB")
                .precio(55000.0)
                .descripcion("SSD M.2 NVMe 1TB")
                .stock(25)
                .imagen("nvme1tb.jpg")
                .disponible(true)
                .categoria(cat3)
                .build();

        Producto p9 = Producto.builder()
                .nombre("HDD Seagate 2TB")
                .precio(35000.0)
                .descripcion("Disco rígido 2TB")
                .stock(20)
                .imagen("hdd2tb.jpg")
                .disponible(true)
                .categoria(cat3)
                .build();

        Producto p10 = Producto.builder()
                .nombre("SSD Samsung 980 Pro 2TB")
                .precio(120000.0)
                .descripcion("SSD NVMe Samsung 980 Pro 2TB")
                .stock(10)
                .imagen("980pro.jpg")
                .disponible(true)
                .categoria(cat3)
                .build();


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
/*        Pedido ped1 = new Pedido(LocalDate.now(), Estado.PENDIENTE, 0.0, FormaPago.EFECTIVO);
        Pedido ped2 = new Pedido(LocalDate.now(), Estado.CONFIRMADO, 0.0, FormaPago.TARJETA);
        Pedido ped3 = new Pedido(LocalDate.now(), Estado.PENDIENTE, 0.0, FormaPago.TRANSFERENCIA);*/

        Pedido ped1 = Pedido.builder()
                .fecha(LocalDate.now())
                .estado(Estado.PENDIENTE)
                .formapago(FormaPago.EFECTIVO)
                .build();

        Pedido ped2 = Pedido.builder()
                .fecha(LocalDate.now())
                .estado(Estado.CONFIRMADO)
                .formapago(FormaPago.TARJETA)
                .build();

        Pedido ped3 = Pedido.builder()
                .fecha(LocalDate.now())
                .estado(Estado.PENDIENTE)
                .formapago(FormaPago.TRANSFERENCIA)
                .build();



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

        Producto p1Duplicado = Producto.builder()
                .nombre("RTX 4060")
                .precio(450000.0)
                .descripcion("NVIDIA RTX 4060 8GB")
                .stock(10)
                .imagen("rtx4060.jpg")
                .disponible(true)
                .categoria(cat1)
                .build();

        boolean existe = productos.contains(p1Duplicado);
        System.out.println(" ¿El producto ya existe en el Set? " + existe);

    }

}
