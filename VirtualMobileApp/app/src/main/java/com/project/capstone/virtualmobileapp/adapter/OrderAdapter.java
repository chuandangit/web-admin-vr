package com.project.capstone.virtualmobileapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.project.capstone.virtualmobileapp.R;
import com.project.capstone.virtualmobileapp.activity.MainActivity;
import com.project.capstone.virtualmobileapp.activity.OrderActivity;
import com.project.capstone.virtualmobileapp.model.OrderItem;
import com.squareup.picasso.Picasso;


import java.text.DecimalFormat;
import java.util.ArrayList;

public class OrderAdapter extends BaseAdapter {
    Context context;
    ArrayList<OrderItem> orderArrayList;
//     ViewHolder viewHolder = null;

    public OrderAdapter(Context context, ArrayList<OrderItem> orderArrayList) {
        this.context = context;
        this.orderArrayList = orderArrayList;
    }

    @Override
    public int getCount() {
        return orderArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return orderArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder {
        public TextView txtNameOrder, txtPrice;
        public ImageView imgOrder;
        public Button btnminus, btnvalues, btnplus;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.order, null);
            viewHolder.txtNameOrder = (TextView) convertView.findViewById(R.id.txtNameOrder);
            viewHolder.txtPrice = (TextView) convertView.findViewById(R.id.txtPriceOrder);
            viewHolder.imgOrder = (ImageView) convertView.findViewById(R.id.imgOrder);
            viewHolder.btnminus = (Button) convertView.findViewById(R.id.btnminus);
            viewHolder.btnvalues = (Button) convertView.findViewById(R.id.btnvalues);
            viewHolder.btnplus = (Button) convertView.findViewById(R.id.btnplus);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        OrderItem order = (OrderItem) getItem(position);
        viewHolder.txtNameOrder.setText(order.getItem().getName());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtPrice.setText("Price");
        Picasso.with(context).load("https://images.pexels.com/photos/414612/pexels-photo-414612.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500")
                .placeholder(R.drawable.no)
                .error(R.drawable.loadingimage)
                .into(viewHolder.imgOrder);
        System.out.println("test số lượng trong order "+ order.getNumber());
        viewHolder.btnvalues.setText(order.getNumber() + "");
        int number = Integer.parseInt(viewHolder.btnvalues.getText().toString());
        if (number >= 10) {
            viewHolder.btnplus.setVisibility(View.INVISIBLE);
            viewHolder.btnminus.setVisibility(View.VISIBLE);
        } else if (number <= 1) {
            viewHolder.btnminus.setVisibility(View.INVISIBLE);
            viewHolder.btnplus.setVisibility(View.VISIBLE);
        } else if (number > 1) {
            viewHolder.btnminus.setVisibility(View.VISIBLE);
            viewHolder.btnplus.setVisibility(View.VISIBLE);
        }

        final ViewHolder finalViewHolder1 = viewHolder;
        viewHolder.btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int brandNewNumber = Integer.parseInt(finalViewHolder1.btnvalues.getText().toString()) + 1;
                int presentNumber = MainActivity.orderArrayList.get(position).getNumber();
                long presentPrice = 2000;
                MainActivity.orderArrayList.get(position).setNumber(brandNewNumber);
//                long brandNewPrice = (presentPrice * brandNewNumber) / presentNumber;
//                MainActivity.orderArrayList.get(position).setId(brandNewPrice);
                long brandNewPrice = 2000* brandNewNumber;

                DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
                finalViewHolder1.txtPrice.setText(decimalFormat.format(brandNewPrice) + " Đ");

                OrderActivity.EventUltil();
                if (brandNewNumber > 9) {
                    finalViewHolder1.btnplus.setVisibility(View.INVISIBLE);
                    finalViewHolder1.btnminus.setVisibility(View.VISIBLE);
                    finalViewHolder1.btnvalues.setText(String.valueOf(brandNewNumber));
                } else {
                    finalViewHolder1.btnplus.setVisibility(View.VISIBLE);
                    finalViewHolder1.btnminus.setVisibility(View.VISIBLE);
                    finalViewHolder1.btnvalues.setText(String.valueOf(brandNewNumber));
                }
            }
        });

        final ViewHolder finalViewHolder = viewHolder;
        viewHolder.btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int brandNewNumber = Integer.parseInt(finalViewHolder.btnvalues.getText().toString()) - 1;
//                int presentNumber = MainActivity.orderArrayList.get(position).getNumber();
                long presentPrice = 2000;
                MainActivity.orderArrayList.get(position).setNumber(brandNewNumber);
//                long brandNewPrice = (presentPrice * brandNewNumber) / presentNumber;
//                MainActivity.orderArrayList.get(position).setPrice(brandNewPrice);
                long brandNewPrice = 2000* brandNewNumber;

                DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
                finalViewHolder.txtPrice.setText(decimalFormat.format(brandNewPrice) + " Đ");


                OrderActivity.EventUltil();
                if (brandNewNumber < 2) {
                    finalViewHolder.btnminus.setVisibility(View.INVISIBLE);
                    finalViewHolder.btnplus.setVisibility(View.VISIBLE);
                    finalViewHolder.btnvalues.setText(String.valueOf(brandNewNumber));
                } else {
                    finalViewHolder.btnplus.setVisibility(View.VISIBLE);
                    finalViewHolder.btnminus.setVisibility(View.VISIBLE);
                    finalViewHolder.btnvalues.setText(String.valueOf(brandNewNumber));
                }
            }
        });


        return convertView;
    }
}
