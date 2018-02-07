/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg534p1;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aaden
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        SourceTree st = new SourceTree();
        SourceTree.getFiles("c:\\Users\\aaden\\sampleSourceFolder");
        String repoPath = ("c:\\Users\\aaden\\sampleTargetFolder");
       // for(int i=0;i<files.size();i++){
        //    System.out.println(files.get(i).toString());
} 
    }
    
