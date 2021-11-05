package com.revature.repositories;

import java.util.List;

import com.revature.models.Album;

public interface AlbumDao {
	
	Album add(Album a);
	List<Album> getAll();
	Album getByTitle(String title);
	boolean remove(Album a);
}
