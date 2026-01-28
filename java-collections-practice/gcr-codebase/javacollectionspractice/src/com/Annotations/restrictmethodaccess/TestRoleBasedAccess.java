package com.annotations.restrictmethodaccess;

public class TestRoleBasedAccess {

    public static void main(String[] args) throws Exception {
        AdminService service = new AdminService();

        Class<?> class1 = service.getClass();

        if (class1.isAnnotationPresent(RoleAllowed.class)) {
            RoleAllowed roleAllowed = class1.getAnnotation(RoleAllowed.class);

            if (!SecurityContext.currentRole.equals(roleAllowed.value())) {
                System.out.println("Access Denied!");
                return;
            }
        }

        service.deleteUser();
    }
}
