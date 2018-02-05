package api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import controllers.ResourcesClassroomController;
import entities.AulaRecursos;

@RestController
@RequestMapping(Uris.AULA_RECURSOS)
public class ResourcesClassroomRest {
	public ResourcesClassroomController relacionAulaRecursos;

	@Autowired
	public void setRelacionAulaRecursosController(ResourcesClassroomController relacionAulaRecursos) {
		this.relacionAulaRecursos = relacionAulaRecursos;
	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<AulaRecursos> getAll() {
		return relacionAulaRecursos.getAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = Uris.ID)
	public List<AulaRecursos> findbyIDAula(@PathVariable(value = "id") int id) {
		return relacionAulaRecursos.findbyIDAula(id);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public void addResourcesClassroom(@RequestBody List<AulaRecursos> resourceClassList) {
		this.relacionAulaRecursos.addResourcesClass(resourceClassList);
	}

	
	@RequestMapping(method = RequestMethod.DELETE , value = Uris.AULA_ID + Uris.RECURSO_ID)
	public void removeResourceClassroom(@PathVariable(value = "idAula") int idAula, @PathVariable(value = "idResource") int idResource ) {
		this.relacionAulaRecursos.removeResourcesClass(idAula,idResource);
	}

	
}
