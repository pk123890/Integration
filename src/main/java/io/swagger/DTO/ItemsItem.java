package io.swagger.DTO;

import javax.annotation.Generated;
import java.util.List;


@Generated("com.robohorse.robopojogenerator")
public class ItemsItem{


	private List<ImagesItem> images;


	private Followers followers;


	private List<String> genres;


	private int popularity;


	private String name;


	private String href;


	private String id;


	private String type;


	private ExternalUrls external_urls;


	private String uri;

	public void setImages(List<ImagesItem> images){
		this.images = images;
	}

	public List<ImagesItem> getImages(){
		return images;
	}

	public void setFollowers(Followers followers){
		this.followers = followers;
	}

	public Followers getFollowers(){
		return followers;
	}

	public void setGenres(List<String> genres){
		this.genres = genres;
	}

	public List<String> getGenres(){
		return genres;
	}

	public void setPopularity(int popularity){
		this.popularity = popularity;
	}

	public int getPopularity(){
		return popularity;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
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

	public ExternalUrls getExternal_urls() {
		return external_urls;
	}

	public void setExternal_urls(ExternalUrls external_urls) {
		this.external_urls = external_urls;
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
			"ItemsItem{" + 
			"images = '" + images + '\'' + 
			",followers = '" + followers + '\'' + 
			",genres = '" + genres + '\'' + 
			",popularity = '" + popularity + '\'' + 
			",name = '" + name + '\'' + 
			",href = '" + href + '\'' + 
			",id = '" + id + '\'' + 
			",type = '" + type + '\'' + 
			",external_urls = '" + external_urls + '\'' +
			",uri = '" + uri + '\'' + 
			"}";
		}
}