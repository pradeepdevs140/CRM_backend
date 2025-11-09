package customer.service.crm.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

import customer.service.crm.Entity.UserEntity;
import customer.service.crm.Repository.UserRepository;
@Service

public class AppUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
	UserEntity existingUser =userRepo.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("Email not found "+ email) );
	return new User(existingUser.getEmail(),existingUser.getPassword(), new ArrayList<>());
	}

}
