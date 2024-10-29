package Part2;

import Part2.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserViewModel {
    private List<UserModel> users;

    public UserViewModel() {
        users = new ArrayList<>();
    }

    public void addUser(String name) {
        users.add(new UserModel(name));
    }

    public List<String> getUserNames() {
        List<String> userNames = new ArrayList<>();
        for (UserModel user : users) {
            userNames.add(user.getName());
        }
        return userNames;
    }
}
