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

public class MarkdownFilesServiceImpl implements MarkdownFilesService {

    @Inject
    private MarkdownFilesMapper markdownFilesMapper;


    @Override
    public MarkdownFiles addNewMarkdown(MarkdownFiles markdownFiles) {
        markdownFilesMapper.insert(markdownFiles);
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
        return MarkdownUtil.markdownToHtmlExtensitons(markdown);
    }

    @Override
    public MarkdownFiles selectBySharedToken(String sharedToken) {
        return markdownFilesMapper.selectBySharedToken(sharedToken);
    }

    @Override
    public int update(MarkdownFiles markdownFiles) {
        return markdownFilesMapper.update(markdownFiles);
    }


}
