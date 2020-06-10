package CypherConsoles;

import Utils.ConsoleStrings;
import Utils.FileManipulator;

import java.util.Scanner;

public class BasicConsoleApp {

    private Scanner scanner;

    public BasicConsoleApp(Scanner scanner){
        this.setScanner(scanner);
    }

    public String getInputText(){
        System.out.println(ConsoleStrings.TYPE_TEXT);
        return this.scanner.nextLine();
    }

    public String getInputTextFromFile(){
        System.out.println(ConsoleStrings.TYPE_FILE);
        String path = this.scanner.nextLine();
        return FileManipulator.readLineByLine(path);
    }

    public void printCypherResults(String output){
        System.out.println(ConsoleStrings.CYPHERED_TEXT + output);
    }

    public void printDecypherResults(String output){
        System.out.println(ConsoleStrings.CYPHERED_TEXT + output);
    }

    public void printResultsFile(String outputFile, String output){
        FileManipulator.writeStringToFile(output, outputFile);
        System.out.println(ConsoleStrings.PRINT_FILE + outputFile);
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

}
