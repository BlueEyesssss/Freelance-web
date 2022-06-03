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

    public static void main(String[] args) {
        String avatar = "hello.jpg";
        String email = "vuamessi99999@gmail.com";
        String link = "https://ba12855.jpg";

//        System.out.println();
//        System.out.println(email.length());
//        System.out.println(email.substring(email.length() - 10, email.length()));
//        System.out.println(link.substring(0, 8));
        System.out.println(avatar.substring(avatar.length() - 4, avatar.length()));
        if (avatar.substring(avatar.length() - 4, avatar.length()).equals(".jpg")
                || avatar.substring(avatar.length() - 4, avatar.length()).equals(".png")
                || avatar.substring(0, 8).equals("https://")) {
            
            System.out.println("correct form");
        }else{
            System.out.println("format must start by https://... or must end by .jpg or .png");
        }
    }
}
