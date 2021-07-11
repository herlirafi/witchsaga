function clickFunction() {
    var option = {
        'personA1': document.getElementById("one").value,
        'personA2': document.getElementById("two").value,
        'personB1': document.getElementById("three").value,
        'personB2': document.getElementById("four").value
    }
    $.ajax({
        url: '/',
        async: false,
        type: 'POST',
        data: option,
        success: function () {
            console.log('success')
        },
        error: function (e) {
            console.log('failed : ' + e)
        }
    })
}

function clearFunction() {
    document.getElementById("one").value = '';
    document.getElementById("two").value = '';
    document.getElementById("three").value = '';
    document.getElementById("four").value = '';
}