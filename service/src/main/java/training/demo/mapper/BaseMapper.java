package training.demo.mapper;

import java.util.List;
import java.util.stream.Collectors;
import com.googlecode.jmapper.JMapper;

import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;
 
@Component
@NoArgsConstructor
public class BaseMapper {
    
	
	public    <D, S> D transformFromSourceToDestination(Class<D> destination, S sourceObj, Class<S> source) {
		JMapper<D , S> mapper = new JMapper<>(destination, source);
		return mapper.getDestination(sourceObj);
	}

	public   <D, S> List<D> transformList(Class<D> destination, List<S> sourceObjList, Class<S> source) {
		JMapper<D , S> mapper = new JMapper<>(destination, source);
		List<D> results = sourceObjList.stream().map((s)-> mapper.getDestination(s)).collect(Collectors.toList());
		return results;
	}
}
