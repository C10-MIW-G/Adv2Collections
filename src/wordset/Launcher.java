package wordset;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */
public class Launcher {

    public static void main(String[] args) {
        WordSet wordSet = new WordSet();

        wordSet.readFromFile("resources/input.txt");

        System.out.println(wordSet.getNrOfUniqueWords());

        for (String woord : wordSet.getWordsSorted()) {
            System.out.println(woord);
        }
    }
}
