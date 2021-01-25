package com.daw.eva.exemplesExtra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Principal {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);

        double num = 0;
        double div = 0;
        boolean correct = true;


        while (correct == true){
            try{
                System.out.println("block try: introdueix un número (dividendo):");

                BufferedReader datosLeidosPorConsolaTmp = new BufferedReader(new InputStreamReader(System.in));
                String datosLeidosPorConsola;
                datosLeidosPorConsola = datosLeidosPorConsolaTmp.readLine();
                num = Integer.parseInt(datosLeidosPorConsola);
                //num = scan.nextInt();

                System.out.println("block try: introdueix un número (divisor):");
                datosLeidosPorConsola = datosLeidosPorConsolaTmp.readLine();
                div = Integer.parseInt(datosLeidosPorConsola);
                //div = scan.nextInt();

                double res = (num / div);

                if(Double.isInfinite(res)) throw new MyException();

                System.out.println("block try: resultat = " + res);
            } catch(ArithmeticException  e) {
                System.out.println("--------------");
                System.out.println("block catch(ArithmeticException): e.printStackTrace(): ");
                e.printStackTrace();
                System.out.println("--------------");
            } catch (MyException e) {
                System.out.println(e.getMessage());
                System.out.println("block catch(MyException): e.printStackTrace(): ");
                e.printStackTrace();
                correct = false;
            } finally {
                System.out.println("block finally: sempre entra!!");
            }
        }
    }
}