package com.katmandu.empleos.service.impl;

import com.katmandu.empleos.model.Categoria;
import com.katmandu.empleos.service.ICategoriaService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

  private List<Categoria> miLista = null;
  private Integer idCont=0;

  public CategoriaServiceImpl() {

    miLista = new LinkedList<Categoria>();

    Categoria cat = new Categoria();
    cat.setId(1);
    cat.setNombre("Recursos Humanos");
    cat.setDescripcion("Trabajos relacionados con el area de RRHH.");
    miLista.add(cat);

    cat = new Categoria();
    cat.setId(2);
    cat.setNombre("Ventas");
    cat.setDescripcion("Trabajos relacionados con el area de Ventas.");
    miLista.add(cat);

    cat = new Categoria();
    cat.setId(3);
    cat.setNombre("Arquitectura");
    cat.setDescripcion("Trabajos relacionados con el area de Arquitectura.");
    miLista.add(cat);

    idCont=miLista.size()+1;

  }

  @Override
  public void guardar(Categoria categoria) {
    categoria.setId(idCont);
    idCont++;
    System.out.println("categoria = " + categoria);
    miLista.add(categoria);
  }

  @Override
  public List<Categoria> buscarTodas() {
    return miLista;
  }

  @Override
  public Categoria buscarPorId(Integer idCategoria) {
    for (Categoria cat : miLista){
      if (cat.getId()==idCategoria){
        return cat;
      }
    }
    return null;
  }
}
