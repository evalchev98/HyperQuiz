package HyperQuiz.models.view;

import java.util.Set;

import HyperQuiz.entities.Role;

public class UserAllViewModel {
	
	private String id;
	private String username;
	private String password;
	private String email;
	
	private Set<String> authorities;

	public UserAllViewModel() {
		super();
	}

	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public Set<String> getAuthorities() {
		return authorities;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAuthorities(Set<String> authorities) {
		this.authorities = authorities;
	}
	
	

}
