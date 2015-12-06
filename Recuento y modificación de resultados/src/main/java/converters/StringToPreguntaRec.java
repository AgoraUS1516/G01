package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


import repositories.PreguntaRecRepository;



import domain.PreguntaRec;

@Component
@Transactional
public class StringToPreguntaRec implements Converter<String, PreguntaRec> {
	
	@Autowired
	private PreguntaRecRepository preguntaRecRepository;
	
	@Override
	public PreguntaRec convert(String text){
		PreguntaRec result;
		int id;
		
		try{
			if(StringUtils.isEmpty(text))
				result = null;
			else{
				id = Integer.valueOf(text);
				result = preguntaRecRepository.findOne(id);
			}
		}catch(Throwable oops){
			throw new IllegalArgumentException(oops);
		}
		return result;
	}

}
