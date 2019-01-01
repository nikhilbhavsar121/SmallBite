package com.rebindtech.tiffin.ctrl;

import com.rebindtech.tiffin.ctrlimpl.CustomerCtrlImpl;
import com.rebindtech.tiffin.ctrlimpl.LoginCtrlImpl;
import com.rebindtech.tiffin.ctrlimpl.MiscCtrlImpl;
import com.rebindtech.tiffin.ctrlimpl.MobileDeviceCtrlImpl;
import com.rebindtech.tiffin.ctrlimpl.OrderCtrlImpl;

/**
 *
 * @author Sagar
 */
public interface CtrlCollection {

    public CustomerCtrl CUSTOMER_CTRL = new CustomerCtrlImpl();

    public SupplierCtrl SUPPLIER_CTRL = new SupplierCtrlImpl();

    public LoginCtrl LOGIN_CTRL = new LoginCtrlImpl();

    public OrderCtrl ORDER_CTRL = new OrderCtrlImpl();

    public MobileDeviceCtrl MOBILE_DEVICE_CTRL = new MobileDeviceCtrlImpl();

    public MiscCtrl MISC_CTRL = new MiscCtrlImpl();
}
