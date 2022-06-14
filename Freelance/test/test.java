
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LENOVO
 */
public class test {
    private String name;
    private String pass;

    public test(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public test() {
        this.name = "kha";
        this.pass = "kha pass";
    }

    public test(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "test{" + "name=" + name + ", pass=" + pass + '}';
    }
    
    public static void main(String[] args) throws ParseException {
//        test pp = new test();
//        System.out.println(pp);
//        pp = new test("kha");
//        System.out.println(pp);
        String date1 = java.time.LocalDate.now() + "a";
        Date date = new SimpleDateFormat("dd-MM-yyyy").parse(java.time.LocalDate.now() + "");
        //String date = dayformat.format(java.time.LocalDate.now() + "");
        System.out.println("date: " + date);
        System.out.println(java.time.LocalDate.now());
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dateFormat = formatter.format(date);
        System.out.println("date after : " + dateFormat);
    }
}
