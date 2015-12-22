package converters;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.Votacion;
import domain.Voto;

@Component
@Transactional
public class VotacionToStringConverter implements Converter<Votacion, String> {
	
	@Override
	public String convert(Votacion a){
		String result;
		
		if(a== null)
			result = null;
		else
			result = String.valueOf(a.getId());
		
		return result;
	}

}
