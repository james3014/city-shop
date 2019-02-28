package models;

/**
 *
 * @author Jamie
 */
public class Clothing extends Product
{
    // Attributes
    private String measurement;

    
    

    /**  Constructors
     *
     * @param measurement
     * @param productName
     * @param price
     * @param stockLevel
     */
    public Clothing(String measurement, String productName, double price, int stockLevel) 
    {
        super(productName, price, stockLevel);
        this.measurement = measurement;
    }

    /**
     *
     * @param measurement
     * @param productId
     * @param productName
     * @param price
     * @param stockLevel
     */
    public Clothing(String measurement, int productId, String productName, double price, int stockLevel) 
    {
        super(productId, productName, price, stockLevel);
        this.measurement = measurement;
    }
    
    
    

    /** Getters
     *
     * @return
     */
    public String getMeasurement() {return measurement;}
    
    

    /** Setters
     *
     * @param measurement
     */
    public void setMeasurement(String measurement) {this.measurement = measurement;}
}
