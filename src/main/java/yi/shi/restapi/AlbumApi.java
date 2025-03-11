package yi.shi.restapi;

import yi.shi.data.ResponseWrapper;
import yi.shi.data.query.IdQueryParam;
import yi.shi.db.mapper.AlbumMapper;
import yi.shi.db.model.Album;
import yi.shi.db.model.Images;
import yi.shi.plinth.annotation.http.HttpBody;
import yi.shi.plinth.annotation.http.HttpParam;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.annotation.http.Method.POST;
import yi.shi.plinth.http.result.JSON;

import javax.inject.Inject;
import java.util.List;

@HttpService
public class AlbumApi {

    @Inject
    private AlbumMapper albumMapper;

    //add Album
    @POST
    @HttpPath("/api/album/addAlbum")
    public JSON<ResponseWrapper<Album>> addAlbum(@HttpBody Album album){
        albumMapper.insert(album);
        return null;
    }

    @GET
    @HttpPath("/api/album/getAlbumsByName")
    public JSON<ResponseWrapper<List<Album>>> getAlbumsByName(@HttpParam("albumname")String albumName){
        return null;
    }

    @GET
    @HttpPath("/api/album/getAllAlbums")
    public JSON<ResponseWrapper<List<Album>>> getAllAlbums(){
        return null;
    }

    @POST
    @HttpPath("/api/album/getImagesByAlbumId")
    public JSON<ResponseWrapper<List<Images>>> getImagesByAlbumId(@HttpBody IdQueryParam idQueryParam){
        return null;
    }
}
