package org.controller.persona;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.dao.persona.DaoPersona;
import org.modelo.persona.Persona;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ControllerPersona implements Serializable{
private List<Persona>listPersonas;
private Persona persona;

public ControllerPersona() {
	persona= new Persona();
}

public List<Persona> getListPersonas() {
	DaoPersona dao = new DaoPersona();
	listPersonas = dao.listPersona();
	return listPersonas;
}

public void setListPersonas(List<Persona> listPersonas) {
	this.listPersonas = listPersonas;
}

public Persona getPersona() {
	return persona;
}

public void setPersona(Persona persona) {
	this.persona = persona;
}

public void limpiarPersona() {
	persona= new Persona();
}

public String agregarPersona() {
	DaoPersona daoPersona= new DaoPersona();
	daoPersona.addPersona(persona);
	return "/index.xhtml?faces-redirect=true";
}


public String modificarPersona() {
	DaoPersona daoPersona= new DaoPersona();
	daoPersona.updatePersona(persona);
	return "/index.xhtml?faces-redirect=true";
}


public String eliminarPersona() {
	DaoPersona daoPersona= new DaoPersona();
	daoPersona.deletePersona(persona);
	return "/index.xhtml?faces-redirect=true";
}
}
