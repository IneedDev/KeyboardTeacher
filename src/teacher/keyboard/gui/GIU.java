package teacher.keyboard.gui;


import teacher.keyboard.data.FileReader;
import teacher.keyboard.engine.Teacher;

import java.io.FileNotFoundException;

import java.util.List;
import java.util.Scanner;

public class GIU {

    private static Scanner scanner = new Scanner(System.in);

    private static String textSourceAdd() {
        System.out.println("Rozpoczymany naukę, podaj ścieżkę do pliku .txt: ");
        return scanner.nextLine();
    }

    private static int howManyLineStudentWant() {


        try {
            System.out.println("Podaj ile chcesz przepisać lini: ");
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Podaj liczbę jeśli chcesz kontynuować:");
            return Integer.parseInt(scanner.nextLine());
        }

    }

    public static void appController() {
        List<String> textToCopy = null;
        while (textToCopy == null) {
            String source = textSourceAdd();

            try {
                textToCopy = FileReader.readFile(source);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("Zła ścieżka dostępu oczekiwany format: '//C:/User/some/Desktop/text.txt");
            }
        }
        int howManyLineToPrint = howManyLineStudentWant();
        while (howManyLineToPrint > textToCopy.size()) {
            System.out.println("Nie ma tyle lini w tekście podaj poprawną wartość");
            howManyLineToPrint = howManyLineStudentWant();
        }


        int textLine = 0;

        long timerStart = System.currentTimeMillis();

        do {

            String textToCopyLine = textToCopy.get(textLine);
            System.out.println(textToCopyLine);
            String textEnteredByStudent = scanner.nextLine();

            if (Teacher.isCorrect(textToCopyLine, textEnteredByStudent)) {
                textLine++;
            } else {
                System.out.println("Popełniono błąd wprowadź tekst jeszcze raz:");
            }
        } while (textLine < howManyLineToPrint);
        long timerStop = System.currentTimeMillis();
        long copyingTime = (timerStop - timerStart) / 1000;

        System.out.println("Gratulacje przepisałeś poprawnie tekst w czasie: " + copyingTime + " sekund");

    }
}



