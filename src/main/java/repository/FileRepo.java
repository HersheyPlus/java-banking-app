package repository;

import entities.Account;
import services.FileService;

import java.io.*;
import java.util.Collection;
import java.util.List;

public class FileRepo implements FileService {
    private final static String PATH = "src/main/java/storage/storage.dat";


    @Override
    public boolean WriteFile(Collection<Account> accounts) {
        try (FileOutputStream fos = new FileOutputStream(PATH);
             BufferedOutputStream bos = new BufferedOutputStream(fos, 1024);
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.flush();
            oos.writeObject(accounts);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean ReadFile() {
        try (FileInputStream fis = new FileInputStream(PATH);
             BufferedInputStream bis = new BufferedInputStream(fis, 1024);
             ObjectInputStream ois = new ObjectInputStream(bis)) {
            Collection<Account> contents = (List<Account>) ois.readObject();
            System.out.println(contents);
            return true;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
