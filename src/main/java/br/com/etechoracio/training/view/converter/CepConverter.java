package br.com.etechoracio.training.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.stereotype.Component;

@Component(value="cepConverter")
public class CepConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		String cep = value;
		
		if (cep != null && !cep.equals("")) {
			cep = value.replaceAll("[^0-9]", "");
		}
		
		return cep;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		String cep = String.valueOf(value);
		
		cep = cep.substring(0, 5) + "-" +
				cep.substring(5);
		
		return cep;
	}

}
