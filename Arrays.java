import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Arrays {
    public static void main(String[] args) {
        try {
            // Redirect standard input to input.txt
            System.setIn(new FileInputStream("input.txt"));
            // Redirect standard output to output.txt
            System.setOut(new PrintStream(new FileOutputStream("output.txt")));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
       
    }
    
}
