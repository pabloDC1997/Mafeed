package br.com.mafeed.mafeed.service.base;

import org.springframework.stereotype.Controller;

import br.com.mafeed.mafeed.utils.FileManager;
import br.com.mafeed.mafeed.utils.Keys;

@Controller
public class BaseService {
	
	public String getBase() {
		return FileManager.openToStr(Keys.PATH_BASE_HTML);
	}
}
