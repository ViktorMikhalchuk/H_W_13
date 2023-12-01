package org.dictionary;

import org.dictionary.hw13.FileNavigator;

public class Application {
    public static void main(String[] args) {

        FileNavigator fileNavigator = new FileNavigator();

        fileNavigator.add("C:\\Users\\Admin\\JavaProjects\\HW_13_Dictionary\\src\\main\\java\\hw\\hw13", "file1.txt", 1024);
        fileNavigator.add("C:\\Users\\Admin\\JavaProjects\\HW_13_Dictionary\\src\\main\\java\\hw\\hw13", "file2.txt", 2048);
        // fileNavigator.add("/another/path", "file3.txt", 4096); //error


        fileNavigator.saveAllFiles(); // Збереження всіх файлів

        System.out.println(fileNavigator);

    }
}