package com.assignment.own;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.LauncherActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
 //   private ArrayList<model> data = new ArrayList<>();
    private RecyclerView recyclerView;
    private DataAdapter adapter;
    RequestQueue queue;
    ProgressDialog  progressDoalog;

   // private List<model> modelList;

    private static final String url_data = "https://api.github.com/repositories/19438/issues";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();


        /*Create handle for the RetrofitInstance interface*/
        GetdataService service = Api.getRetrofitInstance().create(GetdataService.class);
        Call<List<storedata>> call = service.getAllPhotos();
        call.enqueue(new Callback<List<storedata>>() {

            @Override
            public void onResponse(Call<List<storedata>> call, retrofit2.Response<List<storedata>> response) {


                progressDoalog.dismiss();
                generateDataList(response.body());
            }


            @Override
            public void onFailure(Call<List<storedata>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    

    }


    private void generateDataList(List<storedata> photoList) {
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new DataAdapter(photoList,this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}





/*
    private void loadRecyclerViewData (){

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url_data,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response);



                            for (int i =0; i<array.length(); i++)
                            {
                                JSONArray array = jsonObject.getInt(i );
                                JSONObject object = array.getJSONObject(i);

                               String id = object.getString("id");
                               String url = object.getString("url");
                               String state = object.getString("state");
                                Toast.makeText(MainActivity.this, ""+id, Toast.LENGTH_SHORT).show();

                            }
                        } catch (JSONException e){
                            Toast.makeText(MainActivity.this,""+ e, Toast.LENGTH_SHORT).show();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,""+ error, Toast.LENGTH_SHORT).show();
                    }
                });
        queue.add(stringRequest);
    }*/



