package org.evan.study.file;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;

public class CityData {
    public static void main(String[] args) {
        try {
            BufferedReader cityBuffer = new BufferedReader(new FileReader("F:\\IDEA\\javaBasic\\file\\city.json"));
            String city = null;
            while ((city = cityBuffer.readLine()) != null) {
                try {
                    JSONObject cityJson = JSONObject.parseObject(city);
                    JSONObject data = cityJson.getJSONObject("data");
                    JSONArray cityList = data.getJSONArray("cityList");
                    for (int i=0; i<cityList.size(); i++) {
                        JSONObject cityObject = cityList.getJSONObject(i);
                        JSONArray cityArray = cityObject.getJSONArray("city");
                        for (int j=0; j<cityArray.size(); j++) {
                            JSONObject cityEntity = cityArray.getJSONObject(j);
                            String city_dirname = cityEntity.getString("city_dirname");
                            System.out.println(city_dirname+",8.12.0,android");
                        }
                    }
                } catch (Exception e) {

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
