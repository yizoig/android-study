package com.example.exvu.myapplication;

import java.util.List;

/**
 * Created by exvu on 2018/5/8.
 */

public class User {

    /**
     * code : 20000
     * data : {"list":[{"id":"5792","driver":"1","driver_name":"杨旭测试","driver_phone":"13595246930","vehicle":"27","vehicle_code":"贵C1178F","vehicle_key":"GT-030","route":"4","route_name":"1路返回（保利-高铁站）","route_loop":"3","route_info":"保利游乐园.保利未来城市.药业园区.忠庄客运站.嵩山路口.红花岗区政府.南岭山水.南岭公园.塑料厂.老年公寓.南岭路口.海风井.华南酒店.丝织厂.迎红桥办事处.迎红桥.洛江桥.迎宾大道.颜村.高铁站","price":"8.00","schedule":"2","start_time":"2018-05-07 15:17:59","end_time":"2018-05-07 15:18:06","type":"0","weitotal":"0.00","alipaytotal":"0.00","weinumber":"0","alipaynumber":"0"},{"id":"5781","driver":"18","driver_name":"王益鹏","driver_phone":"15885656508","vehicle":"26","vehicle_code":"贵C1552F","vehicle_key":"GT-026","route":"8","route_name":"3路返回（添阳小区-高铁站）","route_loop":"7","route_info":"添阳小区.1964文化创意园.自由港奥特莱斯.汕头路.实验幼儿园.火柴厂.遵义市第一人民医院.遵义宾馆.遵义会议会址.洗花桥.桃溪路口.洛江桥.迎宾大道.颜村.高铁站","price":"8.00","schedule":"2","start_time":"2018-05-07 13:34:36","end_time":"2018-05-07 13:50:59","type":"0","weitotal":"0.00","alipaytotal":"0.00","weinumber":"0","alipaynumber":"0"},{"id":"5780","driver":"18","driver_name":"王益鹏","driver_phone":"15885656508","vehicle":"26","vehicle_code":"贵C1552F","vehicle_key":"GT-026","route":"7","route_name":"3路（高铁站-添阳小区）","route_loop":"8","route_info":"高铁站.颜村.龙礼路.万福桥.遵义三小.遵义三中.白杨洞.国贸广场.重百商城.武装部.凤凰山公园.遵义宾馆.火柴厂.高桥.西安路口.汇川区第三小学.鼎盛家园.添阳小区","price":"8.00","schedule":"2","start_time":"2018-05-07 13:34:25","end_time":"2018-05-07 13:34:29","type":"0","weitotal":"0.00","alipaytotal":"0.00","weinumber":"0","alipaynumber":"0"},{"id":"5779","driver":"18","driver_name":"王益鹏","driver_phone":"15885656508","vehicle":"26","vehicle_code":"贵C1552F","vehicle_key":"GT-026","route":"8","route_name":"3路返回（添阳小区-高铁站）","route_loop":"7","route_info":"添阳小区.1964文化创意园.自由港奥特莱斯.汕头路.实验幼儿园.火柴厂.遵义市第一人民医院.遵义宾馆.遵义会议会址.洗花桥.桃溪路口.洛江桥.迎宾大道.颜村.高铁站","price":"8.00","schedule":"2","start_time":"2018-05-07 13:34:08","end_time":"2018-05-07 13:34:21","type":"0","weitotal":"0.00","alipaytotal":"0.00","weinumber":"0","alipaynumber":"0"},{"id":"5746","driver":"19","driver_name":"杨峰","driver_phone":"15685228615","vehicle":"1","vehicle_code":"贵C0980F","vehicle_key":"GT-001","route":"3","route_name":"1路（高铁站-保利）","route_loop":"4","route_info":"高铁站.高铁一号小区.颜村.迎宾大道.洛江桥.迎红桥.海风井.南岭路口.老年公寓.塑料厂.南岭公园.红花岗区政府.嵩山路口.忠庄客运站.富邦家装商城.药业园区.保利未来城市.保利游乐园","price":"8.00","schedule":"2","start_time":"2018-05-07 13:33:07","end_time":"2018-05-07 13:33:09","type":"0","weitotal":"0.00","alipaytotal":"0.00","weinumber":"0","alipaynumber":"0"}],"pagination":{"pageSize":5,"total":17},"statistics":{"weitotal":"816.00","alipaytotal":"64.00","count":"89","number":"110"}}
     */

    public int code;
    public DataBean data;

