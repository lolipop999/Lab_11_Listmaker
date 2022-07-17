import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // creating array list
    static ArrayList<String> list = new ArrayList<>();

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        final String menu = "A - Add  D - Delete  P - Print  Q - Quit";
        boolean done = false;
        String cmd = "";

        do {
            // display the list
            displayList();

            // display the menu and get a menu choice
            cmd = SafeInput.getRegExString(in, menu, "[AaDdPpQq]");
            cmd = cmd.toUpperCase();

            // execute the choice
            switch(cmd) {
                case "A":
                    addItems();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "P":
                    displayList();
                    break;
                case "Q":
                    done = quitProgram();
                    break;
            }

        }
        while (!done);
    }

    private static boolean quitProgram() {
        boolean quit = SafeInput.getYNConfirm(in, "Do you want to quit the program");

        return quit;
    }

    private static void deleteItem() {
        // asks user which index they want to remove
        int index = SafeInput.getRangedInt(in, "Which index do you want to remove", 1, list.size());

        // subtracts 1 from index
        index -= 1;

        list.remove(index);
    }

    private static void addItems() {
        // asks user what they want to add to the list
        String newItem = SafeInput.getNonZeroLenString(in, "What do you want to add to your list");

        // adds item to the list
        list.add(newItem);
    }

    private static void displayList() {
        System.out.println("==================================================");
        if (list.size() !=0) {
            for (int x = 0; x < list.size(); x++) {
                System.out.printf("%-3d%-15s", x+1, list.get(x));
            }
        }
        else {
            System.out.print("===                 Empty List                 ===");
        }
        System.out.println("\n==================================================");
    }


}