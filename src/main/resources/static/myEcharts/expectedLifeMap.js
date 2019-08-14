//根据id: ExpectedLife 选择画板
var expectedLifeMap;
var expectedLifeMapData = [];
var expectedLifeOpt = {
    backgroundColor: "rgba(239,255,233,0.69)",
    title: {
        top:30,
        id: "liang",
        text: "不同地区预期寿命",
        x: 'center',
    },
    tooltip: {
        trigger: 'item',
        formatter: function (params,ticket,callback) {
            // console.log(params);
            if(params.data!=null&&params.data){
                return params.name+"省预期寿命"+params.data['value']+"岁";
            }else{
                return "暂无数据";
            }
        }

    },
    label: {
        textStyle: {
            fontFamily: 'monospace',
            fontSize: 2,
        },
        backgroundColor: '#c4d7dd',


    },
    visualMap: {
        show: true,
        x: 'left',
        y: 'bottom',
        splitList: [
            {start: 80, end: 83},
            {start: 78, end: 80},
            {start: 74, end: 77},
            {start: 71, end: 74},
            {start: 68, end: 71},
            {start: 65, end: 68},
        ],
        formatter:"{value}岁-{value2}岁",
        color: ['#f1c40f','#A0B3EE', '#D8EEC0',
            '#F4B4A8','#e74c3c', '#FEFC94']
    },
    series: [{
        name: '数据',
        type: 'map',
        mapType: 'china',
        roam: false,
        label: {
            show: false,
            emphasis: {
                show: false
            }
        },
        data: expectedLifeMapData
    },
    ]
}

function getexpectedLifeMapData() {
    $.ajax({
        url:"/expectedLifeMap",
        type:"POST",
        dataType:"json",
        error:function (data) {
            console.log(data)
        },
        success:function (data) {
            console.log(data);
            expectedLifeMapData = data["data"];
            expectedLifeOpt.series[0].data=expectedLifeMapData;
            expectedLifeMap.setOption(expectedLifeOpt);

            expectedLifeMap.hideLoading()
        }
    })
}

