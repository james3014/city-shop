package models;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jamie
 */
public class DBManager 
{
    // Private Constants
    private final String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
    private final String connectionString = 
//              "jdbc:ucanaccess://Z:\\HND\\Object Oriented Programming\\15-2-19\\Assessment\\Assessment30237347\\Data\\ShopDB.accdb";
            "jdbc:ucanaccess://C:\\Users\\Jamie\\Desktop\\Assessment30237347\\Data\\ShopDB.accdb";
    
    
    // Public Functions

    /**
     *
     * @return
     */
    public HashMap<String, Staff> loadStaff()
    {
        // String as ZooKeepers email
        HashMap<String, Staff> staffMembers = new HashMap();
        try
        {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(connectionString);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Staff");
            
            while(rs.next())
            {
                // Store database values in ResultSet
                String username = rs.getString("Username");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String password = rs.getString("Password");
                String position = rs.getString("Position");
                Double salary = rs.getDouble("Salary");
                        
                // Create an instance of ZooKeeper 
                Staff staff = new Staff(position, salary, username, password, firstName, lastName);
                
                // Add 'zooKeeper' to the 'zooKeepers' HashMap
                staffMembers.put(username, staff);
            }
            
            connection.close();
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
        finally
        {
            return staffMembers;
        }
    }
    
    /**
     *
     * @return
     */
    public HashMap<String, Customer> loadCustomers()
    {
        // String as ZooKeepers email
        HashMap<String, Customer> customers = new HashMap();
        try
        {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(connectionString);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Customers");
            
            while(rs.next())
            {
                // Store database values in ResultSet
                String username = rs.getString("Username");
                String password = rs.getString("Password");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String addressLine1 = rs.getString("AddressLine1");
                String addressLine2 = rs.getString("AddressLine2");
                String town = rs.getString("Town");
                String postcode = rs.getString("Postcode");

               // Create an instance of ZooKeeper 
                Customer customer = new Customer(username, password, firstName,
                        lastName, addressLine1, addressLine2, town, postcode);
                
                // Add 'zooKeeper' to the 'zooKeepers' HashMap
                customers.put(username, customer);
            }
            
            connection.close();
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
        finally
        {
            customers = loadCustomerOrders(customers);
            customers = loadCustomerOrderLines(customers);
            return customers;
        }
    }
    
    /**
     *
     * @param username
     * @param password
     * @return
     */
    public Staff staffLogin(String username, String password)
    {
        HashMap<String, Staff> staffMembers = loadStaff();
        
                
        // Returns true if zookeeper with this email is present
        if(staffMembers.containsKey(username)) 
        {
            // Returns the zookeeper with email address as their key
            Staff foundStaffMember = staffMembers.get(username);
            
            if(foundStaffMember.getPassword().equals(password))
            {
                return foundStaffMember;
            }
            else
            {
                return null;
            }
        }
        else
        {
            return null;
        }
    }
    
    /**
     *
     * @param username
     * @param password
     * @return
     */
    public Customer customerLogin(String username, String password)
    {
        HashMap<String, Customer> customers = loadCustomers();
        
                
        // Returns true if zookeeper with this email is present
        if(customers.containsKey(username)) 
        {
            // Returns the zookeeper with email address as their key
            Customer foundCustomer = customers.get(username);
            
            if(foundCustomer.getPassword().equals(password))
            {
                return foundCustomer;
            }
            else
            {
                return null;
            }
        }
        else
        {
            return null;
        }
    }
     
    /**
     *
     * @return
     */
    public HashMap<Integer, Product> loadProducts()
    {
        // String as ZooKeepers email
        HashMap<Integer, Product> products = new HashMap();
        try
        {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(connectionString);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Products");
            
            while(rs.next())
            {
                // Store database values in ResultSet
                int productId = rs.getInt("ProductId");
                String productName = rs.getString("ProductName");
                double price = rs.getDouble("Price");
                int stockLevel = rs.getInt("StockLevel");
                String measurement = rs.getString("Measurement");
                int size = rs.getInt("Size");
                
                if(size == 0)
                {
                    Clothing clothing = new Clothing(measurement, productId, productName, price, stockLevel);
                    
                    products.put(productId, clothing);
                }
                else
                {
                    Footwear footwear = new Footwear(size, productId, productName, price, stockLevel);
                    
                    products.put(productId, footwear);
                }
            }
            
            connection.close();
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
        finally
        {
            return products;
        }
    }
     
    /**
     *
     * @param c
     * @return
     */
    public boolean registerCustomer(Customer c)
    {
         try
         {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(connectionString);
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Customers (Username, Password, FirstName, LastName, AddressLine1, AddressLine2, Town, Postcode) "
            + "VALUES ('" + c.getUsername() + "', '" + c.getPassword() + "', '" + c.getFirstName() + "', '" + c.getLastName() 
            + "', '" + c.getAddressLine1() + "', '" + c.getAddressLine2() + "', '" + c.getTown()+ "', '" + c.getPostcode() + "')");
         
            connection.close();
            return true;
         }
         catch(Exception ex)
         {
             String message = ex.getMessage();
             return false;
         }
                       
    }
    
    /**
     *
     * @param product
     */
    public void addProduct(Product product)
    {
            String measurement = "";
            int size = 0;
            
            if(product.getClass().getName().equals("models.Clothing"))
            {
                Clothing clothing = (Clothing)product;
                measurement = String.valueOf(clothing.getMeasurement());
            }
            else if(product.getClass().getName().equals("models.Footwear"))
            {
                Footwear footwear = (Footwear)product;
                size = footwear.getSize();
            }
            
            try
            {
                Class.forName(driver);
                Connection connection = DriverManager.getConnection(connectionString);
                Statement statement = connection.createStatement();
                statement.executeUpdate("INSERT INTO Products (ProductName, Price, StockLevel, Measurement, Size) " +
                        "VALUES ('" + product.getProductName() + "', '" + product.getPrice() +  "', '" + product.getStockLevel()
                        + "', '" + measurement + "', '" + size + "')");
                 
                connection.close();
            }
            catch(Exception ex)
            {
                String message = ex.getMessage();
            }
    }
    
    /**
     *
     * @param product
     */
    public void editProduct(Product product)
    {
        String measurement = "";
        int size = 0;
            
        if(product.getClass().getName().equals("models.Clothing"))
        {
            Clothing clothing = (Clothing)product;
            measurement = String.valueOf(clothing.getMeasurement());
        }
        else if(product.getClass().getName().equals("models.Footwear"))
        {
            Footwear footwear = (Footwear)product;
            size = footwear.getSize();
        }
            
        try
        {
        
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(connectionString);
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE Products SET ProductName = '" + product.getProductName() + "', Price = '" + product.getPrice() + "',"
                    + "StockLevel = '" + product.getStockLevel() + "', Measurement = '" + measurement + "', Size = '" + size + "' WHERE ProductId = '" + product.getProductId() + "'");
  
            connection.close();
        }
        
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
    
    /**
     *
     * @param c
     */
    public void editCustomer(Customer c)
    {
         try
         {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(connectionString);
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE Customers SET Username = '" + c.getUsername() + "', Password = '" + c.getPassword() + "', FirstName = '" + c.getFirstName() + "', LastName = '" + c.getLastName() 
            + "', AddressLine1 = '" + c.getAddressLine1() + "', AddressLine2 = '" + c.getAddressLine2() + "', Town =  '" + c.getTown()+ "', Postcode = '" + c.getPostcode() + "' WHERE Username = '" + c.getUsername() + "'");
         
            connection.close();
         }
         catch(Exception ex)
         {
             String message = ex.getMessage();
         }
    }
    
    /**
     *
     * @param customer
     */
    public void deleteCustomer(Customer customer)
    {
            try
            {
                Class.forName(driver);
                Connection connection = DriverManager.getConnection(connectionString);
                Statement statement = connection.createStatement();
                statement.executeUpdate("DELETE FROM Customers WHERE Username = '" + customer.getUsername()+ "'");
                connection.close();
            }
            catch(Exception ex)
            {
                String message = ex.getMessage();
            }  
    }
    
    /**
     *
     * @param product
     */
    public void deleteProduct(Product product)
    {
        try
            {
                Class.forName(driver);
                Connection connection = DriverManager.getConnection(connectionString);
                Statement statement = connection.createStatement();
                statement.executeUpdate("DELETE FROM Products WHERE ProductId = '" + product.getProductId() + "'");
                connection.close();
            }
            catch(Exception ex)
            {
                String message = ex.getMessage();
            }  
    }
    
    /**
     *
     * @param orderLine
     * @param orderId
     * @return
     */
    public int addOrderLine(OrderLine orderLine, int orderId)
    {
        int orderLineId = 0;
        
        try
            {
                Class.forName(driver);
                Connection connection = DriverManager.getConnection(connectionString);
                Statement statement = connection.createStatement();
                statement.executeUpdate("INSERT INTO OrderLines (ProductId, Quantity, LineTotal, OrderId) VALUES " + 
                "('" + orderLine.getProduct().getProductId() + "', '" + orderLine.getQuantity()
                + "', '" + orderLine.getLineTotal() + "', '" + orderId + "')");
                
                ResultSet rs = statement.getGeneratedKeys();
                
                if(rs.next())
                {
                    orderLineId = rs.getInt(1);
                }
                
                connection.close();
            }
            catch(Exception ex)
            {
                String message = ex.getMessage();
            }  
        
        return orderLineId;
    }
    
    /**
     *
     * @param ol
     */
    public void editOrderLine(OrderLine ol)
    {
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("UPDATE OrderLines SET Quantity = '" + ol.getQuantity() + "', " +
                    "LineTotal = '" + ol.getLineTotal() + "' WHERE OrderLineId = '" + ol.getOrderLineId() + "'");

            conn.close();
        }
        catch(Exception ex)
        {
            ex.getMessage();
        }
    }
    
