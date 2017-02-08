package com.project;

import com.project.drinks.*;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

/**
 * BaristaMatic class represents the simulator of an automatic coffee dispensing machine.
 * <p>
 * <b>Notes:</b>
 * The program is flexible enough to allow new drinks to be added to the menu without requiring extensive code changes.<p>
 * To add a new drinks:
 * <ul>
 * <li>1. Create a new Drink class that inherit from base class </li>
 * <li>2. If the new drink requires new ingredinet, add the ingredient, its name and cost in the Enum 'Ingredient'</li>
 * <li>3. Add the name and ingredient amounts in the constructor of the new drink class</li>
 * <li>4. Add the drink to the drinkMenu Arraylist of the Barista-matic class</li>
 * </ul>
 *
 * @author ummehunn
 */

public class BaristaMatic {

    /**
     * BaristaMatic class contains an inventory of drink ingredients, for this project, the initial size for each of the ingredients is 10 Units.
     */
    private Inventory inventory = new Inventory(10);

    /**
     * Menu contains fixed set of possible drinks. New derived drink classes can be added to this menu.
     */
    private ArrayList<Drink> drinkMenu = new ArrayList<>();

    public void createInventory(int size) {
        inventory = new Inventory(size);
        stockInventory();
    }

    /**
     * This method is used to stock all ingredients that are defined in the Ingredients Enum according to the Inventory Unit size.
     */
    public void stockInventory() {
        inventory.stockAll();
    }

    /**
     * This method is used to create a menu as per the specification.
     */
    public void createMenu() {
        addToMenu(new Coffee());
        addToMenu(new DecafCoffee());
        addToMenu(new CaffeLatte());
        addToMenu(new CaffeAmericano());
        addToMenu(new CaffeMocha());
        addToMenu(new Cappuccino());
    }

    /**
     * To add a new kind of drink to the menu, this method needs to be used.
     * Before that, a new child class of drink class needs to be instantiated.
     * The menu will be sorted and the drink numbers will be updated automatically.
     * Each time the arraylist will be sorted but since this method is not called frequently, the performance impact will not be extreme.
     * @param drink The drink object that needs to be added to the menu.
     */
    public void addToMenu(Drink drink) {
        drinkMenu.add(drink);
        Collections.sort(drinkMenu,
                (o1, o2) -> o1.getName().compareTo(o2.getName()));
    }

    /**
     * This method prints the inventory status and the menu status.
     * At program startup, and following the processing of every command, the machine inventory and the drink menu are displayed.
     */
    public void printStatus() {
        inventory.printInventory();
        printMenu();
    }

    /**
     * This method returns true if specific drink ingredients are available in the inventory.
     *
     * @param drink The drink for which ingredient availability is checked in the inventory.
     * @return true or false
     */
    public boolean getAvailability(Drink drink) {
        HashMap<Ingredient, Integer> ingredientMesureMent = drink.getIngredientMeasurements();
        for (Ingredient ingredient : ingredientMesureMent.keySet()) {
            if (inventory.getQuatity(ingredient) < ingredientMesureMent.get(ingredient)) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method prints the message that a drink is being dispensed when the ingredients are available in the inventory.
     * As drinks are dispensed, the inventory is updated using this method.
     * Ideally this method should throw exception if dispensing is not possible due to ingredient out od stock
     *
     * @param drink The drink that needs to be dispensed.
     */
    public void dispenseDrink(Drink drink) {
        HashMap<Ingredient, Integer> measureMents = drink.getIngredientMeasurements();
        for (Ingredient ingredient : measureMents.keySet()) {
            inventory.useIngredient(ingredient, measureMents.get(ingredient));
        }
        showMessageAndStatus("Dispensing: " + drink.getName());
    }

    /**
     * This method ensures that following the processing of every command, the machine inventory and the drink menu are displayed.
     *
     * @param message The message that needs to displayed
     */
    public void showMessageAndStatus(String message) {
        System.out.println(message);
        printStatus();
    }

    /**
     * This method displays the intended output and processes input lines. It continues to print machine status and read input lines until a quit command is entered.
     * Upon startup, the Barista-matic initializes the inventory and displays a list of its current inventory, followed by a menu to allow the user to select a drink.
     * As per the specification, the jar file reads from the standard input stream, one command per line. No prompts or other extraneous user messages is displayed. Blank input lines are ignored.<p>
     * <b>Valid Input</b>
     * <ul>
     * <li>'R' or 'r' - restock the inventory and redisplay the menu</li>
     * <li>'Q' or 'q' - quit the application</li>
     * <li>[1-6] - order the drink with the corresponding number in the menu, displays a single line message 'Dispensing: [drink name]' following the machine status</li>
     * </ul>
     * <b>Invalid Input</b>
     * <ul>
     * <li>For any invalid command/selection the method displays a single-line message 'Invalid selection: [characters that were entered]' following the machine status</li>
     * <li>For any selecting any out of stock drink the method displays a single-line message 'Out of stock: [drink name]' following the machine status</li>
     * </ul>
     */
    public void startMachine() {
        printStatus();
        Scanner scanner = new Scanner(System.in);
        String inputLine = "";
        int command = 'r';
        while (true) {
            inputLine = scanner.nextLine();
            if (inputLine.length() == 1 && !Character.isDigit(inputLine.charAt(0))) {
                command = inputLine.charAt(0);
                if (command == 'r' || command == 'R') {
                    stockInventory();
                    printStatus();
                } else if (command == 'q' || command == 'Q') {
                    break;
                } else {
                    showMessageAndStatus("Invalid selection: " + inputLine);
                }
            } else if (inputLine.length() > 0) {
                processInput(inputLine);
            } else {
                //ignore blank line inputs
            }
        }
        scanner.close();
    }

    /**
     * This method displays the drink menu is alphabetically sorted order.<p>
     * Format:<p>
     * Menu:<p>
     * [drink number],[drink name],[cost],[in-stock]<p>
     * Drinks are numbered sequentially, starting at 1, in the order they are displayed in the menu. The
     * in-stock indicator is either "true" or "false" depending on the inventory status.
     */
    public void printMenu() {
        System.out.println("Menu:");
        int i = 1;
        NumberFormat formatter = new DecimalFormat("#0.00");
        for (Drink drink : drinkMenu) {
            System.out.println(i++ + "," + drink.getName() + ",$" + formatter.format(drink.getCost()) + "," + getAvailability(drink));
        }
    }

    /**
     * This method is used to process each line of user input.
     *
     * @param choiceString Line from the standard input
     */
    public void processInput(String choiceString) {
        int choice = 0;
        try {
            choice = Integer.parseInt(choiceString);
            if (validChoice(choice)) {
                Drink drink = drinkMenu.get(choice - 1);
                if (getAvailability(drink))
                    dispenseDrink(drink);
                else
                    showMessageAndStatus("Out of Stock: " + drink.getName());
                return;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            showMessageAndStatus("Invalid selection: " + choiceString);
        }
    }

    /**
     * This method return true if the input has a valid selection, otherwise returns false.
     *
     * @param choice Selected drink number
     * @return True if the drink can be dispensed, false otherwise.
     */
    public boolean validChoice(int choice) {
        return choice > 0 && choice <= drinkMenu.size();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public ArrayList<Drink> getDrinkMenu() {
        return drinkMenu;
    }
}
