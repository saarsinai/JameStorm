package com.JameStorm.outer;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;

public class MainActivity extends Activity 
{
	 GoogleMap map;
	 
	 @SuppressLint("NewApi")
	 @Override
	 protected void onCreate(Bundle savedInstanceState) 
	 {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 final LocationManager manager = (LocationManager) getSystemService( Context.LOCATION_SERVICE );
		// If the GPS isn't on.
		if ( !manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
			  TurnLocationOnDialog turnLocationDialog = new TurnLocationOnDialog();
			  turnLocationDialog.show(getFragmentManager(), "turn_location_on");
		}
		  
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
		    .getMap();
		  
		map.setMyLocationEnabled(true);
		  
		map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		map.setIndoorEnabled(true);
		map.setBuildingsEnabled(true);
		map.getUiSettings().setZoomControlsEnabled(true);
		map.setTrafficEnabled(true);
		  


	 }
}
