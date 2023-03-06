package com.pjatk.example.mathutils;

import static java.lang.Math.pow;

public class MathUtils {

    /*
        Funkcja oblicza n!
     */
    public static int factorial(int n){

        int multiply = 1;
        for (int i=1; i<=n; i++) {
            multiply *= i;
        }
        return multiply;
    }

    /*
        Funkcja oblicza n! (zastosować rekurencję)
     */
    public static int factorialRecursive(int n){

        if (n==0)
            return 1;
        else
            return (n*factorialRecursive(n-1));

    }

    /*
        Funkcja oblicza przyblożoną całkę oznaczoną od a do b dla wielomiany o podanych w tabeli współczunnikach
        (całka oznaczona to pole powierzchni pod wykresem wielomianu na przedziale [a,b])
     */
    public static double integralOfPolynomial(double[] coefficients,double a, double b){

    //-1 x2 + 0x + 1
        //double w0=coefficients[0];
        //double w1=coefficients[1];
        //double w2=coefficients[2];

        double wynik1 = 0;
        double wynik2 = 0;
        double wynik = 0;
        //double wynik =((w2*pow(b,3))/3+(w1*pow(b,2))/2+(w0*b)/1) - ((w2*pow(a,3))/3+(w1*pow(a,2))/2+(w0*a)/1);

        int length = coefficients.length; //3

        for(int i=0;i<length;i++){

            wynik1=wynik1+((coefficients[length-i-1]*pow(a,i+1))/(i+1));

        }
        for(int i=0;i<length;i++){

            wynik2=wynik2+((coefficients[length-i-1]*pow(b,i+1))/(i+1));

        }
        wynik = wynik1-wynik2;



        return wynik;
    }

    /*
        Funkcja przedstawia nieskracalny ułamek w postaci a/b
        np. dla 9/12 zwróci "3/4"
                15/5 zwróci "3"
     */
    public static String simplifyFractionInString(int meter, int denominator){

        if(meter==0) return "0";
        else if(denominator==0) return "brak rozwiązan";
        else {
            for (int i = meter; i > 0; i--) {
                if (meter % i == 0 && denominator % i == 0) {

                    meter = meter / i;
                    denominator = denominator / i;

                }
            }


            return "" + meter + "/" + denominator;
        }
    }

}
