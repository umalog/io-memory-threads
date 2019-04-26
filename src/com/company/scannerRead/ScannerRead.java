package com.company.scannerRead;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Boring example
 */
public class ScannerRead {
    private static List<String> stringList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        scannerExample();

        /* Ну честно, так же проще: */
//        stringList = Files.readAllLines(Paths.get("note.txt"));
//        stringList.forEach(System.out::println);
    }

    private static void scannerExample() throws FileNotFoundException {
        File file = new File("note.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                stringList.add(line);
            }
        }
        stringList.forEach(System.out::println);
    }


}
