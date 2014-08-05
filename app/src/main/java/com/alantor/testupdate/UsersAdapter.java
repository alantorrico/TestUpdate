package com.alantor.testupdate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Alan on 8/1/14.
 */
public class UsersAdapter extends ArrayAdapter<Contacto> {

    public UsersAdapter(Context context, ArrayList<Contacto> users){
        super(context, R.layout.item_user, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        Contacto user = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user, parent, false);
        }

        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        TextView tvhome = (TextView) convertView.findViewById(R.id.tvHome);

        tvName.setText(user.getNombre());
        tvhome.setText(user.getTelefono());

        return convertView;
    }
}
