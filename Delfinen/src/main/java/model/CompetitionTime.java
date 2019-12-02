

package model;

import dataadmin.ResultMapper;

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
    public void insertResult(Result result) {
        ResultMapper rm = new ResultMapper();
        rm.insertResultToSQL(result);
    }

}
