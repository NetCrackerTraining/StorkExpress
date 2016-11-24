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
function weightCheck(input) {
    ch = input.value.replace(/[^\d,.]/g, '');
    document.getElementById('weight').onkeypress = function (e) {
        if (this.value.indexOf(".") != '-1' || this.value.indexOf(",") != '-1') {
            return !(/[.,]/.test(String.fromCharCode(e.charCode)));
        }
    }
    input.value = ch;
}