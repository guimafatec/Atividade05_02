package br.edu.fateczl.atividade05_02;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    /*
     *@author: Gustavo Guimarães de Oliveira
    */

    private EditText etBits;
    private RadioGroup rgXBytes;
    private RadioButton rbBytes;
    private RadioButton rbKB;
    private RadioButton rbMB;
    private RadioButton rbGB;
    private RadioButton rbTB;
    private Button btnConvert;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etBits = findViewById(R.id.etBits);
        rgXBytes = findViewById(R.id.rgXBytes);
        rbBytes = findViewById(R.id.rbBytes);
        rbKB = findViewById(R.id.rbKB);
        rbMB = findViewById(R.id.rbMB);
        rbGB = findViewById(R.id.rbGB);
        rbTB = findViewById(R.id.rbTB);
        rbBytes.setChecked(true);
        btnConvert = findViewById(R.id.btnConvert);
        tvResult = findViewById(R.id.tvResult);

        btnConvert.setOnClickListener(op -> convert());
    }

    private void convert() {
        int power = 0;
        String unit = "";
        if (rbBytes.isChecked()){
            power = 0;
            unit = "B";
        }
        else if (rbKB.isChecked()) {
            power = 1;
            unit = "KB";
        }
        else if (rbMB.isChecked()){
            power = 2;
            unit = "MB";
        }
        else if (rbGB.isChecked()){
            power = 3;
            unit = "GB";
        }
        else if (rbTB.isChecked()){
            power = 4;
            unit = "TB";
        }
        double bits = Double.parseDouble(etBits.getText().toString());
        double bytes = bits / 8;
        double result = bytes / Math.pow(1024, power);
        System.out.println("Bits: " + bits);
        System.out.println("Bytes: " + bytes);
        System.out.println("Power: " + power);
        System.out.println("Result: " + result + unit);
        String strResult = String.format("Resultado = %f %s\n", result, unit);
        tvResult.setText(strResult);
    }
}