package utils;

import common.Constants;
import changes.AnualChanges;
import entities.Child;
import changes.ChildrenUpdate;
import entities.Gift;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.LinkedList;

public final class Utils {
    private Utils() {
    }

    /**
     * @param array
     * @return
     */
    public static LinkedList<String> giftPreferences(final JSONArray array) {
        if (array != null) {
            LinkedList<String> finalArray = new LinkedList<>();
            for (Object object : array) {
                finalArray.add((String) object);
            }
            return finalArray;
        } else {
            return null;
        }
    }

    /**
     * @param jsonChildren
     * @return
     */
    public static LinkedList<Child> jsonNewChildren(final JSONArray jsonChildren) {
        LinkedList<Child> children = new LinkedList<>();
        if (jsonChildren != null) {
            for (Object jsonChild : jsonChildren) {
                children.add(new Child.ChildBuilder(((Long)
                        ((JSONObject) jsonChild).get(Constants.ID)).intValue(),
                        (String)
                                ((JSONObject) jsonChild).get(Constants.LAST_NAME),
                        (String)
                                ((JSONObject) jsonChild).get(Constants.FIRST_NAME),
                        ((Long)
                                ((JSONObject) jsonChild).get(Constants.AGE)).intValue(),
                        (String)
                                ((JSONObject) jsonChild).get(Constants.CITY),
                        ((Long)
                                ((JSONObject) jsonChild).get(Constants.NICE_SCORE)).doubleValue(),
                        Utils.giftPreferences((JSONArray)
                                ((JSONObject) jsonChild)
                                        .get(Constants.GIFT_PREFERENCES)))
                        .build());
            }
        }
        return children;
    }

    /**
     * @param jsonSantaGiftsList
     * @return
     */
    public static LinkedList<Gift> jsonGifts(final JSONArray jsonSantaGiftsList) {
        LinkedList<Gift> giftList = new LinkedList<>();
        if (jsonSantaGiftsList != null) {
            for (Object santaGift : jsonSantaGiftsList) {
                giftList.add(new Gift.GiftBuilder((String)
                        ((JSONObject) santaGift)
                                .get(Constants.PRODUCT_NAME),
                        ((Long) ((JSONObject) santaGift)
                                .get(Constants.PRICE)).doubleValue(),
                        (String) ((JSONObject) santaGift)
                                .get(Constants.CATEGORY))
                        .build());
            }
        }
        return giftList;
    }

    /**
     * @param jsonChildrenUpdates
     * @return
     */
    public static LinkedList<ChildrenUpdate>
    jsonChildrenMakeUpdates(final JSONArray jsonChildrenUpdates) {
        LinkedList<ChildrenUpdate> children = new LinkedList<>();
        Double score = 0.0;
        final Double aboveScore = 11.0;
        if (jsonChildrenUpdates != null) {
            for (Object santaGift : jsonChildrenUpdates) {
                if ((((JSONObject) santaGift).get(Constants.NICE_SCORE)) == null) {
                    score = aboveScore;
                } else {
                    score = ((Long) ((JSONObject) santaGift)
                            .get(Constants.NICE_SCORE)).doubleValue();
                }
                children.add(new ChildrenUpdate.ChildrenUpdateBuilder(((Long)
                        ((JSONObject) santaGift)
                                .get(Constants.ID)).intValue(),
                        score,
                        Utils.giftPreferences((JSONArray)
                                ((JSONObject) santaGift)
                                        .get(Constants.GIFT_PREFERENCES)))
                        .build());
            }
        }
        return children;
    }

    /**
     * @param jsonAnnualChanges
     * @return
     */
    public static LinkedList<AnualChanges>
    anualChanges(final JSONArray jsonAnnualChanges) {
        LinkedList<AnualChanges> changes = new LinkedList<>();
        if (jsonAnnualChanges != null) {
            for (Object anualChange : jsonAnnualChanges) {
                JSONArray jsonNewChild =
                        (JSONArray) ((JSONObject) anualChange).get(Constants.NEW_CHILDREN);
                JSONArray jsonGifts =
                        (JSONArray) ((JSONObject) anualChange).get(Constants.NEW_GIFTS);
                JSONArray jsonChildrenUpdates =
                        (JSONArray) ((JSONObject) anualChange).get(Constants.CHILDREN_UPDATES);
                changes.add(new AnualChanges.AnualChangesBuilder(((Long) ((JSONObject) anualChange)
                                .get(Constants.NEW_SANTA_BUDGET))
                                .doubleValue(),
                                Utils.jsonGifts(jsonGifts),
                                Utils.jsonNewChildren(jsonNewChild),
                                Utils.jsonChildrenMakeUpdates(jsonChildrenUpdates))
                        .build());
            }
        }
        return changes;
    }
}
