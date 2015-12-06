package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


import repositories.OpcionRecRepository;



import domain.OpcionRec;

@Component
@Transactional
public class StringToOpcionRecConverter implements Converter<String, OpcionRec> {
	
	@Autowired
	private OpcionRecRepository opcionRecRepository;
	
	@Override
	public OpcionRec convert(String text){
		OpcionRec result;
		int id;
		
		try{
			if(StringUtils.isEmpty(text))
				result = null;
			else{
				id = Integer.valueOf(text);
				result = opcionRecRepository.findOne(id);
			}
		}catch(Throwable oops){
			throw new IllegalArgumentException(oops);
		}
		return result;
	}

}
