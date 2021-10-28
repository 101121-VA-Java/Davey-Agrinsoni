package com.revature.services;

import com.revature.models.Album;
import com.revature.repositories.AlbumDao;
import com.revature.repositories.AlbumList;

public class AlbumService {
	private AlbumDao ad = new AlbumList();
	
	public Album addAlbum (Album a) {
		return a;
	}
	
	public boolean removeAlbum(Album a) {
		return false;
	}

}
