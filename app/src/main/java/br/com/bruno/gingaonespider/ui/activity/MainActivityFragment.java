package br.com.bruno.gingaonespider.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.HashMap;
import java.util.Map;

import br.com.bruno.gingaonespider.R;
import br.com.bruno.gingaonespider.data.remote.RestApi;
import br.com.bruno.gingaonespider.data.remote.ServerStatus;
import br.com.bruno.gingaonespider.model.SpiderMagazine;
import butterknife.BindView;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private static final String TAG = "MainActivityFragment";

    @BindView(R.id.grid_spider) GridView gridView;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        RestApi restApi = RestApi.Builder.build();

        Map<String, String> params = new HashMap<>();
        params.put("ts", "1");
        params.put("apikey", "bb4470a46d0659a43c566ac6056ed48d");
        params.put("hash", "479474cf0a28eac9998960da4d96f06b");

        Observable<Response<SpiderMagazine>> responseMagazine = restApi.getMagazines(params);
        responseMagazine
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Response<SpiderMagazine>>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "Load magazines [onCompleted]");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("ERROR", e.toString());
                    }

                    @Override
                    public void onNext(Response<SpiderMagazine> spiderMagazineResponse) {
                        if(spiderMagazineResponse.code() == ServerStatus.REQUEST_OK){
                            SpiderMagazine spider = spiderMagazineResponse.body();
                            Log.d("Magazine", spider.getTitle());
                        }
                    }
                });

        return view;
    }
}
