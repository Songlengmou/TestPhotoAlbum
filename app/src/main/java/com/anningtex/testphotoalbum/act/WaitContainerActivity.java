package com.anningtex.testphotoalbum.act;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.anningtex.testphotoalbum.R;
import com.anningtex.testphotoalbum.bean.WaitContainerBean;
import com.anningtex.testphotoalbum.json.Contans;
import com.anningtex.testphotoalbum.weight.MyItemTouchHelper;
import com.anningtex.testphotoalbum.weight.StringUtils;
import com.google.gson.Gson;
import com.syp.library.BaseRecycleAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Administrator
 */
public class WaitContainerActivity extends AppCompatActivity {
    private RecyclerView mRecycle;
    private Spinner mSpinner;
    private LinearLayoutCompat mLlTitle;
    private TextView mTvBaleZ, mTvVolumeZ, mTvWeightZ;
    private TextView mTvIsShow, mTvCreate;
    private TextView mTvContainerNo, mTvLoadDate, mTvLeaveDate, mTvCountryName, mTvToPort, mTvContainerSize;
    private final List<String> blNoList = new ArrayList<>();
    private double zBale = 0.0, zVolume = 0.0, zWeight = 0.0;
    private BaseRecycleAdapter<WaitContainerBean.DataBean.GoodsListBean> recycleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        setContentView(R.layout.activity_wait_container);
        initView();
        onClick();
        titleData();
    }

    private void initView() {
        mTvIsShow = findViewById(R.id.tv_isShow);
        mTvCreate = findViewById(R.id.tv_create);
        mLlTitle = findViewById(R.id.ll_title);
        mTvBaleZ = findViewById(R.id.tv_bale_z);
        mTvVolumeZ = findViewById(R.id.tv_volume_z);
        mTvWeightZ = findViewById(R.id.tv_weight_z);
        mRecycle = findViewById(R.id.recycle);
        mSpinner = findViewById(R.id.spinner);
        mTvContainerNo = findViewById(R.id.tv_containerNo);
        mTvLoadDate = findViewById(R.id.tv_load_date);
        mTvLeaveDate = findViewById(R.id.tv_leave_date);
        mTvCountryName = findViewById(R.id.tv_country_name);
        mTvToPort = findViewById(R.id.tv_to_port);
        mTvContainerSize = findViewById(R.id.tv_container_size);
    }

    private void onClick() {
        mTvIsShow.setOnClickListener(view -> {
            String trim = mTvIsShow.getText().toString().trim();
            if ("关闭".equals(trim)) {
                mLlTitle.setVisibility(View.GONE);
                mTvIsShow.setText("打开");
            } else if ("打开".equals(trim)) {
                mLlTitle.setVisibility(View.VISIBLE);
                mTvIsShow.setText("关闭");
            }
        });
        mTvCreate.setOnClickListener(view -> {
            Toast.makeText(this, "创建集装箱号", Toast.LENGTH_SHORT).show();
        });
    }

    private void titleData() {
        WaitContainerBean waitContainerBean = new Gson().fromJson(Contans.JSON, WaitContainerBean.class);
        List<WaitContainerBean.DataBean> dataBeans = waitContainerBean.getData();
        for (WaitContainerBean.DataBean dataBean : dataBeans) {
            blNoList.add(dataBean.getBl_no());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, blNoList);
        mSpinner.setAdapter(adapter);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mTvContainerNo.setText("集装箱号: " + dataBeans.get(i).getContainer_no());
                mTvLoadDate.setText("装箱日期: " + dataBeans.get(i).getLoad_date());
                mTvLeaveDate.setText("出船货期: " + dataBeans.get(i).getLeave_date());
                mTvCountryName.setText("国别: " + dataBeans.get(i).getTo_country_name());
                mTvToPort.setText("目的港: " + dataBeans.get(i).getTo_port());
                mTvContainerSize.setText("箱型: " + dataBeans.get(i).getContainer_size());
                recycleData(dataBeans.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @SuppressLint("NotifyDataSetChanged")
    private void recycleData(WaitContainerBean.DataBean dataBean) {
        List<WaitContainerBean.DataBean.GoodsListBean> goodsListBeans = dataBean.getGoods_list();
        recycleAdapter = new BaseRecycleAdapter<>(R.layout.item_wait_container, goodsListBeans);
        recycleAdapter.setOnDataToViewListener((helper, item, position) -> {
            WaitContainerBean.DataBean.GoodsListBean listBean = (WaitContainerBean.DataBean.GoodsListBean) item;
            listBean.setNumPos(position + 1);
            helper.setText(R.id.tv_num, listBean.getNumPos() + "");
            helper.setText(R.id.tv_orderNo, listBean.getOrder_no());
            helper.setText(R.id.tv_tex_show_name, listBean.getTex_show_name());
            helper.setText(R.id.tv_bale, listBean.getBale() + " Bales");
            helper.setText(R.id.tv_meters_per_bale, listBean.getMeters_per_bale() + " " + listBean.getUnit_name());
            helper.setText(R.id.tv_volume_total, listBean.getVolume_total() + " (" + listBean.getVolume_unit() + " /m³)");
            helper.setText(R.id.tv_weight_total, listBean.getWeight_total() + " (" + listBean.getWeight_unit() + " /kg)");
            helper.setText(R.id.tv_delivery_no, listBean.getDelivery_no());
            helper.setText(R.id.tv_number_total, "出货米数: " + listBean.getNumber_total());
            EditText etNote = helper.getView(R.id.et_note);
            etNote.setText(listBean.getNotes());
            etNote.setSelection(etNote.length());
        });
        mRecycle.setAdapter(recycleAdapter);
        recycleAdapter.setOnItemClickListener((adapter, view, position) -> {
            WaitContainerBean.DataBean.GoodsListBean goodsListBean = recycleAdapter.getData().get(position);
            new AlertDialog.Builder(this)
                    .setTitle("确认")
                    .setMessage(goodsListBean.getOrder_no() + " 确认删除?")
                    .setNegativeButton("取消", null)
                    .setPositiveButton("确认", (dialog, which) -> {
                        recycleAdapter.getData().remove(position);
                        recycleAdapter.notifyDataSetChanged();
                        Toast.makeText(this, "删除Success", Toast.LENGTH_SHORT).show();
                    })
                    .create().show();
        });
        totalShowData();
        touchData();
    }

    @SuppressLint("SetTextI18n")
    private void totalShowData() {
        if (recycleAdapter != null) {
            List<WaitContainerBean.DataBean.GoodsListBean> goodsListBeans = recycleAdapter.getData();
            for (WaitContainerBean.DataBean.GoodsListBean goodsListBean : goodsListBeans) {
                zBale += Double.parseDouble(goodsListBean.getBale() + "");
                zVolume += Double.parseDouble(goodsListBean.getVolume_total());
                zWeight += Double.parseDouble(goodsListBean.getWeight_total());
            }
            mTvBaleZ.setText(StringUtils.formatFloatNumber1(zBale) + " Bales");
            mTvVolumeZ.setText(StringUtils.formatFloatNumber3(zVolume) + " m³");
            mTvWeightZ.setText(StringUtils.formatFloatNumber3(zWeight) + " kg");
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private void touchData() {
        if (recycleAdapter != null) {
            MyItemTouchHelper myItemTouchHelper = new MyItemTouchHelper(recycleAdapter);
            ItemTouchHelper helper = new ItemTouchHelper(myItemTouchHelper);
            helper.attachToRecyclerView(mRecycle);
            myItemTouchHelper.setOnRefreshListener((int fromPosition, int toPosition) -> {
                List<WaitContainerBean.DataBean.GoodsListBean> goodsListBeans = recycleAdapter.getData();
                goodsListBeans.get(fromPosition).setNumPos(toPosition);
                goodsListBeans.get(toPosition).setNumPos(fromPosition);
                if (fromPosition < toPosition) {
                    for (int i = fromPosition; i < toPosition; i++) {
                        Collections.swap(goodsListBeans, i, i + 1);
                    }
                } else {
                    for (int i = fromPosition; i > toPosition; i--) {
                        Collections.swap(goodsListBeans, i, i - 1);
                    }
                }
                recycleAdapter.notifyDataSetChanged();
            });
        }
    }
}