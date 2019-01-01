/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebindtech.tiffin.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author jt
 */
@Entity
@Table(name = "City")
@NamedQueries({
    @NamedQuery(name = "City.findAll", query = "SELECT c FROM City c WHERE c.isActive=1")})
public class City implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CityID")
    private Integer cityID;
    @Size(max = 45)
    @Column(name = "CityName")
    private String cityName;
    @Column(name = "IsActive")
    private Boolean isActive;
    @OneToMany(mappedBy = "cityID", fetch = FetchType.LAZY)
    private List<Locality> localityList;

    public City() {
    }

    public City(Integer cityID) {
        this.cityID = cityID;
    }

    public Integer getCityID() {
        return cityID;
    }

    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public List<Locality> getLocalityList() {
        return localityList;
    }

    public void setLocalityList(List<Locality> localityList) {
        this.localityList = localityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cityID != null ? cityID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof City)) {
            return false;
        }
        City other = (City) object;
        if ((this.cityID == null && other.cityID != null) || (this.cityID != null && !this.cityID.equals(other.cityID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rebindtech.tiffin.entity.City[ cityID=" + cityID + " ]";
    }

}
