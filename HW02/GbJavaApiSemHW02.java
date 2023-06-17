package HW02;


/*
        1) Дана строка sql-запроса "select * from students WHERE ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
        Если значение null, то параметр не должен попадать в запрос.
        Пример данной строки {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
        Вывод: select * from students WHERE name=Ivanov AND country=Russia AND city=Moscow
*/


/*
        2) Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
        1 3 4 2
        1 3 2 4
        1 2 3 4
 */


/* Дополнительные задания
        3) Дана строка в файле(читать из файла)
        [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
        Написать метод(ы), который распарсит строчку и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
        Пример вывода:
        Студент Иванов получил 5 по предмету Математика.
        Студент Петрова получил 4 по предмету Информатика.
        Студент Краснов получил 5 по предмету Физика.
 */


/*
        4) К калькулятору из предыдущего ДЗ добавить логирование.
        3+4=7
        1+2=3
        6/3=2
 */


import java.io.*;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Thread.sleep;
 

public class GbJavaApiSemHW02 {


    public static void main(String[] args) throws InterruptedException, IOException {


        long time_1_mils = System.currentTimeMillis();

        method_hw_1_sql();

        method_hw_2_logs_v2();

        method_hw_3_parcer();


        sleep(500); // ±9 milis  :))
        long time_2_mils = System.currentTimeMillis();
        System.out.println("Время метода " + (time_2_mils - time_1_mils - 500));

    }


    private static void method_hw_3_parcer() {
//[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//        Написать метод(ы), который распарсит строчку и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
//        Пример вывода:
//        Студент Иванов получил 5 по предмету Математика.

        String str0mtd = hw_3_dop_Method_readFile();
        String[][] stdMssv = hw_3_dop_Method_parcer_part1(str0mtd);
        StringBuilder strOut = new StringBuilder();

        for (int i = 0; i < stdMssv.length; i++) {
            // Студент [фамилия] получил [оценка] по предмету [предмет].
            strOut = new StringBuilder("Студент ").append(stdMssv[i][0]).append(" получил ").append(stdMssv[i][1]).append(" по предмету ").append(stdMssv[i][2]);
            System.out.println(strOut);
        }
    }


    private static String[][] hw_3_dop_Method_parcer_part1(String str0mtd) {

        Pattern pattern1_Fmly = Pattern.compile("\"фамилия\":\".+?\"");       //"фамилия":"Иванов"
        Pattern pattern2_Scr = Pattern.compile("\"оценка\":\".\"");          //"оценка":"5"
        Pattern pattern3_Subj = Pattern.compile("\"предмет\":\".+?\"");     //"предмет":"Физика"

        List<Matcher> lstMtchrz = new ArrayList<>() {        };

        lstMtchrz.add(pattern1_Fmly.matcher(str0mtd));
        lstMtchrz.add(pattern2_Scr.matcher(str0mtd));
        lstMtchrz.add(pattern3_Subj.matcher(str0mtd));


        String[][] stdns = new String[1][3]; // araylist ?!?

        int i_ctgrs = 0;
        for (Matcher mt4r : lstMtchrz) {

            int i_std = -1;

            while (mt4r.find()) {

                int start = mt4r.start();
                int end = mt4r.end();
//                System.out.println("Найдено совпадение " + str0mtd.substring(start,end) + " с "+ start + " по " + (end-1) + " позицию");

                i_std++;

                if (i_std + 1 > stdns.length) {

                    String[][] stdnsN2 = new String[stdns.length + 1][stdns[0].length];

                    for (int i = 0; i < stdns.length; i++) {
                        System.arraycopy(stdns[i], 0, stdnsN2[i], 0, stdns[i].length);
                    }

                    stdns = stdnsN2;
                }

                String strFin = str0mtd.substring(start, end).
                        replace("фамилия", "").
                        replace(":", "").
                        replace("оценка", "").
                        replace("предмет", "").
                        replace("\"", "");


                stdns[i_std][i_ctgrs] = String.valueOf(strFin);
            }
            i_ctgrs++;


        }

        return stdns;


    }

    private static String hw_3_dop_Method_readFile() {
        String pathProject = System.getProperty("user.dir");
        String pathFile = pathProject.concat("/file.txt");
        File file = new File(pathFile);
        String str0 = "";

        if (file.exists()) {
            try (BufferedReader buf = new BufferedReader(new FileReader(file))) {
                str0 = buf.readLine();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
         return str0;
    }


    private static void method_hw_2_logs_v2() throws InterruptedException, IOException {

        Logger lg1 = Logger.getLogger(GbJavaApiSemHW02.class.getName());
        FileHandler fHl1 = new FileHandler("log.txt");
        lg1.addHandler(fHl1);
        SimpleFormatter smpFrmt1 = new SimpleFormatter();
        fHl1.setFormatter(smpFrmt1);

        int[] arr1 = new int[]{1, 3, 4, 2};
        lg1.info("strt            " + "  arr " + Arrays.toString(arr1));

        int aftStp = 0;
        int cntR = 0;
        boolean iter = true;

        while (iter == true) {
            cntR++;

            int cnt = 0;
            for (int j = arr1.length - 1; j >= 1; j--) {

                if (arr1[j - 1] > arr1[j]) {

                    int swp = arr1[j - 1];
                    arr1[j - 1] = arr1[j];
                    arr1[j] = swp;
                    cnt++;
                }

                lg1.info("aftr node step " + (-(-arr1.length + j)) + "  arr " + Arrays.toString(arr1));
            }
            if (cnt == 0) {
                iter = false;
                lg1.log(Level.WARNING, "stop iterate - basta -  already 1 free run ");
                aftStp++;
            }
            if (aftStp > 0) {
                lg1.log(Level.WARNING, "after stop iterate" + aftStp);
            }
            lg1.info("aftr ROOT step " + cntR + "  arr " + Arrays.toString(arr1));
        }
        System.out.println(Arrays.toString(arr1));

    }
 

    private static void method_hw_1_sql() {
        String str0 = "select * from students WHERE ";

        Map<String, String> mpFiltr = new HashMap<>() {
        };
        mpFiltr.put("name", "Ivanov");
        mpFiltr.put("country", "Russia");
        mpFiltr.put("city", "Moscow");
//        mpFiltr.put("age", null);
        mpFiltr.put("age", "null");

        StringBuilder finStr = new StringBuilder(str0);

        for (Map.Entry<String, String> entr : mpFiltr.entrySet()) {

            if (entr.getValue() != null) {
                if (!entr.getValue().equalsIgnoreCase("null")) {
                    finStr.append(entr.getKey()).append(" ").append(entr.getValue()).append(" ").append("AND ");
                }
            }


        }//for

        System.out.println(finStr.substring(0, finStr.length() - 4));

    }//func

}//class
