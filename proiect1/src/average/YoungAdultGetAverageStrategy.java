package average;

import java.util.LinkedList;

public class YoungAdultGetAverageStrategy implements GetAverageStrategy {
    private LinkedList<Double> historyScore;
    public YoungAdultGetAverageStrategy(final LinkedList<Double> historyScore) {
        this.historyScore = historyScore;
    }

    /**
     * @return
     */
    @Override
    public Double getAverageScore() {
        final Double aboveAverage = 11.0;
        return aboveAverage;
    }
}
