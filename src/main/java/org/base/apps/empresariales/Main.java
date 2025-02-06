package org.base.apps.empresariales;

import org.base.apps.empresariales.service.FuncionesCalculoNumericoService;
import org.base.apps.empresariales.service.impl.FuncionesCalculoNumericoServiceImpl;
import org.base.apps.empresariales.utils.Utilidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private final FuncionesCalculoNumericoService funcionesCalculoNumericoService;

    public Main() {
        this.funcionesCalculoNumericoService = new FuncionesCalculoNumericoServiceImpl();
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        Integer opcion = opcionLogica(scanner);
        boolean cambiarOpcion = false;
        while (true){
            if(cambiarOpcion){
                opcion = opcionLogica(scanner);
            }
            try{
                switch (opcion){
                    case 1 -> {
                        System.out.println("Coloca un numero:");
                        Optional<Integer> numero = Utilidades.checkType(scanner.next(), Integer.class);
                        numero.ifPresentOrElse(
                                n -> System.out.println(funcionesCalculoNumericoService.numeroPrimo(n)),
                                () ->  System.out.println("No se envio ningun valor")
                        );
                    }
                    case 2 -> {
                        System.out.println("Cuantos numeros deseas ingrear:");
                        Optional<Integer> numero = Utilidades.checkType(scanner.next(), Integer.class);
                        AtomicInteger cantidad = new AtomicInteger(0);
                        List<Integer> numeros = new ArrayList<>();
                        while (cantidad.get() < numero.get()){
                            try {
                                System.out.println("Pon un numero");
                                Optional<Integer> numeroAsignar = Utilidades.checkType(scanner.next(), Integer.class);
                                numeroAsignar.ifPresentOrElse(
                                        n -> {
                                            numeros.add(n);
                                            cantidad.addAndGet(1);
                                        },
                                        () -> System.out.println("Lo que se mando no es un numero, por favor ingresa un numero")
                                );
                            }catch (Exception ex){
                                System.err.println(ex);
                                System.out.println("Lo que se mando no es un numero, por favor ingresa un numero");
                            }
                        }
                        System.out.println(funcionesCalculoNumericoService.numeroGrandePequeno(numeros));
                    }
                    case 3 ->{
                        while (true){
                            System.out.println("Pon una palabra:");
                            String palabra = scanner.next();
                            if(palabra.matches("-?\\d+(\\.\\d+)?")){
                                System.out.println("Lo que ingresaste es un numero no una palabra");
                            }else{
                                System.out.println(funcionesCalculoNumericoService.palabraPalindroma(palabra));
                                break;
                            }
                        }
                    }
                }
                if(!repetir(scanner, "¿Quieres seguir en el programa?")){
                    break;
                }
                cambiarOpcion = repetir(scanner, "¿Quieres cambiar de opcion?");
            }catch (Exception ex){
                System.err.println(ex);
                if(!repetir(scanner, "¿Quieres seguir en el programa?")){
                    break;
                }
            }
        }

    }

    private int opcionLogica(Scanner scanner){
        List<Integer> valoresValidos = new ArrayList<>();
        valoresValidos.add(1);
        valoresValidos.add(2);
        valoresValidos.add(3);
        int respuesta;
        while (true){
            try{
                System.out.println("¿Que opcion quieres? \n 1.Numero primo \n 2.listado de numeros para tener el mas grande y el mas pequeño \n 3.Palabra palindromo");
                Optional<Integer> opcion = Utilidades.checkType(scanner.next(), Integer.class);
                if(opcion.isPresent()){
                    if(!valoresValidos.contains(opcion.get())){
                        System.out.println("Debes escoger alguno de las opciones disponibles");
                    }else{
                        respuesta = opcion.get();
                        break;
                    }
                }else{
                    System.out.println("Lo que se puso no es numerico, porfavor, pon numeros");
                }
            }catch (Exception ex){
                System.out.println(ex);
                System.out.println("Lo que se puso no es numerico, porfavor, pon numeros");
            }
        }
        return respuesta;
    }

    private boolean repetir(Scanner scanner, String texto){
        boolean retornar;
        while (true){
            System.out.println(texto);
            String respuesta = scanner.next();
            if(respuesta.equalsIgnoreCase("si") || respuesta.equalsIgnoreCase("no")){
                retornar = respuesta.equalsIgnoreCase("si");
                break;
            } else{
                System.out.println("Debes colocar solo si o no");
            }
        }
        return retornar;
    }


    public  static void main(String[] args){
        new Main().iniciar();
    }

}