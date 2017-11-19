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
public class Pharmacy {
    private String pharm_id;
    private String name;
    private String address;
    private String phone;

    public Pharmacy(String pharm_id, String name, String address, String phone) {
        this.pharm_id = pharm_id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    private String remove="Remove";
     public String getRemove() {
        return remove;
    }

    public String getPharm_id() {
        return pharm_id;
    }

    public void setPharm_id(String pharm_id) {
        this.pharm_id = pharm_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
        
    
}
