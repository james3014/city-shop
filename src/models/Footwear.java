package models;

/**
 *
 * @author Jamie
 */
public class Footwear extends Product
{
    // Attributes
    private int size;

    
    // Constructors

    /**
     *
     * @param size
     * @param productName
     * @param price
     * @param stockLevel
     */
    public Footwear(int size, String productName, double price, int stockLevel) 
    {
        super(productName, price, stockLevel);
        this.size = size;
    }
    
    /**
     *
     * @param size
     * @param productId
     * @param productName
     * @param price
     * @param stockLevel
     */
    public Footwear(int size, int productId, String productName, double price, int stockLevel) 
    {
        super(productId, productName, price, stockLevel);
        this.size = size;
    }

    // Getters

    /**
     *
     * @return
     */
    public int getSize() {return size;}
    
    // Setters

    /**
     *
     * @param size
     */
    public void setSize(int size) {this.size = size;}
    
    
}
