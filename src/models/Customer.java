package models;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jamie
 */
public class Customer extends User
{
    // Private Attributes
    private String addressLine1;
    private String addressLine2;
    private String town;
    private String postcode;
    private boolean isRegistered;
    private HashMap<Integer, Order> orders;
    
    
    // Default Constructor

    /**
     *
     */
    public Customer() 
    {
        super();
        addressLine1 = " ";
        addressLine2 = " ";
        town = " ";
        postcode = " ";
        isRegistered = false;
        orders = new HashMap();
    }

    // Custom Constructor

    /**
     *
     * @param username
     * @param password
     * @param firstName
     * @param lastName
     * @param addressLine1
     * @param addressLine2
     * @param town
     * @param postcode
     */
    public Customer(String username, String password, String firstName, 
                    String lastName, String addressLine1, String addressLine2, 
                    String town,String postcode) 
    {
        super(username, password, firstName, lastName);
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.town = town;
        this.postcode = postcode;
        orders = new HashMap();
    }
    
    // Getters

    /**
     *
     * @return
     */
    public String getAddressLine1() {return addressLine1;}

    /**
     *
     * @return
     */
    public String getAddressLine2() {return addressLine2;}

    /**
     *
     * @return
     */
    public String getTown() {return town;}

    /**
     *
     * @return
     */
    public String getPostcode() {return postcode;}

    /**
     *
     * @return
     */
    public boolean isIsRegistered() {return isRegistered;}

    /**
     *
     * @return
     */
    public HashMap<Integer, Order> getOrders() {return orders;}
    
    // Setters

    /**
     *
     * @param addressLine1
     */
    public void setAddressLine1(String addressLine1) {this.addressLine1 = addressLine1;}

    /**
     *
     * @param addressLine2
     */
    public void setAddressLine2(String addressLine2) {this.addressLine2 = addressLine2;}

    /**
     *
     * @param town
     */
    public void setTown(String town) {this.town = town;}

    /**
     *
     * @param postcode
     */
    public void setPostcode(String postcode) {this.postcode = postcode;}

    /**
     *
     * @param isRegistered
     */
    public void setIsRegistered(boolean isRegistered) {this.isRegistered = isRegistered;}

    /**
     *
     * @param ordersIn
     */
    public void setOrders(HashMap<Integer, Order> ordersIn) {orders = ordersIn;}
    
    /**
     *
     * @return
     */
    public Order findLatestOrders()
    {
        Order currentOrder = new Order();
        int orderID = generateUniqueOrderId();
        currentOrder.setOrderId(orderID);
        
        if(orders.isEmpty())
        {
            addOrder(currentOrder);
        }
        else
        {
            currentOrder = orders.entrySet().iterator().next().getValue();
            
            for(Map.Entry<Integer, Order> oEntry : orders.entrySet())
            {
                Order actualOrder = oEntry.getValue();
                
                if(actualOrder.getOrderDate().after(currentOrder.getOrderDate()))
                {
                    currentOrder = actualOrder;
                }
            }  
        }
        
        if(currentOrder.getStatus().equals("Complete"))
        {
            currentOrder = new Order();
            addOrder(currentOrder);
        }
        
        return currentOrder; 
    }
    
    /**
     *
     * @return
     */
    public String displayGreeting()
    {
        String greeting = "Welcome " + this.getFirstName();
        
        return greeting;
    }
    
    /**
     *
     * @param order
     */
    public void addOrder(Order order)
    {

        DBManager db = new DBManager();
        int orderId = db.addOrder(order, this.getUsername());
        
        orders.put(orderId, order);
        orders.get(orderId).setOrderId(orderId); 
    }
    
    /**
     *
     * @return
     */
    public int generateUniqueOrderId()
    {
        int orderId = 0;
        
        for(Map.Entry<Integer, Order> olEntry : orders.entrySet())
        {
            if(orders.containsKey(orderId))
            {
                orderId++;
            }
        }
        
        return orderId;
    }
    
}
