package api;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import controllers.ClassroomController;
import entities.Aula;

@RestController
@RequestMapping(Uris.AULAS)
public class ClassroomRest {

	private Logger logger = LogManager.getLogger(ClassroomRest.class.getName());
	public ClassroomController classroomController;

	@Autowired
	public void setAulaController(ClassroomController classroomController) {
		this.classroomController = classroomController;
	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")

	public List<Aula> getAll() {
		logger.debug("getAll()");
		return classroomController.getAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = Uris.ID)
	public Aula searchByID(@PathVariable(value = "id") int id) {
			logger.debug("searchByID()");
			Aula aula = classroomController.searchByID(id);
			return aula;
	}
	
	
	@RequestMapping(method = RequestMethod.PUT)
	public void updateAula(@RequestBody Aula classroom) {
		logger.debug("updateAula()");
		this.classroomController.updateAula(classroom);
	}
	  
	@RequestMapping(method = RequestMethod.POST)
	public void addAula(@RequestBody Aula aula) {
		logger.debug("addAula()");
		this.classroomController.addAula(aula);
	}


	@RequestMapping(method = RequestMethod.DELETE , value = Uris.ID)
	public void removeAula(@PathVariable(value = "id") int id) {
		logger.debug("removeAula()");
		this.classroomController.removeAula(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = Uris.PERSONAL_MAESTROS + Uris.PERSONAL_ID)
	public List<Aula> findbyPersonal(@PathVariable(value = "idPersonal") int id) {
		
		return classroomController.findbyPersonal(id);
		
	}
	

}
