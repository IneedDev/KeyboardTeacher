package teacher.keyboard.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    public static List<String> readFile (String sourceLine) throws FileNotFoundException {

            List<String> sourceText = new ArrayList<>();
            File file = new File(sourceLine);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                sourceText.add(sc.nextLine());
            }
            return sourceText;

    }
}