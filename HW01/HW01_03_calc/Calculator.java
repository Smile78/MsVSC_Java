package HW01.HW01_03_calc;

import java.util.function.*;

public class Calculator {

    static Supplier<Calculator> instance = Calculator::new;

    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;


    BinaryOperator<Double> devide = (x, y) -> {
        double z =0;
        double x2=(double)x;
        double y2=(double)y;
        try {
            z= x2/y2;
         } catch (ArithmeticException exc){
            System.out.println("Йохохоу АрифметикException....\n" +
                    "нельзя делить на 0 и похорошему тут наверно надо все это заново вводить ... \n" +
                    "но какбы в задании такого нет... \n" );
        } finally {
        }

        return (Double)z;  
        };

    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;       // а здесь не приедикат !!!!

    Predicate<Integer> isPositive = x -> x > 0;                  // Predicate всетаки !!!!

    Consumer<Integer> println_int = System.out::println;    
    Consumer<Double> println_dbl = System.out::println;

    Consumer<Boolean> println2_bool = System.out::println;

}
