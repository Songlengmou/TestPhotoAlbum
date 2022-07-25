package com.anningtex.testphotoalbum.bean;

import java.util.List;

/**
 * @Author Song
 * @Desc:
 * @Date：2021-09-26
 */
public class DesignOrderPicBean {

    /**
     * code : 1
     * msg : success
     * data : {"is_have_finished":false,"ggy":"","image_list":[{"OFLID":76912,"request_content":"11111:C02001,C02002,C04001/C04002","flower_no":"YT2108004C","flower_url_original":"http://192.168.0.155:8084/uploads/20210816/31fa80b6275ff098fce41bcc5b490362.jpg","flower_url_medium":"http://192.168.0.155:8084/medium/20210816/31fa80b6275ff098fce41bcc5b490362.jpg","flower_url_mini":"http://192.168.0.155:8084/mini/20210816/31fa80b6275ff098fce41bcc5b490362.jpg","color_url_original":"","color_url_medium":"","color_url_mini":"","flower_finished_url":"","drawing_image_url":"","color_card_list":[{"id":2322,"type":1,"color_code":"C02001","color_name":"C02001","system_id":15,"image_url":"","md5":"d1d29272ba0590821b75132b888212fb","qr_img":"/temp_QR/d1d29272ba0590821b75132b888212fb.png","palette":[{"id":2322,"element_id":2322,"color_id":2322,"color":{"id":2322,"type":1,"color_code":"C02001","color_name":"C02001","html_color":"F9B2A7","rgb_r":249,"rgb_g":178,"rgb_b":167}}],"color_system":{"id":15,"name":"C02"}},{"id":2323,"type":1,"color_code":"C02002","color_name":"C02002","system_id":15,"image_url":"","md5":"e97a5048b6c1869e1ed4c4153682326b","qr_img":"/temp_QR/e97a5048b6c1869e1ed4c4153682326b.png","palette":[{"id":2323,"element_id":2323,"color_id":2323,"color":{"id":2323,"type":1,"color_code":"C02002","color_name":"C02002","html_color":"FBBE9B","rgb_r":251,"rgb_g":190,"rgb_b":155}}],"color_system":{"id":15,"name":"C02"}},{"id":3423,"type":2,"color_code":"C04001/C04002","color_name":"C04001/C04002","system_id":0,"image_url":"","md5":"","qr_img":"","palette":[{"id":4108,"element_id":3423,"color_id":2341,"color":{"id":2341,"type":1,"color_code":"C04001","color_name":"C04001","html_color":"F0E6A0","rgb_r":240,"rgb_g":230,"rgb_b":160}},{"id":4109,"element_id":3423,"color_id":2342,"color":{"id":2342,"type":1,"color_code":"C04002","color_name":"C04002","html_color":"F5F0A0","rgb_r":245,"rgb_g":240,"rgb_b":160}}],"color_system":null}]}]}
     */

