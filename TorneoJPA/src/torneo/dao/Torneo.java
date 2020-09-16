package torneo.dao;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Torneo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idTorneo;
	@Column
	private String nombre;
	@Column
	private int cantEquipos;
	@ManyToMany
	private List<Equipo> equipos;
	
	
	public Torneo(String nombre, int cantEquipos, List<Equipo> equipos) {
		super();
		this.nombre = nombre;
		this.cantEquipos = cantEquipos;
		this.equipos = equipos;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getCantEquipos() {
		return cantEquipos;
	}


	public void setCantEquipos(int cantEquipos) {
		this.cantEquipos = cantEquipos;
	}


	public List<Equipo> getEquipos() {
		return equipos;
	}


	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}


	public int getIdTorneo() {
		return idTorneo;
	}


	@Override
	public String toString() {
		return "Torneo [idTorneo=" + idTorneo + ", nombre=" + nombre + ", cantEquipos=" + cantEquipos + ", equipos="
				+ equipos + "]";
	}
	
	
}
