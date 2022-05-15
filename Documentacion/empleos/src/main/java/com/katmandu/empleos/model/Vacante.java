package com.katmandu.empleos.model;

import java.util.Date;

public class Vacante {

  private Integer id;
  private String nombre;
  private String descripcion;
  private Date fecha;
  private Double salario;
  private String status;
  private String detalles;
  private String imagen = "no-image.png";
  private Integer destacado;
  private Categoria categoria;

  public Integer getDestacado() {
    return destacado;
  }

  public void setDestacado(Integer destacado) {
    this.destacado = destacado;
  }

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

  public Date getFecha() {
    return fecha;
  }

  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  public Double getSalario() {
    return salario;
  }

  public void setSalario(Double salario) {
    this.salario = salario;
  }
  public String getImagen() {
    return imagen;
  }

  public void setImagen(String imagen) {
    this.imagen = imagen;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
  }

  @Override
  public String toString() {
    return "Vacante{" +
        "id=" + id +
        ", nombre='" + nombre + '\'' +
        ", descripcion='" + descripcion + '\'' +
        ", fecha=" + fecha +
        ", salario=" + salario +
        ", status='" + status + '\'' +
        ", detalles='" + detalles + '\'' +
        ", imagen='" + imagen + '\'' +
        ", destacado=" + destacado +
        ", categoria=" + categoria +
        '}';
  }

  public String getDetalles() {
    return detalles;
  }

  public void setDetalles(String detalles) {
    this.detalles = detalles;
  }

}
