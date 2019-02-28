package models;

/**
 *
 * @author Jamie
 */
public class Staff extends User
{
    // Private Attributes
    private String position;
    private double salary;

    
    // Default Constructor

    /**
     *
     */
    public Staff() 
    {
        super();
        position = " ";
        salary = 0;
    }

    
    // Custom Constructors

    /**
     *
     * @param position
     * @param salary
     * @param username
     * @param password
     * @param firstName
     * @param lastName
     */
    public Staff(String position, double salary, String username, String password, 
                 String firstName, String lastName) 
    {
        super(username, password, firstName, lastName);
        this.position = position;
        this.salary = salary;
    }

    
    // Getters

    /**
     *
     * @return
     */
    public String getPosition(){return position;}

    /**
     *
     * @return
     */
    public double getSalary() {return salary;}
    
    
    // Setters

    /**
     *
     * @param position
     */
    public void setPosition(String position) {this.position = position;}

    /**
     *
     * @param salary
     */
    public void setSalary(double salary) {this.salary = salary;}
    
    /**
     *
     * @return
     */
    public String displayGreeting()
    {
        String greeting = "Hi " + this.getFirstName();
        
        return greeting;
    }
}
