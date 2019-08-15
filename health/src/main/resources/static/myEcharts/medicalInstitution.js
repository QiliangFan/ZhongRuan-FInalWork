var medicalInstitutions_map;
var medicalInstitutions_map_data = [];
var dataMap = {
    dataComprehensive: function (year) {
        var data = {}
        for (var i = 0; i < medicalInstitutions_map_data.length; i++) {
            if ((medicalInstitutions_map_data[i]["year"]).toString().indexOf(year) != -1) {
                return parseInt(medicalInstitutions_map_data[i]["comprehensive"]);
            }
        }
        // for(data in medicalInstitutions_map_data){
        //     console.log(medicalInstitutions_map_data)
        //     console.log(data)
        //     if(data["year"].index(year)!=-1){
        //         return parseInt(data["comprehensive"]);
        //     }
        // }
        return 0;
    },
    dataChineseMedicine: function (year) {
        for (var i = 0; i < medicalInstitutions_map_data.length; i++) {
            if ((medicalInstitutions_map_data[i]["year"]).toString().indexOf(year) != -1) {
                return parseInt(medicalInstitutions_map_data[i]["chinesemedicine"]);
            }
        }
        // for(data in medicalInstitutions_map_data){
        //     if(data["year"].index(year)!=-1){
        //         return parseInt(data["chinesemedicine"]);
        //     }
        // }
        return 0;
    },
    dataSpecialist: function (year) {
        for (var i = 0; i < medicalInstitutions_map_data.length; i++) {
            if ((medicalInstitutions_map_data[i]["year"]).toString().indexOf(year) != -1) {
                return parseInt(medicalInstitutions_map_data[i]["specialist"]);
            }
        }
        // for(data in medicalInstitutions_map_data){
        //     if(data["year"].index(year)!=-1){
        //         return parseInt(data["specialist"]);
        //     }
        // }
        return 0;
    },
    dataPrimary: function (year) {
        for (var i = 0; i < medicalInstitutions_map_data.length; i++) {
            if ((medicalInstitutions_map_data[i]["year"]).toString().indexOf(year) != -1) {
                return parseInt(medicalInstitutions_map_data[i]["primary"]);
            }
        }
        // for(data in medicalInstitutions_map_data){
        //     if(data["year"].index(year)!=-1){
        //         return parseInt(data['primary']);
        //     }
        // }
        return 0;
    },
    dataCommunity: function (year) {
        for (var i = 0; i < medicalInstitutions_map_data.length; i++) {
            if ((medicalInstitutions_map_data[i]["year"]).toString().indexOf(year) != -1) {
                return parseInt(medicalInstitutions_map_data[i]["community"]);
            }
        }
        // for(data in medicalInstitutions_map_data){
        //     if(data["year"].index(year)!=-1){
        //         return parseInt(data['community']);
        //     }
        // }
        return 0;
    },
    dataTownShip: function (year) {
        for (var i = 0; i < medicalInstitutions_map_data.length; i++) {
            if ((medicalInstitutions_map_data[i]["year"]).toString().indexOf(year) != -1) {
                return parseInt(medicalInstitutions_map_data[i]["township"]);
            }
        }
        // for(data in medicalInstitutions_map_data){
        //     if(data["year"].index(year)!=-1){
        //         return parseInt(data['township']);
        //     }
        // }
        return 0;
    },
    dataVillage: function (year) {
        for (var i = 0; i < medicalInstitutions_map_data.length; i++) {
            if ((medicalInstitutions_map_data[i]["year"]).toString().indexOf(year) != -1) {
                return parseInt(medicalInstitutions_map_data[i]["village"]);
            }
        }
        // for(data in medicalInstitutions_map_data){
        //     if(data["year"].index(year)!=-1){
        //         return parseInt(data['village']);
        //     }
        // }
        return 0;
    },
    dataOutput: function (year) {
        for (var i = 0; i < medicalInstitutions_map_data.length; i++) {
            if ((medicalInstitutions_map_data[i]["year"]).toString().indexOf(year) != -1) {
                return parseInt(medicalInstitutions_map_data[i]["outpatient"]);
            }
        }
        // for(data in medicalInstitutions_map_data){
        //     if(data["year"].index(year)!=-1){
        //         return parseInt(data['outpatient']);
        //     }
        // }
        return 0;
    },
    dataProfession: function (year) {
        for (var i = 0; i < medicalInstitutions_map_data.length; i++) {
            if ((medicalInstitutions_map_data[i]["year"]).toString().indexOf(year) != -1) {
                return parseInt(medicalInstitutions_map_data[i]["profession"]);
            }
        }
        // for(data in medicalInstitutions_map_data){
        //     if(data["year"].index(year)!=-1){
        //         return parseInt(data['profession']);
        //     }
        // }
        return 0;
    },
    dataDiseaseprevention: function (year) {
        for (var i = 0; i < medicalInstitutions_map_data.length; i++) {
            if ((medicalInstitutions_map_data[i]["year"]).toString().indexOf(year) != -1) {
                return parseInt(medicalInstitutions_map_data[i]["diseaseprevention"]);
            }
        }
        // for(data in medicalInstitutions_map_data){
        //     if(data["year"].index(year)!=-1){
        //         return parseInt(data['diseaseprevention']);
        //     }
        // }
        return 0;
    },
    dataSpecialiststation: function (year) {
        for (var i = 0; i < medicalInstitutions_map_data.length; i++) {
            if ((medicalInstitutions_map_data[i]["year"]).toString().indexOf(year) != -1) {
                return parseInt(medicalInstitutions_map_data[i]["specialiststation"]);
            }
        }
        // for(data in medicalInstitutions_map_data){
        //     if(data["year"].index(year)!=-1){
        //         return parseInt(data['specialiststation']);
        //     }
        // }
        return 0;
    },
    dataWomenAndChild: function (year) {
        for (var i = 0; i < medicalInstitutions_map_data.length; i++) {
            if ((medicalInstitutions_map_data[i]["year"]).toString().indexOf(year) != -1) {
                return parseInt(medicalInstitutions_map_data[i]["womenandchild"]);
            }
        }
        // for(data in medicalInstitutions_map_data){
        //
        //     if(data["year"].index(year)!=-1){
        //         return parseInt(data['womenandchild']);
        //     }
        // }
        return 0;
    },
    dataHealthAuthority: function (year) {
        for (var i = 0; i < medicalInstitutions_map_data.length; i++) {
            if ((medicalInstitutions_map_data[i]["year"]).toString().indexOf(year) != -1) {
                return parseInt(medicalInstitutions_map_data[i]["healthauthority"]);
            }
        }
        // for(data in medicalInstitutions_map_data){
        //     if(data["year"].index(year)!=-1){
        //         return parseInt(data['healthauthority']);
        //     }
        // }
        return 0;
    },
    dataFormat1: function (year) {
        sum = 0;
        for (var i = 0; i < medicalInstitutions_map_data.length; i++) {
            if ((medicalInstitutions_map_data[i]["year"]).toString().indexOf(year) != -1) {
                sum = medicalInstitutions_map_data[i]["comprehensive"];
            }
        }

        // for(data in medicalInstitutions_map_data){
        //     if(data["year"].index(year)!=-1){
        //         sum=data["comprehensive"]+
        //             data['chinesemedicine']+
        //             data['specialist'];
        //     }
        // }
        return sum;
    },
    dataFormat2: function (year) {
        sum = 0;
        for (var i = 0; i < medicalInstitutions_map_data.length; i++) {
            if ((medicalInstitutions_map_data[i]["year"]).toString().indexOf(year) != -1) {
                sum = medicalInstitutions_map_data[i]['township'];
            }
        }

        // for(data in medicalInstitutions_map_data){
        //     if(data["year"].index(year)!=-1){
        //         sum=data['primary'];
        //     }
        // }
        return sum;
    },
    dataFormat3: function (year) {
        sum = 0;
        for (var i = 0; i < medicalInstitutions_map_data.length; i++) {
            if ((medicalInstitutions_map_data[i]["year"]).toString().indexOf(year) != -1) {
                sum = medicalInstitutions_map_data[i]["profession"];
            }
        }

        // for(data in medicalInstitutions_map_data){
        //     if(data["year"].index(year)!=-1){
        //         sum=data["profession"];
        //     }
        // }
        return sum;
    },
};
var medicalInstitutions_map_opt = {}

