package com.example.recap;

import android.os.Environment;
import android.util.Log;

import java.io.File;

public class Storage {
    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    public File getPublicDocumentsStorageDir(String fileName) {
        // Get the directory for the user's documents
        File file = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOCUMENTS), fileName);
        if (!file.mkdirs()) {
            Log.e("Storage exception:","Directory not created");
        }
        return file;
    }
    
    public void deleteFile(File file) {
        file.delete();
    }
}
