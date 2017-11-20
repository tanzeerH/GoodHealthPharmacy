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
public class Prescription {
    
    private String pre_id;
    private String status;
    private String drop_off_time;
    private String pick_up_time;
    private String ssn;
    private String phy_ssn;
    private String pre_date;
    private String quantity;
    private String trade_name;
    private String pharm_co_name;
    
    
    private String remove="Remove";

    public String getPre_id() {
        return pre_id;
    }

    public void setPre_id(String pre_id) {
        this.pre_id = pre_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDrop_off_time() {
        return drop_off_time;
    }

    public void setDrop_off_time(String drop_off_time) {
        this.drop_off_time = drop_off_time;
    }

    public String getPick_up_time() {
        return pick_up_time;
    }

    public void setPick_up_time(String pick_up_time) {
        this.pick_up_time = pick_up_time;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getPhy_ssn() {
        return phy_ssn;
    }

    public void setPhy_ssn(String phy_ssn) {
        this.phy_ssn = phy_ssn;
    }

    public String getPre_date() {
        return pre_date;
    }

    public void setPre_date(String pre_date) {
        this.pre_date = pre_date;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getTrade_name() {
        return trade_name;
    }

    public void setTrade_name(String trade_name) {
        this.trade_name = trade_name;
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

    public Prescription(String pre_id, String status, String drop_off_time, String pick_up_time, String ssn, String phy_ssn, String pre_date, String quantity, String trade_name, String pharm_co_name) {
        this.pre_id = pre_id;
        this.status = status;
        this.drop_off_time = drop_off_time;
        this.pick_up_time = pick_up_time;
        this.ssn = ssn;
        this.phy_ssn = phy_ssn;
        this.pre_date = pre_date;
        this.quantity = quantity;
        this.trade_name = trade_name;
        this.pharm_co_name = pharm_co_name;
    }
    
}
