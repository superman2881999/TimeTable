package android.app.networks;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;


public class APIRequest {
    private  String url;
    private  Context ctx;

    public APIRequest(String url, Context ctx) {
        this.url = url;
        this.ctx = ctx;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void req(final VolleyCallback callback){
        RequestQueue queue = Volley.newRequestQueue(this.ctx);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, this.url
                ,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray temp = new JSONArray(response);
                            callback.onSuccess(temp);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("TAG", String.valueOf(error));
            }
        });
        queue.add(stringRequest);

    }
}

