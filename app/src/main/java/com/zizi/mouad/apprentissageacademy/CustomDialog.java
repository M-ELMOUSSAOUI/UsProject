package com.zizi.mouad.apprentissageacademy;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

public class CustomDialog extends DialogFragment {

    //Widgets
    private TextView mOk, mCancel;
    private EditText input;
    private String inputText, code;
    private ViewPager vp;
    private Context context;

    public CustomDialog(ViewPager vp, Context context) {
        this.vp = vp;
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.video_code, container, false);
        mOk = v.findViewById(R.id.txt_ok);
        mCancel = v.findViewById(R.id.txt_cancel);
        input = v.findViewById(R.id.password);
        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
                vp.setCurrentItem(0);
            }
        });
        getDialog().setCanceledOnTouchOutside(false);
        mOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputText = input.getText().toString().trim();
                code = "0012";
                if (inputText.isEmpty() || !inputText.equals(code)) {
                    Toast.makeText(getActivity(), "Code Incorrect", Toast.LENGTH_SHORT).show();
                    vp.setCurrentItem(0);
                    getDialog().dismiss();
                }

                if (!inputText.isEmpty() && inputText.equals(code)) getDialog().dismiss();
            }
        });

        return v;
    }

}
