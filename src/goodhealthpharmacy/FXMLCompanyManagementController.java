/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goodhealthpharmacy;

import goodhealthpharmacy.database.DataHelper;
import goodhealthpharmacy.model.Company;
import goodhealthpharmacy.model.Company;
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
public class FXMLCompanyManagementController implements Initializable {

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
    Button btnCompany;
    
    @FXML
    Button btnDocManage;
    
    @FXML
    Button btnPharmacy;


    @FXML
    TableView tableCompany;
    @FXML
    Button btnShowSelective;
    @FXML
    Button btnShowAll;

    private  ObservableList<Company> data;

    @FXML
    private void handleButtonAction(ActionEvent event) {
       System.out.println(event.getSource()+"  patient clicked");
        Stage stage;
        Parent root;
        stage = (Stage) btnCompany.getScene().getWindow();
        //load up OTHER FXML document
        try {
             root = FXMLLoader.load(getClass().getResource("FXMLCompanyManagement.fxml"));
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
        stage = (Stage) btnCompany.getScene().getWindow();
        //load up OTHER FXML document
        try {
             root = FXMLLoader.load(getClass().getResource("FXMLCompanyManagement.fxml"));
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
        stage = (Stage) btnCompany.getScene().getWindow();
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
    private void handleAddButton(ActionEvent event) {
       /* System.out.println(event.getSource() + "  add clicked");
        if(txtSsn.getText().length() == 0 || txtName.getText().length() == 0 ||
                txtSpeciality.getText().length() == 0 || txtExp.getText().length() == 0)
        {
            CommonUtils.showWarningDialog();
        }
        else
        {
           boolean res= DataHelper.insertCompany(txtSsn.getText(), txtName.getText(), txtSpeciality.getText(), txtExp.getText());
           if(res)
           {
                JOptionPane.showMessageDialog(null, "Successfully Inserted.");
                txtSsn.setText("");
                txtName.setText("");
                txtSpeciality.setText("");
                txtExp.setText("");
                initCompanyTable();
           }
           else
           {
                JOptionPane.showMessageDialog(null, "Insertion Failed.");
               
           }
        } */
    }
      @FXML
    private void onSelectiveShow(ActionEvent event) {
         System.out.println(event.getSource() + "  selective show clicked");
    }
     @FXML
    private void onAllShow(ActionEvent event) {
      System.out.println(event.getSource() + "  on all show clicked");

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        initCompanyTable();
    }
    private void loadData()
    {
        ArrayList<Company> patientList= DataHelper.getCompanyList();
        data= FXCollections.observableArrayList(patientList);
    }

    private void initCompanyTable() {
        loadData();
        int column_maxWidth = Constants.TABLE_WIDTH / 2;
        tableCompany.setEditable(true);
        TableColumn name = new TableColumn("Name");
        TableColumn phone = new TableColumn("Phone");
        
        TableColumn remove = new TableColumn("Remove");

        
        name.setPrefWidth(column_maxWidth);
        name.setCellValueFactory(
                new PropertyValueFactory<Company, String>("name"));
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        name.setOnEditCommit(
            new EventHandler<CellEditEvent<Company, String>>() {
                @Override
                public void handle(CellEditEvent<Company, String> t) {
                    ((Company) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setName(t.getNewValue());
                }
            }
        );

        
        phone.setCellValueFactory(
                new PropertyValueFactory<Company, Integer>("phone"));
        phone.setPrefWidth(column_maxWidth);
        phone.setCellFactory(TextFieldTableCell.forTableColumn());
        phone.setOnEditCommit(
            new EventHandler<CellEditEvent<Company, String>>() {
                @Override
                public void handle(CellEditEvent<Company, String> t) {
                    ((Company) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setPhone(t.getNewValue());
                }
            }
        );
        
        
        remove.setCellValueFactory(new PropertyValueFactory<Company, String>("remove"));
        remove.setPrefWidth(column_maxWidth);
        tableCompany.setItems(data);

        tableCompany.getColumns().addAll(name,phone,remove);

        tableCompany.getSelectionModel().setCellSelectionEnabled(true);
        ObservableList selectedCells = tableCompany.getSelectionModel().getSelectedCells();

        selectedCells.addListener(new ListChangeListener() {
            @Override
            public void onChanged(Change c) {
                TablePosition tablePosition = (TablePosition) selectedCells.get(0);
                Object val = tablePosition.getTableColumn().getCellData(tablePosition.getRow());
                int i = tableCompany.getSelectionModel().getSelectedIndex();
                // System.out.println("Selected Value" + val + "ssn "+ tableCompany.getSelectionModel().getSelectedIndex());
                if (val.toString().equals("Remove")) {
                   // String s = ((Company) tableCompany.getItems().get(i)).getSsn();
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
