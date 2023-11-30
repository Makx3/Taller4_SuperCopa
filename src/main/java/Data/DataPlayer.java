package Data;

import Model.Player;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataPlayer {
    public static List<Player> obtenerJugadores(String equipo) {
        List<Player> jugadores = new ArrayList<>();
        String rutaArchivo = "/home/dci/Escritorio/Super_copa/src/main/java/Data/" + equipo.toLowerCase() + ".txt";

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                int numero = Integer.parseInt(partes[0]);
                String nombre = partes[1];
                String posicion = partes[2];

                jugadores.add(new Player(numero, nombre, posicion));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jugadores;
    }
}
