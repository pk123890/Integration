package io.swagger.DTO;

import javax.annotation.Generated;


@Generated("com.robohorse.robopojogenerator")
public class Cursors{


	private Object after;

	public void setAfter(Object after){
		this.after = after;
	}

	public Object getAfter(){
		return after;
	}

	@Override
 	public String toString(){
		return 
			"Cursors{" + 
			"after = '" + after + '\'' + 
			"}";
		}
}