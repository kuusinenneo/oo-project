import java.util.Scanner;

public class CLI {

    private PersonController controller;
    private Scanner scanner;

    public CLI(PersonController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("welcome to person manager");
        int choice = 0;
        while (choice != 5) {
            System.out.println("\n1. add person");
            System.out.println("2. list all");
            System.out.println("3. update person");
            System.out.println("4. delete person");
            System.out.println("5. exit");
            System.out.print("choose: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("please enter a  number");
                continue;
            }

            if (choice == 1) {
                addPerson();
            } else if (choice == 2) {
                listAll();
            } else if (choice == 3) {
                updatePerson();
            } else if (choice == 4) {
                deletePerson();
            } else if (choice == 5) {
                System.out.println("bye");
            } else {
                System.out.println("invalid choice");
            }
        }
    }

    private void addPerson() {
        System.out.print("first name: ");
        String first = scanner.nextLine();
        System.out.print("last name: ");
        String last = scanner.nextLine();
        System.out.print("age: ");
        int age = 0;
        try {
            age = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("invalid age");
            return;
        }
        controller.addPerson(first, last, age);
        System.out.println("person added");
    }

    private void listAll() {
        MyList<Person> persons = controller.getAllPersons();
        if (persons.isEmpty()) {
            System.out.println("no persons found");
            return;
        }
        for (int i = 0; i < persons.size(); i++) {
            System.out.println(persons.get(i));
        }
    }

    private void updatePerson() {
        System.out.print("enter id: ");
        int id = 0;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("invalid id");
            return;
        }
        Person p = controller.getPersonById(id);
        if (p == null) {
            System.out.println("person not found");
            return;
        }
        System.out.println("current: " + p);
        System.out.print("new first name: ");
        String first = scanner.nextLine();
        System.out.print("new last name: ");
        String last = scanner.nextLine();
        System.out.print("new age: ");
        int age = 0;
        try {
            age = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("invalid age");
            return;
        }
        controller.updatePerson(id, first, last, age);
        System.out.println("updated");
    }

    private void deletePerson() {
        System.out.print("enter id: ");
        int id = 0;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("invalid id");
            return;
        }
        Person p = controller.getPersonById(id);
        if (p == null) {
            System.out.println("person not found");
            return;
        }
        System.out.println("deleting: " + p);
        System.out.print("are you sure? (yes/no): ");
        String answer = scanner.nextLine();
        if (answer.equals("yes")) {
            controller.deletePerson(id);
            System.out.println("deleted");
        } else {
            System.out.println("cancelled");
        }
    }
}