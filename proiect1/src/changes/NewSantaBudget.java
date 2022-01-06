package changes;

import entities.Santa;

public class NewSantaBudget {
    public NewSantaBudget() {

    }

    /**
     * @param santa
     * @param newBudget
     */
    public void putNewSantaBudget(final Santa santa, final Double newBudget) {
        santa.setBudget(newBudget);
    }
}
