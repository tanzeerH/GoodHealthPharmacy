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
public class Sell {
   private String trade_name;
   private String pharm_co_name; 
   private String pharm_id;
   private String price; 

    public Sell(String trade_name, String pharm_co_name, String pharm_id, String price) {
        this.trade_name = trade_name;
        this.pharm_co_name = pharm_co_name;
        this.pharm_id = pharm_id;
        this.price = price;
    }

   private String remove="Remove";

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

    public String getPharm_id() {
        return pharm_id;
    }

    public void setPharm_id(String pharm_id) {
        this.pharm_id = pharm_id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

   
    public String getRemove() {
        return remove;
    }
}
