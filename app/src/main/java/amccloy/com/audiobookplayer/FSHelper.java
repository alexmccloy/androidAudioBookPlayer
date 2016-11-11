package amccloy.com.audiobookplayer;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by amccl_000 on 10/11/2016.
 */

public class FSHelper {

	public static void test() {
		Log.v(Util.TAG, "Writeable - " + (isExternalStorageWritable() ? "yes" : "no"));
		Log.v(Util.TAG, "Readable  - " + (isExternalStorageReadable() ? "yes" : "no"));
	}

	public void createTextFile(Context c, String fileName, String data) {
		// Create a path where we will place our private file on external
		// storage.
		File file = new File(c.getExternalFilesDir(null), "DemoFile.jpg");

		try {
			// Very simple code to copy a picture from the application's resource into the external file.  Note that this code does
			// no error checking, and assumes the picture is small (does not try to copy it in chunks).  Note that if external storage is
			// not currently mounted this will silently fail.
			OutputStream os = new FileOutputStream(file);
			os.write(data);
			os.close();
		} catch (IOException e) {
			// Unable to create file, likely because external storage is
			// not currently mounted.
			Log.w("ExternalStorage", "Error writing " + file, e);

		}
	}

	public void deleteFile(Context c) {
		// Get path for the file on external storage.  If external
		// storage is not currently mounted this will fail.
		File file = new File(c.getExternalFilesDir(null), "DemoFile.jpg");
		if (file != null) {
			file.delete();
		}
	}

	public boolean hasFile(Context c) {
		// Get path for the file on external storage.  If external
		// storage is not currently mounted this will fail.
		File file = new File(c.getExternalFilesDir(null), "DemoFile.jpg");
		if (file != null) {
			return file.exists();
		}
		return false;
	}

	/* Checks if external storage is available for read and write */
	public static boolean isExternalStorageWritable() {
		String state = Environment.getExternalStorageState();
		if (Environment.MEDIA_MOUNTED.equals(state)) {
			return true;
		}
		return false;
	}

	public static boolean isExternalStorageReadable() {
		String state = Environment.getExternalStorageState();
		if (Environment.MEDIA_MOUNTED.equals(state) ||
				Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
			return true;
		}
		return false;
	}

}
