package HW01.HW01_04_xX_chisla;


/*
4) (дополнительное задание) Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69. Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.
Под знаком вопроса - всегда одинаковая ЦИФРА.
Введите уравнение: ?? + ?? = 44
Решение: 22 + 22 = 44
*/

public class GbJavaApiSemHW04_xX_Chisla {
//    static InpSngltone inp1 = InpSngltone.getInstance();
    static InpSngltone inp1 ;

    public static void main(String[] args) {
        zadanye_04_qCyphers_02_02();
         inp1=    InpSngltone.getInstance();
    }


    private static void zadanye_04_qCyphers_02_02() {

        boolean stop=false;

        while (!stop){

            String str0mtd = inp_Method("Введите уравнение, тока норм..  \nтипа: \n2? + ?7 = 82\nили \n?7 + 2? = 82\nили exit");

            if(str0mtd.equalsIgnoreCase("exit")){ //redundandy
                stop=true;
//                break;
            } else if (str0mtd.equalsIgnoreCase("tred")){ //redundandy
//                System.out.println("tred inp cls    "+inp1.getClass().getName());  хз тока если new
//                System.out.println("tred inp inst   "+inp1); // null
            } else {
                String[] str2 = str0mtd.split(" ");

                String chisl_X1_str = str2[0];
                String chisl_Y1_str = str2[2];
 //                int A = 0;
//                int B = 0;
                int[] ab= new int[2];
                int sum = Integer.parseInt(str2[4]);


                if ((chisl_X1_str.charAt(1) == '?' & chisl_Y1_str.charAt(0) == '?' )  | ( chisl_X1_str.charAt(0) == '?' & chisl_Y1_str.charAt(1) == '?' )){
                    ab= qcyph_02_srch_1x_x1_IF(str0mtd,chisl_X1_str,chisl_Y1_str,sum);
                }

                System.out.println("стрИнп1: " + str0mtd);
                System.out.println("стрАут1: " + ab[0]+ " + " + ab[1] + " == " + (ab[0] + ab[1]));


            }

        }//while



    }//func

    private static int[] qcyph_02_srch_1x_x1_IF(String str0mtd, String chisl_X1_str,String chisl_Y1_str,int sum) {
        int A = 0;
        int B = 0;
        int[] ab= new int[2];

//        System.out.println( chisl_X1_str+" "+ chisl_Y1_str);

        if (chisl_X1_str.charAt(1) == '?' & chisl_Y1_str.charAt(0) == '?') {

            A = Integer.parseInt(chisl_X1_str.substring(0, 1));
            B = Integer.parseInt(String.valueOf(chisl_Y1_str.charAt(1)));

        } else if (chisl_X1_str.charAt(0) == '?' & chisl_Y1_str.charAt(1) == '?') {

            A = Integer.parseInt(String.valueOf(chisl_Y1_str.charAt(0)));
            B = Integer.parseInt(chisl_X1_str.substring(1, 2));
        }

        ab = qcyph_02_srch_1x_x1(  str0mtd,A, B,sum);
        return ab;
    }


    // если 1x x2 only
    private static int[] qcyph_02_srch_1x_x1(String str0mtd, int chisl10_1x, int chisl1_x1, int sum) {
        int[] ab= new int[2];
        for (int i = 0; i < 10; i++) {                                      // сразу одинаковое число
            int x = chisl10_1x * 10 + i;
            int y = chisl1_x1 + i * 10;
//            System.out.println(x+" "+y);
            if ((x + y) == sum) {
//                System.out.println("стрИнп1: " + str0mtd);
//                System.out.println("стрАут1: " + x + " + " + y + " == " + (x + y));
                ab[0]=x;
                ab[1]=y;
                System.out.println(ab[0]);
                System.out.println(ab[1]);


            }
        }
        return ab;
    }



