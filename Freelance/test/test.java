
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
        String name = "kha";
        System.out.println("ascii code K: " + (int)'k');
    }
}
