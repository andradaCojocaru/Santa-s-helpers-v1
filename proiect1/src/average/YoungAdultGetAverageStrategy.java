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
        return 0.0;
    }
}
