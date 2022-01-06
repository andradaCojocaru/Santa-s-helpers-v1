package changes;

import entities.Child;
import entities.Gift;

import java.util.LinkedList;

public final class AnualChanges {
    private Double newSantaBudget;
    private LinkedList<Gift> newGifts;
    private LinkedList<Child> newChildren;
    private LinkedList<ChildrenUpdate> childrenUpdate;

    public static class AnualChangesBuilder {
        private Double newSantaBudget;
        private LinkedList<Gift> newGifts;
        private LinkedList<Child> newChildren;
        private LinkedList<ChildrenUpdate> childrenUpdate;

        public AnualChangesBuilder(final Double newSantaBudget,
                                   final LinkedList<Gift> newGifts,
                                   final LinkedList<Child> newChildren,
                                   final LinkedList<ChildrenUpdate> childrenUpdate) {
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

    public LinkedList<Gift> getNewGifts() {
        return newGifts;
    }

    public LinkedList<Child> getNewChildren() {
        return newChildren;
    }

    public LinkedList<ChildrenUpdate> getChildrenUpdate() {
        return childrenUpdate;
    }
}
