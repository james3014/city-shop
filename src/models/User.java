package models;

/**
 *
 * @author Jamie
 */
public class User 
{
    // Attributes
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    
    // Default Constructor

    /**
     *
     */
    public User() 
    {
        username = " ";
        password = " ";
        firstName = " ";
        lastName = " ";     
    }
    
    // Custom Constructor

    /**
     *
     * @param username
     * @param password
     * @param firstName
     * @param lastName
     */
    public User(String username, String password, String firstName, String lastName) 
    {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    // Getters

    /**
     *
     * @return
     */
    public String getUsername() {return username;}

    /**
     *
     * @return
     */
    public String getPassword() {return password;}

    /**
     *
     * @return
     */
    public String getFirstName() {return firstName;}

    /**
     *
     * @return
     */
    public String getLastName() {return lastName;}
    
    // Setters

    /**
     *
     * @param username
     */
    public void setUsername(String username) {this.username = username;}

    /**
     *
     * @param password
     */
    public void setPassword(String password) {this.password = password;}

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {this.firstName = firstName;}

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {this.lastName = lastName;}
}

