package com.project;

/**
 * <h2>Barista-matic</h2>
 * Barista-matic solution is a command-line program written in Java. No external Java library has been used.
 * <p>
 * Tests:
 * <p>
 * Some JUnit Test Cases are added in the tests/ folder.
 * <p>
 * To test the Barista-matic.jar file with some sample input/output cases from command line, tests/test.bat file is added.
 *
 * @author ummehunn
 */
public class Main {

    public static void main(String[] args) {
        /**
         * This is the main method which makes use of a Barista-matic object.
         * This method instantiates a Barista-matic object and input output processing starts when the startMachine() method is called.
         * @param args Unused.
         * @return Nothing.
         * @exception IOException On input error.
         */

        BaristaMatic baristaMatic = new BaristaMatic();

        baristaMatic.createInventory(10);
        baristaMatic.stockInventory();
        baristaMatic.createMenu();

        baristaMatic.startMachine();
    }
}
