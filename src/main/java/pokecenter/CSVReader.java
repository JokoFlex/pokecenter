package pokecenter;

import javafx.scene.control.Alert;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CSVReader {

    static String csvHeader = "";

    static ArrayList<Pokemon> read()
    {
        Path path = Paths.get(System.getProperty("user.dir"), "resources", "pokemon.csv");
        ArrayList<Pokemon> pokeList = new ArrayList<>();
        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            Alert al = new Alert(Alert.AlertType.ERROR, "Die Datei " + path.toString() + " konnte nicht gefunden werden");
            al.show();
        }

        csvHeader = lines.get(0);
        lines.remove(0);

        int i = 0;
        while(i < lines.size()-1)
        {
            if(lines.get(i).split(",")[0].equals(lines.get(i+1).split(",")[0]))
            {
                lines.remove(i+1);
            }
            else
            {
                i++;
            }
        }

        for (String line :
                lines) {
            line.replace(",,", ", ,");
            String[] parts = line.split(",");

            try
            {
                int newID = Integer.parseInt(parts[0]);
                String newName = parts[1];
                Type newType1 = Type.valueOf(parts[2].toUpperCase());
                Optional<Type> newType2;
                try {
                    newType2 = Optional.of(Type.valueOf(parts[3].toUpperCase()));
                }
                catch (Exception e)
                {
                    newType2 = Optional.empty();
                }
                int newTotal = Integer.parseInt(parts[4]);
                int newHP = Integer.parseInt(parts[5]);
                int newAttack = Integer.parseInt(parts[6]);
                int newDefense = Integer.parseInt(parts[7]);
                int newSPAttack = Integer.parseInt(parts[8]);
                int newSPDefence = Integer.parseInt(parts[9]);
                int newSpeed = Integer.parseInt(parts[10]);

                pokeList.add(new Pokemon(newID, newName, newType1, newType2, newTotal,newHP, newAttack, newDefense, newSPAttack, newSPDefence, newSpeed));
            }
            catch (Exception e)
            {
                Alert al = new Alert(Alert.AlertType.ERROR, "Die Zeile " + line + " konnte nicht gelesen werden");
                al.show();
                return pokeList;
            }
        }
        save(pokeList);
        return pokeList;
    }
    
    static void save(ArrayList<Pokemon> pokeList)
    {
        Path path = Paths.get(System.getProperty("user.dir"), "resources", "pokemon.csv");
        ArrayList<String> lines = new ArrayList<>();
        lines.add(csvHeader);

        for (Pokemon poke :
                pokeList) {
            lines.add(poke.toString());
        }

        try {
            Files.write(path, lines, Charset.forName("UTF-8"));
        } catch (IOException e) {
            Alert al = new Alert(Alert.AlertType.ERROR, "Sicherung fehlgeschlagen");
            al.show();
            return;
        }
    }

    public static void main(String[] args) {
        ArrayList<Pokemon> pokelist = CSVReader.read();

        for (Pokemon pokemon :
                pokelist) {
            System.out.println(pokemon.toString());
        }
    }
}
