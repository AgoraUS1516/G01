package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;



import repositories.RecuentoOpcionRepository;



import domain.RecuentoOpcion;

@Component
@Transactional
public class StringToRecuentoOpcion implements Converter<String, RecuentoOpcion> {
	
	@Autowired
	private RecuentoOpcionRepository recuentoOpcionRepository;
	
	@Override
	public RecuentoOpcion convert(String text){
		RecuentoOpcion result;
		int id;
		
		try{
			if(StringUtils.isEmpty(text))
				result = null;
			else{
				id = Integer.valueOf(text);
				result = recuentoOpcionRepository.findOne(id);
			}
		}catch(Throwable oops){
			throw new IllegalArgumentException(oops);
		}
		return result;
	}

}
