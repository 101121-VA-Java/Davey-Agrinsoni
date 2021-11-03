package com.revature.services;

import java.util.List;

import com.revature.models.Album;
import com.revature.repositories.AlbumDao;
import com.revature.repositories.AlbumList;

public class AlbumService {
	private AlbumDao ad = new AlbumList();
	
	public Album addAlbum (Album a) {
		return ad.add(a);
	}
	
	public boolean removeAlbum(Album a) {
		List<Album> albums = ad.getAll();
		for(Album a1 :albums) {
			if(a1.equals(a)) {
				return ad.remove(a);
			}
		}
		return false;
	}

}