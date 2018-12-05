package com.cumulations.fragmentdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentB extends Fragment {

    FragmentBListener listener;
    EditText editText ;
    Button button;

    public interface FragmentBListener {
        void onInputBSent(CharSequence input);
    }
    public FragmentB() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_b, container, false);

        editText=view.findViewById(R.id.editText);
        button=view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input=editText.getText();
                listener.onInputBSent(input);
            }
        });

        return view;
    }

    public void updateEditText(CharSequence newText){
        editText.setText(newText);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentBListener){
            listener=(FragmentBListener) context;
        }else {
            throw new RuntimeException(context.toString()+" must implement FragmentBListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;
    }
}
