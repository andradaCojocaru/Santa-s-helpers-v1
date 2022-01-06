package changes;

import entities.Gift;
import entities.Santa;
import gifts.GiftPutInCategories;
import gifts.GiftsArrays;
import gifts.SortGifts;

import java.util.LinkedList;

public class NewGifts {
    public NewGifts() {

    }

    /**
     * @param santa
     * @param newGift
     * @param gifts
     * @return
     */
    public GiftsArrays putGifts(final Santa santa, final LinkedList<Gift> newGift,
                                 final GiftsArrays gifts) {
        GiftPutInCategories giftPutInCategories = new GiftPutInCategories(newGift);
        giftPutInCategories.giftSortType(gifts);
        SortGifts sortGifts = new SortGifts();
        sortGifts.sort();
        sortGifts.mySort(gifts.getBoardGames());
        sortGifts.mySort(gifts.getBooks());
        sortGifts.mySort(gifts.getClothes());
        sortGifts.mySort(gifts.getSweets());
        sortGifts.mySort(gifts.getSweets());
        sortGifts.mySort(gifts.getToys());
        return gifts;
    }
}
