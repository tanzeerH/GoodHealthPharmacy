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
public class FXMLAddEditContractManagementController implements Initializable {

    @FXML
    ComboBox comboBoxPharmcy;
    @FXML
    ComboBox comboBoxCompany;
    @FXML 
    TextArea txtContractText;
    @FXML
    TextField txtName;
    @FXML
    TextField startDate;
    @FXML
    TextField endDate;
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
    private  ObservableList<String> pharmacyList;
    private  ObservableList<String> companyList;



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
        System.out.println(event.getSource() + "  add clicked" + comboBoxCompany.getSelectionModel().getSelectedItem());
        if( txtName.getText().trim().length() == 0 ||
                startDate.getText().trim().length() == 0 || endDate.getText().trim().length() == 0 || txtContractText.getText().trim().length() == 0)
        {
            CommonUtils.showWarningDialog();
        } 
        else if(comboBoxCompany.getSelectionModel().getSelectedItem() == null || comboBoxPharmcy.getSelectionModel().getSelectedItem() == null)
        {
             CommonUtils.showNotSelectedWarningDialog();
        }
        else if(txtContractText.getText().length()>4000)
        {
            CommonUtils.showNotSelectedWarningDialog();
        }
            
        else
        {
            String  pharm_id = comboBoxPharmcy.getSelectionModel().getSelectedItem().toString().split(":")[0].trim();
            String  pharm_co_name =  comboBoxCompany.getSelectionModel().getSelectedItem().toString().trim();
            String start_date = startDate.getText().toString().trim();
            String end_date=  endDate.getText().toString().trim();
            String supervisor = txtName.getText().toString().trim();
            String text = txtContractText.getText().toString().trim();
            insertOrUpdate(pharm_id, pharm_co_name, start_date, end_date, supervisor, text);
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
    private void insertOrUpdate(String pharm_id, String pharm_co_name, String start_date, String end_date, String supervisor, String text)
    {
        if(Constants.CURRENT_SELECTION == Constants.SELECTION_FLAG_EDIT)
        {
        boolean res= DataHelper.updateContract(pharm_id, pharm_co_name, start_date, end_date, supervisor, text,
                Constants.CURRENT_SELECTED_CONTRACT.getPharm_id(),Constants.CURRENT_SELECTED_CONTRACT.getPharm_co_name());
           if(res)
           {
                JOptionPane.showMessageDialog(null, "Successfully updated.");
                //txtSsn.setText("");
                

               // initContractTable();
           }
           else
           {
                JOptionPane.showMessageDialog(null, "Update Failed.");
               
           }
        }
        else
        {
             boolean res= DataHelper.insertContract(pharm_id, pharm_co_name, start_date, end_date, supervisor, text);
           if(res)
           {
                JOptionPane.showMessageDialog(null, "Successfully Inserted.");
                //txtSsn.setText("");
                txtName.setText("");
                txtContractText.setText("");
                startDate.setText("");
                endDate.setText("");

               // initContractTable();
           }
           else
           {
                JOptionPane.showMessageDialog(null, "Insertion Failed.");
               
           }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        loadData();
        initUI();
        //initContractTable();
    }
    private void initUI()
    {
        if( Constants.CURRENT_SELECTION ==  Constants.SELECTION_FLAG_EDIT && Constants.CURRENT_SELECTED_CONTRACT != null )
        {
            txtContractText.setText(Constants.CURRENT_SELECTED_CONTRACT.getText());
            startDate.setText(Constants.CURRENT_SELECTED_CONTRACT.getStart_date());
            endDate.setText(Constants.CURRENT_SELECTED_CONTRACT.getEnd_date());
            txtName.setText(Constants.CURRENT_SELECTED_CONTRACT.getSupervisor());
            
            comboBoxCompany.getSelectionModel().select(getCompanySelectionIndex(Constants.CURRENT_SELECTED_CONTRACT.getPharm_co_name()));
            comboBoxPharmcy.getSelectionModel().select(getPhrmacySelectionIndex(Constants.CURRENT_SELECTED_CONTRACT.getPharm_id()));


        }
    }
    private int getPhrmacySelectionIndex(String text)
    {
        for(int i = 0; i< pharmacyList.size();i++)
            if(pharmacyList.get(i).contains(text))
                return  i;
        return -1;
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
        companyList = FXCollections.observableArrayList(DataHelper.getCompanyIDList());
        pharmacyList = FXCollections.observableArrayList(DataHelper.getPharmacyIDList());
       // comboBoxPharmcy.getItems().addAll(pharmacyList);
        comboBoxCompany.getItems().addAll(companyList);
        

    }

  

}
