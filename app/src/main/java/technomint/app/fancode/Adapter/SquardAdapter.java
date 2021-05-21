package technomint.app.fancode.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import technomint.app.fancode.R;

public class SquardAdapter extends BaseAdapter {

    Context context;
    private final String [] values;
    LayoutInflater layoutInflater;

    public SquardAdapter(Context context, String[] values) {
        this.context = context;
        this.values = values;
    }

    @Override
    public int getCount() {
        return values.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        Holder holder = new Holder();
        View rowView;

        rowView = layoutInflater.inflate(R.layout.squard_item, null);
        holder.tv =(TextView) rowView.findViewById(R.id.textview);
        holder.tv.setText(values[position]);


        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context, "You Clicked "+values[position], Toast.LENGTH_LONG).show();

            }
        });

        return rowView;
    }

    public class Holder
    {
        TextView tv;
    }

}