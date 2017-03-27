package com.example.karugo.Restaurants;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

public class Main2Activity extends AppCompatActivity implements OnMapReadyCallback {
    Toolbar mToolbar;
    ImageView flag;
    TextView desc;
    GoogleMap mGoogleMap;


    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(googleServicesAvailable()){
            Toast.makeText(this,"Perfecto!!!",Toast.LENGTH_LONG).show();
            setContentView(R.layout.activity_main2);

            initMap();

        }
        else {
           Toast.makeText(this,"No google maps",Toast.LENGTH_LONG).show();


        }

        mToolbar = (Toolbar) findViewById(R.id.toolbar1);
        flag = (ImageView) findViewById(R.id.imageView);
        desc = (TextView) findViewById(R.id.tvDescription);

        Bundle bundle = getIntent().getExtras();


        if (bundle != null)

        {
            mToolbar.setTitle(bundle.getString("Restaurantname"));
            if (mToolbar.getTitle().toString().equalsIgnoreCase("Kenya"))

            {
                flag.setImageDrawable(ContextCompat.getDrawable(Main2Activity.this, R.drawable.flag_kenya));
                desc.setText("44.35 million (2013)");
                // mGoogleMap.setOnCameraIdleListener(-1.361621,36.770329,15);

                //  mGoogleMap.setOnMapClickListener(this,goToLocation(-1.361621,36.770329,15));
                //mGoogleMap.setOnMarkerClickListener(goToLocationZoom(-1.361621, 36.770329,15));;

            }

            else if (mToolbar.getTitle().toString().equalsIgnoreCase("Ghana"))

            {
                flag.setImageDrawable(ContextCompat.getDrawable(Main2Activity.this, R.drawable.flag_ghana));
                desc.setText("25.9 million (2013)");
            }

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Chad"))
            {
                flag.setImageDrawable(ContextCompat.getDrawable(Main2Activity.this,R.drawable.flag_chad));
                desc.setText("12.83 million (2013)");

            }
            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Guam"))
            {
                flag.setImageDrawable(ContextCompat.getDrawable(Main2Activity.this,R.drawable.flag_guam));
                desc.setText("165,124 (2013)");

            }

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Haiti"))
            {
                flag.setImageDrawable(ContextCompat.getDrawable(Main2Activity.this,R.drawable.flag_haiti));
                desc.setText("10.32 million (2013)");

            }

            else if (mToolbar.getTitle().toString().equalsIgnoreCase("Jordan"))
            {
                flag.setImageDrawable(ContextCompat.getDrawable(Main2Activity.this,R.drawable.flag_jordan));
                desc.setText("6.459 million (2013)");

            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    private void initMap() {
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);
    }

    public boolean googleServicesAvailable(){

        GoogleApiAvailability api = GoogleApiAvailability.getInstance();
        int isavailable = api.isGooglePlayServicesAvailable(this);
        if(isavailable == ConnectionResult.SUCCESS){
            return true;
        }
        else  if (api.isUserResolvableError(isavailable)){
            Dialog dialog = api.getErrorDialog(this,isavailable,0);
            dialog.show();
        }

        else {
            Toast.makeText(this, "cant connect to play services", Toast.LENGTH_SHORT).show();
        }
        return false;

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mGoogleMap = googleMap;

        // goToLocationZoom(-1.361621, 36.770329,15);


    }
    private void goToLocation(double lat,double lng){
        LatLng ll = new LatLng(lat,lng);
        CameraUpdate update = CameraUpdateFactory.newLatLng(ll);
        mGoogleMap.moveCamera(update);
    }
    private void goToLocationZoom (double lat,double lng,float zoom){
        LatLng ll = new LatLng(lat,lng);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(ll,zoom);
        mGoogleMap.moveCamera(update);
    }
}





