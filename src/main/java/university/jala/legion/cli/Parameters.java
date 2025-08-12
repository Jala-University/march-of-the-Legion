// Handles command-line parameters for the March of the Legion simulator.

package university.jala.legion.cli;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Parameters {
    private final Map<String, String> parameters;

    public Parameters(String[] args) {
        parameters = new HashMap<>();
        parseArgs(args);
        validateParameters();
    }

    private void parseArgs(String[] args) {
        Arrays.stream(args)
                .filter(arg -> arg.contains("="))
                .forEach(arg -> {
                    String[] parts = arg.split("=", 2);
                    parameters.put(parts[0].toLowerCase(), parts[1].toLowerCase());
                });
    }

    private void validateParameters() {
        if (parameters.containsKey("a") && !parameters.get("a").equals("i")) {
            throw new IllegalArgumentException("Only 'a=i' (Insertion Sort) is supported in this version.");
        }
        if (!parameters.containsKey("u")) {
            throw new IllegalArgumentException("Unit distribution parameter 'u' is required");
        }
        if (!parameters.containsKey("t")) {
            throw new IllegalArgumentException("Type parameter 't' is required");
        }

        validateType();
        validateUnitDistribution();
    }

    private void validateType() {
        String type = parameters.get("t");
        if (!type.matches("[cn]")) {
            throw new IllegalArgumentException("Invalid display type code: " + type);
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
            if (totalUnits > 36) { // 6x6 battlefield size
                throw new IllegalArgumentException("Total units exceed battlefield capacity (36)");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid unit count format");
        }
    }

    public String getType() {
        return parameters.get("t");
    }

    public int[] getUnitDistribution() {
        return Arrays.stream(parameters.get("u").split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
