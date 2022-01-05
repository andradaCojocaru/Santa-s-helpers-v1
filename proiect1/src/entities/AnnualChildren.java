package entities;

import java.util.LinkedList;
public final class AnnualChildren {
    LinkedList<Child> children;

    public AnnualChildren(LinkedList<Child> annualChildren) {
            this.children = annualChildren;
    }

    public LinkedList<Child> getChildren() {
        return children;
    }

    public void setChildren(LinkedList<Child> annualChildren) {
        this.children = annualChildren;
    }

}
