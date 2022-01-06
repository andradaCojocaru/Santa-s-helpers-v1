package entities;

import java.util.LinkedList;

public class CopySanta {
    public CopySanta() {

    }

    /**
     * @param santa
     * @return
     */
    public LinkedList<Child> copyConstructor(final Santa santa) {
        LinkedList<Gift> oldGifts = santa.getGiftList();
        LinkedList<Gift> newGifts = new LinkedList<>();
        LinkedList<Child> children = santa.getChildList();
        LinkedList<Child> newChildren = new LinkedList<>();
        for (Gift gift : oldGifts) {
            newGifts.add(gift);
        }

        for (Child child : children) {
            LinkedList<Double> niceScoreHistory = child.getNiceScoreHistory();
            LinkedList<Double> newNiceScoreHistory = new LinkedList<>();
            LinkedList<String> giftPreferences = child.getGiftsPreferences();
            LinkedList<String> newGiftPreferences = new LinkedList<>();
            LinkedList<Gift> receivedGifts = child.getReceivedGifts();
            LinkedList<Gift> newReceivedGifts = new LinkedList<>();
            Double assignedBudget = child.getAssignedBudget();
            int age = child.getAge();
            if (receivedGifts != null) {
                for (Gift received : receivedGifts) {
                    newReceivedGifts.add(received);
                }
            }
            for (String gift : giftPreferences) {
                newGiftPreferences.add(gift);
            }

            for (Double score : niceScoreHistory) {
                newNiceScoreHistory.add(score);
            }
            Child newChild = new Child.ChildBuilder(child.getId(), child.getLastName(),
                    child.getFirstName(), age, child.getCity(),
                    child.getAverageScore(), newGiftPreferences)
                    .niceScoreHistory(newNiceScoreHistory)
                    .assignedBudget(assignedBudget)
                    .receivedGifts(newReceivedGifts)
                    .build();
            newChildren.add(newChild);
        }

        Santa newSanta = new Santa.SantaBuilder(santa.getNumberOfYears(),
                santa.getBudget(), newGifts, newChildren)
                .build();
        return newChildren;
    }
}
