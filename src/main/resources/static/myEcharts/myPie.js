//能量的食物来源
var title_text_energy_food = "城乡居民的能量来源";
var data_energy_food = [
    ['category', '城市情况\n2002', '城市情况\n2012', '农村情况\n2002', '农村情况\n2012'],
    ['谷类', "48.5", "47.1", "61.5", "58.8"],
    ['动物性实物类', '17.6', '17.6', '10.7', '12.5'],
    ['其他', '33.9', '35.3', '27.8', '28.7']
];
var opt1 = {
    color:['#D92943','#9FB1F1','#DCEEBE'],
    title: {
        text: title_text_energy_food
    },
    legend: {},
    tooltip: {
        axisPointer: {
            type: 'cross',
            label:{
                backgroundColor:'rgba(2,1,2,0.24)',
            }
        },
        formatter: "{a}{b}\n{d}%"
    },
    dataset: {
        source: data_energy_food
    },
    label: {
        formatter: "{a}{b}\n {d}%"
    },
    series: [{
        name: '2002年城市情况',
        type: 'pie',
        radius: 60,
        center: ['25%', '30%'],
        encode: {
            itemName: 'category',
            value: '城市情况\n2002'
        }


    }, {
        name: '20012年城市情况',
        type: 'pie',
        radius: 60,
        center: ['75%', '30%'],
        encode: {
            itemName: 'category',
            value: '城市情况\n2012'
        }
    }, {
        name: '2002年乡村情况',
        type: 'pie',
        radius: 60,
        center: ['25%', '75%'],
        encode: {
            itemName: 'category',
            value: '农村情况\n2002'
        }
    }, {
        name: '2012年城市情况',
        type: 'pie',
        radius: 60,
        center: ['75%', '75%'],
        encode: {
            itemName: 'category',
            value: '农村情况\n2012',
        }
    }
    ]

};

//能量的营养来源
var title_text_energy_nutr = "城乡居民的营养素来源";
var data_energy_nutr = [
    ['category', '城市情况\n2002', '城市情况\n2012', '农村情况\n2002', '农村情况\n2012'],
    ['蛋白质', '13.1', '12.9', '11.3', '11.2'],
    ['脂肪', '35.0', '36.1', '27.5', '29.7'],
    ['碳水化合物', '51.9', '51.0', '61.2', '59.1'],
];
var opt2 =  {
    title: {
        text: title_text_energy_nutr,
    },
    legend: {},
    tooltip: {
        formatter: "{a}{b}\n {d}%",
        axisPointer: {
            type: 'cross',
            label:{
                backgroundColor:'rgba(2,1,2,0.24)',
            }
        },
    },
    label: {
        formatter: "{a}{b}\n {d}%",
    },
    dataset: {
        source: data_energy_nutr,
    },
    series: [
        {
            name: "2002年城市情况",
            type: "pie",
            radius: 60,
            center: ['25%', '30%'],
            encode: {
                itemName: 'category',
                value: '城市情况\n2002'
            }
        }, {
            name: "2012年城市情况",
            type: 'pie',
            radius: 60,
            center: ['75%', '30%'],
            encode: {
                itemName: 'category',
                value: '城市情况\n2012',
            }
        }, {
            name: "2002年农村情况",
            type: "pie",
            radius: 60,
            center: ['25%', '75%'],
            encode: {
                itemName: "category",
                value: "农村情况\n2002"
            }
        }, {
            name: "2012年农村情况",
            type: "pie",
            radius: 60,
            center: ['75%', '75%'],
            encode: {
                itemName: 'category',
                value: "农村情况\n2012"
            }
        }
    ]
};

//蛋白质来源
var title_text_protein = "城乡居民蛋白质的食物来源";
var data_ernergy_protein = [
    ['category', '城市情况\n2002', '城市情况\n2012', '农村情况\n2002', '农村情况\n2012'],
    ['谷类', '40.7', '39.7', '56.5', '54.6'],
    ['豆类', '7.3', '6.3', '7.6', '4.5'],
    ['动物性食物类', '35.8', '36.2', '21.0', '25.4'],
    ['其他', '16.2', '17.8', '14.9', '15.5'],
];
var opt3 =  {
    color:['#F3B4A8','#9FB1F1','#D92943','#FFCD11'],
    title: {
        text: title_text_protein,
    },
    label: {
        formatter: "{a}{b}\n {d}%",
    },
    legend:{},
    tooltip: {
        formatter: "{a}{b}\n {d}%",
    },
    dataset: {
        source: data_ernergy_protein,
    },
    series: [
        {
            name: "2002年城市情况",
            type: "pie",
            radius: 60,
            center: ['25%', '30%'],
            encode: {
                itemName: "category",
                value: '城市情况\n2002',
            }
        }, {
            name: "2012年城市情况",
            type: "pie",
            radius: 60,
            center: ["75%", '30%'],
            encode: {
                itemName: "category",
                value: '城市情况\n2012'
            }
        }, {
            name: "2002年农村情况",
            type: "pie",
            radius: 60,
            center: ['25%', '75%'],
            encode: {
                itemName: "category",
                value: '农村情况\n2002',
            }
        }, {
            name: "2012年农村情况",
            type: "pie",
            radius: 60,
            center: ['75%', '75%'],
            encode: {
                itemName: "category",
                value: '农村情况\n2012',
            }
        }
    ]

}


//脂肪的食物来源
var title_text_fat = "城乡居民脂肪的食物来源";
var data_energy_fat = [
    ['category', '城市情况\n2002', '城市情况\n2012', '农村情况\n2002', '农村情况\n2012'],
    ['动物性食物', '36.2', '34.3', '40.4', '37.4'],
    ['植物性食物', '63.8', '65.7', '59.6', '62.6'],
]
var opt4 = {
    title: {
        text: title_text_fat,
    },
    label: {
        formatter: "{a}{b}\n {d}%",
    },
    tooltip: {
        formatter: "{a}{b}\n {d}%",
    },
    dataset: {
        source: data_energy_fat,
    },
    legend: {},
    series: [
        {
            labelLine: {
                length: 20,
                length2: 50,
            },
            name: "2002年城市情况",
            type: "pie",
            radius: [0, 20],
            center: ['25%', '30%'],
            encode: {
                itemName: "category",
                value: '城市情况\n2002',
            }
        }, {
            name: "2012年城市情况",
            type: "pie",
            center: ['25%', '30%'],
            radius: [60, 80],
            encode: {
                itemNode: "category",
                value: "城市情况\n2012",
            }
        }, {
            name: "2002年农村情况",
            type: "pie",
            center: ['75%', '30%'],
            labelLine: {
                length2: 50,
            },
            radius: [0, 20],
            encode: {
                itemName: "category",
                value: "农村情况\n2002",
            },


        }, {
            name: "2012年农村情况",
            type: "pie",
            radius: [60, 80],
            center: ['75%', '30%'],
            encode: {
                itemName: "category",
                value: '农村情况\n2012'
            },

        }
    ]

}

