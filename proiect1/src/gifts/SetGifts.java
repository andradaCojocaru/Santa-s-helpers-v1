package gifts;

import entities.Gift;
import entities.Santa;

import java.util.LinkedList;

public class SetGifts {
    public SetGifts() {
    }

    /**
     * @param santaBuilder
     * @return
     */
    public GiftsArrays setGiftsInArray(final Santa santaBuilder) {
        GiftPutInCategories giftPutInCategories =
                new GiftPutInCategories(santaBuilder.getGiftList());
        LinkedList<Gift> boardGames = new LinkedList<>();
        LinkedList<Gift> books = new LinkedList<>();
        LinkedList<Gift> clothes = new LinkedList<>();
        LinkedList<Gift> sweets = new LinkedList<>();
        LinkedList<Gift> technology = new LinkedList<>();
        LinkedList<Gift> toys = new LinkedList<>();
        GiftsArrays giftsArrays =
                new GiftsArrays(boardGames, books, clothes, sweets, technology, toys);
        giftPutInCategories.giftSortType(giftsArrays);
        SortGifts sortGifts = new SortGifts();
        sortGifts.sort();
        sortGifts.mySort(boardGames);
        sortGifts.mySort(books);
        sortGifts.mySort(clothes);
        sortGifts.mySort(sweets);
        sortGifts.mySort(technology);
        sortGifts.mySort(toys);
        return giftsArrays;
    }
}
