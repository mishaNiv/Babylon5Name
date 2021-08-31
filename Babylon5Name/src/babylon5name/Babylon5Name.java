/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package babylon5name;

import java.util.Scanner;

/**
 *
 * @author mnivota
 */
public class Babylon5Name {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner (System.in);
        int fnlen;
        int lnlen;
        int citylen;
        int frenlen;
        
        //first name input
        System.out.println("Please enter your first name below.");
        String fn = s.nextLine();
        fnlen = fn.length();
        
        //checking name
        fn = namecheck("first name", fn, fnlen); 
       
        //last name
        System.out.println("Please enter your last name below.");
        String ln = s.nextLine();
        lnlen = ln.length();
        
        //checking input
        ln = namecheck("last name", ln, lnlen);    
        
        //city name
        System.out.println("Please enter your favorite city below.");
        String city = s.nextLine();
        citylen = city.length();
        
        //checking input
        city = namecheck("favorite city", city, citylen);    
        
        //friend's name
        System.out.println("Please enter your friend's name below.");
        String fren = s.nextLine();
        frenlen = fren.length();
        
        //checking input
        fren = namecheck("friend's name", fren, frenlen);

        String name = starwarsname(fn, ln, city, fren); 
        
        System.out.println(name);
    }
    
    public static String starwarsname(String first, String last, String cit, String frend){
        
        //initializing return string and city/friend length ints
        String name;
        int citlen = cit.length();
        int frendlen = frend.length();
        
        //creating first name, taking letters from city and first name
        String firstname = cit.substring(citlen - 3, citlen) + first.substring(0, 3);
        
        //capitalizing the first letter and un-capitalizing the fourth letter of first name
        char firone = firstname.charAt(0);
        char firmid = first.charAt(0);
        firstname = Character.toUpperCase(firone) + firstname.substring(1, 3) + 
                        Character.toLowerCase(firmid) + firstname.substring(4, firstname.length());
        
        //capitalizing the first letter and un-capitalizing the fourth letter of last name
        String lastname = frend.substring(frendlen - 3, frendlen) + last.substring(0, 4);
        char lasone = lastname.charAt(0);
        char lasmid = last.charAt(0);
        lastname = Character.toUpperCase(lasone) + lastname.substring(1, 3) + 
                        Character.toLowerCase(lasmid) + lastname.substring(4, lastname.length());
        
        //adding the apostrophe before the first consonant for first and last name
        firstname = insertApostrophe(firstname);
        lastname = insertApostrophe(lastname);
        
        name = firstname + " " + lastname;
        return name;
    }
    
    public static String namecheck(String ask, String n, int len) {
        Scanner s = new Scanner(System.in); //initializing Scanner
        
        while (len < 4) { //making sure the input has at least four characters
            System.out.println("Please enter your " + ask + " again."); //repeatedly asking them
            n = s.nextLine(); //for a correct entry if
            len = n.length(); //it doesn't have four chars
        }
        
        return n;
    }
    
    public static int consonantPos(String name) {
        int cnt = 1;
        int in = 0;
        boolean vowel = false;
        char a = 'a';
        char e = 'e';
        char i = 'i';
        char u = 'u';
        char o = 'o';
        
        for (cnt = 1; cnt < name.length() - 1; cnt++) {
            if (name.charAt(cnt) != a && name.charAt(cnt) != e && name.charAt
                    (cnt) != i && name.charAt(cnt) != o && name.charAt(cnt) != u) {
                in = cnt;
                break;
            }
        }
        
        return in;
    }
    
    public static String insertApostrophe(String n) {
        String name = "o";
        int consn = consonantPos(n);        
        int len = n.length();
        
        if (consn > len) {
            name = n;
        }
        
        else {
            String name1 = n.substring(0, consn);
            String name2 = n.substring(consn, n.length());

            name = name1 + "'" + name2;        
        }
        return name;
    }
}
