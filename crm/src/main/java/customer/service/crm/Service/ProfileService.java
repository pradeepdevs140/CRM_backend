package customer.service.crm.Service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import customer.service.crm.Entity.UserEntity;
import customer.service.crm.Repository.UserRepository;
import customer.service.crm.io.ProfileRequest;
import customer.service.crm.io.ProfileResponse;
@Service
public class ProfileService implements ProfileServiceImp {

	@Autowired
	private UserRepository userRepo;
	@Override
	public ProfileResponse createProfile(ProfileRequest request) {
		// TODO Auto-generated method stub
		UserEntity newProfile = convertToUserEntity(request);
		if(!userRepo.existsByEmail(request.getEmail())) {
			newProfile = userRepo.save(newProfile);
			return convertToProfileResponse(newProfile);
		}
		
		throw new ResponseStatusException(HttpStatus.CONFLICT,"Email already exist");
	}
	private ProfileResponse convertToProfileResponse(UserEntity newProfile) {
	    ProfileResponse response = new ProfileResponse();

	    response.setUserId(newProfile.getUserId());
	    response.setName(newProfile.getName());
	    response.setEmail(newProfile.getEmail());
	    response.setAccountVerified(newProfile.isAccountVerified());

	    return response;
	}

	private UserEntity convertToUserEntity(ProfileRequest request) {
		UserEntity userEntity = new UserEntity();
		userEntity.setUserId(UUID.randomUUID().toString());
	    userEntity.setName(request.getName());
	    userEntity.setEmail(request.getEmail());
	    userEntity.setPassword(request.getPassword());
	    userEntity.setAccountVerified(false);
	    userEntity.setVerifyOTP(null);
	    userEntity.setVerifyOtpExpireAt(0L);
	    userEntity.setResetOtp(null);
	    userEntity.setResetOtpExpireAt(0L);

	    return userEntity;
		
	}

}
