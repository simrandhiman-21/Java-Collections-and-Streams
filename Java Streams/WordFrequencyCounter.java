import java.io.*;
import java.util.*;

public class WordFrequencyCounter {

    public static void main(String[] args) {
        String filePath = "textfile.txt";    // Path to the text file

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            Map<String, Integer> wordCount = new HashMap<>();

            String line;
            while ((line = reader.readLine()) != null) {
                // Split line into words and convert to lowercase
                String[] words = line.toLowerCase().split("\\W+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }

            // Sort by frequency (descending order)
            List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCount.entrySet());
            
            sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

            // Display total words and top 5 frequent words
            System.out.println("Total unique words: " + wordCount.size());
            System.out.println("Top 5 Most Frequent Words:");

            for (int i = 0; i < Math.min(5, sortedList.size()); i++) {
                Map.Entry<String, Integer> entry = sortedList.get(i);
                System.out.println(entry.getKey() + " → " + entry.getValue());
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
