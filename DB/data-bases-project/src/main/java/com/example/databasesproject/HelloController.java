package com.example.databasesproject;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;

import com.ibm.db2.jcc.am.SqlIntegrityConstraintViolationException;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;

public class HelloController {
    private DB2Connection conn;
    private String genre;
    private String movieName;
    private String director;
    private String branch;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnSearch;

    @FXML
    private TableView<Movie> tblMovies;

    @FXML
    private TableColumn<Movie, String> clmMovieName;

    @FXML
    private TableColumn<Movie, String> clmDirector;

    @FXML
    private TableColumn<Movie, String> clmGenre;

    @FXML
    private TableColumn<Movie, Integer> clmLength;

    @FXML
    private TableColumn<Movie, Integer> clmAvailable;

    @FXML
    private TextField lblDirector;

    @FXML
    private TextField lblMovieName;

    @FXML
    private MenuButton mbtnGenre;

    @FXML
    private MenuItem optAny;

    @FXML
    private MenuItem optAction;

    @FXML
    private MenuItem optComedy;

    @FXML
    private MenuItem optCrime;

    @FXML
    private MenuItem optHorror;

    @FXML
    private MenuItem optSciFi;
    @FXML
    private MenuItem optDrama;

    // SEARCH MOVIES PANE
    @FXML
    void btnSearchOnActionHandler(ActionEvent event) {
        clmMovieName.setCellValueFactory(new PropertyValueFactory<Movie, String>("name"));
        clmDirector.setCellValueFactory(new PropertyValueFactory<Movie, String>("director"));
        clmGenre.setCellValueFactory(new PropertyValueFactory<Movie, String>("genre"));
        clmLength.setCellValueFactory(new PropertyValueFactory<Movie, Integer>("length"));
        clmAvailable.setCellValueFactory(new PropertyValueFactory<Movie, Integer>("availableCopies"));

        ObservableList<Movie> moviesList = FXCollections.observableArrayList();

        String where = generateWhere();
        String sql = "SELECT m.name, m.director, m.genre, m.length, ai.availableCopies " + "FROM FN72072.movies AS m INNER JOIN FN72072.available_in AS ai on m.id = ai.movie " + "WHERE ai.videoLibrary = '" + branch + "'" + where;

        try {
            ResultSet resultSet = conn.select(sql);

            while (resultSet.next()) {
                Movie movie = new Movie(resultSet.getString("name"), resultSet.getString("director"), resultSet.getString("genre"), resultSet.getInt("length"), resultSet.getInt("availableCopies"));
                moviesList.add(movie);
            }
        } catch (SQLException sqle) {
            System.out.println("Error Code = " + sqle.getErrorCode());
            System.out.println("SQL state = " + sqle.getSQLState());
            System.out.println("Message = " + sqle.getMessage());
        }
        tblMovies.setItems(moviesList);
    }

    String generateWhere() {
        StringBuilder sql = new StringBuilder("");
        this.movieName = lblMovieName.getText().toUpperCase();
        this.director = lblDirector.getText().toUpperCase();

        if (this.movieName.length() >= 1) {
            //REGEXP ('(^| )test( |$)')
            sql.append(" AND UPPER(m.name) LIKE '%");
            sql.append(this.movieName);
            sql.append("%'");
        }
        if (this.director.length() >= 1) {
            sql.append(" AND UPPER(m.director) Like '%");
            sql.append(this.director);
            sql.append("%'");
        }
        if (this.genre != null) {
            sql.append(" AND UPPER(m.genre) = '");
            sql.append(this.genre);
            sql.append("'");
        }

        return sql.toString();
    }

    @FXML
    void optAnyOnActionHandler(ActionEvent event) {
        this.mbtnGenre.setText("Any Genre");
        this.genre = null;
    }

    @FXML
    void optActionOnActionHandler(ActionEvent event) {
        this.mbtnGenre.setText("Action");
        this.genre = "Action";
    }

    @FXML
    void optComedyOnActionHandler(ActionEvent event) {
        this.mbtnGenre.setText("Comedy");
        this.genre = "Comedy";
    }

    @FXML
    void optCrimeOnActionHandler(ActionEvent event) {
        this.mbtnGenre.setText("Crime");
        this.genre = "Crime";
    }

    @FXML
    void optHorrorOnActionHandler(ActionEvent event) {
        this.mbtnGenre.setText("Horror");
        this.genre = "Horror";
    }

