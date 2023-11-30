package Guis;

import Model.Player;
import Model.Team;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GuiPlayer {
    private JFrame frame;

    public GuiPlayer(Team team, List<Player> jugadores) {
        initialize(team, jugadores);
    }

    private void initialize(Team team, List<Player> jugadores) {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(0, 1, 0, 0));

        JLabel lblTeamName = new JLabel("Equipo: " + team.getPais());
        panel.add(lblTeamName);

        for (Player jugador : jugadores) {
            JLabel lblPlayer = new JLabel("Número: " + jugador.getNumero() + " | Nombre: " + jugador.getNombre() +
                    " | Posición: " + jugador.getPosicion());
            panel.add(lblPlayer);
        }
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }
}
