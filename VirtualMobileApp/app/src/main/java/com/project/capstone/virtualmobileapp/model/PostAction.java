//package com.project.capstone.virtualmobileapp.model;
//
//import android.app.Activity;
//import android.app.ProgressDialog;
//import android.content.Context;
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.util.Log;
//import android.widget.Toast;
//import com.google.gson.internal.LinkedTreeMap;
//
//import com.project.capstone.virtualmobileapp.remote.RmaAPIService;
//import com.project.capstone.virtualmobileapp.utils.RmaAPIUtils;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import static com.project.capstone.virtualmobileapp.constants.AppStatus.ITEM_CREATE_ACTION;
//import static com.project.capstone.virtualmobileapp.constants.AppStatus.ITEM_UPDATE_ACTION;
//
//
//public class PostAction {
//    RmaAPIService rmaAPIService = RmaAPIUtils.getAPIService();
//    ProgressDialog progressDialog;
//
//    public PostAction() {
//    }
//
//    public void manageItem(Item item, List<String> urlList, String authorization, final Context context, int action) {
//
//        setDialog(context);
//
//        String itemName = item.getName();
//        String itemDes = item.getDescription();
//        String itemAddress = item.getAddress();
//        String privacy = item.getPrivacy();
//        int category = item.getCategory().getId();
//        final Map<String, Object> jsonBody = new HashMap<String, Object>();
//
//        jsonBody.put("name", itemName);
//        jsonBody.put("description", itemDes);
//        jsonBody.put("address", itemAddress);
//        jsonBody.put("privacy", privacy);
//        jsonBody.put("category", "" + (category + 1));
////        jsonBody.put("urls", urlList);
//
//        if (authorization != null) {
//            if (action == ITEM_CREATE_ACTION) {
//                jsonBody.put("urls", urlList);
//                rmaAPIService.createItem(jsonBody, authorization).enqueue(new Callback<Item>() {
//
//                    @Override
//                    public void onResponse(Call<Item> call, Response<Item> response) {
//                        if (response.isSuccessful()) {
//                            if (response.body() != null) {
//                                Log.i("PostAction", "item added");
//                                progressDialog.dismiss();
////                                Intent intent = new Intent(context, OwnInventory.class);
////                                intent.putExtra("itemId", response.body().getId());
////                                context.startActivity(intent);
//
//                                Intent returnIntent = new Intent();
//                                ((Activity) context).setResult(Activity.RESULT_OK, returnIntent);
//                                ((Activity) context).finish();
//                            } else {
//                                progressDialog.dismiss();
//                                Toast.makeText(context, "Vui lòng thử lại sau.", Toast.LENGTH_LONG).show();
//                                Log.i("PostAction", "item create null");
//                            }
//                        } else {
//                            progressDialog.dismiss();
//                            Toast.makeText(context, "Vui lòng thử lại sau.", Toast.LENGTH_LONG).show();
//                            Log.i("PostAction", "item create error: " + response.message());
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<Item> call, Throwable t) {
//                        progressDialog.dismiss();
//                        Toast.makeText(context, "Vui lòng thử lại sau.", Toast.LENGTH_LONG).show();
//                        Log.i("PostAction", "item create failed");
//                    }
//                });
//            } else if (action == ITEM_UPDATE_ACTION) {
//                jsonBody.put("newUrls", urlList);
//                jsonBody.put("removedUrlIds", item.getImageIds());
//                rmaAPIService.updateItem(jsonBody, authorization, item.getId()).enqueue(new Callback<Object>() {
//
//                    @Override
//                    public void onResponse(Call<Object> call, Response<Object> response) {
//                        if (response.isSuccessful()) {
//                            if (response.body() != null) {
//                                progressDialog.dismiss();
//                                Log.i("PostAction", "item updated");
//                                Intent intent = new Intent(context, OwnInventory.class);
//                                context.startActivity(intent);
//                            } else {
//                                progressDialog.dismiss();
//                                Toast.makeText(context, "Vui lòng thử lại sau.", Toast.LENGTH_LONG).show();
//                                Log.i("PostAction", "item update null");
//                            }
//                        } else {
//                            progressDialog.dismiss();
//                            Toast.makeText(context, "Vui lòng thử lại sau.", Toast.LENGTH_LONG).show();
//                            Log.i("PostAction", "item update error: " + response.message());
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<Object> call, Throwable t) {
//                        progressDialog.dismiss();
//                        Toast.makeText(context, "Vui lòng thử lại sau.", Toast.LENGTH_LONG).show();
//                        Log.i("PostAction", "item update failed");
//                    }
//                });
//            }
//        }
//    }
//
//    public void manageDonation(DonationPostWrapper donationPostWrapper, List<String> urlList, String authorization, final Context context, int action) {
//
//        setDialog(context);
//
////        jsonBody.put("urls", urlList);
//
//        if (authorization != null) {
//            if (action == DONATION_CREATE_ACTION) {
//                donationPostWrapper.setUrls(urlList);
//                rmaAPIService.createDonationPost(donationPostWrapper, authorization).enqueue(new Callback<DonationPostWrapper>() {
//
//                    @Override
//                    public void onResponse(Call<DonationPostWrapper> call, Response<DonationPostWrapper> response) {
//                        if (response.isSuccessful()) {
//                            if (response.body() != null) {
//                                progressDialog.dismiss();
//                                Toast.makeText(context, "Đăng bài thành công.", Toast.LENGTH_LONG).show();
//                                Log.i("PostAction", "donation added");
//                                //go to main screen
//                                Intent intent = new Intent(context, MainActivity.class);
//                                context.startActivity(intent);
//
//                                //TODO on activity result
//
//                            } else {
//                                progressDialog.dismiss();
//                                Toast.makeText(context, "Vui lòng thử lại sau.", Toast.LENGTH_LONG).show();
//                                Log.i("PostAction", "donation create null");
//                            }
//                        } else {
//                            progressDialog.dismiss();
//                            Toast.makeText(context, "Vui lòng thử lại sau.", Toast.LENGTH_LONG).show();
//                            Log.i("PostAction", "donation create error " + response.code());
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<DonationPostWrapper> call, Throwable t) {
//                        progressDialog.dismiss();
//                        Toast.makeText(context, "Vui lòng thử lại sau.", Toast.LENGTH_LONG).show();
//                        Log.i("PostAction", "donation create failed");
//                    }
//                });
//            } else if (action == DONATION_UPDATE_ACTION) {
//                donationPostWrapper.setNewUrls(urlList);
////                jsonBody.put("newUrls", urlList);
////                jsonBody.put("removedUrlIds", donationPost.getImageIds());
//                rmaAPIService.updateDonationPost(donationPostWrapper, donationPostWrapper.getDonationPost().getId(), authorization).enqueue(new Callback<Object>() {
//
//                    @Override
//                    public void onResponse(Call<Object> call, Response<Object> response) {
//                        if (response.isSuccessful()) {
//                            if (response.body() != null) {
//                                Log.i("PostAction", "donation updated");
//                                //go to main
//                                progressDialog.dismiss();
////                                Intent intent = new Intent(context, MainActivity.class);
////                                context.startActivity(intent);
//
//                                Intent returnIntent = new Intent();
//                                ((Activity) context).setResult(Activity.RESULT_OK, returnIntent);
//                                ((Activity) context).finish();
//                            } else {
//                                progressDialog.dismiss();
//                                Toast.makeText(context, "Vui lòng thử lại sau.", Toast.LENGTH_LONG).show();
//                                Log.i("PostAction", "donation update null");
//                            }
//                        } else {
//                            progressDialog.dismiss();
//                            Toast.makeText(context, "Vui lòng thử lại sau.", Toast.LENGTH_LONG).show();
//                            Log.i("PostAction", "donation update error " + response.code());
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<Object> call, Throwable t) {
//                        progressDialog.dismiss();
//                        Toast.makeText(context, "Vui lòng thử lại sau.", Toast.LENGTH_LONG).show();
//                        Log.i("PostAction", "donation update failed");
//                    }
//                });
//            }
//        }
//    }
//
//    private void setDialog(Context context) {
//        progressDialog = new ProgressDialog(context);
//        progressDialog.setTitle("Đang tải dữ liệu...");
//        progressDialog.setMessage("Vui lòng chờ...");
//        progressDialog.setCanceledOnTouchOutside(false);
//        progressDialog.show();
//    }
//
//    public void manageUser(final User user, final String url, String authorization, final Context context, int action, final SharedPreferences.Editor editor) {
//        setDialog(context);
//
//        final String fullName = user.getFullName();
//        final String address = user.getAddress();
//        final Map<String, String> jsonBody = new HashMap<String, String>();
//        jsonBody.put("fullName", fullName);
//        jsonBody.put("avatar", url);
//        jsonBody.put("address", address);
//
//        if (action == USER_UPDATE_ACTION) {
//            rmaAPIService.updateInfo(jsonBody, authorization).enqueue(new Callback<Object>() {
//                @Override
//                public void onResponse(Call<Object> call, Response<Object> response) {
//
//
//                    if (response.isSuccessful()) {
//                        LinkedTreeMap<String, Object> responeBody = (LinkedTreeMap<String, Object>) response.body();
//                        if (responeBody.containsKey("User")) {
//                            Toast.makeText(context, R.string.edit_profile_success, Toast.LENGTH_SHORT).show();
//                            editor.putString("fullname", fullName);
//                            editor.putString("avatar", url);
//                            editor.putString("address", address);
//                            editor.commit();
//                            progressDialog.dismiss();
//                        }
//                    } else {
//                        LinkedTreeMap<String, String> responeBody = (LinkedTreeMap<String, String>) response.body();
//                        if (responeBody.containsKey("message")) {
//                            Toast.makeText(context, responeBody.get("message").toString(), Toast.LENGTH_SHORT).show();
//                        }
//                        progressDialog.dismiss();
//                    }
//                }
//                //TODO: updating...
//
//                @Override
//                public void onFailure(Call<Object> call, Throwable t) {
//                    System.out.println("Fail rồi");
//                    Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
//                    progressDialog.dismiss();
//                }
//            });
//        }
//    }
//}