    private int code;
    private String msg;
    /**
     * is_have_finished : false
     * ggy :
     * image_list : [{"OFLID":76912,"request_content":"11111:C02001,C02002,C04001/C04002","flower_no":"YT2108004C","flower_url_original":"http://192.168.0.155:8084/uploads/20210816/31fa80b6275ff098fce41bcc5b490362.jpg","flower_url_medium":"http://192.168.0.155:8084/medium/20210816/31fa80b6275ff098fce41bcc5b490362.jpg","flower_url_mini":"http://192.168.0.155:8084/mini/20210816/31fa80b6275ff098fce41bcc5b490362.jpg","color_url_original":"","color_url_medium":"","color_url_mini":"","flower_finished_url":"","drawing_image_url":"","color_card_list":[{"id":2322,"type":1,"color_code":"C02001","color_name":"C02001","system_id":15,"image_url":"","md5":"d1d29272ba0590821b75132b888212fb","qr_img":"/temp_QR/d1d29272ba0590821b75132b888212fb.png","palette":[{"id":2322,"element_id":2322,"color_id":2322,"color":{"id":2322,"type":1,"color_code":"C02001","color_name":"C02001","html_color":"F9B2A7","rgb_r":249,"rgb_g":178,"rgb_b":167}}],"color_system":{"id":15,"name":"C02"}},{"id":2323,"type":1,"color_code":"C02002","color_name":"C02002","system_id":15,"image_url":"","md5":"e97a5048b6c1869e1ed4c4153682326b","qr_img":"/temp_QR/e97a5048b6c1869e1ed4c4153682326b.png","palette":[{"id":2323,"element_id":2323,"color_id":2323,"color":{"id":2323,"type":1,"color_code":"C02002","color_name":"C02002","html_color":"FBBE9B","rgb_r":251,"rgb_g":190,"rgb_b":155}}],"color_system":{"id":15,"name":"C02"}},{"id":3423,"type":2,"color_code":"C04001/C04002","color_name":"C04001/C04002","system_id":0,"image_url":"","md5":"","qr_img":"","palette":[{"id":4108,"element_id":3423,"color_id":2341,"color":{"id":2341,"type":1,"color_code":"C04001","color_name":"C04001","html_color":"F0E6A0","rgb_r":240,"rgb_g":230,"rgb_b":160}},{"id":4109,"element_id":3423,"color_id":2342,"color":{"id":2342,"type":1,"color_code":"C04002","color_name":"C04002","html_color":"F5F0A0","rgb_r":245,"rgb_g":240,"rgb_b":160}}],"color_system":null}]}]
     */

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private boolean is_have_finished;
        private String ggy;
        /**
         * OFLID : 76912
         * request_content : 11111:C02001,C02002,C04001/C04002
         * flower_no : YT2108004C
         * flower_url_original : http://192.168.0.155:8084/uploads/20210816/31fa80b6275ff098fce41bcc5b490362.jpg
         * flower_url_medium : http://192.168.0.155:8084/medium/20210816/31fa80b6275ff098fce41bcc5b490362.jpg
         * flower_url_mini : http://192.168.0.155:8084/mini/20210816/31fa80b6275ff098fce41bcc5b490362.jpg
         * color_url_original :
         * color_url_medium :
         * color_url_mini :
         * flower_finished_url :
         * drawing_image_url :
         * color_card_list : [{"id":2322,"type":1,"color_code":"C02001","color_name":"C02001","system_id":15,"image_url":"","md5":"d1d29272ba0590821b75132b888212fb","qr_img":"/temp_QR/d1d29272ba0590821b75132b888212fb.png","palette":[{"id":2322,"element_id":2322,"color_id":2322,"color":{"id":2322,"type":1,"color_code":"C02001","color_name":"C02001","html_color":"F9B2A7","rgb_r":249,"rgb_g":178,"rgb_b":167}}],"color_system":{"id":15,"name":"C02"}},{"id":2323,"type":1,"color_code":"C02002","color_name":"C02002","system_id":15,"image_url":"","md5":"e97a5048b6c1869e1ed4c4153682326b","qr_img":"/temp_QR/e97a5048b6c1869e1ed4c4153682326b.png","palette":[{"id":2323,"element_id":2323,"color_id":2323,"color":{"id":2323,"type":1,"color_code":"C02002","color_name":"C02002","html_color":"FBBE9B","rgb_r":251,"rgb_g":190,"rgb_b":155}}],"color_system":{"id":15,"name":"C02"}},{"id":3423,"type":2,"color_code":"C04001/C04002","color_name":"C04001/C04002","system_id":0,"image_url":"","md5":"","qr_img":"","palette":[{"id":4108,"element_id":3423,"color_id":2341,"color":{"id":2341,"type":1,"color_code":"C04001","color_name":"C04001","html_color":"F0E6A0","rgb_r":240,"rgb_g":230,"rgb_b":160}},{"id":4109,"element_id":3423,"color_id":2342,"color":{"id":2342,"type":1,"color_code":"C04002","color_name":"C04002","html_color":"F5F0A0","rgb_r":245,"rgb_g":240,"rgb_b":160}}],"color_system":null}]
         */

