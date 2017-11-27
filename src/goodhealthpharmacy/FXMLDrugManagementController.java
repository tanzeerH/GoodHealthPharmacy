/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goodhealthpharmacy;

import goodhealthpharmacy.database.DataHelper;
import goodhealthpharmacy.model.Doctor;
import goodhealthpharmacy.model.Drug;
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
public class FXMLDrugManagementController implements Initializable {

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
    TableView tableDrug;
    @FXML
    Button btnShowSelective;
    @FXML
    Button btnShowAll;
    
    @FXML
    Button btnDrugSell;

    private  ObservableList<Drug> data;
    
    private int CURRENT_SELECTION = 1;
    private int FLAG_SHOW_ALL = 1;
    private int FLAG_SHOW_SELECTIVE = 2;

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
                initDrugTable();
           }
           else
           {
                JOptionPane.showMessageDialog(null, "Insertion Failed.");
               
           }
        }
    }
    @FXML
    private void onSelectiveShow(ActionEvent event) {
         System.out.println(event.getSource() + "  selective show clicked");
         CURRENT_SELECTION =  FLAG_SHOW_SELECTIVE;
         initDrugTable();
    }
     @FXML
    private void onAllShow(ActionEvent event) {
      System.out.println(event.getSource() + "  on all show clicked");
      CURRENT_SELECTION = FLAG_SHOW_ALL;
      initDrugTable();

    }
      @FXML
    private void onDrugSell(ActionEvent event) {
      System.out.println(event.getSource() + "  on drug sell clicked");
       Stage stage;
        Parent root;
        stage = (Stage) btnCompany.getScene().getWindow();
        //load up OTHER FXML document
        try {
             root = FXMLLoader.load(getClass().getResource("FXMLSellManagement.fxml"));
             Scene scene = new Scene(root,Constants.WINDOW_WIDTH,Constants.WINDOW_HEIGHT);

            stage.setTitle("Sell Management");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        initDrugTable();
    }
    private void loadData()
    {
        ArrayList<Drug> patientList;
        if(CURRENT_SELECTION == FLAG_SHOW_ALL)
        {
         patientList= DataHelper.getDrugList();
        data= FXCollections.observableArrayList(patientList);
        }
        else
        {
            patientList= DataHelper.getDrugsSoldByAllPharmacyList();
            data= FXCollections.observableArrayList(patientList);
        }
    }

    private void initDrugTable() {
        loadData();
        int column_maxWidth = Constants.TABLE_WIDTH / 4;
        tableDrug.setEditable(true);
        TableColumn tradeName = new TableColumn("trade_name");
        TableColumn pharm_co = new TableColumn("pharm_co_name");
        TableColumn formula = new TableColumn("formula");
        

        TableColumn remove = new TableColumn("Remove");

        tradeName.setPrefWidth(column_maxWidth);
        tradeName.setCellValueFactory(
                new PropertyValueFactory<Doctor, String>("trade_name"));
        // firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
       tradeName.setCellFactory(TextFieldTableCell.forTableColumn());
       tradeName.setOnEditCommit(
            new EventHandler<CellEditEvent<Drug, String>>() {
                @Override
                public void handle(CellEditEvent<Drug, String> t) {
                    System.out.println(t.getNewValue()+"  "+ t.getOldValue());
                    if( t.getNewValue().length() == 0)
                    {
                        initDrugTable();
                      //  CommonUtils.showWarningDialog();
                  
                    }
                    else
                    {
                    ((Drug) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setTrade_name(t.getNewValue());
                    }
                }
            }
        );

        pharm_co.setPrefWidth(column_maxWidth);
        pharm_co.setCellValueFactory(
                new PropertyValueFactory<Drug, String>("pharm_co_name"));
        pharm_co.setCellFactory(TextFieldTableCell.forTableColumn());
        pharm_co.setOnEditCommit(
            new EventHandler<CellEditEvent<Drug, String>>() {
                @Override
                public void handle(CellEditEvent<Drug, String> t) {
                    ((Drug) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setPharm_co_name(t.getNewValue());
                }
            }
        );

        formula.setPrefWidth(column_maxWidth);
        formula.setCellValueFactory(
                new PropertyValueFactory<Drug, String>("formula"));
        formula.setCellFactory(TextFieldTableCell.forTableColumn());
        formula.setOnEditCommit(
            new EventHandler<CellEditEvent<Drug, String>>() {
                @Override
                public void handle(CellEditEvent<Drug, String> t) {
                    ((Drug) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setFormula(t.getNewValue());
                }
            }
        );
        
        
        remove.setCellValueFactory(new PropertyValueFactory<Drug, String>("remove"));
        remove.setPrefWidth(column_maxWidth);
        tableDrug.setItems(data);
        if(tableDrug!= null)
            tableDrug.getColumns().clear();
        tableDrug.getColumns().addAll(tradeName, pharm_co, formula);

        tableDrug.getSelectionModel().setCellSelectionEnabled(true);
        ObservableList selectedCells = tableDrug.getSelectionModel().getSelectedCells();

        selectedCells.addListener(new ListChangeListener() {
            @Override
            public void onChanged(Change c) {
                TablePosition tablePosition = (TablePosition) selectedCells.get(0);
                Object val = tablePosition.getTableColumn().getCellData(tablePosition.getRow());
                int i = tableDrug.getSelectionModel().getSelectedIndex();
                // System.out.println("Selected Value" + val + "ssn "+ tableDrug.getSelectionModel().getSelectedIndex());
                if (val.toString().equals("Remove")) {
                   // String s = ((Drug) tableDrug.getItems().get(i)).getSsn();
                   // System.out.println(s);
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
