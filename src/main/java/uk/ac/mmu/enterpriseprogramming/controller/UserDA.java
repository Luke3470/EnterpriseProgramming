package uk.ac.mmu.enterpriseprogramming.controller;

import uk.ac.mmu.enterpriseprogramming.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserDA {

    public List<UserModel> getAllUsers() {

        List<UserModel> list = List.of(
                new UserModel("Alice", "alice@example.com", 25, "Canada"),
                new UserModel("Bob", "bob@example.com", 30, "USA")
        );

        return list;
    }
}
