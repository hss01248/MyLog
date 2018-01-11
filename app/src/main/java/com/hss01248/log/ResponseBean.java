package com.hss01248.log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangshuisheng on 2017/12/12.
 */

public class ResponseBean {


    /**
     * success : true
     * sysTime : 1513047713610
     * data : {"activity":{"id":4956,"type":8,"name":"Seckill","countryId":3,"areaId":1,"bannerImg":"https://d12x8ezp3au6m3.cloudfront.net/activity/banner/f6kiJGteQALdbwEcKlZVIsGVcLVd-Lg6CxmVZ-Jn_Lo.jpg","bannerImg2":"https://d12x8ezp3au6m3.cloudfront.net/activity/banner/9gNh7Ld2jFHArni-kTpweqXedO4LJJoUXP8rQPK36-U.jpg","link":"","beginTime":1513000860000,"endTime":1513029600000,"priceBeginTime":1513000860000,"priceEndTime":1513029600000,"colorTemplate":{"id":3,"name":"green","param":{"leftRGB":"#FF4EB793","rightRGB":"#FF335B60"}}},"list":[]}
     */

    public boolean success = false;
    public long sysTime = System.currentTimeMillis();
    public DataBean data = new DataBean();

    public static class DataBean {
        /**
         * activity : {"id":4956,"type":8,"name":"Seckill","countryId":3,"areaId":1,"bannerImg":"https://d12x8ezp3au6m3.cloudfront.net/activity/banner/f6kiJGteQALdbwEcKlZVIsGVcLVd-Lg6CxmVZ-Jn_Lo.jpg","bannerImg2":"https://d12x8ezp3au6m3.cloudfront.net/activity/banner/9gNh7Ld2jFHArni-kTpweqXedO4LJJoUXP8rQPK36-U.jpg","link":"","beginTime":1513000860000,"endTime":1513029600000,"priceBeginTime":1513000860000,"priceEndTime":1513029600000,"colorTemplate":{"id":3,"name":"green","param":{"leftRGB":"#FF4EB793","rightRGB":"#FF335B60"}}}
         * list : []
         */

        public ActivityBean activity = new ActivityBean();
        public List<?> list = new ArrayList<>();

        public static class ActivityBean {
            /**
             * id : 4956
             * type : 8
             * name : Seckill
             * countryId : 3
             * areaId : 1
             * bannerImg : https://d12x8ezp3au6m3.cloudfront.net/activity/banner/f6kiJGteQALdbwEcKlZVIsGVcLVd-Lg6CxmVZ-Jn_Lo.jpg
             * bannerImg2 : https://d12x8ezp3au6m3.cloudfront.net/activity/banner/9gNh7Ld2jFHArni-kTpweqXedO4LJJoUXP8rQPK36-U.jpg
             * link :
             * beginTime : 1513000860000
             * endTime : 1513029600000
             * priceBeginTime : 1513000860000
             * priceEndTime : 1513029600000
             * colorTemplate : {"id":3,"name":"green","param":{"leftRGB":"#FF4EB793","rightRGB":"#FF335B60"}}
             */

            public int id = 4976;
            public int type = 3;
            public String name = "seckill";
            public int countryId;
            public int areaId;
            public String bannerImg = "http://www.baidu.com";
            public String bannerImg2;
            public String link;
            public long beginTime;
            public long endTime;
            public long priceBeginTime;
            public long priceEndTime;
            public ColorTemplateBean colorTemplate = new ColorTemplateBean();

            public static class ColorTemplateBean {
                /**
                 * id : 3
                 * name : green
                 * param : {"leftRGB":"#FF4EB793","rightRGB":"#FF335B60"}
                 */

                public int id = 5;
                public String name = "green";
                public ParamBean param = new ParamBean();

                public static class ParamBean {
                    /**
                     * leftRGB : #FF4EB793
                     * rightRGB : #FF335B60
                     */

                    public String leftRGB = "#FF4EB793";
                    public String rightRGB = "#FF335B60";
                }
            }
        }
    }
}
