package main;

import changes.AnualChanges;
import entities.Santa;

import java.util.LinkedList;


public class Input {
    private Santa santa;
    private LinkedList<AnualChanges> anualChanges;

    public Input(final Santa santa,
                 final LinkedList<AnualChanges> anualChanges) {
        this.santa = santa;
        this.anualChanges = anualChanges;
    }

    /**
     * @return
     */
    public Santa getSanta() {
        return santa;
    }

    /**
     * @return
     */
    public LinkedList<AnualChanges> getAnualChanges() {
        return anualChanges;
    }
}
