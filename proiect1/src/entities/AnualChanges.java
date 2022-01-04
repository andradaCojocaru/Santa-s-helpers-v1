package entities;

import java.util.LinkedList;

public final class AnualChanges {
    private Double newSantaBudget;
    private LinkedList<Gift.GiftBuilder> newGifts;
    private LinkedList<Child.ChildBuilder> newChildren;
    private LinkedList<ChildrenUpdate.ChildrenUpdateBuilder> childrenUpdate;

    public static class AnualChangesBuilder {
        private Double newSantaBudget;
        private LinkedList<Gift.GiftBuilder> newGifts;
        private LinkedList<Child.ChildBuilder> newChildren;
        private LinkedList<ChildrenUpdate.ChildrenUpdateBuilder> childrenUpdate;

        public AnualChangesBuilder(final Double newSantaBudget,
                                   final LinkedList<Gift.GiftBuilder> newGifts,
                                   final LinkedList<Child.ChildBuilder> newChildren,
                                   final LinkedList<ChildrenUpdate.ChildrenUpdateBuilder>
                                           childrenUpdate) {
            this.newSantaBudget = newSantaBudget;
            this.newGifts = newGifts;
            this.newChildren = newChildren;
            this.childrenUpdate = childrenUpdate;
        }

        /**
         * @return
         */
        public AnualChanges build() {
            return new AnualChanges(this);
        }
    }
    private AnualChanges(final AnualChangesBuilder anualChangesBuilder) {
        this.newSantaBudget = anualChangesBuilder.newSantaBudget;
        this.newGifts = anualChangesBuilder.newGifts;
        this.newChildren = anualChangesBuilder.newChildren;
        this.childrenUpdate = anualChangesBuilder.childrenUpdate;
    }

    public Double getNewSantaBudget() {
        return newSantaBudget;
    }

    public LinkedList<Gift.GiftBuilder> getNewGifts() {
        return newGifts;
    }

    public LinkedList<Child.ChildBuilder> getNewChildren() {
        return newChildren;
    }

    public LinkedList<ChildrenUpdate.ChildrenUpdateBuilder> getChildrenUpdate() {
        return childrenUpdate;
    }
}
