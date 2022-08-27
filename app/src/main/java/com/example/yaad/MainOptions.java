package com.example.yaad;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainOptions extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<String> arr = new ArrayList<>();
    ArrayList<Integer> srcs = new ArrayList<>();
    private static final int VIEW_TYPE_HEADER=0;
    private static final int VIEW_TYPE_DEFAULT=1;
    OptionClickListener optionClickListener;

    MainOptions(ArrayList<String> arr, ArrayList<Integer> srcs,OptionClickListener opt ){
        this.srcs = srcs;
        this.arr = arr;
        this.optionClickListener = opt;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if(viewType == VIEW_TYPE_HEADER){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lyt_main_banner_header,parent,false);
            return new HeaderViewHolder(view);
        }else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_page_options,parent,false);
            return new OptionViewHolder(view);
        }


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        if(holder instanceof OptionViewHolder){
            ((OptionViewHolder) holder).textView.setText(arr.get(position-1));
            ((OptionViewHolder) holder).imageView.setImageResource(srcs.get(position-1));
            ((OptionViewHolder) holder).cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    optionClickListener.onOptionClick(position);
                }
            });
        }else{
            ((HeaderViewHolder)holder).txt_header_description.setText("Yaad is for yours");
        }

    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return VIEW_TYPE_HEADER;
        }else{
            return VIEW_TYPE_DEFAULT;
        }
    }

    @Override
    public int getItemCount() {
        return arr.size()+1;
    }

    protected class OptionViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;
        CardView cardView;
        public OptionViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txt_main_page_options);
            imageView = itemView.findViewById(R.id.img_main_options);
            cardView = itemView.findViewById(R.id.card_main_options);
        }
    }

    protected class HeaderViewHolder extends RecyclerView.ViewHolder{
        TextView txt_header_description;
        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txt_header_description = itemView.findViewById(R.id.txt_main_page_header_desc);
        }
    }

    public interface OptionClickListener{
        public void onOptionClick(int position);
    }
}
