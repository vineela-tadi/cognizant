public class Forecast {

    // Recursive Method
    static double भविष्यValue(double presentValue, double rate, int years) {

        // Base Case
        if (years == 0) {
            return presentValue;
        }

        // Recursive Case
        return भविष्यValue(presentValue, rate, years - 1) * (1 + rate);
    }

    public static void main(String[] args) {

        double presentValue = 1000;   // initial amount
        double rate = 0.10;           // 10% growth
        int years = 3;

        double result = भविष्यValue(presentValue, rate, years);

        System.out.println("Future Value after " + years + " years: " + result);
    }
}