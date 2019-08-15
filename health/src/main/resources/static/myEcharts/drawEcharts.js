$(function () {
    //expectedLifeMap.js  <=  id: ExpectedLife
    try {
        expectedLifeMap = echarts.init($("#ExpectedLife")[0]);
        expectedLifeMap.showLoading();
        getexpectedLifeMapData()
    }catch (e) {
        console.log(e);
    }

    //populationratio.js   <= id:  populationratio
    try{
        populationratio =echarts.init($("#populationratio")[0]);
        loadLocalDataAndShowPopulationratio();
    }catch (e) {
        console.log(e);
    }

    //popu2.js  <=  id : popu2
    try{
        popu2  =echarts.init($("#popu2")[0]);
        loadLocalDataAndShowPopu2();
    }catch (e) {
        console.log(e);
    }

    //myPie.js  <=  id: dataenergyfood
    try{
        data_energy_food_pie = echarts.init($("#dataenergyfood")[0]);
        data_energy_food_pie.setOption(opt1)
    }catch (e) {
        console.log(e);
    }

    //myPie.js <= id: dataenergynutr
    try{
        data_energy_nutr_pie = echarts.init($("#dataenergynutr")[0])
        data_energy_nutr_pie.setOption(opt2)
    }catch (e) {
        console.log(e);
    }

    //myPie.js <= id: dataernergyprotein
    try {
        data_ernergy_protein_pie = echarts.init($("#dataernergyprotein")[0])
        data_ernergy_protein_pie.setOption(opt3)
    }catch (e) {
        console.log(e)
    }

    //myPie.js  <=  id:dataenergyfat
    try{
        data_energy_fat_pie = echarts.init($("#dataenergyfat")[0])
        data_energy_fat_pie.setOption(opt4)
    }catch (e) {
        console.log(e)
    }

    //medicalInstitutions.js   <= id: medicalInstitutions
    try{
        medicalInstitutions_map = echarts.init($("#medicalInstitutions")[0])
        getMedicalInstitutionData();
        console.log(medicalInstitutions_map_opt)
        medicalInstitutions_map.setOption(medicalInstitutions_map_opt);
    }catch (e) {
        console.log(e)
    }

    //resultToBar.js  <=  id :  resultToBar
    try{
        resultToBar = echarts.init($("#resultToBar")[0]);
        resultToBar.showLoading();
        resultToBarFunc()
    }catch(e){
        console.log(e);
    }

    //resultToPie.js  <= id  :resultToPie
    try{
        resultToPie = echarts.init($("#resultToPie")[0]);
        resultToPie.showLoading()
        resultToPieFunc()
    }catch(e){
        console.log(e)
    }

    //resultToPie.js  <= id :  dataPie
    try{
        $("#dataPie").on("input",function () {
            sendJsonPie();
        });
    }catch(e){
        console.log(e)
    }

    //resultToBar.js  <= id :  dataBar
    try{
        $("#dataBar").on("input",function () {
            sendJsonBar();
        });
    }catch(e){
        console.log(e)
    }
});