    @FXML
    void optSciFiOnActionHandler(ActionEvent event) {
        this.mbtnGenre.setText("Science Fiction");
        this.genre = "Science fiction";
    }

    @FXML
    void optDramaOnActionHandler(ActionEvent event) {
        this.mbtnGenre.setText("Drama");
        this.genre = "Drama";
    }

    // ADD CLIENT PANE
    @FXML
    private Label lblStatusAdd;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    private Button btnAddClient;

    @FXML
    void btnAddClientOnActionHandler(ActionEvent event) {
        String fName = txtFirstName.getText();
        String lName = txtLastName.getText();
        String phone = txtPhoneNumber.getText();
        String email = txtEmail.getText();
        String emailCol = "";
        if (fName.length() == 0) {
            lblStatusAdd.setText("First name is required.");
            lblStatusAdd.setTextFill(Color.RED);
            return;
        }
        if (lName.length() == 0) {
            lblStatusAdd.setText("Last name is required.");
            lblStatusAdd.setTextFill(Color.RED);
            return;
        }
        if (!phone.matches("08[789]\\d{7}")) {
            lblStatusAdd.setText("Invalid phone number");
            lblStatusAdd.setTextFill(Color.RED);
            return;
        }

        if (email.length() != 0) {
            if (!email.matches("(\\w+[.]?-?)+@(\\w+-?)+[.][a-zA-Z]{2,4}")) {
                //invalid email format
                lblStatusAdd.setText("Invalid email");
                lblStatusAdd.setTextFill(Color.RED);
                return;
            }
            email = "'" + email + "'";
        } else {
            email = "NULL";
        }

        //capitalize first letters of names
        fName = fName.substring(0, 1).toUpperCase() + fName.substring(1).toLowerCase();
        lName = lName.substring(0, 1).toUpperCase() + lName.substring(1).toLowerCase();

        // query
        String sql = "INSERT INTO FN72072.clients(FIRSTNAME, LASTNAME, EMAIL, PHONE) VALUES('" + fName + "', '" + lName + "', " + email + ", '" + phone + "')";
        try {
            conn.insert(sql);
        } catch (SqlIntegrityConstraintViolationException s1) {
            //check if phone already exists in DB
            lblStatusAdd.setText("Phone number already exists.");
            lblStatusAdd.setTextFill(Color.RED);

            return;
        } catch (SQLException sqle) {
            System.out.println("Error Code = " + sqle.getErrorCode());
            System.out.println("SQL state = " + sqle.getSQLState());
            System.out.println("Message = " + sqle.getMessage());

            return;
        }

        lblStatusAdd.setText("Successfully inserted client.");
        lblStatusAdd.setTextFill(Color.GREEN);
    }


    // RENT OUT / RETURN
    @FXML
    private Button btnRent;

    @FXML
    private Button btnReturn;

    @FXML
    private Button btnSearchBorrow;

    @FXML
    private DatePicker cldReturnDate;

    @FXML
    private Label lblBorrower;

    @FXML
    private Label lblPrice;

    @FXML
    private Label lblRentStatus;

    @FXML
    private Label lblRentedMovie;

    @FXML
    private Label lblReturnStatus;

    @FXML
    private TextField txtBorrowId;

    @FXML
    private TextField txtClientPhone;

    @FXML
    private TextField txtEmployeeId;

    @FXML
    private TextField txtMovieToRent;

    @FXML
    private TextField txtPrice;

    @FXML
    public void btnReturnOnActionHandler(ActionEvent actionEvent) {
        String borrowId = txtBorrowId.getText();
        if (borrowId.length() == 0) {
            lblReturnStatus.setText("Enter borrow ID");
            lblReturnStatus.setTextFill(Color.RED);
            return;
        }

        int movieId = btnSearchBorrowOnActionHandler(actionEvent);
        // use cases handled by btnSearchBorrow
        if (movieId == -1) {
            return;
        }

        String sql = "UPDATE FN72072.BORROWS SET returned = 'TRUE' WHERE ID =" + borrowId;
        String query = "UPDATE FN72072.available_in SET availableCopies = availableCopies + 1 WHERE movie = " + movieId + " AND videoLibrary = '" + branch + "'";
        try {
            conn.insert(sql);
            conn.insert(query);

            lblReturnStatus.setText("Movie returned successfully");
            lblReturnStatus.setTextFill(Color.GREEN);
        } catch (SQLException sqle) {
            System.out.println("Error Code = " + sqle.getErrorCode());
            System.out.println("SQL state = " + sqle.getSQLState());
            System.out.println("Message = " + sqle.getMessage());
        }
    }

