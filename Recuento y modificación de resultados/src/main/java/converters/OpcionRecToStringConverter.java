package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.OpcionRec;




@Component
@Transactional
public class OpcionRecToStringConverter implements Converter<OpcionRec, String> {
	
	@Override
	public String convert(OpcionRec a){
		String result;
		
		if(a== null)
			result = null;
		else
			result = String.valueOf(a.getId());
		
		return result;
	}

}
