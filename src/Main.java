import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void saveNotes(ArrayList<String> notes, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String note: notes) {
                writer.write(note);
                writer.newLine();
            }
        }   catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }
    }
    public static void main(String[] args){
        String fileName = "notes.txt";
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> notes = new ArrayList<>();

    File file = new File(fileName);
    if (file.exists()) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                notes.add(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

        while (true) {
            System.out.println("\n1 - добавить заметку");
            System.out.println("2 - показать все");
            System.out.println("3 - удалить");
            System.out.println("4 - выход");
            System.out.print("Выбери: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Введите заметку: ");
            String note = scanner.nextLine();
            notes.add(note);
            saveNotes(notes, fileName);
            System.out.println("Заметка добавлена! Всего заметок: " + notes.size());
            }   else if (choice == 2) {
                if (notes.isEmpty()) {
                    System.out.println("Заметок нет!");
                }   else {
                    System.out.println("Вот ваши заметки: ");
                    for (int i = 0; i < notes.size(); i++) {
                        System.out.println((i + 1) + ". " + notes.get(i));
                    }
                        }
                    }   else if (choice == 3) {
                System.out.println("Номер заметки для удаления: ");
                int index = scanner.nextInt();
                scanner.nextLine();
                if (index >= 1 && index <= notes.size()) {
                    notes.remove(index - 1);
                    saveNotes(notes, fileName);
                    System.out.println("Удалено!");
                } else {
                    System.out.println("Нет такого номера!");
                }
            }   else if (choice == 4)  {
                System.out.println("Пока!");
                break;
            }   else {
                System.out.println("Извините, я вас не понимаю");
            }
        }
    }
}