package cn.zsp.ssm.controller;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: 张士鹏
 * @blog: http://blog.csdn.net/mixi9760
 * @CreateDate: 2017/4/1
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-*.xml", "classpath:spring/springmvc.xml"})
public class SolrJTest {
    @Autowired
    HttpSolrServer solrServer;

    /**
     * 创建索引/ 更新
     */
    @Test
    public void testCreateIndex() throws IOException, SolrServerException {
        SolrInputDocument document = new SolrInputDocument();
        document.addField("id", "123456789");
        document.addField("item_price", 2000);
        document.addField("item_sell_point", "最好用的Android手机");
        document.addField("item_title", "一加5");
        solrServer.add(document);
        // 提交
        solrServer.commit();
    }

    /**
     * 删除
     */
    @Test
    public void testRemove() throws Exception {
        //根据id删除
        solrServer.deleteById("123456789");
        //根据多个id删除
        // solrServer.deleteById(ids);
        //自动查询条件删除
        // solrServer.deleteByQuery("product_keywords:教程");
        // 提交
        solrServer.commit();
    }

    /**
     * 查询
     */
    @Test
    public void testSearch() throws Exception {
        // 查询对象
        SolrQuery query = new SolrQuery();
        //设置查询条件,名称“q”是固定的且必须 的
        //搜索product_keywords域，product_keywords是复制域包括product_name和product_description
        //query.set("q", "item_title:一加");
        query.setQuery("item_title:一加");
        //过滤条件
        query.set("fq", "item_price:{* TO 3000}");
        //排序
        query.addSort("item_price", SolrQuery.ORDER.desc);
        // 分页参数
        // 每页显示记录数
        int pageSize = 2;
        // 当前页码
        int curPage = 1;

        // 开始记录下标
        int begin = pageSize * (curPage - 1);

        // 起始下标
        query.setStart(begin);
        // 结束下标
        query.setRows(pageSize);

        //高亮显示
        query.setHighlight(true);
        //设置高亮显示的域
        query.addHighlightField("item_title");
        //高亮显示前缀
        query.setHighlightSimplePre("<em style=\"color:red\">");
        //后缀
        query.setHighlightSimplePost("</em>");
        // 请求查询
        QueryResponse response = solrServer.query(query);

        // 查询结果
        SolrDocumentList docs = response.getResults();
        // 查询文档总数
        System.out.println("查询文档总数" + docs.getNumFound());

        for (SolrDocument doc : docs) {
            //商品主键
            String id = (String) doc.getFieldValue("id");
            //商品名称
            String product_name = (String) doc.getFieldValue("item_title");
            //商品价格
            Long product_price = (Long) doc.getFieldValue("item_price");

            System.out.println("=============================");
            System.out.println(id);
            System.out.println(product_name);
            System.out.println(product_price);
            // 高亮信息
            if (response.getHighlighting() != null) {
                if (response.getHighlighting().get(id) != null) {
                    Map<String, List<String>> map = response.getHighlighting()
                            .get(id);// 取出高亮片段

                    if (map.get("item_title") != null) {

                        for (String s : map.get("item_title")) {

                            System.out.println(s);

                        }

                    }
                }
            }


        }
    }
}
