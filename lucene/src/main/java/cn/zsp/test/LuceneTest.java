package cn.zsp.test;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;


import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;


/**
 * @Description: Lucene入门
 * @Author: 张士鹏
 * @blog: http://blog.csdn.net/mixi9760
 * @CreateDate: 2017/3/29
 */
public class LuceneTest {
    private String rootPath = LuceneTest.class.getClassLoader().getResource("").getPath();

    /**
     * 创建索引
     */
    @Test
    public void testCreate() throws IOException {
        System.out.println(rootPath);
        //第一步：创建一个java工程，并导入jar包
        //第二步：创建一个indexwriter对象
        //1）指定索引库的存放位置Directory对象
        Directory directory = FSDirectory.open(new File(rootPath + "/temp"));
        //2）指定一个分析器，对文档内容进行分析
        //Analyzer analyzer = new StandardAnalyzer();//标准分词器 英文
        Analyzer analyzer = new IKAnalyzer();//第三方中文分词器
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_4_10_3, analyzer);
        IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);
        //第三步：创建field对象，将field添加到document对象中

        File file = new File(rootPath + "/resources");
        File[] files = file.listFiles();
        //遍历目录中的文件
        for (File f : files) {
            //第四步：创建document对象
            Document document = new Document();
            //文件名称
            String fileName = f.getName();
            Field fileNameField = new TextField("fileName", fileName, Field.Store.YES);
            //文件内容
            String content = FileUtils.readFileToString(f);
            Field contentField = new TextField("content", content, Field.Store.YES);
            //文件大小
            long size = FileUtils.sizeOf(f);
            Field sizeField = new LongField("size", size, Field.Store.YES);
            //文件路径
            String path = f.getPath();
            System.out.println(path);
            Field pathField = new StoredField("path", path);
            document.add(fileNameField);
            document.add(contentField);
            document.add(sizeField);
            document.add(pathField);
            //第五步：使用indexwriter对象将document对象写入索引库，此过程进行索引创建。
            //并将索引和document对象写入索引
            indexWriter.addDocument(document);
        }
        //第六步；关闭流
        indexWriter.close();
    }

    /**
     * 查询索引
     */
    @Test
    public void testSearch() throws IOException, ParseException {
        //第一步：创建一个Directory对象，也就是索引库存放的位置
        Directory directory = FSDirectory.open(new File(rootPath + "/temp"));
        //第二步：创建一个indexReader对象，需要指定Directory对象
        IndexReader indexReader = DirectoryReader.open(directory);
        //第三步：创建一个indexSearcher对象，需要指定IndexReader对象
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        //第四步：创建一个TermQuery对象，指定查询的域和查询的关键词
        Term term = new Term("fileName", "中文");
        //方式一：精准查询
        Query termQuery = new TermQuery(term);
        //方式二：查询所有
        //Query query=new MatchAllDocsQuery();
        //方式三：数值范围查询 最小值 最大值 区间
        //Query query=NumericRangeQuery.newIntRange("size",100,1000,true,true);
        //方式四：组合条件查询
        //BooleanQuery query=new BooleanQuery();
        //query.add(query1, BooleanClause.Occur.MUST);
        //query.add(query2, BooleanClause.Occur.MUST);
        //方式五：解析查询       参数一：默认域 参数二：分词器
        //QueryParser queryParser=new QueryParser("fileName",new IKAnalyzer());
        //语法：
        //     查询所有 *:*
        //     指定查询 域:查询的内容
        //     范围域：{ 数字 to 数字}
        //     组合查询：域:查询的内容 and/not/or 域:查询的内容
        //Query query= queryParser.parse("*:*");
        //Query query= queryParser.parse("fileName:中文");
        //第五步：执行查询
        TopDocs topDocs = indexSearcher.search(termQuery, 2);
        //第六步：返回查询的结果，遍历查询结果并输出
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;//文档id 数组
        for (ScoreDoc scoreDoc : scoreDocs) {
            int doc = scoreDoc.doc;
            Document document = indexSearcher.doc(doc);
            //文件名称
            System.out.println(document.get("fileName"));
            //文件内容
            System.out.println(document.get("content"));
            //文件路径
            System.out.println(document.get("path"));
            //文件大小
            System.out.println(document.get("size"));
            System.out.println("---------------end-----------------");
        }
        //第七步：关闭IndexReader对象
        indexReader.close();
    }

    /**
     * 更新索引
     */
    @Test
    public void testUpdate() throws IOException {
        Directory directory = FSDirectory.open(new File(rootPath + "/temp"));
        Analyzer analyzer = new IKAnalyzer();
        IndexWriterConfig config = new IndexWriterConfig(Version.LATEST, analyzer);
        IndexWriter indexWriter = new IndexWriter(directory, config);
        Document doc = new Document();
        doc.add(new TextField("fileName", "a", Field.Store.YES));
        //更新= 先删除 后添加
        indexWriter.updateDocument(new Term("fileName", "中文"), doc);
        indexWriter.close();
    }

    /**
     * 删除索引
     */
    @Test
    public void testRemove() throws IOException {
        Directory directory = FSDirectory.open(new File(rootPath + "/temp"));
        Analyzer analyzer = new IKAnalyzer();
        IndexWriterConfig config = new IndexWriterConfig(Version.LATEST, analyzer);
        IndexWriter indexWriter = new IndexWriter(directory, config);
        indexWriter.deleteDocuments(new TermQuery(new Term("fileName", "中文")));//条件删除
        indexWriter.deleteAll();//全删除
        indexWriter.close();
    }
}
