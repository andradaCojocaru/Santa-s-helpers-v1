package changes;

import entities.Child;
import entities.Santa;

import java.util.LinkedList;

public class IncreaseAge {
    public IncreaseAge() {

    }

    /**
     * @param santa
     */
    public void applyIncreaseAge(final Santa santa) {
        LinkedList<Child> children = santa.getChildList();
        for (Child child : children) {
            child.setAge(child.getAge() + 1);
        }
    }
}
