package model;

import dataadmin.MemberMapper;
import java.util.ArrayList;
import ui.ConsoleUI;

/**
 *
 * @author FrederikDahl
 */
public class AccountantProgram {

    private final MemberMapper memberMapper;
    private ConsoleUI ui;

    public AccountantProgram(ConsoleUI ui, MemberMapper memberMapper) {
        this.ui = ui;
        this.memberMapper = memberMapper;
        accountantUI();
    }

    private void accountantUI() {
        int choice = 0;
        ui.println("Kasserer UI");
        ui.println("1) Vis kontigent");
        ui.println("2) Vis medlemmer i restance");
        try {
            choice = Integer.parseInt(ui.getInput());
            if (choice < 1 || choice > 2) {
                throw new NumberFormatException();
            }
            switch (choice) {
                case 1:
                    showPayment();
                    break;
                case 2:
                    showAllMembersNotPaid(); 
                    break; 
            }
        }
        catch (NumberFormatException e){
        }
    }

    private Member getMember(){
        ui.println("For at vise betalingstatus for et medlem skal der indtastets et medlems ID");
        int id = ui.getIntInput(); 
        Member member = memberMapper.searchSpecificMember(id); 
        return member; 
    }
    
    private void showPayment() {
        Member member = getMember(); 
        ui.println("Du har valgt medlem: " + member.getName());
        ui.println("Medlemmets betalingstatus er: "); 
        if(member.isPaystatus() == false){
            ui.println("ikke betalt"); 
        } else {
            ui.println("Betalt");
        }
    }

    private void showAllMembersNotPaid() {
       Payment p = new Payment(); 
       ArrayList<Member> notPaidList = p.haventPayed(); 
       ui.println("Medlemmer i restance er: ");
        for (Member member : notPaidList) {
            ui.println("Navn: " + member.getName() + " id: " + member.getId()); 
        }
    }
}
