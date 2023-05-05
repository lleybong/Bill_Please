package sg.edu.rp.c346.id22015711.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    EditText amount;
    EditText numOfPax;
    ToggleButton svs;
    ToggleButton gst;
    RadioGroup rgPayMode;
    Button split;
    Button reset;
    TextView totalBill;
    TextView eachPays;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amount = findViewById(R.id.editInputAmt);
        numOfPax = findViewById(R.id.editInputPax);
        svs = findViewById(R.id.toggleButtonEnabled);
        gst = findViewById(R.id.toggleButtonEnabled2);
        rgPayMode = findViewById(R.id.rgPayMode);
        split = findViewById(R.id.split);
        reset = findViewById(R.id.reset);
        totalBill = findViewById(R.id.textTotalBill);
        eachPays = findViewById(R.id.textEachPays);







    split.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            if (amount.getText().toString().trim().length() != 0 && numOfPax.getText().toString().trim().
                    length() != 0) {
                double origAmt = Double.parseDouble(amount.getText().toString());
                double newAmt = 0.0;
                if (!svs.isChecked() && !gst.isChecked()) {
                    newAmt = origAmt;
                } else if (svs.isChecked() && !gst.isChecked()) {
                    newAmt = origAmt * 1.1;
                } else if (!svs.isChecked() && gst.isChecked()) {
                    newAmt = origAmt * 1.07;
                } else {
                    newAmt = origAmt * 1.17;
                }
                double eachPaysAmt = newAmt/numOfPax;
                totalBill.append("$" + newAmt);
                eachPays.append("$" + eachPaysAmt + " via Paynow to 9123 4567");
            }

        }
    });

    }
}





