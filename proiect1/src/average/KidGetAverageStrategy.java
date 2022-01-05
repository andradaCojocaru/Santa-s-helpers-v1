package average;

import java.util.LinkedList;

public class KidGetAverageStrategy implements GetAverageStrategy {
    private LinkedList<Double> historyScore;
    public KidGetAverageStrategy(final LinkedList<Double> historyScore) {
        this.historyScore = historyScore;
    }

    /**
     * @return
     */
    @Override
    public Double getAverageScore() {
        Double sum = 0.0;
        Double nr = 0.0;
        for (Double score : historyScore) {
            sum += score;
            nr += 1;
        }
        return sum / nr;
    }
}
