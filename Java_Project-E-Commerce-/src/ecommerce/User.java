package ecommerce;

import java.util.Objects;

public class User {
	protected int id;
	protected String username;
	protected String password;
	
	static private int user_count = 0;
	
	public User() {
		this.id = 987654321;
		this.username = "noUserName";
		this.password = "noPassword";
	}
	
	
	
	public User(String username, String password) {
		super();
		this.id = user_count;
		this.username = username;
		this.password = password;
		user_count++;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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
	
	
	
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return id == other.id;
	}



	@Override
	public String toString() {
		return "\nid=" + id + "\nusername=" + username + "\npassword=" + password;
	}
	
	public String encryptPassword(String password) //simple encryption algorithm just for show, it is not save!
	{
		int len = password.length();
		StringBuilder updated = new StringBuilder();
		for(int i=0;i<len;i++)
		{
			char ch=(char) (password.charAt(i)+len);
			updated.append(ch);
		}
		return(updated.toString());
	}
	
	public String decryptPassword(String encrypted)
	{
		int len =encrypted.length();
		StringBuilder decrypted =new StringBuilder();
		for(int i=0;i<len;i++)
		{
			char ch = (char) (encrypted.charAt(i)-len);
			decrypted.append(ch);
		}
		return(decrypted.toString());
		
	}
	
	
	
	
	

}
