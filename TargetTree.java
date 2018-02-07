/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg534p1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import static pkg534p1.VCS.getChecksum;
import static pkg534p1.VCS.makeDirectory;

/**
 *
 * @author aaden
 */
public class TargetTree {
    
        public static void makeDirectory(String destinationString) {
        File dir = new File(destinationString);

        boolean successful = dir.mkdir();
        if (successful) {
            System.out.println("Directory made: " + destinationString);
        } else {
            System.out.println("Failed trying to create the directory");
        }
    }
    public static void copyFolder(File srcFolderPath, File destFolderPath, String sourceFolderName,
        ArrayList<String> fileAIDPaths) throws IOException {
        if (!srcFolderPath.isDirectory()) {
        // If it is a File the Just copy it to the new Folder
            InputStream in = new FileInputStream(srcFolderPath);
            OutputStream out = new FileOutputStream(destFolderPath);
            byte[] buffer = new byte[1024];

            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }

            in.close();
            out.close();
            System.out.println("File copied from " + srcFolderPath + " to " + destFolderPath + " successfully");
        } else {
            File destRepoPath = new File(destFolderPath.toString() + "/" + sourceFolderName);
        // if it is a directory create the directory inside the new
        // destination directory and
        // list the contents...
            if (!destRepoPath.exists()) {
                destRepoPath.mkdir();
                System.out.println("Directory copied from " + srcFolderPath + "  to " + destRepoPath + " successfully");
            }
            String folder_contents[] = srcFolderPath.list();

        // List of all the AID path to be added to the manifest file
            for (String file : folder_contents) {
                makeDirectory(destRepoPath + "/" + file);
                File source = new File(srcFolderPath, file);
        // If the folder has folders in it, recursive copy the folder
                if (source.isDirectory()) {
                    File inFolderDir = new File(destFolderPath + "/" + sourceFolderName);
                    copyFolder(source, inFolderDir, source.getName(), fileAIDPaths);
                } else {
            // Generate Checksum
                    File destination = new File(destRepoPath, file + "/" + (int) getChecksum(source));
            // Add file path to ArrayList to be added to manifest file
                    fileAIDPaths.add(destination.toString());
            // Copy each file
                    copyFolder(source, destination, sourceFolderName, fileAIDPaths);
                }
            }
        }
    }
}
