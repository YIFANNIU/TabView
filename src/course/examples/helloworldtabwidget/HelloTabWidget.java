package course.examples.helloworldtabwidget;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

public class HelloTabWidget extends TabActivity {
    /** Called when the activity is first created. */
	TabHost tabHost;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Resources res = getResources(); // Resource object to get Drawables
        tabHost = getTabHost();  // The activity TabHost
        TabHost.TabSpec spec;  // Reusable TabSpec for each tab
        Intent intent;  // Reusable Intent for each tab

//        Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent().setClass(this, ArtistsActivity.class);

//        Initialize a TabSpec for each tab and add it to the TabHost
        spec = tabHost.newTabSpec("artists").setIndicator("Artists",
                          res.getDrawable(R.drawable.ic_tab_artists))
                      .setContent(intent);
        tabHost.addTab(spec);

        // Do the same for the other tabs
        intent = new Intent().setClass(this, AlbumsActivity.class);
        spec = tabHost.newTabSpec("albums").setIndicator("Albums",
                          res.getDrawable(R.drawable.ic_tab_albums))
                      .setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, SongsActivity.class);
        spec = tabHost.newTabSpec("songs").setIndicator("Songs",
                          res.getDrawable(R.drawable.ic_tab_songs))
                      .setContent(intent);
       
        tabHost.addTab(spec);
        
//        when initialized , set the default selected tab's color Red, set others Blue
        for(int i=0;i<tabHost.getTabWidget().getChildCount();i++)
    	{
    		tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.BLUE);
    	}
        tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundColor(Color.RED);
        
//        when selected tab changed, set the selected tab's color Red, set others Blue
        tabHost.setOnTabChangedListener(new OnTabChangeListener() {
			
			@Override
			public void onTabChanged(String tabId) {
				// TODO Auto-generated method stub
				setTabColor();
			}
		});
        
    }
    
//    set the selected tab's color red !
    public void setTabColor()
    {
//    	first, set all tabs' color Blue
    	for(int i=0;i<tabHost.getTabWidget().getChildCount();i++)
    	{
    		tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.BLUE);
    		
    	}
//    	second, set the selected tab's color Red
    	tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundColor(Color.RED);
    		
    }
}