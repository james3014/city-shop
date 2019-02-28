package models;


import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author Jamie
 */
public class Order 
{
    // Attributes
    private int orderId;
    private Date orderDate;
    private double orderTotal;
    private String status;
    private HashMap<Integer, OrderLine> orderLines;

    
    // Default Constructor

    /**
     *
     */
    public Order() 
    {
        orderId = 0;
        orderDate = new Date();
        orderTotal = 0.0;
        status = "In Progress";
        orderLines = new HashMap();
    }

    
    
    // Custom Constructor

    /**
     *
     * @param orderId
     * @param orderDate
     * @param orderTotal
     * @param status
     */
    public Order(int orderId, Date orderDate, double orderTotal, String status) 
    {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderTotal = orderTotal;
        this.status = status;
        orderLines = new HashMap();
    }

    
    // Getters

    /**
     *
     * @return
     */
    public int getOrderId() {return orderId;}

    /**
     *
     * @return
     */
    public Date getOrderDate() {return orderDate;}

    /**
     *
     * @return
     */
    public double getOrderTotal() {return orderTotal;}

    /**
     *
     * @return
     */
    public String getStatus() {return status;}

    /**
     *
     * @return
     */
    public HashMap<Integer, OrderLine> getOrderLines() {return orderLines;}
    
    
    // Setters

    /**
     *
     * @param orderId
     */
    public void setOrderId(int orderId) {this.orderId = orderId;}

    /**
     *
     * @param orderDate
     */
    public void setOrderDate(Date orderDate) {this.orderDate = orderDate;}

    /**
     *
     * @param orderTotal
     */
    public void setOrderTotal(double orderTotal) {this.orderTotal = orderTotal;}

    /**
     *
     * @param status
     */
    public void setStatus(String status) {this.status = status;}

    /**
     *
     * @param orderLines
     */
    public void setOrderLines(HashMap<Integer, OrderLine> orderLines) {this.orderLines = orderLines;}
    
    
    // 

    /**
     *
     * @return
     */
    public int generateUniqueOrderLineId()
    {
        int orderLineId = 0;
        
        for(Map.Entry<Integer, OrderLine> olEntry : orderLines.entrySet())
        {
            if(orderLines.containsKey(orderLineId))
            {
                orderLineId++;
            }
        }
        
        return orderLineId;
    }
    
    /**
     *
     * @param orderLine
     */
    public void addOrderLine(OrderLine orderLine)
    {
        
        DBManager db = new DBManager();
        int orderLineId = db.addOrderLine(orderLine, orderId);
        
        orderLines.put(orderLineId, orderLine);
        orderLines.get(orderLineId).setOrderLineId(orderLineId);
        
        calculateOrderTotal();
    }
    
    /**
     *
     */
    public void calculateOrderTotal()
    {
        orderTotal = 0;
        for(Map.Entry<Integer, OrderLine> olEntry : orderLines.entrySet())
        {
            OrderLine ol = olEntry.getValue();
            orderTotal = orderTotal + ol.getLineTotal();
        }
        
        DBManager db = new DBManager();
        db.updateOrderTotal(orderId, orderTotal);    
    }
    
    /**
     *
     * @param productId
     */
    public void removeOrderLine(int productId)
    {
        Iterator<Map.Entry<Integer, OrderLine>> iter = orderLines.entrySet().iterator();
        
        while(iter.hasNext())
        {
            Map.Entry<Integer, OrderLine> olEntry = iter.next();
            
            OrderLine actualOrderLine = olEntry.getValue();
            
            if(actualOrderLine.getProduct().getProductId() == productId)
            {
                iter.remove();
                orderTotal = orderTotal - actualOrderLine.getLineTotal();
                
                DBManager db = new DBManager();
                db.deleteOrderLine(actualOrderLine.getOrderLineId());
                db.updateOrderTotal(orderId, orderTotal);
            }
        }
    }
    
    /**
     *
     * @param order
     */
    public void completeOrder(Order order)
    {
        DBManager db = new DBManager();
        
        db.completeOrder(order.orderId);
        
        for(Map.Entry<Integer, OrderLine> olEntry : orderLines.entrySet())
        {
            OrderLine actualOrderLine = olEntry.getValue();
            Product product = actualOrderLine.getProduct();
            
            db.updateProductAvailability(product.getProductId(), actualOrderLine.getQuantity());
        }
    }
    
    /**
     *
     * @param productId
     * @return
     */
    public Optional<OrderLine> findProductInTheBasket(int productId)
    {
        Optional<OrderLine> foundOrderLineWithProduct = Optional.empty();
        
        for(Map.Entry<Integer, OrderLine> olEntry : orderLines.entrySet())
        {
            OrderLine actualOrderLine = olEntry.getValue();
            Product product = actualOrderLine.getProduct();
            
            if(product.getProductId() == productId)
            {
                foundOrderLineWithProduct = Optional.of(actualOrderLine);
            }
        }
        
        return foundOrderLineWithProduct;
    }
    
    
}
