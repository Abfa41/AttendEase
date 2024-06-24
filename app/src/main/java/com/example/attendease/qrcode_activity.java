package com.example.attendease;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class qrcode_activity extends AppCompatActivity {

    private ImageView qrcode;
    private Button b;

    // Define the ActivityResultLauncher
    private final ActivityResultLauncher<Intent> scanActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    String scannedData = result.getData().getStringExtra("scannedData");
                    // Handle the scanned data
                    Toast.makeText(this, "Scanned: " + scannedData, Toast.LENGTH_LONG).show();
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        qrcode = findViewById(R.id.qrcode);
        b = findViewById(R.id.scanBut);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(qrcode_activity.this, ScannerActivity.class);
                scanActivityResultLauncher.launch(intent);
            }
        });

        String textToEncode = "Hi, I am QR code";
        generateQRCode(qrcode, textToEncode, 500);
    }

    private void generateQRCode(ImageView qrcode, String textToEncode, int size) {
        try {
            BitMatrix bitMatrix = new BarcodeEncoder().encode(textToEncode, BarcodeFormat.QR_CODE, size, size);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            qrcode.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("QR Exception", e.toString());
        }
    }
}
