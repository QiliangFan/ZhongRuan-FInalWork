// id: popu2

function loadLocalDataAndShowPopu2(){
    var myChart = echarts.init(document.getElementById('popu2'));
    var posList = [
        'left', 'right', 'top', 'bottom',
        'inside',
        'insideTop', 'insideLeft', 'insideRight', 'insideBottom',
        'insideTopLeft', 'insideTopRight', 'insideBottomLeft', 'insideBottomRight'
    ];
    var app = {};
    app.configParameters = {
        rotate: {
            min: -90,
            max: 90
        },
        align: {
            options: {
                left: 'left',
                center: 'center',
                right: 'right'
            }
        },
        verticalAlign: {
            options: {
                top: 'top',
                middle: 'middle',
                bottom: 'bottom'
            }
        },
        position: {
            options: echarts.util.reduce(posList, function (map, pos) {
                map[pos] = pos;
                return map;
            }, {})
        },
        distance: {
            min: 0,
            max: 100
        }
    };

    app.config = {
        rotate: 90,
        align: 'left',
        verticalAlign: 'middle',
        position: 'insideBottom',
        distance: 15,
        onChange: function () {
            var labelOption = {
                normal: {
                    rotate: app.config.rotate,
                    align: app.config.align,
                    verticalAlign: app.config.verticalAlign,
                    position: app.config.position,
                    distance: app.config.distance
                }
            };
            myChart.setOption({
                series: [{
                    label: labelOption
                }, {
                    label: labelOption
                }, {
                    label: labelOption
                }, {
                    label: labelOption
                }]
            });
        }
    };


    var labelOption = {
        normal: {

            show: true,
            position: app.config.position,
            distance: app.config.distance,
            align: app.config.align,
            verticalAlign: app.config.verticalAlign,
            rotate: app.config.rotate,
            formatter: '{c}  {name|{a}}',
            fontSize: 16,
            rich: {
                name: {
                    textBorderColor: '#fff'
                }
            }
        }
    };

    myChart.setOption({
        color: ['#003366', '#006699', '#4cabce', '#e5323e'],
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            }
        },
        legend: {
            data: ['出生率', '死亡率', '自然增长率']
        },
        toolbox: {
            show: true,
            orient: 'vertical',
            left: 'right',
            top: 'center',
            feature: {
                mark: {show: true},
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar', 'stack', 'tiled']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        calculable: true,
        xAxis: [
            {
                type: 'category',
                axisTick: {show: false},
                data: ['2012', '2013', '2014', '2015', '2016']
            }
        ],
        yAxis: [

            {
                type: 'value',
                axisLabel:{ show: true,
                    interval: 'auto',
                    formatter: '{value}%' },
                show: true
            }
        ],
        series: [
            {
                name: '出生率',
                type: 'bar',
                barGap: 0,
                // label: labelOption,
                data: []
            },
            {
                name: '死亡率',
                type: 'bar',
                // label: labelOption,
                data: []
            },
            {
                name: '自然增长率',
                type: 'bar',
                // label: labelOption,
                data: []
            }
        ]
    });
    myChart.showLoading();
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
            $.each(result, function(index, item){
                if(years.indexOf(item.year)==-1) {
                    years.push(item.year);
                    birthRates.push(item.birthrate);
                    mortalityRates.push(item.mortalityrate);
                    naturalGrowthRates.push(item.naturalgrowthrate);
                }
            });

            myChart.hideLoading();
            myChart.setOption({
                xAxis : {
                    data : years
                },
                series : [ {
                    data : birthRates
                },{
                    data:mortalityRates
                },{
                    data:naturalGrowthRates
                }
                ]
            });
        },
        error : function(errorMsg){
            console.log(errorMsg);
            myChart.hideLoading();
        }
    });
}