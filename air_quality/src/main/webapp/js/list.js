$(function () {
    // 初始化分页数据
    initPageData(1);
    //条件查找
    $("[type=button]").click(function () {
        initPageData(1);
    });

});



function initPageData(pageNo) {
    var table = $("table");
    var pageFoot = $("[class=pageFoot]");
    var districtId = $("[name=districtId]").val();
    $.ajax({
        url: "selectByPrimaryKey.do",
        type: "post",
        dataType: "json",
        data: {"pageNo": pageNo, "airQualityIndex.districtId": districtId},
        async: true,
        success: function (obj) {
            var tableStr = "";
            console.log(obj.airQualityIndexList.length===0);
            if (obj.airQualityIndexList.length===0){
                $("tr:gt(0)").remove();
                tableStr=`
                <tr style="text-align: center">
                    <td colspan="6"><strong>抱歉,暂无数据</strong></td>
                </tr>
                `;
            }else{
                //在循环的前面清空标题以下的所有行
                //获取行>0的那行.移除方法
                $("tr:gt(0)").remove();
                $.each(obj.airQualityIndexList, function (i) {
                    tableStr += `
                <tr>
                  <td>${obj.airQualityIndexList[i].id}</td>
                  <td> <a href="edit.html?id=${obj.airQualityIndexList[i].id}">${obj.airQualityIndexList[i].name}</a></td>
                  <td>${obj.airQualityIndexList[i].monitorTime}</td>
                  <td>${obj.airQualityIndexList[i].pm10}</td>
                  <td>${obj.airQualityIndexList[i].pm2_5}</td>
                  <td>${obj.airQualityIndexList[i].monitoringStation}</td>
                </tr>
                `;
                });
            }
            table.attr("width", "600");
            table.append(tableStr);
            $("tr").first().attr("style", "background-color:#ADD8E6");
            $("tr:gt(0):odd").attr("style", "background-color:#90EE90");

            //分页
            //在分页前,清空原来分页的内容
            pageFoot.html("");
            var pageStr = "";
            if(obj.pageUtils.totalCount===0){//如果没有数据,就不显示分页条
                return ;
            }
            if (obj.pageUtils.pageNo === 1 && obj.pageUtils.pageNo !== obj.pageUtils.totalPages) {//如果是第一页,并且还有下一页
                pageStr = `
                <a href="javascript:void(0);" style="text-decoration: none;color: grey;cursor:no-drop;">首&nbsp;页</a>|
                <a href="javascript:void(0);" style="text-decoration: none;color: grey;cursor:no-drop;"><< 上一页</a>|
                <a href="javascript:void(0);" onclick="initPageData(${obj.pageUtils.pageNo + 1 });">下一页>></a>|
                <a href="javascript:void(0);" onclick="initPageData(${obj.pageUtils.totalPages});">尾&nbsp;页</a>
                `
            }else if (obj.pageUtils.pageNo === 1 && obj.pageUtils.pageNo !== obj.pageUtils.totalPages) {//如果是第一页,并且没有有下一页
                pageStr = ``//nothing to do
            }else if(obj.pageUtils.pageNo !== 1 && obj.pageUtils.pageNo !== obj.pageUtils.totalPages){//如果不是第一页,并且还有下一页
                pageStr = `
                <a href="javascript:void(0);" onclick="initPageData(1)">首&nbsp;页</a>|
                <a href="javascript:void(0);" onclick="initPageData(${obj.pageUtils.pageNo - 1 });"><< 上一页</a>|
                <a href="javascript:void(0);" onclick="initPageData(${obj.pageUtils.pageNo + 1 });">下一页>></a>|
                <a href="javascript:void(0);" onclick="initPageData(${obj.pageUtils.totalPages});">尾&nbsp;页</a>
                `
            }else if(obj.pageUtils.pageNo !== 1 && obj.pageUtils.pageNo === obj.pageUtils.totalPages){//如果不是第一页,且是最后一页
                pageStr = `
                <a href="javascript:void(0);" onclick="initPageData(1)">首&nbsp;页</a>|
                <a href="javascript:void(0);" onclick="initPageData(${obj.pageUtils.pageNo - 1 })"><< 上一页</a>|
                <a href="javascript:void(0);" style="text-decoration: none;color: grey;cursor:no-drop;">下一页>></a>|
                <a href="javascript:void(0);" style="text-decoration: none;color: grey;cursor:no-drop;">尾&nbsp;页</a>
                `
            }
            pageStr += `
            第&nbsp;
                ${obj.pageUtils.pageNo}
                页/共
                ${obj.pageUtils.totalPages}
                页(${obj.pageUtils.totalCount}条)
            `;
            pageFoot.append(pageStr);
        },
        error: function () {
            alert("initPageData error");
        }
    })
}