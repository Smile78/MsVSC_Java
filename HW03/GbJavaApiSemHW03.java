package    HW03;


/*
Урок 3. Коллекции JAVA: Введение
Задание

Пусть дан произвольный список целых чисел.

1) Нужно удалить из него чётные числа / одно дб отрицательное

2) Найти минимальное значение
3) Найти максимальное значение
4) Найти среднее ариф. значение



*/


import java.util.*;

// import static java.util.Collections.max;
// import static java.util.Collections.min;

public class GbJavaApiSemHW03 {


    public static void main(String[] args) {

        method_1_hw_middle_outer();

        method_hw_2_del_even();

    }

    private static void method_hw_2_del_even() {
        List<Integer> arr1 = new ArrayList<>();

//        Random rnd1 = new Random();
//
//        for (int i = 0; i < 4; i++) {
//            arr1.add(rnd1.nextInt( -10,5));
//        }
//        arr1 = new ArrayList<>(List.of(3, 3, 5, 5, 4, 687, 4, -4));
        arr1 = new LinkedList<>(List.of(3, 3, 5,4, 5, 687, 7, 3,-4));

        Iterator<Integer> iter1 = arr1.iterator();


        while (iter1.hasNext()){
            int nbmr1= iter1.next();
            if((double)nbmr1%2==0){
//                arr1.remove(arr1.get(nbmr1));
                     iter1.remove();
            }
        }
        System.out.println(arr1);
    }


    private static void method_1_hw_middle_outer() {
        List<Integer> arr1 = new ArrayList<>();

        Random rnd1 = new Random();

        for (int i = 0; i < 4; i++) {
            arr1.add(rnd1.nextInt(-10, 5));
        }

        method_1_hw_middle_inner(arr1);

        arr1 = new ArrayList<>(List.of(60, 120, 120, 120, 40, 40));
        method_1_hw_middle_inner(arr1);

        arr1 = new ArrayList<>(List.of(12000, 12000, 12000, 12000, 100000));
        method_1_hw_middle_inner(arr1);

    }

    private static void method_1_hw_middle_inner(List<Integer> arr1) {

        System.out.println(arr1);

        Map<Integer, Integer> mp1 = new HashMap<>();

        int min = arr1.get(0);
        int max = arr1.get(0);

        int sum = 0;
        for (Integer val : arr1) {
            if (val < min) {
                min = val;
            } else if (val > max) {
                max = val;
            }
            sum += val;
            if (mp1.containsKey(val)) {
                mp1.put(val, mp1.get(val) + val);
            } else mp1.put(val, val);

        }

        int sum4Mid = 0;  //какбы обычн сумма  НО с учетом разложеного ряда (структуры

        for (var mp1v : mp1.entrySet()) {
            sum4Mid += mp1v.getValue();
        }

//        mp1.entrySet().stream().forEach(System.out::println);

        Set<Integer> st1 = new HashSet<>();
        for (var ar : arr1) {
            st1.add(ar);
        }
        int sumAr = 0;
        for (var st11 : st1) {
            sumAr += st11;
        }

        //  "класич cреднее арифм "     // среднее сет арифметическое    // Фейк асбтрактный
        double midSetArifm = (double) sumAr / st1.size();

        // средний на отрезке
        double midOtrzk = (double) (min + max) / 2;

        // cреднее арифм                //взвешен - потомучто разложен ряд повторов
        double Avrg1 = (double) sum / arr1.size();


        // cреднее арифм взвешен        //если бы сумма по мапе
        double weitAvrg2 = (double) sum4Mid / arr1.size();// обычн сумм на обычн кол-во


        System.out.printf("min=%d max=%d midSetArifm=%.2f midOtrzk=%.2f  Avrg1=%.2f  weitAvrg2=%.2f  \n ------------------- \n", min, max, midSetArifm, midOtrzk, Avrg1, weitAvrg2);
//        System.out.printf("min=%d max=%d midSetArifm=%.2f midOtrzk=%.2f  Avrg1=%.2f  \n ------------------- \n",min, max,midSetArifm, midOtrzk,Avrg1);


    }


}//class
