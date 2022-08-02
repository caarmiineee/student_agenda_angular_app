package com.nanosoft.student_agenda.payload.response;

import java.util.List;
import java.util.Objects;

import org.springframework.http.ResponseCookie;

public class UserInfoResponse {

	private Long id;
	private String username;
	private String email;
	private List<String> roles;
	private String jwtCookie;
	
	public UserInfoResponse(Long id, String username, String email, List<String> roles2, String jwtCookie) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles2;
		this.jwtCookie = jwtCookie;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getJwtCookie() {
		return jwtCookie;
	}

	public void setJwtCookie(String jwtCookie) {
		this.jwtCookie = jwtCookie;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, jwtCookie, roles, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfoResponse other = (UserInfoResponse) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(jwtCookie, other.jwtCookie) && Objects.equals(roles, other.roles)
				&& Objects.equals(username, other.username);
	}
	
	
}
