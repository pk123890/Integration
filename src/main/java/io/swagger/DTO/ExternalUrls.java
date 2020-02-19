package io.swagger.DTO;

import javax.annotation.Generated;


@Generated("com.robohorse.robopojogenerator")
public class ExternalUrls{


	private String spotify;

	public void setSpotify(String spotify){
		this.spotify = spotify;
	}

	public String getSpotify(){
		return spotify;
	}

	@Override
 	public String toString(){
		return 
			"ExternalUrls{" + 
			"spotify = '" + spotify + '\'' + 
			"}";
		}
}