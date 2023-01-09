package wordset;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */
public class WordSet {
    private Set<String> wordset = new HashSet<>();

    public void readFromFile(String filenaam) {
        File teLezenBestand = new File(filenaam);
        try (Scanner bestandsScanner = new Scanner(teLezenBestand)) {
            while (bestandsScanner.hasNext()) {
                String toeTeVoegenWoord = bestandsScanner.next();

                toeTeVoegenWoord = toeTeVoegenWoord.replaceAll("[^A-Za-z0-9-]", "");
                toeTeVoegenWoord = toeTeVoegenWoord.toLowerCase();

                if (!toeTeVoegenWoord.isEmpty()) {
                    wordset.add(toeTeVoegenWoord);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.printf("Het openen van bestand: %s is niet gelukt.\n\n%s", filenaam, e.getMessage());
        }
    }

    public int getNrOfUniqueWords() {
        return wordset.size();
    }

    public Iterable<String> getWordsSorted() {
        List<String> teSorterenLijst = new ArrayList<>(wordset);
        Collections.sort(teSorterenLijst);
        return teSorterenLijst;
    }
}
