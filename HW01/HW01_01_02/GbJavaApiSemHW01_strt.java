package HW01.HW01_01_02;

/*
1) Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
*/


/*
2) Вывести все простые числа от 1 до 1000
*/


public class GbJavaApiSemHW01_strt {

    public static void main(String[] args) {
        System.out.println(zadanye_01_p2_triangl_numbr(3));
        System.out.println(zadanye_01_p1_factorial(5));
        zadanye_02_prime_numbrs(1000);

    }

    private static void zadanye_02_prime_numbrs(int n) {
        if (n==1) ;
        else {
            zadanye_02_prime_numbrs(n-1);
        }
        int cntDel=0;
        int[] delm = new int[]{2,3,5};

        for (int j : delm) {
            if (n % j == 0) {
                cntDel++;
                break;
            }
        }
        if (cntDel==0) System.out.println(n);

    }

    private static int zadanye_01_p1_factorial(int n) {
        if (n == 1) return 1;
        else return n * zadanye_01_p1_factorial(n - 1);
    }

    private static int zadanye_01_p2_triangl_numbr(int n) {
        if (n == 1) return 1;
        else return n + zadanye_01_p2_triangl_numbr(n - 1);

    }


}
