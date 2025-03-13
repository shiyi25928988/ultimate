package yi.shi.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.google.inject.Inject;
import yi.shi.db.mapper.ImagesMapper;
import yi.shi.db.model.Images;
import yi.shi.service.ImagesService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

public class ImagesServiceImpl implements ImagesService {

    @Inject
    private ImagesMapper imagesMapper;

    private static Lock lock = new ReentrantLock();

    @Override
    public Images addImages(Images images) {
        lock.lock();
        try {
            if (Objects.isNull(images.getId())) {
                images.setId(imagesMapper.selectMaxId() + 1);
                images.setCreateTime(new Date());
                images.setOwnerId(Long.parseLong(String.valueOf(StpUtil.getLoginId())));
                imagesMapper.insert(images);
            } else {
                imagesMapper.update(images);
            }
            return images;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void deleteImages(Long id) {
        imagesMapper.deleteById(id);
    }

    @Override
    public Images getImagesById(Long id) {
        return imagesMapper.selectById(id);
    }

    @Override
    public List<Images> getImagesByAlbumId(Long albumId) {
        return imagesMapper.selectByAlbumId(albumId);
    }
}
