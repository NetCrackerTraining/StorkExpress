/**
 * Created by Alexandr on 24.11.2016.
 */
function phoneCheck(input) {
    ch = input.value.replace(/[^\d+ ]/g, '');
    document.getElementById('phone_number').onkeypress = function (e) {
    }
    input.value = ch;
}
function phoneCheck2(input) {
    ch = input.value.replace(/[^\d+ ]/g, '');
    document.getElementById('newPhoneNumber').onkeypress = function (e) {
    }
    input.value = ch;
}



function checkEmail() {
    var email = document.getElementById('email');
    var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if (!filter.test(email.value)) {
        alert('Please provide a valid email address');
        return false;
    }
}