        private List<ImageListBean> image_list;

        public boolean isIs_have_finished() {
            return is_have_finished;
        }

        public void setIs_have_finished(boolean is_have_finished) {
            this.is_have_finished = is_have_finished;
        }

        public String getGgy() {
            return ggy;
        }

        public void setGgy(String ggy) {
            this.ggy = ggy;
        }

        public List<ImageListBean> getImage_list() {
            return image_list;
        }

        public void setImage_list(List<ImageListBean> image_list) {
            this.image_list = image_list;
        }

        public static class ImageListBean {
            private int OFLID;
            private String request_content;
            private String flower_no;
            private String flower_url_original;
            private String flower_url_medium;
            private String flower_url_mini;
            private String color_url_original;
            private String color_url_medium;
            private String color_url_mini;
            private String flower_finished_url;
            private String drawing_image_url;
            /**
             * id : 2322
             * type : 1
             * color_code : C02001
             * color_name : C02001
             * system_id : 15
             * image_url :
             * md5 : d1d29272ba0590821b75132b888212fb
             * qr_img : /temp_QR/d1d29272ba0590821b75132b888212fb.png
             * palette : [{"id":2322,"element_id":2322,"color_id":2322,"color":{"id":2322,"type":1,"color_code":"C02001","color_name":"C02001","html_color":"F9B2A7","rgb_r":249,"rgb_g":178,"rgb_b":167}}]
             * color_system : {"id":15,"name":"C02"}
             */

            private List<ColorCardListBean> color_card_list;

            public int getOFLID() {
                return OFLID;
            }

            public void setOFLID(int OFLID) {
                this.OFLID = OFLID;
            }

            public String getRequest_content() {
                return request_content;
            }

            public void setRequest_content(String request_content) {
                this.request_content = request_content;
            }

            public String getFlower_no() {
                return flower_no;
            }

            public void setFlower_no(String flower_no) {
                this.flower_no = flower_no;
            }

            public String getFlower_url_original() {
                return flower_url_original;
            }

            public void setFlower_url_original(String flower_url_original) {
                this.flower_url_original = flower_url_original;
            }

            public String getFlower_url_medium() {
                return flower_url_medium;
            }

            public void setFlower_url_medium(String flower_url_medium) {
                this.flower_url_medium = flower_url_medium;
            }

            public String getFlower_url_mini() {
                return flower_url_mini;
            }

            public void setFlower_url_mini(String flower_url_mini) {
                this.flower_url_mini = flower_url_mini;
            }

            public String getColor_url_original() {
                return color_url_original;
            }

            public void setColor_url_original(String color_url_original) {
                this.color_url_original = color_url_original;
            }

            public String getColor_url_medium() {
                return color_url_medium;
            }

            public void setColor_url_medium(String color_url_medium) {
                this.color_url_medium = color_url_medium;
            }

            public String getColor_url_mini() {
                return color_url_mini;
            }

            public void setColor_url_mini(String color_url_mini) {
                this.color_url_mini = color_url_mini;
            }

            public String getFlower_finished_url() {
                return flower_finished_url;
            }

            public void setFlower_finished_url(String flower_finished_url) {
                this.flower_finished_url = flower_finished_url;
            }

            public String getDrawing_image_url() {
                return drawing_image_url;
            }

            public void setDrawing_image_url(String drawing_image_url) {
                this.drawing_image_url = drawing_image_url;
            }

            public List<ColorCardListBean> getColor_card_list() {
                return color_card_list;
            }

            public void setColor_card_list(List<ColorCardListBean> color_card_list) {
                this.color_card_list = color_card_list;
            }

            public static class ColorCardListBean {
                private int id;
                private int type;
                private String color_code;
                private String color_name;
                private int system_id;
                private String image_url;
                private String md5;
                private String qr_img;
                /**
                 * id : 15
                 * name : C02
                 */

