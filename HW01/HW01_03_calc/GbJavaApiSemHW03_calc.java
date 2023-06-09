package HW01.HW01_03_calc;

import HW01.HW01_04_xX_chisla.InpSngltone;

/*
  3) Реализовать простой калькулятор (+-/*)
*/




public class GbJavaApiSemHW03_calc {
    static InpSngltone inp1 = InpSngltone.getInstance();
    static Calculator calc = Calculator.instance.get();
    


    public static void main(String[] args) {
        zadanye_03_calc();
//          inp1= new InpSngltone().getInstance();


    }


    private static void zadanye_03_calc() {

        boolean stop = false;

        while (!stop) {
            System.out.println("---КАКБЫ_КАЛЬКУЛЯТОР_2.0---");
            System.out.println("Доступно: \nx+y - * / \nx abs(модуль) \nx pow(возведение в степень) \nx ?(чет нечет)");

            String str0mtd = inp_Method("Введите выражение, тока норм..  \nтипа: \n2 + 7\nили \n7 / 2\nили exit");

            if (str0mtd.equalsIgnoreCase("exit")) { //redundandy
                stop = true;
            } else {
                String[] str2 = str0mtd.split(" ");

                int x = Integer.valueOf(str2[0]);
                String sign = str2[1];
                int y=666;
                if (str2.length > 2) {

                    y = Integer.valueOf(str2[2]);
                }


                if (sign.equalsIgnoreCase("+")) {
                    calc.println_int.accept(calc.plus.apply(x, y));
                } else if (sign.equalsIgnoreCase("-")) {
                    int b = calc.minus.apply(x, y);
                    System.out.println(b);
                } else if (sign.equalsIgnoreCase("/")) {
                    double c = calc.devide.apply(Double.valueOf(x), Double.valueOf(y));
                    calc.println_dbl.accept(c);
                } else if (sign.equalsIgnoreCase("*")) {
                    int c = calc.multiply.apply(x, y);
                    calc.println_int.accept(c);
                } else if (sign.equalsIgnoreCase("?")) {
                    boolean isPositiF = calc.isPositive.test(x);
                    calc.println2_bool.accept(isPositiF);
                } else if (sign.equalsIgnoreCase("abs")) {
                    int abs2 = calc.abs.apply(x);
                    calc.println_int.accept(abs2);
                } else if (sign.equalsIgnoreCase("pow")) {
                    int pow = calc.pow.apply(x);
                    calc.println_int.accept(pow);
                }


            }

        }//while


    }//func


    private static String inp_Method(String prnt) {  // static?!
        InpSngltone inpSng = InpSngltone.getInstance();

        return inpSng.inp_Method(prnt);
    }


}
