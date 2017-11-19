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
public class Patient {
    
    private String ssn;
    private String name;
    private String age;
    private String address;
    private String pri_phy;

    private String remove="Remove";

    public Patient(String ssn, String name, String age, String address, String pri_phy) {
        this.ssn = ssn;
        this.name = name;
        this.age = age;
        this.address = address;
        this.pri_phy = pri_phy;
    }

    

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPri_phy() {
        return pri_phy;
    }

    public void setPri_phy(String pri_phy) {
        this.pri_phy = pri_phy;
    }

   
  
    public String getRemove() {
        return remove;
    }
    
    
}
