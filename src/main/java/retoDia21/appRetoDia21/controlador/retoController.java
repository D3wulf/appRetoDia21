package retoDia21.appRetoDia21.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@RestController
public class retoController {
	
	
		private Counter counter;
		
		//Utilidad de prometheus MeterRegistry
		public retoController(MeterRegistry registry) {
			
			this.counter = Counter.builder("entradas.persona").description("veces que ha entrado una persona").register(registry);
			
		}
		// Aumenta el contador cuando entremos en http://localhost:8080/holamundo
		
		
		@GetMapping(path="/persona/{nombre}")
		public String prueba(@PathVariable String nombre) {
			
			String mensaje = nombre;
			
			if(nombre == "paco") {
				counter.increment();
				mensaje= "Te esperabamos" + nombre;
			}else {
				mensaje= "Buscamos a otra persona";
				
			}
			
			return mensaje;
			
			
			
			
		}
		
		
		
		

	


}
