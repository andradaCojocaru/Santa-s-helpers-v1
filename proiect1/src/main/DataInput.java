package main;

import average.GetAverageStrategy;
import average.GetAverageStrategyFactory;
import entities.Child;
import entities.Santa;

import java.util.LinkedList;

public class DataInput {
    public DataInput() {

    }

    /**
     * @param santaBuilder
     */
    public void setData(final Santa santaBuilder) {
        Double sumAverage = 0.0;
        Double budgetUnit = 0.0;
        for (Child child : santaBuilder.getChildList()) {
            LinkedList<Double> niceScore = new LinkedList<>();
            niceScore.add(child.getAverageScore());
            if (child.getNiceScoreHistory() == null) {
                child.setNiceScoreHistory(niceScore);
            }
            GetAverageStrategyFactory getAverageStrategyFactory =
                    new GetAverageStrategyFactory();
            GetAverageStrategy getAverageStrategy =
                    getAverageStrategyFactory.createStrategy(child);
            child.setAverageScore(getAverageStrategy.getAverageScore());
        }
        if (sumAverage != 0) {
            budgetUnit = santaBuilder.getBudget() / sumAverage;
        }
        for (Child child : santaBuilder.getChildList()) {
            child.setAssignedBudget(budgetUnit * child.getAverageScore());
        }
    }
}
