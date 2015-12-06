package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.RecuentoOpcion;





@Component
@Transactional
public class RecuentoOpcionToStringConverter implements Converter<RecuentoOpcion, String> {
	
	@Override
	public String convert(RecuentoOpcion a){
		String result;
		
		if(a== null)
			result = null;
		else
			result = String.valueOf(a.getId());
		
		return result;
	}

}
