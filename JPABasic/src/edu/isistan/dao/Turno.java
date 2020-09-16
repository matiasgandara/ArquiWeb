package edu.isistan.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Turno {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private Timestamp fecha;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Persona> jugadores;

	public Turno() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Turno(Timestamp fecha, List<Persona> jugadores) {
		super();
		this.fecha = fecha;
		this.jugadores = jugadores;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public List<Persona> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Persona> jugadores) {
		this.jugadores = jugadores;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Turno [id=" + id + ", fecha=" + fecha + ", jugadores=" + jugadores + "]";
	}
	
	
}
