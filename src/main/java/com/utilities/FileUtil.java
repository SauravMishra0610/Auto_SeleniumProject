package com.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.regex.Pattern;

public class FileUtil {
    // Root folder is: C:\save\thomas\job\computer\selenium_java\code
    public static String getFullpath(String... path) {
        String fullpath = (path.length > 0) ? path[0] : "";

        // Regex to replace / by \
        if (Pattern.compile("\\/").matcher(fullpath).find()) {
            fullpath = fullpath.replaceAll("\\/", "\\\\");
        }

        // Regex to find: C:\
        if (Pattern.compile("^[a-zA-Z]:\\\\").matcher(fullpath).find()) {
            return new File(fullpath).getAbsolutePath();
        }

        fullpath = fullpath.replaceAll("^\\\\", "");
        return new File(fullpath).getAbsolutePath();
    }

    /* -----------------------------------------------------
    Basic CRUD operation
	----------------------------------------------------- */

    public static boolean isFilePresent(String filename) {
        File file = new File(filename);
        return (file.exists() && !file.isDirectory());
    }

    public static boolean renameTo(String filenameOld, String filenameNew) {
        if (isFilePresent(filenameOld) && !isFilePresent(filenameNew)) {
            File fileOld = new File(filenameOld);
            File fileNew = new File(filenameNew);
            return fileOld.renameTo(fileNew);
        }
        return false;
    }

    public static boolean copy(String filenameOld, String filenameNew) {
        File fileOld = new File(filenameOld);
        File fileNew = new File(filenameNew);
        try {
            //Files.copy(fileOld.toPath(), fileNew.toPath(), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(fileOld.toPath(), fileNew.toPath());
            return true;
        } catch (IOException e) {
            // e.printStackTrace();
        }
        return false;
    }

    public static boolean move(String filenameOld, String filenameNew) {
        File fileOld = new File(filenameOld);
        File fileNew = new File(filenameNew);
        try {
            Files.move(fileOld.toPath(), fileNew.toPath());
            return true;
        } catch (IOException e) {
            // e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteFile(String filename) {
        if (!isFilePresent(filename))
            return false;
        File file = new File(filename);
        return file.delete();
    }

  	/* -----------------------------------------------------
    For testing purpose
	----------------------------------------------------- */

    public static void main(String[] args) {
        boolean flag = false;
        flag = isFilePresent("C:\\save\\test.txt");
        flag = copy("C:\\save\\test.txt", "C:\\save\\test2.txt");
        flag = renameTo("C:\\save\\test2.txt", "C:\\save\\test3.txt");
        flag = move("C:\\save\\test3.txt", "C:\\save\\test4.txt");
        flag = deleteFile("C:\\save\\test4.txt");
        System.out.println("flag = " + flag);

        System.out.println("1: "+ getFullpath() );
        System.out.println("2: "+ getFullpath("") );
        System.out.println("3: "+ getFullpath("C:/vendor") );
        System.out.println("4: "+ getFullpath("C:\\vendor") );
        System.out.println("5: "+ getFullpath("vendor") );
        System.out.println("6: "+ getFullpath("\\vendor") );
    }
}