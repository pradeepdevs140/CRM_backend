package customer.service.crm.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import customer.service.crm.io.AuthRequest;

@RestController

public class authController {

	private AuthenticationManager authenticationManager;
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AuthRequest request){
		try {
			authenticate(request.getEmail() , request.getPassword());
			
		}
		catch(Exception e ) {
			Map<String , Object> error = new HashMap<>();
			
		}
		
		
	}
	public void authenticate(String email , String password) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
	}
}
