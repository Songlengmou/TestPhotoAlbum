package com.anningtex.testphotoalbum.bean;

import java.util.List;

/**
 * @Author Song
 * @Desc:
 * @Date：2021-09-26
 */
public class WaitContainerBean {

    /**
     * code : 1
     * msg : success
     * data : [{"id":2674,"bl_no":"NGNT11001500","container_no":"PCIU1265513","to_country_name":"赞比亚","load_date":"2021-08-21","leave_date":"2021-08-28","goods_list":[{"container_id":2674,"delivery_no":"SGJ-AN210821M","order_no":"DJ210607K","volume_unit":"0.1450","weight_unit":"110.0000","volume_total":"4.3500","weight_total":"3300.0000","number_total":"24688.8000","bale":30,"notes":"900码，欧丝雅发货，花色不齐21包，余仓库","meters_per_bale":"900","meters_per_bale_unit_id":1,"unit_name":"码"},{"container_id":2674,"delivery_no":"SGJ-AN210821H","order_no":"FO210316C","volume_unit":"0.1280","weight_unit":"103.0000","volume_total":"5.1200","weight_total":"4120.0000","number_total":"21945.6000","bale":40,"notes":"三和发货，加贸第3项，花色不齐3包，余仓库","meters_per_bale":"600","meters_per_bale_unit_id":1,"unit_name":"码"},{"container_id":2674,"delivery_no":"SGJ-AN210821H","order_no":"FO210413Z","volume_unit":"0.1280","weight_unit":"103.0000","volume_total":"11.5200","weight_total":"9270.0000","number_total":"49377.6000","bale":90,"notes":"三和发货，加贸第3项，余仓库","meters_per_bale":"600","meters_per_bale_unit_id":1,"unit_name":"码"},{"container_id":2674,"delivery_no":"SGJ-AN210821L","order_no":"POB210710Z","volume_unit":"0.1500","weight_unit":"109.5000","volume_total":"6.9000","weight_total":"5037.0000","number_total":"37856.1600","bale":46,"notes":"900码，欧丝雅发货，花色不齐9包，混花一包，余仓库","meters_per_bale":"900","meters_per_bale_unit_id":1,"unit_name":"码"}]}]
     */

    private int code;
    private String msg;
    /**
     * id : 2674
     * bl_no : NGNT11001500
     * container_no : PCIU1265513
     * to_country_name : 赞比亚
     * load_date : 2021-08-21
     * leave_date : 2021-08-28
     * goods_list : [{"container_id":2674,"delivery_no":"SGJ-AN210821M","order_no":"DJ210607K","volume_unit":"0.1450","weight_unit":"110.0000","volume_total":"4.3500","weight_total":"3300.0000","number_total":"24688.8000","bale":30,"notes":"900码，欧丝雅发货，花色不齐21包，余仓库","meters_per_bale":"900","meters_per_bale_unit_id":1,"unit_name":"码"},{"container_id":2674,"delivery_no":"SGJ-AN210821H","order_no":"FO210316C","volume_unit":"0.1280","weight_unit":"103.0000","volume_total":"5.1200","weight_total":"4120.0000","number_total":"21945.6000","bale":40,"notes":"三和发货，加贸第3项，花色不齐3包，余仓库","meters_per_bale":"600","meters_per_bale_unit_id":1,"unit_name":"码"},{"container_id":2674,"delivery_no":"SGJ-AN210821H","order_no":"FO210413Z","volume_unit":"0.1280","weight_unit":"103.0000","volume_total":"11.5200","weight_total":"9270.0000","number_total":"49377.6000","bale":90,"notes":"三和发货，加贸第3项，余仓库","meters_per_bale":"600","meters_per_bale_unit_id":1,"unit_name":"码"},{"container_id":2674,"delivery_no":"SGJ-AN210821L","order_no":"POB210710Z","volume_unit":"0.1500","weight_unit":"109.5000","volume_total":"6.9000","weight_total":"5037.0000","number_total":"37856.1600","bale":46,"notes":"900码，欧丝雅发货，花色不齐9包，混花一包，余仓库","meters_per_bale":"900","meters_per_bale_unit_id":1,"unit_name":"码"}]
     */

    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private int id;
        private String bl_no;
        private String container_no;
        private String to_country_name;
        private String load_date;
        private String leave_date;
        private String to_port;
        private String container_size;
        private int to_country_id;
        /**
         * container_id : 2674
         * delivery_no : SGJ-AN210821M
         * order_no : DJ210607K
         * volume_unit : 0.1450
         * weight_unit : 110.0000
         * volume_total : 4.3500
         * weight_total : 3300.0000
         * number_total : 24688.8000
         * bale : 30
         * notes : 900码，欧丝雅发货，花色不齐21包，余仓库
         * meters_per_bale : 900
         * meters_per_bale_unit_id : 1
         * unit_name : 码
         */

