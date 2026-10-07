import java.util.*;
public class StopWordFilteredWordFrequency {
    public static void printFilteredWordFrequency(String feedback) {
        String[] stopWords = {
            "the", "was", "and", "a", "is", "of", "in"
        };
        HashSet<String> stopWordSet = new HashSet<>();
        for (String word : stopWords) {
            stopWordSet.add(word);
        }
        String cleanedText = feedback.toLowerCase();
        cleanedText = cleanedText.replace(".", "");
        cleanedText = cleanedText.replace(",", "");
        String[] words = cleanedText.split("\\s+");
        HashMap<String, Integer> frequency = new HashMap<>();
        for (String word : words) {
            if (stopWordSet.contains(word)) {
                continue;
            }
            frequency.put(
                word,
                frequency.getOrDefault(word, 0) + 1
            );
        }
        List<Map.Entry<String, Integer>> entries =
                new ArrayList<>(frequency.entrySet());
                entries.sort((a, b) -> b.getValue().compareTo(a.getValue())
        );
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    public static void main(String[] args) {
        String feedback =
            "The mentor was great, the session was great and clear.";
            printFilteredWordFrequency(feedback);
    }
}