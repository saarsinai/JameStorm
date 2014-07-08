package com.JameStorm.outer;

import java.util.ArrayList;
import java.util.Iterator;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;
import android.view.ContextMenu;  
import android.view.View;  
import android.view.ContextMenu.ContextMenuInfo; 

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.tyczj.mapnavigator.*;

public class MainActivity extends Activity
{
	 GoogleMap map;
	 public Navigator nav;
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
		map.setTrafficEnabled(false);
		/*Location myLocation = map.getMyLocation();
		LatLng latlng = new LatLng(myLocation.getLatitude(), myLocation.getLongitude());
		CameraPosition camPosition = new CameraPosition(latlng, 14.0f, 45f, 0f);*/
		 map.setMyLocationEnabled(true);

/*
 * Navigating through an outer activity.
 * 
		    LocationManager locManager = (LocationManager) getSystemService(LOCATION_SERVICE);
		    Criteria cri = new Criteria();
		    String bestProvider = locManager.getBestProvider(cri, true);

		    Location loc = locManager.getLastKnownLocation(bestProvider);
		    String latMy = String.valueOf(loc.getLatitude());
		    String lngMy = String.valueOf(loc.getLongitude());

		    Toast.makeText(this, "Navigation", Toast.LENGTH_SHORT).show();
		    String url = "http://maps.google.com/maps?saddr=" + latMy + ","
		            + lngMy + "&daddr=" + "תל אביב";

		    Intent navigation = new Intent(Intent.ACTION_VIEW);
		    navigation.setData(Uri.parse(url));

		    startActivity(navigation);
		    
		    		  */
		 

	 }
	 @Override
	public void onBackPressed() {
		/*Directions a = nav.getDirections();
		ArrayList<Route> routes = a.getRoutes();
		ArrayList<Steps> steps = routes.get(0).getLegs().get(0).getSteps();

		for(Iterator<Steps> i = steps.iterator(); i.hasNext(); ) {
			Steps item = i.next();
			System.out.println(item.instructions);
		super.onBackPressed();
		}*/
	 }
	 	 
	 public void onDirectionPressed(View v)
	 {
		 PopupMenu menu = new PopupMenu(this, v);
		 MenuInflater inflater = menu.getMenuInflater();
		 inflater.inflate(R.menu.main_menu, menu.getMenu());	 
		 menu.show();
	 
		 
		 /*LocationManager locManager = (LocationManager) getSystemService(LOCATION_SERVICE);
		    Criteria cri = new Criteria();
		    String bestProvider = locManager.getBestProvider(cri, true);

		    Location loc = locManager.getLastKnownLocation(bestProvider);
		    LatLng SourceLatLng = new LatLng(loc.getLatitude(), loc.getLongitude());
		    LatLng desLatLng = new LatLng(31.259477,34.790558);
		 nav = new Navigator(map,SourceLatLng,desLatLng);
		 nav.setPathLineWidth(12f);
		 nav.findDirections(false);
		 
		 CameraPosition cameraPosition = new CameraPosition.Builder().
                 target(SourceLatLng).
                 tilt(60).
                 zoom(15).
                 bearing(0).
                 build();

map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
				 */
	 }
}
