$(function () {
    //select all info and show by that id
    //1. get the id
    var id = getLocationParam("id");
    //2. get the info by that id,and give the value to input
    getInfo(id);
    //3.click the edit
    $(".edit").click(function () {
        //just do it(edit)
        $.ajax({
            url: "updateByPrimaryKey.do",
            type: "post",
            dataType: "json",
            data: $("#edit").serialize(),
            async: true,
            success: function (obj) {
                if(obj !== 0){
                   location.href ="list.html";
                }else {
                    alert("更新失败,请填写必要信息");
                }
            },
            error: function () {
                alert("update error")
            }
        })
    });
    //4. click the delete
    $(".delete").click(function () {
        //just do it(delete)
        $.ajax({
            url: "deleteByPrimaryKey.do",
            type: "post",
            dataType: "json",
            data:{"id":id},
            async: true,
            success: function (obj) {
                if(obj !== 0){
                    location.href ="list.html";
                }else {
                    alert("删除失败");
                }
            },
            error: function () {
                alert("delete error")
            }
        })
    })
});

//(很重要)截取地址栏上的参数
function getLocationParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    // alert(window.location.search);
    if (r != null) return unescape(r[2]);
    return null;
}

function getInfo(id) {
    //ajax
    $.ajax({
        url: "info.do",
        type: "post",
        dataType: "json",
        data: {"airQualityIndex.id": id},
        async: true,
        success: function (obj) {
            console.log(obj);
            //give the value to input
            //select the input
            $("[name=id]").val(id);
            $("[name=districtId]").val(obj.airQualityIndex.districtId);

            $("[name=monitorTime]").val(obj.airQualityIndex.monitorTime);
            $("[name=pm10]").val(obj.airQualityIndex.pm10);
            $("[name=pm2_5]").val(obj.airQualityIndex.pm2_5);
            $("[name=monitoringStation]").val(obj.airQualityIndex.monitoringStation);
            $("#lastUpdateTime").html(obj.airQualityIndex.lastModifyTime);
        },
        error: function () {
            alert("getInfo error");
        }
    })
}