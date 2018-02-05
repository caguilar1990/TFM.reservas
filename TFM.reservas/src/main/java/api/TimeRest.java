package api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import controllers.TimeController;
import entities.Horario;

@RestController
@RequestMapping(Uris.HORARIOS)
public class TimeRest {

	public TimeController timeController;



	@Autowired
	public void setHorarioController(TimeController timeController) {
		this.timeController = timeController;
	}



	@RequestMapping(method = RequestMethod.GET)
	public List<Horario> getAll() {

		return timeController.getAll();
	}


}
