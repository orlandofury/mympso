package com.example.mpesoconsulta;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class MPSODBHelper extends SQLiteOpenHelper {
	public final static String DATABASE_NAME = "mpso_db";
	public final static int DATABASE_VERSION = 1;
	public static final String ITEM_CREATE = 
			String.format("create table %s (%s int auto_increment,"
						+ "%s tarjetatucno int ," 
						+ "%s error boolean ,"
						+ "%s mensaje text ,"
						+ "%s saldo real ,"
						+ "%s fechaconsulta datetime)",
						ItemColumns._ID,
						ItemColumns.TARJETATUCNO,
						ItemColumns.ERROR,
						ItemColumns.MENSAJE,
						ItemColumns.SALDO,
						ItemColumns.FECHACONSULTA
						
			);
	public MPSODBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);

	}
	public interface Tables {
		String LOGCONSULTA = "LOGCONSULTA";
	}
	public interface ItemColumns extends BaseColumns {
		String TARJETATUCNO = "TARJETATUCNO";
		String ERROR = "ERROR";
		String MENSAJE = "MENSAJE";
		String SALDO = "SALDO";
		String FECHACONSULTA = "FECHACONSULTA";
		
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(ITEM_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
