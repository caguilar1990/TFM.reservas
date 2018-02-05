package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import daos.PermisosDAO;
import entities.Permisos;

@Controller
public class PermissionController {

	private PermisosDAO permissionsDAO;

	@Autowired
	public void setPermisosDAO(PermisosDAO permissionsDAO) {
		this.permissionsDAO = permissionsDAO;
	}

	public List<Permisos> getAll() {

		List<Permisos> aula = permissionsDAO.findAll();
		return aula;
	}

	public void removePermission(int id) {
		permissionsDAO.delete(id);

	}

	public void updatePermission(Permisos permission) {
		Permisos permissionsUpdate = permissionsDAO.findOne(permission.getId());
		if (permissionsUpdate != null) {
			try {
				permissionsUpdate.setDescripcion(permission.getDescripcion());
				this.permissionsDAO.save(permissionsUpdate);
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}

	}
	
	public void addPermission(Permisos permission) {
		permissionsDAO.save(permission);

	}


}
