package average;

import entities.Child;

public class GetAverageStrategyFactory {
    /**
     * @param child
     * @return
     */
    public GetAverageStrategy createStrategy(final Child child) {
        String type = null;
        final int five = 5;
        final int twelve = 12;
        final int eighteen = 18;
        if (child.getAge() < five) {
            type = "BABY";
        } else if (child.getAge() >= five && child.getAge() < twelve) {
            type = "KID";
        } else if (child.getAge() >= twelve && child.getAge() < eighteen) {
            type = "TEEN";
        } else {
            type = "YOUNG_ADULT";
        }
        switch (type) {
            case "BABY": return
                    new BabyGetAverageStrategy(child.getNiceScoreHistory());
            case "KID": return
                    new KidGetAverageStrategy(child.getNiceScoreHistory());
            case "TEEN": return
                    new TeenGetAverageStrategy(child.getNiceScoreHistory());
            case "YOUNG_ADULT": return
                    new YoungAdultGetAverageStrategy(child.getNiceScoreHistory());
            default:
                throw new IllegalArgumentException("Child is young adult ");
        }
    }
}
