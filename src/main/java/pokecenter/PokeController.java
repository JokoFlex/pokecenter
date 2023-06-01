package pokecenter;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.channels.Selector;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.TextStyle;
import java.util.*;

public class PokeController {

    public TableView pokeTable = new TableView();
    private int lowestHP = Integer.MAX_VALUE,
            highestHP = 0,
            lowestTotal = Integer.MAX_VALUE,
            highestTotal = 0,
            lowestAttack = Integer.MAX_VALUE,
            highestAttack = 0,
            lowestDefense = Integer.MAX_VALUE,
            highestDefense = 0,
            lowestSp_Attack = Integer.MAX_VALUE,
            highestSp_Attack = 0,
            lowestSp_Defense = Integer.MAX_VALUE,
            highestSp_Defense = 0,
            lowestSpeed = Integer.MAX_VALUE,
            highestSpeed = 0;

    public VBox initializeView() {
        fillPokeTable();
        VBox root = new VBox();
        pokeTable.setPrefHeight(550);

        // Table
        TableColumn<Pokemon, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory("id"));
        idCol.setResizable(false);
        idCol.setPrefWidth(40);
        pokeTable.getColumns().add(idCol);

        TableColumn<Pokemon, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory("name"));
        nameCol.setResizable(false);
        nameCol.setPrefWidth(183);
        pokeTable.getColumns().add(nameCol);

        TableColumn<Pokemon, String> type1Col = new TableColumn<>("Primärtyp");
        type1Col.setCellValueFactory(new PropertyValueFactory("type1"));
        type1Col.setResizable(false);
        type1Col.setPrefWidth(80);
        type1Col.setCellFactory(column -> {
            TableCell<Pokemon, String> cell = new TableCell<>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setGraphic(null);
                        setText(null);
                        setStyle("");
                    } else {
                        setText(null);

                        HBox hbox = new HBox();


                        Image img = null;
                        ImageView imgV;
                        try {
                            img = new Image(new FileInputStream(System.getProperty("user.dir") + "/resources/images/" + item.toLowerCase() + ".png"));
                            imgV = new ImageView(img);
                            imgV.setFitWidth(20);
                            imgV.setFitHeight(20);

                            hbox.getChildren().add(imgV);
                        } catch (FileNotFoundException e) {
                        }

                        Label label = new Label(item);
                        hbox.getChildren().add(label);

                        setGraphic(hbox);
                    }
                }
            };
            return cell;
        });
        pokeTable.getColumns().add(type1Col);

        TableColumn<Pokemon, String> type2Col = new TableColumn<>("Sekundärtyp");
        type2Col.setCellValueFactory(new PropertyValueFactory("type2"));
        type2Col.setResizable(false);
        type2Col.setPrefWidth(80);
        type2Col.setCellFactory(column -> {
            TableCell<Pokemon, String> cell = new TableCell<>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setGraphic(null);
                        setText(null);
                        setStyle("");
                    } else {
                        setText(null);

                        HBox hbox = new HBox();


                        Image img = null;
                        ImageView imgV;
                        try {
                            img = new Image(new FileInputStream(System.getProperty("user.dir") + "/resources/images/" + item.toLowerCase() + ".png"));
                            imgV = new ImageView(img);
                            imgV.setFitWidth(20);
                            imgV.setFitHeight(20);

                            hbox.getChildren().add(imgV);
                        } catch (FileNotFoundException e) {
                        }

                        Label label = new Label(item);
                        hbox.getChildren().add(label);

                        setGraphic(hbox);
                    }
                }
            };
            return cell;
        });
        pokeTable.getColumns().add(type2Col);

        TableColumn<Pokemon, Integer> totalCol = new TableColumn<>("Total");
        totalCol.setCellValueFactory(new PropertyValueFactory("total"));
        totalCol.setPrefWidth(60);
        totalCol.setResizable(false);
        totalCol.setCellFactory(column -> {
            TableCell<Pokemon, Integer> cell = new TableCell<>() {
                @Override
                protected void updateItem(Integer item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setGraphic(null);
                        setText(null);
                        setStyle("");
                    } else {
                        setText(null);

                        StackPane stackPane = new StackPane();
                        stackPane.setPrefSize(60, 20);
                        stackPane.setAlignment(Pos.CENTER_LEFT);

                        Rectangle rectangle = new Rectangle(((float) item - lowestTotal) / (highestTotal - lowestTotal) * 53.0, 20, Color.rgb(172, 164, 224));
                        stackPane.getChildren().add(rectangle);

                        String labelValue = String.valueOf(item);
                        Label label = new Label(labelValue);
                        stackPane.getChildren().add(label);

                        setGraphic(stackPane);
                    }
                }
            };
            return cell;
        });
        pokeTable.getColumns().add(totalCol);

        TableColumn<Pokemon, Integer> hpCol = new TableColumn<>("HP");
        hpCol.setCellValueFactory(new PropertyValueFactory("hp"));
        hpCol.setPrefWidth(60);
        hpCol.setResizable(false);
        hpCol.setCellFactory(column -> {
            TableCell<Pokemon, Integer> cell = new TableCell<>() {
                @Override
                protected void updateItem(Integer item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setGraphic(null);
                        setText(null);
                        setStyle("");
                    } else {
                        setText(null);

                        StackPane stackPane = new StackPane();
                        stackPane.setPrefSize(60, 20);
                        stackPane.setAlignment(Pos.CENTER_LEFT);

                        Rectangle rectangle = new Rectangle(((float) item - lowestHP) / (highestHP - lowestHP) * 53.0, 20, Color.rgb(235, 64, 52));
                        stackPane.getChildren().add(rectangle);

                        String labelValue = String.valueOf(item);
                        Label label = new Label(labelValue);
                        stackPane.getChildren().add(label);

                        setGraphic(stackPane);
                    }
                }
            };
            return cell;
        });
        pokeTable.getColumns().add(hpCol);

        TableColumn<Pokemon, Integer> attackCol = new TableColumn<>("Attack");
        attackCol.setCellValueFactory(new PropertyValueFactory<>("attack"));
        attackCol.setPrefWidth(60);
        attackCol.setResizable(false);
        attackCol.setCellFactory(column -> {
            TableCell<Pokemon, Integer> cell = new TableCell<>() {
                @Override
                protected void updateItem(Integer item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setGraphic(null);
                        setText(null);
                        setStyle("");
                    } else {
                        setText(null);

                        StackPane stackPane = new StackPane();
                        stackPane.setPrefSize(60, 20);
                        stackPane.setAlignment(Pos.CENTER_LEFT);

                        Rectangle rectangle = new Rectangle(((float) item - lowestAttack) / (highestAttack - lowestAttack) * 53.0, 20, Color.rgb(52, 235, 67));
                        stackPane.getChildren().add(rectangle);

                        String labelValue = String.valueOf(item);
                        Label label = new Label(labelValue);
                        stackPane.getChildren().add(label);

                        setGraphic(stackPane);
                    }
                }
            };
            return cell;
        });
        pokeTable.getColumns().add(attackCol);

        TableColumn<Pokemon, Integer> defenseCol = new TableColumn<>("Defense");
        defenseCol.setCellValueFactory(new PropertyValueFactory("defense"));
        defenseCol.setPrefWidth(60);
        defenseCol.setResizable(false);
        defenseCol.setCellFactory(column -> {
            TableCell<Pokemon, Integer> cell = new TableCell<>() {
                @Override
                protected void updateItem(Integer item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setGraphic(null);
                        setText(null);
                        setStyle("");
                    } else {
                        setText(null);

                        StackPane stackPane = new StackPane();
                        stackPane.setPrefSize(60, 20);
                        stackPane.setAlignment(Pos.CENTER_LEFT);

                        Rectangle rectangle = new Rectangle(((float) item - lowestDefense) / (highestDefense - lowestDefense) * 53.0, 20, Color.rgb(64, 162, 227));
                        stackPane.getChildren().add(rectangle);

                        String labelValue = String.valueOf(item);
                        Label label = new Label(labelValue);
                        stackPane.getChildren().add(label);

                        setGraphic(stackPane);
                    }
                }
            };
            return cell;
        });
        pokeTable.getColumns().add(defenseCol);

        TableColumn<Pokemon, Integer> sp_attackCol = new TableColumn<>("Sp. Attack");
        sp_attackCol.setCellValueFactory(new PropertyValueFactory("sp_attack"));
        sp_attackCol.setPrefWidth(60);
        sp_attackCol.setResizable(false);
        sp_attackCol.setCellFactory(column -> {
            TableCell<Pokemon, Integer> cell = new TableCell<>() {
                @Override
                protected void updateItem(Integer item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setGraphic(null);
                        setText(null);
                        setStyle("");
                    } else {
                        setText(null);

                        StackPane stackPane = new StackPane();
                        stackPane.setPrefSize(60, 20);
                        stackPane.setAlignment(Pos.CENTER_LEFT);

                        Rectangle rectangle = new Rectangle(((float) item - lowestSp_Attack) / (highestSp_Attack - lowestSp_Attack) * 53.0, 20, Color.rgb(229, 52, 235));
                        stackPane.getChildren().add(rectangle);

                        String labelValue = String.valueOf(item);
                        Label label = new Label(labelValue);
                        stackPane.getChildren().add(label);

                        setGraphic(stackPane);
                    }
                }
            };
            return cell;
        });
        pokeTable.getColumns().add(sp_attackCol);

        TableColumn<Pokemon, Integer> sp_defenseCol = new TableColumn<>("Sp. Defense");
        sp_defenseCol.setCellValueFactory(new PropertyValueFactory("sp_defense"));
        sp_attackCol.setPrefWidth(60);
        sp_defenseCol.setPrefWidth(60);
        sp_defenseCol.setResizable(false);
        sp_defenseCol.setCellFactory(column -> {
            TableCell<Pokemon, Integer> cell = new TableCell<>() {
                @Override
                protected void updateItem(Integer item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setGraphic(null);
                        setText(null);
                        setStyle("");
                    } else {
                        setText(null);

                        StackPane stackPane = new StackPane();
                        stackPane.setPrefSize(60, 20);
                        stackPane.setAlignment(Pos.CENTER_LEFT);

                        Rectangle rectangle = new Rectangle(((float) item - lowestSp_Defense) / (highestSp_Defense - lowestSp_Defense) * 53.0, 20, Color.rgb(159, 52, 235));
                        stackPane.getChildren().add(rectangle);

                        String labelValue = String.valueOf(item);
                        Label label = new Label(labelValue);
                        stackPane.getChildren().add(label);

                        setGraphic(stackPane);
                    }
                }
            };
            return cell;
        });
        pokeTable.getColumns().add(sp_defenseCol);

        TableColumn<Pokemon, Integer> speedCol = new TableColumn<>("Speed");
        speedCol.setCellValueFactory(new PropertyValueFactory("speed"));
        speedCol.setPrefWidth(60);
        speedCol.setResizable(false);
        speedCol.setCellFactory(column -> {
            TableCell<Pokemon, Integer> cell = new TableCell<>() {
                @Override
                protected void updateItem(Integer item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setGraphic(null);
                        setText(null);
                        setStyle("");
                    } else {
                        setText(null);

                        StackPane stackPane = new StackPane();
                        stackPane.setPrefSize(60, 20);
                        stackPane.setAlignment(Pos.CENTER_LEFT);

                        Rectangle rectangle = new Rectangle(((float) item - lowestSpeed) / (highestSpeed - lowestSpeed) * 53.0, 20, Color.rgb(52, 235, 229));
                        stackPane.getChildren().add(rectangle);

                        String labelValue = String.valueOf(item);
                        Label label = new Label(labelValue);
                        stackPane.getChildren().add(label);

                        setGraphic(stackPane);
                    }
                }
            };
            return cell;
        });
        pokeTable.getColumns().add(speedCol);

        pokeTable.setPlaceholder(new Label("Keine Pokemon verfügbar"));
        root.getChildren().add(pokeTable);

        // Other Menu

        HBox horiBox = new HBox();
        root.getChildren().add(horiBox);
        horiBox.setSpacing(3);

        TextField name = new TextField();
        name.setPrefWidth(100);
        name.setPromptText("Name");
        horiBox.getChildren().add(name);

        ComboBox<String> primarytype = new ComboBox<String>();
        primarytype.setPromptText("Primär Typ");
        for (Type type : Type.values()) {
            primarytype.getItems().add(type.toString().toLowerCase());
        }
        horiBox.getChildren().add(primarytype);


        ComboBox<String> secondarytype = new ComboBox<String>();
        secondarytype.setPromptText("Sekundär Typ");
        for (Type type : Type.values()) {
            secondarytype.getItems().add(type.toString().toLowerCase());
        }
        secondarytype.getItems().add("");
        horiBox.getChildren().add(secondarytype);


        TextField total = new TextField();
        total.setPrefWidth(50);
        total.setPromptText("total");
        horiBox.getChildren().add(total);

        TextField hp = new TextField();
        hp.setPrefWidth(50);
        hp.setPromptText("hp");
        horiBox.getChildren().add(hp);

        TextField attack = new TextField();
        attack.setPrefWidth(50);
        attack.setPromptText("attack");
        horiBox.getChildren().add(attack);

        TextField defense = new TextField();
        defense.setPromptText("defense");
        defense.setPrefWidth(50);
        horiBox.getChildren().add(defense);

        TextField spAtt = new TextField();
        spAtt.setPrefWidth(50);
        spAtt.setPromptText("special Att");
        horiBox.getChildren().add(spAtt);

        TextField spDf = new TextField();
        spDf.setPrefWidth(50);
        spDf.setPromptText("special Def");
        horiBox.getChildren().add(spDf);

        TextField speed = new TextField();
        speed.setPrefWidth(50);
        speed.setPromptText("speed");
        horiBox.getChildren().add(speed);

        Button addPoke = new Button();
        addPoke.setText("Add");
        horiBox.getChildren().add(addPoke);

        Button safeCh = new Button();
        safeCh.setText("Update");
        horiBox.getChildren().add(safeCh);

        //teams
        HBox horiBox1 = new HBox();
        root.getChildren().add(horiBox1);
        horiBox1.setPadding(new Insets(10, 0, 0, 0));
        horiBox1.setSpacing(5);

        ListView<String> teamList = new ListView<String>();
        teamList.setPrefWidth(300);
        teamList.setPrefHeight(200);
        horiBox1.getChildren().add(teamList);

        VBox vertBox = new VBox();
        horiBox1.getChildren().add(vertBox);
        vertBox.setSpacing(3);

        TextField teamName = new TextField();
        teamName.setPromptText("Teamname: ");
        teamName.setPrefWidth(520);
        vertBox.getChildren().add(teamName);


        GridPane teamGrid = new GridPane();
        for (int i = 0; i < 6; i++) {
            VBox vb = new VBox();
            vb.setPrefWidth(170);
            vb.setPrefHeight(30);
            Path p = Paths.get(System.getProperty("user.dir"), "resources", "images", "plus.png");
            ImageView imgV = new ImageView();
            imgV.setFitWidth(50);
            imgV.setFitHeight(50);
            try {
                InputStream input = new FileInputStream(p.toString());
                imgV.setImage(new Image(input));
            } catch (FileNotFoundException e) {
            }
            vb.getChildren().add(imgV);

            TextField pokemon = new TextField();
            vb.getChildren().add(pokemon);
            pokemon.setPromptText("Pokemon " + (i + 1) + ": ");
            teamGrid.add(vb, i % 3, i / 3, 1, 1);
        }
        vertBox.getChildren().add(teamGrid);

        Button selectPokeToAdd = new Button();
        selectPokeToAdd.setText("Start selecting Pokemon to add");
        selectPokeToAdd.setPrefWidth(825);
        root.getChildren().add(selectPokeToAdd);

        Button StopSelectPokeToAdd = new Button();
        StopSelectPokeToAdd.setText("Stop selecting Pokemon to add");
        StopSelectPokeToAdd.setDisable(true);
        StopSelectPokeToAdd.setPrefWidth(825);
        root.getChildren().add(StopSelectPokeToAdd);

        Button addTeam = new Button();
        addTeam.setText("Add Team to list");
        addTeam.setPrefWidth(825);
        root.getChildren().add(addTeam);

        Button safeTeam = new Button();
        safeTeam.setText("Safe Team Changes");
        safeTeam.setPrefWidth(825);
        root.getChildren().add(safeTeam);

        Button removeTeam = new Button();
        removeTeam.setText("Remove Team");
        removeTeam.setPrefWidth(825);
        root.getChildren().add(removeTeam);

        addPoke.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String selectedValue = secondarytype.getValue();
                Optional<Type> optionalSecondary;

                if (selectedValue.equals(""))
                    optionalSecondary = Optional.empty();
                else {
                    optionalSecondary = Optional.of(Type.valueOf(selectedValue.toUpperCase()));
                }

                int id = 899;

                Pokemon newPoke = new Pokemon(id, name.getText(), Type.valueOf(primarytype.getValue()), optionalSecondary, Integer.parseInt(total.getText()), Integer.parseInt(hp.getText()), Integer.parseInt(attack.getText()), Integer.parseInt(defense.getText()), Integer.parseInt(spAtt.getText()), Integer.parseInt(spDf.getText()), Integer.parseInt(speed.getText()));
                id += 1;
                pokeTable.getItems().add(newPoke);
            }
        });

        final int[] counter = {0};
        pokeTable.setRowFactory(tv -> {
            counter[0] = 0;
            TableRow<Pokemon> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (selectPokeToAdd.isDisabled()) {
                    Path p = Paths.get(System.getProperty("user.dir"), "resources" , "images", "pokemon", row.getItem().getId() + "_" + row.getItem().getName().replace(" ", "_") + ".png");
                    InputStream input = null;
                    try {
                        input = new FileInputStream(p.toString());
                    } catch (FileNotFoundException e) {}
                    ((TextField)((VBox) (teamGrid.getChildren().get(counter[0]))).getChildren().get(1)).setText(row.getItem().getName());
                    ((ImageView)((VBox) (teamGrid.getChildren().get(counter[0]))).getChildren().get(0)).setImage(new Image(input));
                    counter[0] = (counter[0]+1)%6;
                }
                Pokemon rowData = row.getItem();
                name.setText(rowData.getName());
                primarytype.setValue(rowData.getType1().toString().toLowerCase());
                secondarytype.setValue(rowData.getType2().toString().toLowerCase());
                total.setText(String.valueOf(rowData.getTotal()));
                hp.setText(String.valueOf(rowData.getHp()));
                attack.setText(String.valueOf(rowData.getAttack()));
                defense.setText(String.valueOf(rowData.getDefense()));
                spAtt.setText(String.valueOf(rowData.getSp_attack()));
                spDf.setText(String.valueOf(rowData.getSp_defense()));
                speed.setText(String.valueOf(rowData.getSpeed()));
            });
            return row;
        });

        safeCh.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pokemon selectedPoke = (Pokemon) pokeTable.getSelectionModel().getSelectedItem();
                selectedPoke.setName(name.getText());
                selectedPoke.setType1(Type.valueOf(primarytype.getValue().toUpperCase()));

                if (secondarytype.getValue().isEmpty())
                    selectedPoke.setType2(Optional.empty());
                else
                    selectedPoke.setType2(Optional.of(Type.valueOf(secondarytype.getValue().toUpperCase())));

                selectedPoke.setTotal(Integer.parseInt(total.getText()));
                selectedPoke.setHp(Integer.parseInt(hp.getText()));
                selectedPoke.setAttack(Integer.parseInt(attack.getText()));
                selectedPoke.setDefense(Integer.parseInt(defense.getText()));
                selectedPoke.setSp_attack(Integer.parseInt(spAtt.getText()));
                selectedPoke.setSp_defense(Integer.parseInt(spDf.getText()));
                selectedPoke.setSpeed(Integer.parseInt(speed.getText()));
                pokeTable.refresh();
            }
        });

        selectPokeToAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                selectPokeToAdd.setDisable(true);
                StopSelectPokeToAdd.setDisable(false);
            }
        });

        StopSelectPokeToAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                selectPokeToAdd.setDisable(false);
                StopSelectPokeToAdd.setDisable(true);
            }
        });

        addTeam.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String team = "";
                try {
                    if (teamName.getText().isEmpty())
                        throw new Exception();
                    team = teamName.getText() + ":";
                    for (int i = 0; i < teamGrid.getChildren().size(); i++) {
                        String name = ((TextField)((VBox) teamGrid.getChildren().get(i)).getChildren().get(1)).getText();
                        if (name.isEmpty()) {
                            throw new Exception();
                        }
                        team += name;
                        if (i < teamGrid.getChildren().size() - 1)
                            team += ",";
                    }

                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Please fill in all fields");
                    alert.showAndWait();
                    return;
                }
                teamList.getItems().add(team);

                teamName.setText("");
                for (Node obj :
                        teamGrid.getChildren()) {
                    ((TextField) obj).setText("");
                }

            }
        });

        teamList.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String selectedTeam = teamList.getSelectionModel().getSelectedItem();
                String[] team = selectedTeam.split(": ");
                String[] pokemon = team[1].split(", ");
                teamName.setText(team[0]);
                for (int i = 0; i < 6; i++) {
                    ((TextField) teamGrid.getChildren()).setText(pokemon[i]);
                }
            }
        });

        safeTeam.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String team = "";
                try {
                    if (teamName.getText().isEmpty())
                        throw new Exception();
                    team = teamName.getText() + ":";
                    for (int i = 0; i < teamGrid.getChildren().size(); i++) {
                        String name = ((TextField)((VBox) teamGrid.getChildren().get(i)).getChildren().get(1)).getText();
                        if (name.isEmpty()) {
                            throw new Exception();
                        }
                        team += name;
                        if (i < teamGrid.getChildren().size() - 1)
                            team += ",";
                    }

                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Please fill in all fields");
                    alert.showAndWait();
                    return;
                }

                teamList.getItems().remove(teamList.getSelectionModel().getSelectedItem());
                teamList.getItems().add(team);
                teamName.setText("");
                for (Node obj :
                        teamGrid.getChildren()) {
                    ((TextField)((VBox) obj).getChildren().get(1)).setText("");
                    Path p = Paths.get(System.getProperty("user.dir"), "resources", "images", "plus.png");
                    InputStream input = null;
                    try {
                        input = new FileInputStream(p.toString());
                        ((ImageView)((VBox) obj).getChildren().get(0)).setImage(new Image(input));
                    } catch (FileNotFoundException e) {
                    }
                }
            }
        });

        removeTeam.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                teamList.getItems().remove(teamList.getSelectionModel().getSelectedItem());
            }
        });


        return root;
    }

    public void fillPokeTable() {
        ArrayList<Pokemon> pokeList = CSVReader.read();
        pokeTable.getItems().addAll(pokeList);

        System.out.println(lowestAttack);
        for (Pokemon poke :
                pokeList) {
            if (poke.getHp() < lowestHP)
                lowestHP = poke.getHp() - 1;
            if (poke.getHp() > highestHP)
                highestHP = poke.getHp();

            if (poke.getTotal() < lowestTotal)
                lowestTotal = poke.getTotal() - 1;
            if (poke.getTotal() > highestTotal)
                highestTotal = poke.getTotal();

            if (poke.getAttack() < lowestAttack)
                lowestAttack = poke.getAttack() - 1;
            if (poke.getAttack() > highestAttack)
                highestAttack = poke.getAttack();

            if (poke.getDefense() < lowestDefense)
                lowestDefense = poke.getDefense() - 1;
            if (poke.getDefense() > highestDefense)
                highestDefense = poke.getDefense();

            if (poke.getSp_attack() < lowestSp_Attack)
                lowestSp_Attack = poke.getSp_attack() - 1;
            if (poke.getSp_attack() > highestSp_Attack)
                highestSp_Attack = poke.getSp_attack();

            if (poke.getSp_defense() < lowestSp_Defense)
                lowestSp_Defense = poke.getSp_defense() - 1;
            if (poke.getSp_defense() > highestSp_Defense)
                highestSp_Defense = poke.getSp_defense();

            if (poke.getSpeed() < lowestSpeed)
                lowestSpeed = poke.getSpeed() - 1;
            if (poke.getSpeed() > highestSpeed)
                highestSpeed = poke.getSpeed();

        }
    }
}