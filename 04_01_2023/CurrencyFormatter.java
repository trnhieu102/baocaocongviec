import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        // Write your code here.
        
        System.out.println("US: " + NumberFormat.getCurrencyInstance(new Locale.Builder().setLanguage("en").setRegion("US").build()).format(payment));
        System.out.println("India: " + NumberFormat.getCurrencyInstance(new Locale.Builder().setLanguage("en").setRegion("IN").build()).format(payment));
        System.out.println("China: " + NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment));
        System.out.println("France: " + NumberFormat.getCurrencyInstance(new Locale.Builder().setLanguage("fr").setRegion("FR").build()).format(payment));
    }
}
