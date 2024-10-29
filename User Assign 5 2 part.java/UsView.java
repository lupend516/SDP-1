package Part2;

import java.util.List;
import java.util.Scanner;

public class UserView {
    private final UserViewModel viewModel;
    private final Scanner scanner;

    public UserView(UserViewModel viewModel) {
        this.viewModel = viewModel;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("1. Add user");
            System.out.println("2. Display users");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    addUser();
                    break;
                case 2:
                    displayUsers();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addUser() {
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();
        viewModel.addUser(name);
        System.out.println("User added!");
    }

    private void displayUsers() {
        System.out.println("User List:");
        List<String> users = viewModel.getUserNames();
        for (String user : users) {
            System.out.println("- " + user);
        }
    }
}
