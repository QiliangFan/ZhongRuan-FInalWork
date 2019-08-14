package com.springboot.health.web.controller;

import com.springboot.health.domain.po.Bar;
import com.springboot.health.domain.po.Pie;
import com.springboot.health.utils.ResultAndEcharts;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AnalysisController {
    @Autowired
    HttpServletRequest request;

    @RequestMapping("/datashowResultToEcharts")
    public String datashowResultToEcharts(){
        return "datashowResultToEcharts";
    }


    @RequestMapping("/analysisBar")
    public String analysisBar(MultipartFile input) {
        //python3 test.py  <path>
        try {
            String path = URLDecoder.decode(AnalysisController.class.getClassLoader().getResource(".").toString()).replace("file:", "");
            if(System.getProperty("os.name").toLowerCase().indexOf("win")!=-1)
            if(path.charAt(0)=='/'){
                path = path.replaceFirst("/","");
            }
            path += "static/python/";
            File inputTxt = new File(path + "input.txt");
            FileUtils.copyInputStreamToFile(input.getInputStream(), inputTxt);

            //to be determined
            ResultAndEcharts.startDrawBar = true;
//            ResultAndEcharts.startDrawPie = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "datashowResultToBar";
    }

    @RequestMapping("/analysisPie")
    public String analysisPie(MultipartFile input) {
        //python3 test.py  <path>
        try {
            String path = URLDecoder.decode(AnalysisController.class.getClassLoader().getResource(".").toString()).replace("file:", "");
            if(System.getProperty("os.name").toLowerCase().indexOf("win")!=-1)
            if(path.charAt(0)=='/'){
                path = path.replaceFirst("/","");
            }
            path += "static/python/";
            File inputTxt = new File(path + "input.txt");
            FileUtils.copyInputStreamToFile(input.getInputStream(), inputTxt);

            //to be determined
//            ResultAndEcharts.startDrawBar = true;
            ResultAndEcharts.startDrawPie = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "datashowResultToPie";
    }

    @RequestMapping("/resultToBar")
    @ResponseBody
    public Bar resultToBar() throws IOException, InterruptedException {
        if (ResultAndEcharts.startDrawBar) {
            System.out.println("start=> draw Bar!");
            String path = URLDecoder.decode(AnalysisController.class.getClassLoader().getResource(".").toString()).replace("file:", "");
            path += "static/python/";

            String[] shell;
            String cmds;
            String mapper;
            String reducer;
            String inputFile;
            if(System.getProperty("os.name").toLowerCase().indexOf("win")!=-1){
                path = path.replaceFirst("/","");
                mapper = path+"mapper.py";
                reducer = path+"reducer.py";
                inputFile = path+"input.txt";
                cmds = " python3 " + mapper + " " + path + " | " + " sort " + " | " + " python3 " + reducer + " " + path;
                shell =new String[]{"cmd","/c",cmds};
            }else {
                mapper = path+"mapper.py";
                reducer = path+"reducer.py";
                inputFile = path+"input.txt";
                cmds = " python3 " + mapper + " " + path + " | " + " sort  " + " | " + " python3 " + reducer + " " + path;
                shell =new String[]{"sh", "-c", cmds};
            }
            //analysis

            System.out.println(cmds);

            Process process = Runtime.getRuntime().exec(shell);
            process.waitFor();
            process.destroy();


            File result = new File(path + "result.txt");
            List<String[]> result_array = new ArrayList<>();
            try {
                BufferedReader bf = new BufferedReader(
                        new InputStreamReader(new FileInputStream(result))
                );
                String temp = null;
                while ((temp = bf.readLine()) != null) {
                    temp = temp.replaceAll("\\n", "");
                    //切割字符串
                    String[] temp_array = temp.split("\\t");
                    //strip 字符串
                    for (int i = 0; i < temp_array.length; i++) {
                        temp_array[i] = temp_array[i].replaceAll("\\t|\\n", "");
                    }
                    //test the result
                    System.out.println(temp_array);
                    result_array.add(temp_array);
                }
                System.out.println(result_array);
                //生成java bean   Bar
                Bar bar = new Bar(result_array);
                ResultAndEcharts.startDrawBar = false;
                System.out.println(bar);
                return bar;
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("resultToBar =>  file can't be found Or io errors");
            }
        }
        ResultAndEcharts.startDrawBar = false;
        return null;
    }

    @RequestMapping("/resultToPie")
    @ResponseBody
    public Pie resultToPie() throws InterruptedException, IOException {
        if (ResultAndEcharts.startDrawPie) {
            System.out.println("start => draw Pie!");
            String path = URLDecoder.decode(AnalysisController.class.getClassLoader().getResource(".").toString()).replace("file:", "");
            path += "static/python/";
            String[] shell;
            String cmds;
            String mapper;
            String reducer;
            String inputFile;
            if(System.getProperty("os.name").toLowerCase().indexOf("win")!=-1){
                path = path.replaceFirst("/","");
                mapper = path+"mapper.py";
                reducer = path+"reducer.py";
                inputFile = path+"input.txt";
                cmds = " python3 " + mapper + " " + path + " | " + " sort " + " | " + " python3 " + reducer + " " + path;
                shell =new String[]{"cmd","/c",cmds};
            }else {
                mapper = path+"mapper.py";
                reducer = path+"reducer.py";
                inputFile = path+"input.txt";
                cmds = " python3 " + mapper + " " + path + " | " + " sort  " + " | " + " python3 " + reducer + " " + path;
                shell =new String[]{"sh", "-c", cmds};
            }
            Process process = Runtime.getRuntime().exec(shell);
            process.waitFor();
            process.destroy();

            //return data
            File result = new File(path + "result.txt");
            List<String[]> result_array = new ArrayList<>();
            try {
                BufferedReader bf = new BufferedReader(
                        new InputStreamReader(new FileInputStream(result))
                );
                String temp = null;
                while ((temp = bf.readLine()) != null) {
                    temp = temp.replaceAll("\\n", "");
                    //切割字符串
                    String[] temp_array = temp.split("\\t");
                    //strip 字符串
                    for (int i = 0; i < temp_array.length; i++) {
                        temp_array[i] = temp_array[i].replaceAll("\\t|\\n", "");
                    }
                    //test the result
                    System.out.println(temp_array);
                    result_array.add(temp_array);
                }
                System.out.println(result_array);
                //生成java bean   Bar
                Pie pie = new Pie(result_array);
                ResultAndEcharts.startDrawPie = false;
                System.out.println(pie);
                return pie;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        ResultAndEcharts.startDrawPie = false;
        return null;
    }

    @RequestMapping("/toAnalysis")
    public String toAnalysis() {
        return "test";
    }

    @RequestMapping("/datashowResultToPie")
    public String datashowResultToPie(){
        return "datashowResultToPie";
    }

    @RequestMapping("/datashowResultToBar")
    public String datashowResultToBar(){
        return "datashowResultToBar";
    }

    @RequestMapping("/dataJsonPie")
    @ResponseBody
    public String dataJsonPie() throws IOException {
        String path = URLDecoder.decode(AnalysisController.class.getClassLoader().getResource(".").toString()).replace("file:", "");
        if(System.getProperty("os.name").toLowerCase().indexOf("win")!=-1)
        if(path.charAt(0)=='/'){
            path = path.replaceFirst("/","");
        }
        path += "static/python/";
        File file = new File(path+"input.txt");
        FileOutputStream fo = new FileOutputStream(file);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fo));
        request.setCharacterEncoding("utf-8");
        InputStream is = request.getInputStream();
        BufferedReader bf = new BufferedReader(new InputStreamReader(is));
        String temp=null;
        StringBuilder sb = new StringBuilder();
        while((temp=bf.readLine())!=null){
            sb.append(temp);
        }
        JSONObject jo = new JSONObject(sb.toString());
        String data = jo.getString("data");
        bw.write(data);
        bw.flush();
        bw.close();
        ResultAndEcharts.startDrawPie=true;
        return "{}";
    }

    @RequestMapping("/dataJsonBar")
    @ResponseBody
    public String dataJsonBar() throws IOException {
        String path = URLDecoder.decode(AnalysisController.class.getClassLoader().getResource(".").toString()).replace("file:", "");
        if(System.getProperty("os.name").toLowerCase().indexOf("win")!=-1)
        if(path.charAt(0)=='/'){
            path = path.replaceFirst("/","");
        }
        path += "static/python/";
        File file = new File(path+"input.txt");
        FileOutputStream fo = new FileOutputStream(file);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fo));
        request.setCharacterEncoding("utf-8");
        InputStream is = request.getInputStream();
        BufferedReader bf = new BufferedReader(new InputStreamReader(is));
        String temp=null;
        StringBuilder sb = new StringBuilder();
        while((temp=bf.readLine())!=null){
            sb.append(temp);
        }
        JSONObject jo = new JSONObject(sb.toString());
        String data = jo.getString("data");
        bw.write(data);
        bw.flush();
        bw.close();
        ResultAndEcharts.startDrawBar=true;
        return "{}";
    }
}