    @FXML
    public int btnSearchBorrowOnActionHandler(ActionEvent actionEvent) {
        int movieId;
        String borrowId = txtBorrowId.getText();
        if (borrowId.length() == 0) {
            lblReturnStatus.setText("Enter borrow ID");
            lblReturnStatus.setTextFill(Color.RED);
            return -1;
        }
        String sql = "SELECT client, price, movie, movieId, videoLibrary, returned FROM FN72072.detailed_borrows WHERE id = " + borrowId;

        try {
            ResultSet rs = conn.select(sql);
            while (rs.next()) {
                lblRentedMovie.setText("Movie: " + rs.getString("movie"));
                lblBorrower.setText("Client: " + rs.getString("client"));
                lblPrice.setText("Price: " + rs.getString("price"));

                if (rs.getString("returned").equals("TRUE")) {
                    lblReturnStatus.setText("Movie is already returned");
                    lblReturnStatus.setTextFill(Color.GREEN);
                    return -1;
                }

                if(!rs.getString("videoLibrary").trim().equals(branch)){
                    lblReturnStatus.setText("Movie is rented by a different video library");
                    lblReturnStatus.setTextFill(Color.RED);
                    return -1;
                }

                lblReturnStatus.setText("");
                return rs.getInt("movieId");
            }

            //if no such record exists
            lblReturnStatus.setText("Invalid borrow ID");
            lblReturnStatus.setTextFill(Color.RED);

        } catch (SQLException sqle) {
            System.out.println("Error Code = " + sqle.getErrorCode());
            System.out.println("SQL state = " + sqle.getSQLState());
            System.out.println("Message = " + sqle.getMessage());
        }
        return -1;
    }


    @FXML
    public void btnRentOnActionHandler(ActionEvent actionEvent) {
        int movieId = getMovieId();
        if (movieId == -1) {
            return;
        }

        String currDate = LocalDate.now().toString();
        LocalDate date = cldReturnDate.getValue();
        String returnDate;
        if (date == null) {
            lblRentStatus.setText("Please select return date");
            lblRentStatus.setTextFill(Color.RED);
            return;
        }
        returnDate = date.toString();

        int clientId = getClient();
        if (clientId == -1) {
            return;
        }

        int emplId = getEmpl();
        if (emplId == -1) {
            return;
        }

        double price = getPrice();
        if (price == -1) {
            return;
        }

        String sql = "INSERT INTO FN72072.borrows  (RENTDATE, RETURNDATE, PRICE, CLIENT, EMPLOYEE, VIDEOLIBRARY, MOVIE) " +
                "VALUES ('" + currDate + "',  '" + returnDate + "', " + price + ", " + clientId + ", " + emplId + ", '" + branch + "', " + movieId + ")";
        String query = "UPDATE FN72072.available_in SET availableCopies = availableCopies - 1 WHERE movie = " + movieId + " AND videoLibrary = '" + branch + "'";

        try {
            conn.insert(sql);
            conn.insert(query);

            lblRentStatus.setText("Movie rented successfully");
            lblRentStatus.setTextFill(Color.GREEN);

        } catch (SqlIntegrityConstraintViolationException s) {
            lblRentStatus.setText("Invalid data");
            lblRentStatus.setTextFill(Color.RED);
        } catch (SQLException sqle) {
            System.out.println("Error Code = " + sqle.getErrorCode());
            System.out.println("SQL state = " + sqle.getSQLState());
            System.out.println("Message = " + sqle.getMessage());
        }
    }

    private int getMovieId() {
        String movie = txtMovieToRent.getText();
        int movieId = -1;

        if (movie.length() == 0) {
            lblRentStatus.setText("Please choose a movie.");
            lblRentStatus.setTextFill(Color.RED);

            return -1;
        } else {
            String sql = "SELECT movieId, availableCopies FROM  FN72072.detailed_availability WHERE MovieName = '" + movie + "' AND videoLibrary = '" + branch + "'";
            try {
                ResultSet rs = conn.select(sql);

                while (rs.next()) {
                    movieId = rs.getInt("movieId");
                    int copiesLeft = rs.getInt("availableCopies");
                    if (copiesLeft == 0) {
                        lblRentStatus.setText("No copies of this movie are available for renting");
                        lblRentStatus.setTextFill(Color.RED);
                        return -1;
                    }
                    return movieId;
                }

                //if we don't enter loop movie doesn't exist
                lblRentStatus.setText("Movie does not exist");
                lblRentStatus.setTextFill(Color.RED);
                return -1;

            } catch (SQLException sqle) {
                System.out.println("Error Code = " + sqle.getErrorCode());
                System.out.println("SQL state = " + sqle.getSQLState());
                System.out.println("Message = " + sqle.getMessage());
            }
        }

        return -1;
    }

