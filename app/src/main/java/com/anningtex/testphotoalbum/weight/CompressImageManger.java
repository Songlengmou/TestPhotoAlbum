package com.anningtex.testphotoalbum.weight;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.util.LruCache;
import android.view.View;
import android.webkit.WebView;

import androidx.recyclerview.widget.RecyclerView;

import com.anningtex.testphotoalbum.R;
import com.bumptech.glide.request.RequestOptions;
import com.nostra13.universalimageloader.core.DisplayImageOptions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @author Song
 */
public class CompressImageManger {
    public static RequestOptions options = new RequestOptions()
            //图片加载出来前，显示的图片
            .placeholder(R.mipmap.ic_launcher)
            //url为空的时候,显示的图片
            .fallback(R.mipmap.ic_launcher)
            //图片加载失败后，显示的图片
            .error(R.mipmap.ic_launcher);

    @SuppressLint("CheckResult")
    public static RequestOptions getRequestOptions() {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher);
        return requestOptions;
    }

    public static DisplayImageOptions NORMAL_OPTION = new DisplayImageOptions.Builder()
            // 设置图片Uri为空或是错误的时候显示的图片
            .showImageForEmptyUri(R.mipmap.ic_launcher)
            // 设置图片加载或解码过程中发生错误显示的图片
            .showImageOnFail(R.mipmap.ic_launcher)
            // 设置图片下载期间显示的图片
            .showImageOnLoading(R.mipmap.ic_launcher)
            // default 设置图片在加载前是否重置、复位
            .resetViewBeforeLoading(false)
            // default  设置下载的图片是否缓存在SD卡中
            .cacheOnDisk(true)
            // default  设置下载的图片是否缓存在内存中
            .cacheInMemory(true)
            .build();

    public static BitmapFactory.Options getBitmapOption(int inSampleSize) {
        System.gc();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPurgeable = true;
        options.inSampleSize = inSampleSize;
        return options;
    }

    public static Bitmap compressImage(Bitmap image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        int options = 90;
        while (baos.toByteArray().length / 1024 > 300) {
            baos.reset();
            image.compress(Bitmap.CompressFormat.JPEG, options, baos);
            options -= 10;
        }
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());
        return BitmapFactory.decodeStream(isBm, null, null);
    }

    public static Bitmap getViewBitmap(WebView webView) {
        int height = (int) (webView.getContentHeight() * webView.getScale());
        int width = webView.getWidth();
        int pH = webView.getHeight();
        Bitmap bm = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bm);
        int top = height;
        while (top > 0) {
            if (top < pH) {
                top = 0;
            } else {
                top -= pH;
            }
            canvas.save();
            canvas.clipRect(0, top, width, top + pH);
            webView.scrollTo(0, top);
            webView.draw(canvas);
            canvas.restore();
        }
        return bm;
    }

    public static Bitmap shotRecyclerView(RecyclerView view) {
        RecyclerView.Adapter adapter = view.getAdapter();
        Bitmap bigBitmap = null;
        if (adapter != null) {
            int size = adapter.getItemCount();
            int height = 0;
            Paint paint = new Paint();
            int iHeight = 0;
            final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
            // Use 1/8th of the available memory for this memory cache.
            final int cacheSize = maxMemory / 8;
            LruCache<String, Bitmap> bitmaCache = new LruCache<>(cacheSize);
            for (int i = 0; i < size; i++) {
                RecyclerView.ViewHolder holder = adapter.createViewHolder(view, adapter.getItemViewType(i));
                adapter.onBindViewHolder(holder, i);
                holder.itemView.measure(
                        View.MeasureSpec.makeMeasureSpec(view.getWidth(), View.MeasureSpec.EXACTLY),
                        View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
                holder.itemView.layout(0, 0, holder.itemView.getMeasuredWidth(),
                        holder.itemView.getMeasuredHeight());
                holder.itemView.setDrawingCacheEnabled(true);
                holder.itemView.buildDrawingCache();
                Bitmap drawingCache = holder.itemView.getDrawingCache();
                if (drawingCache != null) {
                    bitmaCache.put(String.valueOf(i), drawingCache);
                }
                height += holder.itemView.getMeasuredHeight();
            }

            bigBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), height, Bitmap.Config.ARGB_8888);
            Canvas bigCanvas = new Canvas(bigBitmap);
            Drawable lBackground = view.getBackground();
            if (lBackground instanceof ColorDrawable) {
                ColorDrawable lColorDrawable = (ColorDrawable) lBackground;
                int lColor = lColorDrawable.getColor();
                bigCanvas.drawColor(lColor);
            }

            for (int i = 0; i < size; i++) {
                Bitmap bitmap = bitmaCache.get(String.valueOf(i));
                bigCanvas.drawBitmap(bitmap, 0f, iHeight, paint);
                iHeight += bitmap.getHeight();
                bitmap.recycle();
            }
        }
        return bigBitmap;
    }

    /**
     * 按比例大小压缩 （路径获取图片）
     */
    public static Bitmap getImage(String srcPath, float ph, float pw) {
        BitmapFactory.Options newOpts = new BitmapFactory.Options();
        // 开始读入图片，此时把options.inJustDecodeBounds 设回true了
        newOpts.inJustDecodeBounds = true;
        // 此时返回bm为空
        Bitmap bitmap;
        newOpts.inJustDecodeBounds = false;
        int w = newOpts.outWidth;
        int h = newOpts.outHeight;
        // 现在主流手机比较多是800*480分辨率
        float hh = ph;
        float ww = pw;
        // 缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
        // be=1表示不缩放
        int be = 1;
        if (w > h && w > ww) {
            // 如果宽度大的话根据宽度固定大小缩放
            be = (int) (newOpts.outWidth / ww);
        } else if (w < h && h > hh) {
            // 如果高度高的话根据宽度固定大小缩放
            be = (int) (newOpts.outHeight / hh);
        }
        if (be <= 0) {
            be = 1;
        }
        // 设置缩放比例
        newOpts.inSampleSize = be;
        // 重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了
        bitmap = BitmapFactory.decodeFile(srcPath, newOpts);
        // 压缩好比例大小后再进行质量压缩
        return compressImage(bitmap);
    }

    /**
     * 图片转成string
     *
     * @param bitmap
     * @return
     */
    public static String convertIconToString(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        // 转为byte数组
        byte[] appIcon = baos.toByteArray();
        return Base64.encodeToString(appIcon, Base64.DEFAULT);
    }
}