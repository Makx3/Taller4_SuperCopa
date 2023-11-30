package Model;

import java.util.List;

public class Team {
    private int id;
    private String pais;
    private int ranking;
    private List<Player> jugadores;
    private String rutaBandera;

    public Team(int id, String pais, int ranking, String rutaBandera, List<Player> jugadores) {
        this.id = id;
        this.pais = pais;
        this.ranking = ranking;
        this.rutaBandera = rutaBandera;
        this.jugadores = jugadores;
    }

    public String getPais() {
        return pais;
    }

    public int getRanking() {
        return ranking;
    }

    public String getRutaBandera() {
        return rutaBandera;
    }

    @Override
    public String toString() {
        return pais;
    }
}
