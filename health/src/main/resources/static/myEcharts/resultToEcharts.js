$(function () {
    $("#choosePie").hide();
    $("#chooseBar").hide();
    $("#myBarButton").on("mouseenter",function () {
        $("#myBar").addClass("enter");
        $("#chooseBar").fadeIn("slow");
    });
    $("#myBarButton").on("mouseleave",function () {
        $("#myBar").removeClass("enter");
        $("#chooseBar").hide();
    });
    $("#myPieButton").on("mouseenter",function () {
        $("#myPie").addClass("enter");
        $("#choosePie").fadeIn("slow");
    });
    $("#myPieButton").on("mouseleave",function () {
        $("#myPie").removeClass("enter");
        $("#choosePie").hide();
    })

})