package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import daos.ResourcesClassroomDAO;
//import daos.ResourcesClassroomDAO;
import daos.ResourcesDAO;
import entities.AulaRecursos;
import entities.Recursos;

@Controller
public class ResourcesController {

	private ResourcesDAO recursoDAO;
	private ResourcesClassroomDAO recursoAulaDAO;


	@Autowired
	public void setRecursoDAO(ResourcesDAO recursoDAO) {
		this.recursoDAO = recursoDAO;
	}
	
	@Autowired
	public void setRecursoAulaDAO(ResourcesClassroomDAO recursoAulaDAO) {
		this.recursoAulaDAO = recursoAulaDAO;
	}
	

	public List<Recursos> getAll() {
		return recursoDAO.findAll();
	}

	public Recursos searchByID(int id) {
		return recursoDAO.findOne(id);
	}

	public void updateRecursos(Recursos recurso) {
		Recursos recursoUpdate = recursoDAO.findOne(recurso.getId());
		if (recursoUpdate != null) {
			try {
				recursoUpdate.setDescripcion(recurso.getDescripcion());
				recursoUpdate.setNombre(recurso.getNombre());
				this.recursoDAO.save(recursoUpdate);
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}

	}

	public void addRecursos(Recursos recurso) {
		recursoDAO.save(recurso);

	}

	public void removeRecursos(int id) {
	
		List<AulaRecursos> resourcesClassRemoveList = recursoAulaDAO.findbyIDrecurso(id);
		for (AulaRecursos resourceClass : resourcesClassRemoveList) {
			recursoAulaDAO.delete(resourceClass);

		}
		recursoDAO.delete(id);

	}
}
