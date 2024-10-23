package yi.shi.restapi;

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

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@HttpService
public class UploadApi {

    @Properties("server.resources.folder")
    private String UPLOAD_DIRECTORY;


    @POST
    @HttpPath(value = "/upload")
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
                    item.write(new File(filePath));
                }
            }
        }
        return new JSON<String>("文件上传成功" );
    }

}
