package yi.shi.restapi;

import com.google.common.collect.Sets;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import yi.shi.plinth.annotation.Properties;
import yi.shi.plinth.annotation.http.HttpBody;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.POST;
import yi.shi.plinth.http.result.JSON;
import yi.shi.plinth.servlet.ServletHelper;
import yi.shi.utils.ImageCompressor;
import yi.shi.utils.JpegToWbmp;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@HttpService
public class UploadApi {

    @Properties("server.resources.folder")
    private String UPLOAD_DIRECTORY;


    @POST
    @HttpPath(value = "/api/upload")
    public JSON<String> upload() throws Exception {
        HttpServletRequest request = ServletHelper.getRequest();
        if(ServletFileUpload.isMultipartContent(request)) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> items = upload.parseRequest(request);
            for (FileItem item : items) {
                if (!item.isFormField()) {
                    String fileName = item.getName();
                    String filePath = UPLOAD_DIRECTORY + File.separator + fileName;
                    if(isImage(item.getContentType())){
                        ImageCompressor.compressImage(item.getInputStream(), filePath);
                    }else {
                        item.write(new File(filePath));
                    }
                }
            }
        }
        return new JSON<String>("文件上传成功" );
    }

    @POST
    @HttpPath(value = "/uploadImage")
    public JSON<String> uploadImage() throws Exception {
        HttpServletRequest request = ServletHelper.getRequest();
        if(ServletFileUpload.isMultipartContent(request)) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> items = upload.parseRequest(request);
            for (FileItem item : items) {
                if (!item.isFormField()) {
                    String fileName = item.getName();
                    String filePath = UPLOAD_DIRECTORY + File.separator + fileName;
                    ImageCompressor.compressImage(item.getInputStream(), filePath);
                            //.convertAndSave(item.getInputStream(), filePath);
                }
            }
        }
        return new JSON<String>("文件上传成功" );
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
