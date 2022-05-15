package com.katmandu.empleos;

import com.katmandu.empleos.model.Categoria;
import com.katmandu.empleos.model.Perfil;
import com.katmandu.empleos.model.Usuario;
import com.katmandu.empleos.model.Vacante;
import com.katmandu.empleos.repository.CategoriasRepository;
import com.katmandu.empleos.repository.PerfilesRepository;
import com.katmandu.empleos.repository.UsuariosRepository;
import com.katmandu.empleos.repository.VacantesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner { // Con esta interfaz la transformamos en linea de comandos

	@Autowired
	private CategoriasRepository repoCategorias;
	@Autowired
	private VacantesRepository repoVacantes;
	@Autowired
	private UsuariosRepository repoUsuarios;
	@Autowired
	private PerfilesRepository repoPerfiles;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Iniciando");
		//guardar();
		//buscarPorId();
		//modificar();
		//eliminar();
		//conteo();
		//eliminarTodos();
		//encontrarPorIds();
		//buscartodos();
		//buscarTodosJpa();
		//buscarTodosOrdenados();
		//buscarTodosPaginaciónOrdenados();
		//existeId();
		//guardarTodos();
		//buscarVacantes();
		//guardarVacante();
		//crearPerfilesAplicacion();
		crearUsuarioConUnPerfil();
	}

	private void crearUsuarioConUnPerfil(){
		Usuario user = new Usuario();
		user.setNombre("");

	}

	private void crearPerfilesAplicacion(){
		repoPerfiles.saveAll(getPerfilesAplicación());
	}

	private void buscarVacantes(){
		List<Vacante> lista = repoVacantes.findAll();
		for (Vacante vac : lista){
			System.out.println("La vacante: "+ vac.getNombre()+"-- ID:"+vac.getId()+" La categoria: "+vac.getCategoria().getNombre());
		}
	}

	private void guardarVacante(){
		Vacante vac = new Vacante();
		vac.setNombre("Profesor de Matemáticas");
		vac.setDestacado(0);
		vac.setDescripcion("Escuela primaria solicita prfesor para curso de Matemáticas");
		vac.setFecha(new Date());
		vac.setEstatus("Aprobada");
		vac.setImagen("escuela.png");
		vac.setSalario(8500.0);
		vac.setDetalles("<h1>Los requisitos para profesor de Matemáticas</h1>");
		Categoria cat = new Categoria();
		cat.setId(15);
		vac.setCategoria(cat);
		repoVacantes.save(vac);
	}

	private void guardar(){
		Categoria cat = new Categoria();
		cat.setNombre("Finanzas");
		cat.setDescripcion("Trabajos relacionados con finanzas y contabilidad");
		repoCategorias.save(cat);
		System.out.println(cat);
	}

	private void buscarPorId(){
		Optional<Categoria> optional = repoCategorias.findById(1);

		if(optional.isPresent()){
			System.out.println("Habemus cat" + optional.get());
		}
	}

	private void modificar(){
		Optional<Categoria> optional = repoCategorias.findById(2);

		if(optional.isPresent()){
			System.out.println("Habemus cat" + optional.get());
			Categoria cat = optional.get();
			cat.setNombre("Ingenieria de Software");
			cat.setDescripcion("Desarrollo de sistemas");
			repoCategorias.save(cat);
		}
	}

	private void eliminar(){
		int idCategoria = 2;
		repoCategorias.deleteById(idCategoria);
	}

	private void conteo(){
		long cont= repoCategorias.count();
		System.out.println("Total cat:" +cont);
	}

	private void eliminarTodos(){
		repoCategorias.deleteAll();
	}

	private void encontrarPorIds(){
		List<Integer> ids = new LinkedList<Integer>();
		ids.add(1);
		ids.add(4);
		ids.add(10);
		Iterable<Categoria> categorias = repoCategorias.findAllById(ids);
		for( Categoria cat : categorias){
			System.out.println("La categ es : "+ cat);
		}
	}

	private void buscartodos(){

		Iterable<Categoria> categorias = repoCategorias.findAll();
		for( Categoria cat : categorias){
			System.out.println("La categ es : "+ cat);
		}
	}

	private void buscarTodosOrdenados(){
		List <Categoria> categorias = repoCategorias.findAll(Sort.by("nombre").descending());
		for( Categoria cat : categorias){
			System.out.println("La categ es : "+ cat);
		}
	}

	private void buscarTodosPaginacion(){
		Page<Categoria> categorias = repoCategorias.findAll(PageRequest.of(0,5));
		System.out.println("Total registros: "+categorias.getTotalElements());
		System.out.println("Total paginas: "+categorias.getTotalPages());
		for( Categoria cat : categorias){
			System.out.println("La categ es : "+ cat);
		}
		System.out.println("*****************************************");
		categorias = repoCategorias.findAll(PageRequest.of(1,5));

		for( Categoria cat : categorias){
			System.out.println("La categ es : "+ cat);
		}
	}

	private void buscarTodosPaginaciónOrdenados(){

		Page<Categoria> categorias = repoCategorias.findAll(PageRequest.of(0,5,Sort.by("nombre").ascending()));
		System.out.println("Total registros: "+categorias.getTotalElements());
		System.out.println("Total paginas: "+categorias.getTotalPages());
		for( Categoria cat : categorias){
			System.out.println("La categ es : "+ cat);
		}
		System.out.println("*****************************************");
		categorias = repoCategorias.findAll(PageRequest.of(1,5,Sort.by("nombre").ascending()));

		for( Categoria cat : categorias){
			System.out.println("La categ es : "+ cat);
		}

	}

	private void existeId(){
		if (repoCategorias.existsById(1)){
			System.out.println("El registro existe");
		}
	}

	private void buscarTodosJpa(){
		List<Categoria> cats= repoCategorias.findAll();
		for (Categoria cat: cats){
			System.out.println("La categoria: "+cat);
		}
	}

	private void borrarTodoEnBloque(){ // Borra con una sola sentencia
		repoCategorias.deleteAllInBatch();
	}

	private void guardarTodos(){
		repoCategorias.saveAll(getListaCategorias());
	}

	private List<Categoria> getListaCategorias() {
		List<Categoria> lista = new LinkedList<Categoria>();
		Categoria cat = new Categoria();
		cat.setNombre("Programador de Blockchain");
		cat.setDescripcion("Trabajos realizados con bitcoins y criptomonedas");
		lista.add(cat);

		cat = new Categoria();
		cat.setNombre("Soldador/Pintura");
		cat.setDescripcion("Trabajos realizados con soldadura, pintura y enderezado");
		lista.add(cat);

		cat = new Categoria();
		cat.setNombre("Ingeniero Industrial");
		cat.setDescripcion("Trabajos realizados con Ingenieria Industrial");
		lista.add(cat);

		return lista;
	}

	private List<Perfil> getPerfilesAplicación()	{

		List<Perfil> lista= new LinkedList<Perfil>();
		Perfil p1 = new Perfil();
		p1.setPerfil("SUPERVISOR");
		lista.add(p1);
		p1 = new Perfil();
		p1.setPerfil("ADMINISTRADOR");
		lista.add(p1);
		p1 = new Perfil();
		p1.setPerfil("USUARIO");
		lista.add(p1);
		return lista;
	}




}
