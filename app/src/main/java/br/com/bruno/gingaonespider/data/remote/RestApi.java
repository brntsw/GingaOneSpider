package br.com.bruno.gingaonespider.data.remote;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import br.com.bruno.gingaonespider.model.SpiderMagazine;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by Bruno on 26/06/2016.
 */
public interface RestApi {

    @Headers({"Accept: application/json", "Content-type: application/json"})
    @GET(UrlServer.URL_MAGAZINES)
    Observable<Response<SpiderMagazine>> getMagazines(@QueryMap Map<String, String> params);

    class Builder {

        private static HttpLoggingInterceptor getLoggingInterceptor() {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            return interceptor;
        }

        private static OkHttpClient getOkHttpClient(HttpLoggingInterceptor loggingInterceptor) {
            return new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .readTimeout(240, TimeUnit.SECONDS)
                    .connectTimeout(20, TimeUnit.SECONDS)
                    .build();
        }

        public static RestApi build() {
            OkHttpClient client = getOkHttpClient(getLoggingInterceptor());

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(UrlServer.BASE_URL)
                    .addConverterFactory(JacksonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(client)
                    .build();

            return retrofit.create(RestApi.class);
        }
    }

}
