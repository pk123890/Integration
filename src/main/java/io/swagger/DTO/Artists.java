package io.swagger.DTO;

import javax.annotation.Generated;
import java.util.List;


@Generated("com.robohorse.robopojogenerator")
public class Artists{


	private Object next;


	private Cursors cursors;


	private int total;


	private int limit;


	private String href;


	private List<ItemsItem> items;

	public void setNext(Object next){
		this.next = next;
	}

	public Object getNext(){
		return next;
	}

	public void setCursors(Cursors cursors){
		this.cursors = cursors;
	}

	public Cursors getCursors(){
		return cursors;
	}

	public void setTotal(int total){
		this.total = total;
	}

	public int getTotal(){
		return total;
	}

	public void setLimit(int limit){
		this.limit = limit;
	}

	public int getLimit(){
		return limit;
	}

	public void setHref(String href){
		this.href = href;
	}

	public String getHref(){
		return href;
	}

	public void setItems(List<ItemsItem> items){
		this.items = items;
	}

	public List<ItemsItem> getItems(){
		return items;
	}

	@Override
 	public String toString(){
		return 
			"Artists{" + 
			"next = '" + next + '\'' + 
			",cursors = '" + cursors + '\'' + 
			",total = '" + total + '\'' + 
			",limit = '" + limit + '\'' + 
			",href = '" + href + '\'' + 
			",items = '" + items + '\'' + 
			"}";
		}
}