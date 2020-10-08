package com.ridamjain.tpfinternapp.api;

import java.security.cert.CertificateException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    public static final String BASEURL = "https://newsapi.org/v2/";
    public static Retrofit retrofit;
    private static APIClient apiClient;
    private APIClient()
    {
        retrofit=new Retrofit.Builder().baseUrl(BASEURL).addConverterFactory(GsonConverterFactory.create()).build();
    }
    public static synchronized APIClient getInstance()
    {
        if (apiClient==null)
        {
            apiClient=new APIClient();
        }
        return apiClient;
    }
    public APInterface getApi()
    {
        return retrofit.create(APInterface.class);
    }
}
