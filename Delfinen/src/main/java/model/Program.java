package model;

import dataadmin.MemberMapper;
import ui.ConsoleUI;

/**
 *
 * @author FrederikDahl
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
                    presidentUI();
                    break;
                case 2:
                    job = "Kasserer";
                    accountantUI();
                    break;
                case 3:
                    job = "Træner";
                    coachUI();
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("VÆLG ET TAL MELLEM 1 OG 3!");
            login();
        }
    }

    private void presidentUI() {
        int choice = 0;
        ui.println("Formand UI");
        ui.println("1) Opret medlem");
        ui.println("2) Find medlem");
        ui.println("3) Slet medlem");
        try {
            choice = Integer.parseInt(ui.getInput());
            if (choice < 1 || choice > 3) {
                throw new NumberFormatException();
            }
            switch (choice) {
                case 1:
                    createMember(); 
                    break;
                case 2: 
                    findMember(); 
                    break; 
                case 3: 
                    deleteMember(); 
                    break; 
            }
        } catch (NumberFormatException e){
        }
    }
        
    private void accountantUI() {
    }

    private void coachUI() {
    }

    private void createMember() {
        System.out.println("Indtast medlem navn");
        String name = ui.getInput(); 
        System.out.println("Indtast medlemmets telefon nummer");
        int nr = ui.getIntInput(); 
        System.out.println("Indtast alder");
        int age = ui.getIntInput(); 
        System.out.println("Indtast hold");
        String team = ui.getInput(); 
        System.out.println("Indtast betalingsstatus: true = betalt, false = ikke betalt");
        Boolean payStatus = ui.getBoolInput(); 
        System.out.println("Indtast medlemsstatus: true = aktiv, false =  inaktiv");
        Boolean status = ui.getBoolInput(); 
        Member member = new Member(name,nr,age,team,payStatus,status); 
        memberMapper.insertMember(member); 
    }
    
    private void findMember() {
        System.out.println("Indtast id på det medlem du søger efter");
        int id = ui.getIntInput(); 
        Member member = memberMapper.searchSpecificMember(id); 
        System.out.println("Det medlem du hedder efter er");
        System.out.println(member);
    }

    private void deleteMember() {
        System.out.println("Indtast id på det medlem du vil slette");
        int id = ui.getIntInput(); 
        memberMapper.deleteMember(id);
        System.out.println("Medlemmet med id: " + id + " er blevet slettet");
    }

    
}
