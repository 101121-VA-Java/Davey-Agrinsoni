package com.revature.repositories;

import java.util.List;

public interface GenericDao<O> {
	
	O add(O o);
	List<O> getAll();
	O getByUsername(String username);
	boolean remove(O o);

}
