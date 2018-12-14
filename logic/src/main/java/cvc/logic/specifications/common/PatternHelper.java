package cvc.logic.specifications.common;

public final class PatternHelper {

    private PatternHelper() {}

    public static String getStartsWithPattern(String startsWith) {
        if (startsWith == null || startsWith.isEmpty()) {
            return "%";
        }

        return startsWith.toLowerCase() + "%";
    }

    public static String getContainsPattern(String startsWith) {
        if (startsWith == null || startsWith.isEmpty()) {
            return "%";
        }

        return "%" + startsWith.toLowerCase() + "%";
    }
}
