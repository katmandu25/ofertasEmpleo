package com.katmandu.empleos.model;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name="Usuarios")
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String username;
  private String nombre;
  private String email;
  private String password;
  private Integer estatus;
  private Date fechaRegistro;
  @ManyToMany(fetch=FetchType.EAGER) // Cuando hagamos una select de usuario busca todos los perfiles asociados
  @JoinTable(name="UsuarioPerfil",
      joinColumns = @JoinColumn(name = "idUsuario"),      // joinColumn con la clave del modelo
      inverseJoinColumns = @JoinColumn(name = "idPerfil"))  //inversejoin con la clave relacionada
  private List<Perfil> perfiles;

  public void agregar (Perfil tempPerfil){    // Esta clase es un helper
    if(this.perfiles==null){
      this.perfiles = new LinkedList<Perfil>();
    }
    else{
      this.perfiles.add(tempPerfil);
    }
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Integer getEstatus() {
    return estatus;
  }

  public void setEstatus(Integer estatus) {
    this.estatus = estatus;
  }

  public Date getFechaRegistro() {
    return fechaRegistro;
  }

  public void setFechaRegistro(Date fechaRegistro) {
    this.fechaRegistro = fechaRegistro;
  }

  public List<Perfil> getPerfiles() {
    return perfiles;
  }

  public void setPerfiles(List<Perfil> perfiles) {
    this.perfiles = perfiles;
  }

  @Override
  public String toString() {
    return "Usuario{" +
        "id=" + id +
        ", username='" + username + '\'' +
        ", nombre='" + nombre + '\'' +
        ", email='" + email + '\'' +
        ", password='" + password + '\'' +
        ", estatus=" + estatus +
        ", fechaRegistro=" + fechaRegistro +
        ", perfiles=" + perfiles +
        '}';
  }

}
