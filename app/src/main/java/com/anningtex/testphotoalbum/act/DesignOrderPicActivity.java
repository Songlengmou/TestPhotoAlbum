package com.anningtex.testphotoalbum.act;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.anningtex.testphotoalbum.R;
import com.anningtex.testphotoalbum.bean.DesignOrderPicBean;
import com.anningtex.testphotoalbum.weight.GlideEngine;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.syp.library.BaseRecycleAdapter;

import java.util.List;

/**
 * https://github.com/LuckSiege/PictureSelector/wiki/PictureSelector-Api%E8%AF%B4%E6%98%8E
 *
 * @author Administrator
 * desc: {"code":1,"msg":"success","data":{"is_have_finished":false,"ggy":"","image_list":[{"OFLID":76912,"request_content":"11111:C02001,C02002,C04001/C04002","flower_no":"YT2108004C","flower_url_original":"https://www.africatex.com:706/order_flower_make_image/medium/20210913/823906892d04ff8ff9b17e2d9b5034d5.jpg","flower_url_medium":"https://www.africatex.com:706/order_flower_make_image/medium/20210913/823906892d04ff8ff9b17e2d9b5034d5.jpg","flower_url_mini":"https://www.africatex.com:706/order_flower_make_image/medium/20210913/823906892d04ff8ff9b17e2d9b5034d5.jpg","color_url_original":"","color_url_medium":"","color_url_mini":"","flower_finished_url":"","drawing_image_url":"","color_card_list":[{"id":2322,"type":1,"color_code":"C02001","color_name":"C02001","system_id":15,"image_url":"","md5":"d1d29272ba0590821b75132b888212fb","qr_img":"/temp_QR/d1d29272ba0590821b75132b888212fb.png","palette":[{"id":2322,"element_id":2322,"color_id":2322,"color":{"id":2322,"type":1,"color_code":"C02001","color_name":"C02001","html_color":"F9B2A7","rgb_r":249,"rgb_g":178,"rgb_b":167}}],"color_system":{"id":15,"name":"C02"}},{"id":2323,"type":1,"color_code":"C02002","color_name":"C02002","system_id":15,"image_url":"","md5":"e97a5048b6c1869e1ed4c4153682326b","qr_img":"/temp_QR/e97a5048b6c1869e1ed4c4153682326b.png","palette":[{"id":2323,"element_id":2323,"color_id":2323,"color":{"id":2323,"type":1,"color_code":"C02002","color_name":"C02002","html_color":"FBBE9B","rgb_r":251,"rgb_g":190,"rgb_b":155}}],"color_system":{"id":15,"name":"C02"}},{"id":3423,"type":2,"color_code":"C04001/C04002","color_name":"C04001/C04002","system_id":0,"image_url":"","md5":"","qr_img":"","palette":[{"id":4108,"element_id":3423,"color_id":2341,"color":{"id":2341,"type":1,"color_code":"C04001","color_name":"C04001","html_color":"F0E6A0","rgb_r":240,"rgb_g":230,"rgb_b":160}},{"id":4109,"element_id":3423,"color_id":2342,"color":{"id":2342,"type":1,"color_code":"C04002","color_name":"C04002","html_color":"F5F0A0","rgb_r":245,"rgb_g":240,"rgb_b":160}}],"color_system":null}]},{"OFLID":86912,"request_content":"11111:C02001,C02002,C04001/C04002","flower_no":"YT2108004C","flower_url_original":"https://www.africatex.com:706/order_flower_make_image/medium/20210913/823906892d04ff8ff9b17e2d9b5034d5.jpg","flower_url_medium":"https://www.africatex.com:706/order_flower_make_image/medium/20210913/823906892d04ff8ff9b17e2d9b5034d5.jpg","flower_url_mini":"https://www.africatex.com:706/order_flower_make_image/medium/20210913/823906892d04ff8ff9b17e2d9b5034d5.jpg","color_url_original":"","color_url_medium":"","color_url_mini":"","flower_finished_url":"","drawing_image_url":"","color_card_list":[{"id":2322,"type":1,"color_code":"C02001","color_name":"C02001","system_id":15,"image_url":"","md5":"d1d29272ba0590821b75132b888212fb","qr_img":"/temp_QR/d1d29272ba0590821b75132b888212fb.png","palette":[{"id":2322,"element_id":2322,"color_id":2322,"color":{"id":2322,"type":1,"color_code":"C02001","color_name":"C02001","html_color":"F9B2A7","rgb_r":249,"rgb_g":178,"rgb_b":167}}],"color_system":{"id":15,"name":"C02"}},{"id":2323,"type":1,"color_code":"C02002","color_name":"C02002","system_id":15,"image_url":"","md5":"e97a5048b6c1869e1ed4c4153682326b","qr_img":"/temp_QR/e97a5048b6c1869e1ed4c4153682326b.png","palette":[{"id":2323,"element_id":2323,"color_id":2323,"color":{"id":2323,"type":1,"color_code":"C02002","color_name":"C02002","html_color":"FBBE9B","rgb_r":251,"rgb_g":190,"rgb_b":155}}],"color_system":{"id":15,"name":"C02"}},{"id":3423,"type":2,"color_code":"C04001/C04002","color_name":"C04001/C04002","system_id":0,"image_url":"","md5":"","qr_img":"","palette":[{"id":4108,"element_id":3423,"color_id":2341,"color":{"id":2341,"type":1,"color_code":"C04001","color_name":"C04001","html_color":"F0E6A0","rgb_r":240,"rgb_g":230,"rgb_b":160}},{"id":4109,"element_id":3423,"color_id":2342,"color":{"id":2342,"type":1,"color_code":"C04002","color_name":"C04002","html_color":"F5F0A0","rgb_r":245,"rgb_g":240,"rgb_b":160}}],"color_system":null}]}]}}
 */
