package id.mncinnovation.mncidentifiersdk.java;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

import id.mncinnovation.face_detection.MNCIdentifier;
import id.mncinnovation.face_detection.SelfieWithKtpActivity;
import id.mncinnovation.face_detection.analyzer.DetectionMode;
import id.mncinnovation.mncidentifiersdk.databinding.ActivityMainBinding;


@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity  {
    static int LIVENESS_DETECTION_REQUEST_CODE = 101;
    static int CAPTURE_EKTP_REQUEST_CODE = 102;
    static int SCAN_KTP_REQUEST_CODE = 103;
    static int SELFIE_WITH_KTP_REQUEST_CODE = 104;

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        MNCIdentifier.setDetectionModeSequence(true, Arrays.asList(
                DetectionMode.HOLD_STILL
                ));


        binding.btnLivenessDetection.setOnClickListener(v ->
            startActivityForResult(MNCIdentifier.getLivenessIntent(this), LIVENESS_DETECTION_REQUEST_CODE)
        );

        binding.btnSelfieWKtp.setOnClickListener(v ->
            startActivityForResult(new  Intent(this, SelfieWithKtpActivity.class), SELFIE_WITH_KTP_REQUEST_CODE)
        );
    }
}