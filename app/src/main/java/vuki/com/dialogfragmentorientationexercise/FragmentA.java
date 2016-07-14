package vuki.com.dialogfragmentorientationexercise;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import vuki.com.dialogfragmentorientationexercise.CustomDF.DialogClickInterface;

/**
 * Main fragment for exercise
 * Created by mvukosav on 13.7.2016..
 */
public class FragmentA extends Fragment implements DialogClickInterface {

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {
        final View v = inflater.inflate( R.layout.fragment, container, false );

        if( savedInstanceState != null ) {
            ( (TextView) v.findViewById( R.id.broj ) ).setText( savedInstanceState.getString( "number" ) );
            CustomDF customDF = ( (CustomDF) getFragmentManager().findFragmentByTag( "ddd" ) );
            if( customDF != null ) {
                customDF.setListener(this);
            }
        }

        v.findViewById( R.id.otvori ).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View view ) {
                CustomDF customDF = new CustomDF();
                customDF.setListener(FragmentA.this);
                customDF.setTargetFragment( FragmentA.this, 123 );
                customDF.show( getFragmentManager(), "ddd" );
            }
        } );
        return v;
    }

    @Override
    public void onDialogClick() {
        TextView textView = (TextView) getView().findViewById( R.id.broj );
        String str = textView.getText().toString();
        textView.setText( Integer.valueOf( TextUtils.isEmpty( str ) ? "0" : str ) + 1 + "" );
    }

    @Override
    public void onSaveInstanceState( Bundle outState ) {
        outState.putString( "number", ( (TextView) getView().findViewById( R.id.broj ) ).getText().toString() );
        super.onSaveInstanceState( outState );
    }

}
