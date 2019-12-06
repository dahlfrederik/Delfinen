
package model;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Frederik, Thor, Josef, Hallur
 */
public class InputValidatorTest {
    private InputValidator iv = new InputValidator();
    
    @Before
    public void setup(){
           InputValidator iv = new InputValidator(); 
    }

    @Test
    public void testValidateStringFalse() {
        String userInput = "1231";
        assertFalse(iv.validateString(userInput));
    }
    
    @Test
    public void testValidateStringTrue() {
        String userInput = "John"; 
        assertTrue(iv.validateString(userInput));
    }

    @Test
    public void testValidateAge0() {
        int userInput = 0;
        assertFalse(iv.validateAge(userInput)); 
      
    }
    
     @Test
    public void testValidateAgeMinus() {
       int userInput = -1;
       assertFalse(iv.validateAge(userInput)); 
      
    }
    
    @Test
    public void testValidateAge101(){
        int userInput = 101; 
        assertFalse(iv.validateAge(userInput)); 
    }
    
    @Test
    public void testValidateAge15(){
        int userInput = 15; 
        assertTrue(iv.validateAge(userInput)); 
    }

    @Test
    public void testValidatePhoneNumberFalse() {
       int userInput = 1;
       assertFalse(iv.validatePhoneNumber(userInput));

    }
    
    @Test
    public void testValidatePhoneNumberTrue(){
        int userInput = 30366319; 
        assertTrue(iv.validatePhoneNumber(userInput));
        
    }
    
    @Test
    public void testValidateTeamSenior(){
        String userInput = "Senior";
        assertTrue(iv.validateTeam(userInput));
    }
    
    @Test
    public void testValidateTeamJunior(){
        String userInput = "Junior";
        assertTrue(iv.validateTeam(userInput)); 
    }
    
    @Test
    public void testValidateTeamFalse(){
        String userInput = "junior";
        assertFalse(iv.validateTeam(userInput));
    }

    @Test
    public void testValidateResultTimeTrue(){
        double userInput = 10.0; 
        assertTrue(iv.validateResultTime(userInput)); 
    }
    
      @Test
    public void testValidateResultTimeFalse(){
        double userInput = 105.0; 
        assertFalse(iv.validateResultTime(userInput)); 
    }
}
