package model;

import dataadmin.MemberMapper;
import dataadmin.ResultMapper;
import dataadmin.TeamMapper;
import ui.ConsoleUI;

/**
 *
 * @author Frederik, Thor, Josef, Hallur
 */
class CoachProgram {

    private final MemberMapper memberMapper;
    private ConsoleUI ui;
    private InputValidator inputValidator = new InputValidator();

    public CoachProgram(ConsoleUI ui, MemberMapper memberMapper) {
        this.ui = ui;
        this.memberMapper = memberMapper;
        coachUI();
    }

    private void coachUI() {
        int choice = 0;
        ui.println("Træner UI");
        ui.println("1) Vis hold");
        ui.println("2) Opret resultater");
        ui.println("3) Vis resultater");
        ui.println("4) Vis top 5");
        ui.println("5) Afslut");
        try {
            choice = Integer.parseInt(ui.getInput());
            if (choice < 1 || choice > 5) {
                throw new NumberFormatException();
            }
            switch (choice) {
                case 1:
                    showTeams();
                    break;
                case 2:
                    insertResults();
                    break;
                case 3:
                    showResults();
                    break;
                case 4:
                    showTop5();
                    break;
                case 5:
                    return;
            }
            coachUI();
        } catch (NumberFormatException e) {
        }
    }

    private void showTeams() {
        int choice = 0;
        TeamMapper tm = new TeamMapper();
        ui.println("Hvilket hold vil du se medlemmer for?");
        ui.println("1) Junior");
        ui.println("2) Senior");
        try {
            choice = Integer.parseInt(ui.getInput());
            if (choice < 1 || choice > 3) {
                throw new NumberFormatException();
            }
            switch (choice) {
                case 1:
                    System.out.println("Junior holdet består af: ");
                    tm.getJunior();
                    break;
                case 2:
                    System.out.println("Senior holdet består af: ");
                    tm.getSenior();
                    break;
            }
        } catch (NumberFormatException e) {
        }
    }

    private void insertResults() {
        System.out.println("Indtast medlem navn");
        String name = ui.getInput();
        while (!inputValidator.validateString(name)) {
            System.out.println("Hov, det var ikke et navn. Prøv igen!");
            System.out.println("Indtast medlem navn");
            name = ui.getInput();
        }

        System.out.println("Indtast medlemmets tid");
        double time = ui.getDoubleInput();
        while (!inputValidator.validateResultTime(time)) {
            System.out.println("Hov, indtast en tid under 100 minutter");
            System.out.println("Indtast medlemmets tid");
            time = ui.getDoubleInput();
        }
        boolean comp = isItComp();
        String disc = pickDisc();

        System.out.println("Indtast dato");
        int date = ui.getIntInput();
        Result result = new Result(name, time, comp, disc, date);
        if (comp == true) {
            ResultTime results = new CompetitionTime();
            results.insertResult(result);
        } else {
            ResultTime results = new TrainingTime();
            results.insertResult(result);
        }
    }

    private void showResults() {
        ResultMapper rm = new ResultMapper();
        Member member = getMember();
        ui.println("Medlemmets resultater er: ");
        rm.showResultForMember(member);
    }

    private Member getMember() {
        memberMapper.getMembersInfo();
        ui.println("For at vise finde medlemsresultater skal der indtastets et medlems ID");
        int id = ui.getIntInput();
        Member member = memberMapper.searchSpecificMember(id);
        return member;
    }

    private void showTop5() {
        int choice = 0;

        ResultMapper rm = new ResultMapper();
        ui.println("Top 5 for træning eller comp?");
        ui.println("1) Træning");
        ui.println("2) Competetion");
        try {
            choice = Integer.parseInt(ui.getInput());
            if (choice < 1 || choice > 2) {
                throw new NumberFormatException();
            }
            switch (choice) {
                case 1:
                    ui.println("Indtast disciplin som du vil se top 5 for træning i: ");
                    String disc = pickDisc();
                    rm.showTop5Training(disc);
                    break;
                case 2:
                    ui.println("Indtast disciplin som du vil se top 5 for konkurrence i");
                    String disc1 = pickDisc();
                    rm.showTop5Comp(disc1);
                    break;
                case 3: 
                    ui.println("Indtast dicsiplin som du vil se top 5 for både træning og konkurrence samlet"); 
                    String disc2 = pickDisc(); 
                    rm.showTop5All(disc2); 
            }
        } catch (NumberFormatException e) {
        }

    }

    private String pickDisc() {
        int choice = 0;
        ui.println("Vælg disciplin: \n 1: Butterfly \n 2: Crawl \n 3: Rygcrawl \n 4: Brystsvømmning");

        try {
            choice = Integer.parseInt(ui.getInput());
            if (choice < 1 || choice > 4) {
                throw new NumberFormatException();
            }
            switch (choice) {
                case 1:
                    ui.println("Butterfly");
                    return "Butterfly";

                case 2:
                    ui.println("Crawl");
                    return "Crawl";
                case 3:
                    ui.println("Rygcrawl");
                    return "Rygcrawl";
                case 4:
                    ui.println("Brystsvømning");
                    return "Brystsvømning";

            }
        } catch (NumberFormatException e) {
             System.out.println("Hov, prøv igen");
             pickDisc(); 
        }
        return "";

    }

    private boolean isItComp() {
        try{
        int choice = 0;
        ui.println("Er tiden fra konkurrence? 1 for Ja eller 2 for nej");
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
             isItComp(); 
        }
        return false;
    
    }
}
