package io.swagger.DTO;

import javax.annotation.Generated;


@Generated("com.robohorse.robopojogenerator")
public class Plan{


	private int privateRepos;


	private String name;


	private int collaborators;


	private int space;

	public void setPrivateRepos(int privateRepos){
		this.privateRepos = privateRepos;
	}

	public int getPrivateRepos(){
		return privateRepos;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setCollaborators(int collaborators){
		this.collaborators = collaborators;
	}

	public int getCollaborators(){
		return collaborators;
	}

	public void setSpace(int space){
		this.space = space;
	}

	public int getSpace(){
		return space;
	}

	@Override
 	public String toString(){
		return 
			"Plan{" + 
			"private_repos = '" + privateRepos + '\'' + 
			",name = '" + name + '\'' + 
			",collaborators = '" + collaborators + '\'' + 
			",space = '" + space + '\'' + 
			"}";
		}
}