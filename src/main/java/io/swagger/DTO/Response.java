package io.swagger.DTO;

import javax.annotation.Generated;
import java.util.List;


@Generated("com.robohorse.robopojogenerator")
public class Response{


	private List<Object> images;


	private Followers followers;


	private String href;


	private String id;


	private String display_name;


	private String type;


	private ExternalUrls external_urls;


	private String uri;

	public void setImages(List<Object> images){
		this.images = images;
	}

	public List<Object> getImages(){
		return images;
	}

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

	public ExternalUrls getExternal_urls() {
		return external_urls;
	}

	public void setExternal_urls(ExternalUrls external_urls) {
		this.external_urls = external_urls;
	}

	public void setFollowers(Followers followers){
		this.followers = followers;
	}

	public Followers getFollowers(){
		return followers;
	}

	public void setHref(String href){
		this.href = href;
	}

	public String getHref(){
		return href;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}



	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}



	public void setUri(String uri){
		this.uri = uri;
	}

	public String getUri(){
		return uri;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"images = '" + images + '\'' + 
			",followers = '" + followers + '\'' + 
			",href = '" + href + '\'' + 
			",id = '" + id + '\'' + 
			",display_name = '" + display_name + '\'' +
			",type = '" + type + '\'' + 
			",external_urls = '" + external_urls + '\'' +
			",uri = '" + uri + '\'' + 
			"}";
		}
}