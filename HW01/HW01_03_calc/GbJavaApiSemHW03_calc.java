package HW01.HW01_03_calc;
 

import HW01.HW01_04_xX_chisla.InpSngltone;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;



/*
  3) Реализовать простой калькулятор (+-/*)
*/

public class GbJavaApiSemHW03_calc {
    public static InpSngltone inp1 = InpSngltone.getInstance();
    public static Calculator calc = Calculator.instance.get();

    public static Logger logr1 = Logger.getLogger(GbJavaApiSemHW03_calc.class.getName());
    public static FileHandler   flHndlr1;


    public static SimpleFormatter   smlF1;

    public GbJavaApiSemHW03_calc() throws IOException {

        flHndlr1 = new FileHandler("calc_log.txt");
        logr1.addHandler(flHndlr1);
        smlF1 = new SimpleFormatter();
        flHndlr1.setFormatter(smlF1);
    }


    public static void main(String[] args) {
        logr1.log(Level.ALL,"Start main");
        zadanye_03_calc();
//          inp1= new InpSngltone().getInstance();
        System.out.println("---stop calc---");
        logr1.log(Level.INFO,"Stop main");
    }


    private static void zadanye_03_calc() {

        boolean stop = false;

        while (!stop) {
            logr1.log(Level.ALL,"Start Calc cicle");

            System.out.println("---КАКБЫ_КАЛЬКУЛЯТОР_3.0---");
            System.out.println("Доступно: \nx+y - * / \nx abs(модуль) \nx pow(возведение в степень) \nx ?(чет нечет)");

            String str0mtd = inp_Method("Введите выражение, тока норм..  \nтипа: \n2 + 7\nили \n7 / 2\nили exit");

            if (str0mtd.equalsIgnoreCase("exit")) { //redundandy
                stop = true;
            } else {
                String[] str2 = str0mtd.split(" ");

                int x = Integer.valueOf(str2[0]);
                String sign = str2[1];
                int y = 666;

                logr1.log(Level.INFO,"x= "+x+" func= "+sign);

                if (str2.length > 2) {       

                    y = Integer.valueOf(str2[2]);
                    logr1.log(Level.INFO,"y= "+y);

                }


                if (sign.equalsIgnoreCase("+")) {
                    int a = calc.plus.apply(x, y);
                    calc.println_int.accept(a);
                    logr1.log(Level.INFO,"sum= "+a);
                } else if (sign.equalsIgnoreCase("-")) {
                    int b = calc.minus.apply(x, y);
                    System.out.println(b);
                    logr1.log(Level.INFO,"sub= "+b);
                } else if (sign.equalsIgnoreCase("/") & y!=666) {    
                    double c = calc.devide.apply(Double.valueOf(x), Double.valueOf(y));
                    calc.println_dbl.accept(c);
                    if (!Double.isInfinite(c)) {
                        logr1.log(Level.INFO,"deviding result is"+c);
                    } else  {logr1.log(Level.INFO,"devided by 0");
                        System.out.println("devided by 0");}
                } else if (sign.equalsIgnoreCase("*")) {
                    int c = calc.multiply.apply(x, y);
                    calc.println_int.accept(c);
                    logr1.log(Level.INFO,"multiplying result is= "+c);
                } else if (sign.equalsIgnoreCase("?")) {
                    boolean isPositiF = calc.isPositive.test(x);
                    calc.println2_bool.accept(isPositiF);
                    logr1.log(Level.INFO,"isPositive= "+isPositiF);
                } else if (sign.equalsIgnoreCase("abs")) {
                    int abs2 = calc.abs.apply(x);
                    calc.println_int.accept(abs2);
                    logr1.log(Level.INFO,"abs= "+abs2);
                } else if (sign.equalsIgnoreCase("pow")) {
                    int pow = calc.pow.apply(x);
                    calc.println_int.accept(pow);
                    logr1.log(Level.INFO,"pow= "+pow);
                }


            }

        }//while


    }//func


    private static String inp_Method(String prnt) {  // static?!
        InpSngltone inpSng = InpSngltone.getInstance();

        return inpSng.inp_Method(prnt);
    }


}
