package com.akina.clinicalstudies;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static android.view.View.GONE;
import static java.text.DateFormat.getDateInstance;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder>  {
    private List<ActivityItem> m_data;
    private LayoutInflater m_inflater;
    private ItemClickListener m_click_listener;

    RVAdapter(Context context, List<ActivityItem> list) {
        this.m_inflater = LayoutInflater.from(context);
        this.m_data = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = m_inflater.inflate(R.layout.activity_elem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ActivityItem elem = m_data.get(position);
        holder.myTitle.setText(elem.m_title);
        DateFormat dateFormat = new SimpleDateFormat("d MMM YYYY", Locale.ENGLISH);

        switch(elem.m_status)
        {
            case PENDING:
                holder.myStartDate.setText("Pending on " + dateFormat.format(elem.m_startTime.getTimeInMillis()));
                holder.myObj.setBackgroundColor(Color.parseColor("#ffb62d"));
                break;
            case ACCEPTED:
                holder.myStartDate.setText("Accepted on " + dateFormat.format(elem.m_startTime.getTimeInMillis()));
                holder.myObj.setBackgroundColor(Color.parseColor("#29eadc"));
                break;
            case COMPLETE:
                holder.myStartDate.setText("Complete on " + dateFormat.format(elem.m_startTime.getTimeInMillis()));
                holder.myObj.setBackgroundColor(Color.parseColor("#f3465a"));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return m_data.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView myTitle;
        TextView myStartDate;
        RelativeLayout myObj;

        ViewHolder(View itemView) {
            super(itemView);
            myTitle = itemView.findViewById(R.id.title_txt);
            myStartDate = itemView.findViewById(R.id.date_txt);
            myObj = itemView.findViewById(R.id.obj);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (m_click_listener != null) m_click_listener.onItemClick(v, getAdapterPosition());
        }
    }


    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.m_click_listener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {

        void onItemClick(View view, int position);
    }

}
