package customer.service.crm.Service;

import customer.service.crm.io.ProfileRequest;
import customer.service.crm.io.ProfileResponse;

public interface ProfileServiceImp {

	public  ProfileResponse createProfile(ProfileRequest request);
}
