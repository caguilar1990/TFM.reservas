package api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import controllers.ResourcesController;
import entities.Recursos;

@RestController
@RequestMapping(Uris.RECURSOS)
public class ResourcesRest {

	public ResourcesController recursoController;

	@Autowired
	public void setRecursoController(ResourcesController recursoController) {
		this.recursoController = recursoController;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Recursos> getAll() {

		return recursoController.getAll();
	}
	
	
	  
	@RequestMapping(method = RequestMethod.POST)
	public void addRecursos(@RequestBody Recursos recurso) {
		this.recursoController.addRecursos(recurso);
	}


	@RequestMapping(method = RequestMethod.DELETE , value = Uris.ID)
	public void removeRecursos(@PathVariable(value = "id") int id) {
		this.recursoController.removeRecursos(id);
	}
	

	@RequestMapping(method = RequestMethod.GET, value = Uris.ID)
	public Recursos searchByID(@PathVariable(value = "id") int id) {
		return recursoController.searchByID(id);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT)
	public void updateRecursos(@RequestBody Recursos recurso) {
		this.recursoController.updateRecursos(recurso);
	}



}
