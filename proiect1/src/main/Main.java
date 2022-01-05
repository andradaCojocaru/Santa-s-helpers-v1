package main;

import checker.Checker;
// import checker.Checkstyle;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import common.Constants;
// import fileio.Writer;
import entities.AnnualChildren;
import entities.ListResult;
import entities.Santa;

import javax.xml.transform.Result;
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
            File out = new File(Constants.OUTPUT_PATH + name + Constants.FILE_EXTENSION);
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
        public static void action(final String filePath1, final String filePath2) throws IOException {
            InputLoader inputLoader = new InputLoader(filePath1);
            Input input = inputLoader.readData();
            Santa santaBuilder = input.getSanta();
            AnnualChildren annualChildren = new AnnualChildren(santaBuilder.getChildList());
            LinkedList<AnnualChildren> listAnnualChildren = new LinkedList<>();
            listAnnualChildren.add(annualChildren);
            ListResult listResult = new ListResult(listAnnualChildren);
            try {
                ObjectMapper mapper = new ObjectMapper();
                ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

                writer.writeValue(Paths.get(filePath2).toFile(), listResult);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
}