        private List<GoodsListBean> goods_list;

        public String getTo_port() {
            return to_port;
        }

        public void setTo_port(String to_port) {
            this.to_port = to_port;
        }

        public String getContainer_size() {
            return container_size;
        }

        public void setContainer_size(String container_size) {
            this.container_size = container_size;
        }

        public int getTo_country_id() {
            return to_country_id;
        }

        public void setTo_country_id(int to_country_id) {
            this.to_country_id = to_country_id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getBl_no() {
            return bl_no;
        }

        public void setBl_no(String bl_no) {
            this.bl_no = bl_no;
        }

        public String getContainer_no() {
            return container_no;
        }

        public void setContainer_no(String container_no) {
            this.container_no = container_no;
        }

        public String getTo_country_name() {
            return to_country_name;
        }

        public void setTo_country_name(String to_country_name) {
            this.to_country_name = to_country_name;
        }

        public String getLoad_date() {
            return load_date;
        }

        public void setLoad_date(String load_date) {
            this.load_date = load_date;
        }

        public String getLeave_date() {
            return leave_date;
        }

        public void setLeave_date(String leave_date) {
            this.leave_date = leave_date;
        }

        public List<GoodsListBean> getGoods_list() {
            return goods_list;
        }

        public void setGoods_list(List<GoodsListBean> goods_list) {
            this.goods_list = goods_list;
        }

        public static class GoodsListBean {
            private int container_id;
            private String delivery_no;
            private String order_no;
            private String volume_unit;
            private String weight_unit;
            private String volume_total;
            private String weight_total;
            private String number_total;
            private int bale;
            private String notes;
            private String meters_per_bale;
            private int meters_per_bale_unit_id;
            private String unit_name;
            private String tex_show_name;
            private int numPos;

            public int getNumPos() {
                return numPos;
            }

            public void setNumPos(int numPos) {
                this.numPos = numPos;
            }

            public String getTex_show_name() {
                return tex_show_name;
            }

            public void setTex_show_name(String tex_show_name) {
                this.tex_show_name = tex_show_name;
            }

            public int getContainer_id() {
                return container_id;
            }

            public void setContainer_id(int container_id) {
                this.container_id = container_id;
            }

            public String getDelivery_no() {
                return delivery_no;
            }

            public void setDelivery_no(String delivery_no) {
                this.delivery_no = delivery_no;
            }

            public String getOrder_no() {
                return order_no;
            }

            public void setOrder_no(String order_no) {
                this.order_no = order_no;
            }

            public String getVolume_unit() {
                return volume_unit;
            }

            public void setVolume_unit(String volume_unit) {
                this.volume_unit = volume_unit;
            }

            public String getWeight_unit() {
                return weight_unit;
            }

            public void setWeight_unit(String weight_unit) {
                this.weight_unit = weight_unit;
            }

            public String getVolume_total() {
                return volume_total;
            }

            public void setVolume_total(String volume_total) {
                this.volume_total = volume_total;
            }

            public String getWeight_total() {
                return weight_total;
            }

            public void setWeight_total(String weight_total) {
                this.weight_total = weight_total;
            }

            public String getNumber_total() {
                return number_total;
            }

            public void setNumber_total(String number_total) {
                this.number_total = number_total;
            }

            public int getBale() {
                return bale;
            }

            public void setBale(int bale) {
                this.bale = bale;
            }

            public String getNotes() {
                return notes;
            }

            public void setNotes(String notes) {
                this.notes = notes;
            }

            public String getMeters_per_bale() {
                return meters_per_bale;
            }

            public void setMeters_per_bale(String meters_per_bale) {
                this.meters_per_bale = meters_per_bale;
            }

            public int getMeters_per_bale_unit_id() {
                return meters_per_bale_unit_id;
            }

            public void setMeters_per_bale_unit_id(int meters_per_bale_unit_id) {
                this.meters_per_bale_unit_id = meters_per_bale_unit_id;
            }

            public String getUnit_name() {
                return unit_name;
            }

            public void setUnit_name(String unit_name) {
                this.unit_name = unit_name;
            }
        }
    }
}