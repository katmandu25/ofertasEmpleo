package com.katmandu.empleos.controller;

import com.katmandu.empleos.model.Vacante;
import com.katmandu.empleos.service.IVacanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeController {

  @Autowired
  private IVacanteService serviceVacantes;

  @GetMapping("/tabla")
  public String mostrarTabla (Model model){
    List<Vacante> lista = serviceVacantes.buscarTodas();
    model.addAttribute("vacantes", lista);

    return "tabla";
  }

  @GetMapping("/")
  public String mostrarHome(Model model){
    List<Vacante> lista = serviceVacantes.buscarTodas();
    model.addAttribute("vacantes", lista);
    return "home";
  }

  @GetMapping("/detalle")
  public String mostrarDetalle(Model model){

    Vacante vacante = new Vacante();
    vacante.setNombre("Ingeniero de Comunicaciones");
    vacante.setDescripcion("Se solicita ingeniero para dar soporte a la Intranet");
    vacante.setFecha(new Date());
    vacante.setSalario(9700.0);
    model.addAttribute("vacante", vacante);

    return "detalle";

  }

  @GetMapping("/listado")
  public String mostrarListado(Model model){
    /*List<String> lista = new LinkedList<String>();
    lista.add("Ingeniero de Sistemas");
    lista.add("Auxiliar de Contabilidad");
    lista.add("Vendedor");
    lista.add("Arquitecto");*/

    List<Vacante> lista = serviceVacantes.buscarTodas();

    model.addAttribute("empleos", lista);

    return "listado";
  }
}
