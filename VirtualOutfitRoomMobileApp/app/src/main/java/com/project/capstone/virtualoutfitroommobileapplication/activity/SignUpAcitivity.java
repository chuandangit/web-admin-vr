package com.project.capstone.virtualoutfitroommobileapplication.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.project.capstone.virtualoutfitroommobileapplication.R;
import com.project.capstone.virtualoutfitroommobileapplication.model.User;
import com.project.capstone.virtualoutfitroommobileapplication.remote.RmaAPIService;
import com.project.capstone.virtualoutfitroommobileapplication.utils.RmaAPIUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.HashMap;
import java.util.Map;

import static com.project.capstone.virtualoutfitroommobileapplication.constants.AppStatus.USER_ENABLE;


public class SignUpAcitivity extends AppCompatActivity {
    EditText txtFullname, txtPhone, txtPassword, txtAddress, txtPasswordCheck;
    private Context context;
    TextView lbl_toolbar;
    RmaAPIService rmaAPIService, thirdPartyrmaAPIService;
    boolean flag = true;
    boolean flag2 = true;
    boolean flag3 = true;
    boolean flag4 = true;
    boolean flag5 = true;
    boolean flag6 = true;
    boolean flag7 = true;
    boolean flag8 = true;
    boolean flag9 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_acitivity);

//        lbl_toolbar = findViewById(R.id.lbl_toolbar);
//        lbl_toolbar.setText("Đăng Kí Tài Khoản");
//        lbl_toolbar.setTypeface(null, Typeface.BOLD);

        context = this;
        txtFullname = findViewById(R.id.txtName);
        txtPhone = findViewById(R.id.txtPhone);
        txtPassword = findViewById(R.id.txtPassword);
        txtAddress = findViewById(R.id.txtAddress);
        txtPasswordCheck = findViewById(R.id.txtPasswordCheck);

    }

    public void signUpUser(View view) {
        rmaAPIService = RmaAPIUtils.getAPIService();
//        thirdPartyrmaAPIService = RmaAPIUtils.getThirdPartyService();

        User user = new User();

        String fullname = txtFullname.getText().toString();
        String phone = txtPhone.getText().toString();
        String password = txtPassword.getText().toString();
        String passwordCheck = txtPasswordCheck.getText().toString();
        String address = txtAddress.getText().toString();

        rmaAPIService.checkValidationLogin(phone).enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                if (response.isSuccessful()) {

                    if (response.body().toString().equals("no")) {
                        txtPhone.setBackgroundResource(R.drawable.signupedt);
                    } else {
//                        onCheckPhoneValid();
                        txtPhone.setBackgroundResource(R.drawable.signuperror);
                        Toast.makeText(getApplicationContext(), "Số điện thoại đã được đăng kí", Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Toast.makeText(getApplicationContext(), R.string.error_server, Toast.LENGTH_SHORT).show();
                System.out.println(t.getMessage());
            }
        });

//        thirdPartyrmaAPIService.verifyPhoneNumber(phone, AppApi.CountryCode, AppApi.APIKey).enqueue(new Callback<Object>() {
//            @Override
//            public void onResponse(Call<Object> call, Response<Object> response) {
//
//                if (response.body() != null) {
//                    Map<String, String> body = (Map<String, String>) response.body();
//                    if (body.get("status").toString().equals("VALID_CONFIRMED")) {
////                        txtPhone.setBackgroundResource(R.drawable.signupedt);
//
//                    } else {
//                        onCheckPhoneExist();
//                        txtPhone.setBackgroundResource(R.drawable.signuperror);
//                        Toast.makeText(getApplicationContext(), "Số điện thoại không tồn tại", Toast.LENGTH_LONG).show();
//
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Object> call, Throwable t) {
//
//            }
//        });
//        System.out.println("test flag 2 " + flag2);

        if (fullname.length() < 1) {
            flag = false;
            txtFullname.setBackgroundResource(R.drawable.signuperror);
        } else {
            txtFullname.setBackgroundResource(R.drawable.signupedt);
        }


//        if (!android.util.Patterns.PHONE.matcher(phone).matches()) {
//            flag2 = false;
//            txtPhone.setBackgroundResource(R.drawable.signuperror);
//        } else {
//            txtPhone.setBackgroundResource(R.drawable.signupedt);
//        }

        if (password.length() < 8) {
            flag3 = false;
            txtPassword.setBackgroundResource(R.drawable.signuperror);
        } else {
            txtPassword.setBackgroundResource(R.drawable.signupedt);
        }

        if (address.length() < 1) {
            flag5 = false;
            txtAddress.setBackgroundResource(R.drawable.signuperror);
        } else {
            txtAddress.setBackgroundResource(R.drawable.signupedt);
        }

        if (passwordCheck.length() < 1) {
            flag6 = false;
            txtPasswordCheck.setBackgroundResource(R.drawable.signuperror);
        } else {
            txtPasswordCheck.setBackgroundResource(R.drawable.signupedt);
        }


        if (!passwordCheck.equals(password) && password.length() == 0) {
            flag7 = false;
            txtPasswordCheck.setBackgroundResource(R.drawable.signuperror);
            txtPassword.setBackgroundResource(R.drawable.signuperror);
        } else {
            txtPasswordCheck.setBackgroundResource(R.drawable.signupedt);
            txtPassword.setBackgroundResource(R.drawable.signupedt);
        }

        if (address.length() < 1) {
            flag8 = false;
            txtAddress.setBackgroundResource(R.drawable.signuperror);
        } else {
            txtAddress.setBackgroundResource(R.drawable.signupedt);
        }


        if (flag && flag2 && flag3 && flag4 && flag5 && flag6 && flag7 && flag9) {


            user.setFullName(fullname);
            user.setPhone(phone);
//            user.setPassword(password)

            final Map<String, String> jsonBody = new HashMap<String, String>();
            jsonBody.put("phoneNumber", phone);
            jsonBody.put("password", password);
            jsonBody.put("fullName", fullname);
            jsonBody.put("status", USER_ENABLE);
            jsonBody.put("address", address);


            rmaAPIService.register(jsonBody).enqueue(new Callback<Object>() {
                @Override
                public void onResponse(Call<Object> call, Response<Object> response) {
                    if (response.body() != null && response.isSuccessful()) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Đăng Kí Thành Công", Toast.LENGTH_SHORT);
                        toast.show();
                        Intent returnIntent = new Intent();
                        returnIntent.putExtra("signupUsername", txtPhone.getText().toString().trim());
                        setResult(Activity.RESULT_OK, returnIntent);
                        finish();
                    } else {
                        Toast toast = Toast.makeText(getApplicationContext(), R.string.signup_error, Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }

                @Override
                public void onFailure(Call<Object> call, Throwable t) {
                    Toast toast = Toast.makeText(getApplicationContext(), R.string.error_server, Toast.LENGTH_SHORT);
                    toast.show();
                }
            });
        }
    }

//    public void onBackButton(View view) {
//        finish();
//    }

    public void toSignUp(View view) {
        finish();
    }

//
//    @Override
//    public void onCheckPhoneValid() {
//        flag9 = false;
//    }
//
//    @Override
//    public void onCheckPhoneExist() {
//        flag2 = false;
//    }
}
