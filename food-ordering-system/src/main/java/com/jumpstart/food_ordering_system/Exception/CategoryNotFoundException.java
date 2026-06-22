package com.jumpstart.food_ordering_system.Exception;

/**
 * Custom runtime exception thrown when a requested Category cannot be found.
 * Extending RuntimeException allows it to be thrown without mandatory try-catch blocks.
 */
public class CategoryNotFoundException extends RuntimeException {

    // A unique identifier used during serialization to verify sender and receiver compatibility.
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new exception with a specific, detailed descriptive message.
     * @param message The error message explaining why the exception occurred.
     */
    public CategoryNotFoundException(String message) {
        // Passes the custom message to the parent RuntimeException class.
        super(message);
    }
}
