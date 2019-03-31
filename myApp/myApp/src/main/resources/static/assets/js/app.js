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
        if (!$(e).hasClass("ignore")){
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
        }
    });
});

function professional(element){
    var username = $(element).data("username");
    $.ajax({
        "url": "/requestModal/"+username,
        "method": "GET"
    }).done(function (data) {
        $("#listaSolicitudesTable").html(data);
    });
}


function requestTime(element) {
    var requestDate = Date.now().toString();
    $("#modal_requestDate").val(requestDate);
    var m = $("#mounth").val();
    var d = $("#day").val();
    var t = $("#time").val();
    $("#modal_serviceDate").val(m+"/"+d+"/"+t);
}

function serviceData(element) {
    var id = $(element).data("id");
    var professional = $(element).data("professional");
    var name = $(element).data("name");
    var category = $(element).data("category");
    var estimateTime = $(element).data("estimate_time");
    var cost = $(element).data("cost");
    var description = $(element).data("description");
    $("#modal_id").val(id);
    $("#modal_professional").val(professional);
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
        "url": "/" +"service" + "/" + "user" +"/"+  user_id + "/" + service_id,
        "method": "DELETE",
    }).done(refreshPage);
}

function removeRequest(request_id,element) {
    var service_id =$(element).parent().parent().prev(".serviceId").val();
    $.ajax({
        "url": "/" +"service" + "/" + "request" + "/" + request_id + "/" + service_id,
        "method": "DELETE",
    }).done(refreshPage);
}

function acceptRequest(request) {
    $.ajax({
        "url": "/" + "request"+"/" + "request"+"/" +request,
        "method": "POST",
    }).done(refreshPage);
}