package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import daos.ResourcesClassroomDAO;
import entities.AulaRecursos;
import identifiers.AulaRecursosId;

@Controller
public class ResourcesClassroomController {

	private ResourcesClassroomDAO resourceClassDAO;

	@Autowired
	public void setRecursoAulaDAO(ResourcesClassroomDAO resourceClassDAO) {
		this.resourceClassDAO = resourceClassDAO;
	}
	
	
	public List<AulaRecursos> getAll() {

		return resourceClassDAO.findAll();
	}

	//AULA_RECURSOS ADD
	public void addResourcesClass(List<AulaRecursos> resourceClassList) {
		AulaRecursosId id;
		AulaRecursos resp;
		for (AulaRecursos resourcesClass : resourceClassList){
			id = new AulaRecursosId(resourcesClass.getAula().getId(), resourcesClass.getRecursos().getId());
			resp = new AulaRecursos();
			resp.setId(id);
			resp.setCantidad(resourcesClass.getCantidad());

			resourceClassDAO.save(resp);
		}
	}

	public void removeResourcesClass(int classID, int resID ) {

		AulaRecursos resp = resourceClassDAO.findByFK(classID, resID);
		resourceClassDAO.delete(resp);
		}
	
	//TODO
	public List<AulaRecursos> findbyIDAula(int id) {
		
		 List<AulaRecursos> listResourcesClass = resourceClassDAO.findbyIDAula(id);
		 return listResourcesClass;
	}
	
	
}
