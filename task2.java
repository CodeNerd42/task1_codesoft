import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WordCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text or provide a file path to count the words:");

        String input = scanner.nextLine();

        int wordCount = 0;

        if (input.startsWith("file:")) {
            
            String filePath = input.substring(5);
            wordCount = countWordsInFile(filePath);
        } else {
         
            wordCount = countWordsInText(input);
        }

        System.out.println("Total words: " + wordCount);

        scanner.close();
    }

    private static int countWordsInText(String text) {
        String[] words = text.split("\\s+|\\p{Punct}");
        return words.length;
    }

    private static int countWordsInFile(String filePath) {
        int wordCount = 0;
        try {
            File file = new File(filePath);
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                wordCount += countWordsInText(line);
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }
        return wordCount;
    }
}
