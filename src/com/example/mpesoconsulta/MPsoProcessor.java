package com.example.mpesoconsulta;


import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

public class MPsoProcessor {
	
	public static MPSOResult process(Context context,JSONObject response, String tarjeta)
			throws JSONException {
		
		Boolean error = response.getBoolean("Error");
		String mensaje = response.getString("Mensaje");
		MPSOResult mpsoResult = new MPSOResult();
		Calendar c = Calendar.getInstance();
		mpsoResult.Error = error;
		mpsoResult.Mensaje = mensaje;
		mpsoResult.TarjetaTucNo = tarjeta;
		// obteniendo el saldo del mensaje para guardar registro del mismo
		Pattern p = Pattern.compile("\\d+(\\.\\d+)?");
		Matcher m = p.matcher(mensaje);
		while (m.find()) {
			mpsoResult.Saldo = Double.parseDouble(m.group());
			// System.out.println(m.group(1));
		}
		// obteniendo fecha actual
		mpsoResult.FechaConsulta = c.get(Calendar.SECOND);
		//TODO: This fails
		//boolean resultInserted = MPSODBManager.instance(context).save(mpsoResult);
	    //Log.d("DBMANAER CALL", "mpso result inserted: " + resultInserted);
		//MPSODBManager.instance(context).save(mpsoResult);
		return mpsoResult;
	}
}
