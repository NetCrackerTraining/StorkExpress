/**
 * Created by Alexandr on 24.11.2016.
 */
function phoneCheck(input) {
    ch = input.value.replace(/[^\d]/g, '');
    document.getElementById('phone_number').onkeypress = function (e) {
    }
    input.value = ch;
}
