package com.revature.repositories;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Album;

public class AlbumList implements AlbumDao{
	
	private List<Album> albums;

	public AlbumList() {
		albums = new ArrayList<>();
	}
	
	@Override
	public Album add(Album a) {
		// TODO Auto-generated method stub
		albums.add(a);
		return a;
	}

	@Override
	public List<Album> getAll() {
		// TODO Auto-generated method stub
		return albums;
	}

	@Override
	public Album getByTitle(String title) {
		// TODO Auto-generated method stub
		for(Album a: albums) {
			if(a.getTitle() == title) {
				return a;
			}
		}
		return null;
	}

	@Override
	public boolean remove(Album a) {
		// TODO Auto-generated method stub
		Album temp = getByTitle(a.getTitle());
		if(temp == null) {
			return false;
		}
		albums.remove(a);
		return true;
	}
}
