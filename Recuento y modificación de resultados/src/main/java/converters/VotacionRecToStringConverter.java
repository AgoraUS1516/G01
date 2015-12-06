package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import domain.VotacionRec;





@Component
@Transactional
public class VotacionRecToStringConverter implements Converter<VotacionRec, String> {
	
	@Override
	public String convert(VotacionRec a){
		String result;
		
		if(a== null)
			result = null;
		else
			result = String.valueOf(a.getId());
		
		return result;
	}

}
