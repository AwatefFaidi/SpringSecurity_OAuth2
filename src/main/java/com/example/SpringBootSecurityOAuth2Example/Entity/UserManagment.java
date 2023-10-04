package com.example.SpringBootSecurityOAuth2Example.Entity;


	import java.io.Serializable;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table(name = "users")
public class UserManagment implements Serializable {
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "id", length = 25)
		private Integer id;

		@Column(name = "username", length = 50)
		private String userName;

		@Column(name = "password", length = 800)
		private String password;

		@Column(name = "role", length = 50)
		private String role;

		@Column(name = "enabled")
		private short enabled;

		
		
		
		
		public UserManagment(Integer id, String userName, String password, String role, short enabled) {
			super();
			this.id = id;
			this.userName = userName;
			this.password = password;
			this.role = role;
			this.enabled = enabled;
		}

		public UserManagment() {
			super();
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		/**
		 * @return the id
		 */
		public Integer getId() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(Integer id) {
			this.id = id;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public short getEnabled() {
			return enabled;
		}

		public void setEnabled(short enabled) {
			this.enabled = enabled;
		}

		@Override
		public String toString() {
			return String.format("UserInfo [id=%s, userName=%s, password=%s, role=%s, enabled=%s]", id, userName, password,
					role, enabled);
		}

	}

