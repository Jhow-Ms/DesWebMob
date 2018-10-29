package br.com.john.moviemobile;

import android.app.Activity;
import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

class WebServiceClient {
    Activity activity;

    WebServiceClient(Activity activity){
        this.activity = activity;
    }
}