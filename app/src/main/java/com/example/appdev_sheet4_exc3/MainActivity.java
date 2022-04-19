package com.example.appdev_sheet4_exc3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.appdev_sheet4_exc3.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    public int index = -1;
    ArrayList<String>pages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.webview.setWebViewClient(new WebViewClient());

        binding.buttonSearch.setOnClickListener(e->{
            String url = binding.textInputLayout3.getEditText().getText().toString();
            binding.webview.loadUrl(url);
            pages.add(url);
            index++;
        });

        binding.buttonBack.setOnClickListener(e->{
            if(!((index-1)<0)){
                String url = pages.get(index-1);
                binding.webview.loadUrl(url);
                index--;
            }
        });

        binding.buttonForth.setOnClickListener(e->{
            if((index+1)<pages.size()){
                String url = pages.get(index+1);
                binding.webview.loadUrl(url);
                index++;
            }
        });
    }
}