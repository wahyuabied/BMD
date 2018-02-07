package com.mrabid.bumidesa.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.mrabid.bumidesa.R;

/**
 * Created by Mr Abid on 1/20/2018.
 */

public class SliderDetailProductAdapter extends PagerAdapter {
    private final String[] image_resource;
    private Context ctx;
    private LayoutInflater layoutInflater;
    private int [] imageDummy = {R.drawable.img_flower,R.drawable.img_flower,R.drawable.img_flower};

    public SliderDetailProductAdapter(Context ctx,String[] image_resource){
        this.ctx=ctx;
        this.image_resource= image_resource;
    }

    @Override
    public int getCount() {
        return image_resource.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.slider_detail_product,container,false);

        ImageView imageView = (ImageView) item_view.findViewById(R.id.imgv_detail_product_activity_slider);
        imageView.setImageResource((imageDummy[position]));
        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
