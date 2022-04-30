package com.techelevator.dao;

import com.techelevator.model.CatCard;
import com.techelevator.model.CatCardNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCatCardDao implements CatCardDao {

	private JdbcTemplate jdbcTemplate;
	private Logger log = LoggerFactory.getLogger(getClass());

	public JdbcCatCardDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<CatCard> list() {
		List<CatCard> catCards = new ArrayList<>();
		String sql = "SELECT id, img_url, fact, caption FROM catcards ";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()) {
			CatCard card = mapRowToCard(results);
			catCards.add(card);
		}
		return catCards;
	}

	@Override
	public CatCard get(long id) {
		CatCard card = null;
		String sql = "SELECT id, img_url, fact, caption FROM catcards WHERE id = ? ";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql,id);
		if(results.next()) {
			card = mapRowToCard(results);
		} else {
			throw new CatCardNotFoundException();
		}

		return card;
	}

	@Override
	public boolean update(long cardId, CatCard changedCard) {
		String sql = "UPDATE catcards SET img_url = ?, fact = ?, caption = ? WHERE id = ? ";
		return jdbcTemplate.update(sql, changedCard.getImgUrl(), changedCard.getCatFact(), changedCard.getCaption(), cardId) == 1;
	}

	@Override
	public boolean delete(long id) {
		String sql = "DELETE FROM catcards WHERE id = ? ";
		return jdbcTemplate.update(sql, id) == 1;
	}

	@Override
	public boolean save(CatCard card) {
		String sql = "INSERT INTO catcards (id, img_url, fact, caption) VALUES (DEFAULT, ?, ?, ?)";
		return jdbcTemplate.update(sql,card.getImgUrl(),card.getCatFact(),card.getCaption()) == 1;
	}

	private boolean exists(long id) {
		return jdbcTemplate.queryForObject("select * from catcards where id = ?", new Object[]{id}, boolean.class);
	}
	
	private CatCard mapRowToCard(SqlRowSet rs) {
		CatCard cc = new CatCard();
		cc.setCatCardId(rs.getLong("id"));
		cc.setCatFact(rs.getString("fact"));
		cc.setImgUrl(rs.getString("img_url"));
		cc.setCaption(rs.getString("caption"));
		return cc;
	};

}
