package br.com.bruno.gingaonespider.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.bruno.gingaonespider.R;
import br.com.bruno.gingaonespider.model.SpiderMagazine;

/**
 * Created by techresult on 03/06/2016.
 */
public class CustomGridAdapter extends ArrayAdapter<SpiderMagazine> {

    private Context context;
    private List<SpiderMagazine> magazines;

    public CustomGridAdapter(Context context, int resource, List<SpiderMagazine> magazines) {
        super(context, resource, magazines);

        this.context = context;
        this.magazines = magazines;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewHolder holder;

        if(convertView == null){
            convertView = inflater.inflate(R.layout.custom_grid_item, parent, false);
            holder = new ViewHolder();
            holder.imgSpider = (ImageView) convertView.findViewById(R.id.img_spider);
            holder.tvNumber = (TextView) convertView.findViewById(R.id.tv_number);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }

        SpiderMagazine spiderMagazine = getItem(position);

        holder.imgSpider.setImageResource(R.drawable.spiderman);
        holder.tvNumber.setText("#91");

        return convertView;
    }

    static class ViewHolder{
        private ImageView imgSpider;
        private TextView tvNumber;
    }
}
