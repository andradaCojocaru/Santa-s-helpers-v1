package gifts;

import entities.Gift;

import java.util.LinkedList;

public class GiftsArrays {
    private LinkedList<Gift> boardGames;
    private LinkedList<Gift> books;
    private LinkedList<Gift> clothes;
    private LinkedList<Gift> sweets;
    private LinkedList<Gift> technology;
    private LinkedList<Gift> toys;

    public GiftsArrays(final LinkedList<Gift> boardGames,
                       final LinkedList<Gift> books,
                       final LinkedList<Gift> clothes,
                       final LinkedList<Gift> sweets,
                       final LinkedList<Gift> technology,
                       final LinkedList<Gift> toys) {
        this.boardGames = boardGames;
        this.books = books;
        this.clothes = clothes;
        this.sweets = sweets;
        this.technology = technology;
        this.toys = toys;
    }

    /**
     * @return
     */
    public LinkedList<Gift> getBoardGames() {
        return boardGames;
    }

    /**
     * @return
     */
    public LinkedList<Gift> getBooks() {
        return books;
    }

    /**
     * @return
     */
    public LinkedList<Gift> getClothes() {
        return clothes;
    }

    /**
     * @return
     */
    public LinkedList<Gift> getSweets() {
        return sweets;
    }

    /**
     * @return
     */
    public LinkedList<Gift> getTechnology() {
        return technology;
    }

    /**
     * @return
     */
    public LinkedList<Gift> getToys() {
        return toys;
    }

    /**
     * @param boardGames
     */
    public void setBoardGames(final LinkedList<Gift> boardGames) {
        this.boardGames = boardGames;
    }

    /**
     * @param books
     */
    public void setBooks(final LinkedList<Gift> books) {
        this.books = books;
    }

    /**
     * @param clothes
     */
    public void setClothes(final LinkedList<Gift> clothes) {
        this.clothes = clothes;
    }

    /**
     * @param sweets
     */
    public void setSweets(final LinkedList<Gift> sweets) {
        this.sweets = sweets;
    }

    /**
     * @param technology
     */
    public void setTechnology(final LinkedList<Gift> technology) {
        this.technology = technology;
    }

    /**
     * @param toys
     */
    public void setToys(final LinkedList<Gift> toys) {
        this.toys = toys;
    }
}
