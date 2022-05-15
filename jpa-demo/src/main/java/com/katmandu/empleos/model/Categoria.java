package com.katmandu.empleos.model;

import javax.persistence.*;

@Entity
@Table(name="Categorias")
public class Categoria {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY) // Con esto se hace autoincrementable
  private Integer id;
  private String nombre;
  private String descripcion;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }
  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  @Override
  public String toString() {
    return "Categoria{" +
        "id=" + id +
        ", nombre='" + nombre + '\'' +
        ", descripción='" + descripcion + '\'' +
        '}';
  }
}
