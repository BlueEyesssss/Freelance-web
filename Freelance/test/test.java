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
    
    public static void main(String[] args) {
        test pp = new test();
        System.out.println(pp);
        pp = new test("kha");
        System.out.println(pp);
    }
}
