/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliocv.spring.Dto;

import jakarta.validation.constraints.NotBlank;

public class dtoSkills {
    @NotBlank
    private String nombre;
    @NotBlank
    private int porcentaje;

    public dtoSkills() {
    }

    public dtoSkills(String nombre, int porcentaje) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
}

