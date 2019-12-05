package model;

import dataadmin.MemberMapper;
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
        
        System.out.println("Indtast hold: Senior eller Junior");
        String team = ui.getInput();
        while(!inputValidator.validateTeam(team)){
            System.out.println("Hov, der er 2 muligheder");
            System.out.println("Senior eller Junior");
            System.out.println("Indtast enten Senior eller Junior");
            team = ui.getInput(); 
        }
        
        System.out.println("Indtast betalingsstatus: true = betalt, false = ikke betalt");
        Boolean payStatus = ui.getBoolInput();
        while(!inputValidator.validateBoolean(payStatus)){
            System.out.println("Hov, indtast venligst betalingstatus");
            System.out.println("true = betalt, false = ikke betalt");
            payStatus = ui.getBoolInput(); 
        }
        
        System.out.println("Indtast medlemsstatus: true = aktiv, false =  inaktiv");
        Boolean status = ui.getBoolInput();
        while(!inputValidator.validateBoolean(status)){
            System.out.println("Hov, indtast venligst medlemsstatus");
            System.out.println("true = aktiv, false =  inaktiv");
            status = ui.getBoolInput(); 
        }
        
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
}
