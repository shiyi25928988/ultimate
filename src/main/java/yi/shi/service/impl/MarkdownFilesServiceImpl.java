package yi.shi.service.impl;

import com.google.inject.Inject;
//import com.vladsch.flexmark.html.HtmlRenderer;
//import com.vladsch.flexmark.parser.Parser;
//import com.vladsch.flexmark.parser.ParserEmulationProfile;
//import com.vladsch.flexmark.util.ast.Node;
//import com.vladsch.flexmark.util.data.MutableDataHolder;
//import com.vladsch.flexmark.util.data.MutableDataSet;
import yi.shi.db.mapper.MarkdownFilesMapper;
import yi.shi.db.model.MarkdownFiles;
import yi.shi.service.MarkdownFilesService;
import yi.shi.utils.MarkdownUtil;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MarkdownFilesServiceImpl implements MarkdownFilesService {

    @Inject
    private MarkdownFilesMapper markdownFilesMapper;

    private static Lock lock = new ReentrantLock();


    @Override
    public MarkdownFiles addNewMarkdown(MarkdownFiles markdownFiles) {
        lock.lock();
        try {
            if (Objects.isNull(markdownFiles.getId())) {
                long id = markdownFilesMapper.selectMaxId() + 1;
                markdownFiles.setId(id);
                markdownFilesMapper.insert(markdownFiles);
            } else {
                markdownFilesMapper.update(markdownFiles);
            }
            return markdownFiles;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public MarkdownFiles updateMarkdown(MarkdownFiles markdownFiles) {
        markdownFilesMapper.update(markdownFiles);
        return markdownFiles;
    }

    @Override
    public List<MarkdownFiles> selectByUserId(Long userId) {
        return markdownFilesMapper.selectByUserId(userId);
    }

    @Override
    public MarkdownFiles selectById(Long id) {
        return markdownFilesMapper.selectById(id);
    }

    @Override
    public String renderMarkdown(String markdown) {
        return MarkdownUtil.renderMarkdown(markdown);
    }

    @Override
    public MarkdownFiles selectBySharedToken(String sharedToken) {
        return markdownFilesMapper.selectBySharedToken(sharedToken);
    }

    @Override
    public int update(MarkdownFiles markdownFiles) {
        return markdownFilesMapper.update(markdownFiles);
    }

    @Override
    public List<MarkdownFiles> getAllMarkdownFiles() {
        return markdownFilesMapper.getAllMarkdownFiles();
    }

}
