package com.rebindtech.tiffin.supplier;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.rebindtech.tiffin.entity.Tiffin;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author mrsagar
 */
@Entity
@Table(name = "TiffinSupplier")
@NamedQueries({
    @NamedQuery(name = "TiffinSupplier.findAll", query = "SELECT t FROM TiffinSupplier t")})
public class TiffinSupplier implements Serializable {

    @Size(max = 15)
    @Column(name = "DeliveryTime")
    private String deliveryTime;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MonthlyPackagePrice")
    private BigDecimal monthlyPackagePrice;
    @Column(name = "WeeklyPackagePrice")
    private BigDecimal weeklyPackagePrice;
    @Column(name = "PerTiffinPrice")
    private BigDecimal perTiffinPrice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierID", fetch = FetchType.LAZY)
    private List<Tiffin> tiffinList;
    @Column(name = "Ratings")
    private Short ratings;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TiffinSupplierID")
    private Integer tiffinSupplierID;
    @Size(max = 100)
    @Column(name = "TiffinSupplierName")
    private String tiffinSupplierName;
    @Size(max = 100)
    @Column(name = "OutletName")
    private String outletName;
    @Size(max = 45)
    @Column(name = "AddressLine1")
    private String addressLine1;
    @Size(max = 45)
    @Column(name = "AddressLine2")
    private String addressLine2;
    @Size(max = 45)
    @Column(name = "Locality")
    private String locality;
    @Size(max = 45)
    @Column(name = "City")
    private String city;
    @Size(max = 45)
    @Column(name = "State")
    private String state;
    @Size(max = 45)
    @Column(name = "Pincode")
    private String pincode;
    @Size(max = 45)
    @Column(name = "Lattitude")
    private String lattitude;
    @Size(max = 45)
    @Column(name = "Longitude")
    private String longitude;
    @Column(name = "IsLogoUploaded")
    private Boolean isLogoUploaded;
    @Size(max = 45)
    @Column(name = "OwenName")
    private String owenName;
    @Column(name = "SMSPhone")
    private BigInteger sMSPhone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 250)
    @Column(name = "Email")
    private String email;
    @Size(max = 10)
    @Column(name = "STDCode")
    private String sTDCode;
    @Size(max = 10)
    @Column(name = "LandLine")
    private String landLine;
    @Column(name = "LunchTimeStart")
    @Temporal(TemporalType.TIME)
    private Date lunchTimeStart;
    @Column(name = "LunchTimeEnd")
    @Temporal(TemporalType.TIME)
    private Date lunchTimeEnd;
    @Column(name = "DinnerTimeStart")
    @Temporal(TemporalType.TIME)
    private Date dinnerTimeStart;
    @Column(name = "DinnerTimeEnd")
    @Temporal(TemporalType.TIME)
    private Date dinnerTimeEnd;
    @Column(name = "IsVeg")
    private Boolean isVeg;

    public TiffinSupplier() {
    }

    public TiffinSupplier(Integer tiffinSupplierID) {
        this.tiffinSupplierID = tiffinSupplierID;
    }

    public Integer getTiffinSupplierID() {
        return tiffinSupplierID;
    }

    public void setTiffinSupplierID(Integer tiffinSupplierID) {
        this.tiffinSupplierID = tiffinSupplierID;
    }

    public String getTiffinSupplierName() {
        return tiffinSupplierName;
    }

    public void setTiffinSupplierName(String tiffinSupplierName) {
        this.tiffinSupplierName = tiffinSupplierName;
    }

    public String getOutletName() {
        return outletName;
    }

    public void setOutletName(String outletName) {
        this.outletName = outletName;
    }

    public BigInteger getsMSPhone() {
        return sMSPhone;
    }

    public void setsMSPhone(BigInteger sMSPhone) {
        this.sMSPhone = sMSPhone;
    }

    public String getsTDCode() {
        return sTDCode;
    }

    public void setsTDCode(String sTDCode) {
        this.sTDCode = sTDCode;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getLattitude() {
        return lattitude;
    }

    public void setLattitude(String lattitude) {
        this.lattitude = lattitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Boolean getIsLogoUploaded() {
        return isLogoUploaded;
    }

    public void setIsLogoUploaded(Boolean isLogoUploaded) {
        this.isLogoUploaded = isLogoUploaded;
    }

    public String getOwenName() {
        return owenName;
    }

    public void setOwenName(String owenName) {
        this.owenName = owenName;
    }

    public BigInteger getSMSPhone() {
        return sMSPhone;
    }

    public void setSMSPhone(BigInteger sMSPhone) {
        this.sMSPhone = sMSPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSTDCode() {
        return sTDCode;
    }

    public void setSTDCode(String sTDCode) {
        this.sTDCode = sTDCode;
    }

    public String getLandLine() {
        return landLine;
    }

    public void setLandLine(String landLine) {
        this.landLine = landLine;
    }

    public Date getLunchTimeStart() {
        return lunchTimeStart;
    }

    public void setLunchTimeStart(Date lunchTimeStart) {
        this.lunchTimeStart = lunchTimeStart;
    }

    public Date getLunchTimeEnd() {
        return lunchTimeEnd;
    }

    public void setLunchTimeEnd(Date lunchTimeEnd) {
        this.lunchTimeEnd = lunchTimeEnd;
    }

    public Date getDinnerTimeStart() {
        return dinnerTimeStart;
    }

    public void setDinnerTimeStart(Date dinnerTimeStart) {
        this.dinnerTimeStart = dinnerTimeStart;
    }

    public Date getDinnerTimeEnd() {
        return dinnerTimeEnd;
    }

    public void setDinnerTimeEnd(Date dinnerTimeEnd) {
        this.dinnerTimeEnd = dinnerTimeEnd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tiffinSupplierID != null ? tiffinSupplierID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiffinSupplier)) {
            return false;
        }
        TiffinSupplier other = (TiffinSupplier) object;
        if ((this.tiffinSupplierID == null && other.tiffinSupplierID != null) || (this.tiffinSupplierID != null && !this.tiffinSupplierID.equals(other.tiffinSupplierID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.i2rtech.tiffin.entity.customer.TiffinSupplier[ tiffinSupplierID=" + tiffinSupplierID + " ]";
    }

    public Short getRatings() {
        return ratings;
    }

    public void setRatings(Short ratings) {
        this.ratings = ratings;
    }

    public List<Tiffin> getTiffinList() {
        return tiffinList;
    }

    public void setTiffinList(List<Tiffin> tiffinList) {
        this.tiffinList = tiffinList;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public BigDecimal getMonthlyPackagePrice() {
        return monthlyPackagePrice;
    }

    public void setMonthlyPackagePrice(BigDecimal monthlyPackagePrice) {
        this.monthlyPackagePrice = monthlyPackagePrice;
    }

    public BigDecimal getWeeklyPackagePrice() {
        return weeklyPackagePrice;
    }

    public void setWeeklyPackagePrice(BigDecimal weeklyPackagePrice) {
        this.weeklyPackagePrice = weeklyPackagePrice;
    }

    public BigDecimal getPerTiffinPrice() {
        return perTiffinPrice;
    }

    public void setPerTiffinPrice(BigDecimal perTiffinPrice) {
        this.perTiffinPrice = perTiffinPrice;
    }

    public Boolean isIsVeg() {
        return isVeg;
    }

    public void setIsVeg(Boolean isVeg) {
        this.isVeg = isVeg;
    }

}
