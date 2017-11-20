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
public class Contract {
    
    private String pharm_id;
    private String start_date;
    private String end_date;
    private String text;
    private String supervisor;
    private String pharm_co_name;

    public Contract(String pharm_id, String start_date, String end_date, String text, String supervisor, String pharm_co_name) {
        this.pharm_id = pharm_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.text = text;
        this.supervisor = supervisor;
        this.pharm_co_name = pharm_co_name;
    }

    public String getPharm_id() {
        return pharm_id;
    }

    public void setPharm_id(String pharm_id) {
        this.pharm_id = pharm_id;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getPharm_co_name() {
        return pharm_co_name;
    }

    public void setPharm_co_name(String pharm_co_name) {
        this.pharm_co_name = pharm_co_name;
    }

    public String getRemove() {
        return remove;
    }

    public void setRemove(String remove) {
        this.remove = remove;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }
    
    private String remove="Remove";
    private String contract="Contract";
    
   



    
}
