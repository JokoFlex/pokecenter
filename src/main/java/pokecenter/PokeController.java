package pokecenter;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

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


        // Table
        TableColumn<Pokemon, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory("id"));
        pokeTable.getColumns().add(idCol);

        TableColumn<Pokemon, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory("name"));
        pokeTable.getColumns().add(nameCol);

        TableColumn<Pokemon, String> type1Col = new TableColumn<>("Primärtyp");
        type1Col.setCellValueFactory(new PropertyValueFactory("type1"));
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
                        } catch (FileNotFoundException e) {}

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
                        } catch (FileNotFoundException e) {}

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

                        Rectangle rectangle = new Rectangle(((float) item - lowestTotal) / (highestTotal-lowestTotal) * 53.0, 20, Color.rgb(172, 164, 224));
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

                        Rectangle rectangle = new Rectangle(((float) item - lowestHP) / (highestHP-lowestHP) * 53.0, 20, Color.rgb(235, 64, 52));
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

                        Rectangle rectangle = new Rectangle(((float) item - lowestAttack) / (highestAttack-lowestAttack) * 53.0, 20, Color.rgb(52, 235, 67));
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

                        Rectangle rectangle = new Rectangle(((float) item - lowestDefense) / (highestDefense-lowestDefense) * 53.0, 20, Color.rgb(64, 162, 227));
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

                        Rectangle rectangle = new Rectangle(((float) item - lowestSp_Attack) / (highestSp_Attack-lowestSp_Attack) * 53.0, 20, Color.rgb(229, 52, 235));
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
        sp_defenseCol.setCellValueFactory(new PropertyValueFactory("sp_defense"));sp_attackCol.setPrefWidth(60);
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

                        Rectangle rectangle = new Rectangle(((float) item - lowestSp_Defense) / (highestSp_Defense-lowestSp_Defense) * 53.0, 20, Color.rgb(159, 52, 235));
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

                        Rectangle rectangle = new Rectangle(((float) item - lowestSpeed) / (highestSpeed-lowestSpeed) * 53.0, 20, Color.rgb(52, 235, 229));
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

        TableColumn<Pokemon, Integer> generationCol = new TableColumn<>("Gen.");
        generationCol.setCellValueFactory(new PropertyValueFactory("generation"));
        pokeTable.getColumns().add(generationCol);

        TableColumn<Pokemon, Boolean> legendaryCol = new TableColumn<>("Legendär");
        legendaryCol.setCellValueFactory(new PropertyValueFactory("legendary"));
        legendaryCol.setCellFactory(column -> {
            TableCell<Pokemon, Boolean> cell = new TableCell<>() {
                @Override
                protected void updateItem(Boolean item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null || !item) {
                        setGraphic(null);
                        setText(null);
                        setStyle("");
                    } else {
                        setText(null);

                        ImageView imgV = new ImageView();
                        try {
                            Image img = new Image(new FileInputStream(System.getProperty("user.dir") + "/resources/images/legendary.png"));
                            imgV = new ImageView(img);
                            imgV.setFitWidth(60);
                            imgV.setFitHeight(20);

                        } catch (FileNotFoundException e) {}

                        setGraphic(imgV);
                    }
                }
            };
            return cell;
        });
        pokeTable.getColumns().add(legendaryCol);


        pokeTable.setPlaceholder(new Label("Keine Pokemon verfügbar"));
        root.getChildren().add(pokeTable);

        // Other Menu



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

            System.out.println(poke.name.toLowerCase());
        }
    }
}