package university.jala.legion.cli;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parameters class is responsible for parsing and validating the command-line
 * arguments provided to the application.
 */
public class Parameters {
    private String algorithm;
    private String type;
    private String orientation;
    private int[] unitDistribution;
    private int battlefieldSize;

    private static final String ALGORITHM_PARAM = "a";
    private static final String TYPE_PARAM = "t";
    private static final String ORIENTATION_PARAM = "o";
    private static final String UNITS_PARAM = "u";
    private static final String BATTLEFIELD_PARAM = "f";

    private static final int DEFAULT_BATTLEFIELD_SIZE = 6;
    private static final int MIN_SIZE = 5;
    private static final int MAX_SIZE = 1000;
    private static final int MAX_UNITS = 1000 * 1000; // N*N for max size

    /**
     * Constructor that parses and validates command line arguments.
     *
     * @param args The array of command-line arguments.
     */
    public Parameters(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("No parameters provided.");
        }

        for (String arg : args) {
            String[] parts = arg.split("=", 2);
            if (parts.length != 2) {
                throw new IllegalArgumentException("Invalid parameter format: " + arg);
            }
            String paramName = parts[0].toLowerCase();
            String paramValue = parts[1];

            switch (paramName) {
                case ALGORITHM_PARAM:
                    this.algorithm = paramValue.toLowerCase();
                    break;
                case TYPE_PARAM:
                    this.type = paramValue.toLowerCase();
                    break;
                case ORIENTATION_PARAM:
                    this.orientation = paramValue.toLowerCase();
                    break;
                case UNITS_PARAM:
                    this.unitDistribution = parseUnitDistribution(paramValue);
                    break;
                case BATTLEFIELD_PARAM:
                    this.battlefieldSize = parseBattlefieldSize(paramValue);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown parameter: " + paramName);
            }
        }
        validateParameters();
    }

    /**
     * Parses the unit distribution string into an integer array.
     *
     * @param value The comma-separated string of unit counts.
     * @return An array of integers.
     */
    private int[] parseUnitDistribution(String value) {
        try {
            return Arrays.stream(value.split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid format for unit distribution. Must be comma-separated numbers.");
        }
    }

    /**
     * Parses the battlefield size string into an integer.
     *
     * @param value The string representing the battlefield size.
     * @return An integer representing the battlefield size.
     */
    private int parseBattlefieldSize(String value) {
        try {
            int size = Integer.parseInt(value);
            if (size < MIN_SIZE || size > MAX_SIZE) {
                throw new IllegalArgumentException("Battlefield size must be between " + MIN_SIZE + " and " + MAX_SIZE + ".");
            }
            return size;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid format for battlefield size. Must be an integer.");
        }
    }

    /**
     * Validates that all required parameters are present and have valid values.
     */
    private void validateParameters() {
        if (algorithm == null || !isValidAlgorithm(algorithm)) {
            throw new IllegalArgumentException("Algorithm parameter 'a' is required and must be 'i', 'q', 'c', or 'r'.");
        }
        if (type == null || (!type.equals("n") && !type.equals("c"))) {
            throw new IllegalArgumentException("Type parameter 't' is required and must be 'n' or 'c'.");
        }
        if (orientation == null || (!orientation.equals("n") && !orientation.equals("s") && !orientation.equals("e") && !orientation.equals("w"))) {
            throw new IllegalArgumentException("Orientation parameter 'o' is required and must be 'n', 's', 'e', or 'w'.");
        }
        if (unitDistribution == null || unitDistribution.length != 5) {
            throw new IllegalArgumentException("Unit distribution parameter 'u' is required and must have 5 comma-separated values.");
        }
        for (int count : unitDistribution) {
            if (count < 0) {
                throw new IllegalArgumentException("Unit counts in distribution 'u' cannot be negative.");
            }
        }

        // Use default size if not provided
        if (this.battlefieldSize == 0) {
            this.battlefieldSize = DEFAULT_BATTLEFIELD_SIZE;
        }

        if (Arrays.stream(unitDistribution).sum() > this.battlefieldSize * this.battlefieldSize) {
            throw new IllegalArgumentException("Total units exceed battlefield size (" + this.battlefieldSize + "x" + this.battlefieldSize + ").");
        }
    }

    /**
     * Checks if the given algorithm code is valid.
     * @param code The algorithm code.
     * @return True if valid, false otherwise.
     */
    private boolean isValidAlgorithm(String code) {
        return code.equals("i") || code.equals("q") || code.equals("c") || code.equals("r");
    }

    // Getters for all parameters
    public String getAlgorithm() {
        return algorithm;
    }

    public String getType() {
        return type;
    }

    public String getOrientation() {
        return orientation;
    }

    public int[] getUnitDistribution() {
        return unitDistribution;
    }

    public int getBattlefieldSize() {
        return battlefieldSize;
    }
}