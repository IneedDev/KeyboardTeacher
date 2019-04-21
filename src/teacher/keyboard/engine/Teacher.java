package teacher.keyboard.engine;

public class Teacher {
    public static boolean isCorrect(String lineFromFile, String lineEnteredByStudent) {

        if (lineFromFile.equals(lineEnteredByStudent)) {
            return true;
        } else {
            for (int i = 0; i < lineEnteredByStudent.length(); ) {
                if (lineFromFile.charAt(i) == lineEnteredByStudent.charAt(i)) {
                    i++;
                } else if (lineFromFile.charAt(i) != lineEnteredByStudent.charAt(i)) {
                    System.out.println("Popełniłeś błąd w znaku nr: " + (i + 1) + " jest to znak: '" + lineEnteredByStudent.charAt(i) + "'");
                    return false;
                }
            }
            System.out.println("Wpisałeś za mało znaków");
            return false;

        }
    }
}

