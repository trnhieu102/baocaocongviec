import java.util.*;
import java.io.*;
import java.math.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int q=in.nextInt();
        for(int i=0;i<q;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int s = a + b;
            for (int j=0;j<n;j++){
                System.out.print(s + " ");
                s = s + b*(int)Math.pow(2, j+1);
            }
            System.out.println();
        }
        in.close();
            
    }
}
