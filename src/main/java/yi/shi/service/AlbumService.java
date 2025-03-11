package yi.shi.service;

import com.google.inject.ImplementedBy;
import yi.shi.db.model.Album;
import yi.shi.db.model.Images;
import yi.shi.service.impl.AlbumServiceImpl;

import java.util.List;

@ImplementedBy(AlbumServiceImpl.class)
public interface AlbumService {

    Album addAlbum(Album album);

    void deleteAlbum(Long id);

    Album getAlbumById(Long id);

    List<Album> getAlbumsByName(String albumName);

    List<Images> getImagesByAlbumId(Long albumId);
}
