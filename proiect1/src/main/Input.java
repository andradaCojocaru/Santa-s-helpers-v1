package main;

import entities.AnualChanges;
import entities.Santa;

import java.util.LinkedList;


public class Input {
    private Santa.SantaBuilder santa;
    private LinkedList<AnualChanges.AnualChangesBuilder> anualChanges;

    public Input(final Santa.SantaBuilder santa,
                 final LinkedList<AnualChanges.AnualChangesBuilder> anualChanges) {
        this.santa = santa;
        this.anualChanges = anualChanges;
    }

    /**
     * @return
     */
    public Santa.SantaBuilder getSanta() {
        return santa;
    }

    /**
     * @return
     */
    public LinkedList<AnualChanges.AnualChangesBuilder> getAnualChanges() {
        return anualChanges;
    }
}
