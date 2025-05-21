package yi.shi.restapi;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload2.core.DiskFileItemFactory;
import org.apache.commons.fileupload2.core.FileItem;
import org.apache.commons.fileupload2.jakarta.servlet6.JakartaServletFileUpload;
import org.apache.commons.io.FileUtils;
import yi.shi.data.ResponseWrapper;
import yi.shi.plinth.annotation.Properties;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.POST;
import yi.shi.plinth.http.result.JSON;
import yi.shi.plinth.servlet.ServletHelper;
import yi.shi.utils.ImageUtil;
import yi.shi.utils.RandomGenerator;

import java.io.File;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@HttpService
public class UploadApi {

    @Properties("server.resources.folder")
    private String UPLOAD_DIRECTORY;


    @POST
    @HttpPath(value = "/api/upload")
    public JSON<ResponseWrapper<List<String>>> upload() {
        try{
            HttpServletRequest request = ServletHelper.getRequest();
            List<String> result = new LinkedList<>();
            if(JakartaServletFileUpload.isMultipartContent(request)) {
                DiskFileItemFactory factory = DiskFileItemFactory.builder().get();
                JakartaServletFileUpload upload = new JakartaServletFileUpload(factory);
                List<FileItem> items = upload.parseRequest(request);
                for (FileItem item : items) {
                    if (!item.isFormField()) {
                        String fileName = item.getName();
                        String tempPath = RandomGenerator.generateRandomString(4);
                        FileUtils.forceMkdir(new File(UPLOAD_DIRECTORY + File.separator + tempPath));
                        String filePath = UPLOAD_DIRECTORY + File.separator + tempPath + File.separator + fileName;
                        result.add("/static/" + tempPath + "/" + fileName);
                        if(isImage(item.getContentType())){
                            ImageUtil.compressImage(item.getInputStream(), filePath);
                        }else {
                            item.write(Path.of(filePath));
                        }
                    }
                }
            }
            return new JSON<>(ResponseWrapper.success(result));
        }
        catch (Exception e){
            return new JSON<>(ResponseWrapper.fail(e.getMessage()));
        }
    }

    private boolean isImage(String contentType) {
        Set<String> imageTypes = new HashSet<>();
        imageTypes.add("image/jpg");
        imageTypes.add("image/jpeg");
        imageTypes.add("image/png");
        imageTypes.add("image/gif");
        imageTypes.add("image/bmp");
        imageTypes.add("image/tiff");
        imageTypes.add("image/webp");
        return imageTypes.contains(contentType);
    }

}
