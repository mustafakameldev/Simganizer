package com.mka.simganizer.SetData;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mka.simganizer.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SetManagerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SetManagerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SetManagerFragment extends Fragment implements View.OnClickListener  {
   private Button btn_next , btn_previous ;
    private OnFragmentInteractionListener mListener;

    public SetManagerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SetManagerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SetManagerFragment newInstance(String param1, String param2) {
        SetManagerFragment fragment = new SetManagerFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_set_manager, container, false);

        btn_next =(Button)view.findViewById(R.id.btn_next_setManagerFragment);
        btn_previous=(Button)view.findViewById(R.id.btn_previous_SetManagerFrgment);
        btn_next.setOnClickListener(this);
        btn_previous.setOnClickListener(this);
        btn_previous.setVisibility(View.GONE);



        return view ;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {
        if(view== btn_next)
        {
            SetAuthForManagerFragment fragment = new SetAuthForManagerFragment();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment, fragment.getClass().getSimpleName()).addToBackStack(null).commit();
        }
    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
