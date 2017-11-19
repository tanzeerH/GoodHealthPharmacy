/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goodhealthpharmacy.model;

/**
 *
 * @author Tanzeer
 */
public class Company {
   
    private String phone;  
    private String name;


    public Company( String name, String phone) {
       
        this.name = name;
        
        this.phone = phone;
    }
    private String remove="Remove";
     public String getRemove() {
        return remove;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
        
    
}
