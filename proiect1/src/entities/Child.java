package entities;

import java.util.LinkedList;

public class Child {
    private int id;
    private String lastName;
    private String firstName;
    private String city;
    private int age;
    private LinkedList<String> giftPreferences;
    private Double averageScore;
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
        private Double averageScore; // for result
        private LinkedList<Integer> niceScoreHistory;
        private Double assignedBudget; // for result
        private LinkedList<Gift> receivedGifts; // for result

        public ChildBuilder(final int id, final String firstName,
                            final String lastName, final int age,
                            final LinkedList<String> giftPreferences,
                            final LinkedList<Integer> niceScoreHistory) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.giftPreferences = giftPreferences;
            this.niceScoreHistory = niceScoreHistory;
        }

        public ChildBuilder averageScore(final Double averageScore) {
            this.averageScore = averageScore;
            return this;
        }

        public ChildBuilder assignedBudget(final Double assignedBudget) {
            this.assignedBudget = assignedBudget;
            return this;
        }

        public ChildBuilder receivedGifts(final LinkedList<Gift> receivedGifts) {
            this.receivedGifts = receivedGifts;
            return this;
        }

        public Child build() {
            return new Child(this);
        }
    }

        private Child(ChildBuilder childBuilder) {
            this.id = childBuilder.id;
            this.lastName = childBuilder.lastName;
            this.firstName = childBuilder.firstName;
            this.city = childBuilder.city;
            this.age = childBuilder.age;
            this.giftPreferences = childBuilder.giftPreferences;
            this.averageScore = childBuilder.averageScore;
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

        public LinkedList<Integer> getNiceScoreHistory() {
            return niceScoreHistory;
        }

        public Double getAssignedBudget() {
            return assignedBudget;
        }

        public LinkedList<Gift> getReceivedGifts() {
            return receivedGifts;
        }
}
