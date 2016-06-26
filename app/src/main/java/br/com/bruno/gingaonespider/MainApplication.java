package br.com.bruno.gingaonespider;

import android.app.Application;

import io.paperdb.Paper;

/**
 * Created by Bruno on 26/06/2016.
 */
public class MainApplication extends Application {

    private static MainApplication instance;

    public static MainApplication getInstance(){
        return instance;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        instance = this;
        initialize();
    }

    private void initialize(){
        Paper.init(this);
    }

}
