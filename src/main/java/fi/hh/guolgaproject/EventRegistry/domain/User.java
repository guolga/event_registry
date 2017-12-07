package fi.hh.guolgaproject.EventRegistry.domain;


import javax.persistence.*;

@Entity
public class User {

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id", nullable = false, updatable = false)
	    private Long id;

	    // Username with unique constraint
	    @Column(name = "username", nullable = false, unique = true)
	    private String username;

	    @Column(name = "firstname", nullable = false)
	    private String firstname;
	    
	    @Column(name = "surname", nullable = false)
	    private String surname;
	    
	    @Column(name = "password", nullable = false)
	    private String passwordHash;

	    @Column(name = "email", nullable = false)
	    private String email;
	    
	    @Column(name = "role", nullable = false)
	    private String role="USER";
	    
	    public User() {}

	    public User(String username, String firstname, String surname, String passwordHash, String email, String role){
	    	super();
			this.username = username;
			this.firstname = firstname;
			this.surname = surname;
			this.passwordHash = passwordHash;
			this.email = email;
			this.role = role;
	    	
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

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getSurname() {
			return surname;
		}

		public void setSurname(String surname) {
			this.surname = surname;
		}

		public String getPasswordHash() {
			return passwordHash;
		}

		public void setPasswordHash(String passwordHash) {
			this.passwordHash = passwordHash;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}
	

}
