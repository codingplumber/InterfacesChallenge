package jason.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    // Create a simple interface (tip: name it Saveable or ISaveable)
    // That interface allows an object to be saved to some sort of storage medium. (tip: use arraylist)
    // The exact type of medium is not known to the interface (nor to the classes that implement it).
    // The interface will just specify two methods, one to return an ArrayList of values to be saved
    // and the other to populate the object's fields from an ArrayList (parameter).
    //
    // Create a few sample classes that implement your Saveable interface (we've used the idea of a game,
    // with Players and Monsters, but you can create any type of classes that you want).
    //
    // Override the toString() method for each of your classes so that they can be easily printed to enable
    // the program to be tested easier.
    //
    // In Main, write a method that takes an object that implements the interface as a parameter and
    // "saves" the values e.g. calls the method defined in the interface.

    // We haven't covered I/O yet, so your method should just print the values to the screen.
    // Also in the Main class, write a method that restores the values to a Saveable object
    // e.g. calls the method from the interface for populating fields (see above).

    // Again, we are not going to use Java file I/O; instead use the readValues() method below to
    // simulate getting values from a file – this allows you to type as many values as your class
    // requires, and returns an ArrayList.
    // There is a whole Java I/O section later in the course where you will get to use files, etc.

    public static void main(String[] args) {
        Player jason = new Player("Jason", "Sword");
        ISaveable gecko = new Monster("Ralph", "gecko", 1, 10);

        // TODO: can't do this with the interface
        // gecko.getName();

        // we can do it like this though
        // TODO: we can CAST it
        System.out.println(((Monster) gecko).getName());

        // it's difficult to determine when to declare the interface
        // TODO: if there is no strong reason to use the class type then declare it as the interface
        // it keeps your code more generic
        // you can always cast the instance to the class or interface as necessary
        // parameters and methods declared as the interface type are automatically cast from the class type for us



//        System.out.println(jason.toString());
//        System.out.println(gecko.toString());
//
//        jason.getDamage(gecko.attack());
//        gecko.getDamage(jason.attack());
//
//        jason.getDamage(gecko.attack());
//        gecko.getDamage(jason.attack());
//
//        jason.getDamage(gecko.attack());
//        gecko.getDamage(jason.attack());
//
//        jason.getDamage(gecko.attack());
//        gecko.getDamage(jason.attack());
//
//        jason.getDamage(gecko.attack());
//        gecko.getDamage(jason.attack());
//
//        jason.getDamage(gecko.attack());
//        gecko.getDamage(jason.attack());
//
//        jason.getDamage(gecko.attack());
//        gecko.getDamage(jason.attack());
//
//        jason.getDamage(gecko.attack());
//        gecko.getDamage(jason.attack());
//
//        jason.getDamage(gecko.attack());
//        gecko.getDamage(jason.attack());
//
//        jason.getDamage(gecko.attack());
//        gecko.getDamage(jason.attack());
//
//        jason.getDamage(gecko.attack());
//        gecko.getDamage(jason.attack());
//
//        jason.getDamage(gecko.attack());
//        gecko.getDamage(jason.attack());

        saveData(jason);
        getData(jason);
        System.out.println(jason);

        saveData(gecko);
        getData(gecko);
        System.out.println(gecko);

//        System.out.println(jason.toString());
//        System.out.println(gecko.toString());



    }

    public static void saveData(ISaveable dataToSave) {
        for (int i = 0; i < dataToSave.returnList().size(); i++) {
            System.out.println(dataToSave.returnList().get(i) + " saved to storage device");
        }
    }

    public static void getData(ISaveable dataToLoad) {
        ArrayList<String> dataValues = readValues();
        dataToLoad.saveList(dataValues);
    }


    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
//            if (index == 4) {
//                quit = true;
//            }
        }
        return values;
    }
}
