package lk.kisal.RentalStore.GUI;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.DatePicker;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import lk.kisal.RentalStore.Database.Database;
import lk.kisal.RentalStore.Date.Schedule;
import lk.kisal.RentalStore.Manager.WestminsterVehicalRentalManager;
import lk.kisal.RentalStore.POJO.Customer;
import lk.kisal.RentalStore.POJO.Vehical;

import java.time.LocalDate;
import java.util.Date;

public class GUI extends Application {
    final DatePicker datePick = new DatePicker();
    final DatePicker dateDrop = new DatePicker();

    private ObservableList<Vehical> getItemsInDatabase(){
        ObservableList<Vehical> allItemDatabase = FXCollections.observableArrayList();
        allItemDatabase.addAll(WestminsterVehicalRentalManager.vehicalDetailsFromDatabase);
        return allItemDatabase;
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {

        HBox buttonBox = new HBox();
        Button searchButton = new Button("Search Vehicle");
        final Button displayButton = new Button("Display Vehicles");
        final Button buyButton= new Button("Book a Vehicle");
        final Button userLogin = new Button("Enter");

        primaryStage.setTitle("Vehicle store");
        VBox vBox = new VBox();
        vBox.setSpacing(12);
        vBox.setPadding(new Insets(20,10,10,30)); //margin
        Label searchItems = new Label("Search Vehicle");
        vBox.getChildren().add(searchItems);

        HBox searchBox = new HBox(new Label("Enter the vehicle plate number to search : "));
        searchBox .getAlignment();
        searchBox .setSpacing(60);
        final TextField searchNu = new TextField();
        searchBox .getChildren().add(searchNu);
        vBox.getChildren().add(searchBox );

        displayButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                primaryStage.setTitle("Vehicle display");
                TableView<Vehical> viewTable = new TableView<Vehical>();

                TableColumn<Vehical,String> plateNumCol = new TableColumn<>("PLATE NUMBER");
                TableColumn<Vehical, Double> rentCol = new TableColumn<>("RENT");
                TableColumn<Vehical,String> makeCol = new TableColumn<>("MAKE");
                TableColumn<Vehical,String> modelCol = new TableColumn<>("MODEL");
                TableColumn<Vehical,Integer> seatCapCol = new TableColumn<>("SEAT CAPACITY");
                TableColumn<Vehical,Integer> cylCapCol = new TableColumn<>("CYLINDER CAPACITY");
                TableColumn<Vehical,String> topSpeedCol = new TableColumn<>("TOP SPEED");
                TableColumn<Vehical,Boolean> vehAvaCol = new TableColumn<Vehical,Boolean>("VEHICLE AVAILABILITY");
                TableColumn<Vehical,Integer> milageCol = new TableColumn<Vehical,Integer>("MILAGE");
                TableColumn<Vehical,String> transmissionCol = new TableColumn<>("TRANSMISSION");
                TableColumn<Vehical,Integer> pickUpDateCol = new TableColumn<>("PICKUP DATE");
                TableColumn<Vehical,Integer> dropOffDateCol = new TableColumn<>("DROPOFF DATE");

                plateNumCol.setMinWidth(60);
                plateNumCol.setCellValueFactory(new PropertyValueFactory<>("plateNo"));

                rentCol.setMinWidth(60);
                rentCol.setCellValueFactory(new PropertyValueFactory<>("rent"));

                makeCol.setMinWidth(60);
                makeCol.setCellValueFactory(new PropertyValueFactory<>("make"));

                modelCol.setMinWidth(60);
                modelCol.setCellValueFactory(new PropertyValueFactory<>("model"));

                seatCapCol.setMinWidth(60);
                seatCapCol.setCellValueFactory(new PropertyValueFactory<>("seatCapacity"));

                cylCapCol.setMinWidth(60);
                cylCapCol.setCellValueFactory(new PropertyValueFactory<>("cylinderCapacity"));

                topSpeedCol.setMinWidth(60);
                topSpeedCol.setCellValueFactory(new PropertyValueFactory<>("topSpeed"));

                vehAvaCol.setCellValueFactory(new PropertyValueFactory<>("vehicalAvailability"));

                milageCol.setMinWidth(60);
                milageCol.setCellValueFactory(new PropertyValueFactory<>("milage"));

                transmissionCol.setMinWidth(60);
                transmissionCol.setCellValueFactory(new PropertyValueFactory<>("transmission"));

                pickUpDateCol.setMinWidth(60);
                pickUpDateCol.setCellValueFactory(new PropertyValueFactory<>("pickUpDate"));

                dropOffDateCol.setMinWidth(60);
                dropOffDateCol.setCellValueFactory(new PropertyValueFactory<>("dropOffDate"));

                viewTable.setItems(getItemsInDatabase());
                viewTable.getColumns().addAll(plateNumCol,rentCol,makeCol,modelCol,seatCapCol,cylCapCol,topSpeedCol,vehAvaCol,milageCol,transmissionCol,pickUpDateCol,dropOffDateCol);

                VBox vBox = new VBox();
                vBox.getChildren().addAll(viewTable);

                Scene scene = new Scene(vBox);
                primaryStage.setScene(new Scene(new BorderPane(viewTable), 1500, 400));
                primaryStage.show();
            }
        });

        buttonBox.getChildren().add(searchButton);
        buttonBox.getChildren().add(displayButton );
        buttonBox.getChildren().add(buyButton );
        vBox.getChildren().add(searchButton);
        vBox.getChildren().add(displayButton);
        vBox.getChildren().add(buyButton);

        Separator separator = new Separator();
        separator.setMaxWidth(10000);
        vBox.getChildren().add(separator);

        final Label plateNumber = new Label();
        final Label rent = new Label();
        final Label make = new Label();
        final Label model= new Label();
        final Label seatCapacity = new Label();
        final Label cylinderCapacity = new Label();
        final Label topSpeed = new Label();
        final Label vehicleAvailability = new Label();
        final Label milage = new Label();
        final Label transmission = new Label();
        final Label pickUpDate = new Label();
        final Label dropOffDate= new Label();

        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                plateNumber.setText("Number doesnt exist");
                rent.setText("");
                make.setText("");
                model.setText("");
                seatCapacity.setText("");
                cylinderCapacity.setText("");
                topSpeed.setText("");
                vehicleAvailability.setText("");
                milage.setText("");
                transmission.setText("");
                pickUpDate.setText("");
                dropOffDate.setText("");
                String plNumSearch =searchNu.getText();
                for (Vehical veh : WestminsterVehicalRentalManager.vehicalDetailsFromDatabase) {
                    if (veh.getPlateNo().equals(plNumSearch)) {
                        if (veh.getPlateNo().equals(plNumSearch)) {
                            plateNumber.setText("Plate number:  " + veh.getPlateNo());
                            rent.setText("Rent: " + veh.getRent());
                            make.setText("Make: " + veh.getMake());
                            model.setText("Model:   " + veh.getModel());
                            seatCapacity.setText("Seat Capacity:    " + veh.getSeatCapacity());
                            cylinderCapacity.setText("Cylinder Capacity:    " + veh.getCylinderCapacity());
                            topSpeed.setText("Top Speed:   " + veh.getTopSpeed());
                            vehicleAvailability.setText("Vehicle Availability:   " + veh.isVehicalAvailability());
                            milage.setText("Milage:   " + veh.getMilage());
                            transmission.setText("Transmission:   " + veh.getTransmission());
                            pickUpDate.setText("Pick Up Date:   " + veh.getPickUpDate());
                            dropOffDate.setText("Drop Off Date:   " + veh.getDropOffDate());
                        }
                    }
                }
                }
        });
        buyButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Stage window =primaryStage;
                window.setTitle("Add customer details Vehicle");

                GridPane grid=new GridPane();
                grid.setAlignment(Pos.CENTER);
                grid.setHgap(10);
                grid.setVgap(10);
                grid.setPadding(new Insets(10));

                Text welcomeTxt= new Text("Welcome");
                welcomeTxt.setFont(Font.font("Tahoma", FontWeight.LIGHT,25));
                grid.add(welcomeTxt,0,0);

                Label nameBook= new Label("Enter name");
                grid.add(nameBook,0,1);

                TextField txtName= new TextField();
                txtName.setPromptText("Full name");
                grid.add(txtName,1,1);

                Label txtData= new Label();
                txtData.setFont(Font.font("Tahoma", FontWeight.LIGHT,15));
                txtData.setText("");
                grid.add(txtData,2,1);

                Label emailBook= new Label("Enter email");
                grid.add(emailBook,0,2);

                TextField txtEmail= new TextField();
                txtEmail.setPromptText("Email");
                grid.add(txtEmail,1,2);

                Label nicBook= new Label("Enter NIC");
                grid.add(nicBook,0,3);

                TextField txtNic= new TextField();
                txtNic.setPromptText("NIC");
                grid.add(txtNic,1,3);


                grid.add(userLogin,1,4);




                userLogin.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                        if (!(txtName.getText().isEmpty()|| txtEmail.getText().isEmpty() || txtNic.getText().isEmpty()) ){
                            String txtNameA = txtName.getText();
                            String txtEmailA = txtEmail.getText();
                            String txtNicA = txtNic.getText();

                            Customer cus = new Customer(txtNameA, txtEmailA, txtNicA);
                            Customer.customerDetails.add(cus);

                            System.out.println("Customer details are added");

                            Stage windowN = primaryStage;
                            windowN.setTitle("Book a Vehicle");

                            GridPane gridN = new GridPane();
                            gridN.setAlignment(Pos.CENTER);
                            gridN.setHgap(10);
                            gridN.setVgap(10);
                            gridN.setPadding(new Insets(10));

                            Text welcomeTxt = new Text("Welcome");
                            welcomeTxt.setFont(Font.font("Tahoma", FontWeight.LIGHT, 25));
                            gridN.add(welcomeTxt, 0, 0);

                            Label plateNoBook = new Label("Enter plate number");
                            gridN.add(plateNoBook, 0, 1);

                            final TextField txtName = new TextField();
                            txtName.setPromptText("Plate number");
                            gridN.add(txtName, 1, 1);

                            Label txtPlateEx = new Label();
                            gridN.add(txtPlateEx, 2, 1);

                            Label pickUpDate = new Label("Enter pickUpDate");
                            gridN.add(pickUpDate, 0, 2);
                            gridN.add(datePick, 1, 2);
                            datePick.setPromptText("Pick up date");
                            datePick.setMaxWidth(300);
                            datePick.setStyle("-fx-font-size:20 ");


                            Label dropOffDate = new Label("Enter dropOffDate");
                            gridN.add(dropOffDate, 0, 3);
                            gridN.add(dateDrop, 1, 3);
                            dateDrop.setPromptText("Drop off date");
                            dateDrop.setMaxWidth(300);
                            dateDrop.setStyle("-fx-font-size:20 ");



                            Button buttonBook = new Button("Book");
                            gridN.add(buttonBook, 1, 4);



                            buttonBook.setOnAction(e->{
                                String plSearch =txtName.getText();
                                txtPlateEx.setStyle("-fx-text-fill: RED");
                                txtPlateEx.setText("There is no such vehicle");
                                for (Vehical veh : WestminsterVehicalRentalManager.vehicalDetailsFromDatabase) {
                                    if (veh.getPlateNo().equals(plSearch)) {
                                        if (veh.getPlateNo().equals(plSearch)) {
                                            txtName.setText(plSearch);
                                            txtPlateEx.setText("valid plate number");

                                            final LocalDate pickUpdate = datePick.getValue();

                                            final LocalDate dropOffdate = dateDrop.getValue();

                                            if (!((pickUpdate == null) || (dropOffDate == null))) {
                                                if (Schedule.checkVal(pickUpdate, dropOffdate) >= 0) {

                                                    txtPlateEx.setStyle("-fx-text-fill: RED");
                                                    txtPlateEx.setText("Incorrect dates");

                                                } else {
                                                    if (!Database.getAvailability(plSearch)) {
                                                        txtPlateEx.setStyle("-fx-text-fill: RED");
                                                        txtPlateEx.setText("Sorry the vehicle is not available at the moment");
                                                    }else {

                                                        new Schedule(pickUpdate, dropOffdate, plSearch);
                                                        primaryStage.close();
                                                    }
                                                }
                                            } else {
                                                txtPlateEx.setText("Add dates");
                                            }

                                        } else {
                                            txtPlateEx.setStyle("-fx-text-fill: RED");
                                            txtPlateEx.setText("There is no such vehicle");
                                        }
                                    }
                                }

                            });


                            Scene scene = new Scene(gridN,800,500);
                            windowN.setScene(scene);
                            windowN.show();
                        }else{
                            txtData.setStyle("-fx-text-fill: RED");
                            txtData.setText("Enter all the values");
                        }

                    }
                });


                Scene scene = new Scene(grid,800,500);
                window.setScene(scene);
                window.show();
            }
        });



        vBox.getChildren().addAll(plateNumber,rent,make,model,seatCapacity,cylinderCapacity,topSpeed,vehicleAvailability,milage,transmission,pickUpDate,dropOffDate);
        Separator separator1 = new Separator();
        separator1.setMaxWidth(5000);
        vBox.getChildren().add(separator1);


        primaryStage.setScene(new Scene( vBox, 800, 800));
        primaryStage.show();
    }


}