public class DesignOrderPicActivity extends AppCompatActivity {
    private RecyclerView mRecycle;
    private BaseRecycleAdapter<DesignOrderPicBean.DataBean.ImageListBean> recycleAdapter;
    private String json = "{\"code\":1,\"msg\":\"success\",\"data\":{\"is_have_finished\":false,\"ggy\":\"\",\"image_list\":[{\"OFLID\":76912,\"request_content\":\"11111:C02001,C02002,C04001/C04002\",\"flower_no\":\"YT2108004C\",\"flower_url_original\":\"https://www.africatex.com:706/order_flower_make_image/medium/20210913/823906892d04ff8ff9b17e2d9b5034d5.jpg\",\"flower_url_medium\":\"https://www.africatex.com:706/order_flower_make_image/medium/20210913/823906892d04ff8ff9b17e2d9b5034d5.jpg\",\"flower_url_mini\":\"https://www.africatex.com:706/order_flower_make_image/medium/20210913/823906892d04ff8ff9b17e2d9b5034d5.jpg\",\"color_url_original\":\"\",\"color_url_medium\":\"\",\"color_url_mini\":\"\",\"flower_finished_url\":\"\",\"drawing_image_url\":\"\",\"color_card_list\":[{\"id\":2322,\"type\":1,\"color_code\":\"C02001\",\"color_name\":\"C02001\",\"system_id\":15,\"image_url\":\"\",\"md5\":\"d1d29272ba0590821b75132b888212fb\",\"qr_img\":\"/temp_QR/d1d29272ba0590821b75132b888212fb.png\",\"palette\":[{\"id\":2322,\"element_id\":2322,\"color_id\":2322,\"color\":{\"id\":2322,\"type\":1,\"color_code\":\"C02001\",\"color_name\":\"C02001\",\"html_color\":\"F9B2A7\",\"rgb_r\":249,\"rgb_g\":178,\"rgb_b\":167}}],\"color_system\":{\"id\":15,\"name\":\"C02\"}},{\"id\":2323,\"type\":1,\"color_code\":\"C02002\",\"color_name\":\"C02002\",\"system_id\":15,\"image_url\":\"\",\"md5\":\"e97a5048b6c1869e1ed4c4153682326b\",\"qr_img\":\"/temp_QR/e97a5048b6c1869e1ed4c4153682326b.png\",\"palette\":[{\"id\":2323,\"element_id\":2323,\"color_id\":2323,\"color\":{\"id\":2323,\"type\":1,\"color_code\":\"C02002\",\"color_name\":\"C02002\",\"html_color\":\"FBBE9B\",\"rgb_r\":251,\"rgb_g\":190,\"rgb_b\":155}}],\"color_system\":{\"id\":15,\"name\":\"C02\"}},{\"id\":3423,\"type\":2,\"color_code\":\"C04001/C04002\",\"color_name\":\"C04001/C04002\",\"system_id\":0,\"image_url\":\"\",\"md5\":\"\",\"qr_img\":\"\",\"palette\":[{\"id\":4108,\"element_id\":3423,\"color_id\":2341,\"color\":{\"id\":2341,\"type\":1,\"color_code\":\"C04001\",\"color_name\":\"C04001\",\"html_color\":\"F0E6A0\",\"rgb_r\":240,\"rgb_g\":230,\"rgb_b\":160}},{\"id\":4109,\"element_id\":3423,\"color_id\":2342,\"color\":{\"id\":2342,\"type\":1,\"color_code\":\"C04002\",\"color_name\":\"C04002\",\"html_color\":\"F5F0A0\",\"rgb_r\":245,\"rgb_g\":240,\"rgb_b\":160}}],\"color_system\":null}]},{\"OFLID\":86912,\"request_content\":\"11111:C02001,C02002,C04001/C04002\",\"flower_no\":\"YT2108004C\",\"flower_url_original\":\"https://www.africatex.com:706/order_flower_make_image/medium/20210913/823906892d04ff8ff9b17e2d9b5034d5.jpg\",\"flower_url_medium\":\"https://www.africatex.com:706/order_flower_make_image/medium/20210913/823906892d04ff8ff9b17e2d9b5034d5.jpg\",\"flower_url_mini\":\"https://www.africatex.com:706/order_flower_make_image/medium/20210913/823906892d04ff8ff9b17e2d9b5034d5.jpg\",\"color_url_original\":\"\",\"color_url_medium\":\"\",\"color_url_mini\":\"\",\"flower_finished_url\":\"\",\"drawing_image_url\":\"\",\"color_card_list\":[{\"id\":2322,\"type\":1,\"color_code\":\"C02001\",\"color_name\":\"C02001\",\"system_id\":15,\"image_url\":\"\",\"md5\":\"d1d29272ba0590821b75132b888212fb\",\"qr_img\":\"/temp_QR/d1d29272ba0590821b75132b888212fb.png\",\"palette\":[{\"id\":2322,\"element_id\":2322,\"color_id\":2322,\"color\":{\"id\":2322,\"type\":1,\"color_code\":\"C02001\",\"color_name\":\"C02001\",\"html_color\":\"F9B2A7\",\"rgb_r\":249,\"rgb_g\":178,\"rgb_b\":167}}],\"color_system\":{\"id\":15,\"name\":\"C02\"}},{\"id\":2323,\"type\":1,\"color_code\":\"C02002\",\"color_name\":\"C02002\",\"system_id\":15,\"image_url\":\"\",\"md5\":\"e97a5048b6c1869e1ed4c4153682326b\",\"qr_img\":\"/temp_QR/e97a5048b6c1869e1ed4c4153682326b.png\",\"palette\":[{\"id\":2323,\"element_id\":2323,\"color_id\":2323,\"color\":{\"id\":2323,\"type\":1,\"color_code\":\"C02002\",\"color_name\":\"C02002\",\"html_color\":\"FBBE9B\",\"rgb_r\":251,\"rgb_g\":190,\"rgb_b\":155}}],\"color_system\":{\"id\":15,\"name\":\"C02\"}},{\"id\":3423,\"type\":2,\"color_code\":\"C04001/C04002\",\"color_name\":\"C04001/C04002\",\"system_id\":0,\"image_url\":\"\",\"md5\":\"\",\"qr_img\":\"\",\"palette\":[{\"id\":4108,\"element_id\":3423,\"color_id\":2341,\"color\":{\"id\":2341,\"type\":1,\"color_code\":\"C04001\",\"color_name\":\"C04001\",\"html_color\":\"F0E6A0\",\"rgb_r\":240,\"rgb_g\":230,\"rgb_b\":160}},{\"id\":4109,\"element_id\":3423,\"color_id\":2342,\"color\":{\"id\":2342,\"type\":1,\"color_code\":\"C04002\",\"color_name\":\"C04002\",\"html_color\":\"F5F0A0\",\"rgb_r\":245,\"rgb_g\":240,\"rgb_b\":160}}],\"color_system\":null}]}]}}";
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_order_pic);
        initView();
    }

    private void initView() {
        mRecycle = findViewById(R.id.recycle);
        DesignOrderPicBean orderPicBean = new Gson().fromJson(json, DesignOrderPicBean.class);
        List<DesignOrderPicBean.DataBean.ImageListBean> imageList = orderPicBean.getData().getImage_list();
        if (imageList != null && imageList.size() > 0) {
            recycleAdapter = new BaseRecycleAdapter<>(R.layout.item_design_order_finish_pic, imageList);
            recycleAdapter.setOnDataToViewListener((helper, item, position) -> {
                DesignOrderPicBean.DataBean.ImageListBean listBean = (DesignOrderPicBean.DataBean.ImageListBean) item;
                helper.setText(R.id.tv_num, position + 1 + "");
                helper.setText(R.id.tv_flowerNo, listBean.getFlower_no());
                ImageView ivDesign = helper.getView(R.id.iv_design);
                ImageView ivFinish = helper.getView(R.id.iv_finish);
                Glide.with(this).load(listBean.getFlower_url_mini()).fallback(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(ivDesign);
                Glide.with(this).load(listBean.getFlower_finished_url()).fallback(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(ivFinish);
                ivFinish.setOnClickListener(view -> {
                    index = position;
                    PictureSelector.create(DesignOrderPicActivity.this)
                            .openGallery(PictureMimeType.ofImage())
                            .imageEngine(GlideEngine.createGlideEngine())
                            .maxSelectNum(1)
                            .minSelectNum(1)
                            .withAspectRatio(4, 3)
                            .cropImageWideHigh(1200, 900)
                            .compress(true)
                            .forResult(PictureConfig.CHOOSE_REQUEST);
                });
            });
            mRecycle.setAdapter(recycleAdapter);
        }
    }

    @SuppressLint({"DefaultLocale", "NotifyDataSetChanged"})
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PictureConfig.CHOOSE_REQUEST && resultCode == RESULT_OK) {
            Log.e("TAG相机", "data: " + data + "  requestCode: " + requestCode + "  resultCode: " + resultCode);
            if (data != null) {
                List<LocalMedia> localMedia = PictureSelector.obtainMultipleResult(data);
                recycleAdapter.getData().get(index).setFlower_finished_url(localMedia.get(0).getPath());
                recycleAdapter.notifyDataSetChanged();
            } else {
                Toast.makeText(DesignOrderPicActivity.this, "未找到存储卡,无法存储照片!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}