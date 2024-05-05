package Interface;

import Conversor.ConversorMoneda;
import Model.Conversion;
import Model.Monedas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void printMenu() {
        String menu = """
                ******************************************************************
                **       Bienvenido al Alura Conversor de monedas               **
                ******************************************************************
                **       Seleccione comando                                     **
                **       1 - Convertir Monedas                                  **
                **       2 - Ver Codigos de Monedas                             **
                **       3 - Salir                                              **
                ******************************************************************""";
        System.out.println(menu);
        select();
    }

    public static void select() {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("**       Seleccione Comando                                     **");
            System.out.print("**       ");
            int comando = sc.nextInt();

            switch(comando) {
                case 1:
                    System.out.printf("**       %-55s**\n",
                            "Escriba moneda base");
                    System.out.print("**       ");
                    String base = sc.next().toUpperCase();
                    System.out.printf("**       %-55s**\n",
                            "Ingrese monto a convertir");
                    System.out.print("**       ");
                    double monto = sc.nextDouble();
                    if(monto < 0 ) {
                        throw new InputMismatchException();
                    }
                    System.out.printf("**       %-55s**\n",
                            "Escriba moneda objetivo");
                    System.out.print("**       ");
                    String objetivo = sc.next().toUpperCase();


                    Conversion conversion = ConversorMoneda.convertirMoneda(base, objetivo, monto);
                    System.out.println(conversion);
                    printMenu();
                    break;
                case 2:

                    Monedas monedas = ConversorMoneda.getMonedas();
                    System.out.println(monedas);
                    printMenu();
                    break;
                case 3:
                    System.out.printf("**       %-55s**",
                            "Gracias por usar el Alura Conversor");
                    break;
                default:
                    System.out.printf("**       %-55s**",
                            "Ingrese un comando válido");
                    printMenu();
                    break;
            }




        }catch(InputMismatchException e) {
            System.out.println("Error, ingrese un número válido");
        }

    }
}
