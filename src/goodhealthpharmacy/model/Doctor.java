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
public class Doctor {
    
    private String ssn;
    private String name;
    private String speciality;
    private String year_of_experience;
    private String remove="Remove";

    public Doctor(String ssn, String name, String speciality, String year_of_experience) {
        this.ssn = ssn;
        this.name = name;
        this.speciality = speciality;
        this.year_of_experience = year_of_experience;
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

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getYear_of_experience() {
        return year_of_experience;
    }

    public void setYear_of_experience(String year_of_experience) {
        this.year_of_experience = year_of_experience;
    }

  
    public String getRemove() {
        return remove;
    }
    
    
}
