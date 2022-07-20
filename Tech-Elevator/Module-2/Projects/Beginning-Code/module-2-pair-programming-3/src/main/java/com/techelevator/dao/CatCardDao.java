package com.techelevator.dao;

import com.techelevator.model.CatCard;

import java.util.List;

public interface CatCardDao {

	List<CatCard> list();

	CatCard get(long id);

	boolean save(CatCard cardToSave);

	boolean update(long id, CatCard card);

	boolean delete(long id);

}
