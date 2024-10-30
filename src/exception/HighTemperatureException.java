package exception;

public class HighTemperatureException extends Exception {
    private Integer testNumber;
    private String neighborhood;

    public HighTemperatureException(Integer testNumber, String neighborhood) {
        super("La temperatura excede los 38 grados\n Numero de test: "+testNumber+"\nBarrio: "+neighborhood);
        this.testNumber = testNumber;
        this.neighborhood = neighborhood;
    }

    public Integer getTestNumber() {
        return testNumber;
    }

    public void setTestNumber(Integer testNumber) {
        this.testNumber = testNumber;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }


}
