package com.hss01248.log;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.OnClick;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {



    String json;
    ResponseBean responseBean;
    String[] arr;
    List list;

    Map map;

    String longjson;


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
        responseBean = new ResponseBean();



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

        longjson = "{\"success\":true,\"sysTime\":1538979108818,\"data\":[{\"itemId\":2900,\"categoryId\":27,\"algTag\":\"QXwzMDE5ODk5MDB8MTA5MDUxOTA0M3x8NTUzNjQ4MTMw\",\"itemName\":\"Tissor Mesin Absensi T4200\",\"img\":\"https://s3-ap-northeast-1.amazonaws.com/com-silvrr-installment/item/eZf5THoj8OWaWkYcExVQIpCAXJ3Z5gaQ8XZfWZe793k.jpg\",\"indexImgUrl\":\"https://s3-ap-northeast-1.amazonaws.com/com-silvrr-installment/item/eZf5THoj8OWaWkYcExVQIpCAXJ3Z5gaQ8XZfWZe793k.jpg\",\"price\":1790000,\"downPay\":448000,\"downPayment\":448000,\"isCollect\":0,\"skipCreditPayCheck\":false},{\"itemId\":35089,\"categoryId\":27,\"algTag\":\"QXwzMDE5ODk5MDB8MTA5MDUxOTA0M3x8NTUzNjQ4MTMw\",\"itemName\":\"OSCAR LIVING Hakari Baby Bed Anis HK 316 S - Putih\",\"img\":\"https://s3-ap-northeast-1.amazonaws.com/com-silvrr-installment/item/eWdevbxML2nm8-skt5WNzAXp_CXlTirbvX4BLCMDKz4.jpg\",\"indexImgUrl\":\"https://s3-ap-northeast-1.amazonaws.com/com-silvrr-installment/item/eWdevbxML2nm8-skt5WNzAXp_CXlTirbvX4BLCMDKz4.jpg\",\"price\":3515000,\"downPay\":879000,\"downPayment\":879000,\"isCollect\":0,\"vendorName\":\"JD\",\"score\":4.9,\"skipCreditPayCheck\":false},{\"itemId\":35052,\"categoryId\":27,\"algTag\":\"QXwzMDE5ODk5MDB8MTA5MDUxOTA0M3x8NTUzNjQ4MTMw\",\"itemName\":\"IKEA Lerberg Unit Rak - Merah/60x148cm\",\"img\":\"https://s3-ap-northeast-1.amazonaws.com/com-silvrr-installment/item/o6932ryLINQg5RIyPmSLCZVYEL8ZsPe3oijci9NkNKA.jpg\",\"indexImgUrl\":\"https://s3-ap-northeast-1.amazonaws.com/com-silvrr-installment/item/o6932ryLINQg5RIyPmSLCZVYEL8ZsPe3oijci9NkNKA.jpg\",\"price\":404000,\"downPay\":101000,\"downPayment\":101000,\"isCollect\":0,\"vendorName\":\"JD\",\"score\":4.9,\"skipCreditPayCheck\":false},{\"itemId\":2815,\"categoryId\":27,\"algTag\":\"QXwzMDE5ODk5MDB8MTA5MDUxOTA0M3x8NTUzNjQ4MTMw\",\"itemName\":\"Gemet 21H Mesin Jilid\",\"img\":\"https://s3-ap-northeast-1.amazonaws.com/com-silvrr-installment/item/tBtE7Povd72M6_i7OZ56JRBP7Q_YiDkPYo0gfHEkkHM.jpg\",\"indexImgUrl\":\"https://s3-ap-northeast-1.amazonaws.com/com-silvrr-installment/item/tBtE7Povd72M6_i7OZ56JRBP7Q_YiDkPYo0gfHEkkHM.jpg\",\"price\":958000,\"downPay\":240000,\"downPayment\":240000,\"isCollect\":0,\"skipCreditPayCheck\":"
                + "false},{\"itemId\":2395,\"categoryId\":27,\"algTag\":\"QXwzMDE5ODk5MDB8MTA5MDUxOTA0M3x8NTUzNjQ4MTMw\",\"itemName\":\"Sharp AC Split AH-A9SCY - 1 PK Standard\",\"img\":\"https://s3-ap-northeast-1.amazonaws.com/com-silvrr-installment/item/7BwsTO2_JdT_apdFmFAsI5GLdsXsvFkkfoPSNCTi6Eo.jpg\",\"indexImgUrl\":\"https://s3-ap-northeast-1.amazonaws.com/com-silvrr-installment/item/7BwsTO2_JdT_apdFmFAsI5GLdsXsvFkkfoPSNCTi6Eo.jpg\",\"isCollect\":0,\"skipCreditPayCheck\":false},{\"itemId\":31179,\"categoryId\":27,\"algTag\":\"QXwzMDE5ODk5MDB8MTA5MDUxOTA0M3x8NTUzNjQ4MTMw\",\"itemName\":\"MIYAKO Vacuum Cleaner VC-7100 WD\",\"img\":\"https://s3-ap-northeast-1.amazonaws.com/com-silvrr-installment/item/W_A24Wsxk0UXaJ0M3STXyPHfrYgM8nddUDGrkD_Hqyk.jpg\",\"indexImgUrl\":\"https://s3-ap-northeast-1.amazonaws.com/com-silvrr-installment/item/W_A24Wsxk0UXaJ0M3STXyPHfrYgM8nddUDGrkD_Hqyk.jpg\",\"price\":1290000,\"downPay\":323000,\"downPayment\":323000,\"isCollect\":0,\"vendorName\":\"JD\",\"score\":4.9,\"skipCreditPayCheck\":false},{\"itemId\":29057,\"categoryId\":27,\"algTag\":\"QXwzMDE5ODk5MDB8MTA5MDUxOTA0M3x8NTUzNjQ4MTMw\",\"itemName\":\"SHARP Mesin Cuci Top Loading Quick Wash Series 6.2 KG - ES-G865P-G\",\"img\":\"https://s3-ap-northeast-1.amazonaws.com/com-silvrr-installment/item/Q0WxaGY4HWpd_acf-5sHCoFMfFqiaXiY2KZ-w6af60Y.jpg\",\"indexImgUrl\":\"https://s3-ap-northeast-1.amazonaws.com/com-silvrr-installment/item/Q0WxaGY4HWpd_acf-5sHCoFMfFqiaXiY2KZ-w6af60Y.jpg\",\"price\":2514000,\"downPay\":629000,\"downPayment\":629000,\"isCollect\":0,\"vendorName\":\"JD\",\"score\":4.9,\"skipCreditPayCheck\":false},{\"itemId\":2651,\"categoryId\":27,\"algTag\":\"QXwzMDE5ODk5MDB8MTA5MDUxOTA0M3x8NTUzNjQ4MTMw\",\"itemName\":\"Modena Pembersih Debu VC 3013\",\"img\":\"https://s3-ap-northeast-1.amazonaws.com/com-silvrr-installment/item/-hd9fyhR7R8aVByJLIYpUxHxYvIPxVQwb-wW89Qs7N8.jpg\",\"indexImgUrl\":\"https://s3-ap-northeast-1.amazonaws.com/com-silvrr-installment/item/-hd9fyhR7R8aVByJLIYpUxHxYvIPxVQwb-wW89Qs7N8.jpg\",\"price\":1347000,\"downPay\":337000,\"downPayment\":337000,\"isCollect\":0,\"skipCreditPayCheck\":false},{\"itemId\":34480,\"categoryId\":27,\"algTag\":\"QXwzMDE5ODk5M"
                + "DB8MTA5MDUxOTA0M3x8NTUzNjQ4MTMw\",\"itemName\":\"[DISC] POLYTRON LED TV 32 Inch HD - PLD32D710\",\"img\":\"https://s3-ap-northeast-1.amazonaws.com/com-silvrr-installment/item/66V2XevKiBjutBfx0ePjl0OhVYN6UhpeIBST6G4XDwQ.jpg\",\"indexImgUrl\":\"https://s3-ap-northeast-1.amazonaws.com/com-silvrr-installment/item/66V2XevKiBjutBfx0ePjl0OhVYN6UhpeIBST6G4XDwQ.jpg\",\"price\":3114000,\"downPay\":779000,\"downPayment\":779000,\"isCollect\":0,\"vendorName\":\"JD\",\"score\":4.9,\"skipCreditPayCheck\":false}]}";

    }

    @OnClick({R.id.json, R.id.array, R.id.list, R.id.map, R.id.activity, R.id.javabean})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.json:
                LogTest.json(json);
                LogTest.json(longjson);
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
