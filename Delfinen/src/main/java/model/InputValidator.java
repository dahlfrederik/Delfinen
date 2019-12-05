package model;

import ui.ConsoleUI;

/**
 *
 * @author FrederikDahl
 */
public class InputValidator {

    public boolean validateString(String userInput) {
        String regex = "^[a-zA-ZÆØÅæøå]+$";
        if (userInput.matches(regex)) {
            return true;
        }
        return false;
    }

    public boolean validateAge(int userInput) {
        if (userInput <= 0 || userInput > 100) {
            return false;
        }
        return true;
    }

    public boolean validatePhoneNumber(int userInput) {
        int length = String.valueOf(userInput).length();
        if (length == 8) {
            return true;
        }
        return false;
    }

    public boolean validateTeam(String userInput){
        if(userInput.equals("Senior") || userInput.equals("Junior" )){
            return true; 
        } return false; 
    }
    
    public boolean validateBoolean(String userInput){
         if(userInput.equals("false") || userInput.equals("true" )){
            return true; 
        } return false; 
    }
    
    
    public boolean validateResultTime(double userInput) {
        return true;
    }

}
