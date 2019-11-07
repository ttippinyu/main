package integration;

import org.junit.jupiter.api.Test;
import spinbox.containers.lists.FileList;
import spinbox.entities.items.File;
import spinbox.exceptions.FileCreationException;
import spinbox.exceptions.SpinBoxException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileListIntegrationTest {
    @Test
    void testFileList_addingFiles() throws SpinBoxException {
        FileList fileList = new FileList("testFileList");
        fileList.add(new File(0, "file1"));
        fileList.add(new File(0, "file2"));
        fileList.add(new File(0, "file3"));

        List<File> checkList = new ArrayList<>();
        checkList.add(new File(0, "file1"));
        checkList.add(new File(0, "file2"));
        checkList.add(new File(0, "file3"));

        assertEquals(checkList.toString(), fileList.getList().toString());
    }

    @Test
    void testFileList_removingFiles() throws SpinBoxException {
        FileList fileList = new FileList("testFileList");
        fileList.add(new File(0, "file1"));
        fileList.add(new File(0, "file2"));
        fileList.add(new File(0, "file3"));

        List<File> checkList = new ArrayList<>();
        checkList.add(new File(0, "file1"));
        checkList.add(new File(0, "file2"));
        checkList.add(new File(0, "file3"));

        fileList.remove(1);
        checkList.remove(1);

        assertEquals(checkList.toString(), fileList.getList().toString());
    }

    @Test
    void testFileList_getFile() throws SpinBoxException {
        FileList fileList = new FileList("testFileList");
        fileList.add(new File(0, "file1"));
        fileList.add(new File(0, "file2"));
        fileList.add(new File(0, "file3"));

        File file = fileList.get(1);

        assertEquals("[NOT DOWNLOADED] file2", file.toString());
    }

    @Test
    void testFileList_update() throws SpinBoxException {
        FileList fileList = new FileList("testFileList");
        fileList.add(new File(0, "file1"));
        fileList.add(new File(0, "file2"));
        fileList.add(new File(0, "file3"));

        fileList.update(1, true);
        File file = fileList.get(1);

        assertEquals("[DOWNLOADED] file2", file.toString());
    }

    @Test
    void testFileList_contains() throws SpinBoxException {
        FileList fileList = new FileList("testFileList");
        fileList.add(new File(0, "a"));
        fileList.add(new File(0, "b"));
        fileList.add(new File(0, "c"));

        List<String> containsList = fileList.containsKeyword("a");
        List<String> checkList = new ArrayList<>();
        checkList.add("Here are the files that contain a in your module:");
        checkList.add("1. [NOT DOWNLOADED] a");

        assertTrue(checkList.equals(containsList));
    }

    @Test
    void testFileList_sort() throws SpinBoxException {
        FileList fileList = new FileList("testFileList");
        fileList.add(new File(0, "file3"));
        fileList.add(new File(0, "file1"));
        fileList.add(new File(0, "file2"));

        List<File> checkList = new ArrayList<>();
        checkList.add(new File(0, "file1"));
        checkList.add(new File(0, "file2"));
        checkList.add(new File(0, "file3"));

        assertEquals(checkList.toString(), fileList.getList().toString());
    }

}