package com.example.medicare;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

public class AdapterOnboarding extends SliderViewAdapter<AdapterOnboarding.MyViewHolder> {

    List<Integer> imageList;

    AdapterOnboarding(List<Integer> list){
        this.imageList = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int position) {
        viewHolder.imageView.setImageResource(imageList.get(position));
        viewHolder.imageView.getLayoutParams().height = 1100;
        viewHolder.imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    class MyViewHolder extends SliderViewAdapter.ViewHolder{

        ImageView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
