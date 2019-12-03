$(function () {
    //初始化查询下啦列表
    initSelOption();}
);
function initSelOption() {
    $.ajax({
        url: "showAllDistrict.do",
        type: "post",
        dataType: "json",
        data: {},
        async: true,
        success: function (obj) {
            var str = "";
            $.each(obj, function (i) {
                str += `
               <option value="${obj[i].id}">${obj[i].name}</option>
               `
            });
            //获取下拉列表
            $("#selDistrictSel").append(str);
        },
        error: function () {
            alert("initSelOption error");
        }
    })
}