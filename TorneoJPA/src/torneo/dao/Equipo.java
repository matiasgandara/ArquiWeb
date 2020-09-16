package torneo.dao;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Equipo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idTorneo;
	@OneToMany(fetch = FetchType.LAZY)
	private List<Jugador> titulares;
	@OneToMany(fetch = FetchType.LAZY)
	private List<Jugador> suplentes;
	@OneToOne
	@JoinColumn(name="Id_Tecnico")
	private Jugador tecnico;
	@Column
	private String patrocinante;
	@ManyToMany(mappedBy = "equipos")
	private List<Torneo> torneos;
	
	static int maxTitulares = 7;
	static int maxSuplentes = 3;
	
	
	public Equipo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Equipo(List<Jugador> titulares, List<Jugador> suplentes, Jugador tecnico, String patrocinante) {
		super();
		if (cumpleTitular(titulares)){
			this.titulares = titulares;
		}
		if (suplentes.size() <= maxSuplentes) {
			this.suplentes = suplentes;
		}
		this.tecnico = tecnico;
		this.patrocinante = patrocinante;
	}

	
	private boolean cumpleTitular(List<Jugador> titular) {
		if (titular.size() <= maxTitulares) {
			for (Jugador j: titular) {
				if (j.getPosicion() == "arquero") {
					return true;
				}
			}
		}
		return false;
	}
	
	
	
	public List<Jugador> getTitulares() {
		return titulares;
	}


	public void setTitulares(List<Jugador> titulares) {
		this.titulares = titulares;
	}


	public List<Jugador> getSuplentes() {
		return suplentes;
	}


	public void setSuplentes(List<Jugador> suplentes) {
		this.suplentes = suplentes;
	}


	public Jugador getTecnico() {
		return tecnico;
	}


	public void setTecnico(Jugador tecnico) {
		this.tecnico = tecnico;
	}


	public String getPatrocinante() {
		return patrocinante;
	}


	public void setPatrocinante(String patrocinante) {
		this.patrocinante = patrocinante;
	}


	public int getIdTorneo() {
		return idTorneo;
	}

	

	public List<Torneo> getTorneos() {
		return torneos;
	}


	public void setTorneos(List<Torneo> torneos) {
		this.torneos = torneos;
	}


	@Override
	public String toString() {
		return "Equipo [idTorneo=" + idTorneo + ", titulares=" + titulares + ", suplentes=" + suplentes + ", tecnico="
				+ tecnico + ", patrocinante=" + patrocinante + ", torneos=" + torneos + "]";
	}

	
}
