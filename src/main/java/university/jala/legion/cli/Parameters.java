package university.jala.legion.cli;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Handles command-line parameters for the March of the Legion simulator.
 */
public class Parameters {
    private final Map<String, String> parameters;

    // Default values
    private static final String DEFAULT_BATTLEFIELD_SIZE = "10";
    private static final String DEFAULT_ORIENTATION = "n";
    private static final String DEFAULT_TYPE = "c";

    /**
     * Creates a Parameters instance from command-line arguments.
     * @param args Command-line arguments in format key=value
     */
    public Parameters(String[] args) {
        parameters = new HashMap<>();
        parseArgs(args);
        validateRequiredParameters();
    }

    private void parseArgs(String[] args) {
        Arrays.stream(args)
                .filter(arg -> arg.contains("="))
                .forEach(arg -> {
                    String[] parts = arg.split("=", 2);
                    parameters.put(parts[0].toLowerCase(), parts[1].toLowerCase());
                });

        // Set defaults if not provided
        parameters.putIfAbsent("f", DEFAULT_BATTLEFIELD_SIZE);
        parameters.putIfAbsent("o", DEFAULT_ORIENTATION);
        parameters.putIfAbsent("t", DEFAULT_TYPE);
    }

    private void validateRequiredParameters() {
        if (!parameters.containsKey("a")) {
            throw new IllegalArgumentException("Sorting algorithm parameter 'a' is required");
        }
        if (!parameters.containsKey("u")) {
            throw new IllegalArgumentException("Unit distribution parameter 'u' is required");
        }
        validateAlgorithm();
        validateOrientation();
        validateType();
        validateBattlefieldSize();
        validateUnitDistribution();
    }

    private void validateAlgorithm() {
        String algorithm = parameters.get("a");
        // Updated validation regex to accept only the four specified algorithms
        if (!algorithm.matches("[criq]")) {
            throw new IllegalArgumentException("Invalid sorting algorithm code. Valid codes are: c (Counting), r (Radix), i (Insertion), q (Quick)");
        }
    }

    private void validateOrientation() {
        String orientation = parameters.get("o");
        if (!orientation.matches("[nsew]")) {
            throw new IllegalArgumentException("Invalid orientation code: " + orientation);
        }
    }

    private void validateType() {
        String type = parameters.get("t");
        if (!type.matches("[cn]")) {
            throw new IllegalArgumentException("Invalid display type code: " + type);
        }
    }

    private void validateBattlefieldSize() {
        try {
            int size = Integer.parseInt(parameters.get("f"));
            if (size < 5 || size > 1000) {
                throw new IllegalArgumentException("Battlefield size must be between 5 and 1000");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid battlefield size format");
        }
    }

    private void validateUnitDistribution() {
        String distribution = parameters.get("u");
        String[] units = distribution.split(",");
        if (units.length != 5) {
            throw new IllegalArgumentException("Unit distribution must specify 5 unit types");
        }
        int totalUnits = 0;
        try {
            for (String unit : units) {
                int count = Integer.parseInt(unit);
                if (count < 0) {
                    throw new IllegalArgumentException("Unit counts cannot be negative");
                }
                totalUnits += count;
            }
            int battlefieldSize = Integer.parseInt(parameters.get("f"));
            if (totalUnits > battlefieldSize * battlefieldSize) {
                throw new IllegalArgumentException("Total units exceed battlefield capacity");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid unit count format");
        }
    }

    public String getAlgorithm() {
        return parameters.get("a");
    }

    public String getOrientation() {
        return parameters.get("o");
    }

    public String getType() {
        return parameters.get("t");
    }

    public int getBattlefieldSize() {
        return Integer.parseInt(parameters.get("f"));
    }

    public int[] getUnitDistribution() {
        return Arrays.stream(parameters.get("u").split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
