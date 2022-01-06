package main;

import changes.AnualChanges;
import changes.ChildrenUpdate;
import changes.IncreaseAge;
import changes.NewChildren;
import changes.NewChildrenUpdates;
import changes.NewGifts;
import changes.NewSantaBudget;
import checker.Checker;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import common.Constants;
import entities.AnnualChildren;
import entities.Child;
import entities.CopySanta;
import entities.ListResult;
import entities.Santa;
import gifts.FindGifts;
import gifts.GiftsArrays;
import gifts.SetGifts;

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
    final static int ABOVEAVERAGE=11;
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
            final Double aboveAverage = 11.0;
            Santa santaBuilder = input.getSanta();
            LinkedList<AnualChanges> anualChanges = input.getAnualChanges();
            DataInput dataInput = new DataInput();
            dataInput.setData(santaBuilder);
            SetGifts setGifts = new SetGifts();
            GiftsArrays giftsArrays = setGifts.setGiftsInArray(santaBuilder);
            FindGifts findGifts = new FindGifts();
            findGifts.findGiftsChildren(santaBuilder, giftsArrays);
            LinkedList<AnnualChildren> listAnnualChildren = new LinkedList<>();
            CopySanta copySanta = new CopySanta();
            AnnualChildren annualChildren =
                    new AnnualChildren(copySanta.copyConstructor(santaBuilder));
            listAnnualChildren.add(annualChildren);
            for (Child child : santaBuilder.getChildList()) {
                child.setReceivedGifts(null);
            }
            for (int i = 0; i < santaBuilder.getNumberOfYears(); i++) {

                IncreaseAge increaseAge = new IncreaseAge();
                increaseAge.applyIncreaseAge(santaBuilder);
                AnualChanges change = anualChanges.get(i);
                NewSantaBudget newSantaBudget = new NewSantaBudget();
                newSantaBudget.putNewSantaBudget(santaBuilder, change.getNewSantaBudget());
                NewGifts newGifts = new NewGifts();
                newGifts.putGifts(santaBuilder, change.getNewGifts(), giftsArrays);
                NewChildren newChildren = new NewChildren();
                newChildren.addNewChildren(santaBuilder, change.getNewChildren());
                NewChildrenUpdates newChildrenUpdates = new NewChildrenUpdates();
                LinkedList<ChildrenUpdate> update = new LinkedList<>();
                update = change.getChildrenUpdate();
                newChildrenUpdates.makeNewChildrenUpdates(santaBuilder, update);
                dataInput.setData(santaBuilder);
                findGifts.findGiftsChildren(santaBuilder, giftsArrays);
                copySanta = new CopySanta();
                copySanta.copyConstructor(santaBuilder);
                annualChildren =
                        new AnnualChildren(copySanta.copyConstructor(santaBuilder));
                listAnnualChildren.add(annualChildren);
                for (Child child : santaBuilder.getChildList()) {
                    child.setReceivedGifts(null);
                }
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
