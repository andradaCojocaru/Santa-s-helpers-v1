package entities;

import java.util.LinkedList;

public class Santa {
    private Double budget;
    private LinkedList<Gift> giftList;
    private LinkedList<Child> childList;

    public static class SantaBuilder {
        private Double budget;
        private LinkedList<Gift> giftList;
        private LinkedList<Child> childList;

        public SantaBuilder(final Double budget,
                            final LinkedList<Gift> giftList,
                            final LinkedList<Child> childList) {
            this.budget = budget;
            this.giftList = giftList;
            this.childList = childList;
        }

        public Santa build() {
            return new Santa(this);
        }
    }
    private Santa(SantaBuilder santaBuilder) {
        this.budget = santaBuilder.budget;
        this.giftList = santaBuilder.giftList;
        this.childList = santaBuilder.childList;
    }
}
