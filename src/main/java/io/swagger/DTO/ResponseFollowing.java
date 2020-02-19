package io.swagger.DTO;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class ResponseFollowing{


	private Artists artists;

	public void setArtists(Artists artists){
		this.artists = artists;
	}

	public Artists getArtists(){
		return artists;
	}

	@Override
 	public String toString(){
		return 
			"ResponseFollowing{" + 
			"artists = '" + artists + '\'' + 
			"}";
		}
}