    @Deprecated(since = "2.0. - lowReadable")
    private static void zadanye_04_qcypher_02() {

        String str0mtd = inp_Method("Введите уравнение, тока норм..  \nтипа: \n2? + ?7 = 82\nили \n7 + 2? = 82");
//                                                                2? + ?7 = 82
//                                                                ?7 +  2? = 82
        String[] str2 = str0mtd.split(" ");             //  0    2    4
//        System.out.println(Arrays.toString(str2));

        int chisl_A_10_1x;
        int chisl_B_1_x1;


        int sum = Integer.parseInt(str2[4]);

        // "2? + ?7 = 82";    //"?7 + 2? = 82";   // 4 позиц в мссв
        if (str2[0].charAt(1) == '?' & str2[2].substring(0, 1).equals("?")) {

            chisl_A_10_1x = Integer.parseInt(String.valueOf(str2[0].charAt(0)));             // "2?";
            chisl_B_1_x1 = Integer.valueOf(str2[2].substring(1, 2));                        // "?7";
            System.out.println("varik1_1");

            qcyph_02_srch_1x_x1(str0mtd, chisl_A_10_1x, chisl_B_1_x1, sum);           // здесь в отд методе -чтобы ИДа не ругалась на НеИниациализацию

        } else if (str2[0].charAt(0) == '?' & str2[2].substring(1, 2).equals("?")) {

            chisl_A_10_1x = Integer.valueOf(str2[2].substring(0, 1));                       // "2?";
            chisl_B_1_x1 = Integer.parseInt(String.valueOf(str2[0].charAt(1)));             // "?7";
            System.out.println("varik1_2");
            qcyph_02_srch_1x_x1(str0mtd, chisl_A_10_1x, chisl_B_1_x1, sum);           // здесь в отд методе -чтобы ИДа не ругалась на НеИниациализацию

        }

    }

    @Deprecated(since = "1.0. - 2muchtime")
    private static void zadanye_04_qcypher() {



        //        String str0mtd = inp_Method("Введите уравнение тока норм..");
//        System.out.println(str0mtd);
//        String str1 = "222? + ?777 = 82";   //"25 + 57=82"
        String str1 = "2? + ?7 = 82";   //"25 + 57=82"
        String[] str2 = str1.split(" "); // 0 2 4
//        System.out.println(str2[0] + str2[2] + str2[4]);

        int[] mssv10 = new int[]{0, 10, 20, 30, 40, 50, 60, 70, 80, 90};      // TODO gen   //00 octal!!!
        int[] mssv1 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        String chisl10 = "2?";
        String chisl1 = "?7";
        String sum = "82";

        int[] mssv1chisl10 = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] mssv2chisl1 = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

//        for (int i = 0; i < 10; i++) {                                      // сразу одинаковое число
//            mssv1chisl10[i]=  Integer.valueOf(chisl10.substring(0,1))*10+i;
//            mssv2chisl1[i]=  Integer.valueOf(chisl1.substring(1,2))+i*10;
////            System.out.println(mssv1chisl10[i] +" "+ mssv2chisl1[i]);
//            if((mssv1chisl10[i] + mssv2chisl1[i]) == Integer.parseInt(sum)) {
//                System.out.println(str1);
//                System.out.println(mssv1chisl10[i]+"+"+mssv2chisl1[i]+"=="+Integer.parseInt(sum));
//                } ;
//        }

        for (int i = 0; i < 10; i++) {                                      // сразу одинаковое число       // если 1x x2
            int x = Integer.valueOf(chisl10.substring(0, 1)) * 10 + i;
            int y = Integer.valueOf(chisl1.substring(1, 2)) + i * 10;
//            System.out.println(mssv1chisl10[i] +" "+ mssv2chisl1[i]);
            if ((x + y) == Integer.parseInt(sum)) {
                System.out.println(str1);
                System.out.println(x + "+" + y + "==" + (x + y));
            }

        }


        // TODO варикс
        //  массив вместо ?  // for 0-9
        //  + разряды  добавить в уме (

        // 4 разр

        //  варики по разрядам - 16 вариантов /2 =8   - для 2 разрядн
//            1x 11         // только -             // развр 1варик
//            х1 11         // только -             // развр 1варик
//            xx 11         // только -             // развр 1варик

//            xx xx        // только 1(задан дб верно       // 1 варик
//

//            xx 1x         //                      // +развр   // сум - разр и 1+люб
//                      1 совп с 1
//                     хотяб1
//            xx x1         //                      // +развр
//                   1 совп с 1
//                     хотяб1

//            x1 x2         // /2                  // развр самсебе     // 1 цифра(но вторая совпдан или первая всегда
//                x1 x1    1 совп с 1   21 31 52                          одинк цфиры
//                x1 x2       sum-3/2 +1 +2    21 22 43 +1 +2

//            1x 2x         // сум -10ки /2       // развр самсебе     // 1 цифра(но вторая совпдан или первая всегда
//                       1x 2x    1 совп с 1
//                        sum-3/2 +1 +2

//            1x x2
//              2x x1


    }


    private static String inp_Method(String prnt) {  // static?!
       InpSngltone inpSng = InpSngltone.getInstance();

        return inpSng.inp_Method(prnt);
    }


}
