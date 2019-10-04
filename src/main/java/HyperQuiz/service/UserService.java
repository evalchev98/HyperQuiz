package HyperQuiz.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import HyperQuiz.models.service.UserServiceModel;

public interface UserService extends UserDetailsService {

	UserServiceModel registerUser(UserServiceModel userServiceModel);
	
	UserServiceModel findUserByUserName(String username);
	
	UserServiceModel editUserProfile(UserServiceModel userServiceModel, String oldPassword);
	
	List<UserServiceModel> findAllUsers();
	
    void setUserRole(String id, String role);
    
    UserServiceModel findUserById(String id);

}
