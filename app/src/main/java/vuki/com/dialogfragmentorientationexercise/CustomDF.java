package vuki.com.dialogfragmentorientationexercise;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Main dialog fragment for exercise
 * Created by mvukosav on 13.7.2016..
 */
public class CustomDF extends DialogFragment {

    public interface DialogClickInterface {
        void onDialogClick();
    }

    private DialogClickInterface listener;

    public void setListener( Fragment fragment ) {
        try {
            listener = (DialogClickInterface) fragment;
        } catch( ClassCastException e ) {
            throw new ClassCastException( "Calling fragment must implement DialogClickListener interface" );
        }
    }

    @Override
    public Dialog onCreateDialog( Bundle savedInstanceState ) {
        return new AlertDialog.Builder( getActivity() )
                .setTitle( R.string.some_title )
                .setIcon( android.R.drawable.ic_dialog_alert )
                .setPositiveButton( R.string.btn_click,
                        new DialogInterface.OnClickListener() {
                            public void onClick( DialogInterface dialog, int whichButton ) {
                                listener.onDialogClick();
                            }
                        }
                )
                .create();
    }

}
