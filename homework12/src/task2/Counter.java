package task2;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Counter {
    public static void main(String[] args) {
       createTextFile("text.txt", "Это пример текста с несколькими знаками препинания." +
                " Количество слов и знаков препинания будет подсчитано.");

        try (BufferedReader reader = new BufferedReader(new FileReader("text.txt"))){
            String line;
            int punctuationCount = 0;
            int wordCount = 0;
            while ((line = reader.readLine()) != null) {
                punctuationCount += countPunctuation(line);
                wordCount += countWords(line);
            }
            System.out.println("Количество знаков препинания: " + punctuationCount);
            System.out.println("Количество слов: " + wordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createTextFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int countPunctuation(String text) {
        int count = 0;
        Pattern pattern = Pattern.compile("\\p{Punct}");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public static int countWords(String text) {
        String[] words = text.split("\\s+");
        return words.length;
    }
}

