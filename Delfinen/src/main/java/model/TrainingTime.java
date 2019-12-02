

package model;

import dataadmin.ResultMapper;

/**
 *
 * @author FrederikDahl
 */
public class TrainingTime implements Results {
    ResultMapper rm = new ResultMapper();

    @Override
    public void showResults(Result result) {
       rm.showResultsFromSQLTraining();
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
