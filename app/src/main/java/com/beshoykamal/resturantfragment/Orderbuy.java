package com.beshoykamal.resturantfragment;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.beshoykamal.resturantfragment.model.Orders;
import com.squareup.picasso.Picasso;

import static android.Manifest.permission.READ_PHONE_NUMBERS;
import static android.Manifest.permission.READ_PHONE_STATE;
import static android.Manifest.permission.READ_SMS;
import static com.backendless.rt.RTTypes.log;

public class Orderbuy extends AppCompatActivity {

    TextView costOrderView,namePlate,title,phonNumber;
    ImageView imag;
    EditText numpOrder;
    Button butnOrder,anothr;
    ProgressBar progress;
    String price;
    String nameplates;
    int prick;
    String mPhoneNumber;
    Orders orders;
    String numstring;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderbuy);
        costOrderView =findViewById(R.id.cost_order_view);
        namePlate=findViewById(R.id.namplate);
        title=findViewById(R.id.titleItems);
        imag=findViewById(R.id.imageOrder);
        numpOrder=findViewById(R.id.numberOrder);
        butnOrder=findViewById(R.id.buttonOrder);
        progress=findViewById(R.id.progressBar);
        phonNumber=findViewById(R.id.viewphone);
        anothr=findViewById(R.id.another);



        final String items = getIntent().getStringExtra("items");
        title.setText(items);

        nameplates = getIntent().getStringExtra("nameplate");
        namePlate.setText(nameplates);

        price = getIntent().getStringExtra("price");
        costOrderView.setText(price);

        String url= getIntent().getStringExtra("URL");
        Picasso.get().load(url).into(imag);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void Orders(View view) {

        progress.setVisibility(View.VISIBLE);
        if (!numpOrder.getText().toString().equals("")){
           costOrderView.setText(numpOrder.getText());

            Toast.makeText(this, "Thank You ", Toast.LENGTH_SHORT).show();


            // method amount
             numstring= numpOrder.getText().toString();
            int count = Integer.parseInt(numpOrder.getText().toString());
            int pric = Integer.parseInt(price.replaceAll("[\\D]", ""));
             prick= (count*pric);
             String amount = prick+" .lE";


             numpOrder.setText("");
             numpOrder.setVisibility(View.INVISIBLE);
             butnOrder.setVisibility(View.INVISIBLE);
             anothr.setVisibility(View.VISIBLE);

            costOrderView.setText(amount+"\n"+numstring+" From / "+nameplates +"\n"+"We prepare Now"+"\n"+
                    "\n Thank You for Order \n"+"\nFoodie food , Foodie drinks\n");



            phonenumper();

            phonNumber.setText(mPhoneNumber+"\n");
            progress.setVisibility(View.INVISIBLE);

        }
        else {
            Toast.makeText(this, "valid enter", Toast.LENGTH_LONG).show();

            progress.setVisibility(View.INVISIBLE);
        }
    }

    private void uploadToDatabase() {
        orders = new Orders();
        orders.setKinds(numstring+" piece");
        orders.setAmount(prick+".LE");
        orders.setPhone(mPhoneNumber+"");
        orders.setName(nameplates);

//        Toast.makeText(this, ""+mPhoneNumber+"///\n"+numstring, Toast.LENGTH_SHORT).show();

        Backendless.Persistence.save(orders, new AsyncCallback<Orders>() {
            @Override
            public void handleResponse(Orders response) {

                Toast.makeText(Orderbuy.this, "Done Your Order Sir", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void handleFault(BackendlessFault fault) {

                Toast.makeText(Orderbuy.this, "Try Again Error Internet", Toast.LENGTH_SHORT).show();
            }
        });


    }

    // permission contact

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void phonenumper() {


        if (ActivityCompat.checkSelfPermission(this, READ_SMS) == PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, READ_PHONE_NUMBERS) ==
                        PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
            TelephonyManager tMgr = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
             mPhoneNumber = tMgr.getLine1Number();
             phonNumber.setText("Order From : "+mPhoneNumber);

            uploadToDatabase();

        } else {
            requestPermission();
        }

    }
        @RequiresApi(api = Build.VERSION_CODES.M)
        private void requestPermission() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{READ_SMS, READ_PHONE_NUMBERS, READ_PHONE_STATE}, 100);
            }
        }
        public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
            switch (requestCode) {
                case 100:
                    TelephonyManager tMgr = (TelephonyManager)  this.getSystemService(Context.TELEPHONY_SERVICE);
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) !=
                            PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                            Manifest.permission.READ_PHONE_NUMBERS) != PackageManager.PERMISSION_GRANTED  &&
                            ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) !=      PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                     mPhoneNumber = tMgr.getLine1Number();
                    phonNumber.setText("Order From : "+mPhoneNumber);
                    uploadToDatabase();
                    break;
            }
        }


    public void anothe(View view) {
        numpOrder.setVisibility(View.VISIBLE);
        butnOrder.setVisibility(View.VISIBLE);
        anothr.setVisibility(View.INVISIBLE);
        costOrderView.setText("");
    }
}




