package model;

import dataadmin.ResultMapper;

/**
 *
 * @author Frederik, Thor, Josef, Hallur
 */
public class CompetitionTime implements ResultTime{
    ResultMapper rm = new ResultMapper();

    @Override
    public void showResults(Result result) {
       rm.showResultsFromSQLComp();
    }

    @Override
    public Result chooseMember(Member member) {
        return rm.showResultForMember(member);
    }

    @Override
    public void insertResult(Result result) {
        rm.insertResultToSQL(result);
    }

    
    

}
