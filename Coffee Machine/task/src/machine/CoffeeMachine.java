package machine;
import java.util.Scanner;
 enum CoffeeMachineState {
    PRINTINGTOTALS(1),
    TAKINGMONEY(2),
    FILLINGMACHINE(3),
    CHOOSINGCOFFEE(4),
    CHOOSINGACTION(5);

    int stateOfMachine;

     CoffeeMachineState(int stateOfMachine) {
        this.stateOfMachine = stateOfMachine;
    }

    public int getState() {
        return stateOfMachine;
    }
}

public class CoffeeMachine {
     static int  water = 400;
     static int milk = 540;
     static int coffeeBeans = 120;
     static int disposableCups = 9;
     static int money = 550;
    public static String[][] arrText = {{"ml", "of water"}, {"ml", "of milk"}, {"grams", "of coffee beans"}, {"disposable", "cups of coffee"}};
    public static int[] arrIngred = {water, milk, coffeeBeans, disposableCups, money};

    public static int state;
    public static boolean done = true;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (done) {
            state = CoffeeMachineState.CHOOSINGACTION.getState();
            System.out.println("\n\nWrite action (buy, fill, take, remaining, exit):");
            String choice = scanner.next();
            switch (choice) {
                case "buy":
                    makeCoffee();
                    break;
                case "fill":
                    fillMachine();
                    break;
                case "take":
                    takeMoney();
                    break;
                case "remaining":
                    printCoffeeMachineState();
                    break;
                case "exit":
                    done = false;
                    break;
            }
        }
    }

    public static void printCoffeeMachineState() {
        //Setting the Machine State
        state = CoffeeMachineState.PRINTINGTOTALS.getState();

        System.out.format("\nThe coffee machine has: \n%s ml of water\n%s ml of milk\n%s g of coffee beans\n%s disposable cups\n$%s of money", arrIngred[0], arrIngred[1], arrIngred[2], arrIngred[3], arrIngred[4]);
    }

    public static void fillMachine() {
        //Setting the Machine State
        state = CoffeeMachineState.FILLINGMACHINE.getState();

        for (int i = 0; i < arrText.length; i++) {
            System.out.format("\nWrite how many %s %s you want to add:", arrText[i][0], arrText[i][1]);
            arrIngred[i] += scanner.nextInt();
        }
    }

    public static void takeMoney() {
        //Setting the Machine State
        state = CoffeeMachineState.TAKINGMONEY.getState();

        System.out.format("\nI gave you $%s", arrIngred[4]);
        arrIngred[4] = 0;
        System.out.println();
    }

    public static void makeCoffee() {
        //Setting the Machine State
        state = CoffeeMachineState.CHOOSINGCOFFEE.getState();

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String typeOfCoffeeNeed = scanner.next();
        switch (typeOfCoffeeNeed) {
            case "1": //espresso
                if (arrIngred[0] >= 250 && arrIngred[2] >= 16 && arrIngred[3] >= 1) {
                    arrIngred[0] -= 250;
                    arrIngred[2] -= 16;
                    arrIngred[3] -= 1;
                    arrIngred[4] += 4;
                    System.out.println("\nI have enough resources, making you a coffee!");
                } else {
                    String notEnoughOf = arrIngred[0] < 250 ? "water" : arrIngred[2] < 16 ? "coffee beans" : "disposable cups";
                    System.out.format("Sorry, not enough %s!", notEnoughOf);
                }
                break;
            case "2": //latte
                if (arrIngred[0] >= 350 && arrIngred[1] >= 75 && arrIngred[2] >= 20 && arrIngred[3] >= 1) {
                    arrIngred[0] -= 350;
                    arrIngred[1] -= 75;
                    arrIngred[2] -= 20;
                    arrIngred[3] -= 1;
                    arrIngred[4] += 7;
                    System.out.println("\nI have enough resources, making you a coffee!");
                } else {
                    String notEnoughOf = arrIngred[0] < 350 ? "water" : arrIngred[1] < 75 ? "milk" : arrIngred[3] < 20 ? "coffee beans" : "disposable cups";
                    System.out.format("Sorry, not enough %s!", notEnoughOf);
                }
                break;
            case "3": //cappuccino
                if (arrIngred[0] >= 200 && arrIngred[1] >= 100 && arrIngred[2] >= 12 && arrIngred[3] >= 1) {
                    arrIngred[0] -= 200;
                    arrIngred[1] -= 100;
                    arrIngred[2] -= 12;
                    arrIngred[3] -= 1;
                    arrIngred[4] += 6;
                    System.out.println("\nI have enough resources, making you a coffee!");
                } else {
                    String notEnoughOf = arrIngred[0] < 200 ? "water" : arrIngred[1] < 100 ? "milk" : arrIngred[3] < 12 ? "coffee beans" : "disposable cups";
                    System.out.format("Sorry, not enough %s!", notEnoughOf);
                }
                break;
            default:
                break;
        }
    }
}