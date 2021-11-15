package com.revature.repositories;

import java.util.List;

public interface GenericDao<O> {
	O add(O o);
	List<O> getAll();
	O getById(int id);
	boolean remove(O o);
	boolean update(O o);
}
