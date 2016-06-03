package br.com.bruno.gingaonespider.task;

import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

import br.com.bruno.gingaonespider.model.SpiderMagazine;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by techresult on 03/06/2016.
 */
public class SpiderMagazineTask extends AsyncTask<Void, Void, List<SpiderMagazine>> {

    protected void onPreExecute(){
        super.onPreExecute();
    }

    @Override
    protected List<SpiderMagazine> doInBackground(Void... params) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://gateway.marvel.com:80/v1/public/characters/1009610/comics?ts=1&apikey=bb4470a46d0659a43c566ac6056ed48d&" +
                        "hash=479474cf0a28eac9998960da4d96f06b")
                .build();

        Response response = client.newCall()

        return null;
    }

    protected void onPostExecute(List<SpiderMagazine> magazines){
        if(magazines.size() > 0) {
            for (SpiderMagazine spiderMagazine : magazines) {
                Log.d("Magazine", spiderMagazine.getTitle());
            }
        }
    }
}
