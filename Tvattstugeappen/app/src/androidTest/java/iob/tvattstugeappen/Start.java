package iob.tvattstugeappen;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;

public class Start extends ActionBarActivity implements View.OnClickListener  {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // FIXME have Parse database initialized?

        setContentView(R.layout.activity_start);

        View x = findViewById(R.id.loginButton);
        x.setOnClickListener(this);
    }

    @Override
    public void onClick(View arg0) {

        if (isNetworkAvailable() == Boolean.FALSE) {
            Toast.makeText(getApplicationContext(),
                    "Du måste ha en aktiv internetuppkoppling för att använda den här appen. Mot world wide web!",
                    Toast.LENGTH_LONG).show();
        } else {
            if (arg0.getId() == R.id.loginButton) {
                    //Intent intent = new Intent(this, Login.class);
                    //this.startActivity(intent);
            }
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}