package io.swagger.DTO;

public class Permissions{
	private boolean pull;
	private boolean admin;
	private boolean push;

	public void setPull(boolean pull){
		this.pull = pull;
	}

	public boolean isPull(){
		return pull;
	}

	public void setAdmin(boolean admin){
		this.admin = admin;
	}

	public boolean isAdmin(){
		return admin;
	}

	public void setPush(boolean push){
		this.push = push;
	}

	public boolean isPush(){
		return push;
	}

	@Override
 	public String toString(){
		return 
			"Permissions{" + 
			"pull = '" + pull + '\'' + 
			",admin = '" + admin + '\'' + 
			",push = '" + push + '\'' + 
			"}";
		}
}
