package com.example.volley_post;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Model>list=new ArrayList<>();
    JSONArray jsonArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        RequestQueue queue= Volley.newRequestQueue(this);
        String url="https://jsonplaceholder.typicode.com/posts";

        StringRequest request=new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject mainobj = null;

                        try {
                            jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                mainobj = jsonArray.getJSONObject(i);
                                int id = mainobj.getInt("id");
                                String title = mainobj.getString("title");
                                String body = mainobj.getString("body");

                                Model model = new Model(id, title, body);
                                list.add(model);
                                Log.d("TTT", "onResponse:id= " + id);
                                Log.d("TTT", "onResponse:title= " + title);
                                Log.d("TTT", "onResponse:id= " + body);
                            }
                        Recyclerview_Adapter adapter=new Recyclerview_Adapter(MainActivity.this,list);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();

            }
        });
     queue.add(request);
    }
}