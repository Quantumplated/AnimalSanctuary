import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Ali
 * @version 1.0
 */
public class AnimalSanctuary extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        VBox vbox1 = new VBox(new Text("Empty"));
        vbox1.setPadding(new Insets(65, 5, 5, 50));
        VBox vbox2 = new VBox(new Text("Empty"));
        vbox2.setPadding(new Insets(65, 5, 5, 50));
        VBox vbox3 = new VBox(new Text("Empty"));
        vbox3.setPadding(new Insets(65, 5, 5, 50));
        VBox vbox4 = new VBox(new Text("Empty"));
        vbox4.setPadding(new Insets(65, 5, 5, 50));
        VBox vbox5 = new VBox(new Text("Empty"));
        vbox5.setPadding(new Insets(65, 5, 5, 50));
        VBox vbox6 = new VBox(new Text("Empty"));
        vbox6.setPadding(new Insets(65, 5, 5, 50));

        Pane box1 = new Pane();
        box1.setStyle("-fx-background-color: white;");
        box1.getChildren().add(vbox1);
        box1.setPrefSize(150, 150);

        Pane box2 = new Pane();
        box2.setStyle("-fx-background-color: white;");
        box2.getChildren().add(vbox2);
        box2.setPrefSize(150, 150);
        Pane box3 = new Pane();
        box3.setStyle("-fx-background-color: white;");
        box3.getChildren().add(vbox3);
        box3.setPrefSize(150, 150);
        Pane box4 = new Pane();
        box4.setStyle("-fx-background-color: white;");
        box4.getChildren().add(vbox4);
        box4.setPrefSize(150, 150);
        Pane box5 = new Pane();
        box5.setStyle("-fx-background-color: white;");
        box5.getChildren().add(vbox5);
        box5.setPrefSize(150, 150);
        Pane box6 = new Pane();
        box6.setStyle("-fx-background-color: white;");
        box6.getChildren().add(vbox6);
        box6.setPrefSize(150, 150);

        grid.add(box1, 0, 0);
        grid.add(box2, 1, 0);
        grid.add(box3, 2, 0);
        grid.add(box4, 0, 1);
        grid.add(box5, 1, 1);
        grid.add(box6, 2, 1);

        grid.setHgap(10);
        grid.setVgap(10);

        Button button = new Button("OK");
        InnerShadow is = new InnerShadow();
        is.setOffsetX(4.0f);
        is.setOffsetY(4.0f);
        Text text = new Text("Animal Sanctuary");
        text.setEffect(is);

        GridPane.setHalignment(text, HPos.CENTER);
        grid.setAlignment(Pos.TOP_CENTER);
        text.setFont(Font.font("Verdana", 50));
        text.setFont(Font.font(null, FontWeight.BOLD, 80));
        text.setFill(Color.DARKGREEN);

        GridPane grid1 = new GridPane();
        grid1.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        grid1.setAlignment(Pos.CENTER);
        grid1.setPrefSize(300, 150);
        grid1.add(new Text("Enter name here"), 0, 0);
        TextField name = new TextField();
        name.setPromptText("Enter name here");
        grid1.add(name, 0, 1);
        grid1.add(new Text("Type health here:"), 1, 0);
        TextField health = new TextField();
        health.setPromptText("Enter health here");
        grid1.add(health, 1, 1);
        grid1.add(new Text("Pick animal type:"), 2, 0);
        Button addAnimal = new Button("Add Animal");
        grid1.add(addAnimal, 3, 0, 3, 3);

        ComboBox<Animal> comboBox = new ComboBox<Animal>();
        comboBox.setPromptText("Select Animal Type");
        for (Animal animal : Animal.values()) {
            comboBox.getItems().add(animal);
        }

        grid1.add(comboBox, 2, 1);

        grid1.setHgap(30);
        grid1.setVgap(20);

        // Button button1 = new Button("Cancel");
        BorderPane pane = new BorderPane(grid, text, null, grid1, null);
        BorderPane.setMargin(text, new Insets(40, 0, 30, 0));
        BorderPane.setAlignment(text, Pos.CENTER);

        Image image = new Image("animalImage.jpg");
        ImageView imageView = new ImageView(image);
        StackPane background = new StackPane();
        background.getChildren().addAll(imageView, pane);

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Health Incorrect");
        alert.setHeaderText("Health was not between 1 and 5");
        alert.setContentText("Health set to 5");

        Spawn[] sanctuary = new Spawn[6];
        VBox[] vboxes = {vbox1, vbox2, vbox3, vbox4, vbox5, vbox6 };
        Pane[] panes = {box1, box2, box3, box4, box5, box6 };
        addAnimal.setOnAction(e -> {

            Animal comboBoxRec;
            String nameRec = name.getText();
            if (nameRec.equals("")) {
                nameRec = "No name yet";
            }
            System.out.println(nameRec);
            int healthRec;
            if (!health.getText().equals("") && Integer.parseInt(health.getText()) >= 1
                    && Integer.parseInt(health.getText()) <= 5) {
                healthRec = Integer.parseInt(health.getText());
                System.out.println(healthRec);
            } else if (health.getText().equals("")) {
                healthRec = 5;
                alert.setTitle("Health Incorrect");
                alert.setHeaderText("A number for health wasn't entered");
                alert.setContentText("Health set to 5");
                alert.showAndWait();
            } else {
                healthRec = 5;
                alert.showAndWait();
            }

            if (comboBox.getValue() != null) {
                comboBoxRec = comboBox.getValue();
                System.out.println(comboBoxRec.toString());
            } else {
                comboBoxRec = null;
                Alert error = new Alert(AlertType.ERROR);
                error.setTitle("No Selection found for animal");
                error.setContentText("You must select an animal");
                error.showAndWait();
            }

            boolean isFull = false;
            for (int i = 0; i < sanctuary.length; i++) {
                if ((sanctuary[i] != null) && (i == sanctuary.length - 1)) {
                    isFull = true;
                }
            }

            if (isFull) {
                Alert alert1 = new Alert(AlertType.INFORMATION);
                alert1.setTitle("Sanctuary Full!");
                alert1.setContentText("There is no more room!");
                alert1.showAndWait();
            } else {
                String h = Integer.toString(healthRec);
                for (int i = 0; i < sanctuary.length; i++) {
                    if (sanctuary[i] == null) {
                        sanctuary[i] = new Spawn(nameRec, healthRec, comboBoxRec);
                        vboxes[i].getChildren().clear();
                        vboxes[i].getChildren().addAll(new Text("Name: " + nameRec), new Text("Health: " + h),
                                new Text("Animal: " + comboBoxRec.toString()));
                        vboxes[i].setPadding(new Insets(20, 5, 5, 20));
                        panes[i].setStyle("-fx-background-color: green;");
                        break;
                    }
                }
            }

            for (int i = 0; i < sanctuary.length; i++) {
                if (sanctuary[i] != null) {
                    System.out.println(sanctuary[i].toString());
                }

            }

            name.clear();
            health.clear();
            comboBox.getSelectionModel().clearSelection();

        });

        vbox1.setOnMouseClicked((e) -> {
            vbox1.getChildren().clear();
            vbox1.getChildren().add(new Text("Empty"));
            vbox1.setPadding(new Insets(65, 5, 5, 50));
            box1.setStyle("-fx-background-color: white;");
            sanctuary[0] = null;
        });

        vbox2.setOnMouseClicked((e) -> {
            vbox2.getChildren().clear();
            vbox2.getChildren().add(new Text("Empty"));
            vbox2.setPadding(new Insets(65, 5, 5, 50));
            box2.setStyle("-fx-background-color: white;");
            sanctuary[1] = null;
        });

        vbox3.setOnMouseClicked((e) -> {
            vbox3.getChildren().clear();
            vbox3.getChildren().add(new Text("Empty"));
            vbox3.setPadding(new Insets(65, 5, 5, 50));
            box3.setStyle("-fx-background-color: white;");
            sanctuary[2] = null;
        });

        vbox4.setOnMouseClicked((e) -> {
            vbox4.getChildren().clear();
            vbox4.getChildren().add(new Text("Empty"));
            vbox4.setPadding(new Insets(65, 5, 5, 50));
            box4.setStyle("-fx-background-color: white;");
            sanctuary[3] = null;
        });

        vbox5.setOnMouseClicked((e) -> {
            vbox5.getChildren().clear();
            vbox5.getChildren().add(new Text("Empty"));
            vbox5.setPadding(new Insets(65, 5, 5, 50));
            box5.setStyle("-fx-background-color: white;");
            sanctuary[4] = null;
        });

        vbox6.setOnMouseClicked((e) -> {
            vbox6.getChildren().clear();
            vbox6.getChildren().add(new Text("Empty"));
            vbox6.setPadding(new Insets(65, 5, 5, 50));
            box6.setStyle("-fx-background-color: white;");
            sanctuary[5] = null;
        });

        // Set scene and stage.
        Scene scene = new Scene(background, 1000, 650);
        primaryStage.setTitle("My Animal Sanctuary");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * @author Ali
     * @version 1.0
     */
    public class Spawn {
        private String name;
        private int health;
        private Animal animal;

        /**
         * @param name   reps name.
         * @param health reps health.
         * @param animal reps animal.
         */
        public Spawn(String name, int health, Animal animal) {
            this.name = name;
            this.health = health;
            this.animal = animal;
        }

        @Override
        public String toString() {
            return "Spawn [name=" + name + ", health=" + health + ", animal=" + animal + "]";
        }

    }

    /**
     * @param args reps args.
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
}
