package dialogapplication.bmpl.com.dialogapplication;

import android.content.Context;
import android.content.DialogInterface;;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button first, second, third;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first = (Button)findViewById(R.id.onebutton);
        second = (Button)findViewById(R.id.twobutton);
        third = (Button)findViewById(R.id.threebutton);
    }

    public void oneButton(View view)
    {

        AlertDialog.Builder alertDialog =new AlertDialog.Builder(this);

        //set the icon of dialog
        alertDialog.setIcon(R.drawable.alert_icon);

        //set the title of dialog
        alertDialog.setTitle("Alert dialog");

        //set the message of dialog
        alertDialog.setMessage("Please Press Ok");

        alertDialog.setNeutralButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Ok is pressed", Toast.LENGTH_LONG).show();
            }
        });
        alertDialog.show();

    }

    public void twoButton(View view){

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);

        // Setting Dialog Title
        alertDialog.setTitle("Confirm Delete...");

        // Setting Dialog Message
        alertDialog.setMessage("Are you sure you want delete this?");

        // Setting Icon to Dialog
        alertDialog.setIcon(R.drawable.alert_icon);

        // Setting Positive "Yes" Button
        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {
                onBackPressed();
                //Toast.makeText(getApplicationContext(), "You clicked on YES", Toast.LENGTH_SHORT).show();
            }
        });

        // Setting Negative "NO" Button
        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                /*Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
                dialog.cancel();*/
                onResume();
            }
        });

        // Showing Alert Message
        alertDialog.show();

    }

    public void threeButton(View view){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);

        // Setting Dialog Title
        alertDialog.setTitle("Save File...");

        // Setting Dialog Message
        alertDialog.setMessage("Do you want to save this file?");

        // Setting Icon to Dialog
        alertDialog.setIcon(R.drawable.alert_icon);

        // Setting Positive "Yes" Button
        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "You clicked on YES",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Setting Negative "NO" Button
        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
            }
        });

        // Setting Netural "Cancel" Button
        alertDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "You clicked on Cancel",
                        Toast.LENGTH_SHORT).show();
            }
        });
        // Showing Alert Message
        alertDialog.show();
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }
}
