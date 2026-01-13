package Utils;

import java.io.File;

public class FileDownloadUtils {

    /**
     * Waits for a file with the given extension to appear in the directory.
     * @param dirPath Directory to check
     * @param extension File extension (e.g. ".pdf", ".docx")
     * @param timeoutSeconds Max wait time in seconds
     * @return The downloaded file, or null if not found
     */
    public static File waitForFile(String dirPath, String extension, int timeoutSeconds) {
        File dir = new File(dirPath);
        int waited = 0;

        while (waited < timeoutSeconds) {
            File[] files = dir.listFiles((d, name) -> name.endsWith(extension));
            if (files != null && files.length > 0) {
                // Sort by last modified
                File latest = files[0];
                for (File f : files) {
                    if (f.lastModified() > latest.lastModified()) {
                        latest = f;
                    }
                }
                return latest;
            }

            try {
                Thread.sleep(1000); // poll every second
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return null;
            }
            waited++;
        }
        return null;
    }

    /**
     * Deletes old files with the given extension before test run.
     */
    public static void clearOldFiles(String dirPath, String extension) {
        File dir = new File(dirPath);
        File[] files = dir.listFiles((d, name) -> name.endsWith(extension));
        if (files != null) {
            for (File f : files) {
                f.delete();
            }
        }
    }
}