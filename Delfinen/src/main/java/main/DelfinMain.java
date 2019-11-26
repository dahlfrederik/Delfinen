package main;

import dataadmin.DataMapper;
import java.util.ArrayList;
import model.Member;

/**
 *
 * @author FrederikDahl
 */
public class DelfinMain {
    public static void main(String[] args) {
        Member member = new Member("Josef",22,"Elite",false,true);
        Member member1 = new Member("Thor",24,"Motionist",false,false);
        Member member2 = new Member("Frederik",22,"Mega elite",true,true);
        DataMapper dm = new DataMapper();
        dm.insertMember(member);
        dm.insertMember(member1);
        dm.insertMember(member2);
        ArrayList<Member> memberlist = dm.getMembers(); 
        //dm.deleteMember(2);
        memberlist = dm.getMembers(); 
        System.out.println(memberlist);
        Member member4 = dm.searchSpecificMember(1); 
        System.out.println(member4);
    }
     
}
