package changes;

import entities.Child;
import entities.Santa;

import java.util.LinkedList;

public class NewChildren {
    public NewChildren() {

    }

    /**
     * @param santa
     * @param newChildren
     */
    public void addNewChildren(final Santa santa, final LinkedList<Child> newChildren) {
        LinkedList<Child> children = santa.getChildList();
        for (Child child : newChildren) {
            children.add(child);
        }
    }
}
