$(function () {
    //点击保存按钮
    $(".save").click(function(){
        saveInfo();
    })
});
function saveInfo() {
    //ajax
    $.ajax({
        url :"insert.do",
        type:"post",
        dataType :"json",
        data : $("#save").serialize(),
        async : true,
        success : function(obj) {
            if (obj!==0){
                location.href ="list.html"
            }else {
                alert("增加失败,请填写必要信息");
            }
        },
        error : function(){
            alert("saveInfo error");
        }
    })
}