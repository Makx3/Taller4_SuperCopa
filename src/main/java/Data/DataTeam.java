package Data;

import Model.Team;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataTeam {
    public static List<Team> obtenerEquipos() {
        List<Team> equipos = new ArrayList<>();
        String rutaArchivo = "/home/dci/Escritorio/Super_copa/src/main/java/Data/teams.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                int id = Integer.parseInt(partes[0]);
                String pais = partes[1];
                int ranking = Integer.parseInt(partes[2]);
                String rutaBandera = partes[3];

                equipos.add(new Team(id, pais, ranking, rutaBandera, null));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return equipos;
    }
}
