package com.microclimate.platform.si729pc2u201717523.microclimate.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

/**
 * Represents an email address as a value object.
 */
@Embeddable
public class EmailAddress {

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    @Size(max = 50, message = "Email must not exceed 50 characters")
    /// <summary>
    /// The email address.
    /// </summary>
    private String email;

    /// <summary>
    /// Initializes a new instance of the EmailAddress class.
    /// </summary>
    public EmailAddress() {}

    /// <summary>
    /// Initializes a new instance of the EmailAddress class with the specified email.
    /// </summary>
    /// <param name="email">The email address to set.</param>
    public EmailAddress(String email) {
        setEmail(email);
    }

    /// <summary>
    /// Gets the email address.
    /// </summary>
    /// <returns>The email address.</returns>
    public String getEmail() {
        return email;
    }

    /// <summary>
    /// Sets the email address.
    /// </summary>
    /// <param name="email">The email address to set.</param>
    /// <exception cref="IllegalArgumentException">Thrown if the email is blank or invalid.</exception>
    public void setEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be blank");
        }
        this.email = email;
    }

    @Override
    public String toString() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmailAddress)) return false;
        EmailAddress that = (EmailAddress) o;
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}