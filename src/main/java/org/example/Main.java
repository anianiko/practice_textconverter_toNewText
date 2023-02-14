package org.example;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("text.txt");
            BufferedWriter out = new BufferedWriter(
                    new FileWriter("text_new.txt", true));
            Scanner scanner = new Scanner(file);
            String fileContent = "";

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                fileContent += line + "\n";
            }

            char[] charString = fileContent.toCharArray();

            for (int i = charString.length - 1; i >= 0; i--) {
                char character = charString[i];

                if (Character.isUpperCase(character)) {
                    character = Character.toLowerCase(character);
                } else {
                    character = Character.toUpperCase(character);
                }
                out.write(character);
            }
            out.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}