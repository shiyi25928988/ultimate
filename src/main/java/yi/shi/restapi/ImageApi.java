package yi.shi.restapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import yi.shi.data.ImageUrl;
import yi.shi.plinth.annotation.Properties;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.annotation.http.Method.POST;
import yi.shi.plinth.http.result.JSON;
import yi.shi.plinth.utils.json.JsonUtils;

import java.util.ArrayList;
import java.util.List;

@HttpService
public class ImageApi {

    @Properties("server.resources.folder")
    private String UPLOAD_DIRECTORY;

    @GET
    @HttpPath(value = "/getImages")
    public JSON<Object> getImages(){
        List<ImageUrl> list = new ArrayList<>();
        list.add(new ImageUrl("/static/1111111.png"));
        list.add(new ImageUrl("/static/1111111.png"));
        list.add(new ImageUrl("/static/1111111.png"));
        list.add(new ImageUrl("/static/1111111.png"));
        list.add(new ImageUrl("/static/1111111.png"));
        return new JSON<>(list);
    }



    public static void main(String[] args) throws JsonProcessingException {
        List<ImageUrl> list = new ArrayList<>();
        list.add(new ImageUrl("/static/1111111.png"));
        list.add(new ImageUrl("/static/1111111.png"));
        list.add(new ImageUrl("/static/1111111.png"));
        list.add(new ImageUrl("/static/1111111.png"));
        list.add(new ImageUrl("/static/1111111.png"));
        String str = JsonUtils.toJson(list);
        System.out.println(str);
    }
}
