/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goodhealthpharmacy;

import goodhealthpharmacy.database.DataHelper;
import goodhealthpharmacy.model.Doctor;
import goodhealthpharmacy.model.Contract;
import goodhealthpharmacy.utils.CommonUtils;
import goodhealthpharmacy.utils.Constants;
import java.awt.Dimension;
import java.awt.JobAttributes;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Tanzeer
 */
public class FXMLAddEditPrescriptionManagementController implements Initializable {

    @FXML
    ComboBox comboBoxStatus;
   
    @FXML
    ComboBox comboBoxTradeName;
    
     @FXML
    ComboBox comboBoxSsn;
    @FXML
    ComboBox comboBoxPhySsn;
    @FXML
    ComboBox comboPickMin;
  @FXML
    ComboBox comboPickHour;
  @FXML
    ComboBox comboDropHour;
  @FXML
    ComboBox comboDropMin;
  
  
 
   
    @FXML
    TextField txtQuantity;
    @FXML
    DatePicker dpDate;
    @FXML
    DatePicker dpDropOff;
    @FXML
    DatePicker dpPickUp;
    @FXML
    Button btnAdd;
    
    @FXML
    Button btnContract;
    
    @FXML
    Button btnDocManage;
    
    @FXML
    Button btnPharmacy;
    
    @FXML
    Button btnCompany;
    
    @FXML
    Button btnDrug;


    @FXML
    TableView tableContract;

    private  ObservableList<Contract> data;
    private  ObservableList<String> tradeNameList;
    private  ObservableList<String> companyList;
    private  ObservableList<String> ssnList;
    private  ObservableList<String> phySnnList;
    private  ObservableList<String> statusList;
    private  ObservableList<String> hourList;
    private  ObservableList<String> minList;
     private  ArrayList<String> mHourList = new ArrayList<>();
    private  ArrayList<String> mMinList  = new ArrayList<>();




