package com.JameStorm.outer;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;

public class TurnLocationOnDialog extends DialogFragment 
{
	public Dialog onCreateDialog(Bundle savedInstanceState) 
	{
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.turn_location_dialog_view, null));
        /*
        builder.setMessage(R.string.turn_location_message)
        		.setTitle(R.string.turn_location_title)*/
        		builder.setPositiveButton(R.string.turn_location_on_button, new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                	   startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                   }
               })
               .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                       // User cancelled the dialog
                   }
               });
        // Create the AlertDialog object and return it
        return builder.create();
	}
}
