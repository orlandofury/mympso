package com.example.mpesoconsulta;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.mpesoconsulta.MPSODBHelper.ItemColumns;
import com.example.mpesoconsulta.MPSODBHelper.Tables;

public class MPSODBManager {
	//Creando instancia estatica del manager
	private static MPSODBManager instance;
	private Context context;
	public MPSODBManager(Context context) {
		this.context = context;
	}
	public static MPSODBManager instance(Context context) {
		if (instance == null) {
			instance = new MPSODBManager(context);
		}
		if (instance.context != context) {
			instance.context = context;
		}
		return instance;
	}
	public boolean save(MPSOResult item) {
		MPSODBHelper helper = new MPSODBHelper(context);
		SQLiteDatabase db = helper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(ItemColumns.TARJETATUCNO, item.TarjetaTucNo);
		values.put(ItemColumns.ERROR, item.Error);
		values.put(ItemColumns.MENSAJE, item.Mensaje);
		values.put(ItemColumns.SALDO, item.Saldo);
		values.put(ItemColumns.FECHACONSULTA, item.FechaConsulta);
		long id = db.insert(Tables.LOGCONSULTA, null, values);
		db.close();
		return id > 0;
	}

}
