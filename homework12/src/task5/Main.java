package task5;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        createStudentFile("students.txt");
        createQuestionFile("questions.txt");

        List<Student> students = loadStudents("students.txt");
        List<Question> questions = loadQuestions("questions.txt");

        Scanner scanner = new Scanner(System.in);

        while (!questions.isEmpty()) {
            System.out.println("Выберите группу (А/Б) или 'стоп' для завершения:");
            String group = scanner.nextLine();
            if ("стоп".equalsIgnoreCase(group)) {
                printScoreboard(students);
                return;
            }

            System.out.println("Выберите тему (География/Паскаль) или 'стоп' для завершения:");
            String topic = scanner.nextLine();
            if ("стоп".equalsIgnoreCase(topic)) {
                printScoreboard(students);
                return;
            }

            for (Student student : students) {
                if (student.getGroup().equals(group)) {
                    Question questionForStudent = null;
                    for (Question question : questions) {
                        if (question.getGroup().equals(group) && question.getTopic().equals(topic)) {
                            questionForStudent = question;
                            break;
                        }
                    }

                    if (questionForStudent == null) {
                        System.out.println("Нет доступных вопросов для данного студента.");
                        continue;
                    }

                    System.out.println("Вопрос для " + student.getFullName() + ": " + questionForStudent.getText());
                    System.out.print("Ответ студента: ");
                    String answer = scanner.nextLine();
                    System.out.println("Правильно? (да/нет) или 'стоп' для завершения:");
                    String response = scanner.nextLine();

                    if ("да".equalsIgnoreCase(response)) {
                        student.increaseScore();
                    } else if ("стоп".equalsIgnoreCase(response)) {
                        printScoreboard(students);
                        return;
                    }

                    questions.remove(questionForStudent);
                }
            }
        }
        printScoreboard(students);
    }

    public static void printScoreboard(List<Student> students) {
        System.out.println("\nРезультаты студентов:");
        for (Student student : students) {
            System.out.println(student.getFullName() + ": " + student.getScore() + " правильных ответов");
        }
    }

    public static void createStudentFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Иван,Иванов,А\n");
            writer.write("Петр,Петров,А\n");
            writer.write("Анна,Сидорова,Б\n");
            writer.write("Андрей,Блинов,Б\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createQuestionFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Вопросы для группы А по теме "География"
            writer.write("Столица Франции?,География,А\n");
            writer.write("Океан между Америкой и Европой?,География,А\n");

            // Вопросы для группы А по теме "Паскаль"
            writer.write("На каком языке Pascal?,Паскаль,А\n");
            writer.write("Расширение файла Pascal?,Паскаль,А\n");

            // Вопросы для группы Б по теме "География"
            writer.write("Сколько планет в Солнечной системе?,География,Б\n");
            writer.write("Столица Англии?,География,Б\n");

            // Вопросы для группы Б по теме "Паскаль"
            writer.write("Что такое цикл?,Паскаль,Б\n");
            writer.write("Символ начала блока кода в Pascal?,Паскаль,Б\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> loadStudents(String fileName) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                students.add(new Student(parts[0], parts[1], parts[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static List<Question> loadQuestions(String fileName) {
        List<Question> questions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                questions.add(new Question(parts[0], parts[1], parts[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questions;
    }
}

