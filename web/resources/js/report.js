function exportTb(filename){
    $(".list-box").table2excel({
        exclude: ".noExl",
        name: "Excel Document Name",
        filename: filename,
        exclude_img: true,
        exclude_links: true,
        exclude_inputs: true
    });
}
function getToday(){
    let nowDate = new Date();
    let year = nowDate.getFullYear();
    let month = nowDate.getMonth() + 1 < 10 ? "0" + (nowDate.getMonth() + 1)
        : nowDate.getMonth() + 1;
    let day = nowDate.getDate() < 10 ? "0" + nowDate.getDate() : nowDate
        .getDate();
    let dateStr = year + "-" + month + "-" + day;
    $("input.date-select").val(dateStr)
    return dateStr
}

/*
<div className="list-row-item">
    <div className="list-cell pos-name" style="width: auto; flex: 1 1 0%;">
                                            <span className="list-cell-span"
                                                  title="猫南北">猫南北</span>
    </div>
    <div className="list-cell pos-cate" style="width: auto; flex: 1 1 0%;">
        <span className="list-cell-span" title="tldj001">tldj001</span>
    </div>
    <div className="list-cell pos-workType" style="width: auto; flex: 1 1 0%;">
        <span className="list-cell-span" title="15">15</span>
    </div>
    <div className="list-cell pos-pubTime" style="width: auto; flex: 1 1 0%;">
        <span className="list-cell-span" title="2021-06-28">2021-06-28</span>
    </div>
    <div className="list-cell pos-locate" style="width: auto; flex: 1 1 0%;">
        <span className="list-cell-span" title="云霄飞车">云霄飞车</span>
    </div>
</div>
*/
