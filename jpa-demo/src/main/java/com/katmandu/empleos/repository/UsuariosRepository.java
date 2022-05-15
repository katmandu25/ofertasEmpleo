package com.katmandu.empleos.repository;

import com.katmandu.empleos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuario,Integer> {
}
