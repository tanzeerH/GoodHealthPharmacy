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
public class Drug {
   private String trade_name;
   private String pharm_co_name; 
   private String formula; 
   private String remove="Remove";

    public Drug(String trade_name, String pharm_co_name, String formula) {
        this.trade_name = trade_name;
        this.pharm_co_name = pharm_co_name;
        this.formula = formula;
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

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }
    public String getRemove() {
        return remove;
    }
}
