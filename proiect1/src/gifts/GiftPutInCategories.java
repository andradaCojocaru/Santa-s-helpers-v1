package gifts;

import entities.Gift;

import java.util.LinkedList;

public class GiftPutInCategories {
    private LinkedList<Gift> gifts;
    public GiftPutInCategories(final LinkedList<Gift> gifts) {
        this.gifts = gifts;
    }

    /**
     * @param giftsArrays
     */
    public void giftSortType(final GiftsArrays giftsArrays) {
        for (Gift gift : gifts) {
            switch (gift.getCategory()) {
                case "Board Games": giftsArrays.getBoardGames().add(gift);
                    giftsArrays.setBoardGames(giftsArrays.getBoardGames());
                    break;
                case "Books": giftsArrays.getBooks().add(gift);
                    giftsArrays.setBooks(giftsArrays.getBooks());
                    break;
                case "Clothes": giftsArrays.getClothes().add(gift);
                    giftsArrays.setClothes(giftsArrays.getClothes());
                    break;
                case "Sweets": giftsArrays.getSweets().add(gift);
                    giftsArrays.setSweets(giftsArrays.getSweets());
                    break;
                case "Technology": giftsArrays.getTechnology().add(gift);
                    giftsArrays.setTechnology(giftsArrays.getTechnology());
                    break;
                case "Toys": giftsArrays.getToys().add(gift);
                    giftsArrays.setToys(giftsArrays.getToys());
                    break;
                default:
                    throw new IllegalArgumentException("Type of gift not found ");
            }
        }
    }
}
