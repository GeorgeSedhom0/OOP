package Actions;

import java.util.Scanner;

import Defines.Cart;

// interface for user actions and admin actions which should have 
// doAction() and setAction() methods

public interface IAction {
    void setAction(int action);

    default void doAction(Scanner scanner) {

    }

    default void doAction(Scanner scanner, Cart cart) {

    }
}
