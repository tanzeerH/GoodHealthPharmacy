/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goodhealthpharmacy;

import goodhealthpharmacy.database.DataHelper;
import goodhealthpharmacy.model.Doctor;
import goodhealthpharmacy.model.Patient;
import goodhealthpharmacy.utils.CommonUtils;
import goodhealthpharmacy.utils.Constants;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javax.swing.JOptionPane;

/**
 *
 * @author Tanzeer
 */
public class FXMLPatientManagementController implements Initializable {

    @FXML
    TextField txtSsn;
    @FXML
    TextField txtName;
    @FXML
    TextField txtAddress;
    @FXML
    DatePicker dpBirthDate;
    @FXML
    ComboBox comboBoxPryPhi;
    @FXML
    Button btnAdd;
    
    
    @FXML
    Button btnPatient;
    
    @FXML
    Button btnDocManage;
    
    @FXML
    Button btnPharmacy;
    
    @FXML
    Button btnCompany;
    
    @FXML
    Button btnDrug;
    
    @FXML
    Button btnContract;
    
    @FXML
    Button btnPrescription;


    @FXML
    TableView tableDoctor;

    private  ObservableList<Patient> data;
    private  ObservableList<String> phySnnList;

    @FXML
    private void handleButtonAction(ActionEvent event) {
       System.out.println(event.getSource()+"  patient clicked");
        Stage stage;
        Parent root;
        stage = (Stage) btnPatient.getScene().getWindow();
        //load up OTHER FXML document
        try {
             root = FXMLLoader.load(getClass().getResource("FXMLPatientManagement.fxml"));
             Scene scene = new Scene(root,Constants.WINDOW_WIDTH,Constants.WINDOW_HEIGHT);
            stage.setTitle("Patient Management");
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
        stage = (Stage) btnPatient.getScene().getWindow();
        //load up OTHER FXML document
        try {
             root = FXMLLoader.load(getClass().getResource("FXMLDoctorManagement.fxml"));
             Scene scene = new Scene(root,Constants.WINDOW_WIDTH,Constants.WINDOW_HEIGHT);
            stage.setTitle("Doctor Management");
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
        stage = (Stage) btnPatient.getScene().getWindow();
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
    private void onContractManage(ActionEvent event) {
     System.out.println(event.getSource()+"  contract clicked");
        Stage stage;
        Parent root;
        stage = (Stage) btnCompany.getScene().getWindow();
        //load up OTHER FXML document
        try {
             root = FXMLLoader.load(getClass().getResource("FXMLContractManagement.fxml"));
             Scene scene = new Scene(root,Constants.WINDOW_WIDTH,Constants.WINDOW_HEIGHT);

            stage.setTitle("Contract Management");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
      @FXML
    private void onPrescriptionManage(ActionEvent event) {
     System.out.println(event.getSource()+"  contract clicked");
        Stage stage;
        Parent root;
        stage = (Stage) btnCompany.getScene().getWindow();
        //load up OTHER FXML document
        try {
             root = FXMLLoader.load(getClass().getResource("FXMLPrescriptionManagement.fxml"));
             Scene scene = new Scene(root,Constants.WINDOW_WIDTH,Constants.WINDOW_HEIGHT);

            stage.setTitle("Prescription Management");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void handleAddButton(ActionEvent event) {
        System.out.println(event.getSource() + "  add clicked");
        if(txtSsn.getText().trim().length() == 0 || txtName.getText().trim().length() == 0 ||
                txtAddress.getText().trim().length() == 0  || dpBirthDate.getValue().toString().trim().length() == 0)
        {
            CommonUtils.showWarningDialog();
        }
        else  if( comboBoxPryPhi.getSelectionModel().getSelectedItem() == null )
        {
             CommonUtils.showNotSelectedWarningDialog();
        }
        else
        {
           String phy_ssn = comboBoxPryPhi.getSelectionModel().getSelectedItem().toString().trim().split(":")[0].trim();
           boolean res= DataHelper.insertPatient(txtSsn.getText(), txtName.getText(), txtAddress.getText(),dpBirthDate.getValue().toString().trim(),phy_ssn);
           if(res)
           {
                JOptionPane.showMessageDialog(null, "Successfully Inserted.");
                txtSsn.setText("");
                txtName.setText("");
                txtAddress.setText("");
               // dpBirthDate.setValue("Bir");
               // txtAge.setText("");
                comboBoxPryPhi.getSelectionModel().clearSelection();
                initPatientTable();
           }
           else
           {
                JOptionPane.showMessageDialog(null, "Insertion Failed.");
               
           }
        }
    }
     private void setDatePickerBirthDate()
   {
       String pattern = "yyyy/MM/dd";

        dpBirthDate.setPromptText(pattern.toLowerCase());

        dpBirthDate.setConverter(new StringConverter<LocalDate>() {
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        setDatePickerBirthDate();
        initPatientTable();
    }
    private void loadData()
    {
        ArrayList<Patient> patientList= DataHelper.getPatientList();
        data= FXCollections.observableArrayList(patientList);
        phySnnList = FXCollections.observableArrayList(DataHelper.getPhySSNList());
        comboBoxPryPhi.getItems().addAll(phySnnList);
    }

    private void initPatientTable() {
        loadData();
        int column_maxWidth = Constants.TABLE_WIDTH / 6;
        tableDoctor.setEditable(true);
        TableColumn ssn = new TableColumn("SSN");
        TableColumn name = new TableColumn("Name");
        TableColumn age = new TableColumn("Age");
        TableColumn address = new TableColumn("Address");
        TableColumn primary_phy = new TableColumn("Primary Physician");

        TableColumn remove = new TableColumn("Remove");

        ssn.setPrefWidth(column_maxWidth);
        ssn.setCellValueFactory(
                new PropertyValueFactory<Doctor, String>("ssn"));
        // firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
       ssn.setCellFactory(TextFieldTableCell.forTableColumn());
       ssn.setOnEditCommit(
            new EventHandler<CellEditEvent<Patient, String>>() {
                @Override
                public void handle(CellEditEvent<Patient, String> t) {
                    System.out.println(t.getNewValue()+"  "+ t.getOldValue());
                    if( t.getNewValue().length() == 0)
                    {
                        initPatientTable();
                      //  CommonUtils.showWarningDialog();
                  
                    }
                    else
                    {
                    ((Patient) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setSsn(t.getNewValue());
                    }
                }
            }
        );

        name.setPrefWidth(column_maxWidth);
        name.setCellValueFactory(
                new PropertyValueFactory<Patient, String>("name"));
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        name.setOnEditCommit(
            new EventHandler<CellEditEvent<Patient, String>>() {
                @Override
                public void handle(CellEditEvent<Patient, String> t) {
                    ((Patient) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setName(t.getNewValue());
                }
            }
        );

        age.setPrefWidth(column_maxWidth);
        age.setCellValueFactory(
                new PropertyValueFactory<Patient, String>("age"));
        age.setCellFactory(TextFieldTableCell.forTableColumn());
        age.setOnEditCommit(
            new EventHandler<CellEditEvent<Patient, String>>() {
                @Override
                public void handle(CellEditEvent<Patient, String> t) {
                    ((Patient) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setAge(t.getNewValue());
                }
            }
        );
        address.setCellValueFactory(
                new PropertyValueFactory<Patient, Integer>("address"));
        address.setPrefWidth(column_maxWidth);
        address.setCellFactory(TextFieldTableCell.forTableColumn());
        address.setOnEditCommit(
            new EventHandler<CellEditEvent<Patient, String>>() {
                @Override
                public void handle(CellEditEvent<Patient, String> t) {
                    ((Patient) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setAddress(t.getNewValue());
                }
            }
        );
        primary_phy.setCellValueFactory(
                new PropertyValueFactory<Patient, Integer>("pri_phy"));
        primary_phy.setPrefWidth(column_maxWidth);
        primary_phy.setCellFactory(TextFieldTableCell.forTableColumn());
        primary_phy.setOnEditCommit(
            new EventHandler<CellEditEvent<Patient, String>>() {
                @Override
                public void handle(CellEditEvent<Patient, String> t) {
                    ((Patient) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setPri_phy(t.getNewValue());
                }
            }
        );
        
        
        remove.setCellValueFactory(new PropertyValueFactory<Patient, String>("remove"));
        remove.setPrefWidth(column_maxWidth);
        tableDoctor.setItems(data);

        tableDoctor.getColumns().addAll(ssn, name, age, address, primary_phy,remove);

        tableDoctor.getSelectionModel().setCellSelectionEnabled(true);
        ObservableList selectedCells = tableDoctor.getSelectionModel().getSelectedCells();

        selectedCells.addListener(new ListChangeListener() {
            @Override
            public void onChanged(Change c) {
                TablePosition tablePosition = (TablePosition) selectedCells.get(0);
                Object val = tablePosition.getTableColumn().getCellData(tablePosition.getRow());
                int i = tableDoctor.getSelectionModel().getSelectedIndex();
                // System.out.println("Selected Value" + val + "ssn "+ tableDoctor.getSelectionModel().getSelectedIndex());
                if (val.toString().equals("Remove")) {
                    String s = ((Patient) tableDoctor.getItems().get(i)).getSsn();
                    System.out.println(s);
                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialog_result = JOptionPane.showConfirmDialog(null, "Are you sure?");
                    if (dialog_result == 0) {
                        System.out.println("Yes option");
                    } else {
                        System.out.println("No Option");
                    }
                }

            }
        });
    }

}
