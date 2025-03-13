package yi.shi.restapi;

import yi.shi.data.ResponseWrapper;
import yi.shi.data.query.IdQueryParam;
import yi.shi.db.model.Album;
import yi.shi.db.model.Images;
import yi.shi.plinth.annotation.http.HttpBody;
import yi.shi.plinth.annotation.http.HttpParam;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.annotation.http.Method.POST;
import yi.shi.plinth.http.result.JSON;
import yi.shi.service.AlbumService;
import yi.shi.service.ImagesService;

import javax.inject.Inject;
import java.util.List;

@HttpService
public class AlbumApi {

    @Inject
    private AlbumService albumService;

    @Inject
    private ImagesService imagesService;

    //add Album
    @POST
    @HttpPath("/api/album/addAlbum")
    public JSON<ResponseWrapper<Album>> addAlbum(@HttpBody Album album){
        album = albumService.addAlbum(album);
        if (album != null){
            return new JSON<>(ResponseWrapper.success(album));
        }
        return new JSON<>(ResponseWrapper.fail("添加相册失败"));
    }

    @GET
    @HttpPath("/api/album/getAlbumsByName")
    public JSON<ResponseWrapper<List<Album>>> getAlbumsByName(@HttpParam("albumname")String albumName){
        List<Album> albums = albumService.getAlbumsByName(albumName);
        return new JSON<>(ResponseWrapper.success(albums));
    }

    @GET
    @HttpPath("/api/album/getAllAlbums")
    public JSON<ResponseWrapper<List<Album>>> getAllAlbums(){
        List<Album> albums = albumService.getAllAlbums();
        return new JSON<>(ResponseWrapper.success(albums));
    }

    @POST
    @HttpPath("/api/album/getImagesByAlbumId")
    public JSON<ResponseWrapper<List<Images>>> getImagesByAlbumId(@HttpBody IdQueryParam idQueryParam){
        List<Images> images = imagesService.getImagesByAlbumId(idQueryParam.getId());
        return new JSON<>(ResponseWrapper.success(images));
    }
}