                private ColorSystemBean color_system;
                /**
                 * id : 2322
                 * element_id : 2322
                 * color_id : 2322
                 * color : {"id":2322,"type":1,"color_code":"C02001","color_name":"C02001","html_color":"F9B2A7","rgb_r":249,"rgb_g":178,"rgb_b":167}
                 */

                private List<PaletteBean> palette;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public String getColor_code() {
                    return color_code;
                }

                public void setColor_code(String color_code) {
                    this.color_code = color_code;
                }

                public String getColor_name() {
                    return color_name;
                }

                public void setColor_name(String color_name) {
                    this.color_name = color_name;
                }

                public int getSystem_id() {
                    return system_id;
                }

                public void setSystem_id(int system_id) {
                    this.system_id = system_id;
                }

                public String getImage_url() {
                    return image_url;
                }

                public void setImage_url(String image_url) {
                    this.image_url = image_url;
                }

                public String getMd5() {
                    return md5;
                }

                public void setMd5(String md5) {
                    this.md5 = md5;
                }

                public String getQr_img() {
                    return qr_img;
                }

                public void setQr_img(String qr_img) {
                    this.qr_img = qr_img;
                }

                public ColorSystemBean getColor_system() {
                    return color_system;
                }

                public void setColor_system(ColorSystemBean color_system) {
                    this.color_system = color_system;
                }

                public List<PaletteBean> getPalette() {
                    return palette;
                }

                public void setPalette(List<PaletteBean> palette) {
                    this.palette = palette;
                }

                public static class ColorSystemBean {
                    private int id;
                    private String name;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }
                }

                public static class PaletteBean {
                    private int id;
                    private int element_id;
                    private int color_id;
                    /**
                     * id : 2322
                     * type : 1
                     * color_code : C02001
                     * color_name : C02001
                     * html_color : F9B2A7
                     * rgb_r : 249
                     * rgb_g : 178
                     * rgb_b : 167
                     */

                    private ColorBean color;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public int getElement_id() {
                        return element_id;
                    }

                    public void setElement_id(int element_id) {
                        this.element_id = element_id;
                    }

                    public int getColor_id() {
                        return color_id;
                    }

                    public void setColor_id(int color_id) {
                        this.color_id = color_id;
                    }

                    public ColorBean getColor() {
                        return color;
                    }

                    public void setColor(ColorBean color) {
                        this.color = color;
                    }

                    public static class ColorBean {
                        private int id;
                        private int type;
                        private String color_code;
                        private String color_name;
                        private String html_color;
                        private int rgb_r;
                        private int rgb_g;
                        private int rgb_b;

                        public int getId() {
                            return id;
                        }

                        public void setId(int id) {
                            this.id = id;
                        }

                        public int getType() {
                            return type;
                        }

                        public void setType(int type) {
                            this.type = type;
                        }

                        public String getColor_code() {
                            return color_code;
                        }

                        public void setColor_code(String color_code) {
                            this.color_code = color_code;
                        }

                        public String getColor_name() {
                            return color_name;
                        }

                        public void setColor_name(String color_name) {
                            this.color_name = color_name;
                        }

                        public String getHtml_color() {
                            return html_color;
                        }

                        public void setHtml_color(String html_color) {
                            this.html_color = html_color;
                        }

                        public int getRgb_r() {
                            return rgb_r;
                        }

                        public void setRgb_r(int rgb_r) {
                            this.rgb_r = rgb_r;
                        }

                        public int getRgb_g() {
                            return rgb_g;
                        }

                        public void setRgb_g(int rgb_g) {
                            this.rgb_g = rgb_g;
                        }

                        public int getRgb_b() {
                            return rgb_b;
                        }

                        public void setRgb_b(int rgb_b) {
                            this.rgb_b = rgb_b;
                        }
                    }
                }
            }
        }
    }
}
