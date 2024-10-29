package Part2;

import Part2.UserView;
import Part2.UserViewModel;

public class UserApp {
    public static void main(String[] args) {
        UserViewModel viewModel = new UserViewModel();
        UserView view = new UserView(viewModel);
        view.displayMenu();
    }
}
