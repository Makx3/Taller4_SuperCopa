package Data;

import Model.Player;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataPlayer {
    private static final String RUTA_BASE = "/home/dci/Escritorio/Super_copa/src/main/java/Data/";

    public static List<Player> obtenerJugadores(String equipo) {
        List<Player> jugadores = new ArrayList<>();
        String rutaArchivo = RUTA_BASE + equipo.toLowerCase() + ".txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 3) {
                    int numero = Integer.parseInt(partes[0]);
                    String nombre = partes[1];
                    String posicion = partes[2];
                    jugadores.add(new Player(numero, nombre, posicion));
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return jugadores;
    }

    public static void guardarJugadores(String equipo, List<Player> jugadores) {
        String rutaArchivo = RUTA_BASE + equipo.toLowerCase() + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Player jugador : jugadores) {
                writer.write(String.format("%d;%s;%s\n", jugador.getNumero(), jugador.getNombre(), jugador.getPosicion()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
