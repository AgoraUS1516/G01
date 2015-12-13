package converters;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import domain.Voto;




import repositories.VotoRepository;




@Component
@Transactional
public class StringToVoto implements Converter<String, Voto> {
	
	@Autowired
	private VotoRepository votoRepository;
	
	@Override
	public Voto convert(String text){
		Voto result;
		int id;
		
		try{
			if(StringUtils.isEmpty(text))
				result = null;
			else{
				id = Integer.valueOf(text);
				result = votoRepository.findOne(id);
			}
		}catch(Throwable oops){
			throw new IllegalArgumentException(oops);
		}
		return result;
	}

}
