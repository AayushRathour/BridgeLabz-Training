package com.annotations.restrictmethodaccess;

@RoleAllowed("ADMIN")
public class AdminService {

    void deleteUser() {
        System.out.println("User deleted successfully!");
    }
}
