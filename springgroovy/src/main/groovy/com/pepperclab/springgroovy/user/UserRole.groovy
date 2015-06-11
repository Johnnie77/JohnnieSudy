package com.pepperclab.springgroovy.user

import javax.persistence.*

/**
 * Created by johney on 15. 6. 10..
 */
@Entity
@Table(name="roles")
class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id

//	@Version
//	private Long version;

	@Column(name = "rolename")
	private String roleName;

	@ManyToOne
	private User user;

	public UserRole() {
	}

	public UserRole(String roleName, User user) {
		this.roleName = roleName;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
