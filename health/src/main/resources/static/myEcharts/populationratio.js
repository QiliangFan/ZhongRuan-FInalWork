//id : populationratio
var populationratio;

function loadLocalDataAndShowPopulationratio() {

    populationratio.showLoading();

    var years = [];
    var birthRates = [];
    var mortalityRates = [];
    var naturalGrowthRates = [];

    $.ajax({
        type : 'get',
        url : '/getpopuratio',
        dataType : "json",
        success : function(result){
            // 提取数组中的每一个元素的 category 和 num 分别放入 names、nums
            console.log(result);
            $.each(result, function(index, item) {
                // alert(index + item.year);
                years.push(item.year);
                birthRates.push(item.birthrate);
                mortalityRates.push(item.mortalityrate);
                naturalGrowthRates.push(item.naturalgrowthrate);
            });
                populationratio.hideLoading();
                populationratio.setOption({
                    title: {
                        text: ''
                    },
                    tooltip: {
                        trigger: 'axis'
                    },
                    legend: {
                        data: ['出生率', '死亡率', '自然增长率']
                    },
                    grid: {
                        left: '3%',
                        right: '4%',
                        bottom: '3%',
                        containLabel: true
                    },
                    toolbox: {
                        feature: {
                            saveAsImage: {}
                        }
                    },
                    xAxis: {
                        type: 'category',
                        boundaryGap: false,
                        data: years
                    },
                    yAxis: {
                        type: 'value',
                        axisLabel: {
                            show: true,
                            interval: 'auto',
                            formatter: '{value}%'
                        },
                        show: true
                    },
                    series: [
                        {
                            name: '出生率',
                            type: 'line',
                            stack: '总量',
                            data: birthRates
                        },
                        {
                            name: '死亡率',
                            type: 'line',
                            stack: '总量',
                            data: mortalityRates
                        },
                        {
                            name: '自然增长率',
                            type: 'line',
                            stack: '总量',
                            data: naturalGrowthRates
                        }
                    ]
                });
        },
        error : function(errorMsg){
            console.log(errorMsg);
            populationratio.hideLoading();
        }
    })
}
