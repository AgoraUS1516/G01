package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import domain.Opcion;

@Component
@Transactional
public class OpcionToStringConverter implements Converter<Opcion, String> {
	
	@Override
	public String convert(Opcion a){
		String result;
		
		if(a== null)
			result = null;
		else
			result = String.valueOf(a.getId());
		
		return result;
	}

}
