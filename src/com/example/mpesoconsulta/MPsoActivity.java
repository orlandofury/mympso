package com.example.mpesoconsulta;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MPsoActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mpso);
		final EditText editText = (EditText)findViewById(R.id.editTUC);
		
		editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
			
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				if(actionId == EditorInfo.IME_ACTION_DONE)
					{
						String tarjetaTUC = editText.getText().toString();
					 	new MPesoCaller(getBaseContext()).consultarSaldo(tarjetaTUC);
						Log.d("MPESOAPP", "On Editor Action");
						return true;
					}
				
				return false;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mpso, menu);
		return true;
	}

}
