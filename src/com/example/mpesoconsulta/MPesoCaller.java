package com.example.mpesoconsulta;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.util.Log;
import android.widget.TextView;

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

	public void consultarSaldo(final String tarjeta,final TextView txtResult) {
		RequestQueue queue = Volley.newRequestQueue(this);
		StringRequest request = new StringRequest(Method.POST, url,
				new Response.Listener<String>() {

					private MPSOResult mpsoresult;

					@Override
					public void onResponse(String response) {
						
						JSONObject jObj = null;
						
						try {
							jObj = new JSONObject(response);
						} catch (JSONException e) {
							Log.d("JSONException Creating JSONObject",
									e.getMessage());
							e.printStackTrace();
						}
						
						try {
							if(jObj!=null)
							{
								mpsoresult = MPsoProcessor.process(
										getBaseContext(), jObj,tarjeta);
								Log.d("MPSO Caller Internal", "callback result: " + mpsoresult.toString());
								//Toast.makeText(getBaseContext(), mpsoresult.toString(),
								//		Toast.LENGTH_LONG).show();
								Log.d("MPSO Caller Internal","callback setText before: " + txtResult.getText());
								txtResult.setText(mpsoresult.toString());
								Log.d("MPSO Caller Internal","callback setText after: " + txtResult.getText());
							}
							else
							{
								Log.e("MPSO Caller - Error Response","Error Response:" + response.length());
								if(response.length() == 0)
								{
									txtResult.setTextColor(Color.parseColor("#FF0000"));
									txtResult.setText("No es un Numero de tarjeta valida");
								}
								Log.d("MPSO Caller - Error Response", "This response must be treated different" + response.length());
							}
						} catch (JSONException e) {
							Log.d("JSONException Processor", e.getMessage());
							e.printStackTrace();
						}
						Log.d("MPESOAPP", response);
						
						

						// TODO:Llamar al setItem

					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						Log.d("DEBUG", "ERROR - " + error.getMessage());
					}
				}) {
			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				// TODO Auto-generated method stub
				Map<String, String> params = new HashMap<String, String>();
				params.put("_funcion", "1");
				params.put("_terminal", tarjeta);
				return params;
			}
		};
		queue.add(request);
	}

}
