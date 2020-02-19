package io.swagger.DTO;

import javax.annotation.Generated;


@Generated("com.robohorse.robopojogenerator")
public class Followers{


	private int total;

	private Object href;


	public void setTotal(int total){
		this.total = total;
	}

	public int getTotal(){
		return total;
	}

	public void setHref(Object href){
		this.href = href;
	}

	public Object getHref(){
		return href;
	}

	@Override
 	public String toString(){
		return 
			"Followers{" + 
			"total = '" + total + '\'' + 
			",href = '" + href + '\'' + 
			"}";
		}
}