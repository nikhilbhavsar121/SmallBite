angular.module('ui.bootstrap.demo', ['ngAnimate', 'ui.bootstrap', 'ngMaterial']);
angular.module('ui.bootstrap.demo').controller('MainController', function($scope, $window, $http, $mdDialog, HttpService, $timeout) {

    $scope.notLoggedIn = true;
    $scope.rememberMe = true;
    $scope.doctorAndLabData = {};
    $scope.noAnyDetailsPresent = false;
    $scope.loginSucess = false;
    $scope.todaysMenus = true;
    $scope.todaysTiffin = [];
    $scope.tomorrowsTiffin = [];
    $scope.selectedTiffins = [];
    $scope.gradTotal = 0;

    $scope.showError = false;
    $scope.registerUserSucess = false;
    $scope.registerUser = "";
    $scope.loginUser = "";
    $scope.addressString = "";
    $scope.paymentSucess = false;
    $scope.baseUrl = "http://smallbite.in/api/";
    $scope.confirmationMessage="";
    //$scope.baseUrl="http://smallbite.in:8080/Tiffin/";
    var event = "";

    $scope.loginObj = {
        mobileNumber: '',
        passWord: ''
    };
    $scope.signup = {
        fullName: '',
        emailID: '',
        mobile: '',
        password: '',
        confirmPassword: '',
        address1: '',
        address1:'',
                pinCode: '',
        paymentMode: 'COD'
    };

    $scope.forgotPass = {
        mobileNumber: '',
        step1: true,
        step2: false,
        step3: false,
        reloginPin: '',
        newPassword: '',
        newConfirmPassword: ''
    };

    $scope.showMyOrderHistory = function($event) {
        $('.loading-container').show();
        var url = $scope.baseUrl + 'webresources/order/getOrders';
        var str = "customerID=" + $scope.loginUser.customerID;
        HttpService.getDataFromServer(url, "POST", str, null, true, 2000, $scope.onGetOrderHistorySucess, $scope.onGetOrderHistoryFailure, "LOGIN_TO_SMALLBITE");
    };
    $scope.onGetOrderHistorySucess = function(data) {
        if (data.messageID == '100')
        {
            $('.loading-container').hide();
            $scope.orderHistory = data.orders;
            if ($scope.orderHistory.length > 0)
            {
                for (var i = 0; i < $scope.orderHistory.length; i++)
                {
                    if ((new Date($scope.orderHistory[i].orderDate).getTime()) >= (new Date().getTime()) && $scope.orderHistory[i].paymentStatus!='C' && $scope.orderHistory[i].paymentStatus!='X') {
                        $scope.orderHistory[i].cancelOrder=true;
                    }else
                    {
                        $scope.orderHistory[i].cancelOrder=false;
                    }
                    if ($scope.orderHistory[i].orderDate != undefined && $scope.orderHistory[i].orderDate != "")
                    {
                        $scope.orderHistory[i].orderDate = dateFormat(new Date($scope.orderHistory[i].orderDate), 'dd-mmm-yyyy');
                    }
                }
            }
            $mdDialog.show({
                clickOutsideToClose: false,
                scope: $scope.$new(),
                preserveScope: true,
                templateUrl: 'pages/OrderHistoryPage.html'
            })
                    .then(function(answer) {
                        $scope.status = 'You said the information was "' + answer + '".';

                    }, function() {
                        $scope.status = 'You cancelled the dialog.';

                    });
        } else
        {
            $('.loading-container').hide();
            $scope.showError = true;
            $scope.errorMsg = "Unable to get your orders history...Please try again...";
            $timeout(function() {
                $scope.showError = false;
            }, 2000);
        }
    };
    $scope.onGetOrderHistoryFailure = function(data) {
        $('.loading-container').hide();
        $scope.showError = true;
        $scope.errorMsg = "Unable to get your orders history...Please try again...";
        $timeout(function() {
            $scope.showError = false;
        }, 2000);
    };
    $scope.closeModalWindow = function() {
        $mdDialog.hide();
    };
    $scope.showLoginWindow = function($event)
    {
        $scope.loginObj = {
            mobileNumber: '',
            passWord: ''
        };
        $mdDialog.show({
            clickOutsideToClose: false,
            scope: $scope.$new(),
            preserveScope: true,
            templateUrl: 'pages/loginPage.html'
        })
                .then(function(answer) {
                    $scope.status = 'You said the information was "' + answer + '".';

                }, function() {
                    $scope.status = 'You cancelled the dialog.';

                });
    };
    $scope.showSignupWindow = function($event)
    {
        $scope.signup = {
            fullName: '',
            emailID: '',
            mobile: '',
            password: '',
            confirmPassword: '',
            address1: '',
            address1:'',
                    pinCode: '',
            paymentMode: 'COD'
        };
        $scope.registerUserSucess = false;
        $mdDialog.show({
            clickOutsideToClose: false,
            scope: $scope.$new(),
            preserveScope: true,
            templateUrl: 'pages/signupPage.html'
        })
                .then(function(answer) {
                    $scope.status = 'You said the information was "' + answer + '".';
                }, function() {
                    $scope.status = 'You cancelled the dialog.';
                });
    };


    $scope.loginToSmallBite = function($event) {

        event = $event;
        if ($scope.loginObj.mobileNumber != "" && $scope.loginObj.passWord != "")
        {
            $('.loading-container').show();
            var url = $scope.baseUrl + 'webresources/login';
            var str = "userName=" + $scope.loginObj.mobileNumber + "&password=" + $scope.loginObj.passWord;
            HttpService.getDataFromServer(url, "POST", str, null, true, 2000, $scope.onLoginSucess, $scope.onLoginFailure, "LOGIN_TO_SMALLBITE");
        }
    };
    $scope.onLoginSucess = function(data) {
        //call get tiffin service...
        if (data.messageID == '109')
        {
            $('.loading-container').hide();
            $scope.showError = true;
            $scope.errorMsg = "Please enter valid credentials";
            $timeout(function() {
                $scope.showError = false;
            }, 2000);
        } else
        {
            $scope.todaysTiffin = [];
            $scope.tomorrowsTiffin = [];
            $scope.selectedTiffins = [];
            $scope.gradTotal = 0;
            localStorage.setItem('USER_INFO', JSON.stringify(data.customer));
            $scope.loginUser = data.customer;
            getTiffinValues();
        }

    };
    $scope.onLoginFailure = function(data) {
        $('.loading-container').hide();
        $scope.showError = true;
        $scope.errorMsg = "Unable to login please try again...";
        $timeout(function() {
            $scope.showError = false;
        }, 2000);
    };

    $scope.logoutUser = function() {

        $scope.ReasonForConfirmDialog='LOGOUT';
        $scope.confirmationMessage='Are you sure to logout from SmallBite??';
        $mdDialog.show({
            clickOutsideToClose: false,
            scope: $scope.$new(),
            skipHide:true,
            preserveScope: true,
            templateUrl: 'pages/ConfirmDialogPage.html'
        })
            .then(function(answer) {
                $scope.status = 'You said the information was "' + answer + '".';

            }, function() {
                $scope.status = 'You cancelled the dialog.';

            });


    };
    var getTiffinValues = function() {
        $('.loading-container').show();
        $mdDialog.hide();
        var url = $scope.baseUrl + 'webresources/supplier/getTiffin';
        var str = "supplierID=1";
        HttpService.getDataFromServer(url, "POST", str, null, true, 2000, $scope.onGetTiffinSucess, $scope.onGetTiffinFailure, "LOGIN_TO_SMALLBITE");
    };
    $scope.onGetTiffinSucess = function(data) {


        $scope.loginSucess = true;
        //make grouping of data by today and tommorows...
        $scope.todaysTiffin = [];
        $scope.tomorrowsTiffin = [];
        if (data)
        {
            for (var i = 0; i < data.length; i++)
            {
                if (dateFormat(new Date(), 'dd-mmm-yyyy') == dateFormat(new Date(data[i].tiffinDate), 'dd-mmm-yyyy'))
                {
                    $scope.todaysTiffin.push(data[i]);
                } else
                {
                    $scope.tomorrowsTiffin.push(data[i]);
                }
            }
            $('.loading-container').hide();
        }

    };
    $scope.onGetTiffinFailure = function(data) {
        $('.loading-container').hide();
        $scope.loginSucess = false;
    };

    $scope.init = function($event) {
        $scope.todaysMenus = true;
        if(window.location.search=='?login=true')
            $scope.showLoginWindow($event);
        else
            $scope.showSignupWindow($event);
    };

    $scope.addToCartTiffin = function(selectedTiffin, param) {
        $scope.orderID="";
        var time = new Date();
        if (param == 'tommorow' || time.getHours() <= 9)
        {
            if ($scope.selectedTiffins.length > 0)
            {
                $scope.showError = true;
                $scope.errorMsg = "You already have some item in cart.Please remove first";
                $timeout(function() {
                    $scope.showError = false;
                }, 2000);
            } else
            {
                selectedTiffin.counter = 1;
                selectedTiffin.totalPrice = parseFloat(selectedTiffin.tiffinCharges);
                $scope.selectedTiffins.push(selectedTiffin);
                makeGrandTotal();
            }

        } else
        {
            $scope.showError = true;
            $scope.errorMsg = "Sorry we are not accepting order after 09:00 am.Please contact us for order now."
            $timeout(function() {
                $scope.showError = false;
            }, 2000);
        }
    };
    $scope.removeSelectedTiffin = function(tiffin, index) {
        //$scope.selectedTiffins.splice(index,1);
        $scope.selectedTiffins = [];
        makeGrandTotal();
    };
    $scope.incrementCounter = function(index) {
        $scope.orderID="";
        if ($scope.selectedTiffins[index].counter < 10)
        {
            $scope.selectedTiffins[index].totalPrice = parseFloat($scope.selectedTiffins[index].totalPrice) + parseFloat($scope.selectedTiffins[index].tiffinCharges);
            $scope.selectedTiffins[index].counter = $scope.selectedTiffins[index].counter + 1;
            makeGrandTotal();
        }

    };
    $scope.decrementCounter = function(index) {
        $scope.orderID="";
        if ($scope.selectedTiffins[index].counter > 1)
        {
            $scope.selectedTiffins[index].totalPrice = parseFloat($scope.selectedTiffins[index].totalPrice) - parseFloat($scope.selectedTiffins[index].tiffinCharges);
            $scope.selectedTiffins[index].counter = $scope.selectedTiffins[index].counter - 1;
            makeGrandTotal();
        }
    };

    var makeGrandTotal = function() {
        if ($scope.selectedTiffins.length > 0)
        {
            $scope.gradTotal = 0;
            for (var i = 0; i < $scope.selectedTiffins.length; i++)
            {
                $scope.gradTotal = parseFloat($scope.gradTotal) + parseFloat($scope.selectedTiffins[i].totalPrice);
            }
        } else
        {
            $scope.gradTotal = 0;
        }
    };

    $scope.proceedToPayment = function() {
        $scope.addressString = "";
        $scope.paymentSucess = false;
        if ($scope.loginUser.addressList.length > 0)
        {
            $scope.signup.address = $scope.loginUser.addressList[0];
            $scope.addressString = $scope.loginUser.addressList[0].addressLine1 ;
            if($scope.loginUser.addressList[0].addressLine2!="" && $scope.loginUser.addressList[0].addressLine2 !=undefined)
                $scope.addressString =$scope.addressString +$scope.loginUser.addressList[0].addressLine2;
            if($scope.loginUser.addressList[0].pincode!="" && $scope.loginUser.addressList[0].pincode !=undefined)
                $scope.addressString =$scope.addressString +$scope.loginUser.addressList[0].pincode;
        }
        $mdDialog.show({
            clickOutsideToClose: false,
            scope: $scope.$new(),
            preserveScope: true,
            templateUrl: 'pages/MakePaymentPage.html'
        })
                .then(function(answer) {
                    $scope.status = 'You said the information was "' + answer + '".';

                }, function() {
                    $scope.status = 'You cancelled the dialog.';

                });
    };

    $scope.registerNewUser = function() {

        if ($scope.signup.password == $scope.signup.confirmPassword)
        {
            $('.loading-container').show();
            var url = $scope.baseUrl + 'webresources/customer/addCustomer';
            var str = "fullName=" + $scope.signup.fullName + '&emailID=' + $scope.signup.emailID + '&mobile=' + $scope.signup.mobile + '&password=' + $scope.signup.password;
            HttpService.getDataFromServer(url, "POST", str, null, true, 2000, $scope.onRegisterUserSucess, $scope.onRegisterUserError, "REGISTER_USER");
        } else {
            $scope.showError = true;
            $scope.errorMsg = "Password and Confirm Password is not equal";
            $timeout(function() {
                $scope.showError = false;
            }, 2000);
        }

    };
    $scope.onRegisterUserSucess = function(data) {
        //call get tiffin service...
        if (data.messageID == '101')
        {
            $('.loading-container').hide();
            $scope.registerUser = data.customer;
            localStorage.setItem('REGISTER_USER', JSON.stringify(data.customer));
            $scope.registerUserSucess = true;
        } else if (data.messageID == '105')
        {
            $('.loading-container').hide();
            $scope.registerUserSucess = false;
            $scope.showError = true;
            $scope.errorMsg = "Oopps this mobile number is already register with us.Please login to system or make request for forgot password.";
            $timeout(function() {
                $scope.showError = false;
            }, 4000);
            $scope.showLoginWindow(event);
        } else
        {
            $('.loading-container').hide();
            $scope.registerUserSucess = false;
        }

    };
    $scope.onRegisterUserError = function(data) {
        $('.loading-container').hide();
        $scope.registerUserSucess = false;
        $scope.showError = true;
        $scope.errorMsg = "Unable to Register please try again...";
        $timeout(function() {
            $scope.showError = false;
        }, 2000);
    };

    $scope.activateAccount = function() {
        $('.loading-container').show();
        var url = $scope.baseUrl + 'webresources/customer/verify';
        var str = "customerID=" + $scope.registerUser.customerID + "&pin=" + $scope.signup.otp + "&type=Mobile";
        HttpService.getDataFromServer(url, "POST", str, null, true, 2000, $scope.onActivatedAccountSucess, $scope.onActivatedAccountError, "REGISTER_USER");
    };
    $scope.onActivatedAccountSucess = function(data) {
        //call get tiffin service...
        $('.loading-container').hide();
        if (data.messageID == '100')
        {

            $scope.showError = true;
            $scope.errorMsg = "Your account is created sucessfully.Please login to SmallBite";
            $timeout(function() {
                $scope.showError = false;
            }, 2000);
            $scope.showLoginWindow(event);
        } else
        {
            $scope.showError = true;
            $scope.errorMsg = "Invalid OTP entered..Please enter valid OTP";
            $timeout(function() {
                $scope.showError = false;
            }, 2000);
        }

    };
    $scope.onActivatedAccountError = function(data) {
        $('.loading-container').hide();
        $scope.registerUserSucess = false;
        $scope.showError = true;
        $scope.errorMsg = "Unable to Register please try again...";
        $timeout(function() {
            $scope.showError = false;
        }, 2000);
    };

    $scope.AddCustomerAddress = function() {
        if($scope.signup.address1!="" && $scope.signup.address1!=undefined)
        {
            $('.loading-container').show();
            var url = $scope.baseUrl + 'webresourcesbase/customer/addAddress';
            var str = {"addressLine1": $scope.signup.address1, "addressLine2": $scope.signup.address2, "customerID": $scope.loginUser.customerID, "pincode": $scope.signup.pinCode};
            HttpService.getDataFromServer(url, "POST", str, null, true, 2000, $scope.onAddAddressSucess, $scope.onAddAddressError, "REGISTER_USER");
        }else
        {
            $scope.showError = true;
            $scope.errorMsg = "Please enter your address....";
            $timeout(function() {
                $scope.showError = false;
            }, 2000);
        }

    };
    $scope.onAddAddressSucess = function(data) {

        if (data.messageID == '101')
        {
            $timeout(function(){
                $scope.loginUser.addressList.push(data.address);
                localStorage.setItem('USER_INFO', JSON.stringify($scope.loginUser));
                $('.loading-container').hide();
                $scope.placeOrderFromSelectedChoice();
            });

        } else
        {
            $('.loading-container').hide();
            $scope.showError = true;
            $scope.errorMsg = "Unable to Add your address please try again...";
            $timeout(function() {
                $scope.showError = false;
            }, 2000);
        }
    };
    $scope.onAddAddressError = function(data) {
        $('.loading-container').hide();
        $scope.showError = true;
        $scope.errorMsg = "Unable to Add your address please try again...";
        $timeout(function() {
            $scope.showError = false;
        }, 2000);
    };

    $scope.placeOrderFromSelectedChoice = function() {
        if($scope.orderID!="" && $scope.orderID!=undefined)
        {
            var obj={
                messageID:100,
                orderID:$scope.orderID
            };
            $scope.onPlaceOrderSucess(obj);
        }else
        {
            $('.loading-container').show();
            var url = $scope.baseUrl + 'webresources/order/addOrder';
            var paymentMode='CSH';
            if($scope.signup.paymentMode=='ONLINE')
                 paymentMode='ONL';
            else
                 paymentMode='CSH';
            var str = [{"addressID": $scope.loginUser.addressList[0].addressMasterID, "netAmount": $scope.selectedTiffins[0].totalPrice, "orderDate": dateFormat(new Date($scope.selectedTiffins[0].tiffinDate), 'mmmm dd, yyyy HH:MM:ss'), "tiffinID": $scope.selectedTiffins[0].tiffinID, "unitCount": $scope.selectedTiffins[0].counter, "userID": $scope.loginUser.customerID,"paymentMode":paymentMode}];

            HttpService.getDataFromServer(url, "POST", str, null, true, 2000, $scope.onPlaceOrderSucess, $scope.onPlaceOrderError, "REGISTER_USER");
        }

    };
    $scope.onPlaceOrderSucess = function(data) {
        $('.loading-container').hide();
        if (data.messageID == '100')
        {
            $scope.orderID = data.orderID;
            if ($scope.signup.paymentMode == 'COD')
            {
                callChangeOrderStatus(data.orderID, 'COD');
            } else
            {
                goToOnlinePayment();
            }
        } else
        {
            $scope.showError = true;
            $scope.errorMsg = "Unable to place order please try again...";
            $timeout(function() {
                $scope.showError = false;
            }, 2000);
        }
    };
    $scope.onPlaceOrderError = function(data) {
        $('.loading-container').hide();
        $scope.showError = true;
        $scope.errorMsg = "Unable to place order please try again...";
        $timeout(function() {
            $scope.showError = false;
        }, 2000);
    };
    var callChangeOrderStatus = function(orderID, paymentMode) {
        $('.loading-container').show();
        var str = "orderID=" + orderID;
        if (paymentMode == 'COD')
            str = str + "&paymentStatus=P";
        else
            str = str + "&paymentStatus=C";
        var url = $scope.baseUrl + 'webresources/order/changeStatus';
        HttpService.getDataFromServer(url, "POST", str, null, true, 2000, $scope.onPaymentStatusSucess, $scope.onPaymentStatusError, "REGISTER_USER");
    };
    $scope.onPaymentStatusSucess = function(data) {
        $('.loading-container').hide();
        if (data.messageID = '100')
        {
            $scope.paymentSucess = true;
        } else
        {
            $scope.paymentSucess = false;
            $scope.showError = true;
            $scope.errorMsg = "Unable to place order please try again...";
            $timeout(function() {
                $scope.showError = false;
            }, 2000);
        }

    };
    $scope.onPaymentStatusError = function(data) {
        $('.loading-container').hide();
        $scope.paymentSucess = false;
        $scope.showError = true;
        $scope.errorMsg = "Unable to place order please try again...";
        $timeout(function() {
            $scope.showError = false;
        }, 2000);
    };
    $scope.goToMainPage = function() {
        $scope.orderID="";
        $scope.selectedTiffins = [];
        $scope.paymentSucess = false;
        $mdDialog.hide();
    };
    var goToOnlinePayment = function() {

        var options = {
//      "key": "rzp_test_O1NHjY9aFZEJD2",  
            "key": "rzp_live_KHpCJXI9cbiiTT",
            "amount": parseFloat($scope.selectedTiffins[0].totalPrice) * 100,
            "name": "ReBind Technologies Pvt. Ltd.",
            "description": "Online meal purchase",
            "image": "img/logo.png",
            "handler": function(response) {
                callChangeOrderStatus($scope.orderID, 'ONLINE');
            },
            "prefill": {
                "name": $scope.loginUser.fullName,
                "contact": $scope.loginUser.sMSPhone,
                "email": ""
            },
            "notes": {
                "address": "Pune"
            },
            "theme": {
                "color": "#FF883F"
            }
        };
        var rzp1 = new Razorpay(options);
        rzp1.open();
        event.preventDefault();
    };



    //forgot pass code...
    $scope.openForgotPassword = function($event) {
        $scope.forgotPass = {
            mobileNumber: '',
            step1: true,
            step2: false,
            step3: false,
            reloginPin: '',
            newPassword: '',
            newConfirmPassword: ''
        };
        $mdDialog.show({
            clickOutsideToClose: false,
            scope: $scope.$new(),
            preserveScope: true,
            templateUrl: 'pages/ForgotPassword.html'
        })
                .then(function(answer) {
                    $scope.status = 'You said the information was "' + answer + '".';

                }, function() {
                    $scope.status = 'You cancelled the dialog.';

                });
    };
    $scope.checkRegisteredMobile = function() {
        $('.loading-container').show();
        var url = $scope.baseUrl + 'webresources/customer/reSend';
        var str = "mobileNumber=" + $scope.forgotPass.mobileNumber;
        HttpService.getDataFromServer(url, "POST", str, null, true, 2000, $scope.onCheckRegisteredMobileSucess, $scope.onCheckRegisteredMobileError, "REGISTER_USER");
    };
    $scope.onCheckRegisteredMobileSucess = function(data) {
        $('.loading-container').hide();
        if (data.messageID == '100')
        {
            $scope.customerID = data.customerID;
            $scope.forgotPass.step1 = false;
            $scope.forgotPass.step2 = true;
            $scope.forgotPass.step3 = false;

        } else
        {
            $scope.showError = true;
            $scope.errorMsg = "This mobile number is not registered with us. Please sign up ";
            $timeout(function() {
                $scope.showError = false;
            }, 3000);
        }
    };
    $scope.onCheckRegisteredMobileError = function(data) {
        $('.loading-container').hide();
        $scope.showError = true;
        $scope.errorMsg = "Unable to process your request..Please try again...";
        $timeout(function() {
            $scope.showError = false;
        }, 2000);
    };

    $scope.goToStep2ForForgotPassword = function() {
        $('.loading-container').show();
        var url = $scope.baseUrl + 'webresources/customer/verify';
        var str = "customerID=" + $scope.customerID + "&pin=" + $scope.forgotPass.reloginPin + "&type=Mobile&isForget=true";
        HttpService.getDataFromServer(url, "POST", str, null, true, 2000, $scope.onReloginPinCheckSucess, $scope.onReloginPinCheckError, "REGISTER_USER");
    };
    $scope.onReloginPinCheckSucess = function(data) {
        $('.loading-container').hide();
        if (data.messageID == '100')
        {
            $scope.forgotPass.step1 = false;
            $scope.forgotPass.step2 = false;
            $scope.forgotPass.step3 = true;
        } else
        {
            $scope.showError = true;
            $scope.errorMsg = "Please enter valid pin...";
            $timeout(function() {
                $scope.showError = false;
            }, 2000);
        }
    };
    $scope.onReloginPinCheckError = function(data) {
        $('.loading-container').hide();
        $scope.showError = true;
        $scope.errorMsg = "Unable to process your request..Try again";
        $timeout(function() {
            $scope.showError = false;
        }, 2000);
    };

    $scope.goToStep3ForForgotPassword = function() {

        if ($scope.forgotPass.newPassword == $scope.forgotPass.newConfirmPassword)
        {
            $('.loading-container').show();
            var url = $scope.baseUrl + 'webresources/login/changePasswrd';
            var str = "userID=" + $scope.customerID + "&password=" + $scope.forgotPass.newPassword;
            HttpService.getDataFromServer(url, "POST", str, null, true, 2000, $scope.onResetPasswordSucess, $scope.onResetPasswordError, "REGISTER_USER");
        } else
        {
            $scope.showError = true;
            $scope.errorMsg = "Password and Confirm Password is not equal";
            $timeout(function() {
                $scope.showError = false;
            }, 2000);
        }

    };
    $scope.onResetPasswordSucess = function(data) {
        $('.loading-container').hide();
        if (data.messageID == '100')
        {
            $scope.showError = true;
            $scope.errorMsg = "Your password changed sucessfully.Please login to system...";
            $timeout(function() {
                $scope.showError = false;
            }, 3000);
            $mdDialog.hide();
            $scope.showLoginWindow(event);
        } else
        {
            $scope.showError = true;
            $scope.errorMsg = "Unable to process your request..Try again";
            $timeout(function() {
                $scope.showError = false;
            }, 2000);
        }
    };
    $scope.onResetPasswordError = function(data) {
        $('.loading-container').hide();
        $scope.showError = true;
        $scope.errorMsg = "Unable to process your request..Try again";
        $timeout(function() {
            $scope.showError = false;
        }, 2000);
    };

    var cancelOrderID="";
    $scope.cancelOrderByUser=function(orderID){
        cancelOrderID=orderID;
        $scope.ReasonForConfirmDialog='CANCEL_ORDER';
        $scope.confirmationMessage='Are you sure to cancel this order??';
        $mdDialog.show({
            clickOutsideToClose: false,
            scope: $scope.$new(),
            skipHide:true,
            preserveScope: true,
            templateUrl: 'pages/ConfirmDialogPage.html'
        })
            .then(function(answer) {
                $scope.status = 'You said the information was "' + answer + '".';

            }, function() {
                $scope.status = 'You cancelled the dialog.';

            });
    };
    $scope.confirmationResponse=function(confirmResponse){
       if(confirmResponse=='NO')
       {
           $mdDialog.hide();
           return;
       }else
       {
           if($scope.ReasonForConfirmDialog=='CANCEL_ORDER')
           {
               callCancelOrderFun(cancelOrderID);
               $mdDialog.hide();
           }else if($scope.ReasonForConfirmDialog=='LOGOUT'){
               $scope.loginSucess = false;
               localStorage.removeItem('USER_INFO');
               localStorage.removeItem('REGISTER_USER');
               $mdDialog.hide();
           }
       }
    };

    var callCancelOrderFun=function(orderID){
        $('.loading-container').show();
        var str = "orderID=" + orderID;
        str = str + "&paymentStatus=X";
        var url = $scope.baseUrl + 'webresources/order/changeStatus';
        HttpService.getDataFromServer(url, "POST", str, null, true, 2000, $scope.onOrderStatusChangeSucess, $scope.onOrderStatusChangeError, "REGISTER_USER");
    };
    $scope.onOrderStatusChangeSucess=function(data){

        if (data.messageID = '100')
        {
            $scope.showError = true;
            $scope.errorMsg = "Your order is cancelled...";
            $timeout(function() {
                $scope.showError = false;
            }, 2000);
            for(var i=0;i<$scope.orderHistory.length;i++)
            {
                if($scope.orderHistory[i].orderID==cancelOrderID)
                {
                    $scope.orderHistory[i].paymentStatus='X';
                    $scope.orderHistory[i].cancelOrder=false;
                    break;
                }
            }
            $('.loading-container').hide();
        } else
        {
            $('.loading-container').hide();
            $scope.showError = true;
            $scope.errorMsg = "Unable to cancel order please try again...";
            $timeout(function() {
                $scope.showError = false;
            }, 2000);
        }
    };
    $scope.onOrderStatusChangeError=function(data){
        $('.loading-container').hide();
        $scope.showError = true;
        $scope.errorMsg = "Unable to cancel order please try again...";
        $timeout(function() {
            $scope.showError = false;
        }, 2000);
    };
    $scope.showUserProfile=function($event){
        $mdDialog.show({
            clickOutsideToClose: false,
            scope: $scope.$new(),
            skipHide:true,
            preserveScope: true,
            templateUrl: 'pages/UserProfilePage.html'
        })
            .then(function(answer) {
                $scope.status = 'You said the information was "' + answer + '".';

            }, function() {
                $scope.status = 'You cancelled the dialog.';

            });
    };
});

angular.module('ui.bootstrap.demo').service('HttpService', function($http) {
    return{
        getDataFromServer: function(url, methodType, requestParameters, httpBody, isAsync, timeOut, successCallBack, errorCallBack, requestIdentifier) {
            this.callService(url, methodType, requestParameters, httpBody, isAsync, timeOut, successCallBack, errorCallBack, requestIdentifier);
        },
        callService: function(url, methodType, requestParameters, httpBody, isAsync, timeOut, successCallBack, errorCallBack, requestIdentifier) {
            $http({
                method: "POST",
                url: url,
                timeout: 6000,
                data: requestParameters ? requestParameters : "",
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            }).success(function(data, status) {
                successCallBack(data, requestIdentifier);
            }).error(function(data, status, headers, config, statusText) {
                errorCallBack({"status": status, "statusText": "Some Error Occurred."}, requestIdentifier)
            });
        }
    };
});