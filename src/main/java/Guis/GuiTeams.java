package Guis;

import Data.DataPlayer;
import Data.DataTeam;
import Model.Player;
import Model.Team;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GuiTeams {
    private JFrame frame;
    private JComboBox<Team> comboBoxTeams;
    private JLabel lblRanking;

    public GuiTeams() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));

        comboBoxTeams = new JComboBox<>();
        comboBoxTeams.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Team selectedTeam = (Team) comboBoxTeams.getSelectedItem();
                if (selectedTeam != null) {
                    lblRanking.setText("Ranking: " + selectedTeam.getRanking());
                }
            }
        });
        panel.add(comboBoxTeams, BorderLayout.NORTH);

        lblRanking = new JLabel("Ranking: ");
        panel.add(lblRanking, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        panel.add(buttonPanel, BorderLayout.SOUTH);

        JButton btnJugadores = new JButton("Jugadores");
        btnJugadores.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Team selectedTeam = (Team) comboBoxTeams.getSelectedItem();
                if (selectedTeam != null) {
                    List<Player> jugadores = DataPlayer.obtenerJugadores(selectedTeam.getPais());
                    GuiPlayer guiPlayer = new GuiPlayer(selectedTeam, jugadores);
                    guiPlayer.mostrarVentana();
                }
            }
        });
        buttonPanel.add(btnJugadores);

        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        buttonPanel.add(btnSalir);

        cargarEquipos();
    }

    private void cargarEquipos() {
        List<Team> equipos = DataTeam.obtenerEquipos();
        DefaultComboBoxModel<Team> model = new DefaultComboBoxModel<>(equipos.toArray(new Team[0]));
        comboBoxTeams.setModel(model);
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }
}