    private int getClient() {
        int clientId = -1;
        String clientPhone = txtClientPhone.getText();

        if (!clientPhone.matches("08[789]\\d{7}")) {
            lblStatusAdd.setText("Invalid phone number");
            lblStatusAdd.setTextFill(Color.RED);
            return -1;
        }

        String sql = "SELECT id FROM FN72072.clients WHERE phone = '" + clientPhone + "'";

        try {
            ResultSet rs = conn.select(sql);
            while (rs.next()) {
                clientId = rs.getInt("id");
                lblRentStatus.setText("");
                return clientId;
            }

            //no such phone exists
            lblRentStatus.setText("No client with such phone number exists");
            lblRentStatus.setTextFill(Color.RED);

        } catch (SQLException sqle) {
            System.out.println("Error Code = " + sqle.getErrorCode());
            System.out.println("SQL state = " + sqle.getSQLState());
            System.out.println("Message = " + sqle.getMessage());
        }

        return -1;
    }

    private int getEmpl() {
        if (txtEmployeeId.getText().length() == 0) {
            lblRentStatus.setText("Enter employee ID");
            lblRentStatus.setTextFill(Color.RED);
            return -1;
        }

        int emplId = Integer.parseInt(txtEmployeeId.getText());

        String sql = "SELECT id FROM FN72072.employees WHERE id=" + emplId + " AND videoLibrary = '" + branch + "' ";

        try {
            ResultSet rs = conn.select(sql);

            while (rs.next()) {
                emplId = rs.getInt("id");
                lblRentStatus.setText("");
                return emplId;
            }

            // no employee with such Id works in that branch
            lblRentStatus.setText("Invalid employee ID");
            lblRentStatus.setTextFill(Color.RED);
            return -1;
        } catch (SQLException sqle) {
            System.out.println("Error Code = " + sqle.getErrorCode());
            System.out.println("SQL state = " + sqle.getSQLState());
            System.out.println("Message = " + sqle.getMessage());
        }

        return -1;
    }

    private double getPrice() {
        double price;
        if (txtPrice.getText().length() == 0) {
            lblRentStatus.setText("Please enter a price");
            lblRentStatus.setTextFill(Color.RED);
            return -1;
        }

        price = Double.parseDouble(txtPrice.getText());
        if (price < 0) {
            lblRentStatus.setText("Please enter a valid price");
            lblRentStatus.setTextFill(Color.RED);
            return -1;
        }

        return price;
    }

    // add movie pane
    @FXML
    private TextField txtCopiesToAdd;

    @FXML
    private Label lblAddMovieError;

    @FXML
    private Button btnAddMovie;

    @FXML
    private TextField txtLengthToAdd;

    @FXML
    private TextField txtMovieToAdd;

    @FXML
    private TextField txtDirectorToAdd;

    @FXML
    private MenuButton mbtnGenreToAdd;

    @FXML
    private MenuItem optActionAdd;

    @FXML
    private MenuItem optComedyToAdd;

    @FXML
    private MenuItem optCrimeToAdd;

    @FXML
    private MenuItem optDramaToAdd;

    @FXML
    private MenuItem optHorrorToAdd;

    @FXML
    private MenuItem optSciFiToAdd;

