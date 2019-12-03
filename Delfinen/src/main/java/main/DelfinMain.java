package main;

import dataadmin.MemberMapper;
import model.Program;
import ui.ConsoleUI;

/**
 *
 * @author Frederik, Thor, Josef, Hallur
 */
public class DelfinMain {
    public static void main(String[] args) {
          MemberMapper mm = new MemberMapper(); 
          ConsoleUI ui = new ConsoleUI(); 
          Program program = new Program(ui, mm); 
    }
     
}
