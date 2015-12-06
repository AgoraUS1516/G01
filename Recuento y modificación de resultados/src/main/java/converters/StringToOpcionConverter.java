package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


import repositories.OpcionRepository;


import domain.Opcion;

@Component
@Transactional
public class StringToOpcionConverter implements Converter<String, Opcion> {
	
	@Autowired
	private OpcionRepository opcionRepository;
	
	@Override
	public Opcion convert(String text){
		Opcion result;
		int id;
		
		try{
			if(StringUtils.isEmpty(text))
				result = null;
			else{
				id = Integer.valueOf(text);
				result = opcionRepository.findOne(id);
			}
		}catch(Throwable oops){
			throw new IllegalArgumentException(oops);
		}
		return result;
	}

}
