package br.com.bruno.gingaonespider.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.util.List;

import br.com.bruno.gingaonespider.model.SpiderMagazine;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by techresult on 03/06/2016.
 */
public class SpiderMagazineTask extends AsyncTask<Void, Void, List<SpiderMagazine>> {

    private Context context;

    public SpiderMagazineTask(Context context){
        this.context = context;
    }

    private ProgressDialog progress;

    protected void onPreExecute(){
        super.onPreExecute();

        progress = new ProgressDialog(context);
        progress.setTitle("Wait");
        progress.setMessage("Downloading magazines");
        progress.show();
    }

    @Override
    protected List<SpiderMagazine> doInBackground(Void... params) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://gateway.marvel.com:80/v1/public/characters/1009610/comics?ts=1&apikey=bb4470a46d0659a43c566ac6056ed48d&" +
                        "hash=479474cf0a28eac9998960da4d96f06b")
                .build();

        try {
            Response response = client.newCall(request).execute();
            Log.d("BODY", response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    protected void onPostExecute(List<SpiderMagazine> magazines){
        progress.dismiss();

        if(magazines.size() > 0) {
            for (SpiderMagazine spiderMagazine : magazines) {
                Log.d("Magazine", spiderMagazine.getTitle());
            }
        }
    }
}
