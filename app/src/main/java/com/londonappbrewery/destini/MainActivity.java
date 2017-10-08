package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static com.londonappbrewery.destini.Path.BTM_BTN_PRESSED;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private Button mTopBtn;
    private Button mBottomButton;
    private TextView mStoryView;
    private int mStoryIndex = 0;
    private Path mCurrentArc;

    private Path[] mPaths = new Path[]{
            new Path(R.string.T1_Story,  R.string.T1_Ans1, R.string.T1_Ans2, 2, 1),
            new Path(R.string.T2_Story,  R.string.T2_Ans1, R.string.T2_Ans2, 2,3),
            new Path(R.string.T3_Story,  R.string.T3_Ans1, R.string.T3_Ans2, 5, 4),
            new Path(R.string.T4_End),
            new Path(R.string.T5_End),
            new Path(R.string.T6_End)
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null)
        {
            mStoryIndex = savedInstanceState.getInt("IndexKey");
        }

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mTopBtn = (Button) findViewById(R.id.buttonTop);
        mBottomButton = (Button) findViewById(R.id.buttonBottom);
        mStoryView = (TextView) findViewById(R.id.storyTextView);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mTopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updatePlot(Path.TOP_BTN_PRESSED);
            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:

        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updatePlot(Path.BTM_BTN_PRESSED);
            }
        });

        incrementStory(mStoryIndex);
    }

    public void updatePlot( int btn) {

        mStoryIndex = mCurrentArc.nextArc( btn );
        incrementStory(mStoryIndex);
    }


    public void incrementStory( int index)
    {
        if(mPaths[index].getBtmBtn() != 0) {
            mTopBtn.setText(mPaths[index].getTopBtn());
            mBottomButton.setText(mPaths[index].getBtmBtn());
        }
        else {
            mTopBtn.setVisibility(View.INVISIBLE);
            mBottomButton.setVisibility(View.INVISIBLE);
        }
        mStoryView.setText(mPaths[index].getStory());
        mCurrentArc = mPaths[index];

    }

    public void onSaveInstanceState( Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putInt("IndexKey", mStoryIndex);
    }

}
