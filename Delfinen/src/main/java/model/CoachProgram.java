package model;

import dataadmin.MemberMapper;
import dataadmin.ResultMapper;
import dataadmin.TeamMapper;
import ui.ConsoleUI;

/**
 *
 * @author FrederikDahl
 */
class CoachProgram {

    private final MemberMapper memberMapper;
    private ConsoleUI ui;

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
        System.out.println("Indtast medlemmets tid");
        int time = ui.getIntInput();
        System.out.println("Indtast comp");
        boolean comp = ui.getBoolInput();
        System.out.println("Indtast disciplin");
        String disc = ui.getInput();
        System.out.println("Indtast dato");
        int date = ui.getIntInput();
        Result result = new Result(name, time, comp, disc, date);
        if (comp == true) {
            Results results = new CompetitionTime();
            results.insertResult(result);
        } else {
            Results results = new TrainingTime();
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
                    ui.println("Indtast disciplin: ");
                    String disc = ui.getInput();
                    rm.showTop5Training(disc);
                    break;
                case 2:
                    ui.println("Indtast disciplin: ");
                    String disc1 = ui.getInput();
                    rm.showTop5Comp(disc1);
                    break;
            }
        } catch (NumberFormatException e) {
        }
        
    }

}
