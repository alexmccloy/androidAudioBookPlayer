package amccloy.com.audiobookplayer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Library extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_library);

		//Init views
		Toolbar toolbar = (Toolbar) findViewById(R.id.library_toolbar);
		setSupportActionBar(toolbar);
		toolbar.setTitle(R.string.library);

		FloatingActionButton fabSync = (FloatingActionButton) findViewById(R.id.library_sync);
		fabSync.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
						.setAction("Action", null).show();
			}
		});

		LinearLayout library = (LinearLayout) findViewById(R.id.ll_libraryContainer);

		//Populate library
		TextView tvNoBooks = new TextView(this);
		tvNoBooks.setText(R.string.no_books_available);
		library.addView(tvNoBooks);

		BookLibrary bookLib = new BookLibrary();
		bookLib.populate();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_library, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
