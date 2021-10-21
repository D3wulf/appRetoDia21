package retoDia21.appRetoDia21.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id= "fiesta")
public class retoNuevoEndpoint {
	
	private List<String> personas = new ArrayList<>();
	
	@ReadOperation
	public List<String> fiesta(){
		return personas;
	}
	
	@WriteOperation
	public void setAsistentes(@Selector String nuevoAsistente){
		personas.add(nuevoAsistente);
		
	}
	
	@ReadOperation
	public void deleteOperation(@Selector String borrarAsistente){
		personas.remove(borrarAsistente);
	}
	
	

}
