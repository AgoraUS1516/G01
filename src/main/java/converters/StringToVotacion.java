package converters;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import domain.Votacion;




import repositories.VotacionRepository;




@Component
@Transactional
public class StringToVotacion implements Converter<String, Votacion> {
	
	@Autowired
	private VotacionRepository votacionRepository;
	
	@Override
	public Votacion convert(String text){
		Votacion result;
		int id;
		
		try{
			if(StringUtils.isEmpty(text))
				result = null;
			else{
				id = Integer.valueOf(text);
				result = votacionRepository.findOne(id);
			}
		}catch(Throwable oops){
			throw new IllegalArgumentException(oops);
		}
		return result;
	}

}
