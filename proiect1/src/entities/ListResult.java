package entities;
import entities.AnnualChildren;

import java.util.LinkedList;

public final class ListResult {
    LinkedList<AnnualChildren> annualChildren;

    public ListResult(LinkedList<AnnualChildren> annualChildren) {
        this.annualChildren = annualChildren;
    }

    public LinkedList<AnnualChildren> getAnnualChildren() {
        return annualChildren;
    }

    public void setAnnualChildren(LinkedList<AnnualChildren> annualChildren) {
        this.annualChildren = annualChildren;
    }
}
