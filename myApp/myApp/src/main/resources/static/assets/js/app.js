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

$(document).ready(function () {
    $("form").submit(function (e) {
        e.preventDefault();
        var formData = new FormData($(this)[0]);
        $.ajax({
            "url": $(this).attr("action"),
            "method": $(this).attr("method") || "POST",
            "data": formData,
            "cache": false,
            "contentType": false,
            "processData": false
        }).done(refreshPage);
    });
});

function serviceData(element) {
    var name = $(element).data("name");
    var category = $(element).data("category");
    var estimateTime = $(element).data("estimate_time");
    var cost = $(element).data("cost");
    var description = $(element).data("description");
    $("#modal_name").val(name);
    $("#modal_category").val(category);
    $("#modal_estimateTime").val(estimateTime);
    $("#modal_cost").val(cost);
    $("#modal_description").val(description);
}

function professionalData(element) {
    var name = $(element).data("name");
    var username = $(element).data("username");
    var birthday = $(element).data("birthday");
    var city = $(element).data("city");
    $("#modal_name").val(name);
    $("#modal_username").val(username);
    $("#modal_birthday").val(birthday);
    $("#modal_city").val(city);
}

function deleteService(user_id,service_id) {
    $.ajax({
        "url": "/" + user_id + "/" + service_id,
        "method": "DELETE",
    }).done(refreshPage);
}