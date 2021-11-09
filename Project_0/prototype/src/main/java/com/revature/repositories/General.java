package com.revature.repositories;

import java.sql.SQLException;
import java.util.List;

public interface General<O> {
	
	O add(O o) throws SQLException;
	List<O> getAll();
	O getByUsername(String username);
	boolean remove(O o);

}
