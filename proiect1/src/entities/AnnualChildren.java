package entities;

import java.util.LinkedList;
public final class AnnualChildren {
    private LinkedList<Child> children;

    public AnnualChildren(final LinkedList<Child> annualChildren) {
            this.children = annualChildren;
    }

    public LinkedList<Child> getChildren() {
        return children;
    }

    public void setChildren(final LinkedList<Child> annualChildren) {
        this.children = annualChildren;
    }

}
