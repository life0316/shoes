package com.haoxi.shoes.widget.materialcalendarview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.haoxi.shoes.R;
import com.haoxi.shoes.widget.materialcalendarview.format.DateFormatTitleFormatter;
import com.haoxi.shoes.widget.materialcalendarview.format.TitleFormatter;

import java.util.ArrayList;
import java.util.List;


public class DownAdapter extends RecyclerView.Adapter<DownAdapter.DownViewHolder> {

    private Context mContext;
    List<CalendarDay> calendarDayList = new ArrayList();
    private TitleFormatter titleFormatter = new DateFormatTitleFormatter();
    private OnDownItemClickListener itemClickListener;

    public void setItemClickListener(OnDownItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public DownAdapter(Context context, List<CalendarDay> calendarDayList) {
        this.calendarDayList = calendarDayList;
        this.mContext = context;
    }

    //adapter.setTitleFormatter(DEFAULT_TITLE_FORMATTER);
    public void setTitleFormatter(@NonNull TitleFormatter titleFormatter){
        this.titleFormatter = titleFormatter;
    }

    public List<CalendarDay> getCalendarDayList() {
        return calendarDayList;
    }

    @Override
    public DownViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.down_item,null);
        DownViewHolder viewHolder = new DownViewHolder(view,itemClickListener);

        return viewHolder;
    }

    private int cup = -2;

    @Override
    public void onBindViewHolder(DownViewHolder downViewHolder, final int position) {

        final CalendarDay calendarDay = calendarDayList.get(position);
        CharSequence newTitle = titleFormatter.format(calendarDay);
        downViewHolder.itemTv.setText(newTitle);

        if (cup == position){
            downViewHolder.itemTv.setTextColor(mContext.getResources().getColor(R.color.colorRed));
        }else {
            downViewHolder.itemTv.setTextColor(mContext.getResources().getColor(android.R.color.black));
        }
    }

    public void changeItem(int position){
        this.cup = position;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return calendarDayList == null?0:calendarDayList.size();
    }

    class DownViewHolder extends RecyclerView.ViewHolder{

        private OnDownItemClickListener itemClickListener;
        TextView itemTv;
        public DownViewHolder(View itemView,final OnDownItemClickListener itemClickListener) {
            super(itemView);
            itemTv = itemView.findViewById(R.id.itemTv);
            this.itemClickListener = itemClickListener;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (itemClickListener != null) {
                        itemClickListener.itemClick(getPosition());
                    }
                }
            });
        }
    }

    interface OnDownItemClickListener{
        void itemClick(int position);
    }

}
