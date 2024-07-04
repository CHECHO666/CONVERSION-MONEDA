package com.Moneda.Conversion.com;

import com.Moneda.Conversion.com.ConsumiendoApi;
import com.Moneda.Conversion.com.Datos;

import java.io.IOException;
import java.util.*;

public class principal extends ConsumiendoApi{

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        Datos datos= new Datos();
        boolean salir = false;

        while(!salir ){
            System.out.println();
            System.out.println("************++******************************");
            System.out.println("---BIENVENIDO AL CONVERSOR DE MONEDA ONLINE---");
            System.out.println("***********************************************+");
            System.out.println();

            System.out.println("****************++****");
            System.out.println("--- MENU DE OPCIONES ---");
            System.out.println("**********************");
            System.out.println();

            System.out.println("""
                    [SELECCIONA UNA OPCION ]
                    
                    1-DIVISA DISPONIBLE PARA CONVERTIR
                    2-CONVERSION DE DIVISA
                    3-HISTORIAL DE BUSQUEDA
                    4-SALIR""");
            int opcion  = scanner.nextInt();

            switch (opcion){

                case 1:
                    System.out.println("--DIVISAS DISPONIBLE ---");
                    System.out.println();

                    String diviDisponibel = ApiDivisasDisponible.apiDivisas(datos);

                    System.out.println();
                    System.out.println("""
                                ¿DESEAS SALIR ?
                                1-SALIR
                                """);
                    int regresar = scanner.nextInt();

                    if (regresar == 1) {
                        System.out.println(regresar);
                    }
                    break;

                case 2:
                    boolean continuarConvirtiendo = true;
                    while (continuarConvirtiendo) {
                        System.out.println("--BIENVENIDO AL MENU DE CONVERSION --");
                        System.out.println();

                        System.out.println("--INGRESA LA DIVISA QUE DESEAS CONVERTIR-- ");
                        String divisaentrada = scanner.next();
                        divisaentrada = divisaentrada.toUpperCase();
                        datos.setDivisiaConvertir(divisaentrada);
                        System.out.println();

                        System.out.println("--¿A QUE DIVISA LA DESEAS CONVERTIR ?-- ");
                        String divisasalida = scanner.next();
                        divisaentrada = divisaentrada.toUpperCase();
                        datos.setDivisaAconvertir(divisasalida);
                        System.out.println();

                        System.out.println("--¿CANTIDAD DE DINERO DE  " + datos.getDivisiaConvertir()
                                + " QUE DESEA CONVERTIR ? -- ");
                        double cantidad = scanner.nextDouble();
                        datos.setCantidaConvertir(cantidad);
                        System.out.println();

                        System.out.println("VERIFICANDO CONVERSION ESPERA......");
                        System.out.println();
                        try {
                            ConsumiendoApi.cosumiendoapi(datos);

                        } catch (IOException | InterruptedException e) {
                            e.printStackTrace();

                        }
                            System.out.println("""
                                    ¿DESEAS SEGUIR CONVIRTIENDO DIVISAS? 
                                    SI / NO """);

                            String volveraintentar = scanner.next();
                            if (volveraintentar.equalsIgnoreCase("NO")) {
                                continuarConvirtiendo = false;
                            }
                    }
                    break;

                case 3:

                    System.out.println("-- HISTORIAL DE BÚSQUEDA --");
                    if (datos.getHistorialBusqueda().isEmpty()) {
                        System.out.println("No hay historial de búsqueda disponible.");

                        System.out.println("""
                                ¿DESEAS SALIR ?
                                1-SALIR
                                """);

                        int regresarmenu = scanner.nextInt();
                        if (regresarmenu == 1) {
                            System.out.println(regresarmenu);
                        }
                    }else {
                        for (Object resumen : datos.getHistorialBusqueda()) {
                            System.out.println(resumen);
                        }
                        System.out.println();
                        System.out.println("""
                                ¿DESEAS SALIR ?
                                1-SALIR
                                """);
                        int regresarmen = scanner.nextInt();

                        if (regresarmen == 1) {
                            System.out.println(regresarmen);
                        }
                    }
                    break;

                case 4:
                    System.out.println("saliendo......");
                    salir = true;
                    break;
                default:{
                    System.out.println("OPCION INVALIDA- INTENTALO DE NUEVO");
                }

            }

        }

    }
}


