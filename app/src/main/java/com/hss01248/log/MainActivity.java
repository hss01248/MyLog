package com.hss01248.log;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {



    String json;
    ResponseBean responseBean;
    String[] arr;
    List list;

    Map map;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initData();
        //LogcatViewer.showLogcatLoggerView(this);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //LogcatViewer.closeLogcatLoggerView(this);
    }

    private void initData() {
        json = "{\"success\":true,\"sysTime\":1513047713610,\"data\":{\"activity\":{\"id\":4956,\"type\":8,\"name\":\"Seckill\",\"countryId\":3,\"areaId\":1,\"bannerImg\":\"https://d12x8ezp3au6m3.cloudfront.net/activity/banner/f6kiJGteQALdbwEcKlZVIsGVcLVd-Lg6CxmVZ-Jn_Lo.jpg\",\"bannerImg2\":\"https://d12x8ezp3au6m3.cloudfront.net/activity/banner/9gNh7Ld2jFHArni-kTpweqXedO4LJJoUXP8rQPK36-U.jpg\",\"link\":\"\",\"beginTime\":1513000860000,\"endTime\":1513029600000,\"priceBeginTime\":1513000860000,\"priceEndTime\":1513029600000,\"colorTemplate\":{\"id\":3,\"name\":\"green\",\"param\":{\"leftRGB\":\"#FF4EB793\",\"rightRGB\":\"#FF335B60\"}}},\"list\":[]}}";
        responseBean = JSON.parseObject(json,ResponseBean.class);
        arr = new String[]{"89","djs","458","fjdsj"};
        list = new ArrayList();
        list.add("1");
        list.add(responseBean);
        list.add(89);
        list.add(89.9f);

        map = new HashMap();
        map.put("1",90);
        map.put("2","dd");
        map.put("4",56);
        map.put("6",78);
        map.put("9",responseBean);

    }

    @OnClick({R.id.json, R.id.array, R.id.list, R.id.map, R.id.activity, R.id.javabean})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.json:
                LogTest.json(json);
                break;
            case R.id.array:
                LogTest.obj(arr);
                break;
            case R.id.list:
                LogTest.obj(list);
                break;
            case R.id.map:
                LogTest.obj(map);
                break;
            case R.id.activity:
                LogTest.obj(this);
                break;
            case R.id.javabean:
                LogTest.obj(responseBean);
                break;
                default:break;
        }
    }
}
