package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User user = null;
        for (User find : users) {
            if (login.equals(find.getUsername())) {
                user = find;
                break;
            }
        }
        if (user == null) {
            throw new UserNotFoundException("User has not found");
        }
        return user;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("User is not valid");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ui) {
            ui.printStackTrace();
        } catch (UserNotFoundException un) {
            un.printStackTrace();
        }
    }
}
