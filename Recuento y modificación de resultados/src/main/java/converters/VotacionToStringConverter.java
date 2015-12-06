package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import domain.Voto;





@Component
@Transactional
public class VotacionToStringConverter implements Converter<Voto, String> {
	
	@Override
	public String convert(Voto a){
		String result;
		
		if(a== null)
			result = null;
		else
			result = String.valueOf(a.getId());
		
		return result;
	}

}
