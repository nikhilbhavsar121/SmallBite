/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebindtech.tiffin.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author mrsagar
 */
@Entity
@Table(name = "TiffinOrderMenu")
@NamedQueries({
    @NamedQuery(name = "TiffinOrderMenu.findAll", query = "SELECT t FROM TiffinOrderMenu t")})
public class TiffinOrderMenu implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "TiffinID")
    private int tiffinID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TiffinMenuID")
    private int tiffinMenuID;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TiffinOrderMenuID")
    private Integer tiffinOrderMenuID;
    @Column(name = "Quantity")
    private Integer quantity;

    public TiffinOrderMenu() {
    }

    public TiffinOrderMenu(Integer tiffinOrderMenuID) {
        this.tiffinOrderMenuID = tiffinOrderMenuID;
    }

    public TiffinOrderMenu(Integer tiffinOrderMenuID, Integer tiffinID, Integer tiffinMenuID) {
        this.tiffinOrderMenuID = tiffinOrderMenuID;
        this.tiffinID = tiffinID;
        this.tiffinMenuID = tiffinMenuID;
    }

    public Integer getTiffinOrderMenuID() {
        return tiffinOrderMenuID;
    }

    public void setTiffinOrderMenuID(Integer tiffinOrderMenuID) {
        this.tiffinOrderMenuID = tiffinOrderMenuID;
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public int getTiffinID() {
        return tiffinID;
    }

    public void setTiffinID(int tiffinID) {
        this.tiffinID = tiffinID;
    }

    public int getTiffinMenuID() {
        return tiffinMenuID;
    }

    public void setTiffinMenuID(int tiffinMenuID) {
        this.tiffinMenuID = tiffinMenuID;
    }

}
