package org.example.Constants;


public final class ResponseMessages {

    private ResponseMessages() {
        throw new AssertionError("Cannot instantiate constants class");
    }

    public static class Account {
        public static final String CREATED = "Account created successfully";
        public static final String UPDATED = "Account updated successfully";
        public static final String DELETED = "Account deleted successfully";
        public static final String RETRIEVED = "Account retrieved successfully";
        public static final String NOT_FOUND = "Account not found";
        public static final String ALREADY_EXISTS = "Account already exists";
        public static final String ACTIVATED = "Account activated successfully";
        public static final String DEACTIVATED = "Account deactivated successfully";
        public static final String INVALID_CREDENTIALS = "Invalid account credentials";
        public static final String ACCOUNT_LOCKED = "Account is locked";
    }

    public static class General {
        public static final String SUCCESS = "Operation completed successfully";
        public static final String FAILED = "Operation failed";
        public static final String INVALID_REQUEST = "Invalid request";
        public static final String UNAUTHORIZED = "Unauthorized access";
        public static final String FORBIDDEN = "Access forbidden";
        public static final String VALIDATION_ERROR = "Validation error";
        public static final String INTERNAL_ERROR = "Internal server error";
    }
}