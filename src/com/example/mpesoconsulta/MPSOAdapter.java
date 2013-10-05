package com.example.mpesoconsulta;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MPSOAdapter extends BaseAdapter {

	private List<MPSOResult> mpsoItems;
	private Context context;

	public MPSOAdapter(Context context) {
		mpsoItems = new ArrayList<MPSOResult>();
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mpsoItems.size();
	}

	@Override
	public MPSOResult getItem(int pos) {
		// TODO Auto-generated method stub
		return mpsoItems.get(pos);
	}

	@Override
	public long getItemId(int pos) {
		return pos;
	}

	@Override
	public View getView(int pos, View convertView, ViewGroup container) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		// el null es porque le decis a android que no sabes a que va estar
		// adjuntado.
		// El asume que el componente es un componente que esta adjuntado hace
		// mach_parent
		// Sin el if indica que cada vez que de haga un scroll se crea un nuevo
		// xml
		// Con el if reutilizara la el xml del layout que va desapareciendo al
		// hacer el scroll
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.activity_mpso, null);
		}
		// seteando el valor del texto.
		TextView textResult = (TextView) convertView
				.findViewById(R.id.textResult);
		MPSOResult item = getItem(pos);
		textResult.setText(item.toString());
		return convertView;
	}

	public void setItems(List<MPSOResult> values) {
		if (mpsoItems != null) {
			this.mpsoItems = values;
			notifyDataSetChanged();
		}
	}
}
