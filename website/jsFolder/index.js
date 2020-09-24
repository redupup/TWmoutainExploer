

$("#container").css("display","none")
$("body").append('<div id="homeCon">')
$("#homeCon").css( {
    "position": "absolute",
    "height" : "100%",
    "width" : "100%",
    "background-image" : "url('images/topBar1.png')", 
    "background-size":"cover",
    // "background"
}).append('<H1 id="bigTitle">岳進者</H1>');

$("#bigTitle").css({
    "position": "absolute",
    "top" : "0%",
    "left" : "10%",
    // "border" : "1px solid red",
    "font-size" : "175px",
    "text-align" : "center",
    "opacity" : "0",
    "cursor" : "pointer"
});



$("#homeCon").append('<ul id="sliderCon"></ul>')
let  = $("#sliderCon")
$("#sliderCon").css({
    "list-style-type" : "none",
    "position" : "absolute",
    "top" : "45%",
    "left" : "3%",
    "width" : "30%",
    "height" : "40%",
})

for (let i = 1; i <= 4; i++) {
    $("#sliderCon").append(`<li id="sliderLi${i}">${i}</li>`);
    $(`#sliderLi${i}`).css({
        "position" : "relative",
        "top" : (i-1)*20+"px",
        "left" : (i-1)*100+"px",
        "transition" : "2s",
        "opacity" : "0",
        "cursor" : "pointer",
        // "border" : "1px solid red"

    })
}
$("#sliderLi1").text("登山查詢").css({
    "list-style-image" : "url('images/indexLi1.png')",
    "font-size" : "50px",
    "width" : "200px"
})
$("#sliderLi2").text("會員登入").css({
    "list-style-image" : "url('images/indexLi4.png')",
    "font-size" : "50px",
    "width" : "200px"
})
$("#sliderLi3").text("地區天氣查詢").css({
    "list-style-image" : "url('images/indexLi2.png')",
    "font-size" : "50px",
    "width" : "300px"
})
$("#sliderLi4").text("露營地/小屋查詢").css({
    "list-style-image" : "url('images/indexLi3.png')",
    "font-size" : "50px",
    "width" : "370px"
})

window.setTimeout(function(){
    $("#bigTitle").css({
        "top" : "10%",
        "opacity" : "1",
        "transition" : "2S"

    })
    
},0)

for (let i = 1; i <= 4; i++) {
    window.setTimeout(function(){
        $(`#sliderLi${i}`).css({
            "left" :  "+=200px",
            "opacity":"1"
        })
    },800*(i))
    
}

$("#bigTitle").click(function(){
    $("#homeCon").fadeOut(1500);
    window.setTimeout(function(){
        $("#container").css("display","block");
    },1000)

})

