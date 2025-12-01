package org.example.Constants;


public final class ResponseMessages {

    private ResponseMessages() {
        throw new AssertionError("Cannot instantiate constants class");
    }

    public static class Account {
        public static final String CREATED = "Account created successfully";
        public static final String UPDATED = "Account updated successfully";
        public static final String RETRIEVED = "Account retrieved successfully";
        public static final String NOT_FOUND = "Account not found";
        public static final String ALREADY_EXISTS = "Account already exists";
        public static final String ACTIVATED = "Account activated successfully";
        public static final String DEACTIVATED = "Account deactivated successfully";
        public static final String INVALID_CREDENTIALS = "Invalid account credentials";
        public static final String ACCOUNT_LOCKED = "Account is locked";
    }
}
