package torneo.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Jugador {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idJugador;
	@Column
	private String nombre;
	@Column
	private String posicion;
	@ManyToOne
	@JoinColumn(name="Id_Equipo")
	private Equipo fichaje;
	public Jugador() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Jugador(String nombre, String posicion, Equipo fichaje) {
		super();
		this.nombre = nombre;
		this.posicion = posicion;
		this.fichaje = fichaje;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	public Equipo getFichaje() {
		return fichaje;
	}
	public void setFichaje(Equipo fichaje) {
		this.fichaje = fichaje;
	}
	public int getIdJugador() {
		return idJugador;
	}
	@Override
	public String toString() {
		return "Jugador [idJugador=" + idJugador + ", nombre=" + nombre + ", posicion=" + posicion + "]";
	}
	
	
	
	
}
