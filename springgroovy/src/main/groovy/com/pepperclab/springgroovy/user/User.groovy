package com.pepperclab.springgroovy.user

import org.springframework.security.crypto.password.PasswordEncoder

import javax.persistence.*


/**
 * Created by johney on 15. 6. 10..
 */
@Entity
@Table(name="users")
class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id

//	@Version
//	private Long version;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "create_date")
	private Date createDate;

	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "user")
	private List<UserRole> roles;

	public static User createUser(String username, String password) {
		User user = new User();

		PasswordCrypto enc = PasswordCrypto.getInstance()

		user.username = username;
		user.password = enc.encrypt(password);
		user.createDate = new Date()

		if(user.roles == null) {
			user.roles = new ArrayList<UserRole>();
		}

		//create a new user with basic user privileges
		UserRole userRole = new UserRole(
				Role.ROLE_USER.toString(),
				user
		)

		user.roles.add(userRole)

		return user;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(List<UserRole> roles) {
		this.roles = roles;
	}
}
