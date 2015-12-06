package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;




import repositories.VotacionRecRepository;



import domain.VotacionRec;

@Component
@Transactional
public class StringToVotacionRec implements Converter<String, VotacionRec> {
	
	@Autowired
	private VotacionRecRepository votacionRecRepository;
	
	@Override
	public VotacionRec convert(String text){
		VotacionRec result;
		int id;
		
		try{
			if(StringUtils.isEmpty(text))
				result = null;
			else{
				id = Integer.valueOf(text);
				result = votacionRecRepository.findOne(id);
			}
		}catch(Throwable oops){
			throw new IllegalArgumentException(oops);
		}
		return result;
	}

}
