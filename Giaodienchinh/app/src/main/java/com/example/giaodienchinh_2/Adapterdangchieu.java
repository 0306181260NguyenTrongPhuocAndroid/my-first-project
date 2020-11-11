package com.example.giaodienchinh_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public  class Adapterdangchieu extends RecyclerView.Adapter<Adapterdangchieu.SliderViewHolder> {
    private List<dangchieu_AT> dangchieu_ats;
    private ViewPager2 viewPager2;

    Adapterdangchieu(List<dangchieu_AT> dangchieu_ats, ViewPager2 viewPager2) {
        this.dangchieu_ats = dangchieu_ats;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.slide_dang_chieu, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        holder.setImage(dangchieu_ats.get(position));
        holder.setTitle(dangchieu_ats.get(position));
        holder.setDesc(dangchieu_ats.get(position));
    }

    @Override
    public int getItemCount() {
        return dangchieu_ats.size();
    }

    static class SliderViewHolder extends RecyclerView.ViewHolder {
        private RoundedImageView imageView;
         private TextView title,desc;

        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageSlide);
            title=itemView.findViewById(R.id.title);
            desc=itemView.findViewById(R.id.desc);

        }

        void setImage(dangchieu_AT dangchieu_at) {
            imageView.setImageResource(dangchieu_at.getImage());
        }
        void setTitle(dangchieu_AT dangchieu_at)
        {
            title.setText(dangchieu_at.getTitle());
        }

        void setDesc(dangchieu_AT dangchieu_at) {
            desc.setText(dangchieu_at.getDesc());
        }
    }
}
