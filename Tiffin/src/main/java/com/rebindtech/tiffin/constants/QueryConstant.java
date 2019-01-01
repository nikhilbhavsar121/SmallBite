package com.rebindtech.tiffin.constants;

/**
 *
 * @author Sagar
 */
public interface QueryConstant {

    public String GET_USER_BY_MOBILE_NUMBER = "SELECT * FROM TiffinCustomer WHERE SMSPhone = :smsPhone";

    public String GET_USER_COUNT_BY_MOBILE_NUMBER = "SELECT * FROM TiffinCustomer WHERE SMSPhone = :smsPhone";
//            + " AND MobileActivationDateTime IS NOT NULL";

    public String GET_USER_COUNT_BY_EMAIL = "SELECT * FROM TiffinCustomer WHERE EmailID = :emailID ";
//            + " AND EmailActivationDateTime IS NOT NULL";

    public String GET_TIFFIN_BY_SUPPLIER_ID = "SELECT * FROM Tiffin tf WHERE tf.supplierID IN (:supplierIDs)"
            + " AND tf.tiffinDate = :date AND tf.isLunch = :IsLunch";//BETWEEN DATE(NOW()) AND DATE(DATE_ADD(NOW(),INTERVAL 1 DAY))";// date_format(now(), '%Y-%m-%d')";

    public String GET_USER_BY_USERNAME_PASSWORD = "SELECT * FROM LoginMaster WHERE PrivateDoor = :mobileNumber"
            + " AND PrivateChavi = :password";

    public String UPDATE_DEVICE_ID_BY_CUSTOMER_ID = "UPDATE TiffinCustomer SET"
            + " DeviceID = :deviceID WHERE CustomerID = :customerID";

    public String GET_SUPPLIER_BY_LAT_LONG = "SELECT * FROM TiffinSupplier";

    public String GET_ADDRESS_BY_USER_ID = "SELECT * FROM AddressMaster am WHERE am.CustomerID = :custID";

    public String UPDATE_PASSWORD_BY_USER_ID = "UPDATE LoginMaster SET PrivateChavi=:password WHERE UserID= :userID";

    public String GET_ORDERS_BY_USER_ID_AND_BETWEEN_DATES = "SELECT * FROM TiffinOrder WHERE UserID= :userID AND PaymentStatus NOT LIKE 'F'"
            + " AND OrderDate BETWEEN :startDate AND :endDate";

    public String GET_MOBILE_DEVICE_BY_PERSONID = "SELECT * FROM MobileDevice WHERE CustomerID =:customerID AND AppType =:appType";

    public String GET_MOBILE_DEVICE_BY_APP_TYPE = "SELECT * FROM MobileDevice WHERE AppType =:appType";

    public String UPDATE_CUSTOMER_ACCOUNT_BALANCE = "UPDATE TiffinCustomer SET SmallBiteWallet=SmallBiteWallet+:amount WHERE CustomerID=:customerID";

    public String GET_SUBS_MENU_BY_SUPPLIER_ID = "SELECT * FROM SubsMenu WHERE SupplierID =:supplierID";

    public String UPDATE_LOCALITY_INTO_CUSTOMER_BY_ID = "UPDATE TiffinCustomer SET LocalityID= :localityID"
            + "  WHERE CustomerID =:customerID";

    public String GET_ACTIVE_OFFERS = "SELECT * FROM Offer a WHERE a.IsActive=1 "
            + " AND a.ValidUpto >= DATE(now())";

    public String GET_CUSTOMER_DETIALS_FOR_ORDER = "SELECT tf.Order_id,tc.CustomerID,tc.IsFirstOrder,"
            + " tf.TiffinID,tc.FullName,tc.SMSPhone,am.AddressTag,am.Locality,am.City,"
            + " am.Lattitude,am.Longitude,am.AddressLine1,am.AddressLine2,tf.UnitCount As Tiffins,"
            + " tf.PaymentMode,if(tf.PaymentStatus='P',tf.NetAmount,0) As Receivable"
            + "  FROM TiffinOrder tf JOIN TiffinCustomer tc ON tf.UserID=tc.CustomerID"
//            + "  JOIN Tiffin t ON t.TiffinID = tf.TiffinID"
            + "  JOIN AddressMaster am  ON tf.AddressID=am.AddressMasterID"
            + "  WHERE OrderDate =:orderDate AND tf.PaymentStatus NOT IN ('X','F')"
            + "  AND tf.SupplierID = :supplierID";

    public String GET_ORDER_DETAILS_BY_TIFFIN_ID = "SELECT * FROM OrderDetails WHERE OrderID = :orderID";
    
    public String GET_NOTICE = "SELECT * FROM NoticeBoard WHERE NoticeStartDate = DATE(Now())";
}
