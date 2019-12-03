package model;

import dataadmin.MemberMapper;
import java.util.ArrayList;

/**
 *
 * @author Frederik, Thor, Josef, Hallur
 */
public class Payment {
    private final double DISCOUNT = 0.75;  
    
    public boolean showPayStatus(Member member){
        return member.isPaystatus(); 
    }
    
    public boolean isMemberActive(Member member){
        return member.isActive(); 
    }
    
    public double paymentPrice(Member member){
        double price = 0; 
        int age = member.getAge(); 
        
        if(!member.isActive()){
            price = 500; 
        } 
        else if(age < 18){
            price = 1000; 
        } else if(age > 18 && age < 60){
            price = 1600; 
        } else {
            price = 1600 * DISCOUNT; 
        }
        return price; 
    }
    
    public ArrayList<Member> haventPayed(){
        return new MemberMapper().notPaid();  
    }
    
}
