package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import daos.TimeDAO;
import entities.Horario;

@Controller
public class TimeController {

	private TimeDAO timeDao;

	@Autowired
	public void setTimeDAO(TimeDAO timeDao) {
		this.timeDao = timeDao;
	}

	public List<Horario> getAll() {
		List<Horario> horarios = timeDao.findAll();
		return horarios;
	}

}
