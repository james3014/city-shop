package models;

/**
 *
 * @author Jamie
 */
public class Product 
{
    // Attributes
    private int productId;
    private String productName;
    private double price;
    private int stockLevel;

    /**
     *
     * @return
     */
    @Override
    public String toString()
    {
       String output = productName;
       return output;
    }
    
    // Default Constructor

    /**
     *
     */
    public Product() 
    {
        productId = 00000;
        productName = " ";
        price = 0.0;
        stockLevel = 0;
    }
    
    
    // Custom Constructors

    /**
     *
     * @param productName
     * @param price
     * @param stockLevel
     */
    public Product(String productName, double price, int stockLevel) 
    {
        productId = 00000;
        this.productName = productName;
        this.price = price;
        this.stockLevel = stockLevel;
    }

    /**
     *
     * @param productId
     * @param productName
     * @param price
     * @param stockLevel
     */
    public Product(int productId, String productName, double price, int stockLevel) 
    {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.stockLevel = stockLevel;
    }
    
    
    // Getters

    /**
     *
     * @return
     */
    public int getProductId() {return productId;}

    /**
     *
     * @return
     */
    public String getProductName() {return productName;}

    /**
     *
     * @return
     */
    public double getPrice() {return price;}

    /**
     *
     * @return
     */
    public int getStockLevel() {return stockLevel;}
    
    
    // Setters

    /**
     *
     * @param productId
     */
    public void setProductId(int productId) {this.productId = productId;}

    /**
     *
     * @param productName
     */
    public void setProductName(String productName) {this.productName = productName;}

    /**
     *
     * @param price
     */
    public void setPrice(double price) {this.price = price;}

    /**
     *
     * @param stockLevel
     */
    public void setStockLevel(int stockLevel) {this.stockLevel = stockLevel;}
}
