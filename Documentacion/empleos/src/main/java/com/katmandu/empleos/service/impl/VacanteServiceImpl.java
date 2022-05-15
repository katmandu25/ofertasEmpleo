package com.katmandu.empleos.service.impl;

import com.katmandu.empleos.model.Vacante;
import com.katmandu.empleos.service.IVacanteService;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

@Service
public class VacanteServiceImpl implements IVacanteService {
  private List<Vacante> miLista = null;

  public VacanteServiceImpl(){
    miLista = new LinkedList<Vacante>();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    try {
      Vacante vacante = new Vacante();
      vacante.setId(1);
      vacante.setNombre("Ingeniero Civil");
      vacante.setDescripcion("Solicitamos Ing. Civil para diseño de puente peatonal");
      vacante.setFecha(sdf.parse("08-02-2019"));
      vacante.setSalario(8500.0);
      vacante.setDestacado(1);
      vacante.setImagen("empresa1.png");
      miLista.add(vacante);

      vacante = new Vacante();
      vacante.setId(2);
      vacante.setNombre("Contador Publico");
      vacante.setDescripcion("Empresa importante solicita contador con 5 años de experiencia");
      vacante.setFecha(sdf.parse("09-02-2019"));
      vacante.setSalario(12000.0);
      vacante.setDestacado(0);
      vacante.setImagen("empresa2.png");
      miLista.add(vacante);

      vacante = new Vacante();
      vacante.setId(3);
      vacante.setNombre("Ingeniero Eléctrico");
      vacante.setDescripcion("Empresa internacional solicita Ingeniero Eléctrico para instalación en el extranjero");
      vacante.setFecha(sdf.parse("10-02-2019"));
      vacante.setSalario(10500.0);
      vacante.setDestacado(0);
      miLista.add(vacante);

      vacante = new Vacante();
      vacante.setId(4);
      vacante.setNombre("Diseñador Gráfico");
      vacante.setDescripcion("Empresa de diseño solicita Diseñador con experiencia en Photoshop");
      vacante.setFecha(sdf.parse("11-02-2019"));
      vacante.setSalario(9500.0);
      vacante.setImagen("empresa3.png");
      vacante.setDestacado(1);
      miLista.add(vacante);

      System.out.println(miLista);
    } catch (ParseException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public List<Vacante> buscarTodas() {
    return miLista;
  }

  @Override
  public Vacante buscarPorId(Integer idVacante) {
    for (Vacante vac: miLista){
      if(vac.getId()==idVacante){
        return vac;
      }
    }
    return null;
  }

  @Override
  public void guardar(Vacante vacante) {
    miLista.add(vacante);
  }
}
