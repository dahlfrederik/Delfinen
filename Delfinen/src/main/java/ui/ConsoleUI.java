

package ui;

import java.util.Scanner;

/**
 *
 * @author Frederik, Thor, Josef, Hallur
 */
public class ConsoleUI {
    Scanner input = new Scanner(System.in);

    public String getInput() {
        return input.next();
    }

    public void println(String msg) {
        System.out.println(msg);
    }
    
    public int getIntInput(){
        return input.nextInt(); 
    }

    public double getDoubleInput(){
        return input.nextDouble();
    }

    public Boolean getBoolInput() {
        return input.nextBoolean(); 
    }
}
