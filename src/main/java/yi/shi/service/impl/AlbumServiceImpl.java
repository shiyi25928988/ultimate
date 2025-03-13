package yi.shi.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.google.inject.Inject;
import yi.shi.db.mapper.AlbumMapper;
import yi.shi.db.model.Album;
import yi.shi.service.AlbumService;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AlbumServiceImpl implements AlbumService {

    @Inject
    private AlbumMapper albumMapper;

    private static Lock lock = new ReentrantLock();

    @Override
    public Album addAlbum(Album album) {
        if (Objects.isNull(album)) {
            return null;
        }
        lock.lock();
        try {
            if (Objects.isNull(album.getId())) {
                album.setId(albumMapper.selectMaxId() + 1);
                album.setCreateTime(new Date());
                album.setOwnerId(Long.parseLong(String.valueOf(StpUtil.getLoginId())));
                albumMapper.insert(album);
            } else {
                albumMapper.update(album);
            }
            return album;
        } finally {
            lock.unlock();
        }

    }

    @Override
    public void deleteAlbum(Long id) {
        albumMapper.deleteById(id);
    }

    @Override
    public Album getAlbumById(Long id) {
        if (Objects.nonNull(id)) {
            return albumMapper.selectById(id);
        }
        return null;
    }

    @Override
    public List<Album> getAllAlbums() {
        return albumMapper.selectAllAlbums();
    }

    @Override
    public List<Album> getAlbumsByName(String albumName) {
        if (Objects.nonNull(albumName)) {
            return albumMapper.selectAlbumsByName(albumName);
        }
        return Collections.emptyList();
    }

}
