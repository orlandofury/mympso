package com.example.mpesoconsulta;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MPesoCaller extends ContextWrapper {
	public MPesoCaller(Context base) {
		super(base);
		// TODO Auto-generated constructor stub
	}

	private String url = "http://www.mpeso.net/datos/consulta.php";
	//private String url = "http://190.124.38.36/datos/consulta.php";

	public void consultarSaldo(final String tarjeta) {
		RequestQueue queue = Volley.newRequestQueue(this);
		StringRequest request = new StringRequest(Method.POST, url, 
				new Response.Listener<String>() {

					@Override
					public void onResponse(String response) {
						Log.d("MPESOAPP", response);
					}
				},new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						Log.d("DEBUG","ERROR - " + error.getMessage());
					}
				}
				) { 
			@Override
			protected Map<String, String> getParams()
					throws AuthFailureError {
				// TODO Auto-generated method stub
				Map<String, String>  params = new HashMap<String, String>();  
	            params.put("_funcion", "1");  
	            params.put("_terminal", tarjeta);
				return params;
			}
		};
		queue.add(request);
	}

}
