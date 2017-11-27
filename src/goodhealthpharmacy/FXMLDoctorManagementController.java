/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goodhealthpharmacy;

import goodhealthpharmacy.database.DataHelper;
import goodhealthpharmacy.model.Doctor;
import goodhealthpharmacy.utils.CommonUtils;
import goodhealthpharmacy.utils.Constants;
import java.io.IOException;
import java.net.URL;
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
import javax.swing.JOptionPane;

/**
 *
 * @author Tanzeer
 */
public class FXMLDoctorManagementController implements Initializable {

    @FXML
    TextField txtSsn;
    @FXML
    TextField txtName;
    @FXML
    TextField txtSpeciality;
    @FXML
    TextField txtExp;
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

    private  ObservableList<Doctor> data;

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
    }  @FXML
    private void handleAddButton(ActionEvent event) {
        System.out.println(event.getSource() + "  add clicked");
        if(txtSsn.getText().length() == 0 || txtName.getText().length() == 0 ||
                txtSpeciality.getText().length() == 0 || txtExp.getText().length() == 0)
        {
            CommonUtils.showWarningDialog();
        }
        else
        {
           boolean res= DataHelper.insertDoctor(txtSsn.getText(), txtName.getText(), txtSpeciality.getText(), txtExp.getText());
           if(res)
           {
                JOptionPane.showMessageDialog(null, "Successfully Inserted.");
                txtSsn.setText("");
                txtName.setText("");
                txtSpeciality.setText("");
                txtExp.setText("");
                initPatientTable();
           }
           else
           {
                JOptionPane.showMessageDialog(null, "Insertion Failed.");
               
           }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        initPatientTable();
    }
    private void loadData()
    {
        ArrayList<Doctor> docList= DataHelper.getDoctorList();
        data= FXCollections.observableArrayList(docList);
    }

    private void initPatientTable() {
        loadData();
        int column_maxWidth = Constants.TABLE_WIDTH / 5;
        tableDoctor.setEditable(true);
        TableColumn ssn = new TableColumn("SSN");
        TableColumn name = new TableColumn("Name");
        TableColumn speciality = new TableColumn("Speciality");
        TableColumn year_of_experience = new TableColumn("Year of Experience");
        TableColumn remove = new TableColumn("Remove");

        ssn.setPrefWidth(column_maxWidth);
        ssn.setCellValueFactory(
                new PropertyValueFactory<Doctor, String>("ssn"));
        // firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
       ssn.setCellFactory(TextFieldTableCell.forTableColumn());
       ssn.setOnEditCommit(
            new EventHandler<CellEditEvent<Doctor, String>>() {
                @Override
                public void handle(CellEditEvent<Doctor, String> t) {
                    System.out.println(t.getNewValue()+"  "+ t.getOldValue());
                    if( t.getNewValue().length() == 0)
                    {
                        initPatientTable();
                      //  CommonUtils.showWarningDialog();
                  
                    }
                    else
                    {
                    ((Doctor) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setSsn(t.getNewValue());
                    }
                }
            }
        );

        name.setPrefWidth(column_maxWidth);
        name.setCellValueFactory(
                new PropertyValueFactory<Doctor, String>("name"));
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        name.setOnEditCommit(
            new EventHandler<CellEditEvent<Doctor, String>>() {
                @Override
                public void handle(CellEditEvent<Doctor, String> t) {
                    ((Doctor) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setName(t.getNewValue());
                }
            }
        );

        speciality.setPrefWidth(column_maxWidth);
        speciality.setCellValueFactory(
                new PropertyValueFactory<Doctor, String>("speciality"));
        speciality.setCellFactory(TextFieldTableCell.forTableColumn());
        speciality.setOnEditCommit(
            new EventHandler<CellEditEvent<Doctor, String>>() {
                @Override
                public void handle(CellEditEvent<Doctor, String> t) {
                    ((Doctor) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setSpeciality(t.getNewValue());
                }
            }
        );
        year_of_experience.setCellValueFactory(
                new PropertyValueFactory<Doctor, Integer>("year_of_experience"));
        year_of_experience.setPrefWidth(column_maxWidth);
        year_of_experience.setCellFactory(TextFieldTableCell.forTableColumn());
        year_of_experience.setOnEditCommit(
            new EventHandler<CellEditEvent<Doctor, String>>() {
                @Override
                public void handle(CellEditEvent<Doctor, String> t) {
                    ((Doctor) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setYear_of_experience(t.getNewValue());
                }
            }
        );
        
        remove.setCellValueFactory(new PropertyValueFactory<Doctor, String>("remove"));
        remove.setPrefWidth(column_maxWidth);
        tableDoctor.setItems(data);

        tableDoctor.getColumns().addAll(ssn, name, speciality, year_of_experience, remove);

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
                    String s = ((Doctor) tableDoctor.getItems().get(i)).getSsn();
                    System.out.println(s);
                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialog_result = JOptionPane.showConfirmDialog(null, "Are you sure?");
                    if (dialog_result == 0) {
                       boolean res= DataHelper.deleteDoctor(s);
                       if(res)
                       {
                           JOptionPane.showMessageDialog(null, "Successfully Deleted.");
                           initPatientTable();
                       }
                       else
                           JOptionPane.showMessageDialog(null, "Error in delete. Integrity Violated. Check Patient and Prescription table.");
                        System.out.println("Yes option");
                    } else {
                        System.out.println("No Option");
                    }
                }

            }
        });
    }

}
