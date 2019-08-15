// id => resultToBar
var resultToBar ;
var resultToBar_option = {
    title:{
      text:"用户表单",
    },
    color: ['#db858a'],
    tooltip : {
        trigger: 'axis',
        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
        }
    },
    toolbox:{
        feature:{
            saveAsImage:{},
            magicType:{
                type:['line','bar']
            },
            dataView:{},
        }
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis : [
        {
            type : 'category',
            data : [],
            axisTick: {
                alignWithLabel: true
            }
        }
    ],
    yAxis : [
        {
            type : 'value'
        }
    ],
    series : [
        {

            name:'数值',
            type:'bar',
            barWidth: '60%',
            data:[]
        }
    ]
};

setInterval(resultToBarFunc,1000)
function resultToBarFunc() {
    $.ajax({
        url:"/resultToBar",
        dataType:"json",
        method:"POST",
        error:function (data) {
            console.log(data)
        },
        success:function (data) {
            console.log(data);
            var legendData = data["legendData"];
            var xData = data["xData"];
            resultToBar_option.xAxis[0].data=legendData;
            resultToBar_option.series[0].data=xData;
            resultToBar.setOption(resultToBar_option);
            resultToBar.hideLoading();
        }
    })
}

function sendJsonBar(){
    $.ajax({
        url:"/dataJsonBar",
        dataType:"json",
        type:"POST",
        data:JSON.stringify({"data":$("#dataBar").val()}),
        contentType:"application/json;charset=utf-8",
        error:function (data) {
            console.log(data);
        },
        success:function(data){
            console.log(data);
        }
    })
}

