/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebindtech.tiffin.dto;

import java.util.List;

/**
 *
 * @author Sagar
 */
public class CityDTO {

    private String cityID;
    private String cityName;
    List<LocalityDTO> localities;

    public String getCityID() {
        return cityID;
    }

    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<LocalityDTO> getLocalities() {
        return localities;
    }

    public void setLocalities(List<LocalityDTO> localities) {
        this.localities = localities;
    }

}
