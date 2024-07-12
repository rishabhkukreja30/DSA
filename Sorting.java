import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Sorting {

    public static void selection_sort(int arr[] ,int n) {
        for(int i =0; i<n-1;i++) {
            int mini = i;
            for(int j=i+1;j<=n-1;j++) {
                if(arr[j] < arr[mini]) {
                    mini = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[mini];
            arr[mini] = temp;
        }
    }

    public static void merge(int arr[], int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;

        while(left <= mid && right <= high) {
            if(arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            }
            else {
                temp.add(arr[right]);
                right++;
            }
        }
        while(left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }
        for(int i=low;i<=high;i++) {
            arr[i] = temp.get(i-low);
        }
    }

    public static void merge_sort(int arr[], int low, int high) {
        if(low >= high) {
            return;
        }
        int mid = (low+high)/2;

        merge_sort(arr, low, mid);
        merge_sort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    public static int partition(int arr[], int low, int high) {
        int pivot = arr[low];
        int i= low;
        int j = high;
        while(i < j) {
            while (arr[i] <= pivot && i<=high-1) {
                i++;
            }
            while (arr[j] > pivot && j >= low+1) {
            j--;
            }
            if(i< j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        return j;
    }

    public static void quick_sort(int arr[], int low, int high) {

        if(low>= high) {
            return;
        }
        int pIndex = partition(arr, low, high);
        quick_sort(arr, low, pIndex-1);
        quick_sort(arr, pIndex+1, high);
    }

    public static void main(String[] args) {
        try {
            // Redirect standard input to input.txt
            System.setIn(new FileInputStream("input.txt"));
            // Redirect standard output to output.txt
            System.setOut(new PrintStream(new FileOutputStream("output.txt")));

            // Use Scanner to read from standard input
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++) {
                arr[i] = scanner.nextInt();
            }
            
            // selection_sort(arr, n);
            // merge_sort(arr,0 , n-1);
            quick_sort(arr, 0, n-1);

            for(int num: arr) {
                System.out.print(num + " ");
            }
            



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