    @FXML
    void btnAddMovieOnActionHandler(ActionEvent event) {
        if (!validateMovieToAdd()) {
            return;
        }
        String movie = txtMovieToAdd.getText();
        String director = txtDirectorToAdd.getText();
        String genre = mbtnGenreToAdd.getText();
        int length = Integer.parseInt(txtLengthToAdd.getText());
        int copies = Integer.parseInt(txtCopiesToAdd.getText());

        String sql = "INSERT INTO FN72072.movies (NAME, DIRECTOR, GENRE, LENGTH) " +
                "VALUES ('" + movie + "', '" + director + "', '" + genre + "', " + length + ")";

        String subQuery = "(SELECT id FROM FN72072.movies WHERE name ='" + movie + "')";

        String query = "INSERT INTO FN72072.AVAILABLE_IN (VIDEOLIBRARY, MOVIE, AVAILABLECOPIES)  " +
                "VALUES ('Sofia-Studentski grad', " + subQuery + ", " + copies + ")";

        try {
            conn.insert(sql);
        } catch (SqlIntegrityConstraintViolationException s) {
            //if already in
            lblAddMovieError.setText("Successfully inserted");
            lblAddMovieError.setTextFill(Color.GREEN);
        } catch (SQLException sqle) {
            System.out.println("Error 1Code = " + sqle.getErrorCode());
            System.out.println("SQL state = " + sqle.getSQLState());
            System.out.println("Message = " + sqle.getMessage());
        }

        try {
            conn.insert(query);
        } catch (SqlIntegrityConstraintViolationException s) {
            lblAddMovieError.setText("Movie is already in database");
            lblAddMovieError.setTextFill(Color.RED);

        } catch (SQLException sqle) {
            System.out.println("Error Code = " + sqle.getErrorCode());
            System.out.println("SQL state = " + sqle.getSQLState());
            System.out.println("Message = " + sqle.getMessage());
        }
    }

    private boolean validateMovieToAdd() {
        if (txtMovieToAdd.getText().length() == 0) {
            lblAddMovieError.setText("Specify movie name");
            lblAddMovieError.setTextFill(Color.RED);
            return false;
        }
        if (txtDirectorToAdd.getText().length() == 0) {
            lblAddMovieError.setText("Specify director name");
            lblAddMovieError.setTextFill(Color.RED);
            return false;
        }
        if (mbtnGenreToAdd.getText().equals("Genre")) {
            lblAddMovieError.setText("Specify movie genre");
            lblAddMovieError.setTextFill(Color.RED);
            return false;
        }

        if (txtLengthToAdd.getText().length() == 0) {
            lblAddMovieError.setText("Specify movie length");
            lblAddMovieError.setTextFill(Color.RED);
            return false;
        } else if (Integer.parseInt(txtLengthToAdd.getText()) <= 0) {
            lblAddMovieError.setText("Invalid movie length");
            lblAddMovieError.setTextFill(Color.RED);
            return false;
        }

        if (txtCopiesToAdd.getText().length() == 0) {
            lblAddMovieError.setText("Enter number of copies");
            lblAddMovieError.setTextFill(Color.RED);
            return false;
        } else if (Integer.parseInt(txtCopiesToAdd.getText()) <= 0) {
            lblAddMovieError.setText("Invalid number of copies");
            lblAddMovieError.setTextFill(Color.RED);
            return false;
        }
        return true;
    }

    @FXML
    String optActionAddOnActionHandler(ActionEvent event) {
        mbtnGenreToAdd.setText("Action");
        return "Action";
    }

    @FXML
    String optComedyToAddOnActionHandler(ActionEvent event) {
        mbtnGenreToAdd.setText("Comedy");
        return "Comedy";
    }

    @FXML
    String optCrimeToAddOnActionHandler(ActionEvent event) {
        mbtnGenreToAdd.setText("Crime");
        return "Crime";
    }

    @FXML
    String optDramaToAddOnActionHandler(ActionEvent event) {
        mbtnGenreToAdd.setText("Drama");
        return "Drama";
    }

    @FXML
    String optHorrorToAddOnActionHandler(ActionEvent event) {
        mbtnGenreToAdd.setText("Drama");
        return "Drama";
    }

    @FXML
    String optSciFiToAddOnActionHandler(ActionEvent event) {
        mbtnGenreToAdd.setText("Science Fiction");
        return "Science fiction";
    }

    private String prompt(){
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Prompt");
        dialog.setHeaderText("Enter video library you want to access.");

        String library = null;
        boolean invalid = true;

        //get all branches in a map
        String sql = "SELECT name FROM FN72072.video_libraries";
        Map<String, String> branches = new HashMap<String, String>();

        try {
           ResultSet rs = conn.select(sql);
           //fill hashmap with all branches
           while (rs.next()){
                String s = rs.getString("name");
                branches.put(s.trim().toUpperCase(), s);
           }
        }catch (SQLException sqle)
        {
            System.out.println("Error Code = " + sqle.getErrorCode());
            System.out.println("SQL state = " + sqle.getSQLState());
            System.out.println("Message = " + sqle.getMessage());
        }

        do {
            Optional<String> userInput = dialog.showAndWait();
            if (userInput.isPresent()) {
                library = userInput.get();

                if (branches.containsKey(library.trim().toUpperCase())){
                    return branches.get(library.trim().toUpperCase());
                }
                showWarningAlert();
            } else {
                invalid = false;

            }
        }while (invalid);

        return null;
    }
    private void showWarningAlert(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setContentText("Non existent video library name");
        alert.showAndWait();
    }


