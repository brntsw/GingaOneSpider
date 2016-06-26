package br.com.bruno.gingaonespider.ui.activity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import br.com.bruno.gingaonespider.R;
import br.com.bruno.gingaonespider.task.SpiderMagazineTask;
import butterknife.BindView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    @BindView(R.id.grid_spider) GridView gridView;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        new SpiderMagazineTask(getActivity()).execute();

        return view;
    }
}
