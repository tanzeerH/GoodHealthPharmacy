/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goodhealthpharmacy;

import goodhealthpharmacy.database.DataHelper;
import goodhealthpharmacy.model.Doctor;
import goodhealthpharmacy.model.Prescription;
import goodhealthpharmacy.utils.CommonUtils;
import goodhealthpharmacy.utils.Constants;
import java.awt.Dimension;
import java.awt.JobAttributes;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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
public class FXMLPrescriptionManagementController implements Initializable {

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
    Button btnShowAll;
    @FXML
    ComboBox comboPatient;
    @FXML
    ComboBox comboxByStatus;
    @FXML
    DatePicker dpBdate;
    @FXML
    Button btnSearch;
    @FXML
    TextField pName;
    
    
      
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
    TableView tablePrescription;

    private  ObservableList<Prescription> data;
    private  ObservableList<String> ssnList;
    private  ObservableList<String> statusList;
    private ArrayList<String> mStatusList= new ArrayList<>();


    
     private int CURRENT_SELECTION = 1;
    private int FLAG_SHOW_ALL = 1;
    private int FLAG_SHOW_BY_STATUS_PENDING = 3;
    private int FLAG_SHOW_BY_STATUS_COMPLETED_TODAY = 4;
    private int FLAG_SHOW_BY_STATUS_READY_TO_GO = 5;
    private int FLAG_SHOW_BY_PATIENT = 10;
    private int FLAG_SHOW_BY_SEARCH = 11;

