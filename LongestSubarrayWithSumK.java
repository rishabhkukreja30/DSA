import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestSubarrayWithSumK {

        static int getlongestSubarray(int arr[],  int k){
            int n = arr.length;
            int sum = 0;
            int maxLen = 0;
            Map <Integer, Integer> preSumMap = new HashMap<>();
            
            for(int i=0;i<n;i++) {
                sum += arr[i];
                if(sum == k) {
                    maxLen = Math.max(maxLen, i+1);
                }
                if(preSumMap.containsKey(sum - k)) {
                    int len = i - preSumMap.get(sum-k);
                    maxLen = Math.max(maxLen, len);
                }
                if(!preSumMap.containsKey(sum)) {
                    preSumMap.put(sum, i);
                }
            }
            return maxLen;
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
            int k = scanner.nextInt();

            System.out.println(getlongestSubarray(arr1, k));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
