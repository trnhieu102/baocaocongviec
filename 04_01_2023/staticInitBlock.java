import java.io.*;
import java.util.*;

public class Solution {
    
static int B;
static int H;
static boolean flag = true;

static {
    Scanner scan = new Scanner(System.in);
    B = scan.nextInt();
    H = scan.nextInt();
    scan.close();
    
    try{
        if (B <= 0 || H <= 0){
            flag = false;
            throw new Exception("Breadth and height must be positive");
        }
    } catch (Exception e){
        System.out.println(e);
    }
}

    public static void main(String[] args) {
        if (flag){
            int a = B*H;
            System.out.println(a);
        }
    }
}
