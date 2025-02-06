package org.base.apps.empresariales;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
// Lista de nombres de ejemplo
        List<String> nombres = Arrays.asList("Ana", "Ana","Alberto", "Juan", "Andrés", "María", "Antonio", "Pedro", "Amanda");

        // 1️⃣ Filtrar nombres que comiencen con 'A'
        List<String> nombresConA = nombres.stream()
                .filter(nombre -> nombre.startsWith("A"))
                .collect(Collectors.toList());

        // 2️⃣ Convertir todos los nombres a mayúsculas
        List<String> nombresMayusculas = nombres.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        // 3️⃣ Contar cuántos nombres tienen más de 5 letras
        long cantidadNombresLargos = nombres.stream()
                .filter(nombre -> nombre.length() > 5)
                .count();

        Map<String, Long> frecuenciaPalabras = nombres.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // 📌 Mostrar resultados
        System.out.println("Nombres que comienzan con 'A': " + nombresConA);
        System.out.println("Nombres en mayúsculas: " + nombresMayusculas);
        System.out.println("Cantidad de nombres con más de 5 letras: " + cantidadNombresLargos);
        System.out.println("Frecuencia de palabras en la lista: " + frecuenciaPalabras);
    }
}
