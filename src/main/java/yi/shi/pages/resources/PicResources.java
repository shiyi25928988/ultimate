package yi.shi.pages.resources;

import com.google.common.base.Strings;
import yi.shi.plinth.annotation.http.HttpParam;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.MimeType;
import yi.shi.plinth.http.result.BINARY;

@HttpService
public class PicResources {

    @GET
    @HttpPath(value = "/img/pic")
    public BINARY pic(@HttpParam("filename")String fileName) throws Exception {
        if(Strings.isNullOrEmpty(fileName)){
            throw new Exception("fileName is null");
        }
        BINARY result = new BINARY();
        if(fileName.endsWith(".png")){
            result.setMimeType(MimeType.IMAGE_PNG);
        }else if(fileName.endsWith(".jpg")){
            result.setMimeType(MimeType.IMAGE_JPEG);
        }else if(fileName.endsWith(".gif")){
            result.setMimeType(MimeType.IMAGE_GIF);
        }else if(fileName.endsWith(".jpeg")){
            result.setMimeType(MimeType.IMAGE_JPEG);
        }else if(fileName.endsWith(".bmp")){
            result.setMimeType(MimeType.IMAGE_BMP);
        }else if(fileName.endsWith(".ico")){
            result.setMimeType(MimeType.IMAGE_ICON);
        }else if(fileName.endsWith(".svg")){
            result.setMimeType(MimeType.IMAGE_SVG);
        }else if(fileName.endsWith(".tiff")){
            result.setMimeType(MimeType.IMAGE_TIFF);
        }else if(fileName.endsWith(".webp")){
            result.setMimeType(MimeType.IMAGE_WEBP);
        }else{
            result.setMimeType(MimeType.ALL);
        }
        result.setData(this.getClass().getResourceAsStream("/pic/" + fileName));
        return result;
    }
}
