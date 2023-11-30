package Guis;

import Model.Player;
import Model.Team;
import Data.DataPlayer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GuiPlayer {
    private JFrame frame;
    private Team team;
    private List<Player> jugadores;
    private JTable table;
    private JButton btnEditarJugador;
    private JButton btnSalir;

    public GuiPlayer(Team team, List<Player> jugadores) {
        this.team = team;
        this.jugadores = jugadores;
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Número");
        model.addColumn("Nombre");
        model.addColumn("Posición");

        for (Player jugador : jugadores) {
            model.addRow(new Object[]{jugador.getNumero(), jugador.getNombre(), jugador.getPosicion()});
        }

        table = new JTable(model);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        btnEditarJugador = new JButton("Editar Jugador");
        btnEditarJugador.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editarJugador();
            }
        });
        panel.add(btnEditarJugador, BorderLayout.SOUTH);

        btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        panel.add(btnSalir, BorderLayout.NORTH);
    }

    private void editarJugador() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            int numero = (int) table.getValueAt(selectedRow, 0);
            String nombre = (String) table.getValueAt(selectedRow, 1);
            String posicion = (String) table.getValueAt(selectedRow, 2);

            String nuevoNombre = JOptionPane.showInputDialog(frame, "Nuevo nombre para el jugador:", nombre);
            String nuevaPosicion = (String) JOptionPane.showInputDialog(frame, "Nueva posición para el jugador:", "Posición",
                    JOptionPane.QUESTION_MESSAGE, null, new String[]{"GK", "DF", "MF", "FW"}, "GK");

            if (nuevoNombre != null && nuevaPosicion != null) {
                table.setValueAt(nuevoNombre, selectedRow, 1);
                table.setValueAt(nuevaPosicion, selectedRow, 2);

                for (Player jugador : jugadores) {
                    if (jugador.getNumero() == numero) {
                        jugador.setNombre(nuevoNombre);
                        jugador.setPosicion(nuevaPosicion);
                        break;
                    }
                }

                DataPlayer.guardarJugadores(team.getPais(), jugadores);
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Selecciona un jugador para editar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }
}
