package main;

import checker.Checker;
// import checker.Checkstyle;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import common.Constants;
// import fileio.Writer;
import average.GetAverageStrategy;
import average.GetAverageStrategyFactory;
import entities.AnnualChildren;
import entities.Child;
import entities.Gift;
import entities.ListResult;
import entities.Santa;
import gifts.GiftPutInCategories;
import gifts.GiftsArrays;
import gifts.SortGifts;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Class used to run the code
 */
public final class Main {

    private Main() {
        ///constructor for checkstyle
    }
    /**
     * This method is used to call the checker which calculates the score
     * @param args
     *          the arguments used to call the main method
     */
    public static void main(final String[] args) throws IOException {
        File directory = new File(Constants.TESTS_PATH);
        Path path = Paths.get(Constants.OUTPUT);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }

        for (File file : Objects.requireNonNull(directory.listFiles())) {
            String name = file.getName();
            name = name.replaceAll("[^\\d]", "");
            File out = new File(Constants.OUTPUT_PATH
                    + name + Constants.FILE_EXTENSION);
            boolean isCreated = out.createNewFile();
            if (isCreated) {
                action(file.getAbsolutePath(), out.getAbsolutePath());
            }
        }
        Checker.calculateScore();
    }

        /**
         * @param filePath2 for output file
         * @throws IOException in case of exceptions to reading / writing
         */
        public static void action(final String filePath1,
                                  final String filePath2) throws IOException {
            InputLoader inputLoader = new InputLoader(filePath1);
            Input input = inputLoader.readData();
            Santa santaBuilder = input.getSanta();
            Double sumAverage = 0.0;
            Double budgetUnit = 0.0;
            for (Child child : santaBuilder.getChildList()) {
                LinkedList<Double> niceScore = new LinkedList<>();
                niceScore.add(child.getAverageScore());
                child.setNiceScoreHistory(niceScore);
                GetAverageStrategyFactory getAverageStrategyFactory =
                        new GetAverageStrategyFactory();
                GetAverageStrategy getAverageStrategy =
                        getAverageStrategyFactory.createStrategy(child);
                child.setAverageScore(getAverageStrategy.getAverageScore());
                sumAverage += child.getAverageScore();
            }
            budgetUnit = santaBuilder.getBudget() / sumAverage;
            for (Child child : santaBuilder.getChildList()) {
                child.setAssignedBudget(budgetUnit * child.getAverageScore());
            }
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
            giftPutInCategories.giftSort(giftsArrays);
            SortGifts sortGifts = new SortGifts();
            sortGifts.sort();
            sortGifts.mySort(boardGames);
            sortGifts.mySort(books);
            sortGifts.mySort(clothes);
            sortGifts.mySort(sweets);
            sortGifts.mySort(technology);
            sortGifts.mySort(toys);
            santaBuilder.getChildList().removeIf(x -> x.getAverageScore().equals(0.0));
            for (Child child : santaBuilder.getChildList()) {
                Double leftBudget = child.getAssignedBudget();
                for (String gift : child.getGiftPreferences()) {
                    LinkedList<Gift> giftType = new LinkedList<>();
                    switch (gift) {
                        case "Board Games": giftType = giftsArrays.getBoardGames();
                            break;
                        case "Books": giftType = giftsArrays.getBooks();
                            break;
                        case "Clothes": giftType = giftsArrays.getClothes();
                            break;
                        case "Sweets": giftType = giftsArrays.getSweets();
                            break;
                        case "Technology": giftType = giftsArrays.getTechnology();
                            break;
                        case "Toys": giftType = giftsArrays.getToys();
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
            LinkedList<AnnualChildren> listAnnualChildren = new LinkedList<>();
            for (int i = 0; i <= santaBuilder.getNumberOfYears(); i++) {
                AnnualChildren annualChildren =
                        new AnnualChildren(santaBuilder.getChildList());
                listAnnualChildren.add(annualChildren);
            }
            ListResult listResult = new ListResult(listAnnualChildren);
            try {
                ObjectMapper mapper = new ObjectMapper();
                ObjectWriter writer =
                        mapper.writer(new DefaultPrettyPrinter());

                writer.writeValue(Paths.get(filePath2).toFile(), listResult);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
}
