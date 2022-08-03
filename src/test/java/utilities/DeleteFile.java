package utilities;
// Java Program to find/delete files based on extensions

// Importing input output classes

import java.io.File;
import java.io.FilenameFilter;

// Class 1
// Main class
// To check for a file
public class DeleteFile {

    // Member variables of this class

    // File directory
    private static final String FILE_DIRECTORY = "target\\Screenshots";
    // File extension
    private static final String FILE_EXTENSION = ".png";

    // Method of this class
    public void deleteFile(String folder, String extension)
    {

        // Creating filter with given extension by
        // creating an object of FileExtFilter
        FileExtFilter filter = new FileExtFilter(extension);

        // Now, creating an object of FIle class
        File direction = new File(folder);

        // Cresting an array if strings to
        // list out all the file name
        // using the list() with .txt extension
        String[] list = direction.list(filter);

        // Iterating over the array of strings
        // using basic length() method
        for (int i = 0; i < list.length; i++) {
            // printing the elements
           // System.out.println(list[i]);
        }

        // Base condition check when array of strinfg is
        // empty Then simply return
        if (list.length == 0)
            return;

        File fileDelete;

        // Now looking for the file in the
        for (String file : list) {

            String temp = new StringBuffer(FILE_DIRECTORY)
                    .append(File.separator)
                    .append(file)
                    .toString();

            // Storing the file
            fileDelete = new File(temp);

            // Checking whether the file is deleted
            boolean isdeleted = fileDelete.delete();

            // Print true if file is deleted
//            System.out.println("file : " + temp
//                    + " is deleted : "
//                    + isdeleted);
        }

    }

    // Method 2
    // Main driver method
    public static void main(String args[])
    {

        // Calling the deleteFile() method over the file
        // FileCheker() method to check existence for the
        // file

        // Delete the file with FILE_EXTENSION from
        // FILE_DIRECTORY using the deleteFile() method s
        // created above
        new DeleteFile().deleteFile(FILE_DIRECTORY, FILE_EXTENSION);
    }
}

// Class 2
// Helper class
// Which in itself is implementing FilenameFilter Interface
class FileExtFilter implements FilenameFilter {

    // Extension
    private String extension;

    // Comparator
    public FileExtFilter(String extension)
    {

        // This keyword refers to current object itself
        this.extension = extension;
    }

    public boolean accept(File directory, String name)
    {

        // Returning the file name along with the file
        // extension type
        return (name.endsWith(extension));
    }
}
