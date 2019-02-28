package models;

/**
 *
 * @author Jamie
 */
public class OrderLine 
{
    // Attributes
    private int orderLineId;
    private Product product;
    private int quantity;
    private double lineTotal;
    
    // Constructors

    /**
     *
     * @param orderLineId
     * @param product
     */
    public OrderLine(int orderLineId, Product product)
    {
        this.orderLineId = orderLineId;
        this.product = product;
        this.quantity = 1;
        lineTotal = product.getPrice();
    }
    
    /**
     *
     * @param orderLineId
     * @param product
     * @param quantity
     */
    public OrderLine(int orderLineId, Product product, int quantity) 
    {
        this.orderLineId = orderLineId;
        this.product = product;
        this.quantity = quantity;
        lineTotal = (double)quantity * (double)product.getPrice();
    }
    
    /**
     *
     * @param orderLineId
     * @param product
     * @param quantity
     * @param lineTotal
     */
    public OrderLine(int orderLineId, Product product, int quantity, double lineTotal) 
    {
        this.orderLineId = orderLineId;
        this.product = product;
        this.quantity = quantity;
        this.lineTotal = lineTotal;
    }

    // Getters

    /**
     *
     * @return
     */
    public int getOrderLineId() {return orderLineId;}

    /**
     *
     * @return
     */
    public Product getProduct() {return product;}

    /**
     *
     * @return
     */
    public int getQuantity() {return quantity;}

    /**
     *
     * @return
     */
    public double getLineTotal() {return lineTotal;}
    
    // Setters

    /**
     *
     * @param orderLineId
     */
    public void setOrderLineId(int orderLineId) {this.orderLineId = orderLineId;}

    /**
     *
     * @param product
     */
    public void setProduct(Product product) {this.product = product;}

    /**
     *
     * @param quantity
     */
    public void setQuantity(int quantity) {this.quantity = quantity;}

    /**
     *
     * @param lineTotal
     */
    public void setLineTotal(double lineTotal) {this.lineTotal = lineTotal;}
    
}
