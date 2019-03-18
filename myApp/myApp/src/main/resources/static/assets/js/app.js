function refreshPage() {
    $.ajax({
        "url": window.location.pathname,
        "method": "GET"
    }).done(function (data) {
        var newDoc = document.open("text/html", "replace");
        newDoc.write(data);
        newDoc.close();
    });
}

function addService(id, token) {
    $.ajax({
        "method": "POST",
        "url": "/service/" + id,
        "data": "_csrf=" + token
    }).done(refreshPage);
}