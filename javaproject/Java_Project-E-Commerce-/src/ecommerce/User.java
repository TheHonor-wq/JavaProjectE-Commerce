package ecommerce;

public class User {
	int id;
	String username;
	String password;
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
	public String toString() {
		return "\nUser \nid=" + id + "\nusername=" + username + "\npassword=" + password;
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
