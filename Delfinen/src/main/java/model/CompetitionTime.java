

package model;

/**
 *
 * @author FrederikDahl
 */
public class CompetitionTime implements Results{

    @Override
    public void showResults(Result result) {
       
    }

    @Override
    public Member chooseMember(Member member) {
        
        return member; 
    }

    @Override
    public void insertTime() {
    }

    @Override
    public void insertDate() {
    }

    @Override
    public boolean comptetion() {
        return true; 
    }

}
