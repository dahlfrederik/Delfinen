package model;

import dataadmin.MemberMapper;
import ui.ConsoleUI;

/**
 *
 * @author Frederik, Thor, Josef, Hallur
 */
public class Program {

    private final ConsoleUI ui;
    private MemberMapper memberMapper;
    private String job;

    public Program(ConsoleUI ui, MemberMapper memberMapper) {
        this.ui = ui;
        this.memberMapper = memberMapper;
        runProgram();
    }

    public void runProgram() {
        int choice = 0;
        while (choice != 1) {
            ui.println("--------------------------------Delfinens system--------------------------------");
            ui.println("1) Login");

            try {
                choice = Integer.parseInt(ui.getInput());
                if (choice < 1 || choice > 1) {
                    throw new NumberFormatException();
                }
                switch (choice) {
                    case 1:
                        login();
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("FEJL!");
            }
        }
    }

    public void login() {
        int choice = 0;
        ui.println("Vælg din funktion i klubben");
        ui.println("1) Formand");
        ui.println("2) Kasserer");
        ui.println("3) Træner");
        try {
            choice = Integer.parseInt(ui.getInput());
            if (choice < 1 || choice > 3) {
                throw new NumberFormatException();
            }
            switch (choice) {
                case 1:
                    job = "Formand";
                    PresidentProgram pprogram = new PresidentProgram(ui, memberMapper); 
                    break;
                case 2:
                    job = "Kasserer";
                    AccountantProgram aprogram = new AccountantProgram(ui,memberMapper); 
                    break;
                case 3:
                    job = "Træner";
                    CoachProgram cprogram = new CoachProgram(ui,memberMapper); 
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("VÆLG ET TAL MELLEM 1 OG 3!");
            login();
        }
    }
}
