package boatRacingSimulator.helpers;

public class Validator {
    public static boolean validateBoatModel(String model) {
        return model.length() >= 5;
    }

    public static boolean validateBoatEngineModel(String model) {
        return model.length() >= 3;
    }

    public static boolean validatePositiveParam(int param) {
        return param > 0;
    }

    public static boolean validateBoatsEffectiveness(int param) {
        return param > 0 && param < 101;
    }

    public static String generateArgumentExceptionMessage(String paramType) {
        return String.format("%s must be a positive integer.", paramType);
    }
}
