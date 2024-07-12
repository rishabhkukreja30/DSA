import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Union {

    static ArrayList<Integer> FindUnion(int arr1[], int arr2[], int n, int m) {
        int i = 0, j = 0; // pointers
        ArrayList<Integer > Union=new ArrayList<>(); // Uninon vector
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) // Case 1 and 2
            {
                if (Union.size() == 0 || Union.get(Union.size()-1) != arr1[i])
                    Union.add(arr1[i]);
                i++;
            } else // case 3
            {
                if (Union.size() == 0 || Union.get(Union.size()-1) != arr2[j])
                    Union.add(arr2[j]);
                j++;
            }
        }
        while (i < n) // IF any element left in arr1
        {
            if (Union.get(Union.size()-1) != arr1[i])
            Union.add(arr1[i]);
            i++;
        }
        while (j < m) // If any elements left in arr2
        {
            if (Union.get(Union.size()-1) != arr2[j])
            Union.add(arr2[j]);
            j++;
        }
        return Union;
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
            

            ArrayList<Integer> Union = FindUnion(arr1, arr2, n1, n2);
            for(int val: Union) {
                System.out.print(val + " ");;
            }
            



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
