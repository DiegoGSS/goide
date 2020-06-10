import CypherConsoles.CesarConsoleApp;
import CypherConsoles.RotConsoleApp;
import CypherConsoles.VigenereConsoleApp;
import Utils.ConsoleStrings;

import java.util.Scanner;

public class GoideConsoleApp {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        defineCypher();
        endApp();
    }

    private static void defineCypher(){
        System.out.println(ConsoleStrings.SELECT_CYPHER);
        int cypher = 0;
        do{
            cypher = Integer.parseInt(scanner.nextLine());
            if(cypher == 1){
                CesarConsoleApp cesarConsoleApp = new CesarConsoleApp(scanner);
                cesarConsoleApp.run();
            }
            else if(cypher == 2){
                RotConsoleApp rotConsoleApp = new RotConsoleApp(scanner);
                rotConsoleApp.run();
            }
            else if (cypher == 3){
                VigenereConsoleApp vigenereConsoleApp = new VigenereConsoleApp(scanner);
                vigenereConsoleApp.run();
            }
            else{
                System.out.println(ConsoleStrings.TRY_AGAIN);
            }
        }while(cypher < 1 && cypher > 4);
    }

    private static void endApp(){
        System.out.println(ConsoleStrings.END_APPLICATION);
        scanner.nextLine();
        System.exit(0);
    }

}
