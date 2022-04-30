package com.techelevator.controller;

import com.techelevator.dao.CatCardDao;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;

public class CatController {

    private CatCardDao catCardDao;
    private CatFactService catFactService;
    private CatPicService catPicService;

    public CatController(CatCardDao catCardDao, CatFactService catFactService, CatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }


}
