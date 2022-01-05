package entities;

import java.util.LinkedList;

public final class ListResult {
    private LinkedList<AnnualChildren> annualChildren;

    public ListResult(final LinkedList<AnnualChildren> annualChildren) {
        this.annualChildren = annualChildren;
    }

    public LinkedList<AnnualChildren> getAnnualChildren() {
        return annualChildren;
    }

    public void setAnnualChildren(final LinkedList<AnnualChildren> annualChildren) {
        this.annualChildren = annualChildren;
    }
}
