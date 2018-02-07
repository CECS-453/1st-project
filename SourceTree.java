/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg534p1;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/**
 *
 * @author aaden
 */
public class SourceTree {
        public static void getFiles(String srcPath) throws IOException
        {
            Files.walk(Paths.get(srcPath))
//            .filter(p -> p.toString().endsWith(".ext"))
            .map(p -> p.getParent().getParent())
            .distinct()
            .forEach(System.out::println);
        }
}
