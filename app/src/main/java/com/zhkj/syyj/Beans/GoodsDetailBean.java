package com.zhkj.syyj.Beans;

public class GoodsDetailBean {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1573628270
     * data : {"goods_id":220,"goods_name":"好多多","market_price":"35.00","shop_price":"29.90","goods_content":"<p><img src=\"https://img.alicdn.com/imgextra/i2/2046293456/TB2DKXvwR0lpuFjSszdXXcdxFXa_!!2046293456.jpg\"/><img src=\"https://img.alicdn.com/imgextra/i4/2046293456/TB2T1XvwR0lpuFjSszdXXcdxFXa_!!2046293456.jpg\"/><img src=\"https://img.alicdn.com/imgextra/i2/2046293456/TB2DKXvwR0lpuFjSszdXXcdxFXa_!!2046293456.jpg\"/><img src=\"https://img.alicdn.com/imgextra/i1/2046293456/TB2d.unwHRkpuFjSspmXXc.9XXa_!!2046293456.jpg\"/><img src=\"https://img.alicdn.com/imgextra/i1/2046293456/TB2iqnjnjihSKJjy0FlXXadEXXa_!!2046293456.jpg\"/><\/p>","is_share":0,"share_content":null,"sales_sum":38}
     */

    private int code;
    private String msg;
    private int time;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * goods_id : 220
         * goods_name : 好多多
         * market_price : 35.00
         * shop_price : 29.90
         * goods_content : <p><img src="https://img.alicdn.com/imgextra/i2/2046293456/TB2DKXvwR0lpuFjSszdXXcdxFXa_!!2046293456.jpg"/><img src="https://img.alicdn.com/imgextra/i4/2046293456/TB2T1XvwR0lpuFjSszdXXcdxFXa_!!2046293456.jpg"/><img src="https://img.alicdn.com/imgextra/i2/2046293456/TB2DKXvwR0lpuFjSszdXXcdxFXa_!!2046293456.jpg"/><img src="https://img.alicdn.com/imgextra/i1/2046293456/TB2d.unwHRkpuFjSspmXXc.9XXa_!!2046293456.jpg"/><img src="https://img.alicdn.com/imgextra/i1/2046293456/TB2iqnjnjihSKJjy0FlXXadEXXa_!!2046293456.jpg"/></p>
         * is_share : 0
         * share_content : null
         * sales_sum : 38
         */

        private int goods_id;
        private String goods_name;
        private String market_price;
        private String shop_price;
        private String goods_content;
        private int is_share;
        private Object share_content;
        private int sales_sum;

        public int getGoods_id() {
            return goods_id;
        }

        public void setGoods_id(int goods_id) {
            this.goods_id = goods_id;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public String getMarket_price() {
            return market_price;
        }

        public void setMarket_price(String market_price) {
            this.market_price = market_price;
        }

        public String getShop_price() {
            return shop_price;
        }

        public void setShop_price(String shop_price) {
            this.shop_price = shop_price;
        }

        public String getGoods_content() {
            return goods_content;
        }

        public void setGoods_content(String goods_content) {
            this.goods_content = goods_content;
        }

        public int getIs_share() {
            return is_share;
        }

        public void setIs_share(int is_share) {
            this.is_share = is_share;
        }

        public Object getShare_content() {
            return share_content;
        }

        public void setShare_content(Object share_content) {
            this.share_content = share_content;
        }

        public int getSales_sum() {
            return sales_sum;
        }

        public void setSales_sum(int sales_sum) {
            this.sales_sum = sales_sum;
        }
    }
}
