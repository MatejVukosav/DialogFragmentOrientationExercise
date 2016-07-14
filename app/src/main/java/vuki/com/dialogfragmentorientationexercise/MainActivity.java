package vuki.com.dialogfragmentorientationexercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Main activity for exercise
 * Created by mvukosav on 13.7.2016..
 */
public class MainActivity extends AppCompatActivity {
    FragmentA fragmentA;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        if( savedInstanceState == null ) {
            fragmentA = new FragmentA();
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.root, fragmentA, "tag" )
                    .commit();
        }
    }
}
