package gifts;

import entities.Child;
import entities.Gift;
import entities.Santa;

import java.util.LinkedList;

public class FindGifts {
    public FindGifts() {

    }

    /**
     * @param santaBuilder
     * @param giftsArrays
     */
    public void findGiftsChildren(final Santa santaBuilder, final GiftsArrays giftsArrays) {
        for (Child child : santaBuilder.getChildList()) {
            Double leftBudget = child.getAssignedBudget();
            for (String gift : child.getGiftsPreferences()) {
                LinkedList<Gift> giftType = new LinkedList<>();
                switch (gift) {
                    case "Board Games":
                        giftType = giftsArrays.getBoardGames();
                        break;
                    case "Books":
                        giftType = giftsArrays.getBooks();
                        break;
                    case "Clothes":
                        giftType = giftsArrays.getClothes();
                        break;
                    case "Sweets":
                        giftType = giftsArrays.getSweets();
                        break;
                    case "Technology":
                        giftType = giftsArrays.getTechnology();
                        break;
                    case "Toys":
                        giftType = giftsArrays.getToys();
                        break;
                    default:
                        throw new IllegalArgumentException("Type of gift not found ");
                }
                if (!giftType.isEmpty()) {
                    Gift selectedGift = giftType.get(0);
                    if (selectedGift.getPrice() <= leftBudget) {
                        if (child.getReceivedGifts() == null) {
                            LinkedList<Gift> receivedGifts = new LinkedList<>();
                            child.setReceivedGifts(receivedGifts);
                        }
                        child.getReceivedGifts().add(selectedGift);
                        child.setReceivedGifts(child.getReceivedGifts());
                        leftBudget -= selectedGift.getPrice();
                    }
                }
            }
        }
    }
}
