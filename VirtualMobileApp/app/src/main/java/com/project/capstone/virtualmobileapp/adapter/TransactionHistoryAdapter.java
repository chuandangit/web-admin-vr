package com.project.capstone.virtualmobileapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.project.capstone.virtualmobileapp.R;
import com.project.capstone.virtualmobileapp.activity.TransactionDetailActivity;
import com.project.capstone.virtualmobileapp.constants.AppStatus;
import com.project.capstone.virtualmobileapp.model.Transaction;
import com.project.capstone.virtualmobileapp.remote.RmaAPIService;
import com.project.capstone.virtualmobileapp.utils.RmaAPIUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static android.content.Context.MODE_PRIVATE;

public class TransactionHistoryAdapter extends BaseAdapter {
    Context context;
    ArrayList<Transaction> transactions;


    public TransactionHistoryAdapter(Context context, ArrayList<Transaction> transactions) {
        this.context = context;
        this.transactions = transactions;
    }

    public class ViewHolder {
        public TextView txtSender, txtStatusTrans, txtDateTrans, txtType, txtDonationName;
    }

    @Override
    public int getCount() {
        return transactions.size();
    }

    @Override
    public Object getItem(int position) {
        return transactions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final RmaAPIService rmaAPIService = RmaAPIUtils.getAPIService();

        SharedPreferences sharedPreferences = ((Activity) context).getSharedPreferences("localData", MODE_PRIVATE);
        final String authorization = sharedPreferences.getString("authorization", null);
        final int idMe = sharedPreferences.getInt("userId", 0);
        TransactionHistoryAdapter.ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new TransactionHistoryAdapter.ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.transaction_item, null);
            viewHolder.txtSender = convertView.findViewById(R.id.txtSender);
            viewHolder.txtDateTrans = convertView.findViewById(R.id.txtDateTrans);
            viewHolder.txtStatusTrans = convertView.findViewById(R.id.txtStatusTrans);
//            viewHolder.txtType = convertView.findViewById(R.id.txtType);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (TransactionHistoryAdapter.ViewHolder) convertView.getTag();
        }

        final Transaction transaction = (Transaction) getItem(position);
        String status = "";
        if (transaction.getStatus().equals(AppStatus.TRANSACTION_DONE)) {
            status = status + context.getString(R.string.trans_finish);
        } else {
            status = status + context.getString(R.string.waiting_transaction);
        }
        viewHolder.txtStatusTrans.setText(status);

        if (transaction.getSender().getId() == idMe) {
            viewHolder.txtSender.setText(transaction.getReceiver().getFullName());
        } else {
            viewHolder.txtSender.setText(transaction.getSender().getFullName());
        }

        Date date = new Date();
        date.setTime(transaction.getCreateTime().getTime());
        String formattedDate = new SimpleDateFormat("HH:mm dd.MM.yyyy").format(date);
        viewHolder.txtDateTrans.setText(formattedDate);


        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TransactionDetailActivity.class);
                intent.putExtra("transactionId", transaction.getId());
                context.startActivity(intent);
            }
        });
        return convertView;
    }


}