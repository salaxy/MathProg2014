package zwischenErgebnisse;
/**
*
* @author Sebastian Röder
*/
public class NewtonRaphsonMethod {

    private int radicant;
    private int index;
    private int precision;
    private double root;

    public int getRadicant() {
        return radicant;
    }

    public void setRadicant(int radicant) {
        this.radicant = radicant;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public double getRoot() {
        return root;
    }
    
    

    public NewtonRaphsonMethod(int radicant, int index, int precision) {
        this.radicant = radicant;
        this.index = index;
        this.precision = precision;
    } 

    public void approximateZeroDigit() {
        // TODO: set root

        double lastApproximation = radicant;
        double currentApproximation;
        boolean weiterMachen;

        do {
            currentApproximation = lastApproximation - f(lastApproximation) / f_prime(lastApproximation);
            weiterMachen = !hasReachedPrecision(lastApproximation, currentApproximation);
            lastApproximation = currentApproximation;
        } while (weiterMachen);
        
        root = currentApproximation;
    }

    private boolean hasReachedPrecision(double lastValue, double currentValue) {
        return Math.abs(lastValue - currentValue) < Math.pow(10, (-1) * precision);
    }

    private double f(double x) {
        return Math.pow(x, index) - radicant;
    }

    private double f_prime(double x) {
        return index * Math.pow(x, index - 1);
    }
    
    public static void main(String[] args) {
        NewtonRaphsonMethod test = new NewtonRaphsonMethod(2, 2, 4); // 2.412
        test.approximateZeroDigit();
        System.out.println(test.getRoot());
    }
}
