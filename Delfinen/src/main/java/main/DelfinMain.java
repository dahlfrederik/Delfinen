package main;

import dataadmin.MemberMapper;
import dataadmin.TeamMapper;
import java.util.ArrayList;
import model.Member;

/**
 *
 * @author FrederikDahl
 */
public class DelfinMain {
    public static void main(String[] args) {
//        Member member = new Member("Josef",22,"Junior",false,true);
//        Member member1 = new Member("Thor",24,"Senior",false,false);
//        Member member2 = new Member("Frederik",22,"Junior",true,true);
//        MemberMapper dm = new MemberMapper();
//        dm.insertMember(member);
//        dm.insertMember(member1);
//        dm.insertMember(member2);
//        ArrayList<Member> memberlist = dm.getMembers(); 
//        //dm.deleteMember(2);
//        memberlist = dm.getMembers(); 
//        System.out.println(memberlist);
        
        TeamMapper tm = new TeamMapper(); 
        System.out.println("Junir: " + tm.getJunior()); 
        System.out.println("Senior" + tm.getSenior()); 
    }
     
}