    @FXML
    void initialize() {
        conn = new DB2Connection();
        conn.openConnection();

        branch = prompt();
        if (branch == null){
            Platform.exit();
        }

        genre = null;
        movieName = null;
        director = null;

        // make past days unavailable
        cldReturnDate.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();

                setDisable(empty || date.compareTo(today) <= 0);
            }
        });
        assert btnAddClient != null : "fx:id=\"btnAddClient\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnAddMovie != null : "fx:id=\"btnAddMovie\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnRent != null : "fx:id=\"btnRent\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnReturn != null : "fx:id=\"btnReturn\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnSearch != null : "fx:id=\"btnSearch\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnSearchBorrow != null : "fx:id=\"btnSearchBorrow\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert cldReturnDate != null : "fx:id=\"cldReturnDate\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert clmAvailable != null : "fx:id=\"clmAvailable\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert clmDirector != null : "fx:id=\"clmDirector\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert clmGenre != null : "fx:id=\"clmGenre\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert clmLength != null : "fx:id=\"clmLength\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert clmMovieName != null : "fx:id=\"clmMovieName\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert lblAddMovieError != null : "fx:id=\"lblAddMovieError\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert lblBorrower != null : "fx:id=\"lblBorrower\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert lblDirector != null : "fx:id=\"lblDirector\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert lblMovieName != null : "fx:id=\"lblMovieName\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert lblPrice != null : "fx:id=\"lblPrice\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert lblRentStatus != null : "fx:id=\"lblRentStatus\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert lblRentedMovie != null : "fx:id=\"lblRentedMovie\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert lblReturnStatus != null : "fx:id=\"lblReturnStatus\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert lblStatusAdd != null : "fx:id=\"lblStatusAdd\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert mbtnGenre != null : "fx:id=\"mbtnGenre\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert mbtnGenreToAdd != null : "fx:id=\"mbtnGenreToAdd\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert optAction != null : "fx:id=\"optAction\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert optActionAdd != null : "fx:id=\"optActionAdd\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert optAny != null : "fx:id=\"optAny\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert optComedy != null : "fx:id=\"optComedy\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert optComedyToAdd != null : "fx:id=\"optComedyToAdd\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert optCrime != null : "fx:id=\"optCrime\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert optCrimeToAdd != null : "fx:id=\"optCrimeToAdd\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert optDrama != null : "fx:id=\"optDrama\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert optDramaToAdd != null : "fx:id=\"optDramaToAdd\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert optHorror != null : "fx:id=\"optHorror\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert optHorrorToAdd != null : "fx:id=\"optHorrorToAdd\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert optSciFi != null : "fx:id=\"optSciFi\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert optSciFiToAdd != null : "fx:id=\"optSciFiToAdd\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert tblMovies != null : "fx:id=\"tblMovies\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtBorrowId != null : "fx:id=\"txtBorrowId\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtClientPhone != null : "fx:id=\"txtClientPhone\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtCopiesToAdd != null : "fx:id=\"txtCopiesToAdd\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtDirectorToAdd != null : "fx:id=\"txtDirectorToAdd\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtEmail != null : "fx:id=\"txtEmail\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtEmployeeId != null : "fx:id=\"txtEmployeeId\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtFirstName != null : "fx:id=\"txtFirstName\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtLastName != null : "fx:id=\"txtLastName\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtLengthToAdd != null : "fx:id=\"txtLengthToAdd\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtMovieToAdd != null : "fx:id=\"txtMovieToAdd\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtMovieToRent != null : "fx:id=\"txtMovieToRent\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtPhoneNumber != null : "fx:id=\"txtPhoneNumber\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtPrice != null : "fx:id=\"txtPrice\" was not injected: check your FXML file 'hello-view.fxml'.";

    }


}
