

package ui;

import java.util.Scanner;

/**
 *
 * @author FrederikDahl
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

    public Boolean getBoolInput() {
        return input.nextBoolean(); 
    }
}