package university.jala.legion.util;

import university.jala.legion.exception.InvalidParameterException;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility class to parse and validate command-line arguments.
 * Adheres to SRP by handling only the logic for argument processing.
 */
public class CommandLineParser {

    private static final Pattern PARAM_PATTERN = Pattern.compile("(\\w)=(\\S+)");

    /**
     * Parses the command-line arguments and returns a map of parameters.
     *
     * @param args The array of command-line arguments.
     * @return A map of parameter keys to their values.
     * @throws InvalidParameterException if any argument is invalid or missing.
     */
    public static Map<String, String> parse(String[] args) throws InvalidParameterException {
        if (args == null || args.length == 0) {
            throw new InvalidParameterException("Missing required parameters: a, t, u.");
        }

        Map<String, String> params = new HashMap<>();
        for (String arg : args) {
            Matcher matcher = PARAM_PATTERN.matcher(arg);
            if (matcher.matches()) {
                params.put(matcher.group(1), matcher.group(2));
            } else {
                // This handles cases like invalid parameter format, e.g., "r=12345".
                throw new InvalidParameterException("Invalid parameter format: " + arg);
            }
        }

        validateParameters(params);
        return params;
    }

    /**
     * Validates that all required parameters are present and have valid values for the first deliverable.
     *
     * @param params The map of parsed parameters.
     * @throws InvalidParameterException if a parameter is missing or invalid.
     */
    private static void validateParameters(Map<String, String> params) throws InvalidParameterException {
        // Required parameters for the evaluation.
        String algorithm = params.get("a");
        String type = params.get("t");
        String units = params.get("u");

        if (algorithm == null || type == null || units == null) {
            throw new InvalidParameterException("Missing required parameters: a, t, u.");
        }

        // Validate algorithm: 'i' for Insertion Sort as per the deliverable.
        if (!"i".equals(algorithm)) {
            throw new InvalidParameterException("Invalid algorithm. Use 'a=i' for Insertion Sort.");
        }

        // Validate type: 'c' for characters or 'n' for numbers.
        if (!"c".equals(type) && !"n".equals(type)) {
            throw new InvalidParameterException("Invalid type. Use 't=c' for characters or 't=n' for numbers.");
        }
    }
}