import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Intersection {

    static ArrayList<Integer> FindIntersection(int arr1[], int arr2[], int n, int m) {
        int i = 0, j = 0; // pointers
        ArrayList<Integer > Intersection = new ArrayList<>(); // Uninon vector
        while(i < n && j< m) {
            if(arr1[i] < arr2[j]) {
                i++;
            }
            else if(arr2[j] < arr1[i]) {
                j++;
            }
            else {
                Intersection.add(arr1[i]);
                i++;
                j++;
            }
        }
        return Intersection;
    }

    public static void main(String[] args) {
        try {
            // Redirect standard input to input.txt
            System.setIn(new FileInputStream("input.txt"));
            // Redirect standard output to output.txt
            System.setOut(new PrintStream(new FileOutputStream("output.txt")));

            // Use Scanner to read from standard input
            Scanner scanner = new Scanner(System.in);
            int n1 = scanner.nextInt();
            int arr1[] = new int[n1];
            for(int i=0;i<n1;i++) {
                arr1[i] = scanner.nextInt();
            }
            int n2 = scanner.nextInt();
            int arr2[] = new int[n2];
            for(int i=0;i<n2;i++) {
                arr2[i] = scanner.nextInt();
            }
            

            ArrayList<Integer> Union = FindIntersection(arr1, arr2, n1, n2);
            for(int val: Union) {
                System.out.print(val + " ");;
            }
            



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
