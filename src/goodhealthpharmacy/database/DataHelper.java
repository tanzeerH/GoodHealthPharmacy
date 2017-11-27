/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goodhealthpharmacy.database;

import goodhealthpharmacy.model.Company;
import goodhealthpharmacy.model.Contract;
import goodhealthpharmacy.model.Doctor;
import goodhealthpharmacy.model.Drug;
import goodhealthpharmacy.model.Patient;
import goodhealthpharmacy.model.Pharmacy;
import goodhealthpharmacy.model.Prescription;
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
                Patient patient=new Patient(rs.getString("ssn"), rs.getString("name"), rs.getString("birth_date"), rs.getString("address"), rs.getString("phy_ssn"));
                patientList.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patientList;

    }
     public static ArrayList<Patient> getPatientListByNameAndBirthdate(String name, String birthdate) {
        ArrayList<Patient> patientList=new ArrayList<>();
        try {
            Connection connection = Connector.getInstance();
            Statement stmt = connection.createStatement();
            String sql="select * from Pri_Phy_Patient where name = '"+ name+"' and birth_date = TO_DATE('"+birthdate+"', 'yyyy-mm-dd')";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Doctor doctor=new Doctor(rs.getString("ssn"), rs.getString("name"), rs.getString("specialty"), rs.getString("yearsOfExperience"));
                Patient patient=new Patient(rs.getString("ssn"), rs.getString("name"), rs.getString("birth_date"), rs.getString("address"), rs.getString("phy_ssn"));
                patientList.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patientList;

    }
     public static boolean insertPatient(String ssn, String name, String address, String date, String pry_phy)
    {
        
        try {
            Connection connection = Connector.getInstance();
            Statement stmt = connection.createStatement();

            String exeqSql="insert into Pri_Phy_Patient values ( '"+ ssn +"', '"+ name +"', TO_DATE('"+date+"', 'yyyy/mm/dd'), '"+ address +"', '"+pry_phy+"')";
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
     public static ArrayList<String> getPharmacyIDList() {
        ArrayList<String> pharmacyList=new ArrayList<>();
        try {
            Connection connection = Connector.getInstance();
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("select * from Pharmacy");
            while (rs.next()) {
                String pharmacy=rs.getString("pharm_id")+" : "+rs.getString("name");
                //Pharmacy pharmacy=new Pharmacy(rs.getString("pharm_id"), rs.getString("name"), rs.getString("address"), rs.getString("phone"));
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
       public static ArrayList<Company> getMostExpensiveCompanyList() {
        ArrayList<Company> companyList=new ArrayList<>();
        try {
            Connection connection = Connector.getInstance();
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("select unique(PHARM_CO.NAME),PHARM_CO.PHONE from Pharm_co,Sell Where Pharm_co.name= Sell.pharm_co_name and Sell.price= (select max(price) from Sell)");
            while (rs.next()) {
                Company company=new Company(rs.getString("name"), rs.getString("phone"));
                companyList.add(company);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companyList;

    }
       public static ArrayList<String> getCompanyIDList() {
        ArrayList<String> companyList=new ArrayList<>();
        try {
            Connection connection = Connector.getInstance();
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("select * from Pharm_co");
            while (rs.next()) {
                String company=rs.getString("name");
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
       public static ArrayList<Drug> getDrugsSoldByAllPharmacyList() {
        ArrayList<Drug> drugList=new ArrayList<>();
        try {
            Connection connection = Connector.getInstance();
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("Select Make_Drug.TRADE_NAME,MAKE_DRUG.PHARM_CO_NAME,MAKE_DRUG.FORMULA from Make_Drug, (select trade_name,pharm_co_name from Sell group by trade_name,pharm_co_name " +
            "having count(pharm_id) = (select count(*)  from Pharmacy)) A where Make_drug.trade_name = A.trade_name and " +
            "Make_Drug.pharm_co_name=A.pharm_co_name");
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
       public static ArrayList<Sell> getSellListOfOtherPharmacy(String pharmacy_id) {
        ArrayList<Sell> sellList=new ArrayList<>();
        try {
            Connection connection = Connector.getInstance();
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("Select Sell.price,Sell.pharm_id,Sell.trade_name, Sell.pharm_co_name, Pharmacy.phone from Sell, PHARMACY  where Sell.PHARM_ID <> '"+pharmacy_id+"' and Sell.TRADE_NAME IN " +
        "( Select TRADE_NAME from  SELL where SELL.PHARM_ID='"+pharmacy_id+"') and Sell.PHARM_CO_NAME IN " +
        "( Select PHARM_CO_NAME from  SELL where SELL.PHARM_ID='"+pharmacy_id+"') and SEll.PHARM_ID=PHARMACY.PHARM_ID");
            while (rs.next()) {
                Sell sell=new Sell(rs.getString("trade_name"), rs.getString("pharm_co_name"),rs.getString("pharm_id"), rs.getString("price"));
                sellList.add(sell);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sellList;

    }
       
    public static ArrayList<Contract> getContractList() {
        ArrayList<Contract> contractList=new ArrayList<>();
        try {
            Connection connection = Connector.getInstance();
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("select * from Contract");
            while (rs.next()) {
                Contract contract=new Contract(rs.getString("pharm_id"), rs.getString("start_date"),rs.getString("end_date"), rs.getString("text"),rs.getString("supervisor"), rs.getString("pharm_co_name"));
                contractList.add(contract);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractList;

    }
      public static boolean insertContract(String pharm_id, String pharm_co_name, String start_date, String end_date, String supervisor, String text)
    {
        
        try {
            Connection connection = Connector.getInstance();
            Statement stmt = connection.createStatement();

            String exeqSql="insert into Contract values ( '"+ pharm_id +"', '"+ start_date +"', '"+ end_date+"', '"+ text +"', '"+ supervisor +"', '"+ pharm_co_name +"')";
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
            return false;
        }
        
        return  true;
    }
       public static boolean updateContract(String pharm_id, String pharm_co_name, String start_date, String end_date, String supervisor, String text, String prev_pharm_id, String prev_pharm_co)
    {
        
        try {
            Connection connection = Connector.getInstance();
            Statement stmt = connection.createStatement();

            String exeqSql="update Contract SET pharm_id = '"+ pharm_id +"', start_date =  '"+ start_date +"', end_date = '"+ end_date+"', text = '"+ text +"', supervisor = '"+ supervisor +"', pharm_co_name =  '"+ pharm_co_name 
                    +"' where pharm_id = '"+prev_pharm_id+"' and pharm_co_name = '"+ prev_pharm_co+"'";
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
            return false;
        }
        
        return  true;
    }
        public static ArrayList<Prescription> getPrescriptionList() {
        ArrayList<Prescription> prescriptionList=new ArrayList<>();
        try {
            Connection connection = Connector.getInstance();
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("select * from Prescription");
            while (rs.next()) {
                Prescription prescription=new Prescription(rs.getString("pre_id"), rs.getString("status"),rs.getString("drop_off_time"), rs.getString("pick_up_time"),rs.getString("ssn"),
                        rs.getString("phy_ssn"),rs.getString("pre_date"),rs.getString("quantity"), rs.getString("trade_name"),rs.getString("pharm_co_name"));
                prescriptionList.add(prescription);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prescriptionList;

    }
        public static ArrayList<Prescription> getPrescriptionListByPatient(String ssn) {
        ArrayList<Prescription> prescriptionList=new ArrayList<>();
        try {
            Connection connection = Connector.getInstance();
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("select * from Prescription where ssn='"+ssn+"'");
            while (rs.next()) {
                Prescription prescription=new Prescription(rs.getString("pre_id"), rs.getString("status"),rs.getString("drop_off_time"), rs.getString("pick_up_time"),rs.getString("ssn"),
                        rs.getString("phy_ssn"),rs.getString("pre_date"),rs.getString("quantity"), rs.getString("trade_name"),rs.getString("pharm_co_name"));
                prescriptionList.add(prescription);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prescriptionList;

    }
        public static ArrayList<Prescription> getPrescriptionListByPendingStatus() {
        ArrayList<Prescription> prescriptionList=new ArrayList<>();
        try {
            Connection connection = Connector.getInstance();
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("select * from Prescription where status='pending'");
            while (rs.next()) {
                Prescription prescription=new Prescription(rs.getString("pre_id"), rs.getString("status"),rs.getString("drop_off_time"), rs.getString("pick_up_time"),rs.getString("ssn"),
                        rs.getString("phy_ssn"),rs.getString("pre_date"),rs.getString("quantity"), rs.getString("trade_name"),rs.getString("pharm_co_name"));
                prescriptionList.add(prescription);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prescriptionList;

    }
         public static ArrayList<Prescription> getPrescriptionListByCompletedStatus(String date) {
        ArrayList<Prescription> prescriptionList=new ArrayList<>();
        try {
            Connection connection = Connector.getInstance();
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("select * from Prescription where status='completed'");
            while (rs.next()) {
                if(rs.getString("drop_off_time").startsWith(date))
                {
                Prescription prescription=new Prescription(rs.getString("pre_id"), rs.getString("status"),rs.getString("drop_off_time"), rs.getString("pick_up_time"),rs.getString("ssn"),
                        rs.getString("phy_ssn"),rs.getString("pre_date"),rs.getString("quantity"), rs.getString("trade_name"),rs.getString("pharm_co_name"));
                prescriptionList.add(prescription);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prescriptionList;

    }
         public static ArrayList<Prescription> getPrescriptionListByPatientNameAndBirthDate(String name, String bdate) {
        ArrayList<Prescription> prescriptionList=new ArrayList<>();
        try {
            ArrayList<Patient> pList= getPatientListByNameAndBirthdate(name, bdate);
            Connection connection = Connector.getInstance();
            Statement stmt = connection.createStatement();

            for (int i=0;i<pList.size();i++)
            {
                ResultSet rs = stmt.executeQuery("select * from Prescription where ssn='"+pList.get(i).getSsn()+"'");
                while (rs.next()) {
                    Prescription prescription=new Prescription(rs.getString("pre_id"), rs.getString("status"),rs.getString("drop_off_time"), rs.getString("pick_up_time"),rs.getString("ssn"),
                            rs.getString("phy_ssn"),rs.getString("pre_date"),rs.getString("quantity"), rs.getString("trade_name"),rs.getString("pharm_co_name"));
                    prescriptionList.add(prescription);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prescriptionList;

    }
         public static boolean insertPrescription(String status, String pharm_co_name, String date, String quantity, String ssn, String phy_ssn, String drop_off_time, String pick_up_time, String trade_name)
    {
        
        try {
            Connection connection = Connector.getInstance();
            Statement stmt = connection.createStatement();

            String exeqSql="insert into Prescription values ( prescription_sequence.nextval, '"+ status +"', "+ "TO_TIMESTAMP('"+drop_off_time+"', 'YYYY-MM-DD HH24:MI:SS.FF'), TO_TIMESTAMP('"+drop_off_time+"', 'YYYY-MM-DD HH24:MI:SS.FF'), '"+
                    ssn+"', '"+phy_ssn+"', TO_DATE('"+date+"', 'yyyy/mm/dd'), "+ quantity +" , '"+trade_name+"', '"+ pharm_co_name +"')";
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
            return false;
        }
        
        return  true;
    }
     public static ArrayList<String> getDrugTradeNameList() {
        ArrayList<String> tradeNameList=new ArrayList<>();
        try {
            Connection connection = Connector.getInstance();
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("select * from Make_Drug");
            while (rs.next()) {
                String company=rs.getString("trade_name")+" : "+rs.getString("pharm_co_name") ;
                tradeNameList.add(company);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tradeNameList;

    }
      public static ArrayList<String> getPatientSSNList() {
        ArrayList<String> patientList=new ArrayList<>();
        try {
            Connection connection = Connector.getInstance();
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("select * from Pri_Phy_Patient");
            while (rs.next()) {
                String company=rs.getString("ssn")+" : "+ rs.getString("name");
                patientList.add(company);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patientList;

    }
       public static ArrayList<String> getPhySSNList() {
        ArrayList<String> patientList=new ArrayList<>();
        try {
            Connection connection = Connector.getInstance();
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("select * from Doctor");
            while (rs.next()) {
                String company=rs.getString("ssn")+" : "+ rs.getString("name");
                patientList.add(company);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patientList;

    }
       public static boolean deletePrescription(String prep_id)
    {
        
        try {
            Connection connection = Connector.getInstance();
            Statement stmt = connection.createStatement();

            String exeqSql="Delete from Prescription where pre_id = '"+prep_id+"'";
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
       
}

