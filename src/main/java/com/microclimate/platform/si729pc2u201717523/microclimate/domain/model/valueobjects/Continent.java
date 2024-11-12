package com.microclimate.platform.si729pc2u201717523.microclimate.domain.model.valueobjects;

/**
 * Represents the continents as an enumeration.
 */
public enum Continent {
    /// <summary>
    /// Represents the continent of America.
    /// </summary>
    AMERICAN(1),

    /// <summary>
    /// Represents the continent of Europe.
    /// </summary>
    EUROPE(2),

    /// <summary>
    /// Represents the continent of Africa.
    /// </summary>
    AFRICA(3),

    /// <summary>
    /// Represents the continent of Asia.
    /// </summary>
    ASIA(4),

    /// <summary>
    /// Represents the continent of Oceania.
    /// </summary>
    OCEANIA(5);

    private final int value;

    /// <summary>
    /// Initializes a new instance of the Continent enumeration with the specified value.
    /// </summary>
    /// <param name="value">The integer value representing the continent.</param>
    Continent(int value) {
        this.value = value;
    }

    /// <summary>
    /// Gets the integer value associated with the continent.
    /// </summary>
    /// <returns>The integer value of the continent.</returns>
    public int getValue() {
        return value;
    }

    /// <summary>
    /// Returns the corresponding Continent for a given integer value.
    /// </summary>
    /// <param name="value">The integer value representing a continent.</param>
    /// <returns>The corresponding Continent.</returns>
    /// <exception cref="IllegalArgumentException">Thrown when an invalid value is provided.</exception>
    public static Continent fromValue(int value) {
        for (Continent continent : values()) {
            if (continent.getValue() == value) {
                return continent;
            }
        }
        throw new IllegalArgumentException("Invalid continent value: " + value);
    }
}
