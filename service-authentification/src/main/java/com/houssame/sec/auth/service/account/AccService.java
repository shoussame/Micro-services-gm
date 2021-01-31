package com.houssame.sec.auth.service.account;




import java.util.Collection;
import java.util.List;

import com.houssame.sec.auth.entities.AppRole;
import com.houssame.sec.auth.entities.AppUser;
import com.houssame.sec.auth.utilities.prototype.Mission;




public interface AccService {
	AppUser addUser(AppUser appUser);
	AppRole addRole(AppRole approle);
	void addRoleToUser(String username, String roleName);
	AppUser loadUserByUsername(String username);
	Collection<Mission> findMissionsByProfesseurUsername(String username);
	List<AppUser> listUsers();
	List<AppRole> listRoles();
}
