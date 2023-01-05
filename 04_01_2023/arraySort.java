1:
import java.util.*;
import java.io.*;

class arraySort{
    public static void main(String []argh){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = scan.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

//////////////////////////////////////////

import java.util.*;
import java.io.*;

class arraySort{
    public static void main(String []argh){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = scan.nextInt();
        }
        scan.close();
        int tmp;
        for (int i = 0; i < n-1; i++) {
            for (int j = i + 1; j < n; j++)
                if (arr[i] > arr[j]) {
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        System.out.println(Arrays.toString(arr));
    }
}