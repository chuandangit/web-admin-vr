package com.project.capstone.virtualmobileapp.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import com.project.capstone.virtualmobileapp.R;
import com.project.capstone.virtualmobileapp.model.Item;
import com.project.capstone.virtualmobileapp.model.OrderItem;
import com.project.capstone.virtualmobileapp.remote.RmaAPIService;
import com.project.capstone.virtualmobileapp.utils.RmaAPIUtils;
import com.squareup.picasso.Picasso;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DescriptionItemActivity extends AppCompatActivity {
    Button btnBuy;
    android.support.v7.widget.Toolbar toolbarDescriptionItem;
    ImageView imgDescriptionItem, imgAvatar;
    TextView txtDateDescriptionItem, txtNameUserDescriotionItem, txtViewDescriptionItem;
    Button btnTrade;
    ImageButton btnShare;
    Spinner spinnerDescriptionProduct;

    //share facebook
    CallbackManager callbackManager;
    ShareDialog shareDialog;

    SharedPreferences sharedPreferences;
    RmaAPIService rmaAPIService;
    String authorization;

    Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this.getApplicationContext());
        setContentView(R.layout.activity_description_item);
        direct();
        actionToolbar();
        CatchEventSpinner();
        EventButton();
        Intent appLinkIntent = getIntent();
        Uri appLinkData = appLinkIntent.getData();

        if (appLinkData == null) { //check if app was opened from link or not
            GetInformation(-1);
        } else {
            int uriItemId = Integer.parseInt(appLinkData.toString().replace("https://exff-104b8.firebaseapp.com/item.html?id=", ""));
            GetInformation(uriItemId);
        }
        spinnerDescriptionProduct.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void GetInformation(int uriItemId) {
        if (uriItemId == -1) {
            item = (Item) getIntent().getSerializableExtra("descriptionItem");
            setItemInf(item);
        } else {
            sharedPreferences = getSharedPreferences("localData", MODE_PRIVATE);
            authorization = sharedPreferences.getString("authorization", null);
            if (authorization != null) {
                txtDateDescriptionItem.setText("");
                rmaAPIService.getItemById(authorization, uriItemId).enqueue(new Callback<Item>() {
                    @Override
                    public void onResponse(Call<Item> call, Response<Item> response) {
                        if (response.isSuccessful()) {
                            if (response.body() != null) {
                                item = response.body();
                                setItemInf(item);
                            } else {
                                Log.i("Item", "null");
                                Toast.makeText(getApplicationContext(), "exe", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Log.i("Item", "cannot load item");
                        }
                    }

                    @Override
                    public void onFailure(Call<Item> call, Throwable t) {
                        Log.i("Item", "failed");
                    }
                });
            }
        }
    }

    private void setItemInf(Item item) {
        toolbarDescriptionItem.setTitle(item.getName());
        txtNameUserDescriotionItem.setText(item.getUser().getFullName());
        txtDateDescriptionItem.setText(convertDatetime(item.getCreateTime()));
        txtViewDescriptionItem.setText(item.getDescription());
        String url = "";
        if (item.getImage().size() > 0) {
            url = item.getImage().get(0).getUrl();
            Picasso.with(getApplicationContext()).load(url)
                    .placeholder(R.drawable.ic_no_image)
                    .error(R.drawable.ic_no_image)
                    .into(imgDescriptionItem);
        } else {
            imgDescriptionItem.setImageResource(R.drawable.ic_no_image);
        }
        if (item.getUser() != null && item.getUser().getAvatar() != null) {
            url = item.getUser().getAvatar();
            Picasso.with(getApplicationContext()).load(url)
                    .placeholder(R.drawable.ic_no_image)
                    .error(R.drawable.ic_no_image)
                    .into(imgAvatar);
        } else {
            imgDescriptionItem.setImageResource(R.drawable.ic_no_image);
        }
    }

    private void actionToolbar() {
        setSupportActionBar(toolbarDescriptionItem);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarDescriptionItem.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void direct() {
        spinnerDescriptionProduct = findViewById(R.id.spinnerDescriptionProduct);
        toolbarDescriptionItem = findViewById(R.id.toolbarDescriptionItem);
        imgDescriptionItem = findViewById(R.id.imgDescriptionItem);
        imgAvatar = findViewById(R.id.imgUserAvatar);
        txtDateDescriptionItem = findViewById(R.id.txtDateDescriptionItem);
        txtNameUserDescriotionItem = findViewById(R.id.txtNameUserDescriotionItem);
        txtViewDescriptionItem = findViewById(R.id.txtViewDescriptionItem);
        btnBuy = findViewById(R.id.btnBuy);
        btnShare = findViewById(R.id.btnShare);

        callbackManager = CallbackManager.Factory.create();
        shareDialog = new ShareDialog(this);

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareLinkContent shareLinkContent = new ShareLinkContent.Builder()
                        .setQuote("Test").setContentUrl(Uri.parse("https://exff-104b8.firebaseapp.com/item.html?id=" + item.getId())).build();
                if (ShareDialog.canShow(ShareLinkContent.class)) {
                    shareDialog.show(shareLinkContent);
                }
            }
        });

        rmaAPIService = RmaAPIUtils.getAPIService();
    }

    private String convertDatetime(Timestamp timestamp) {
        String date = "";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm dd/MM/yyyy");
        try {
            date = simpleDateFormat.format(timestamp);
        } catch (Exception e) {
        }
        return date;
    }

    private void EventButton() {

        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.orderArrayList.size() > 0) {
                    int s1 = Integer.parseInt(spinnerDescriptionProduct.getSelectedItem().toString());
                    boolean exist = false;
                    for (int i = 0; i < MainActivity.orderArrayList.size(); i++) {
                        if (MainActivity.orderArrayList.get(i).getItem().getId() == item.getId()) {
                            MainActivity.orderArrayList.get(i).setNumber(MainActivity.orderArrayList.get(i).getNumber() + s1);
                            if (MainActivity.orderArrayList.get(i).getNumber() >= 10) {
                                MainActivity.orderArrayList.get(i).setNumber(10);
                            }
//                            MainActivity.orderArrayList.get(i).setPrice(price * MainActivity.orderArrayList.get(i).getNumber());
                            exist = true;
                        }
                    }
                    if (exist == false) {
                        int number = Integer.parseInt(spinnerDescriptionProduct.getSelectedItem().toString());
//                        long priceOrder = number * price;
                        MainActivity.orderArrayList.add(new OrderItem(item.getId(), item, number));
                    }

                } else {
                    int number = Integer.parseInt(spinnerDescriptionProduct.getSelectedItem().toString());
//                    long priceOrder = number * price;
                    MainActivity.orderArrayList.add(new OrderItem(item.getId(), item, number));
                }
                Intent intent = new Intent(getApplicationContext(), OrderActivity.class);
                startActivity(intent);
            }
        });
    }

    private void CatchEventSpinner() {
        Integer[] number = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item, number);
        spinnerDescriptionProduct.setAdapter(arrayAdapter);
    }
}
