package model;

import dataadmin.MemberMapper;
import java.util.InputMismatchException;
import ui.ConsoleUI;

/**
 *
 * @author Frederik, Thor, Josef, Hallur
 */
public class PresidentProgram {

    private final ConsoleUI ui;
    private MemberMapper memberMapper;
    private InputValidator inputValidator = new InputValidator();

    public PresidentProgram(ConsoleUI ui, MemberMapper memberMapper) {
        this.ui = ui;
        this.memberMapper = memberMapper;
        presidentUI();
    }

    private void presidentUI() {
        int choice = 0;
        ui.println("Formand UI");
        ui.println("1) Opret medlem");
        ui.println("2) Find medlem");
        ui.println("3) Slet medlem");
        ui.println("4) Afslut");
        try {
            choice = Integer.parseInt(ui.getInput());
            if (choice < 1 || choice > 4) {
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
                case 4:
                    return;
            }
            presidentUI();
        } catch (NumberFormatException e) {
        }
    }

    private void createMember() {
        System.out.println("Indtast medlem navn");
        String name = ui.getInput();
        while(!inputValidator.validateString(name)){
            System.out.println("Hov, det var ikke et navn. Prøv igen!");
            System.out.println("Indtast medlem navn");
            name = ui.getInput(); 
        }
        System.out.println("Indtast medlemmets telefon nummer");
        int nr = ui.getIntInput();
        System.out.println(nr);
        while(!inputValidator.validatePhoneNumber(nr)){
            System.out.println("Det indtastede nummer er ikke validt, numre skal indeholde 8 cifre. Prøv igen");
            System.out.println("Indtast medlemmets telefon nummer");
            nr = ui.getIntInput(); 
        } 
        
        System.out.println("Indtast alder");
        int age = ui.getIntInput();
        while(!inputValidator.validateAge(age)){
            System.out.println("Hov, man skal være mellem 0 og 100 år");
            System.out.println("Indtast alder");
            age = ui.getIntInput(); 
        }
        String team = pickTeam();
        
        System.out.println("Betalingsstatus: ");
        System.out.println("Er medlem i restance?");
        Boolean payStatus = boolStatus();
        
        System.out.println("Indtast medlemsstatus: ");
        System.out.println("Er medlem aktivt?");
        boolean status = boolStatus(); 
        
        Member member = new Member(name, nr, age, team, payStatus, status);
        memberMapper.insertMember(member);
    }

    private void findMember() {
        memberMapper.getMembersInfo();
        System.out.println("Indtast id på det medlem du søger efter");
        int id = ui.getIntInput();
        Member member = memberMapper.searchSpecificMember(id);
        System.out.println("Det medlem du hedder efter er");
        System.out.println(member);
    }

    private void deleteMember() {
        memberMapper.getMembersInfo();
        System.out.println("Indtast id på det medlem du vil slette");
        int id = ui.getIntInput();
        memberMapper.deleteMember(id);
        System.out.println("Medlemmet med id: " + id + " er blevet slettet");
    }
    
    private boolean boolStatus(){
           try{
        int choice = 0;
        ui.println("Ja eller nej");
        choice = Integer.parseInt(ui.getInput());
        if (choice < 1 || choice > 2) {
            throw new NumberFormatException();
        }
        switch (choice) {
            case 1:
                ui.println("Ja");
                return true;
            case 2:
                ui.println("Nej");
                return false;
        }
        }
        catch (NumberFormatException e){
            System.out.println("Hov, prøv igen");
            boolStatus(); 
        }
        return false;
    }
    
    private String pickTeam() {
        int choice = 0;
        ui.println("Vælg hold: \n 1: Senior \n 2: Junior ");

        try {
            choice = Integer.parseInt(ui.getInput());
            if (choice < 1 || choice > 2) {
                throw new NumberFormatException();
            }
            switch (choice) {
                case 1:
                    ui.println("Senior");
                    return "Senior";

                case 2:
                    ui.println("Junior");
                    return "Junior";
            }
        } catch (NumberFormatException e) {
            System.out.println("Hov, prøv igen");
            pickTeam(); 
        }
        return "";

    }
}

