package entities;

import java.util.LinkedList;

public final class ChildrenUpdate {
    private int id;
    private Double niceScore;
    private LinkedList<String> giftPreferences;

    public static class ChildrenUpdateBuilder {
        private int id;
        private Double niceScore;
        private LinkedList<String> giftPreferences;

        public ChildrenUpdateBuilder(final int id, final Double niceScore,
                                     final LinkedList<String> giftPreferences) {
            this.id = id;
            this.niceScore = niceScore;
            this.giftPreferences = giftPreferences;
        }

        /**
         * @return
         */
        public ChildrenUpdate build() {
            return new ChildrenUpdate(this);
        }
    }
    private ChildrenUpdate(final ChildrenUpdateBuilder childrenUpdateBuilder) {
        this.id = childrenUpdateBuilder.id;
        this.niceScore = childrenUpdateBuilder.niceScore;
        this.giftPreferences = childrenUpdateBuilder.giftPreferences;
    }

    public int getId() {
        return id;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public LinkedList<String> getGiftPreferences() {
        return giftPreferences;
    }
}
