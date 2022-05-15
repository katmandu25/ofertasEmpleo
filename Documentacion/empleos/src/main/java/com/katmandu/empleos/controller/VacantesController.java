package com.katmandu.empleos.controller;

import com.katmandu.empleos.model.Vacante;
import com.katmandu.empleos.service.ICategoriaService;
import com.katmandu.empleos.service.IVacanteService;
import com.katmandu.empleos.util.Utilidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {

  @Value("${empleosapp.ruta.imagenes}")
  private String ruta;
  @Autowired
  private IVacanteService vacanteService;
  @Autowired
  private ICategoriaService categoriaService;

  @GetMapping("/index")
  public String mostrarIndex(Model model) {
    model.addAttribute("vacantes", vacanteService.buscarTodas());
    return "vacantes/listVacantes";
  }

  @GetMapping("/delete")
  public String eliminar (@RequestParam("id") int idVacante, Model model){
    System.out.println("Elemento eliminado");
    model.addAttribute("idVacante", idVacante);
    return ("vacantes/mensaje");
  }

  @GetMapping("/view/{id}")
  public String verDetalle (@PathVariable ("id") int idVacante, Model model){

    model.addAttribute("vacante", vacanteService.buscarPorId(idVacante));
    //Buscar detalles de la vacante en la BBDD

    return "vacantes/detalle";
  }

  @GetMapping("/crear")
  public String crear(Vacante vacante, Model model){
    model.addAttribute("categorias", categoriaService.buscarTodas());
    return "vacantes/formVacante";
  }

  /*@PostMapping("/save")
  public String guardar(
      @RequestParam("nombre") String nombre,
      @RequestParam("descripcion") String descripcion,
      @RequestParam("categoria") String categoria,
      @RequestParam("estatus") String estatus,
      @RequestParam("fecha") String fecha,
      @RequestParam("destacado") int destacado,
      @RequestParam("salario") double salario,
      @RequestParam("detalles") String detalles
      ){
    System.out.println("nombre = " + nombre + ", descripcion = " + descripcion + ", categoria = " + categoria + ", estatus = " + status + ", fecha = " + fecha + ", destacado = " + destacado + ", sueldo = " + salario + ", detalles = " + detalles);
    return "vacantes/listVacantes";
  }*/
  @PostMapping("/save")
  public String guardar(Vacante vacante, @RequestParam("archivoImagen") MultipartFile multiPart, BindingResult result, RedirectAttributes attributes){
    if (result.hasErrors()){
      for(ObjectError error: result.getAllErrors()){
        System.out.println("Ocurrio el error: "+error.getDefaultMessage());
      }
      return "vacantes/formVacante";
    }

    if (!multiPart.isEmpty()) {
    //String ruta = "/empleos/img-vacantes/"; // Linux/MAC
    //  String ruta = "C:/Code_Java/Curso/empleos/img-vacantes/"; // Windows
      String nombreImagen = Utilidades.guardarArchivo(multiPart, ruta);
      if (nombreImagen != null){ // La imagen si se subio
    // Procesamos la variable nombreImagen
        vacante.setImagen(nombreImagen);
      }
    }


    vacanteService.guardar(vacante);
    // model.addAttribute("msg", "Registro guardado"); Esto no funciona en REDIRECT
    attributes.addFlashAttribute("msg", "Registro guardado");
    return "redirect:/vacantes/index";
  }

  @InitBinder
  public void initBinder(WebDataBinder webDataBinder){
    SimpleDateFormat dateFormat =  new SimpleDateFormat("dd-MM-yyyy");
    webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,false));
  }
}