    public static class DataBean {
        /**
         * list : [{"id":"5792","driver":"1","driver_name":"杨旭测试","driver_phone":"13595246930","vehicle":"27","vehicle_code":"贵C1178F","vehicle_key":"GT-030","route":"4","route_name":"1路返回（保利-高铁站）","route_loop":"3","route_info":"保利游乐园.保利未来城市.药业园区.忠庄客运站.嵩山路口.红花岗区政府.南岭山水.南岭公园.塑料厂.老年公寓.南岭路口.海风井.华南酒店.丝织厂.迎红桥办事处.迎红桥.洛江桥.迎宾大道.颜村.高铁站","price":"8.00","schedule":"2","start_time":"2018-05-07 15:17:59","end_time":"2018-05-07 15:18:06","type":"0","weitotal":"0.00","alipaytotal":"0.00","weinumber":"0","alipaynumber":"0"},{"id":"5781","driver":"18","driver_name":"王益鹏","driver_phone":"15885656508","vehicle":"26","vehicle_code":"贵C1552F","vehicle_key":"GT-026","route":"8","route_name":"3路返回（添阳小区-高铁站）","route_loop":"7","route_info":"添阳小区.1964文化创意园.自由港奥特莱斯.汕头路.实验幼儿园.火柴厂.遵义市第一人民医院.遵义宾馆.遵义会议会址.洗花桥.桃溪路口.洛江桥.迎宾大道.颜村.高铁站","price":"8.00","schedule":"2","start_time":"2018-05-07 13:34:36","end_time":"2018-05-07 13:50:59","type":"0","weitotal":"0.00","alipaytotal":"0.00","weinumber":"0","alipaynumber":"0"},{"id":"5780","driver":"18","driver_name":"王益鹏","driver_phone":"15885656508","vehicle":"26","vehicle_code":"贵C1552F","vehicle_key":"GT-026","route":"7","route_name":"3路（高铁站-添阳小区）","route_loop":"8","route_info":"高铁站.颜村.龙礼路.万福桥.遵义三小.遵义三中.白杨洞.国贸广场.重百商城.武装部.凤凰山公园.遵义宾馆.火柴厂.高桥.西安路口.汇川区第三小学.鼎盛家园.添阳小区","price":"8.00","schedule":"2","start_time":"2018-05-07 13:34:25","end_time":"2018-05-07 13:34:29","type":"0","weitotal":"0.00","alipaytotal":"0.00","weinumber":"0","alipaynumber":"0"},{"id":"5779","driver":"18","driver_name":"王益鹏","driver_phone":"15885656508","vehicle":"26","vehicle_code":"贵C1552F","vehicle_key":"GT-026","route":"8","route_name":"3路返回（添阳小区-高铁站）","route_loop":"7","route_info":"添阳小区.1964文化创意园.自由港奥特莱斯.汕头路.实验幼儿园.火柴厂.遵义市第一人民医院.遵义宾馆.遵义会议会址.洗花桥.桃溪路口.洛江桥.迎宾大道.颜村.高铁站","price":"8.00","schedule":"2","start_time":"2018-05-07 13:34:08","end_time":"2018-05-07 13:34:21","type":"0","weitotal":"0.00","alipaytotal":"0.00","weinumber":"0","alipaynumber":"0"},{"id":"5746","driver":"19","driver_name":"杨峰","driver_phone":"15685228615","vehicle":"1","vehicle_code":"贵C0980F","vehicle_key":"GT-001","route":"3","route_name":"1路（高铁站-保利）","route_loop":"4","route_info":"高铁站.高铁一号小区.颜村.迎宾大道.洛江桥.迎红桥.海风井.南岭路口.老年公寓.塑料厂.南岭公园.红花岗区政府.嵩山路口.忠庄客运站.富邦家装商城.药业园区.保利未来城市.保利游乐园","price":"8.00","schedule":"2","start_time":"2018-05-07 13:33:07","end_time":"2018-05-07 13:33:09","type":"0","weitotal":"0.00","alipaytotal":"0.00","weinumber":"0","alipaynumber":"0"}]
         * pagination : {"pageSize":5,"total":17}
         * statistics : {"weitotal":"816.00","alipaytotal":"64.00","count":"89","number":"110"}
         */

        public PaginationBean pagination;
        public StatisticsBean statistics;
        public List<ListBean> list;

        public static class PaginationBean {
            /**
             * pageSize : 5
             * total : 17
             */

            public int pageSize;
            public int total;
        }

        public static class StatisticsBean {
            /**
             * weitotal : 816.00
             * alipaytotal : 64.00
             * count : 89
             * number : 110
             */

            public String weitotal;
            public String alipaytotal;
            public String count;
            public String number;
        }

        public static class ListBean {
            /**
             * id : 5792
             * driver : 1
             * driver_name : 杨旭测试
             * driver_phone : 13595246930
             * vehicle : 27
             * vehicle_code : 贵C1178F
             * vehicle_key : GT-030
             * route : 4
             * route_name : 1路返回（保利-高铁站）
             * route_loop : 3
             * route_info : 保利游乐园.保利未来城市.药业园区.忠庄客运站.嵩山路口.红花岗区政府.南岭山水.南岭公园.塑料厂.老年公寓.南岭路口.海风井.华南酒店.丝织厂.迎红桥办事处.迎红桥.洛江桥.迎宾大道.颜村.高铁站
             * price : 8.00
             * schedule : 2
             * start_time : 2018-05-07 15:17:59
             * end_time : 2018-05-07 15:18:06
             * type : 0
             * weitotal : 0.00
             * alipaytotal : 0.00
             * weinumber : 0
             * alipaynumber : 0
             */

            public String id;
            public String driver;
            public String driver_name;
            public String driver_phone;
            public String vehicle;
            public String vehicle_code;
            public String vehicle_key;
            public String route;
            public String route_name;
            public String route_loop;
            public String route_info;
            public String price;
            public String schedule;
            public String start_time;
            public String end_time;
            public String type;
            public String weitotal;
            public String alipaytotal;
            public String weinumber;
            public String alipaynumber;
        }
    }
}