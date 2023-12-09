package Week8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Bai6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập văn bản:");
        String text = scanner.nextLine();
        scanner.close();

        List<WordFrequency> wordFrequencies = countWords(text);

        Collections.sort(wordFrequencies);

        System.out.println("Kết quả:");
        for (WordFrequency wordFrequency : wordFrequencies) {
            System.out.println(wordFrequency.getWord() + ": " + wordFrequency.getFrequency());
        }
    }

    private static List<WordFrequency> countWords(String text) {
        List<WordFrequency> wordFrequencies = new ArrayList<>();
        String[] words = text.split("\\s+");

        for (String word : words) {
            WordFrequency existingWord = findWord(wordFrequencies, word);
            if (existingWord != null) {
                existingWord.incrementFrequency();
            } else {
                wordFrequencies.add(new WordFrequency(word));
            }
        }

        return wordFrequencies;
    }

    private static WordFrequency findWord(List<WordFrequency> wordFrequencies, String word) {
        for (WordFrequency wf : wordFrequencies) {
            if (wf.getWord().equals(word)) {
                return wf;
            }
        }
        return null;
    }

    static class WordFrequency implements Comparable<WordFrequency> {
        private String word;
        private int frequency;

        public WordFrequency(String word) {
            this.word = word;
            this.frequency = 1;
        }

        public String getWord() {
            return word;
        }

        public int getFrequency() {
            return frequency;
        }

        public void incrementFrequency() {
            this.frequency++;
        }

        @Override
        public int compareTo(WordFrequency other) {
            return this.word.compareTo(other.word);
        }
    }
}

