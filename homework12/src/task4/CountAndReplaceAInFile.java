package task4;

import java.io.*;

public class CountAndReplaceAInFile {
    public static void main(String[] args) {
        String fileName = "textfile.txt";

        createTextFile(
                fileName,
                "Это текстовый файл с несколькими строками." +
                        "\nЗдесь находятся разные символы a." +
                        "\nАбракадабра!"
        );

        int countA = countAInFile(fileName);
        System.out.println("Количество символов 'a' в файле: " + countA);

        replaceFileContentWithA(fileName, countA);
        System.out.println("Содержимое файла заменено на " + countA + " символов 'a'.");
    }

    public static void createTextFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int countAInFile(String fileName) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName)) ) {
            String line;
            while ((line = reader.readLine()) != null) {
                count += countAllAInString(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static int countAllAInString(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == 'a' || c == 'A') {
                count++;
            }
        }
        return count;
    }

    public static void replaceFileContentWithA(String fileName, int count) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (int i = 0; i < count; i++) {
                writer.print('a');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

