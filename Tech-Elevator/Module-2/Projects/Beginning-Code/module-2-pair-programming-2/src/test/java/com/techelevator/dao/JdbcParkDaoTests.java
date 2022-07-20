package com.techelevator.dao;

import com.techelevator.model.Park;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class JdbcParkDaoTests extends BaseDaoTests {

    private ParkDao dao;

    @Before
    public void setup() {
        dao = new JdbcParkDao(dataSource);
    }

    @Test
    public void getParksTest_Should_ReturnAllParksInLocationAlphaOrder() {
        List<Park> parks = dao.getAllParks();

        assertEquals(2, parks.size());
        assertEquals("Ohio", parks.get(0).getLocation());
        assertEquals("Pennsylvania", parks.get(1).getLocation());
    }

}
