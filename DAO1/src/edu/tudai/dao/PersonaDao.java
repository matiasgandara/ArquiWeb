package edu.tudai.dao;

import edu.tudai.db.Persona;

public interface PersonaDao {
	public void insert(Persona persona);
	public void update(Persona persona);
	public void delete(int id);
	public void read(int id);
}
