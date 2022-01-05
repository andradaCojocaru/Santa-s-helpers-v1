package entities;

import java.util.LinkedList;

public final class Child {
    private int id;
    private String lastName;
    private String firstName;
    private String city;
    private int age;
    private LinkedList<String> giftPreferences;
    private Double averageScore;
    private Double niceScore;
    private LinkedList<Integer> niceScoreHistory;
    private Double assignedBudget;
    private LinkedList<Gift> receivedGifts;

    public static class ChildBuilder {
        private int id;
        private String lastName;
        private String firstName;
        private String city;
        private int age;
        private LinkedList<String> giftPreferences;
        private Double averageScore;
        private Double niceScore;
        private LinkedList<Integer> niceScoreHistory;
        private Double assignedBudget;
        private LinkedList<Gift> receivedGifts;

        public ChildBuilder(final int id, final String lastName,
                            final String firstName, final int age,
                            final String city,
                            final Double niceScore,
                            final LinkedList<String> giftPreferences) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.city = city;
            this.niceScore = niceScore;
            this.giftPreferences = giftPreferences;
        }

        /**
         * @param averageScore
         * @return
         */
        public ChildBuilder averageScore(final Double averageScore) {
            this.averageScore = averageScore;
            return this;
        }

        /**
         * @param assignedBudget
         * @return
         */
        public ChildBuilder assignedBudget(final Double assignedBudget) {
            this.assignedBudget = assignedBudget;
            return this;
        }

        /**
         * @param receivedGifts
         * @return
         */
        public ChildBuilder receivedGifts(final LinkedList<Gift> receivedGifts) {
            this.receivedGifts = receivedGifts;
            return this;
        }

        /**
         * @return
         */
        public Child build() {
            return new Child(this);
        }
    }

        private Child(final ChildBuilder childBuilder) {
            this.id = childBuilder.id;
            this.lastName = childBuilder.lastName;
            this.firstName = childBuilder.firstName;
            this.city = childBuilder.city;
            this.age = childBuilder.age;
            this.giftPreferences = childBuilder.giftPreferences;
            this.averageScore = childBuilder.averageScore;
            this.niceScore = childBuilder.niceScore;
            this.niceScoreHistory = childBuilder.niceScoreHistory;
            this.assignedBudget = childBuilder.assignedBudget;
            this.receivedGifts = childBuilder.receivedGifts;
        }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

    public LinkedList<String> getGiftPreferences() {
        return giftPreferences;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public LinkedList<Integer> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public Double getAssignedBudget() {
        return assignedBudget;
    }

    public LinkedList<Gift> getReceivedGifts() {
        return receivedGifts;
    }

    @Override
    public String toString() {
        return "children{"
                + "id=" + id
                + " lastName='" + lastName
                + " firstName='" + firstName
                + " city='" + city
                + " age=" + age
                + " giftPreferences=" + giftPreferences
                + " averageScore=" + averageScore
                + " niceScoreHistory=" + niceScoreHistory
                + " assignedBudget=" + assignedBudget
                + " receivedGifts=" + receivedGifts
                + '}';
    }
}
