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
public class FXMLContractManagementController implements Initializable {

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
    TableView tableContract;

    private  ObservableList<Contract> data;

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
       System.out.println( "contract add clicked");
         Stage stage;
        Parent root;
        stage = (Stage) btnCompany.getScene().getWindow();
        //load up OTHER FXML document
        try {
             Constants.CURRENT_SELECTION = Constants.SELECTION_FLAG_ADD;
             Constants.CURRENT_SELECTED_CONTRACT = null;
             root = FXMLLoader.load(getClass().getResource("FXMLAddEditContractManagement.fxml"));
             Scene scene = new Scene(root,Constants.WINDOW_WIDTH,Constants.WINDOW_HEIGHT);

            stage.setTitle("Contract Management");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        } 
        
    }
    @FXML
    private void onContractEditClicked(Contract contract) {
        System.out.println( "contract edit clicked");
         Stage stage;
        Parent root;
        stage = (Stage) btnCompany.getScene().getWindow();
        //load up OTHER FXML document
        try {
             Constants.CURRENT_SELECTION = Constants.SELECTION_FLAG_EDIT;
             Constants.CURRENT_SELECTED_CONTRACT = contract;
             root = FXMLLoader.load(getClass().getResource("FXMLAddEditContractManagement.fxml"));
             Scene scene = new Scene(root,Constants.WINDOW_WIDTH,Constants.WINDOW_HEIGHT);

            stage.setTitle("Contract Management");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        initContractTable();
    }
    private void loadData()
    {
        ArrayList<Contract> patientList= DataHelper.getContractList();
        data= FXCollections.observableArrayList(patientList);
    }

    private void initContractTable() {
        loadData();
        int column_maxWidth = Constants.TABLE_WIDTH / 6;
        tableContract.setEditable(true);
        TableColumn pharm_id = new TableColumn("Pharmacy_id");
        TableColumn start_date = new TableColumn("Start Date");
        TableColumn end_date = new TableColumn("End Date");
        TableColumn text = new TableColumn("Text");
        TableColumn supervisor = new TableColumn("Supervisor");
        TableColumn pharm_co_name = new TableColumn("Company");


        TableColumn remove = new TableColumn("Remove");

        pharm_id.setPrefWidth(column_maxWidth);
        pharm_id.setCellValueFactory(
                new PropertyValueFactory<Doctor, String>("pharm_id"));
        // firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
       pharm_id.setCellFactory(TextFieldTableCell.forTableColumn());
       pharm_id.setOnEditCommit(
            new EventHandler<CellEditEvent<Contract, String>>() {
                @Override
                public void handle(CellEditEvent<Contract, String> t) {
                    System.out.println(t.getNewValue()+"  "+ t.getOldValue());
                    if( t.getNewValue().length() == 0)
                    {
                        initContractTable();
                      //  CommonUtils.showWarningDialog();
                  
                    }
                    else
                    {
                    ((Contract) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setPharm_id(t.getNewValue());
                    }
                }
            }
        );

        start_date.setPrefWidth(column_maxWidth);
        start_date.setCellValueFactory(
                new PropertyValueFactory<Contract, String>("start_date"));
        start_date.setCellFactory(TextFieldTableCell.forTableColumn());
        start_date.setOnEditCommit(
            new EventHandler<CellEditEvent<Contract, String>>() {
                @Override
                public void handle(CellEditEvent<Contract, String> t) {
                    ((Contract) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setStart_date(t.getNewValue());
                }
            }
        );

        end_date.setPrefWidth(column_maxWidth);
        end_date.setCellValueFactory(
                new PropertyValueFactory<Contract, String>("end_date"));
        end_date.setCellFactory(TextFieldTableCell.forTableColumn());
        end_date.setOnEditCommit(
            new EventHandler<CellEditEvent<Contract, String>>() {
                @Override
                public void handle(CellEditEvent<Contract, String> t) {
                    ((Contract) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setEnd_date(t.getNewValue());
                }
            }
        );
        supervisor.setCellValueFactory(
                new PropertyValueFactory<Contract, Integer>("supervisor"));
        supervisor.setPrefWidth(column_maxWidth);
        supervisor.setCellFactory(TextFieldTableCell.forTableColumn());
        supervisor.setOnEditCommit(
            new EventHandler<CellEditEvent<Contract, String>>() {
                @Override
                public void handle(CellEditEvent<Contract, String> t) {
                    ((Contract) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setSupervisor(t.getNewValue());
                }
            }
        );
        pharm_co_name.setCellValueFactory(
                new PropertyValueFactory<Contract, Integer>("pharm_co_name"));
        pharm_co_name.setPrefWidth(column_maxWidth);
        pharm_co_name.setCellFactory(TextFieldTableCell.forTableColumn());
        pharm_co_name.setOnEditCommit(
            new EventHandler<CellEditEvent<Contract, String>>() {
                @Override
                public void handle(CellEditEvent<Contract, String> t) {
                    ((Contract) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setPharm_co_name(t.getNewValue());
                }
            }
        );
        
        
        remove.setCellValueFactory(new PropertyValueFactory<Contract, String>("remove"));
        remove.setPrefWidth(column_maxWidth);
        text.setCellValueFactory(new PropertyValueFactory<Contract, String>("contract"));
        text.setPrefWidth(column_maxWidth);
        tableContract.setItems(data);

        tableContract.getColumns().addAll(pharm_id,start_date,end_date,supervisor,pharm_co_name,text,remove);

        tableContract.getSelectionModel().setCellSelectionEnabled(true);
        ObservableList selectedCells = tableContract.getSelectionModel().getSelectedCells();

        selectedCells.addListener(new ListChangeListener() {
            @Override
            public void onChanged(Change c) {
                TablePosition tablePosition = (TablePosition) selectedCells.get(0);
                Object val = tablePosition.getTableColumn().getCellData(tablePosition.getRow());
                int i = tableContract.getSelectionModel().getSelectedIndex();
                 System.out.println("Selected Value" + val );
                if (val.toString().equals("Remove")) {
                   String pharm_id= ((Contract) tableContract.getItems().get(i)).getPharm_id();
                    String pharm_co_name= ((Contract) tableContract.getItems().get(i)).getPharm_co_name();
                   // System.out.println(s);
                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialog_result = JOptionPane.showConfirmDialog(null, "Are you sure?");
                    if (dialog_result == 0) {
                         boolean res= DataHelper.deleteContract(pharm_id, pharm_co_name);
                       if(res)
                       {
                           JOptionPane.showMessageDialog(null, "Successfully Deleted.");
                           initContractTable();
                       }
                       else
                           JOptionPane.showMessageDialog(null, "Error in delete. Integrity Violated.");
                        System.out.println("Yes option");
                    } else {
                        System.out.println("No Option");
                    }
                }
                else if(val.toString().equals("Contract"))
                {
                   Contract contract= ((Contract) tableContract.getItems().get(i));
                    onContractEditClicked(contract);
                }
            }
        });
    }

}
