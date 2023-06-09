package HW01.HW01_04_xX_chisla;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InpSngltone {
    private BufferedReader buf;
    private static InpSngltone instance= null;

    String str0;
    String print1;


    public InpSngltone() {      // PaVLIC ?!?!?!
        try {
            buf = new BufferedReader(new InputStreamReader(System.in)) ;    // try с ресурсмт??!? что закроется??
            // при удалении...
        } catch (Exception ex2){
            System.out.println(ex2);
        }

    }

    public static InpSngltone getInstance() {
        if (instance == null) {
            instance = new InpSngltone();        }
        return  instance;
    }

    public String inp_Method(String prnt2) {
        System.out.println(prnt2);
        try {
            str0 = buf.readLine();
        }catch (IOException ex){
            System.out.println(ex);
        }
        return str0;
    }


}
