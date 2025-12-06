package org.example.TransactionRules;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ValidationResult {

    private final boolean valid;
    private final String errorMessage;
    private final String ruleName;

    private ValidationResult(boolean valid, String errorMessage, String ruleName) {
        this.valid = valid;
        this.errorMessage = errorMessage;
        this.ruleName = ruleName;
    }

    public static ValidationResult success(String ruleName) {
        return new ValidationResult(true, null, ruleName);
    }

    public static ValidationResult failure(String ruleName, String errorMessage) {
        return new ValidationResult(false, errorMessage, ruleName);
    }
}