    private int FLAG_SHOW_SELECTIVE = 2;
    private String currentPatient="";
    private String currentName="";
    private String currentBdate="";

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
       // System.out.println(event.getSource()+"  doctor clicked");
        Stage stage;
        Parent root;
        stage = (Stage) btnAdd.getScene().getWindow();
        //load up OTHER FXML document
        try {
             root = FXMLLoader.load(getClass().getResource("FXMLAddEditPrescriptionManagement.fxml"));
             Scene scene = new Scene(root,Constants.WINDOW_WIDTH,Constants.WINDOW_HEIGHT);
             
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
      
        
    }
    @FXML
    private void onShowAllClicked(ActionEvent event) {
        System.out.println(event.getSource() + "  show all clicked");
        CURRENT_SELECTION = FLAG_SHOW_ALL;
        initPrescriptionTable();
      
        
    }
     @FXML
    private void onSearchClicked(ActionEvent event) {
        System.out.println(event.getSource() + " on search clicked");
        CURRENT_SELECTION = FLAG_SHOW_BY_SEARCH;
       
        initPrescriptionTable();
      
        
    }
     private void setDateBdatePicker()
   {
       String pattern = "yyyy-MM-dd";

        dpBdate.setPromptText(pattern.toLowerCase());

        dpBdate.setConverter(new StringConverter<LocalDate>() {
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
    @FXML
    private void onPrescriptionEditClicked(Prescription contract) {
        System.out.println( "contract edit clicked");
         Stage stage;
        Parent root;
        stage = (Stage) btnCompany.getScene().getWindow();
        //load up OTHER FXML document
        try {
            // Constants.CURRENT_SELECTION = Constants.SELECTION_FLAG_EDIT;
            // Constants.CURRENT_SELECTED_CONTRACT = contract;
             root = FXMLLoader.load(getClass().getResource("FXMLAddEditPrescriptionManagement.fxml"));
             Scene scene = new Scene(root,Constants.WINDOW_WIDTH,Constants.WINDOW_HEIGHT);

            stage.setTitle("Prescription Management");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        initPrescriptionTable();
    }
    private void loadData()
    {
        ArrayList<Prescription> patientList=null;
        if(CURRENT_SELECTION == FLAG_SHOW_ALL)   
        {
            patientList=DataHelper.getPrescriptionList();
       
        }
        else if( CURRENT_SELECTION == FLAG_SHOW_BY_PATIENT){
            patientList=DataHelper.getPrescriptionListByPatient(currentPatient);
        }
        else if(CURRENT_SELECTION == FLAG_SHOW_BY_SEARCH)
        {
            currentBdate="";
            if(dpBdate.getValue()!= null)
                currentBdate=dpBdate.getValue().toString();
           
            currentName = pName.getText().toString();
             patientList=DataHelper.getPrescriptionListByPatientNameAndBirthDate(currentName,currentBdate);
        }
         else if(CURRENT_SELECTION == FLAG_SHOW_BY_STATUS_PENDING)
        {
           
             patientList=DataHelper.getPrescriptionListByPendingStatus();
        }
         else if(CURRENT_SELECTION == FLAG_SHOW_BY_STATUS_COMPLETED_TODAY)
        {
           
             patientList=DataHelper.getPrescriptionListByCompletedStatus(getTodaysDate());
        }
         else if(CURRENT_SELECTION == FLAG_SHOW_BY_STATUS_READY_TO_GO)
        {
           
             patientList=DataHelper.getPrescriptionListByReadyToGoStatus();
        }
        
            
        data= FXCollections.observableArrayList(patientList);
        comboPatient.getItems().clear();
         ssnList = FXCollections.observableArrayList(DataHelper.getPatientSSNList());
         comboPatient.getItems().addAll(ssnList);
         comboPatient.valueProperty().addListener(new ChangeListener<String>() {
        @Override 
        public void changed(ObservableValue ov, String t, String t1) {
          
            String ssn= comboPatient.getValue().toString().split(":")[0].trim();
            System.out.println(ssn);
            currentPatient=ssn;
            CURRENT_SELECTION = FLAG_SHOW_BY_PATIENT;
            initPrescriptionTable();
        }    
        });
      
        mStatusList.clear();
        mStatusList.add("Pending");
        mStatusList.add("Completed Today");
        mStatusList.add("Ready To Go");
        
        statusList = FXCollections.observableArrayList(mStatusList);
        if(comboxByStatus != null)
            comboxByStatus.getItems().clear();
        comboxByStatus.getItems().addAll(statusList);
        
        comboxByStatus.valueProperty().addListener(new ChangeListener<String>() {
        @Override 
        public void changed(ObservableValue ov, String t, String t1) {
          
            String status= comboxByStatus.getValue().toString();
            if(status.equals("Pending"))
            {
                CURRENT_SELECTION =FLAG_SHOW_BY_STATUS_PENDING;
            }
            else  if(status.equals("Completed Today"))
            {
                CURRENT_SELECTION =FLAG_SHOW_BY_STATUS_COMPLETED_TODAY;
            }
             else  if(status.equals("Ready To Go"))
            {
                CURRENT_SELECTION =FLAG_SHOW_BY_STATUS_READY_TO_GO;
            }
            System.out.println(status);
            initPrescriptionTable();
        }    
        });
    }

    private String getTodaysDate()
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String d=dateFormat.format(date);
        System.out.println(d);
        return d;
    }
    private void initPrescriptionTable() {
        setDateBdatePicker();
        loadData();
        int column_maxWidth = Constants.TABLE_WIDTH / 6;
        tablePrescription.setEditable(true);
        TableColumn pre_id = new TableColumn("Prescription ID");
        TableColumn status = new TableColumn("Status");
        TableColumn drop_off_time = new TableColumn("Drop Off Time");
        TableColumn pick_up_time = new TableColumn("Pick Up Time");
        TableColumn ssn = new TableColumn("SSN");
        TableColumn phy_ssn = new TableColumn("Doctor's SSN");
        
        TableColumn pre_date = new TableColumn("Prescription Date");
        TableColumn quantity = new TableColumn("Quantity");
        TableColumn trade_name = new TableColumn("Trade Name");
        TableColumn pharm_co_name = new TableColumn("Company Name");


        TableColumn remove = new TableColumn("Remove");

        pre_id.setPrefWidth(column_maxWidth);
        pre_id.setCellValueFactory(
                new PropertyValueFactory<Doctor, String>("pre_id"));
        // firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
       pre_id.setCellFactory(TextFieldTableCell.forTableColumn());
       pre_id.setOnEditCommit(
            new EventHandler<CellEditEvent<Prescription, String>>() {
                @Override
                public void handle(CellEditEvent<Prescription, String> t) {
                    System.out.println(t.getNewValue()+"  "+ t.getOldValue());
                    if( t.getNewValue().length() == 0)
                    {
                        initPrescriptionTable();
                      //  CommonUtils.showWarningDialog();
                  
                    }
                    else
                    {
                    ((Prescription) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setPre_id(t.getNewValue());
                    }
                }
            }
        );

        status.setPrefWidth(column_maxWidth);
        status.setCellValueFactory(
                new PropertyValueFactory<Prescription, String>("status"));
        status.setCellFactory(TextFieldTableCell.forTableColumn());
        status.setOnEditCommit(
            new EventHandler<CellEditEvent<Prescription, String>>() {
                @Override
                public void handle(CellEditEvent<Prescription, String> t) {
                    ((Prescription) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setStatus(t.getNewValue());
                }
            }
        );

        drop_off_time.setPrefWidth(column_maxWidth);
        drop_off_time.setCellValueFactory(
                new PropertyValueFactory<Prescription, String>("drop_off_time"));
        drop_off_time.setCellFactory(TextFieldTableCell.forTableColumn());
        drop_off_time.setOnEditCommit(
            new EventHandler<CellEditEvent<Prescription, String>>() {
                @Override
                public void handle(CellEditEvent<Prescription, String> t) {
                    ((Prescription) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setDrop_off_time(t.getNewValue());
                }
            }
        );
        pick_up_time.setCellValueFactory(
                new PropertyValueFactory<Prescription, Integer>("pick_up_time"));
        pick_up_time.setPrefWidth(column_maxWidth);
        pick_up_time.setCellFactory(TextFieldTableCell.forTableColumn());
        pick_up_time.setOnEditCommit(
            new EventHandler<CellEditEvent<Prescription, String>>() {
                @Override
                public void handle(CellEditEvent<Prescription, String> t) {
                    ((Prescription) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setPick_up_time(t.getNewValue());
                }
            }
        );
        pharm_co_name.setCellValueFactory(
                new PropertyValueFactory<Prescription, Integer>("pharm_co_name"));
        pharm_co_name.setPrefWidth(column_maxWidth);
        pharm_co_name.setCellFactory(TextFieldTableCell.forTableColumn());
        pharm_co_name.setOnEditCommit(
            new EventHandler<CellEditEvent<Prescription, String>>() {
                @Override
                public void handle(CellEditEvent<Prescription, String> t) {
                    ((Prescription) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setPharm_co_name(t.getNewValue());
                }
            }
        );
         ssn.setCellValueFactory(
                new PropertyValueFactory<Prescription, Integer>("ssn"));
        ssn.setPrefWidth(column_maxWidth);
        ssn.setCellFactory(TextFieldTableCell.forTableColumn());
        ssn.setOnEditCommit(
            new EventHandler<CellEditEvent<Prescription, String>>() {
                @Override
                public void handle(CellEditEvent<Prescription, String> t) {
                    ((Prescription) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setPharm_co_name(t.getNewValue());
                }
            }
        );
         phy_ssn.setCellValueFactory(
                new PropertyValueFactory<Prescription, Integer>("phy_ssn"));
        phy_ssn.setPrefWidth(column_maxWidth);
        phy_ssn.setCellFactory(TextFieldTableCell.forTableColumn());
        phy_ssn.setOnEditCommit(
            new EventHandler<CellEditEvent<Prescription, String>>() {
                @Override
                public void handle(CellEditEvent<Prescription, String> t) {
                    ((Prescription) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setPhy_ssn(t.getNewValue());
                }
            }
        );
        pre_date.setCellValueFactory(
                new PropertyValueFactory<Prescription, Integer>("pre_date"));
        pre_date.setPrefWidth(column_maxWidth);
        pre_date.setCellFactory(TextFieldTableCell.forTableColumn());
        pre_date.setOnEditCommit(
            new EventHandler<CellEditEvent<Prescription, String>>() {
                @Override
                public void handle(CellEditEvent<Prescription, String> t) {
                    ((Prescription) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setPre_date(t.getNewValue());
                }
            }
        );
         quantity.setCellValueFactory(
                new PropertyValueFactory<Prescription, Integer>("quantity"));
        quantity.setPrefWidth(column_maxWidth);
        quantity.setCellFactory(TextFieldTableCell.forTableColumn());
        quantity.setOnEditCommit(
            new EventHandler<CellEditEvent<Prescription, String>>() {
                @Override
                public void handle(CellEditEvent<Prescription, String> t) {
                    ((Prescription) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setQuantity(t.getNewValue());
                }
            }
        );
         trade_name.setCellValueFactory(
                new PropertyValueFactory<Prescription, Integer>("trade_name"));
        trade_name.setPrefWidth(column_maxWidth);
        trade_name.setCellFactory(TextFieldTableCell.forTableColumn());
        trade_name.setOnEditCommit(
            new EventHandler<CellEditEvent<Prescription, String>>() {
                @Override
                public void handle(CellEditEvent<Prescription, String> t) {
                    ((Prescription) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setTrade_name(t.getNewValue());
                }
            }
        );
        
        
        
        remove.setCellValueFactory(new PropertyValueFactory<Prescription, String>("remove"));
        remove.setPrefWidth(column_maxWidth);
       
        tablePrescription.setItems(data);
        tablePrescription.getColumns().clear();
        tablePrescription.getColumns().addAll(pre_id,status,drop_off_time,pick_up_time,ssn,phy_ssn,quantity,pre_date,trade_name,pharm_co_name,remove);

        tablePrescription.getSelectionModel().setCellSelectionEnabled(true);
        ObservableList selectedCells = tablePrescription.getSelectionModel().getSelectedCells();

        selectedCells.addListener(new ListChangeListener() {
            @Override
            public void onChanged(Change c) {
                TablePosition tablePosition = (TablePosition) selectedCells.get(0);
                Object val = tablePosition.getTableColumn().getCellData(tablePosition.getRow());
                int i = tablePrescription.getSelectionModel().getSelectedIndex();
                 System.out.println("Selected Value" + val );
                if (val.toString().equals("Remove")) {
                   String id = ((Prescription) tablePrescription.getItems().get(i)).getPre_id();
                   // System.out.println(s);
                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialog_result = JOptionPane.showConfirmDialog(null, "Are you sure?");
                    if (dialog_result == 0) {
                        System.out.println("Yes option");
                        DataHelper.deletePrescription(id);
                        initPrescriptionTable();
                    } else {
                        System.out.println("No Option");
                    }
                }
                else if(val.toString().equals("Prescription"))
                {
                   Prescription contract= ((Prescription) tablePrescription.getItems().get(i));
                    onPrescriptionEditClicked(contract);
                }
            }
        });
    }

}
