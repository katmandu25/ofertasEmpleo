package com.katmandu.empleos.controller;

import com.katmandu.empleos.model.Categoria;
import com.katmandu.empleos.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value="/categorias")
public class CategoriasController {

  @Autowired
  ICategoriaService categoriaService;

  // @GetMapping("/index")
  @RequestMapping(value="/index", method= RequestMethod.GET)
  public String mostrarIndex(Model model) {
    model.addAttribute("categorias",categoriaService.buscarTodas());
    return "categorias/listCategorias";
  }

  // @GetMapping("/create")
  @RequestMapping(value="/create", method=RequestMethod.GET)
  public String crear(Categoria cat) {
    return "categorias/formCategoria";
  }

  // @PostMapping("/save")
  @RequestMapping(value="/save", method=RequestMethod.POST)
  public String guardar(Categoria cat, BindingResult result, RedirectAttributes attributes) {
    if (result.hasErrors()){
      for(ObjectError error: result.getAllErrors()){
        System.out.println("Ocurrió el error: "+error.getDefaultMessage());
      }
      return "categorias/formCategoria";
    }
    categoriaService.guardar(cat);
    attributes.addFlashAttribute("msg", "Categoría guardada");
    return "redirect:/categorias/index";
  }
}
