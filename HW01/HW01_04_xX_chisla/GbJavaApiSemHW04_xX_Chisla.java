package HW01.HW01_04_xX_chisla;


/*
4) (дополнительное задание) Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69. Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.
Под знаком вопроса - всегда одинаковая ЦИФРА.
Введите уравнение: ?? + ?? = 44
Решение: 22 + 22 = 44
*/

public class GbJavaApiSemHW04_xX_Chisla {
    static InpSngltone inp1 ;

    public static void main(String[] args) {

           //TOD0s НЕДОДЕЛАЛ- пока только  2? + ?7 = 82
           
        zadanye_04_qCyphers_02_02();
         inp1=    InpSngltone.getInstance();
    }


 
    private static void zadanye_04_qCyphers_02_02() {

        boolean stop=false;

        while (!stop){

            String str0mtd = inp_Method("Введите уравнение, тока норм..  \nтипа: \n2? + ?7 = 82\nили \n?7 + 2? = 82\nили exit");

            if(str0mtd.equalsIgnoreCase("exit")){ 
                stop=true;
//                break;
            } else if (str0mtd.equalsIgnoreCase("tred")){ 
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

            if ((x + y) == sum) {

                ab[0]=x;
                ab[1]=y;
                System.out.println(ab[0]);
                System.out.println(ab[1]);

            }
        }
        return ab;
    }




    private static String inp_Method(String prnt) {  // static?!
       InpSngltone inpSng = InpSngltone.getInstance();

        return inpSng.inp_Method(prnt);
    }


}
