//package com.example.hackathon.RestAPIConn;
//
//import android.content.Context;
//
//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.StringRequest;
//import com.android.volley.toolbox.Volley;
//
//public class RestAPIConn {
//
//    private static String URL = "";
//    private static RequestQueue requestQueue;
//
//    public RestAPIConn()
//    {
//
//    }
//
//    public static void connect(Context context)
//    {
//        requestQueue = Volley.newRequestQueue(context);
//        // Request a string response from the provided URL.
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        // Display the first 500 characters of the response string.
////                        textView.setText("Response is: "+ response.substring(0,500));
//                    }
//                },
//                new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
////                textView.setText("That didn't work!");
//            }
//        });
//
//// Add the request to the RequestQueue.
//        requestQueue.add(stringRequest);
//
////        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
////            @Override
////            public void onResponse(JSONObject response) {
////
////            },
////            new Response.ErrorListener() {
////
////            }
////        })
//    }
//
//    public void onStop()
//    {
//        if (requestQueue != null)
//        {
////
//        }
//    }
//
//}