function getMedicalInstitutionData() {
    medicalInstitutions_map.showLoading()
    $.ajax({
        url: "/getMedicalInstitutions",
        dataType: "json",
        method: "POST",
        async: true,
        error: function (data) {
            console.log(data);
        },
        success: function (data) {
            medicalInstitutions_map_data = data;
            console.log(medicalInstitutions_map_data)
            medicalInstitutions_map_opt = {

                baseOption: {

                    grid: {
                        top: 80,
                        bottom: 100,
                        height:400,
                        tooltip: {
                            trigger: 'axis',
                            axisPointer: {
                                type: "shadow",
                                label: {
                                    show: true,
                                    formatter: function (params) {
                                        return params.value.replace('\n', '');
                                    }
                                }
                            }
                        }
                    },
                    timeline: {
                        axisType: 'category',
                        autoPlay: true,
                        playInterval: 1000,
                        data: [
                            '2002-01-01', '2003-01-01', '2004-01-01', '2005-01-01', '2006-01-01', '2007-01-01', '2008-01-01', '2009-01-01',
                            '2010-01-01', '2011-01-01', '2012-01-01', '2013-01-01', '2014-01-01', '2015-01-01', '2016-01-01', '2017-01-01'
                        ],
                        label: {
                            formatter: function (s) {
                                return (new Date(s)).getFullYear();
                            }
                        },
                    },
                    title: {
                        subtext: "数据来自某统计网站",
                    },
                    tooltip: {},
                    legend: {
                        x: 'right',
                        data: ['综合医院', '基层医疗卫生机构', '专业公共卫生机构'],
                        // data: [
                        //     '综合医院', '中医医院', '专科医院', '社区卫生服务中心', '乡镇卫生院',
                        //     '村卫生室', '门诊部', '疾病预防控制中心', '专科疾病防止院', '妇幼保健所',
                        //     '卫生监督所'
                        // ],
                    },
                    calculable: true,
                    xAxis: [
                        {
                            type: 'category',
                            axisLabel: {
                                interval: 0,
                                formatter: function (value) {
                                    return value.split("").join("\n");
                                }
                            },
                            data: [
                                '综合医院', '中医医院', '专科医院', '基层医疗卫生机构', '社区卫生服务中心', '乡镇卫生院',
                                '村卫生室', '门诊部', '专业公共卫生机构', '疾病预防控制中心', '专科疾病防止院', '妇幼保健所',
                                '卫生监督所',
                            ],
                            splitLine: {
                                show: false,
                            }
                        }
                    ],
                    yAxis: [{
                        type: 'value',
                        name: "数量(个)"
                    }],
                    series: [
                        // {name:"综合医院",type:'bar'},
                        // {name:"中医医院",type:'bar'},
                        // {name:"专科医院",type:'bar'},
                        // {name:"基层医疗卫生机构",type:'bar'},
                        // {name:"社区卫生服务中心",type:'bar'},
                        // {name:"乡镇卫生院",type:'bar'},
                        // {name:"村卫生室",type:'bar'},
                        // {name:"门诊部",type:'bar'},
                        // {name:"专业公共卫生机构",type:'bar'},
                        // {name:"疾病预防控制中心",type:'bar'},
                        // {name:"专科疾病防止院",type:'bar'},
                        // {name:"妇幼保健所",type:'bar'},
                        // {name:"卫生监督所",type:'bar'},
                        {
                            name: '卫生机构类型',
                            type: 'pie',
                            center: ['75%', '25%'],
                            radius: '20%',
                            z: 100
                        }
                    ]
                },
                options: [
                    {//2002
                        itemStyle:{
                            color: function (params){
                                var colorList = [
                                    "#2860c0",
                                    "#d66e32",
                                    "#ffb5b0",
                                    "#c1a2b0",
                                    "#799ec5",
                                    "#c0d8de",
                                    "#ba85ff",
                                    "#6ac780",
                                    "#2da841",
                                    "#a7139d",
                                    "#1880a5",
                                    "#a5ae38"
                                ];
                                return colorList[params.dataIndex];
                            }
                        },
                        title: {
                            text: '2002年全国卫生机构数量'
                        },
                        series: [
                            {
                                type: "bar",
                                data: [
                                    dataMap.dataComprehensive('2002'),
                                    dataMap.dataChineseMedicine('2002'),
                                    dataMap.dataSpecialist('2002'),
                                    dataMap.dataPrimary('2002'),
                                    dataMap.dataCommunity('2002'),
                                    dataMap.dataTownShip('2002'),
                                    dataMap.dataVillage('2002'),
                                    dataMap.dataOutput('2002'),
                                    dataMap.dataProfession('2002'),
                                    dataMap.dataDiseaseprevention('2002'),
                                    dataMap.dataSpecialiststation('2002'),
                                    dataMap.dataWomenAndChild('2002'),
                                    dataMap.dataHealthAuthority('2002')
                                ]
                            }, {
                                name: "卫生机构类型",
                                // type:"pie",
                                type: 'pie', data: [
                                    {name: "综合医院", value: [dataMap.dataFormat1('2002')  ]},
                                    {name: "基层医疗卫生机构", value: [dataMap.dataFormat2('2002')]},
                                    {name: "专业公共卫生机构", value: [dataMap.dataFormat3('2002')]},
                                ]
                            }
                        ]
                    },
                    {//2003
                        title: {
                            text: '2003年全国卫生机构数量'
                        },
                        series: [
                            {
                                type: "bar",
                                data: [
                                    dataMap.dataComprehensive('2003'),
                                    dataMap.dataChineseMedicine('2003'),
                                    dataMap.dataSpecialist('2003'),
                                    dataMap.dataPrimary('2003'),
                                    dataMap.dataCommunity('2003'),
                                    dataMap.dataTownShip('2003'),
                                    dataMap.dataVillage('2003'),
                                    dataMap.dataOutput('2003'),
                                    dataMap.dataProfession('2003'),
                                    dataMap.dataDiseaseprevention('2003'),
                                    dataMap.dataSpecialiststation('2003'),
                                    dataMap.dataWomenAndChild('2003'),
                                    dataMap.dataHealthAuthority('2003')
                                ]
                            }, {
                                name: "卫生机构类型",
                                // type:"pie",
                                type: 'pie', data: [
                                    {name: "综合医院", value: [dataMap.dataFormat1('2003') ]},
                                    {name: "基层医疗卫生机构", value: [dataMap.dataFormat2('2003')]},
                                    {name: "专业公共卫生机构", value: [dataMap.dataFormat3('2003')]},
                                ]
                            }
                        ]
                    },
                    {//2004
                        title: {
                            text: '2004年全国卫生机构数量'
                        },
                        series: [
                            {
                                type: "bar",
                                data: [
                                    dataMap.dataComprehensive('2004'),
                                    dataMap.dataChineseMedicine('2004'),
                                    dataMap.dataSpecialist('2004'),
                                    dataMap.dataPrimary('2004'),
                                    dataMap.dataCommunity('2004'),
                                    dataMap.dataTownShip('2004'),
                                    dataMap.dataVillage('2004'),
                                    dataMap.dataOutput('2004'),
                                    dataMap.dataProfession('2004'),
                                    dataMap.dataDiseaseprevention('2004'),
                                    dataMap.dataSpecialiststation('2004'),
                                    dataMap.dataWomenAndChild('2004'),
                                    dataMap.dataHealthAuthority('2004')
                                ]
                            }, {
                                name: "卫生机构类型",
                                // type:"pie",
                                type: 'pie', data: [
                                    {name: "综合医院", value: [dataMap.dataFormat1('2004') ]},
                                    {name: "基层医疗卫生机构", value: [dataMap.dataFormat2('2004')]},
                                    {name: "专业公共卫生机构", value: [dataMap.dataFormat3('2004')]},
                                ]
                            }
                        ]
                    },
                    {//2005
                        title: {
                            text: '2005年全国卫生机构数量'
                        },
                        series: [
                            {
                                type: "bar",
                                data: [
                                    dataMap.dataComprehensive('2005'),
                                    dataMap.dataChineseMedicine('2005'),
                                    dataMap.dataSpecialist('2005'),
                                    dataMap.dataPrimary('2005'),
                                    dataMap.dataCommunity('2005'),
                                    dataMap.dataTownShip('2005'),
                                    dataMap.dataVillage('2005'),
                                    dataMap.dataOutput('2005'),
                                    dataMap.dataProfession('2005'),
                                    dataMap.dataDiseaseprevention('2005'),
                                    dataMap.dataSpecialiststation('2005'),
                                    dataMap.dataWomenAndChild('2005'),
                                    dataMap.dataHealthAuthority('2005')
                                ]
                            }, {
                                name: "卫生机构类型",
                                // type:"pie",
                                type: 'pie', data: [
                                    {name: "综合医院", value: [dataMap.dataFormat1('2005') ]},
                                    {name: "基层医疗卫生机构", value: [dataMap.dataFormat2('2005')]},
                                    {name: "专业公共卫生机构", value: [dataMap.dataFormat3('2005')]},
                                ]
                            }
                        ]
                    },
                    {//2006
                        title: {
                            text: '2006年全国卫生机构数量'
                        },
                        series: [
                            {
                                type: "bar",
                                data: [
                                    dataMap.dataComprehensive('2006'),
                                    dataMap.dataChineseMedicine('2006'),
                                    dataMap.dataSpecialist('2006'),
                                    dataMap.dataPrimary('2006'),
                                    dataMap.dataCommunity('2006'),
                                    dataMap.dataTownShip('2006'),
                                    dataMap.dataVillage('2006'),
                                    dataMap.dataOutput('2006'),
                                    dataMap.dataProfession('2006'),
                                    dataMap.dataDiseaseprevention('2006'),
                                    dataMap.dataSpecialiststation('2006'),
                                    dataMap.dataWomenAndChild('2006'),
                                    dataMap.dataHealthAuthority('2006')
                                ]
                            }, {
                                name: "卫生机构类型",
                                // type:"pie",
                                type: 'pie', data: [
                                    {name: "综合医院", value: [dataMap.dataFormat1('2006') ]},
                                    {name: "基层医疗卫生机构", value: [dataMap.dataFormat2('2006')]},
                                    {name: "专业公共卫生机构", value: [dataMap.dataFormat3('2006')]},
                                ]
                            }
                        ]
                    },
                    {//2007
                        title: {
                            text: '2007年全国卫生机构数量'
                        },
                        series: [
                            {
                                type: "bar",
                                data: [
                                    dataMap.dataComprehensive('2007'),
                                    dataMap.dataChineseMedicine('2007'),
                                    dataMap.dataSpecialist('2007'),
                                    dataMap.dataPrimary('2007'),
                                    dataMap.dataCommunity('2007'),
                                    dataMap.dataTownShip('2007'),
                                    dataMap.dataVillage('2007'),
                                    dataMap.dataOutput('2007'),
                                    dataMap.dataProfession('2007'),
                                    dataMap.dataDiseaseprevention('2007'),
                                    dataMap.dataSpecialiststation('2007'),
                                    dataMap.dataWomenAndChild('2007'),
                                    dataMap.dataHealthAuthority('2007')
                                ]
                            }, {
                                name: "卫生机构类型",
                                // type:"pie",
                                type: 'pie', data: [
                                    {name: "综合医院", value: [dataMap.dataFormat1('2007') ]},
                                    {name: "基层医疗卫生机构", value: [dataMap.dataFormat2('2007')]},
                                    {name: "专业公共卫生机构", value: [dataMap.dataFormat3('2007')]},
                                ]
                            }
                        ]
                    },
                    {//2008
                        title: {
                            text: '2008年全国卫生机构数量'
                        },
                        series: [
                            {
                                type: "bar",
                                data: [
                                    dataMap.dataComprehensive('2008'),
                                    dataMap.dataChineseMedicine('2008'),
                                    dataMap.dataSpecialist('2008'),
                                    dataMap.dataPrimary('2008'),
                                    dataMap.dataCommunity('2008'),
                                    dataMap.dataTownShip('2008'),
                                    dataMap.dataVillage('2008'),
                                    dataMap.dataOutput('2008'),
                                    dataMap.dataProfession('2008'),
                                    dataMap.dataDiseaseprevention('2008'),
                                    dataMap.dataSpecialiststation('2008'),
                                    dataMap.dataWomenAndChild('2008'),
                                    dataMap.dataHealthAuthority('2008')
                                ]
                            }, {
                                name: "卫生机构类型",
                                // type:"pie",
                                type: 'pie', data: [
                                    {name: "综合医院", value: [dataMap.dataFormat1('2008') ]},
                                    {name: "基层医疗卫生机构", value: [dataMap.dataFormat2('2008')]},
                                    {name: "专业公共卫生机构", value: [dataMap.dataFormat3('2008')]},
                                ]
                            }
                        ]
                    },
                    {//2009
                        title: {
                            text: '2009年全国卫生机构数量'
                        },
                        series: [
                            {
                                type: "bar",
                                data: [
                                    dataMap.dataComprehensive('2009'),
                                    dataMap.dataChineseMedicine('2009'),
                                    dataMap.dataSpecialist('2009'),
                                    dataMap.dataPrimary('2009'),
                                    dataMap.dataCommunity('2009'),
                                    dataMap.dataTownShip('2009'),
                                    dataMap.dataVillage('2009'),
                                    dataMap.dataOutput('2009'),
                                    dataMap.dataProfession('2009'),
                                    dataMap.dataDiseaseprevention('2009'),
                                    dataMap.dataSpecialiststation('2009'),
                                    dataMap.dataWomenAndChild('2009'),
                                    dataMap.dataHealthAuthority('2009')
                                ]
                            }, {
                                name: "卫生机构类型",
                                // type:"pie",
                                type: 'pie', data: [
                                    {name: "综合医院", value: [dataMap.dataFormat1('2009') ]},
                                    {name: "基层医疗卫生机构", value: [dataMap.dataFormat2('2009')]},
                                    {name: "专业公共卫生机构", value: [dataMap.dataFormat3('2009')]},
                                ]
                            }
                        ]
                    },
                    {//2010
                        title: {
                            text: '2010年全国卫生机构数量'
                        },
                        series: [
                            {
                                type: "bar",
                                data: [
                                    dataMap.dataComprehensive('2010'),
                                    dataMap.dataChineseMedicine('2010'),
                                    dataMap.dataSpecialist('2010'),
                                    dataMap.dataPrimary('2010'),
                                    dataMap.dataCommunity('2010'),
                                    dataMap.dataTownShip('2010'),
                                    dataMap.dataVillage('2010'),
                                    dataMap.dataOutput('2010'),
                                    dataMap.dataProfession('2010'),
                                    dataMap.dataDiseaseprevention('2010'),
                                    dataMap.dataSpecialiststation('2010'),
                                    dataMap.dataWomenAndChild('2010'),
                                    dataMap.dataHealthAuthority('2010')
                                ]
                            }, {
                                name: "卫生机构类型",
                                // type:"pie",
                                type: 'pie', data: [
                                    {name: "综合医院", value: [dataMap.dataFormat1('2010') ]},
                                    {name: "基层医疗卫生机构", value: [dataMap.dataFormat2('2010')]},
                                    {name: "专业公共卫生机构", value: [dataMap.dataFormat3('2010')]},
                                ]
                            }
                        ]
                    }, {//2011
                        title: {
                            text: '2011年全国卫生机构数量'
                        },
                        series: [
                            {
                                type: "bar",
                                data: [
                                    dataMap.dataComprehensive('2011'),
                                    dataMap.dataChineseMedicine('2011'),
                                    dataMap.dataSpecialist('2011'),
                                    dataMap.dataPrimary('2011'),
                                    dataMap.dataCommunity('2011'),
                                    dataMap.dataTownShip('2011'),
                                    dataMap.dataVillage('2011'),
                                    dataMap.dataOutput('2011'),
                                    dataMap.dataProfession('2011'),
                                    dataMap.dataDiseaseprevention('2011'),
                                    dataMap.dataSpecialiststation('2011'),
                                    dataMap.dataWomenAndChild('2011'),
                                    dataMap.dataHealthAuthority('2011')
                                ]
                            }, {
                                name: "卫生机构类型",
                                // type:"pie",
                                type: 'pie', data: [
                                    {name: "综合医院", value: [dataMap.dataFormat1('2011') ]},
                                    {name: "基层医疗卫生机构", value: [dataMap.dataFormat2('2011')]},
                                    {name: "专业公共卫生机构", value: [dataMap.dataFormat3('2011')]},
                                ]
                            }
                        ]
                    },
                    {//2012
                        title: {
                            text: '2012年全国卫生机构数量'
                        },
                        series: [
                            {
                                type: "bar",
                                data: [
                                    dataMap.dataComprehensive('2012'),
                                    dataMap.dataChineseMedicine('2012'),
                                    dataMap.dataSpecialist('2012'),
                                    dataMap.dataPrimary('2012'),
                                    dataMap.dataCommunity('2012'),
                                    dataMap.dataTownShip('2012'),
                                    dataMap.dataVillage('2012'),
                                    dataMap.dataOutput('2012'),
                                    dataMap.dataProfession('2012'),
                                    dataMap.dataDiseaseprevention('2012'),
                                    dataMap.dataSpecialiststation('2012'),
                                    dataMap.dataWomenAndChild('2012'),
                                    dataMap.dataHealthAuthority('2012')
                                ]
                            }, {
                                name: "卫生机构类型",
                                // type:"pie",
                                type: 'pie', data: [
                                    {name: "综合医院", value: [dataMap.dataFormat1('2012') ]},
                                    {name: "基层医疗卫生机构", value: [dataMap.dataFormat2('2012')]},
                                    {name: "专业公共卫生机构", value: [dataMap.dataFormat3('2012')]},
                                ]
                            }
                        ]
                    },
                    {//2013
                        title: {
                            text: '2013年全国卫生机构数量'
                        },
                        series: [
                            {
                                type: "bar",
                                data: [
                                    dataMap.dataComprehensive('2013'),
                                    dataMap.dataChineseMedicine('2013'),
                                    dataMap.dataSpecialist('2013'),
                                    dataMap.dataPrimary('2013'),
                                    dataMap.dataCommunity('2013'),
                                    dataMap.dataTownShip('2013'),
                                    dataMap.dataVillage('2013'),
                                    dataMap.dataOutput('2013'),
                                    dataMap.dataProfession('2013'),
                                    dataMap.dataDiseaseprevention('2013'),
                                    dataMap.dataSpecialiststation('2013'),
                                    dataMap.dataWomenAndChild('2013'),
                                    dataMap.dataHealthAuthority('2013')
                                ]
                            }, {
                                name: "卫生机构类型",
                                // type:"pie",
                                type: 'pie', data: [
                                    {name: "综合医院", value: [dataMap.dataFormat1('2013') ]},
                                    {name: "基层医疗卫生机构", value: [dataMap.dataFormat2('2013')]},
                                    {name: "专业公共卫生机构", value: [dataMap.dataFormat3('2013')]},
                                ]
                            }
                        ]
                    },
                    {//2014
                        title: {
                            text: '2014年全国卫生机构数量'
                        },
                        series: [
                            {
                                type: "bar",
                                data: [
                                    dataMap.dataComprehensive('2014'),
                                    dataMap.dataChineseMedicine('2014'),
                                    dataMap.dataSpecialist('2014'),
                                    dataMap.dataPrimary('2014'),
                                    dataMap.dataCommunity('2014'),
                                    dataMap.dataTownShip('2014'),
                                    dataMap.dataVillage('2014'),
                                    dataMap.dataOutput('2014'),
                                    dataMap.dataProfession('2014'),
                                    dataMap.dataDiseaseprevention('2014'),
                                    dataMap.dataSpecialiststation('2014'),
                                    dataMap.dataWomenAndChild('2014'),
                                    dataMap.dataHealthAuthority('2014')
                                ]
                            }, {
                                name: "卫生机构类型",
                                // type:"pie",
                                type: 'pie', data: [
                                    {name: "综合医院", value: [dataMap.dataFormat1('2014') ]},
                                    {name: "基层医疗卫生机构", value: [dataMap.dataFormat2('2014')]},
                                    {name: "专业公共卫生机构", value: [dataMap.dataFormat3('2014')]},
                                ]
                            }
                        ]
                    },
                    {//2015
                        title: {
                            text: '2015年全国卫生机构数量'
                        },
                        series: [
                            {
                                type: "bar",
                                data: [
                                    dataMap.dataComprehensive('2015'),
                                    dataMap.dataChineseMedicine('2015'),
                                    dataMap.dataSpecialist('2015'),
                                    dataMap.dataPrimary('2015'),
                                    dataMap.dataCommunity('2015'),
                                    dataMap.dataTownShip('2015'),
                                    dataMap.dataVillage('2015'),
                                    dataMap.dataOutput('2015'),
                                    dataMap.dataProfession('2015'),
                                    dataMap.dataDiseaseprevention('2015'),
                                    dataMap.dataSpecialiststation('2015'),
                                    dataMap.dataWomenAndChild('2015'),
                                    dataMap.dataHealthAuthority('2015')
                                ]
                            }, {
                                name: "卫生机构类型",
                                // type:"pie",
                                type: 'pie', data: [
                                    {name: "综合医院", value: [dataMap.dataFormat1('2015') ]},
                                    {name: "基层医疗卫生机构", value: [dataMap.dataFormat2('2015')]},
                                    {name: "专业公共卫生机构", value: [dataMap.dataFormat3('2015')]},
                                ]
                            }
                        ]
                    },
                    {//2016
                        title: {
                            text: '2016年全国卫生机构数量'
                        },
                        series: [
                            {
                                type: "bar",
                                data: [
                                    dataMap.dataComprehensive('2016'),
                                    dataMap.dataChineseMedicine('2016'),
                                    dataMap.dataSpecialist('2016'),
                                    dataMap.dataPrimary('2016'),
                                    dataMap.dataCommunity('2016'),
                                    dataMap.dataTownShip('2016'),
                                    dataMap.dataVillage('2016'),
                                    dataMap.dataOutput('2016'),
                                    dataMap.dataProfession('2016'),
                                    dataMap.dataDiseaseprevention('2016'),
                                    dataMap.dataSpecialiststation('2016'),
                                    dataMap.dataWomenAndChild('2016'),
                                    dataMap.dataHealthAuthority('2016')
                                ]
                            }, {
                                name: "卫生机构类型",
                                // type:"pie",
                                type: 'pie', data: [
                                    {name: "综合医院", value: [dataMap.dataFormat1('2016') ]},
                                    {name: "基层医疗卫生机构", value: [dataMap.dataFormat2('2016')]},
                                    {name: "专业公共卫生机构", value: [dataMap.dataFormat3('2016')]},
                                ]
                            }
                        ]
                    },
                    {//2017
                        title: {
                            text: '2017年全国卫生机构数量'
                        },
                        series: [
                            {
                                type: "bar",
                                data: [
                                    dataMap.dataComprehensive('2017'),
                                    dataMap.dataChineseMedicine('2017'),
                                    dataMap.dataSpecialist('2017'),
                                    dataMap.dataPrimary('2017'),
                                    dataMap.dataCommunity('2017'),
                                    dataMap.dataTownShip('2017'),
                                    dataMap.dataVillage('2017'),
                                    dataMap.dataOutput('2017'),
                                    dataMap.dataProfession('2017'),
                                    dataMap.dataDiseaseprevention('2017'),
                                    dataMap.dataSpecialiststation('2017'),
                                    dataMap.dataWomenAndChild('2017'),
                                    dataMap.dataHealthAuthority('2017')
                                ]
                            }, {
                                name: "卫生机构类型",
                                // type:"pie",
                                type: 'pie', data: [
                                    {name: "综合医院", value: [dataMap.dataFormat1('2017') ]},
                                    {name: "基层医疗卫生机构", value: [dataMap.dataFormat2('2017')]},
                                    {name: "专业公共卫生机构", value: [dataMap.dataFormat3('2017')]},
                                ]
                            }
                        ]
                    },

                ]
            }
            console.log(medicalInstitutions_map_opt)
            medicalInstitutions_map.setOption(medicalInstitutions_map_opt);
            medicalInstitutions_map.hideLoading()
        }
    })
}