//package com.project.capstone.virtualmobileapp.adapter;
//
//import android.app.Activity;
//import android.content.Context;
//import android.content.SharedPreferences;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.*;
//
//import com.project.capstone.virtualmobileapp.R;
//import com.project.capstone.virtualmobileapp.constants.AppStatus;
//import com.project.capstone.virtualmobileapp.model.*;
//import com.project.capstone.virtualmobileapp.remote.RmaAPIService;
//import com.project.capstone.virtualmobileapp.utils.RmaAPIUtils;
//import com.squareup.picasso.Picasso;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//import static android.content.Context.MODE_PRIVATE;
//import static com.facebook.FacebookSdk.getApplicationContext;
//
//public class TransactionNotificationAdapter extends BaseAdapter {
//    Context context;
//    //    ArrayList<Transaction> transactions;
//    ArrayList<Object> notifications;
//    int idMe, yourUserId;
//    String authorization;
//    SharedPreferences sharedPreferences;
//    RmaAPIService rmaAPIService;
//
//
//    public TransactionNotificationAdapter(Context context, ArrayList<Object> notifications) {
//        this.context = context;
//        this.notifications = notifications;
//    }
//
//    @Override
//    public int getCount() {
//        return notifications.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return notifications.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    public class ViewHolder {
//        public TextView txtNotification, txtDateNoti;
//        public ImageView imgSender;
//    }
//
//    @Override
//    public int getItemViewType(int position) {
//        if (notifications.get(position).getClass() == Relationship.class) {
//            return 0;
//        } else if (notifications.get(position).getClass() == Transaction.class) {
//            return 1;
//        } else {
//            return 2;
//        }
//    }
//
//    @Override
//    public int getViewTypeCount() {
//        return 3;
//    }
//
//    @Override
//    public View getView(final int position, View convertView, ViewGroup parent) {
//        rmaAPIService = RmaAPIUtils.getAPIService();
//        sharedPreferences = ((Activity) context).getSharedPreferences("localData", MODE_PRIVATE);
//        idMe = sharedPreferences.getInt("userId", 0);
//        authorization = sharedPreferences.getString("authorization", null);
//
//        View view = convertView;
//        int type = getItemViewType(position);
//        if (view == null) {
//            // Inflate the layout according to the view type
//            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            if (type == 0) {
//                // Inflate the layout with image
//                view = inflater.inflate(R.layout.notification_friend_request_item, parent, false);
//            } else if (type == 1) {
//                view = inflater.inflate(R.layout.transaction_notification, parent, false);
//            } else if (type == 2) {
//                view = inflater.inflate(R.layout.transaction_notification, parent, false);
//            }
//        }
//        //
//        Object c = notifications.get(position);
//
//        if (c.getClass() == Transaction.class) {
//            Transaction transaction = (Transaction) c;
//            ImageView imgSender = (ImageView) view.findViewById(R.id.imgSender);
//            TextView txtNotification = (TextView) view.findViewById(R.id.txtNotification);
//            TextView txtDateNoti = (TextView) view.findViewById(R.id.txtDateNoti);
//
//            String notification = "";
//            if (transaction.getSenderId() == idMe && transaction.getStatus().equals(AppStatus.TRANSACTION_DONE)) {
//                notification = transaction.getReceiver().getFullName() + "đã đồng ý yêu cầu của bạn";
//            } else if (transaction.getReceiverId() == idMe && transaction.getStatus().equals(AppStatus.TRANSACTION_SEND)) {
//                notification = transaction.getSender().getFullName() + " vừa gửi yêu cầu";
//            } else if (transaction.getStatus().equals(AppStatus.TRANSACTION_RESEND)) {
//                if (transaction.getReceiverId() == idMe) {
//                    notification = transaction.getSender().getFullName() + " vừa cập nhật yêu cầu";
//                } else {
//                    notification = transaction.getReceiver().getFullName() + " vừa cập nhật yêu cầu";
//                }
//            } else if (transaction.getDonationPostId() != null && transaction.getStatus().equals(String.valueOf(AppStatus.DONATION_UPDATE_ACTION))) {
//                notification = transaction.getSender().getFullName() + " vừa gửi từ thiện";
//            }
//
//            txtNotification.setText(notification);
//            Date date = new Date();
//            date.setTime(transaction.getCreateTime().getTime());
//            String formattedDate = new SimpleDateFormat("HH:mm dd/MM/yyyy").format(date);
//            txtDateNoti.setText(formattedDate);
//            Picasso.with(context).load(transaction.getSender().getAvatar())
//                    .placeholder(R.drawable.ic_no_image)
//                    .error(R.drawable.ic_no_image)
//                    .into(imgSender);
//
//        } else if (c.getClass() == Relationship.class) {
//            final Relationship relationship = (Relationship) c;
//            ImageView imgProfileUser = (ImageView) view.findViewById(R.id.imgProfileUser);
//            TextView txtNameUser = (TextView) view.findViewById(R.id.txtNameUser);
//            TextView txtAddressUser = (TextView) view.findViewById(R.id.txtAddressUser);
//            Button btnAcceptFriend = (Button) view.findViewById(R.id.btnAcceptFriend);
//            Button btnDeclineFriend = (Button) view.findViewById(R.id.btnDeclineFriend);
//            btnAcceptFriend.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Map<String, String> bodyAccept = new HashMap<String, String>();
//                    bodyAccept.put("id", String.valueOf(relationship.getId()));
//                    rmaAPIService.acceptFriend(authorization, bodyAccept).enqueue(new Callback<ExffMessage>() {
//                        @Override
//                        public void onResponse(Call<ExffMessage> call, Response<ExffMessage> response) {
//                            if (response.isSuccessful()) {
//                                ExffMessage message = response.body();
//                                notifications.remove(position);
//                                notifyDataSetChanged();
//                                Toast.makeText(getApplicationContext(), message.getMessage(), Toast.LENGTH_LONG).show();
//                            }
//                        }
//
//                        @Override
//                        public void onFailure(Call<ExffMessage> call, Throwable t) {
//
//                        }
//                    });
//                }
//            });
//
//            btnDeclineFriend.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    rmaAPIService.cancelFriendRequest(authorization, relationship.getId()).enqueue(new Callback<ExffMessage>() {
//                        @Override
//                        public void onResponse(Call<ExffMessage> call, Response<ExffMessage> response) {
//                            if (response.isSuccessful()) {
//                                ExffMessage message = response.body();
//                                notifications.remove(position);
//                                notifyDataSetChanged();
//                                Toast.makeText(getApplicationContext(), message.getMessage(), Toast.LENGTH_LONG).show();
//                            }
//                        }
//
//                        @Override
//                        public void onFailure(Call<ExffMessage> call, Throwable t) {
//
//                            Toast.makeText(getApplicationContext(), R.string.error_server, Toast.LENGTH_LONG).show();
//                        }
//                    });
//
//                }
//            });
//
//            txtNameUser.setText(relationship.getSender().getFullName());
//            txtAddressUser.setText(relationship.getSender().getAddress());
//            Picasso.with(context).load(relationship.getSender().getAvatar())
//                    .placeholder(R.drawable.ic_no_image)
//                    .error(R.drawable.ic_no_image)
//                    .into(imgProfileUser);
//        } else if (c.getClass() == Room.class) {
//            final Room room = (Room) c;
//            String otherUserName = "";
//            final ImageView imgSender = (ImageView) view.findViewById(R.id.imgSender);
//            final TextView txtNotification = (TextView) view.findViewById(R.id.txtNotification);
//            TextView txtDateNoti = (TextView) view.findViewById(R.id.txtDateNoti);
//
//            List<UserRoom> listUser = room.getUsers();
//            for (int i = 0; i < listUser.size(); i++) {
//                if (listUser.get(i).getUserId() != idMe) {
//                    Picasso.with(context).load(listUser.get(i).getAvatar())
//                            .placeholder(R.drawable.ic_no_image)
//                            .error(R.drawable.ic_no_image)
//                            .into(imgSender);
//                    otherUserName = otherUserName + listUser.get(i).getFullName();
//
//                }
//            }
//            txtNotification.setText("Phòng Trao Đổi của bạn và " + otherUserName + " đang hoạt động");
//        }
//        return view;
//    }
//}
