package br.com.etechoracio.training.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.stereotype.Component;

@Component(value="foneConverter")
public class FoneConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		String fone = value;
		
		if (fone != null && !fone.equals("")) {
			fone = value.replaceAll("[^0-9]", "");
		}
		
		return fone;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		String fone = String.valueOf(value);
		
		if (fone != null && !fone.equals("")) {
			fone = "(" + fone.substring(0, 2) + ")" + " " +
					fone.substring(2, 6) + "-" +
					fone.substring(6);
		}
		
		return null;
	}

}
