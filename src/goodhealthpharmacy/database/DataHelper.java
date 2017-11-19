/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goodhealthpharmacy.database;

import goodhealthpharmacy.model.Company;
import goodhealthpharmacy.model.Doctor;
import goodhealthpharmacy.model.Drug;
import goodhealthpharmacy.model.Patient;
import goodhealthpharmacy.model.Pharmacy;
import goodhealthpharmacy.model.Sell;
import goodhealthpharmacy.utils.Connector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Tanzeer
 */
public class DataHelper {

    public static ArrayList<Doctor> getDoctorList() {
        ArrayList<Doctor> docList=new ArrayList<>();
        try {
            Connection connection = Connector.getInstance();
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("select * from Doctor");
            while (rs.next()) {
                Doctor doctor=new Doctor(rs.getString("ssn"), rs.getString("name"), rs.getString("specialty"), rs.getString("yearsOfExperience"));
                docList.add(doctor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return docList;

    }
    public static boolean insertDoctor(String ssn, String name, String speciality, String year_of_exp)
    {
        
        try {
            Connection connection = Connector.getInstance();
            Statement stmt = connection.createStatement();

            String exeqSql="insert into Doctor values ( '"+ ssn +"', '"+ name +"', '"+ speciality+"', "+ year_of_exp +")";
            System.out.println(exeqSql);
            boolean res= stmt.execute(exeqSql);
            System.out.println("res: "+ res);
        } 
        catch (SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
            return false;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return  true;
    }
    public static ArrayList<Patient> getPatientList() {
        ArrayList<Patient> patientList=new ArrayList<>();
        try {
            Connection connection = Connector.getInstance();
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("select * from Pri_Phy_Patient");
            while (rs.next()) {
                //Doctor doctor=new Doctor(rs.getString("ssn"), rs.getString("name"), rs.getString("specialty"), rs.getString("yearsOfExperience"));
                Patient patient=new Patient(rs.getString("ssn"), rs.getString("name"), rs.getString("age"), rs.getString("address"), rs.getString("phy_ssn"));
                patientList.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patientList;

    }
     public static ArrayList<Pharmacy> getPharmacyList() {
        ArrayList<Pharmacy> pharmacyList=new ArrayList<>();
        try {
            Connection connection = Connector.getInstance();
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("select * from Pharmacy");
            while (rs.next()) {
                Pharmacy pharmacy=new Pharmacy(rs.getString("pharm_id"), rs.getString("name"), rs.getString("address"), rs.getString("phone"));
                pharmacyList.add(pharmacy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pharmacyList;

    }
      public static ArrayList<Company> getCompanyList() {
        ArrayList<Company> companyList=new ArrayList<>();
        try {
            Connection connection = Connector.getInstance();
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("select * from Pharm_co");
            while (rs.next()) {
                Company company=new Company(rs.getString("name"), rs.getString("phone"));
                companyList.add(company);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companyList;

    }
      public static ArrayList<Drug> getDrugList() {
        ArrayList<Drug> drugList=new ArrayList<>();
        try {
            Connection connection = Connector.getInstance();
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("select * from Make_Drug");
            while (rs.next()) {
                Drug drug=new Drug(rs.getString("trade_name"), rs.getString("pharm_co_name"),rs.getString("formula"));
                drugList.add(drug);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drugList;

    }
       public static ArrayList<Sell> getSellList() {
        ArrayList<Sell> sellList=new ArrayList<>();
        try {
            Connection connection = Connector.getInstance();
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("select * from Sell");
            while (rs.next()) {
                Sell sell=new Sell(rs.getString("trade_name"), rs.getString("pharm_co_name"),rs.getString("pharm_id"), rs.getString("price"));
                sellList.add(sell);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sellList;

    }
}