    @FXML
    private void handleButtonAction(ActionEvent event) {
       System.out.println(event.getSource()+"  patient clicked");
        Stage stage;
        Parent root;
        stage = (Stage) btnContract.getScene().getWindow();
        //load up OTHER FXML document
        try {
             root = FXMLLoader.load(getClass().getResource("FXMLDoctorManagement.fxml"));
             Scene scene = new Scene(root,Constants.WINDOW_WIDTH,Constants.WINDOW_HEIGHT);

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
    @FXML
    private void onDocManage(ActionEvent event) {
     System.out.println(event.getSource()+"  doctor clicked");
        Stage stage;
        Parent root;
        stage = (Stage) btnContract.getScene().getWindow();
        //load up OTHER FXML document
        try {
             root = FXMLLoader.load(getClass().getResource("FXMLDoctorManagement.fxml"));
             Scene scene = new Scene(root,Constants.WINDOW_WIDTH,Constants.WINDOW_HEIGHT);
             
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        
    @FXML
    private void onPharmManage(ActionEvent event) {
     System.out.println(event.getSource()+"  doctor clicked");
        Stage stage;
        Parent root;
        stage = (Stage) btnContract.getScene().getWindow();
        //load up OTHER FXML document
        try {
             root = FXMLLoader.load(getClass().getResource("FXMLPharmacyManagement.fxml"));
             Scene scene = new Scene(root,Constants.WINDOW_WIDTH,Constants.WINDOW_HEIGHT);

            stage.setTitle("Pharmacy Management");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void onCompanyManage(ActionEvent event) {
     System.out.println(event.getSource()+"  company clicked");
        Stage stage;
        Parent root;
        stage = (Stage) btnCompany.getScene().getWindow();
        //load up OTHER FXML document
        try {
             root = FXMLLoader.load(getClass().getResource("FXMLCompanyManagement.fxml"));
             Scene scene = new Scene(root,Constants.WINDOW_WIDTH,Constants.WINDOW_HEIGHT);

            stage.setTitle("Company Management");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  @FXML
    private void onDrugManage(ActionEvent event) {
     System.out.println(event.getSource()+"  drugs clicked");
        Stage stage;
        Parent root;
        stage = (Stage) btnCompany.getScene().getWindow();
        //load up OTHER FXML document
        try {
             root = FXMLLoader.load(getClass().getResource("FXMLDrugsManagement.fxml"));
             Scene scene = new Scene(root,Constants.WINDOW_WIDTH,Constants.WINDOW_HEIGHT);

            stage.setTitle("Company Management");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void handleAddButton(ActionEvent event) {
        System.out.println(event.getSource() + "  add clicked" + dpDate.getValue().toString());
        if( dpDropOff.getValue().toString().trim().length() == 0 ||
                 dpPickUp.getValue().toString().trim().length() == 0 || txtQuantity.getText().trim().length() == 0 || dpDate.getValue().toString().trim().length() == 0)
        {
            CommonUtils.showWarningDialog();
        } 
        else if( comboBoxStatus.getSelectionModel().getSelectedItem() == null || 
          comboBoxSsn.getSelectionModel().getSelectedItem() == null || comboBoxPhySsn.getSelectionModel().getSelectedItem() == null   ||comboBoxTradeName.getSelectionModel().getSelectedItem() == null  || 
                comboDropHour.getSelectionModel().getSelectedItem() == null || 
          comboDropMin.getSelectionModel().getSelectedItem() == null || comboPickHour.getSelectionModel().getSelectedItem() == null   ||comboPickMin.getSelectionModel().getSelectedItem() == null)
        {
             CommonUtils.showNotSelectedWarningDialog();
        }
        else
        {
            String  status = comboBoxStatus.getSelectionModel().getSelectedItem().toString().trim();
            
            String ssn = comboBoxSsn.getSelectionModel().getSelectedItem().toString().trim().split(":")[0].trim();
            String phy_ssn=  comboBoxPhySsn.getSelectionModel().getSelectedItem().toString().trim().split(":")[0].trim();
            String pre_date = dpDate.getValue().toString();
            String quantity = txtQuantity.getText().toString().trim();
            String drop_off_time = dpDropOff.getValue().toString()+" "+ comboDropHour.getSelectionModel().getSelectedItem().toString().trim()+":"+
                    comboDropMin.getSelectionModel().getSelectedItem().toString().trim()+":00.00000";
            String pick_up_time = dpPickUp.getValue().toString()+" "+ comboPickHour.getSelectionModel().getSelectedItem().toString().trim()+":"+
                    comboPickMin.getSelectionModel().getSelectedItem().toString().trim()+":00.00000";
            String trade_name = comboBoxTradeName.getSelectionModel().getSelectedItem().toString().trim().split(":")[0].trim();
            String  pharm_co_name =  comboBoxTradeName.getSelectionModel().getSelectedItem().toString().trim().split(":")[1].trim();

            insertOrUpdate(status,pharm_co_name,pre_date,quantity,ssn,phy_ssn,drop_off_time,pick_up_time,trade_name);
          /* boolean res= DataHelper.insertDoctor(txtSsn.getText(), txtName.getText(), txtSpeciality.getText(), txtExp.getText());
           if(res)
           {
                JOptionPane.showMessageDialog(null, "Successfully Inserted.");
                //txtSsn.setText("");
                txtName.setText("");
                txtSpeciality.setText("");
                txtExp.setText("");
               // initContractTable();
           }
           else
           {
                JOptionPane.showMessageDialog(null, "Insertion Failed.");
               
           }*/
        }
    }
   private void setDatePicker()
   {
       String pattern = "yyyy/MM/dd";

        dpDate.setPromptText(pattern.toLowerCase());

        dpDate.setConverter(new StringConverter<LocalDate>() {
             DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

             @Override 
             public String toString(LocalDate date) {
                 if (date != null) {
                     return dateFormatter.format(date);
                 } else {
                     return "";
                 }
             }

             @Override 
             public LocalDate fromString(String string) {
                 if (string != null && !string.isEmpty()) {
                     return LocalDate.parse(string, dateFormatter);
                 } else {
                     return null;
                 }
             }
         });
   }
    private void setDatePickerForPickUp()
   {
       String pattern = "yyyy-MM-dd";

        dpPickUp.setPromptText(pattern.toLowerCase());

        dpPickUp.setConverter(new StringConverter<LocalDate>() {
             DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

             @Override 
             public String toString(LocalDate date) {
                 if (date != null) {
                     return dateFormatter.format(date);
                 } else {
                     return "";
                 }
             }

             @Override 
             public LocalDate fromString(String string) {
                 if (string != null && !string.isEmpty()) {
                     return LocalDate.parse(string, dateFormatter);
                 } else {
                     return null;
                 }
             }
         });
   }
     private void setDatePickerForDropOff()
   {
       String pattern = "yyyy-MM-dd";

        dpDropOff.setPromptText(pattern.toLowerCase());

        dpDropOff.setConverter(new StringConverter<LocalDate>() {
             DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

             @Override 
             public String toString(LocalDate date) {
                 if (date != null) {
                     return dateFormatter.format(date);
                 } else {
                     return "";
                 }
             }

             @Override 
             public LocalDate fromString(String string) {
                 if (string != null && !string.isEmpty()) {
                     return LocalDate.parse(string, dateFormatter);
                 } else {
                     return null;
                 }
             }
         });
   }
    private void insertOrUpdate(String status, String pharm_co_name, String date, String quantity, String ssn, String phy_ssn, String drop_off_time, String pick_up_time, String trade_name)
    {
        
            boolean res= DataHelper.insertPrescription(status, pharm_co_name, date, quantity, ssn,phy_ssn, drop_off_time, pick_up_time, trade_name);
           if(res)
           {
                JOptionPane.showMessageDialog(null, "Successfully Inserted.");
                //txtSsn.setText("");
                //txtDropOffTime.setText("");
                //txtDropOffTime.setText("");
                txtQuantity.setText("");
                //txtDate.setText("");
                dpDate.setPromptText("yyyy/MM/dd");
                dpDropOff.setPromptText("yyyy-MM-dd");
                dpPickUp.setPromptText("yyyy-MM-dd");

               // initContractTable();
           }
           else
           {
                JOptionPane.showMessageDialog(null, "Insertion Failed.");
               
           }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        setDatePicker();
        setDatePickerForDropOff();
        setDatePickerForPickUp();
        populateHourAndMinute();
        loadData();
       // initUI();
        //initContractTable();
    }
    private void populateHourAndMinute()
    {
        for( int i=0 ;i<25;i++)
        {
            if(i<10)
                mHourList.add("0"+i);
            else
                mHourList.add(""+i);
        }
        for( int i=0 ;i<61;i++)
        {
            if(i<10)
                mMinList.add("0"+i);
            else
                mMinList.add(""+i);
        }
        
    }
   
   
     private int getCompanySelectionIndex(String text)
    {
        for(int i = 0; i< companyList.size();i++)
            if(companyList.get(i).equals(text))
                return  i;
        return -1;
    }
    
    private void loadData()
    {
        ArrayList<Contract> patientList= DataHelper.getContractList();
        data= FXCollections.observableArrayList(patientList);
       // companyList = FXCollections.observableArrayList(DataHelper.getCompanyIDList());
        tradeNameList = FXCollections.observableArrayList(DataHelper.getDrugTradeNameList());
        ssnList = FXCollections.observableArrayList(DataHelper.getPatientSSNList());
        phySnnList = FXCollections.observableArrayList(DataHelper.getPhySSNList());
        hourList = FXCollections.observableArrayList(mHourList);
        minList = FXCollections.observableArrayList(mMinList);
       // System.out.println("size: "+ tradeNameList.size());
       // comboBoxCompany.getItems().addAll(companyList);
        comboBoxTradeName.getItems().addAll(tradeNameList);
        comboBoxSsn.getItems().addAll(ssnList);
        comboBoxPhySsn.getItems().addAll(phySnnList);
        
        ArrayList<String> mStatusList=new ArrayList<>();
        mStatusList.add("canceled");
        mStatusList.add("pending");
        mStatusList.add("ready");
        mStatusList.add("completed");
        
        statusList= FXCollections.observableArrayList(mStatusList);
        comboBoxStatus.getItems().addAll(statusList);
        
        comboDropHour.getItems().addAll(hourList);
        comboPickHour.getItems().addAll(hourList);
        comboPickMin.getItems().addAll(minList);
        comboDropMin.getItems().addAll(minList);
       
        

    }

  

}
