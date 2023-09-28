package fr.dawan.calculatriceweb.validation;

import jakarta.validation.constraints.NotNull;

public class CalculForm {
	@NotNull
	private Integer nombre1;

	@NotNull
	private Integer nombre2;



	// Getters et setters
	public Integer getNombre1() {
		return nombre1;
	}

	public void setNombre1(Integer nombre1) {
		this.nombre1 = nombre1;
	}

	public Integer getNombre2() {
		return nombre2;
	}

	public void setNombre2(Integer nombre2) {
		this.nombre2 = nombre2;
	}
}
