package uk.ac.mmu.enterpriseprogramming.service;

import uk.ac.mmu.enterpriseprogramming.controller.UserDA;
import uk.ac.mmu.enterpriseprogramming.model.UserModel;

import java.util.List;

public class UserService {
    private UserDA dao = new UserDA();

    public List<UserModel> getAllUsers() {
        return dao.getAllUsers();
    }
}
