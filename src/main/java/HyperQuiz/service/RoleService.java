package HyperQuiz.service;

import java.util.Set;

import HyperQuiz.models.service.RoleServiceModel;
import HyperQuiz.models.service.UserServiceModel;

public interface RoleService {
	
	void seedRolesInDb();
	
	//void assignUserRoles(UserServiceModel userServiceModel, long numberOfUsers);
	
	Set<RoleServiceModel> findAllRoles();
	
	RoleServiceModel findByAuthority(String authority);

}
