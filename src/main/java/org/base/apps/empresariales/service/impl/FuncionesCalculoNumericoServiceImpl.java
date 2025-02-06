package org.base.apps.empresariales.service.impl;

import org.base.apps.empresariales.service.FuncionesCalculoNumericoService;

import java.util.List;

public class FuncionesCalculoNumericoServiceImpl implements FuncionesCalculoNumericoService {

    @Override
    public String numeroPrimo(Integer numero) {
        int numeroDividir = 1;
        boolean primo = true;
        String texto = "El numero %s %s";
        while(true){
            if(numeroDividir > numero){
                break;
            }
            if((numeroDividir != 1 && numeroDividir != numero) && (numero % numeroDividir == 0)  ){
                primo = false;
                break;
            }
            numeroDividir++;
        }
        return String.format(texto, numero, primo ? "es primo" : "no es primo");
    }

    @Override
    public String numeroGrandePequeno(List<Integer> numeros) {
        Integer numeroGrande = numeros.get(0);
        Integer numeroPequeno = numeros.get(0);
        String texto = "El numero mas grande es %s y el numero mas pequeño es %s";
        for(Integer numero : numeros){
            if(numero > numeroGrande){
                numeroGrande = numero;
            }
        }
        for(Integer numero : numeros){
            if(numero < numeroPequeno){
                numeroPequeno = numero;
            }
        }
        return String.format(texto, numeroGrande, numeroPequeno);
    }

    @Override
    public String palabraPalindroma(String palabra) {
        StringBuilder palabraReves = new StringBuilder(palabra).reverse();
        String texto = "La palabra %s %s";
        boolean palindroma = palabraReves.toString().equalsIgnoreCase(palabra);
        return String.format(texto, palabra, palindroma ? "es palindroma" : "no es palindroma");
    }
}
