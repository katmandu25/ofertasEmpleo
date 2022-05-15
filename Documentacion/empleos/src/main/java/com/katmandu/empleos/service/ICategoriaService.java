package com.katmandu.empleos.service;

import com.katmandu.empleos.model.Categoria;

import java.util.List;

public interface ICategoriaService {
  void guardar (Categoria categoria);
  List<Categoria> buscarTodas();
  Categoria buscarPorId(Integer idCategoria);
}
