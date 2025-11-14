package customer.service.crm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import customer.service.crm.Service.ProfileService;
import customer.service.crm.io.ProfileRequest;
import customer.service.crm.io.ProfileResponse;


@RestController
@RequestMapping("/api/user")
public class profileController {

	@Autowired
	private ProfileService profileService;
	
	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public ProfileResponse register( @RequestBody ProfileRequest request) {
		ProfileResponse response = profileService.createProfile(request);
		return response;
	}
	@GetMapping("/profile")
	public ProfileResponse getProfile(@CurrentSecurityContext(expression="authentication?.name")String email ) {
		return profileService.getProfile(email);
	}
}
