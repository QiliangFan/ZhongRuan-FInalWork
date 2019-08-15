// id  < = resultToPie
var resultToPie;
var resultToPie_option ={
    title:{
        text:"用户表单",
    },
    color:['#db858a',"#58bdff","#99cbab",
        '#db412a',"#d097ff","#007fcb",
        '#a629db',"#ffb3e8","#00ff6d"],
    tooltip:{
        trigger:'item',
        formatter:"{b}: {c}({d}%)",
    },
    toolbox:{
        feature:{
            saveAsImage:{},
            dataView:{},
        }
    },
    legend:{
        top:20,
        orient:'vertical',
        x:'left',
        data:[],
    },
    series:[
        {
            name:"用户表单",
            type:"pie",
            radius:["50%","70%"],
            // avoidLabelOverlap:false,
            label:{
                normal:{
                    show:false,
                    position:'center',
                },
                emphasis:{
                    show:true,
                    textStyle:{
                        fontSize:'30',
                        fontWeight:'bold'
                    }
                }
            },
            labelLine:{
                normal:{
                    show:false,
                }
            },
            data:[]
        }
    ]
};

function convertPiexData(lData, xData){
    var result = []
    for(var i =0;i<lData.length;i++){
        result.push({'name':lData[i],'value':xData[i]})
    }
    return result;
}

function resultToPieFunc() {
    $.ajax({
        url:"/resultToPie",
        dataType:"json",
        method:"POST",
        error:function(data){
            console.log(data)
        },
        success:function (data) {
            console.log(data);
            var legendData = data["legendData"];
            var xData = data["xData"];
            resultToPie_option.legend.data=legendData;
            resultToPie_option.series[0].data=convertPiexData(legendData,xData);
            resultToPie.setOption(resultToPie_option)
            resultToPie.hideLoading();
        }
    })
}

function sendJsonPie(){
    $.ajax({
        url:"/dataJsonPie",
        dataType:"json",
        type:"POST",
        data:JSON.stringify({"data":$("#dataPie").val()}),
        contentType:"application/json;charset=utf-8",
        error:function (data) {
            console.log(data);
        },
        success:function(data){
            console.log(data);
        }
    })
}

setInterval(resultToPieFunc,1000)