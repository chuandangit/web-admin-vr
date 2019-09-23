package com.project.capstone.exchangesystem.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.project.capstone.exchangesystem.R;
import com.squareup.picasso.Picasso;
import com.project.capstone.exchangesystem.model.Item;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> {

    Context context;
    ArrayList<Item> itemArrayList;
    private final OnItemClickListener listener;

    public ItemAdapter(Context context, ArrayList<Item> itemArrayList, OnItemClickListener listener) {
        this.context = context;
        this.itemArrayList = itemArrayList;
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(Item item);
    }

    public void setfilter(ArrayList<Item> tempArray) {
        //wordlist = new ArrayList<>();
        itemArrayList.clear();
        if(tempArray != null) {
            itemArrayList.addAll(tempArray);
        }
        notifyDataSetChanged();
    }

    public ArrayList<Item> getfilter() {
        return itemArrayList;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.brandnewproduct, parent, false);
        ItemHolder itemHolder = new ItemHolder(v);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        Item item = itemArrayList.get(position);
        holder.bind(item, listener);
//        holder.txtNameItem.setText(item.getName());
////        holder.txtNameProduct.setText(item.getName());
////        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
////        holder.txtPriceProduct.setText("Price: " + decimalFormat.format(item.getPrice()) + "VND");
//        Picasso.with(context).load("https://cdn.tgdd.vn/Products/Images/42/192001/samsung-galaxy-j6-plus-1-400x460.png")
//                .placeholder(R.drawable.no)
//                .error(R.drawable.loadingimage)
//                .into(holder.imgItem);

//        Glide.with().load("https://cdn.tgdd.vn/Products/Images/42/192001/samsung-galaxy-j6-plus-1-400x460.png")
//                .thumbnail(0.5f)
//                .placeholder(R.drawable.loadingimage)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(holder.imgItem);

    }


    @Override
    public int getItemCount() {
        return itemArrayList.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        public ImageView imgItem;
        public TextView txtNameItem, txtDateItem;


        public ItemHolder(View itemView) {
            super(itemView);
            imgItem = itemView.findViewById(R.id.imgItem);
            txtNameItem = itemView.findViewById(R.id.txtNameItem);
            txtDateItem = itemView.findViewById(R.id.txtDateItem);
        }


        public void bind(final Item item, final OnItemClickListener listener) {
            Date date = new Date();
            date.setTime(item.getCreateTime().getTime());
            String formattedDate = new SimpleDateFormat("dd.MM.yyyy").format(date);
            txtDateItem.setText(formattedDate);
            txtNameItem.setText(item.getName());
            String url = "";
            if (item.getImage().size() > 0) {
                url = item.getImage().get(0).getUrl();
                Picasso.with(context).load(url)
                        .placeholder(R.drawable.ic_no_image)
                        .error(R.drawable.ic_no_image)
                        .into(imgItem);
            } else {
                imgItem.setImageResource(R.drawable.ic_no_image);
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }

    }
}
