

package model;

import dataadmin.ResultMapper;

/**
 *
 * @author FrederikDahl
 */
public class CompetitionTime implements Results{
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

    @Override
    public void showTop5() {
    }
    
    

}
