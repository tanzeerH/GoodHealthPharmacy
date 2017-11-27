/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goodhealthpharmacy;

import goodhealthpharmacy.database.DataHelper;
import goodhealthpharmacy.model.Pharmacy;
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
public class FXMLPharmacyManagementController implements Initializable {

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
    TableView tablePharmacy;

    private  ObservableList<Pharmacy> data;

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
      /*  System.out.println(event.getSource() + "  add clicked");
        if(txtSsn.getText().length() == 0 || txtName.getText().length() == 0 ||
                txtSpeciality.getText().length() == 0 || txtExp.getText().length() == 0)
        {
            CommonUtils.showWarningDialog();
        }
        else
        {
           boolean res= DataHelper.insertPharmacy(txtSsn.getText(), txtName.getText(), txtSpeciality.getText(), txtExp.getText());
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
        } */
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        initPatientTable();
    }
    private void loadData()
    {
        ArrayList<Pharmacy> docList= DataHelper.getPharmacyList();
        data= FXCollections.observableArrayList(docList);
    }

    private void initPatientTable() {
        loadData();
        int column_maxWidth = Constants.TABLE_WIDTH / 5;
        tablePharmacy.setEditable(true);
        TableColumn pharm_id = new TableColumn("Pharmacy_id");
        TableColumn name = new TableColumn("Name");
        TableColumn address = new TableColumn("Address");
        TableColumn phone = new TableColumn("Phone");
        TableColumn remove = new TableColumn("Remove");

        pharm_id.setPrefWidth(column_maxWidth);
        pharm_id.setCellValueFactory(
                new PropertyValueFactory<Pharmacy, String>("pharm_id"));
        // firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
       pharm_id.setCellFactory(TextFieldTableCell.forTableColumn());
       pharm_id.setOnEditCommit(
            new EventHandler<CellEditEvent<Pharmacy, String>>() {
                @Override
                public void handle(CellEditEvent<Pharmacy, String> t) {
                    System.out.println(t.getNewValue()+"  "+ t.getOldValue());
                    if( t.getNewValue().length() == 0)
                    {
                        initPatientTable();
                      //  CommonUtils.showWarningDialog();
                  
                    }
                    else
                    {
                    ((Pharmacy) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setPharm_id(t.getNewValue());
                    }
                }
            }
        );

        name.setPrefWidth(column_maxWidth);
        name.setCellValueFactory(
                new PropertyValueFactory<Pharmacy, String>("name"));
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        name.setOnEditCommit(
            new EventHandler<CellEditEvent<Pharmacy, String>>() {
                @Override
                public void handle(CellEditEvent<Pharmacy, String> t) {
                    ((Pharmacy) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setName(t.getNewValue());
                }
            }
        );

        address.setPrefWidth(column_maxWidth);
        address.setCellValueFactory(
                new PropertyValueFactory<Pharmacy, String>("address"));
        address.setCellFactory(TextFieldTableCell.forTableColumn());
        address.setOnEditCommit(
            new EventHandler<CellEditEvent<Pharmacy, String>>() {
                @Override
                public void handle(CellEditEvent<Pharmacy, String> t) {
                    ((Pharmacy) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setAddress(t.getNewValue());
                }
            }
        );
        phone.setCellValueFactory(
                new PropertyValueFactory<Pharmacy, Integer>("phone"));
        phone.setPrefWidth(column_maxWidth);
        phone.setCellFactory(TextFieldTableCell.forTableColumn());
        phone.setOnEditCommit(
            new EventHandler<CellEditEvent<Pharmacy, String>>() {
                @Override
                public void handle(CellEditEvent<Pharmacy, String> t) {
                    ((Pharmacy) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setPhone(t.getNewValue());
                }
            }
        );
        
        remove.setCellValueFactory(new PropertyValueFactory<Pharmacy, String>("remove"));
        remove.setPrefWidth(column_maxWidth);
        tablePharmacy.setItems(data);

        tablePharmacy.getColumns().addAll(pharm_id, name,address,phone);

        tablePharmacy.getSelectionModel().setCellSelectionEnabled(true);
        ObservableList selectedCells = tablePharmacy.getSelectionModel().getSelectedCells();

        selectedCells.addListener(new ListChangeListener() {
            @Override
            public void onChanged(Change c) {
                TablePosition tablePosition = (TablePosition) selectedCells.get(0);
                Object val = tablePosition.getTableColumn().getCellData(tablePosition.getRow());
                int i = tablePharmacy.getSelectionModel().getSelectedIndex();
                // System.out.println("Selected Value" + val + "ssn "+ tablePharmacy.getSelectionModel().getSelectedIndex());
                if (val.toString().equals("Remove")) {
                    //String s = ((Pharmacy) tablePharmacy.getItems().get(i)).getSsn();
                    //System.out.println(s);
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
