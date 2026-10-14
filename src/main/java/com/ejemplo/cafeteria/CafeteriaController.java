package com.ejemplo.cafeteria;

// Permite crear endpoints REST que reciben peticiones HTTP
// y devuelven respuestas al cliente.
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Map;


//le indica a Spring Boot que esta clase atenderá
// peticiones de nuestra API y devolverá respuestas.
@RestController
public class CafeteriaController {
    // indica que este metodo respondera a peticiones GET
    // que llegue a la direccion / bienvenida
    @GetMapping("/bienvenida")
    public String bienvenida(){

        // este texto sera la repuesta que vera el usuario
        return "Bienvenido a Café Andino";
    }

    //Recibe el producto escrito despues de /pedido/
    @GetMapping("/pedido/{producto}")
    public String prepararPedido(@PathVariable String producto ) {

        // construye una respuesta utilizando el producto recibido.
        return "Preparando tu " + producto + "...";
    }


    // Este endpoit devuelve el menu de la cafeteria en formato JSON.
    @GetMapping("/menu")
    public Map<String, Integer> obtenerMenu() {

        //cada producto es una clave y su precio es el valor
        return Map.of(
                "tinto", 3000,
                "capuchino", 6500,
                "chocolate", 5500,
                "pan de bono", 2500
        );
    }


    // este endpoint devuelve la informacion general de la cafeteria.
    @GetMapping("/cafeteria")
    public Map<String, Object> obtenerCafeteria() {

        // guardamos el nombre, la ciudad, el estado y el horario.
        return Map.of(
                "nombre", "Café Andino",
                "ciudad", "Bogotá",
                "abierto", true,
                "horario", "6:00 a.m - 8:00 p. m."
        );

    }

    // Este endpoint calcula el costo total de un pedido.
    @GetMapping("/total/{precio}/{cantidad}")
    public String calcularTotal(
            @PathVariable int precio,
            @PathVariable int cantidad) {

        // Multiplicamos el precio por la cantidad de productos.
        int total = precio * cantidad;

        // Devolvemos el resultado como un mensaje.
        return "Total a pagar: $" + total;
    }

}
