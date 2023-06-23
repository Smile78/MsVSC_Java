package   HW04;


/*

Даны два Deque, представляющие два целых числа.

Цифры хранятся в обратном порядке и каждый из их узлов содержит одну цифру.
1) Умножьте два числа и верните произведение в виде связанного списка.
2) Сложите два числа и верните сумму в виде связанного списка.
Одно или два числа могут быть отрицательными.

Даны два Deque, цифры в обратном порядке.
[3,2,1] - пример Deque
[5,4,3] - пример второго Deque
1) 123 * 345 = 42 435

Ответ всегда - связный список, в обычном порядке
[4,2,4,3,5] - пример ответа

*/


import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class GbJavaApiSemHW04 {


    public static void main(String[] args) {

        method_1_hw_middle_outer();

    }


    private static void method_1_hw_middle_outer() {

//        List<Integer> dq1 = new LinkedList<>(List.of(3,2,1));
        Deque<Integer> dq1 = new ArrayDeque<>(List.of(3,2,1));
        Deque<Integer> dq2 = new ArrayDeque<>(List.of(5,4,3)); // рус запятые не Але...

        System.out.println(dq1);
        System.out.println(dq2);

        int chisl1 = 0;
        int chisl2 = 0;

        int sum = 0;
//        Optional<Integer> result1=dq1.stream().reduce((x,y)->(x+y*10));
//        System.out.println(result1);
//
//        Optional<Integer> result2=dq2.stream().reduce((x,y)->(x+y*10));
//        System.out.println(result2);

        Iterator<Integer> iter1  = dq1.iterator();
        Iterator<Integer> iter2  = dq2.iterator();

        int i=0;
        while (iter1.hasNext()){
//            System.out.println(dq1.getLast());
//            if (iter1.hasNext()){
//                Optional<Integer> opt1 = Optional.ofNullable(dq1.pollLast());
//                int val= iter1.next();
//                Optional<Integer> opt1 = Optional.ofNullable(iter1.next());
//                if (opt1.isPresent()){
//                    chisl1+=(int)(opt1.orElse(0)) *(Math.pow(10,i++));
//                    chisl1+=(int)(val) *(Math.pow(10,i++));
                    chisl1+=(int)(iter1.next()) *(Math.pow(10,i++));
//                }
//                System.out.println(opt1.get()+" "+ chisl1);
//            }
        }
//        chisl1+=dq1.pollLast()*(Math.pow(10,i++));


        int i2=0;
        while (iter2.hasNext()){
            chisl2+=(int)(iter2.next()) *(Math.pow(10,i2++));
        }

//        System.out.println(chisl1);
        int sum1 = chisl2+chisl1;
        int mult1 = chisl2*chisl1;

//        System.out.println("sum= "+sum1);
//        System.out.println("mult= "+mult1);

        Deque<Integer> lst1 = new LinkedList<>();
        String sumStr1 = String.valueOf(sum1);
        for (int j = 0; j <sumStr1.length() ; j++) {
            lst1.addFirst(sum1%10);
            sum1=sum1/10;
        }



//        System.out.print("[");
//        Iterator<Integer> iterLst1 = lst1.iterator();
//        while (iterLst1.hasNext()){
//            System.out.print(iterLst1.next()+",");
//        }
//        System.out.print("\b]\n");
//
//
        Deque<Integer> lst2 = new LinkedList<>();
        String multStr1 = String.valueOf(mult1);
        for (int j = 0; j <multStr1.length() ; j++) {
            lst2.addFirst(mult1%10);
            mult1=mult1/10;
        }
//        System.out.print("[");
//        Iterator<Integer> iterLst2 = lst2.iterator();
//        while (iterLst2.hasNext()){
//            System.out.print(iterLst2.next()+",");
//        }
//        System.out.print("\b]");

        System.out.println(lst1);
        System.out.println(lst2);

    }


}//class































