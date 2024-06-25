package com.trongphu.ticketmovie.util;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

/**
 * Created by Trong Phu on 6/8/2024 22:46:43
 *
 * @author Trong Phu
 */
public class FileImageUploadUtil {

    public static String storeFile(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        //Them UUID vao truc tiep file de dam bao ten file la duy nhat!!
        String uniqueFileName = UUID.randomUUID().toString() + "_" + fileName;
        //Duong dan den thu muc ban muon luu  /////file java.nio.file
        Path uploadDir = Paths.get("uploads");
        //Kiem tra va tao thu muc ne no khong ton tai
        if (!Files.exists(uploadDir)) {
            Files.createDirectories(uploadDir);
        }
        //DUong dan day du den file
        Path destination = Paths.get(uploadDir.toString(), uniqueFileName);
        //Sao chep file vao thu muc dich
        Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);
        return uniqueFileName;
    }


    public static boolean deleteFile(String filename) {
        Path uploadDir = Paths.get("uploads");
        Path destination = Paths.get(uploadDir.toString(), filename);
        File file = new File(String.valueOf(destination));
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

}