    /**
     *
     * @param order
     * @param staffUsername
     * @return
     */
    public int addOrder(Order order, String staffUsername)
    {
        int orderId = 0;
        
        try
            {
                Class.forName(driver);
                Connection connection = DriverManager.getConnection(connectionString);
                Statement statement = connection.createStatement();
                statement.executeUpdate("INSERT INTO Orders (OrderDate, Username, OrderTotal, Status)" 
                + "VALUES ('" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getOrderDate()) 
                + "', '" + staffUsername + "', '" + order.getOrderTotal() + "', '" + order.getStatus() + "')");
                
                ResultSet rs = statement.getGeneratedKeys();
                
                if(rs.next())
                {
                    orderId = rs.getInt(1);
                }
                
                connection.close();
            }
            catch(Exception ex)
            {
                String message = ex.getMessage();
            }
        
        return orderId;
    }
    
    /**
     *
     * @param orderId
     * @param newTotal
     */
    public void updateOrderTotal(int orderId, double newTotal)
    {
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE Orders SET OrderTotal = '" + newTotal + 
                    "' WHERE OrderId = '" + orderId + "'");
            conn.close();
        }
        catch(Exception ex)
        {
            ex.getMessage();
        }        
    }
    
    /**
     *
     * @param orderId
     */
    public void completeOrder(int orderId)
    {
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE Orders SET Status = 'Complete' WHERE OrderId = '" + orderId + "'");
            conn.close();
        }
        catch(Exception ex)
        {
            ex.getMessage();
        }        
    }
    
    /**
     *
     * @param customers
     * @return
     */
    public HashMap<String, Customer> loadCustomerOrders(HashMap<String, Customer> customers)
    {
       try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Orders");
            
            while(rs.next())
            {
                int orderId = rs.getInt("OrderId");
                Date orderDate = rs.getDate("OrderDate");
                String username = rs.getString("Username");
                double orderTotal = rs.getDouble("OrderTotal");
                String status = rs.getString("Status");
                
                Order loadOrder = new Order(orderId, orderDate, orderTotal, status);
                
                if(customers.containsKey(username))
                {
                    Customer cWithOrder = customers.get(username);
                    cWithOrder.getOrders().put(orderId, loadOrder);
                }
            }
            
            conn.close();
            
        }
        catch(ClassNotFoundException | SQLException ex)
        {
            ex.getMessage();
        }
        finally
        {
             return customers;
        } 
    }
    
    /**
     *
     * @param customers
     * @return
     */
    public HashMap<String, Customer> loadCustomerOrderLines(HashMap<String, Customer> customers)
    {
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM OrderLines");
            
            HashMap<Integer, Product> products = loadProducts();
            
            while(rs.next())
            {
                int orderLineId = rs.getInt("OrderLineId");
                int productId = rs.getInt("ProductId");
                int quantity = rs.getInt("Quantity");
                double lineTotal = rs.getDouble("LineTotal");
                int orderId = rs.getInt("OrderId");
                
                Product loadedProduct = new Product();
                
                if(products.containsKey(productId))
                {
                    loadedProduct = products.get(productId);
                }

                OrderLine loadOrderLine = new OrderLine(orderLineId, loadedProduct, quantity, lineTotal);
                
                for(Map.Entry<String, Customer> cEntry : customers.entrySet())
                {
                    Customer actualCustomer = cEntry.getValue();
                    
                    if(actualCustomer.getOrders().containsKey(orderId))
                    {
                        Order orderWithOrderLine = actualCustomer.getOrders().get(orderId);
                        orderWithOrderLine.getOrderLines().put(orderLineId, loadOrderLine);
                    }
                }
            }
            
            conn.close();
        }
        catch(ClassNotFoundException | SQLException ex)
        {
            ex.getMessage();
        }
        finally
        {
             return customers;
        }
    }
    
    /**
     *
     * @param orderLineId
     */
    public void deleteOrderLine(int orderLineId)
    {
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM OrderLines WHERE OrderLineId = '" + orderLineId + "'");
            conn.close();
        }
        catch(Exception ex)
        {
            ex.getMessage();
        }
    }
    
    /**
     *
     * @param productId
     * @param quantity
     */
    public void updateProductAvailability(int productId, int quantity)
    {
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            
            String query = "UPDATE Products SET StockLevel = StockLevel - ? WHERE ProductId = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, quantity);
            stmt.setInt(2, productId);
            
            stmt.executeUpdate();
            
            conn.close();
        }
        catch(Exception ex)
        {
            ex.getMessage();
        }
    }
}

    


