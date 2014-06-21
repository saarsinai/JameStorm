package com.JameStorm.outer;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;

public class MainActivity extends Activity {
 GoogleMap map;
 @SuppressLint("NewApi")
 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);

  map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
    .getMap();
  
  map.setMyLocationEnabled(true);
  
  // map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
  //map.setMapType(GoogleMap.MAP_TYPE_NONE);
  map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
  map.setIndoorEnabled(true);
  map.setBuildingsEnabled(true);
  map.getUiSettings().setZoomControlsEnabled(true);
  map.setTrafficEnabled(true);
  CameraUpdateFactory.zoomTo(14);
  //map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
  // map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
 }
}
