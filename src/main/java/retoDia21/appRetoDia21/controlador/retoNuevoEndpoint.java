package retoDia21.appRetoDia21.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import retoDia21.appRetoDia21.model.Persona;

@Component
@Endpoint(id= "fiesta")
public class retoNuevoEndpoint {
	
	private List<Persona> personas = new ArrayList<>();
	Persona persona1;
	
	
	@ReadOperation
	public List<Persona> fiesta(){
		return personas;
	}
	
	@WriteOperation
	public void setAsistentes(@Selector String nombre){
		
		persona1.setNombre(nombre);
		
		
		personas.add(persona1);
		
	}
	
	@ReadOperation
	public void deleteAsistente(@Selector Persona persona){
		personas.remove(persona);
	}
	
	

}
