package entities;

import java.util.LinkedList;

public final class Santa {
    private int numberOfYears;
    private Double budget;
    private LinkedList<Gift> giftList;
    private LinkedList<Child> childList;

    public Santa() {

    }

    public static class SantaBuilder {
        private int numberOfYears;
        private Double budget;
        private LinkedList<Gift> giftList;
        private LinkedList<Child> childList;

        public SantaBuilder(final int numberOfYears,
                            final Double budget,
                            final LinkedList<Gift> giftList,
                            final LinkedList<Child> childList) {
            this.numberOfYears = numberOfYears;
            this.budget = budget;
            this.giftList = giftList;
            this.childList = childList;
        }

        /**
         * @return
         */
        public Santa build() {
            return new Santa(this);
        }
    }
    private Santa(final SantaBuilder santaBuilder) {
        this.numberOfYears = santaBuilder.numberOfYears;
        this.budget = santaBuilder.budget;
        this.giftList = santaBuilder.giftList;
        this.childList = santaBuilder.childList;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public Double getBudget() {
        return budget;
    }

    public LinkedList<Gift> getGiftList() {
        return giftList;
    }

    public LinkedList<Child> getChildList() {
        return childList;
    }

}
