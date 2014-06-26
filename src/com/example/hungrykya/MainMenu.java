package com.example.hungrykya;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainMenu extends Activity {

	ListView menuList;
	String[] values;
	int[] prices;
	ArrayList<String> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menupage);

		menuList = (ListView) findViewById(R.id.list_menu_dishes);

		values = new String[] { "Tomato Shorba", "Lengendary Burger",
				"French Fries", "Panner Tikka", "Long Island Ice Tea",
				"Margaritta" };
		prices = new int[] { 150, 350, 180, 275, 480, 325 };
		list = new ArrayList<String>();

		for (int i = 0; i < values.length; ++i) {
			list.add(values[i]);

		}

		final SimpleArrayAdapter adapter = new SimpleArrayAdapter(this,
				android.R.layout.simple_list_item_1, list);
		menuList.setAdapter(adapter);
		menuList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(getApplicationContext(),
						"Click List Item Number " + position + 1,
						Toast.LENGTH_LONG).show();
			}
		});

	}

	private class SimpleArrayAdapter extends ArrayAdapter<String> {

		private final Context context;
		private final ArrayList<String> value;

		public SimpleArrayAdapter(Context context, int textViewResourceId,
				ArrayList<String> values) {
			super(context, textViewResourceId, values);
			this.context = context;
			this.value = values;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			View rowView = inflater.inflate(R.layout.list_menuitem_layout,
					parent, false);
			final TextView dishName = (TextView) rowView
					.findViewById(R.id.text_dish_name);
			final TextView dishPrice = (TextView) rowView
					.findViewById(R.id.text_dish_price);
			final ImageView dishImage = (ImageView) rowView
					.findViewById(R.id.img_dish_pic);
			dishName.setText(list.get(position));
			dishPrice.setText(String.valueOf(prices[position]));

			// Change icon based on name
			final int pos = position;

			rowView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					final Dialog dialog = new Dialog(MainMenu.this);

					dialog.setContentView(R.layout.dish_description);
					dialog.setTitle(dishName.getText().toString());

					final TextView pop_dish_close = (TextView) dialog
							.findViewById(R.id.text_pop_close);
					final TextView pop_dish_desc = (TextView) dialog
							.findViewById(R.id.text_pop_desc);
					final ImageView pop_dish_image = (ImageView) dialog
							.findViewById(R.id.img_pop_dish);

					pop_dish_close.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							dialog.dismiss();
						}
					});

					pop_dish_desc.setText("This will have the decription");
					if (pos == 0) {
						pop_dish_image.setImageResource(R.drawable.dish1);
					} else if (pos == 1) {
						pop_dish_image.setImageResource(R.drawable.dish2);
					} else if (pos == 2) {
						pop_dish_image.setImageResource(R.drawable.dish3);
					} else if (pos == 3) {
						pop_dish_image.setImageResource(R.drawable.dish4);
					} else if (pos == 4) {
						pop_dish_image.setImageResource(R.drawable.dish5);
					} else if (pos == 5) {
						pop_dish_image.setImageResource(R.drawable.dish6);
					}
					dialog.show();
				}
			});

			if (position == 0) {
				dishImage.setImageResource(R.drawable.dish1);
			} else if (position == 1) {
				dishImage.setImageResource(R.drawable.dish2);
			} else if (position == 2) {
				dishImage.setImageResource(R.drawable.dish3);
			} else if (position == 3) {
				dishImage.setImageResource(R.drawable.dish4);
			} else if (position == 4) {
				dishImage.setImageResource(R.drawable.dish5);
			} else if (position == 5) {
				dishImage.setImageResource(R.drawable.dish6);
			}
			return rowView;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu items for use in the action bar
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.activity_actions, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle presses on the action bar items
		switch (item.getItemId()) {
		case R.id.action_order:
			Toast.makeText(getApplicationContext(), "Time To Order",
					Toast.LENGTH_LONG).show();

			// order();
			return true;
		case R.id.action_settings:
			// openSettings();
			Toast.makeText(getApplicationContext(), "Settings",
					Toast.LENGTH_LONG).show();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
